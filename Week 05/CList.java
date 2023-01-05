package Kim;

import java.util.NoSuchElementException;

public class CList <E>{
	private Node last;		// 리스트의 마지막 노드
	private int size;		// 리스트의 항목(노드) 수
	public CList() {
		last = null;
		size = 0;
	}
	
	public boolean isEmpty() {		// 리스트가 비어있으면 true 아니면 flase
		if(size == 0)
			return true;
		return false;
	}
	
	public void insert(E newItem) {					// last가 가르키는 노드의 다음에 새 노드 삽읍
		Node newNode = new Node(newItem, null);		// 새 노드 생성
		if(last == null) {							// 리스트가 empty 일 때
			newNode.setNext(newNode);
			last = newNode;							// 새 노드는 last
		}
		else {										
			newNode.setNext(last.getNext());		// newNode의 다음 노드가 last가 가르키는 노드의 다음노드가 되도록
			last.setNext(newNode);					// last가 가르키는 다음 노드가 newNode가 되도록
		}
		size++;
	}
	
	public Node delete() {							// last가 가르키는 노드의 다음 노드를 제거
		if(isEmpty()) throw new NoSuchElementException();
		Node x = last.getNext();					// x가 리스트의 첫 노드를 가르킴
		if(x == last)								// 리스트의 1개의 노드만 있는 경우
			last = null;
		else {
			last.setNext(x.getNext());				// last가 가르키는 노드의 다음 노드가 x의 다음 노드가 되도록
			x.setNext(null);						// x의 next를 null로 만든다
		}
		size--;
		return x;									// 제거한 노드 x를 return
	}
	
	public void rotateLeft(int n) {					// 리스트를 왼쪽으로 회전
		if(size < n)
			rotateLeft(Math.abs(size-n));
		else {
			for(int i = 0; i < size()-n; i++) {
				last = last.getNext();
		}
		}
	}
	
	
	public void rotateRight(int n) {				// 리스트를 오른쪽으로 회전
		for(int i = 0; i < n; i++) {
			last = last.getNext();
		}
	}
	
	
	
	public int size() {			// 현재 리스트의 size를 return
		return this.size;
	}
	
	public void print() {					// last의 다음 항목부터 last까지 출력
		Node p = last.getNext();
		
		if(size <= 0) 						// list가 비어있다면
			System.out.println("리스트 비어있음");
		
		for(int i = 0; i < size(); i++) {
			System.out.printf(p.getItem()+"\t");
			p = p.getNext();
		}
		System.out.println();

}
}
