public class AvlTree {
	public class AvlNode {
		private AvlNode left = null;
		private AvlNode right = null;
		private AvlNode parent = null;
		private Integer elem;
		private Integer heightDiff = 0;

		public AvlNode(Integer e) {
			elem = e;
		}
	}

	private AvlNode root = null;

	public void insert(Integer e) {
		if (root == null) {
			root = new AvlNode(e);
			return;
		}

		insert(root, e);
	}

	private void insert(AvlNode n, Integer e) {
		Integer current = n.elem;

		if (e < current) {
			if (n.left != null) {
				insert(n.left, e);
			}
			else {
				AvlNode newNode = new AvlNode(e);
				newNode.parent = n;
				n.left = newNode;

				adjustHeight(n, newNode);
				balance(newNode.parent);
			}
		}
		else if (e > current) {
			if (n.right != null) {
				insert(n.right, e);
			}
			else {
				AvlNode newNode = new AvlNode(e);
				newNode.parent = n;
				n.right = newNode;

				adjustHeight(n, newNode);
				balance(newNode.parent);
			}
		}
	}

	// diff = height(left) - height(right)
	private void adjustHeight(AvlNode p, AvlNode c) {
		if (p.left == c) {
			p.heightDiff++;
		}
		else {
			p.heightDiff--;
		}

		if (p != root)
			adjustHeight(p.parent, p);
	}

	private int height(AvlNode n) {
		if (n == null) {
			return 0;
		}
		else {
			return n.heightDiff;
		}
	}

	private void balance(AvlNode p) {
		AvlNode r = p.right;
		AvlNode l = p.left;
		// System.out.println(p.heightDiff);
		if (height(p) == -2) {
			// balance right
			if (height(r) == -1) {
				// single left rotation with p as the root (RIGHT RIGHT)
				rotateLeft(p);
			}
			if (height(r) == 1) {
				// double rotation (RIGHT LEFT)
				// right rotation with R as the root
				rotateRight(r);
				// left rotation with P as the root
				rotateLeft(p);
			}
		}

		if (height(p) == 2) {
			// balance left
			if (height(l) == 1) {
				// single right rotation with P as the root (LEFT LEFT)
				rotateRight(p);
			}
			if (height(l) == -1) {
				// double rotation (LEFT RIGHT)
				// left rotation with L as the root
				rotateLeft(l);
				// right rotation with P as the root
				rotateRight(p);
			}
		}

		// We balanced the tree at p
		p.heightDiff = 0;

		if (p != root)
			balance(p.parent);
	}

	private void rotateLeft(AvlNode top) {
		AvlNode ancestor = top.parent;
		boolean direction = false; // false = left, true = right
		if (ancestor != null) {
			direction = ancestor.right == top;
		}

		top.parent = top.right;
		top.right = top.parent.left;
		top.parent.left = top;
		top.parent.parent = ancestor;

		if (root == top) {
			root = top.parent;
		}

		if (ancestor != null) {
			if (direction) {
				ancestor.right = top.parent;
			}
			else {
				ancestor.left = top.parent;
			}
		}
	}

	private void rotateRight(AvlNode top) {
		AvlNode ancestor = top.parent;
		boolean direction = false; // false = left , true = right
		if (ancestor != null) {
			direction = ancestor.right == top;
		}

		top.parent = top.left;
		top.left = top.parent.right;
		top.parent.right = top;
		top.parent.parent = ancestor;

		if (root == top) {
			root = top.parent;
		}

		if (ancestor != null) {
			if (direction) {
				ancestor.right = top.parent;
			}
			else {
				ancestor.left = top.parent;
			}
		}
	}

	public void print() {
		print(root, 0);
	}

	private void print(AvlNode n, int tabs) {
		if (n == null) {
			return;
		}

		for (int i = 0; i < tabs; ++i) {
			System.out.print("\t");
		}

		System.out.println(n.elem);
		print(n.left, tabs + 1);
		print(n.right, tabs + 1);
	}

	public static void main(String args[]) {
		AvlTree test = new AvlTree();

		test.insert(3);
		test.insert(5);
		test.insert(4);
		test.insert(2);
		test.insert(1);
		test.insert(0);

		test.print();
	}
}
