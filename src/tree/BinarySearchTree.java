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
		if(isLeaf(deleteHelper(key))){
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
	public void isLeftChild(BSTNode<E> node){
		System.out.println(node.parent == null);
		
		
	}
	public boolean isRightChild(BSTNode<E> node){
		if(node.parent.right.getData().compareTo(node.getData()) == 0){
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
