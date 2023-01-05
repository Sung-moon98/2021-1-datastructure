package Kim;

import java.util.Collections;
import java.util.NoSuchElementException;
public class SList <E> {
	protected Node head;			// 연결리스트의 첫 노드
	int size;				// 항목 수
	public SList() {
		head = null;
		size = 0;
	}

	public int search(E target) {			// 탐색 메소드
		Node p = head;
		for(int k = 0; k < size; k++) {
			if(target == p.getItem())		// target을 찾으면
				return k;					// k(순서) return
			p = p.getNext();				// 다음 노드로 이동
		}
		return -1;
	}
	
	public void insertFront(E newItem) {	// 새로운 노드를 첫 번째에 삽입
		head = new Node(newItem, head);		
		size++;
	}
	
	public void insertAfter(E newItem, Node p) {	// 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	public void deleteFront() {					// 리스트의 첫 노드 삭제
		if(size == 0) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node p) {			// p가 가르키는 노드의 다음 노드 삭제
		if(p == null) throw new NoSuchElementException();
		Node t = p.getNext();					// p가 가르키는 다음 노드 t
		if(t != null) {						
			p.setNext(t.getNext());					
			t.setNext(null);
			size--;
		}
		else									// t가 null이라면 해줄 작업 X
			;
	}
	
	public void setAndOrderNodes(int[] arr) {
		if(arr != null) {							// 배열이 있으면 현재 연결리스트를 초기화 시킨다.
			for(int i = 0; i < size(); i++) 
				deleteFront();
			
			
			int temp = 0;
			Node p = null;
			
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = i+1; j < size; j++) {
					if(arr[i] >= arr[j]) {
						p = new Node(arr[j], p.getNext());
						temp = arr[j];
						arr[i] = arr[j];
						arr[j] = temp;
						
						}
					}
				
			
				}
			
			
			
		}
		else
			;
		
		
		}
	
	public void reverse() {
		Node p = head;  		//역순으로 변환시킬 리스트
		Node q = null; 			//역순으로 만들 노드
		Node r = null;  		//역순으로 변환된 리스트
		  
		while(p !=null){ 		//공백 리스트가 아니라면
			r = q;
			q = p;
			p = p.getNext();
			q.setNext(r);
		  }	
		head = q;
	}
	
	
	
	public int size() {						// SList의 size를 return하는 메소드
		return this.size;
	}
	
	
	public void print() {					// 연결리스트에 있는 항목들을 head부터 순서대로 출력
		Node p = head;
		if(head == null) 
			System.out.println("리스트 비어있음");
		for(int i = 0; i < size(); i++) {
			System.out.print(p.getItem()+"\t");
			p = p.getNext();
		}
		System.out.println();
		
		
		
	
	
}
}
