package Kim;

import java.util.NoSuchElementException;
public class ArrayQueue <E>{
	private E[] q;			// 큐를 위한 배열
	private int front, rear, size;
	public ArrayQueue() {			// 생성자
		q = (E[]) new Object[2];	// front는 빈 공간을 가르켜야하므로 크기가 2인 배열 생성
		front = rear = size = 0;
	}
	public int size() { return size; }						// 큐의 항목 수 리턴
	public boolean isEmpty() { return (size == 0); }		// 큐가 비어있으면 true
	
	public void add(E newItem) {				// 큐 삽입 연산
		if((rear+1)%q.length == front){			// 비어있는 원소가 1개뿐인 경우, 즉 큐가 full인 경우
			resize(2*q.length);
		}
		rear = (rear+1)%q.length;
		q[rear] = newItem;
		size++;
	}
	
	public E remove() {		  		// 큐 삭제 연산
		if(isEmpty()) throw new NoSuchElementException();
		front = (front+1)%q.length;			// front는 비어있는 값을 가르키므로 다음 값으로 갱신해야한다.
		E item = q[front];					// 임시변수에 저장
		q[front] = null;					// 삭제
		size--;
		if(size > 0 && size == q.length) {
			resize(q.length/2);
		}
		return item;
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i = 1, j = front+1; i < size+1; i++, j++) {
			t[i] = q[j%q.length];			// 0번째 인덱스는 비어있는 값으로 front이다
		}
		front = 0;
		rear = size;
		q = (E[]) t;						// 배열 t를 q로
	}
	
	public void print() {						// 출력 함수
		for(int i = 0; i < q.length; i++) {		
			if(q[i] != null)						// 의미있는 값 출력
				System.out.printf(q[i] + "\t");	
			else								// 의미없는 값
				System.out.printf("null\t");
		}
		System.out.println();
	}

}
