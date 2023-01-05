package Kim;

import java.util.Comparator;
public class Book implements Comparable<Book> {
	public static final Comparator<Book> WITH_NAME = new WithName();
	public static final Comparator<Book> WITH_SERIAL = new WithSerial();
	public static final Comparator<Book> WITH_DATE = new WithDate();
	
	String title;
	int serial;
	int yyyy;
	int mm;
	int dd;
	
	public Book(String title, int serial, int yyyy, int mm, int dd){
		this.title = title;
		this.serial = serial;
		this.yyyy = yyyy;
		this.mm = mm;
		this.dd = dd;
		
	}
	
	public String gettitle() { return title; }
	public int getserial() { return serial; }
	public int getyyyy() { return yyyy;}
	public int getmm() { return mm;}
	public int getdd() { return dd;}
	
	public static class WithName implements Comparator<Book> {
		public int compare(Book b1, Book b2) {
			return b1.title.compareTo(b2.title);
		}
	}
	
	public static class WithSerial implements Comparator<Book> {
		public int compare(Book b1, Book b2) {
			return b1.serial-b2.serial;
		}

	}
	
	public static class WithDate implements Comparator<Book>{
	      public int compare(Book b1, Book b2) {
	          if(b1.yyyy > b2.yyyy)
	             return b1.yyyy-b2.yyyy;
	          else if(b1.yyyy == b2.yyyy) {
	                if(b1.mm > b2.mm)
	                   return b1.mm-b2.mm;
	                else if(b1.mm == b2.mm) {
	                      if(b1.dd > b2.dd)
	                         return b1.dd-b2.dd;
	                      else if(b1.dd == b2.dd)
	                         return b1.dd-b2.dd;
	                      else
	                         return b1.dd-b2.dd;
	                }
	             
	                else
	                	return b1.mm-b2.mm;
	          }   
	          else
	             return b1.yyyy-b2.yyyy;
	       }
	    }
	
	public int compareTo(Book b1) {
		return this.title.compareTo(b1.title);
	}
	
	

}
