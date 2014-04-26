public class Node {
	private Node left = null;
	private Node right = null;
	private Object elem;
	
	public Node(Object e){
		elem = e;
	}
	
	public Node(Node l, Node r) {
		left = l;
		right = l;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return the elem
	 */
	public Object getElem() {
		return elem;
	}

	/**
	 * @param elem the elem to set
	 */
	public void setElem(Object elem) {
		this.elem = elem;
	}
}
