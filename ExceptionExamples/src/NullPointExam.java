
public class NullPointExam {

	public static void main(String[] args) {
		try{
			String str = null;
		System.out.println("���ڿ�: " + str.length());
		}
	catch(NullPointerException npe) {
		System.out.println("npe.tiString():"+npe.toString());
		}finally {
			System.out.println("������ ����");
	}

	}

}
