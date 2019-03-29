package collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {
    TreeNode treeNode;

    private void inputDictionary() {
        treeNode.insert(1);
        treeNode.insert(-1);
        treeNode.insert(5);
        treeNode.insert(8);
        treeNode.insert(3);
        treeNode.insert(134);
    }

    @Before
    public void setUp() {
        treeNode = new TreeNode();
    }

    @Test
    public void nullTreeInput() {
        assertEquals(0, treeNode.countNodes());
    }

    @Test
    public void oneElementInput() {
        treeNode.insert(1);
        assertEquals(1, treeNode.countNodes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void insert() {
        treeNode.insert(1);
        treeNode.insert(1);
        assertEquals(2, treeNode.countNodes());
    }

    @Test
    public void defaultUserInput() {
        inputDictionary();
        assertEquals(6, treeNode.countNodes());
    }
}