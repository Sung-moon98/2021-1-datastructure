package Kim;

public class Chaining<K, V> {
	private int M = 5;		// 테이블 크기
	private int N = 0; 		// 항목 수
	private Node[] a = new Node[M];			// 해시 테이블
	public static class Node{		// Node 클래스
		public Object key;
		public Object data;
		public Node next;
		public Node(Object newkey, Object newdata, Node ref) {		// 생성자
			key = newkey;
			data = newdata;
			next = ref;
		}
		public Object getKey() { return key; }
		public Object getData() { return data; }
		
	}
	
	private int hash(K key) {		//해시코드
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public V get(K key) {		// 탐색연산
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) 	// 연결리스트 탐색
			if(key.equals(x.key))	return (V) x.data;		// 탐색 성공
		return null;		// 탐색 실패
	}
	
	public void put(K key, V data) {		// 삽입 연산
		check_and_rehash();
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {		// 이미 key 존재
				x.data = data;			// 데이터만 갱신
				return;
			}
		}
		a[i] = new Node(key, data, a[i]);		// 연결리스트의 첫 노드로 삽입
		N++;
	}
	
	public void delete(K key) {		// 삭제 연산
		check_and_rehash();
		int i = hash(key);
		if(get(key) == null) {		// key를 가지고 있는 인덱스 없음
			System.out.println("비어있음");
		}
		else {
			Node t = a[i];			// 삭제하려고 하는 노드의 이전 노드를 가르키는 노드 t
			if(key.equals(t.key)) {		// 첫 번째 원소가 삭제하려는 원소인 경우
				a[i] = a[i].next;
				N--;
			}
			else {
				for(Node x = t.next; x != null; x = x.next) {		// 중간에 삭제할 원소가 있는 경우
					if(key.equals(x.key)) {
						t.next = x.next;
						N--;
					}
					t = x;			// t를 x로 갱신
				}
			}
		}
	}
	
	private void check_and_rehash() {
		double m = M;
		double n = N;
		double l = n/m;		// 적재율

		if(l > 0.75) {		// 테이블 확대
			M = M*2;
			Node[] t = new Node[M];			// 확대한 테이블
			for(int i = 0; i < a.length; i++) {
				if(a[i] != null && a[i].next != null) {		// 테이블의 인덱스가 비어있지 않고 다음 항목이 있다면
					Node k = a[i];						
					int p = hash((K) a[i].getKey());
					t[p] = a[i];							// a[i]에 연결된 연결리스트를 t의 j번째 인덱스로 옮김
					for(Node x = k.next; x != null; x = x.next) {
						int j = hash((K) x.getKey());		// j는 x의 해시값
						if(j == p) {
							continue;				// 만약 x의 해시값이 현재 위치하고 있는 인덱스라면 아무 작업도 하지 않는다
						}
						t[j] = x;						// 새로운 테이블 j번째 인덱스에 x를 넣는다
						k.next = x.next;				// k의 다음항목을 x의 다음 항목과 연결해준다
				
					}
				}
				else if(a[i] != null) {			// next가 존재하지 않고 항목이 있다면
					int j = hash((K) a[i].getKey());
					t[j] = a[i];
				}
			}
			a = t;
		}
			
		else if(l < 0.25) {		// 테이블 축소
			if(M >= 10) {		// 테이블의 크기가 축소 하였을 때의 크기가 5 미만이 된다면 축소하지 않는다.
				M = M/2;
				Node[] t = new Node[M];			// 축소된 테이블
				for(int i = 0; i < a.length; i++) {
					if(a[i] != null && a[i].next != null) {		// 테이블의 인덱스가 비어있지 않고 다음 항목이 있다면
						Node k = a[i];						
						int p = hash((K) a[i].getKey());
						t[p] = a[i];							// a[i]에 연결된 연결리스트를 t의 j번째 인덱스로 옮김
						for(Node x = k.next; x != null; x = x.next) {
							int j = hash((K) x.getKey());		// j는 x의 해시값
							if(j == p) {
								continue;				// 만약 x의 해시값이 현재 위치하고 있는 인덱스라면 아무 작업도 하지 않는다
							}
							t[j] = x;						// 새로운 테이블 j번째 인덱스에 x를 넣는다
							k.next = x.next;				// k의 다음항목을 x의 다음 항목과 연결해준다
					
						}
					}
					
					else if(a[i] != null) {
						int j = hash((K) a[i].getKey());
						t[j] = a[i];
					}
				}
				a = t;
			}
			else {		
				;
			}
			
		}
		else {		// 확대 및 축소를 할 필요 없는 경우
			;
		}
		
	}

	public void print() {
		System.out.println("해시 테이블:");
		for(int i = 0; i < a.length; i++) {
			System.out.print(i);
			for(Node x = a[i]; x != null; x = x.next) {
				System.out.print("--->["+ x.key+", "+x.data+"]");
			}
			System.out.println();
		}
	}
	
	


}
