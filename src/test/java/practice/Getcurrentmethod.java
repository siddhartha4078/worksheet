package practice;

public class Getcurrentmethod {

	public void testmethod1() {

		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());

		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	public void testmethod2() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void testmethod3() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void testmethod4() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public static void main(String[] args) throws InterruptedException {
		Getcurrentmethod te = new Getcurrentmethod();
		te.testmethod1();
		te.testmethod2();
		te.testmethod3();
		te.testmethod4();

	}

}
