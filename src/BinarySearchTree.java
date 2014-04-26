public class BinarySearchTree extends Tree {

	public BinarySearchTree() {
		super(null);
	}

	public BinarySearchTree(Node root) {
		super(root);
	}
	
	public void insert(Integer e) {
		if(getRoot() == null){
			setRoot(new Node(e));
			return;
		}
		
		insert(null, getRoot(), e, false);
	}
	
	private void insert(Node parent, Node n, Integer e, boolean dir){
		// No duplicates in this insertion
		
		if(n == null){
			if(dir)
				parent.setRight(new Node(e));
			else 
				parent.setLeft(new Node(e));
			return;
		}
		
		Integer current = (Integer) n.getElem();
		
		if(e < current)
			insert(n, n.getLeft(), e, false);
		else if(e > current)
			insert(n, n.getRight(), e, true);
	}

	public void findMin() {
		Node t = this.getRoot();

		while (t.getLeft() != null)
			t = t.getLeft();

		System.out.println(t.getElem() + " is the min");
	}

	public void findMax() {
		Node t = this.getRoot();

		while (t.getRight() != null)
			t = t.getRight();

		System.out.println(t.getElem() + " is the max");
	}

	public boolean contains(Integer e){
		Node t = this.getRoot();
		Integer s;
		
		while(t != null){
			s = (Integer) t.getElem();
			
			if(s == e)
				return true;
			else if(e < s)
				t = t.getLeft();
			else 
				t = t.getRight();
		}
		
		return false;
	}
}
