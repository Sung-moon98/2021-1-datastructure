package Kim;

import java.util.NoSuchElementException;
public class DList <E>{
	protected DNode head, tail;
	protected int size;
	public DList() {
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);		// tail의 이전 노드를 head로 만든다.
		head.setNext(tail);						// head의 다음 노드를 tail로 만든다.
		size = 0;
	}
	public DNode getTail() {
		return this.tail;
	}
	
	public void insertBefore(DNode p, E newItem) {		// p가 가르키는 노드 앞에 삽입
		DNode t = p.getPrevious();
		DNode newNode = new DNode(newItem, t, p);		// 새로운 노드 앞 노드는 t, 뒤 노드는 p
		p.setPrevious(newNode);							// p가 가르키는 전 노드 변경
		t.setNext(newNode);								// t가 가르키는 다음 노드 변경
		size++;
	}
	
	public void insertAfter(DNode p, E newItem) {		// p가 가르키는 노드 뒤에 삽입
		DNode t = p.getNext();
		DNode newNode = new DNode(newItem, p, t);		// 새로운 노드 앞 노드는 p, 뒤 노드는 t
		t.setPrevious(newNode);							// t가 가르키는 전 노드 변경
		p.setNext(newNode);								// p가 가르키는 다음 노드 변경
		size++;
	}
	
	public void delete(DNode x) {						// x가 가르키는 노드 삭제
		if(x == null) throw new NoSuchElementException();	// 노드가 비어있다면
		if(size <= 0) throw new NoSuchElementException();	// 연결리스트의 size가 0보다 작으면
		DNode f = x.getPrevious();						
		DNode r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}
	
	
	public int add(DList dl2) {						// 두 개의 리스트 더함
		int place1 = 1;								// dl2의 자리수
		int place2 = 1;								// dl1의 자리수
		int d1= 0, d2= 0;
		DNode p = dl2.tail.getPrevious();			// dl2의 tail	
		DNode q = this.getTail().getPrevious();		// dl1의 tail
		
		for(int i = 0; i < dl2.size(); i++) {		// dl2 계산
			d1 += (int) p.getItem()*place1;
			place1 *= 10;
			p = p.getPrevious();
		}
		
		
		for(int i = 0; i < this.size(); i++) {		// dl1 계산
			d2 += (int) q.getItem()*place2;
			place2 *= 10;
			q = q.getPrevious();
	}	
		return d1 + d2;								// 합 리턴
	}
	
	
	
	public int size() {						// DList의 size를 return하는 메소드
		return this.size;
	}
	
	public void print() {					// head가 가르키는 다음 항목부터 tail이 가르키는 이전 항목까지 출력
		DNode p = head.getNext();
		
		if(size <= 0) 
			System.out.println("리스트 비어있음");
		
		for(int i = 0; i < size(); i++) {
			System.out.printf(p.getItem()+"\t");
			p = p.getNext();
			}
		System.out.println();
		
		
}
}
