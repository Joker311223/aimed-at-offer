package algorithm;

import java.util.Arrays;

public class Sort {
	static float[] floatArray = { 6.5f, 4.3f, 8.8f, 9.5f, 2.4f, 10.6f, 20.6f, 0.5f, 3.6f, 1.5f };
	static int[] intArray = { 121, 12, 52, 88, 11, 150, 2, 40, 73, 60 };

	// ��������
	public static float[] arrayCopy(float[] array) {
		float[] copyArray = new float[array.length];
		System.arraycopy(array, 0, copyArray, 0, array.length);
		return copyArray;
	}

	// ֱ�Ӳ�������
	public float[] insertSort(float[] array) {
		int j;
		for (int i = 1; i < array.length; i++) {
			j = i - 1;
			float temp = array[i];
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
		return array;
	}

	// ϣ������
	public float[] shellSort(float[] array) {
		int arrLength = array.length;
		for (int step = arrLength >> 1; step > 0; step >>= 1) {
			for (int i = step; i < arrLength; i += step) {// �����￪ʼ����������Ƚ�
				int j = i - step;
				float temp = array[i];
				while (j >= 0 && array[j] > temp) {
					array[j + step] = array[j];
					j -= step;
				}
				array[j + step] = temp;
			}
		}
		return array;
	}

	// ð������
	public float[] bubbleSort(float[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					float temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	// ѡ������
	public float[] selectSort(float[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			float temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}

	// �鲢����
	public float[] mergeSort(float[] array) {
		float[] tempArray = arrayCopy(array);
		mergeSortCore(array, tempArray, 0, array.length - 1);
		return tempArray;
	}

	// �鲢����
	public void mergeSortCore(float[] array, float[] tempArray, int start, int end) {
		if (start == end) {
			tempArray[start] = array[start];
			return;
		} else if (start < end) {
			int middle = (start + end) >> 1;
			mergeSortCore(tempArray, array, start, middle);
			mergeSortCore(tempArray, array, middle + 1, end);

			int i = start;
			int j = middle + 1;
			int k = start;
			while (i <= middle && j <= end) {
				if (array[i] <= array[j]) {
					tempArray[k++] = array[i++];
				} else {
					tempArray[k++] = array[j++];
				}
			}
			while (i <= middle) {
				tempArray[k++] = array[i++];
			}
			while (j <= end) {
				tempArray[k++] = array[j++];
			}
		}
	}

	// ��������
	public float[] quickSort(float[] array) {
		quickSortCore(array, 0, array.length - 1);
		return array;
	}

	// ����
	public void quickSortCore(float[] array, int left, int right) {
		if (left > right) {
			return;
		} else {
			float base = array[left];
			int i = left, j = right;
			while (i < j) {
				while (array[j] >= base && j > i) {// ���ұ߿�ʼ
					j--;
				}
				if (j > i) {
					array[i++] = array[j];
				}
				while (array[i] <= base && j > i) {
					i++;
				}
				if (j > i) {
					array[j--] = array[i];
				}
			}
			array[i] = base;
			quickSortCore(array, left, i - 1);
			quickSortCore(array, i + 1, right);
		}
	}

	// ������
	public float[] heapSort(float[] array) {
		// ��������
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			adjustHeap(array, i, array.length);
		}
		// �����Ѷ�Ԫ�غ�ĩβԪ�أ����ڽ���֮������ѽṹ
		for (int j = array.length - 1; j > 0; j--) {
			float temp = array[j];
			array[j] = array[0];
			array[0] = temp;
			adjustHeap(array, 0, j);
		}
		return array;
	}

	// �����ѽṹ
	public void adjustHeap(float[] array, int i, int length) {
		float temp = array[i];
		for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && array[k] < array[k + 1]) {
				k++;
			}
			if (array[k] > temp) {
				array[i] = array[k];
				i = k;
			} else {
				break;
			}
			array[i] = temp;
		}
	}

	// ��������LSD��,����dΪ�������������λ��,123��3λ,1234��4λ
	public int[] radixSort(int[] array, int d) {
		int[] tempArray = new int[array.length];
		System.arraycopy(array, 0, tempArray, 0, array.length);

		int m = 1;// ��ʾ��ǰ�����Ĵ����������ڼ�λ
		int n = 1;
		int[][] bucket = new int[10][array.length];// 10��Ͱ
		int[] numInBucket = new int[10]; // ÿ��Ͱ��Ԫ�ظ���
		while (m <= d) {
			int k = 0;
			for (int i = 0; i < tempArray.length; i++) {
				int value = (tempArray[i] / n) % 10;
				bucket[value][numInBucket[value]] = tempArray[i];
				numInBucket[value]++;
			}
			for (int i = 0; i < 10; i++) {
				if (numInBucket[i] != 0) {
					for (int j = 0; j < numInBucket[i]; j++) {
						tempArray[k] = bucket[i][j];
						k++;
					}
				}
				numInBucket[i] = 0;
			}
			m++;
			n *= 10;
		}
		return tempArray;
	}

	public static void main(String[] args) {
		Sort sort = new Sort();
		System.out.println("��������:" + Arrays.toString(sort.insertSort(arrayCopy(floatArray))));
		System.out.println("ϣ������:" + Arrays.toString(sort.shellSort(arrayCopy(floatArray))));
		System.out.println("ð������:" + Arrays.toString(sort.bubbleSort(arrayCopy(floatArray))));
		System.out.println("ѡ������:" + Arrays.toString(sort.selectSort(arrayCopy(floatArray))));
		System.out.println("�鲢����:" + Arrays.toString(sort.mergeSort(arrayCopy(floatArray))));
		System.out.println("��������:" + Arrays.toString(sort.quickSort(arrayCopy(floatArray))));
		System.out.println("������:" + Arrays.toString(sort.heapSort(arrayCopy(floatArray))));

		System.out.println("��������:" + Arrays.toString(sort.radixSort(intArray, 3)));

	}
}
