package Kim;

public class DNode <E>{
	private E item;
	private DNode previous;			// 이전 노드
	private DNode next;				// 다음 노드
	public DNode(E newItem, DNode p, DNode q) {
		item = newItem;
		previous = p;
		next = q;
	}
	
	public E getItem() { return item; }
	public DNode getPrevious() { return previous; }
	public DNode getNext() { return next; }
	public void setItem(E newItem) { item = newItem; }
	public void setPrevious(DNode p) { previous = p; }
	public void setNext(DNode q) { next = q; }
	

}
