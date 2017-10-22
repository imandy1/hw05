package tree;

public class main {
	public static void main(String[] args){
		BinarySearchTree<Integer> tree= new BinarySearchTree();
		
		
		Integer[] arr = {50, 11, 21, 80, 51};
		
		
		BinarySearchTree<Integer> tree1= new BinarySearchTree(arr);
		

		
		
		tree1.printTree();
	}
}
