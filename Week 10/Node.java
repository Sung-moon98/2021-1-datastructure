package Kim;

public class Node <Key extends Comparable<Key>, Value> {
	private Key id;
	private Value name;
	private Node left, right;
	public Node(Key newId, Value newName) {			// 생성자
		id = newId;
		name = newName;
		left = right = null;
	}
	
	public Key getKey() { return id; }
	public Value getValue() { return name; }
	public Node getLeft() { return left; }
	public Node getRight() { return right; }
	public void setKey(Key newId) { id = newId; }
	public void setValue(Value newName) { name = newName; }
	public void setLeft(Node lt) { left = lt; }
	public void setRight(Node rt) { right = rt; }

}
