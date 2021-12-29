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
}
