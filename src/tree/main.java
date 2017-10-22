package tree;

public class main {
	public static void main(String[] args){
		BinarySearchTree<Integer> tree= new BinarySearchTree();
		
		
		Integer[] arr = {50, 25, 75, 100, 60, 11, 5, 13, 102, 15};
		
		
		BinarySearchTree<Integer> tree1= new BinarySearchTree(arr);
		

		tree1.printTree();
		
		
		
		for(int i = 0; i < tree1.preorder(tree1.findNode(50)).size(); i++){
			System.out.print(tree1.preorder(tree1.findNode(50)).get(i).getData() + " ");
		}
		
		System.out.println();
		for(int i = 0; i < tree1.inorder(tree1.findNode(50)).size(); i++){
			System.out.print(tree1.inorder(tree1.findNode(50)).get(i).getData() + " ");
		}
		System.out.println();
		for(int i = 0; i < tree1.postorder(tree1.findNode(50)).size(); i++){
			System.out.print(tree1.postorder(tree1.findNode(50)).get(i).getData() + " ");
		}
		System.out.println();
		
		tree1.printParentValue(75);
		
		
		
	}
}
