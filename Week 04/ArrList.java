package Kim;

import java.util.NoSuchElementException; 	// underflow가 발생하면 프로그램 정지
public class ArrList<E> {
	protected E a[];					// 리스트의 항목들을 저장할 배열
	protected int size;					// 리스트의 항목 수
	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}
	
	public E peek(int k) {			// k번째 항목을 리턴
		if(size == 0 || k >= size)
			throw new NoSuchElementException();
		return a[k];
	}
	
	public boolean isEmpty() {		// 배열이 비어있으면 true 아니면 flase
		if(size == 0)
			return true;
		return false;
	}
	
	public void insertLast(E newItem) {		// 가장 뒤에 새 항목 삽입
		if(size == a.length)				// 배열에 빈 공간이 없으면 확장
			resize(2*a.length);
		a[size++] = newItem;				// 새 항목 삽입
	}
	
	public void insert(E newItem, int k) {	// 새 항복을 k번째 항목에 삽입
		if(size == a.length)				// 배열에 빈 공간이 없으면 확장
			resize(2*a.length);
		for(int i = size-1; i >= k; i--)	// 한 칸씩 뒤로 이동
			a[i+1] = a[i];
		a[k] = newItem;						// k번째에 새 항목 삽입
		size++;								// size 1 늘리기
	}
	
	public void insert(E newItem) {			// insert 오버로딩
		insertLast(newItem);
	}
	
	private void resize(int newSize) {		// 배열 크기 조절
		Object[] t = new Object[newSize];	// 새로운 배열 t 생성
		for(int i = 0; i < size; i++)		// 배열 a를 t로 복사
			t[i] = a[i];	
		a = (E[]) t;						// a가 t를 참조하도록 변경
					
	}
	
	public E delete(int k) {				// k 번째 항목 삭제
		if(isEmpty())						// underflow 발생 시 프로그램 종료 
			throw new NoSuchElementException();
		E item = a[k];						// 삭제할 항목을 임시변수에 저장
		for(int i = k; i < size; i++)		// 한 칸씩 앞으로 이동
			a[i] = a[i+1];
		size--;								// size 1 줄이기
		if(size > 0 && size <= a.length/4)	// 사용하고 있는 공간이 배열의 1/4 이하이면
			resize(a.length/2);				// 배열의 크기를 절반으로 줄임
		return item;						// 삭제된 항목의 값 리턴
	}
	
	public void print() {						// 출력 함수
		for(int i = 0; i < a.length; i++) {		
			if(i < size)						// 의미있는 값 출력
				System.out.printf(a[i] + "\t");	
			else								// 의미없는 값
				System.out.printf("null\t");
		}
		System.out.println();
	}
	
	
	
}
