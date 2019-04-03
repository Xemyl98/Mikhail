package model.tree;


public class TreeNode {
    private Tree root = null;

    public void insert(int data) {
        Tree node = new Tree(data);
        if (root == null) {
            root = node;
            return;
        }

        Tree currentNode = root;
        Tree parentNode;

        while (true) {
            parentNode = currentNode;
            if (currentNode.data == data)
                throw new IllegalArgumentException("Duplicates nodes note allowed in Binary Search Tree");

            if (currentNode.data > data) {
                currentNode = currentNode.left;
                if (currentNode == null) {
                    parentNode.left = node;
                    return;
                }
            } else {
                currentNode = currentNode.right;
                if (currentNode == null) {
                    parentNode.right = node;
                    return;
                }
            }
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Tree node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(node.left);
            count += countNodes(node.right);
            return count;
        }
    }
}
