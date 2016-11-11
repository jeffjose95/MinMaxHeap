/*
 * This class makes the MinMaxHeap
 * The minMaxHeap is such that
 * if height of the node is even Parent<Node<GrandParent
 * if height of the node is odd GrandParent<Node<Parent
 */
public class MINMAXHEAP {
	
	
	public Node root; // this represents the first node and has a height of 0
	
	
	public MINMAXHEAP()
	{
		root = null;
	}
	
	/*
	 * Node class represnting the variables of a node
	 */
	 private class Node{
		public Node Left;  // represents the node to the left of the parent node
		public Node Right; // represents the node to the right of the parent node
		public int height; // represents the height of the node
		public int value;  // represents the value stored inside the node
		
		public Node(int value)
		{
			this.value = value;
		}
		
		/*
		 * Method to add a node
		 * @param value the value to be stored and added into the heap
		 * @result the updated root having the newly added Node added into the heap
		 */
		public void add(int value) {
			root = add(root, value);
		}
		
		/*
		 * Largest height value found in the heap
		 * @param the root
		 * @result the height of the lowest node 
		 */
		
		private int lowestHeight(Node root)
		{
			int lowestHeight = root.height;
			if(root.Left!=null)
			{
				lowestHeight(root.Left);
			}
			else
			{
				lowestHeight = root.height;				
			}

			return lowestHeight;
		}
		
		/*
		 * adds a new node from the root
		 * @param root the node to check from
		 * @param value the value stored in the new node
		 * @result root of the updated heap 
		 */
		private Node add(Node root, int value) {
			if (root == null)
			{
			root = new Node(value);
			root.height = 0;
			return root;
			}
			Node left = root.Left;
			Node right = root.Right;
			
			int height = lowestHeight(root);
			
			if(left.equals(null))
			{
				left = new Node(value);
				left.height = root.height+1;
				return root;
			}
			
			else if(right.equals(null))
			{
				right = new Node(value);
				right.height = root.height+1;
				return root;
			}
			return null;
	}
		

	}

}
