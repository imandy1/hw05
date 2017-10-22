package tree;

import java.util.ArrayList;

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
				BSTNode parent = insertHelper(key);
				if(key.compareTo((E) parent.getData()) == -1){
					parent.left = child;
				}
				else if(key.compareTo((E) parent.getData()) == 1){
					parent.right = child;
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
		return true;
	}
	public boolean isLeftChild(BSTNode<E> node){
		return true;
	}
	public boolean isRightChild(BSTNode<E> node){
		return true;
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
	public ArrayList<BSTNode<E>> preorder(){
		return null;
	}
	public ArrayList<BSTNode<E>> inorder(){
		return null;
	}
	public ArrayList<BSTNode<E>> postorder(){
		return null;
	}
	public ArrayList<BSTNode<E>> breadthfirst(){
		return null;
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
	
}
