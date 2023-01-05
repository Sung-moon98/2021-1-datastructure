package Kim;

import java.util.EmptyStackException;
public class ArrayStack<E> {
	private E s[];				// 스택을 위한 배열
	private int top;			// 스택의 top 항목의 배열 원소 인덱스
	public ArrayStack() {		// ArrayStack 생성자
		s = (E[])new Object[1];
		top = -1;
	}
	public int size() { return top+1; }						// 스택의 항목 수 리턴
	public boolean isEmpty() { return (top == -1); }		// 스택이 empty이면 true 리턴
	
	
	private void resize(int newSize) {		// 배열 크기 조절
		Object[] t = new Object[newSize];	// 새로운 배열 t 생성
		for(int i = 0; i < size(); i++)		// 배열 s를 t로 복사
			t[i] = s[i];	
		s = (E[]) t;						// s가 t를 참조하도록 변경
	}
	
	public E peek() {			// 스택의 top 항목 리턴
		if(isEmpty()) throw new EmptyStackException();		// 비어있으면 정지
		return s[top];			
	}
	
	public void push(E newItem) {  // push 연산
		if(size() == s.length)
			resize(2*s.length);
		s[++top] = newItem;			// 새 항목을 push
	}
	
	public E pop() {				// pop 연산
		if(isEmpty()) throw new EmptyStackException();
		E item = s[top];			// 원래 top 항목을 item에 저장
		s[top--] = null;			// top을 null로 만들고 top--
		if(size() > 0 && size() == s.length/4)
			resize(s.length/2);
		
		return item;				// item 리턴
	}
	
	public boolean checkParentheses(String s) {			// 괄호 짝 맞추기
			String[] str = s.split("");					// 문자열을 하나씩 가져오기 위해 변환
			
		for(int i = 0; i < str.length; i++) {
			if(str[i].equals("(") || str[i].equals("{") || str[i].equals("[")) {		// 괄호의 시작일 경우 push
				this.push((E)(Object)str[i]);
			}
			else if(str[i].equals(")")) {						// 닫는 괄호일 경우
				if(isEmpty())									// 닫을 괄호가 없을 경우 false
					return false;
				
				else if(this.peek().equals("(")) {				// peek 한 것이 닫을 괄호와 짝이 맞는 경우
					this.pop();
				}
				else											// 짝이 맞지 않는 경우
					return false;
			}
			else if(str[i].equals("}")) {
				if(isEmpty())
					return false;
				
				else if(this.peek().equals("{")) {
					this.pop();
				}
				else
					return false;
			}
			else if(str[i].equals("]")) {
				if(isEmpty())
					return false;
				
				else if(this.peek().equals("[")) {
					this.pop();
				}
				else
					return false;
			}
			
			else									// 괄호가 아닌 다른 문자일 경우 무시
				continue;
				
		}
		if(this.isEmpty())							// 스택이 비어있으면
			return true;
		
		else									   // 스택이 비어있지 않으면
			return false;
	}
	
	public boolean checkPalindrome(String s) {		// 회문 검사
		String[] str = s.split("");		
		
		if(str.length%2 == 0) {						// 길이가 짝수일 때
			for(int i = 0; i < str.length/2; i++) {
				this.push((E)(Object)str[i]);
			}
			
			for(int j = str.length/2; j < str.length; j++) {
				if(isEmpty())
					return false;
				
				else if(this.peek().equals(str[j])) {
					this.pop();
				}
				else
					return false;
			}
			if(isEmpty())
				return true;
			
			else
				return false;
		}
				
		else {									// 길이가 홀수일 때
			for(int i = 0; i < str.length/2; i++) {
				this.push((E)(Object)str[i]);
			}
			
			for(int j = str.length/2+1; j < str.length; j++) {
				if(isEmpty())
					return false;
				
				else if(this.peek().equals(str[j])) {
					this.pop();
				}
				else
					return false;
			}
			if(isEmpty())
				return true;
			
			else
				return false;
		}
		
	}
	
	
	
	
	public void print() {						// 출력 함수
		for(int i = 0; i < s.length; i++) {		
			if(s[i] != null)						// 의미있는 값 출력
				System.out.printf(s[i] + "\t");	
			else								// 의미없는 값
				System.out.printf("null\t");
		}
		System.out.println();
	
	}

}
