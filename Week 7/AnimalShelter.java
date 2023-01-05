package Kim;

import java.util.NoSuchElementException;
public class AnimalShelter  {
	private ListQueue<Animal> ani;		// 큐 선언
	private Animal front;				// 가장 최근에 들어온 동물
	
	public AnimalShelter() {
		ani = new ListQueue<Animal>();		// 큐 생성
		front = null;
	}
	
	public void enter(Animal a) {			// 동물을 추가한다
		if(a.getType().equals("Cat") || a.getType().equals("Dog")) {
			ani.add(a);
			front = a;
		}
		
		else throw new NoSuchElementException();		// 다른 type의 동물을 입력했을 시 예외 발생
	}
	
	public Animal adoptAny() {					// remove()로 가장 오래 전에 들어온 동물을 꺼낸다
		Animal temp = ani.remove();
		return temp;
	}
	
	public Animal adoptDog() {					// 가장 오래 전에 들어온 Dog를 내보낸다
		int c_size = ani.size();
		int cnt = 0;							// remove()를 호출한 횟수
		Animal a, b = null;
		a = ani.remove();
		cnt++;
		if(a.getType().equals("Dog"))			// 가장 오래 전에 들어온 동물이 Dog일 경우
			return a;	
		
		else{									// 가장 오래 전에 들어온 동물이 Cat일 경우
			ani.add(a);
			for(int i = 0; i < c_size; i++) {
				a = ani.remove();
				cnt++;
				if(a.getType().equals("Dog")) {		// Dog 중 가장 오래 전에 들어온 Dog를 찾는다
					b = a;							// 찾은 Dog를 b에 임시 저장
					break;							// Dog 찾기 중지
				}
			}
			// 원래 size에서 remove한 횟수를 뺀 만큼 반복 작업을 하면 원래 큐의 모습으로 돌아갈 수 있다
			for(int i = 0; i < (c_size - cnt); i++) {		// remove하여 어질러진 큐를 다시 재정돈한다 
				a = ani.remove();
				ani.add(a);
			}
			return b;						// 찾은 Dog를 리턴한다. Dog가 없다면 null 리턴
		}

	}
	
	public Animal adoptCat() {					// 가장 오래 전에 들어온 Cat을 내보낸다
		int c_size = ani.size();
		int cnt = 0;							// remove()를 호출한 횟수
		Animal a, b = null;
		a = ani.remove();
		cnt++;
		if(a.getType().equals("Cat"))			// 가장 오래 전에 들어온 동물이 Cat일 경우
			return a;	
		
		else{									// 가장 오래 전에 들어온 동물이 Dog일 경우
			ani.add(a);
			for(int i = 0; i < c_size; i++) {
				a = ani.remove();
				cnt++;
				if(a.getType().equals("Cat")) {		// Dog 중 가장 오래 전에 들어온 Cat을 찾는다
					b = a;							// 찾은 Cat을 b에 임시 저장
					break;							// Cat 찾기 중지
				}
			}
			// 원래 size에서 remove한 횟수를 뺀 만큼 반복 작업을 하면 원래 큐의 모습으로 돌아갈 수 있다
			for(int i = 0; i < (c_size - cnt); i++) {		// remove하여 어질러진 큐를 다시 재정돈한다 
				a = ani.remove();
				ani.add(a);
			}
			return b;						// 찾은 Cat을 리턴한다. Dog가 없다면 null 리턴
		}

	}
	
	public void print() {				// 출력함수
		Animal p = front;
		int c_size = ani.size();		// 원래 큐의 사이즈를 저장
		ani.reverse();					// 가장 최근에 들어온 동물을 왼쪽에 출력하기 위해 큐를 reverse 한다
		if(p == null)					// 큐가 비어있다면
			System.out.print("동물이 없습니다.");
		
		else {
			for(int i = 0; i < c_size; i++) {	// 처음 size만큼 remove와 add 작업을 하며 출력한다
				Animal temp = ani.remove();
				System.out.print(temp.getName()+"("+temp.getType()+")\t");
				ani.add(temp);
			}
			ani.reverse();		// reverse한 큐를 다시 원래상태로 돌려놓는다
		}
		
		System.out.println();
		
	}
	
	
}
