package Kim;

import java.util.EmptyStackException;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class ListStack<E> {
	private Node<E> top;		// top 항목을 가진 Node
	private int size;			// 스택의 항목 수
	public ListStack() {		// ListStack 생성자
		top = null;
		size = 0;
	}
	public int size() { return size; }				// 스택의 항목 수를 리턴
	public boolean isEmpty() { return size == 0; }	// 스택이 empty면 true 리턴
	
	
	public E peek() {		// top 항목을 리턴
		if(isEmpty()) throw new EmptyStackException();
		return top.getItem();
	}
	
	public void push(E newItem) {				// push 메소드
		Node newNode = new Node(newItem, top);	// 리스트 앞부분에 새로운 노드 삽입
		top = newNode;							// 새로 삽입한 노드를 top으로	
		size++;
	}
	
	public E pop() {							// pop 메소드
		if(isEmpty()) throw new EmptyStackException();
		E topItem = top.getItem();				// 원래 top 항목을 topItem에 저장
		top = top.getNext();					// top을 원래 top의 next로 설정	
		size--;
		return topItem;							// 저장한 topItem 리턴
	}
	
	public static boolean isOperator(String s) {		// 연산자와 피연산자를 구분하는 함수
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;							// 연산자면 true
		else
			return false;
	}
	
	public static int prec(String op) {			// 연산자의 우선순위를 결정함
	    switch(op) {
	        case "(" :
	        case ")" :
	            return 0;
	        case "+" :
	        case "-" :
	            return 1;
	        case "*" :
	        case "/" :
	            return 2;
	    }
	    return 999;
	}
	
	public String getPostEq(String s) {				// 중위표기식을 후위표기식으로 변환
		String [] str = s.split("");				// 문자열을 배열로 변환
	
		String temp = "";							// 후위표기식으로 변환 된 문자열
		
		for(int i = 0; i < str.length; i++) {		
			if(str[i].equals("("))					// '('라면 push
				this.push((E)(Object)str[i]);		
			
			else if(isOperator(str[i])) {				// 연산자라면
				if(isEmpty())						// 스택이 비어있으면 연산자 push
					push((E)(Object)str[i]);
				
				else if(isOperator((String)top.getItem())) {		// top이 연산자라면
					while(prec(str[i]) < prec((String)peek())) {	// 현재 연산자가 top의 연산자보다 우선순위가 낮다면
						temp = temp.concat((String)pop());			// pop하여 저장
						if(isEmpty()) {								// 스택이 비어있으면
							this.push((E)(Object)str[i]);
							break;
						}
					}	
					this.push((E)(Object)str[i]);							
				}
				else									// 현재 연산자가 top의 연산자보다 우선순위가 크다면
					this.push((E)(Object)str[i]);
	
			}
			else if(str[i].equals(")")) {				//닫는 괄호일 경우
				while(true) {							// top이 ( 일 때까지 pop
				   if(isEmpty())
					   break;
					else if(this.peek().equals("(")) {
						break;
					}
					temp = temp.concat((String)pop());
					
				}
				this.pop();							// ( 는 pop만 하여 버림
				
			}
			else {									// 문자일 경우 출력
				temp = temp.concat(str[i]);
			}	
		}// for문 종료
		if(!isEmpty()) {						// 스택이 비어있을 때까지 pop하여 출력
			while(size>0) {
				temp = temp.concat((String)pop());
			}
		}
		return temp;
		
	}
	
	public double calc(String[] s) {		// 후위표기법 수식 계산
		
		double result, num1, num2;							// double 형 결과값을 저장할 변수와 pop하여 저장할 임시 변수
	
	    for(int i = 0; i < s.length; i++) {
	    	switch(s[i]) {
	    	// 연산자 + 일 경우
	    	case "+":									
	    		num2 = (double)pop();
	    		num1 = (double)pop();
	    		this.push((E)(Object)(num1+num2));
	    		break;
	    	// 연산자 - 일 경우
	    	case "-":									
	    		num2 = (double)pop();
	    		num1 = (double)pop();
	    		this.push((E)(Object)(num1-num2));
	    		break;
	    	// 연산자 * 일 경우
	    	case "*":
	    		num2 = (double)pop();
	    		num1 = (double)pop();
	    		this.push((E)(Object)(num1*num2));
	    		break;
	    	// 연산자 / 일 경우	
	    	case "/":
	    		num2 = (double)pop();
	    		num1 = (double)pop();
	    		this.push((E)(Object)(num1/num2));
	    		break;

	    	default:
	    		this.push((E)(Object)Double.parseDouble(s[i]));
	    		break;
	    	
	    	}
	    }
	    // 마지막 스택에 저장되어있는 값을 pop하여 리턴
	    result = (double) this.pop();

		
	    return result;
	}
	
	
	public void print() {					// 연결리스트에 있는 항목들을 head부터 순서대로 출력
		Node p = top;
		if(top == null) 
			System.out.println("리스트 비어있음");
		for(int i = 0; i < size(); i++) {
			System.out.print(p.getItem()+"\t");
			p = p.getNext();
		}
		System.out.println();
	}
}
