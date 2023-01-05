package Kim;

public class LinearProbing<K, V> {		// 선형조사
	private int M = 13;			// 테이블 크기
	private K[] a = (K[]) new Object[M];		// 해시테이블
	private V[] d = (V[]) new Object[M];		// key 관련 데이터 저장
	private int hash(K key) {	// 해시코드
		return (key.hashCode() & 0x7fffffff) % M;	// 나눗셈 함수
	}
	
	public void put(K key, V data) {	// 삽입 연산
		int initialpos = hash(key);		// 초기 위치
		int i = initialpos, j = 1;
		do {
			if(a[i] == null) {		// 삽입 위치 발견
				a[i] = key;			// key를 해시테이블에 저장
				d[i] = data;		// key관련 데이터를 동일한 인덱스에 저장
				return;
			}
			if(a[i].equals(key)) {	// 이미 key 존재
				d[i] = data;		// 데이터만 갱신
				return;
			}
			i = (initialpos + j++) % M;		// i를 다음 위치로 갱신
		}while(i != initialpos);	// 현재 i가 초기위치와 같게 되면 루프 종료
	}
	
	public V get(K key) {		// 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key))	// 탐색 성공
				return d[i];
			i = (initialpos + j++) % M;		// 충돌로 인해 다른 위치에 있는 값 찾기위해 i를 다음 위치로 갱신
		}while(a[i] != null && i != initialpos);	// a[i]가 비어있거나 처음위치로 돌아왔다면 종료
		
		return null;
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
