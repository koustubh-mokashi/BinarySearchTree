import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryRunner {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(15);
		bst.insert(20);
		bst.insert(14);
		bst.insert(22);
		bst.insert(21);
		bst.insert(25);
		bst.insert(16);
		dfsInOrder(bst);
	}

	public static void bfsTraversal(BinarySearchTree bst) {
		ArrayDeque<BinarySearchTree.Node> bq = new ArrayDeque<>();
		bq.add(bst.getRoot());
		while (!bq.isEmpty()) {
			BinarySearchTree.Node start = bq.poll();
			System.out.println(start.getValue());
			if (start.getLeft() != null)
				bq.add(start.getLeft());
			if (start.getRight() != null)
				bq.add(start.getRight());
		}
	}

	public static void dfsInOrder(BinarySearchTree bst) {
		BinarySearchTree.Node current = bst.getRoot();
		if (current == null) {
			return;
		}
		Stack<BinarySearchTree.Node> stack = new Stack<>();
		do {
			if (current != null && current.getLeft() != null) {
				stack.add(current);
				current = current.getLeft();
			} else if (current != null) {
				System.out.println(current.getValue());
				current = current.getRight();
			} else {
				current = stack.pop();
				System.out.println(current.getValue());
				current = current.getRight();
			}
		} while (!stack.isEmpty() || current != null);
	}

	public static void dfsPreOrder(BinarySearchTree bst) {
		BinarySearchTree.Node current = bst.getRoot();
		if (current == null) {
			return;
		}
		Stack<BinarySearchTree.Node> stack = new Stack<>();
		stack.add(current);
		System.out.println(current.getValue());
		while (!stack.isEmpty()) {
			if (current == null) {
				current = stack.pop().getRight();
				if (current != null) {
					System.out.println(current.getValue());
					stack.add(current);
				}
			} else if (current.getLeft() != null) {
				current = current.getLeft();
				stack.add(current);
				System.out.println(current.getValue());
			} else {
				current = stack.pop().getRight();
				if (current != null) {
					System.out.println(current.getValue());
					stack.add(current);
				}
			}

		}
	}

	public static void dfsPostOrder(BinarySearchTree bst) {
		BinarySearchTree.Node current = bst.getRoot();
		Stack<BinarySearchTree.Node> stack = new Stack<>();
		do {
			while (current != null) {
				if (current.getRight() != null) {
					stack.add(current.getRight());
				}
				stack.add(current);
				current = current.getLeft();
			}
			current = stack.pop();
			if (!stack.isEmpty() && current.getRight() != null && current.getRight() == stack.peek()) {
				stack.pop();
				stack.push(current);
				current = current.getRight();
			} else {
				System.out.println(current.getValue());
				current = null;
			}
		} while (!stack.isEmpty());
	}

}
