package Kim;

public class DoubleHashing<K, V> {
	private int N = 0, M = 13;					// 항목수, 테이블 크기
	private K[] a = (K[]) new Object[M];		// 해시테이블
	private V[] dt = (V[]) new Object[M];		// key 관련 데이터 저장
	private int hash(K key) {	// 해시코드
		return (key.hashCode() & 0x7fffffff) % M;	// 나눗셈 함수
	}
	
	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7-(int)key % 7);
		do {
			if(a[i] == null) {			// 삽입 위치 발견
				a[i] = key;				// key를 해시테이블에 저장
				dt[i] = data;  N++;		// key관련 데이터를 동일한 인덱스에 저장
				return;
			}
			if(a[i].equals(key)) {	// 이미 key 존재
				dt[i] = data;		// 데이터만 갱신
				return;
			}
			i = (initialpos + j*d) % M;		// i를 다음 위치로 갱신
			j++;
		}while(N <M);
	}
	
	public V get(K key) {
		int initialpos = hash(key);			// 초기 위치
		int i = initialpos;
		int j = 1;
		int d = (7-(int)key % 7);
		while(a[i] != null) {
			if(a[i].equals(key))		// 탐색 성공
				return dt[i];
			i = (initialpos + j*d) % M;		// 다음 위치로 i 갱신
			j++;
		}
		return null;		// 탐색 실패
	}
	
	public void print() {
		System.out.println("해시 테이블: ");
		
		for(int i = 0; i < M; i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for(int i = 0; i < M; i++) {
			System.out.print(this.a[i]+"\t");
		}
	}

}
