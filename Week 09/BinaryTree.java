package Kim;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	public BinaryTree() { root = null; }		// 이진트리 생성자
	final static Node NOT_VAL = new Node(-1, null, null);		// 비어있는 노드 정의
	
	public Node getRoot() { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }
	public boolean isEmpty() { return root == null; }

	public void preorder(Node n) {			// 전위순회
		if(n != null) {
			System.out.print(n.getKey()+" ");	// 방문
			preorder(n.getLeft());				// 왼쪽 서브트리 순회
			preorder(n.getRight());				// 오른쪽 서브트리 순회
		}
	}
	
	public void inorder(Node n) {			// 중위순회
		if(n != null) {
			inorder(n.getLeft());				// 왼쪽 서브트리 순회
			System.out.print(n.getKey()+" ");	// 방문
			inorder(n.getRight());				// 오른쪽 서브트리 순회
		}
	}
	
	public void postorder(Node n) {			// 후위순회
		if(n != null) {	
			postorder(n.getLeft());				// 왼쪽 서브트리 순회
			postorder(n.getRight());			// 오른쪽 서브트리 순회
			System.out.print(n.getKey()+" ");	// 방문
		}
	}
	
	public void levelorder(Node root) {		// 레벨순회
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root);								// 루트 노드 큐에 삽입
		while(!q.isEmpty()) {
			t = q.remove();							// 큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey()+" ");		// 제거된 노드 방문
			if(t.getLeft() != null)					// 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());					// 큐에 왼쪽 자식 삽입
			if(t.getRight() != null)				// 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());				// 큐에 오른쪽 자식 삽입
		}
	}
	
	public int size(Node n) {				// n을 루트로 하는 트리에 있는 노드 수
		if(n == null)
			return 0;		// null이면 0 리턴
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public int height(Node n) {				// n을 루트로 하는 트리의 높이
		if(n == null)
			return 0;
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}
	
	public static boolean isEqual(Node n, Node m) {		// 두 트리의 동일성 검사
		if(n == null || m == null)		// 둘 중에 하나라도 null이면		
			return n == m;				// 둘 다 null이면 true, 아니면 false
		
		if(n.getKey().compareTo(m.getKey()) != 0)		// 둘 다 null이 아니면 item 비교
			return false;
		
		return(isEqual(n.getLeft(), m.getLeft())) &&	// item이 같으면 왼쪽자식 재귀호출
				isEqual(n.getRight(), m.getRight());	// 오른쪽 자식 재귀호출
	}
	
	
	public int[] btree2intarr() {
		int h = this.height(this.root);
		int[] btree = new int[(int) Math.pow(2, h)];	// 배열의 0번째 인덱스는 비어있다 // 포화이진트리의 개수로 배열의 크기 설정
		
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root);								// 루트 노드 큐에 삽입
		for(int i = 1; i < btree.length; i++) {
			t = q.remove();					
			btree[i] = (int)t.getKey();				
			if(t.getLeft() != null)					// Left가 null 값이 아니면 큐에 노드 삽입
				q.add(t.getLeft());					
			if(t.getRight() != null)				// Right가 null 값이 아니면 큐에 노드 삽입
				q.add(t.getRight());		
			if(t.getLeft() == null)					// Left가 null이면 큐에 NOT_VAL 삽입
				q.add(NOT_VAL);
			if(t.getRight() == null)				// Right가 null이면 큐에 NOT_VAL 삽입
				q.add(NOT_VAL);
			if(t == NOT_VAL) {						// 큐에서 가져온 값이 NOT_VAL이면 자식 노드들도 null이므로 큐에 NOT_VAL 2회 삽입
				q.add(NOT_VAL);
				q.add(NOT_VAL);
			}
		}

		return btree;
	}
	
	public void intarr2btree(int[] arr) {
		if(!isEmpty()) { this.root = null; }	// 이진트리에 저장된 노드 삭제
		
		int mid = this.size(root)/2;
		Node t = new Node(arr[1], null, null);
		this.setRoot(t);
		}
	
	public Queue<Node> pre2subtree(Node n){
		Queue<Node> q = new LinkedList<Node>();
		if(n != null) {
			q.add(n);
			pre2subtree(n.getLeft());
			pre2subtree(n.getLeft());
		}
		return q;
	}
	
	
	public LinkedList<Node> subTreeCompare(BinaryTree t){
		LinkedList<Node> sub = new LinkedList<Node>();
		
		for(Node i : pre2subtree(this.root)) {
			for(Node b : pre2subtree(t.root)) {
				if(isEqual(i, b)) {
					sub.add(b);
				}
			}
		}
		return sub;
	}
	
	
	}
	

