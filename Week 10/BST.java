package Kim;

import java.util.*;
import java.util.Collections;
public class BST <Key extends Comparable<Key>, Value> {
	public Node root;
	public Node getRoot() {return root; }
	public void setRoot(Node newRoot) { root = newRoot; }
	public BST(Key newId, Value newName) {		// 생성자
		root = new Node(newId, newName);
	}
	
	public BST() {		// 아무런 인자를 받지 않는 생성자
		root = null;
	}
	
	public Value get(Key k) { return get(root, k); }		// 탐색 연산
	public Value get(Node n, Key k) {
		if (n == null) return null;				// k를 발견 못함
		int t = n.getKey().compareTo(k);
		if(t > 0)		return get(n.getLeft(), k);		// n의 key 값 < k, 왼쪽 서브트리 탐색
		else if(t < 0)	return get(n.getRight(), k);	// n의 key 값 > k, 오른쪽 서브트리 탐색
		else			return (Value) n.getValue();	// k를 가진 노드 발견, value 리턴
	}
	
	public void put(Key k, Value v) { root = put(root, k, v); }		// 삽입 연산
	public Node put(Node n, Key k, Value v) {
		if(n == null) return new Node(k, v);		// 삽입/추가될 노드를 생성하고 리턴
		int t = n.getKey().compareTo(k);
		if(t > 0)		n.setLeft(put(n.getLeft(), k, v));		// n의 key 값 < k, 왼쪽 서브트리에 삽입
		else if(t < 0)	n.setRight(put(n.getRight(), k, v));	// n의 key 값 > k, 오른쪽 서브트리에 삽입
		else n.setValue(v);		// 노드 n의 name을 v로 갱신, 삽입하고자 하는 key값이 이미 있는 경우
		return n;
	}
	
	public Key min() {				// 최솟값 찾기
		if(root == null) return null;
		return (Key) min(root).getKey();
	}
	private Node min(Node n) {
		if(n.getLeft() == null) return n;
		return min(n.getLeft());
	}
	
	public void deleteMin() {		// 최솟값 삭제
		if(root == null)	System.out.println("empty tree");
		else root = deleteMin(root); }
	private Node deleteMin(Node n) {
		if(n.getLeft() == null)	return n.getRight();
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	public void delete(Key k) { root = delete(root, k); }		// 삭제 연산
	public Node delete(Node n, Key k) {
		if(n == null)	return null;					
		int t = n.getKey().compareTo(k);
		if(t > 0)		n.setLeft(delete(n.getLeft(), k));
		else if(t < 0)	n.setRight(delete(n.getRight(), k));
		else {
			if(n.getRight() == null)	return n.getLeft();		// 자식노드가 없는경우, 자식노드가 한 쪽만 없는 경우
			if(n.getLeft() == null)		return n.getRight();	// 자식 노드가 왼쪽만 없는 경우
			Node target = n;							// target은 삭제할 노드
			n = min(target.getRight());					// n은 target의 중위후속자로 업데이트
			n.setRight(deleteMin(target.getRight()));	// n의 오른쪽 자식은 target의 원래 오른쪽 서브트리에서 최솟값을 삭제한 트리	
			n.setLeft(target.getLeft());				// n의 왼쪽 자식은 target의 원래 왼쪽 서브트리
		}
		return n;
	}
	
	public Key max() {				// 최대값 찾기
		if(root == null) return null;
		return (Key) max(root).getKey();
	}
	private Node max(Node n) {
		if(n.getRight() == null) return n;
		return max(n.getRight());
	}
	
	public void deletemax() {		// 최대값 삭제
		if(root == null)	System.out.println("empty tree");
		else 	root = deletemax(root);
	}
	private Node deletemax(Node n) {
		if(n.getRight() == null)	return n.getLeft();
		n.setRight(deleteMin(n.getRight()));
		return n;
	}
	
	public int size(Node n) {				// n을 루트로 하는 트리에 있는 노드 수
		if(n == null)
			return 0;		// null이면 0 리턴
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public void bst2queue(Node n, Queue<Node> q){		// 트리의 중위순회 순서로 큐에 노드를 삽입
		if(n.getLeft() != null)
			bst2queue(n.getLeft(),q);
		q.add(n);
		if(n.getRight() != null)
			bst2queue(n.getRight(),q);
	}
	
	public Key kthSmallest(int k) {
		Queue<Node> q = new LinkedList<Node>();
		bst2queue(this.root, q);			// 이진탐색트리의 중위순회(작은 값부터 들어간) 큐
		Node t = null;
		
		for(int i = 0; i <= k; i++) {
			t = q.remove();				// k번째의 작은 값을 t에 넣는다
		}
		return (Key) t.getKey();
	}
	

	public boolean checkBST() {			// 이진탐색트리인지 검사
		if(root == null)	return false;
		Queue<Node> q = new LinkedList<Node>();
		bst2queue(this.root, q);		// 큐에는 트리의 중위순회 결과가 차례로 들어가있다
		Node r = q.remove();			// r은 중위순회 시 첫 번째 노드
		
		while(!q.isEmpty()) {			// 큐가 비어있을 때까지 반복
			Node l = q.remove();		// 다음 큐의 항목을 꺼내온다
			int t = r.getKey().compareTo(l.getKey()); 		// t는 r.key와 l.key를 비교한 값
			if(t > 0)		// r.key > l.key
				return false;
			else {
				if(!q.isEmpty()) 		// 큐가 비어있지 않으면
					r = q.remove();	 	// r을 중위순회 시 그 다음 노드로 바꾸어준다(큐에서 꺼내온다)
			}
		}
		return true;				// while문을 빠져나왔다면 이진탐색트리이다
	}
	
	
	
	
	public void print() {			// 루트 노드부터 중위순회 출력
		inorder(this.root);
		System.out.println();
	}
	
	public void inorder(Node n) {		// 노드 n 부터 중위순회 결과 출력
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getValue()+" ");
			inorder(n.getRight());
	}
}
	
}
