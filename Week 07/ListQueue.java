package Kim;

import java.util.NoSuchElementException;
public class ListQueue <E> {
	private Node<E> front, rear;
	private int size;
	public ListQueue() {			// 생성자
		front = rear = null;
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return (size() == 0); }
	public Node<E> getFront() { return front; }
	
	public void add(E newItem) {			// 큐 삽입 연산
		Node newNode = new Node(newItem, null);
		if(isEmpty()) front = newNode;		// 큐가 비어있으면 front는 newNode
		else rear.setNext(newNode);			// 아니면 rear의 next를 newNode로 설정
		rear = newNode;						
		size++;
	}
	
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		E frontItem = front.getItem();
		front = front.getNext();
		size--;
		if(isEmpty()) rear = null;
		return frontItem;
	}
	
	public double avg() {			// 큐에 저장된 항목의 평균
		int sum = 0;
		int temp;					// remove한 항목 임시 저장 변수
		double avg;					// 리턴할 평균
		int c_size = this.size();	// 현재 size를 c_size에 저장
		for(int i = 0; i < c_size; i++) {
			temp = (Integer)remove();		// 임시 변수에 remove한 항목 저장
			sum += temp;					// 평균을 구하기 위해 remove한 항목들의 합을 저장
			this.add((E)(Object)temp);		// remove한 항목을 다시 큐에 add한다
		}
		avg = sum/c_size;				// 합을 size로 나눔
		return avg;
	}
	
	public void reverse() {
		ListStack<E> s = new ListStack<E>();		// stack 생성
		for(int i = 0; size() != 0; i++) {			// 큐에 있는 항목들을 스택에 push
			s.push(remove());
		}
		
		for(int j = 0; s.size() != 0; j++) {		// 스택에 있는 항목들을 pop하여 큐에 add
			add(s.pop());
		}
	}
	
	
	public void print() {					// 연결리스트에 있는 항목들을 front부터 순서대로 출력
		Node p = front;
		if(front == null) 
			System.out.println("리스트 비어있음");
		for(int i = 0; i < size(); i++) {
			System.out.print(p.getItem()+"\t");
			p = p.getNext();
		}
		System.out.println();
	}
	
	
	
	

}
