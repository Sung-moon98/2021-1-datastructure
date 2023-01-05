package Kim;

import java.util.Arrays;
public class Bookmain {
	public static void main(String[] args) {
		Book[] b = { 
			new Book("한림대학교", 1, 2010, 3, 15), 
			new Book("IT기술", 2, 2018, 8, 11),
			new Book("자바 프로그래밍", 3, 2011, 1, 1), 
			new Book("C프로그래밍", 4, 1999, 12, 18),
			new Book("인공지능", 5, 2019, 2, 22), 
			new Book("기계학습", 6, 2015, 9, 30),
			new Book("인간의 미래", 7, 2017, 5, 21)
		};
		Arrays.sort(b);
		print(b,"도서명");
		
		Arrays.sort(b,Book.WITH_NAME);
		print(b,"도서명");
		
		Arrays.sort(b,Book.WITH_SERIAL);
		print(b,"고유번호");
		
		Arrays.sort(b,Book.WITH_DATE);
		print(b,"출간일자");
		
		
		
		
		
	}
	public static void print(Book[] b, String key) {
		int i = 0;
		System.out.println();
		System.out.println("      "+key+"(으)로 정렬");
		System.out.println("----------------------");
		for(Book temp: b) {
			System.out.printf(temp.gettitle() + "  "+ temp.getserial()+"  "+temp.getyyyy()+"  "+temp.getmm()+"  "+ temp.getdd()+"\n");
		}
	}

}
