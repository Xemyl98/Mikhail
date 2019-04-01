package tasks.collections;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {
    tasks.collections.TreeNode treeNode;

    private void fillingTreeNodes() {
        treeNode.insert(1);
        treeNode.insert(-1);
        treeNode.insert(5);
        treeNode.insert(8);
        treeNode.insert(3);
        treeNode.insert(134);
    }

    @Before
    public void setUp() {
        treeNode = new tasks.collections.TreeNode();
    }

    @Test
    public void countNodesInEmptyTree() {
        assertEquals(0, treeNode.countNodes());
    }

    @Test
    public void countNodesInTreeWithOneNode() {
        treeNode.insert(1);
        assertEquals(1, treeNode.countNodes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void insert() {
        treeNode.insert(1);
        treeNode.insert(1);
    }

    @Test
    public void countNodesInTreeWithCorrectDataValue() {
        fillingTreeNodes();
        assertEquals(6, treeNode.countNodes());
    }
}