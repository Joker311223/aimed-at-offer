package offer;

/**
 * ��ָoffer-��4���滻�ո�
 * 
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */

public class Test04 {

	public String replaceSpace(StringBuffer str) {
//		return str.toString().replaceAll("\\s", "%20");
		
		char[] originStr = str.toString().toCharArray();// ���ַ���תΪ�ַ�����
		int spaceNum = 0;// �ַ����пո�����
		for (int i = 0; i < originStr.length; i++) {
			if (originStr[i] == ' ') {
				spaceNum++;
			}
		}
		int newStrLength = originStr.length + 2 * spaceNum;
		char[] newStr = new char[newStrLength];
		int originIndex = originStr.length - 1;
		int newStrIndex = newStrLength - 1;
		
		for (; originIndex >= 0; originIndex--) {
			if(originStr[originIndex] != ' '){
				newStr[newStrIndex--] = originStr[originIndex];
			}else {
				newStr[newStrIndex--] = '0';
				newStr[newStrIndex--] = '2';
				newStr[newStrIndex--] = '%';
			}
		}
		return new String(newStr);
	}

	public static void main(String[] args) {
		String oldString = "hello  world a b";
		StringBuffer sb = new StringBuffer(oldString);
		String newString = new Test04().replaceSpace(sb);
		
		System.out.println(newString);
		System.out.println(oldString.length());
		System.out.println(newString.length());
	}

}
