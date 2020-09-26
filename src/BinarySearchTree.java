public class BinarySearchTree {

	private Node root;

	public static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(int value) {
		if (root == null) {
			this.root = new Node(value);
			return;
		}
		Node trave = root;
		while (trave != null) {
			if (trave.value > value) {
				if (trave.left == null) {
					trave.left = new Node(value);
					break;
				}
				trave = trave.left;
			} else {
				if (trave.right == null) {
					trave.right = new Node(value);
					break;
				}
				trave = trave.right;
			}
		}
	}

}
