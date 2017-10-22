package tree;

public class BSTNode<E extends Comparable<E>> {
	protected BSTNode<E> parent;
	protected BSTNode<E> left;
	protected BSTNode<E> right;
	protected E data;
	
	public BSTNode(E data){
		this.data = data;
	}
	
	public E getData(){
		return this.data;
	}
	public void setData(E data){
		this.data = data;
	}
}
