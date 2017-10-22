package tree;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(E[] array){
		
	}
	
	public void insert(E key){
		
	}
	private BSTNode<E> insertHelper(E key) throws DuplicateItemException{
		BSTNode<E> current = root;
		BSTNode<E> parent = null;
		
		while(current != null){
			if(key.compareTo(key) == 1){
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
		return true;
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
	
}
