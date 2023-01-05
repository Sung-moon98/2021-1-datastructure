package Kim;

public class Node <E>{
	private E item;				// 항목(데이터)
	private Node<E> next;		// 다음 노드를 가르키는 레퍼런스
	
	public Node(E newItem, Node<E> node) {		// 생성자
		item = newItem;
		next = node;
	}
	
	public E getItem() { return item; }
	public Node<E> getNext() { return next; }
	public void setItem(E newItem) { item = newItem; }
	public void setNext(Node<E> newNext) { next = newNext; }

}
