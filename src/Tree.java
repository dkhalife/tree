import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	private Node root = null;

	public Tree(Node r) {
		root = r;
	}

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	public static void inOrder(Tree t) {
		inOrder(t.root);
	}

	public static void inOrder(Node t) {
		if (t.getLeft() != null)
			inOrder(t.getLeft());

		System.out.print(t.getElem() + " ");

		if (t.getRight() != null)
			inOrder(t.getRight());
	}

	public static void preOrder(Tree t) {
		preOrder(t.root);
	}

	public static void preOrder(Node t) {
		System.out.print(t.getElem() + " ");

		if (t.getLeft() != null)
			preOrder(t.getLeft());

		if (t.getRight() != null)
			preOrder(t.getRight());
	}

	public static void postOrder(Tree t) {
		postOrder(t.root);
	}

	public static void postOrder(Node t) {
		if (t.getLeft() != null)
			postOrder(t.getLeft());

		if (t.getRight() != null)
			postOrder(t.getRight());

		System.out.print(t.getElem() + " ");
	}

	public static void reverseOrder(Tree t) {
		reverseOrder(t.root);
	}

	public static void reverseOrder(Node t) {
		if (t.getRight() != null)
			reverseOrder(t.getRight());

		System.out.print(t.getElem() + " ");

		if (t.getLeft() != null)
			reverseOrder(t.getLeft());
	}

	public static void levelOrder(Tree t) {
		Queue<Node> q = new LinkedList<>();
		Node n = t.root;
		q.offer(n);

		while (!q.isEmpty()) {
			n = q.poll();
			System.out.println(n.getElem());
			if (n.getLeft() != null) {
				q.offer(n.getLeft());
			}
			if (n.getRight() != null) {
				q.offer(n.getRight());
			}
		}
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);
		
		BinarySearchTree t = new BinarySearchTree(e);
		e.setLeft(c);
		e.setRight(g);
		c.setLeft(b);
		c.setRight(d);
		b.setLeft(a);
		
		g.setLeft(f);
		g.setRight(h);
		h.setRight(i);

		levelOrder(t);
		// System.out.print('\n');

		// if(t.contains(9))
		// System.out.println("It contains 9");
		//
		// if(t.contains(10))
		// System.out.println("It contains 10");

//		BinarySearchTree t = new BinarySearchTree();
//		t.insert(5);
//
//		t.insert(4);
//		t.insert(9);
//		t.insert(7);
//		t.insert(1);
//		t.insert(3);
//		t.insert(0);
//		t.insert(100);
//		t.insert(50);

//		inOrder(t);
//		System.out.print('\n');
//		reverseOrder(t);
//		System.out.print('\n');
	}
}