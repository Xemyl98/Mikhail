package tasks.collections;

import tasks.collections.utility.CollectionsUtilities;

public class TreeNode {
    CollectionsUtilities.Tree root = null;
    public void insert(int data) {
        CollectionsUtilities.Tree node = new CollectionsUtilities.Tree(data);
        if (root == null) {
            root = node;
            return;
        }

        CollectionsUtilities.Tree currentNode = root;
        CollectionsUtilities.Tree parentNode;

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

    private int countNodes(CollectionsUtilities.Tree node) {
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
