package Dhiraj;

public class PopulatingNextRightPointersInEachNode {
	public Node connect(Node root) {
		if(root == null) return root;
		root.next = null;
		pointToNextRightNode(root.right, null);
		pointToNextRightNode(root.left, root.right);
		return root;
	}
	private void pointToNextRightNode(Node currNode, Node nodeToPointTo){
		if(currNode == null) return;
		currNode.next = nodeToPointTo;
		pointToNextRightNode(currNode.right, nodeToPointTo == null ? null : nodeToPointTo.left);
		pointToNextRightNode(currNode.left, currNode.right);
	}

	/**
	 * Another Approach using BFS
	 *
	 * public Node connect(Node root) {
	 *         if(root == null) return root;
	 *         Queue<Node> queue = new LinkedList<>();
	 *         queue.add(root);
	 *         while(queue.size() > 0){
	 *             int size = queue.size();
	 *             Node leftNode = null;
	 *
	 *             // Processing all Node at same level
	 *             while(size-- > 0){
	 *                 Node currNode = queue.poll();
	 *                 if(leftNode != null){
	 *                     leftNode.next = currNode;
	 *                 }
	 *                 if(currNode.left != null)queue.add(currNode.left);
	 *                 if(currNode.right != null) queue.add(currNode.right);
	 *                 leftNode = currNode;
	 *             }
	 *         }
	 *         return root;
	 *     }
	 * */
}
