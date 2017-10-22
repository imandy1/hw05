package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(E[] array){
		// note if using array type like int[] need to use Integer[] instead
		for(int i = 0; i < array.length; i++){
			insert(array[i]);
		}
	}
	
	public void insert(E key){
		BSTNode child = new BSTNode(key);
		
		if(root == null){
			root = child;
		}
		else{
			try{
				BSTNode<E> parent = insertHelper(key);
				if(key.compareTo((E) parent.getData()) == -1){
					parent.left = child;
					child.parent = parent;
				}
				else if(key.compareTo((E) parent.getData()) == 1){
					parent.right = child;
					child.parent = parent;
				}
			}
			catch(DuplicateItemException e){
				e.printStackTrace();
			}
		}
		
	}
	private BSTNode<E> insertHelper(E key) throws DuplicateItemException{
		BSTNode<E> current = root;
		BSTNode<E> parent = null;
		
		while(current != null){
			if(key.compareTo(current.getData()) == 0){
				throw new DuplicateItemException("Error: item trying to insert is already in tree");
			}
			else if(key.compareTo(current.getData()) == -1){
				parent = current;
				current = current.left;
			}
			else if(key.compareTo(current.data) == 1){
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}
	public void delete(E key){
		delete(deleteHelper(key));
	}
	public void delete(BSTNode<E> node){
		if(isLeaf(node)){
			if(isLeftChild(node)){
				node.parent.left = null;
			}
			else if(isRightChild(node)){
				node.parent.right = null;
			}
		}
		else if(numOfChildren(node) == 1){
			BSTNode<E> child = null;
			if(node.left != null){
				child = node.left;
			}
			else if(node.right != null){
				child = node.right;
			}
			
			if(isLeftChild(node)){
				node.parent.left = child;
			}
			else if(isRightChild(node)){
				node.parent.right = child;
			}
		}
		else if(numOfChildren(node) == 2){
			
		}
	}
	/**
	 * Finds the node to delete using the key specified in the parameters
	 * @param key
	 * @return
	 */
	private BSTNode<E> deleteHelper(E key){
		BSTNode<E> current = root;
		
		while(current != null){
			if(key.compareTo((E) current.getData()) == 0){
				return current;
			}
			else if(key.compareTo((E) current.getData()) == -1){
				current = current.left;
			}
			else if(key.compareTo((E) current.getData()) == 1){
				current = current.right;
			}
		}
		
		return null;
	}
	public int numOfChildren(BSTNode<E> node){
		int children = 0;
		
		if(node.left != null && node.right != null){
			children = 2;
		}
		else if(node.right != null || node.left != null){
			children = 1;
		}
		
		return children;
	}
	public boolean find(E key){
		BSTNode<E> current = root;
		while(current != null){
			if(key.compareTo(current.getData()) == 0){
				return true;
			}
			else if(key.compareTo(current.getData()) == -1){
				current = current.left;
			}
			else if(key.compareTo(current.getData()) == 1){
				current = current.right;
			}
		}
		return false;
	}
	public int depth(BSTNode<E> node){
		return 0;
	}
	public int height(BSTNode<E> node){
		return 0;
	}
	public boolean isEmpty(){
		if(root == null){
			return true;
		}
		return false;
	}
	public boolean isLeaf(BSTNode<E> node){
		//add exception for when node is not in tree
		if(node.right == null && node.left == null){
			return true;
		}
		return false;
	}
	public boolean isLeftChild(BSTNode<E> node){
		if(node == root){
			return false;
		}
		else if(node.parent.left == null){
			return false;
		}
		else if(node.parent.left.getData().compareTo(node.getData()) == 0){
			return true;
		}
		return false;
	}
	public boolean isRightChild(BSTNode<E> node){
		if(node == root){
			return false;
		}
		else if(node.parent.right == null){
			return false;
		}
		else if(node.parent.right.getData().compareTo(node.getData()) == 0){
			return true;
		}
		return false;
	}
	public BSTNode<E> sibling(BSTNode<E> node){
		return null;
	}
	public BSTNode<E> uncle(BSTNode<E> node){
		return null;
	}
	public BSTNode<E> grandparent(BSTNode<E> node){
		return null;
	}
	public List<BSTNode<E>> preorder(BSTNode<E> node){
		List<BSTNode<E>> list = new ArrayList<>();
		printPreOrder(node, list);
		return list;
	}
	/**
	 * helper method for preorder. Used to pass an list into the method
	 * so we can use the list to store values
	 * @param node
	 * @param list
	 */
	public void printPreOrder(BSTNode<E> node, List<BSTNode<E>> list){
		if(node == null){
			return;
		}
		list.add(node);
		printPreOrder(node.left, list);
		printPreOrder(node.right, list);
	}
	public List<BSTNode<E>> inorder(BSTNode<E> node){
		List<BSTNode<E>> list = new ArrayList<>();
		printInOrder(node, list);
		return list;
	}
	public void printInOrder(BSTNode<E> node, List<BSTNode<E>> list){
		if(node == null){
			return;
		}
		printInOrder(node.left, list);
		list.add(node);
		printInOrder(node.right, list);
	}
	public List<BSTNode<E>> postorder(BSTNode<E> node){
		List<BSTNode<E>> list = new ArrayList<>();
		printPostOrder(node, list);
		return list;
	}
	public void printPostOrder(BSTNode<E> node, List<BSTNode<E>> list){
		if(node == null){
			return;
		}
		printPostOrder(node.left, list);
		printPostOrder(node.right, list);
		list.add(node);
	}
	public ArrayList<BSTNode<E>> breadthfirst(){
		return null;
	}
	public void printParentValue(E value){
		System.out.println(findNode(value).parent.getData());
	}
	public void printTree() {

	    if (this.root.right != null) {
	        this.printTree(this.root.right, true, "");
	    }

	    printNodeValue(this.root);

	    if (this.root.left != null) {
	        this.printTree(this.root.left, false, "");
	    }
	}

	private void printTree(BSTNode<E> node, boolean isRight, String indent) {
	    if (node.right != null) {
	        printTree(node.right, true, indent + (isRight ? "        " : " |      "));
	    }

	    System.out.print(indent);

	    if (isRight) {
	        System.out.print(" /");
	    }
	    else {
	        System.out.print(" \\");
	    }
	    System.out.print("----- ");
	    printNodeValue(node);
	    if (node.left != null) {
	        printTree(node.left, false, indent + (isRight ? " |      " : "        "));
	    }
	}

	private void printNodeValue(BSTNode<E> node) {
	    if (node == null) {
	        System.out.print("<null>");
	    }
	    else {
	        System.out.print(node.getData());
	    }
	    System.out.println();
	}
	
	public BSTNode<E> findNode(E key){
		BSTNode<E> current = root;
		while(current != null){
			if(key.compareTo((E) current.getData()) == 0){
				return current;
			}
			else if(key.compareTo((E) current.getData()) == 1){
				current = current.right;
			}
			else if(key.compareTo((E) current.getData()) == -1){
				current = current.left;
			}
		}	
		return null;

		
	}
	
}
