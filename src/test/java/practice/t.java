package practice;

public class t {


		public void print(int pageheight) {
			String sc1 = "window.scrollBy(0," + pageheight + "),"+"\"\"" ;
			System.out.println(sc1+" ");

		}
		
		public static void main(String[] args) {
			
			t t = new t();
			t.print(-50);


	}

}
