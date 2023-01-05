package Kim;

import java.util.NoSuchElementException; 
public class ArrListPoly extends ArrList {
	
	int HighestDegree = 0;
	protected int[] arr = new int[1];
	
	
	
	public int[] getArr() {
		return this.arr;
	}
	
	public int getHighestDegree() {
		return this.HighestDegree;
	}
	
	public void setPoly(int k, int[] arr) {
		for(int i = 0; i <= k; i++){			// 처음 인덱스는 상수부터 시작하여
			super.insertLast(arr[i]);			// k까지 값 추가
		}
		HighestDegree = k;						// 최고차항은 k
		this.arr = arr;							// arr 값 초기화
	}
	
	public ArrListPoly sumPoly(ArrListPoly p) {
		int p1, p2;
		this.getArr();							// 현재 ArrListPoly의 배열 불러오기
		ArrListPoly t = new ArrListPoly();		// 덧셈값을 저장할 새로운 ArrListPoly 생성
		
		// 현재 다항식과 불러온 다항식 합 구하기
		// 최고차항이 낮은 다항식을 기준으로 덧셈
		// 두 다항식의 합을 구하여 새로운 ArrListPoly 넣어 저장 후 리턴
		
		if(this.HighestDegree > p.HighestDegree) {
			for(int i = 0; i <= p.HighestDegree; i++) {
				p1 = (int) super.peek(i);
				p2 = (int) p.peek(i);
				this.arr[i] = p1 + p2; 
			}
			
			t.setPoly(this.HighestDegree, this.arr);
			return t;
		}
		else if(this.HighestDegree < p.HighestDegree) {
			for(int i = 0; i <= this.HighestDegree; i++) {
				p1 = (int) super.peek(i);
				p2 = (int) p.peek(i);
				p.arr[i] = p1 + p2;
			}
			t.setPoly(p.HighestDegree, p.arr);
			return t;
		}
		else {
			for(int i = 0; i <= p.HighestDegree; i++) {
				p1 = (int) super.peek(i);
				p2 = (int) p.peek(i);
				p.arr[i] = p1 + p2;
			}
			t.setPoly(p.HighestDegree, p.arr);
			return t;
		}
		
		
			
		
		
		
		
	}
	
	
	
	
	
	
}
