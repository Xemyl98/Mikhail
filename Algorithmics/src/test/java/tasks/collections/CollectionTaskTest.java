package tasks.collections;

import model.tree.TreeNode;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.files.FileUtils;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CollectionTaskTest {
    private static TreeNode treeNodeWithCorrectData;
    private static TreeNode treeNodeWithOneNode;
    private static TreeNode emptyTreeNode;
    private CollectionTask collectionTask;
    private static final String PATH_TO_MANUAL_INPUT_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\ManualInput.txt";
    private static final String PATH_TO_MANUAL_OUTPUT_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\ManualOutput.txt";
    private static List<String> correctDataInputValue;
    private static List<String> correctDataOutputValue;
    private static List<String> manySpacesInputValue;
    private static List<String> manySpacesOutputValue;
    private static List<String> arrayListFromManualInputValues;
    private static Map<String, Integer> hashMapWithDataFromFile;


    private List<String> convertHashMapToArrayList(Map<String, Integer> hashMapFromManualInputValues) {
        List<String> dataFromHashMap = new ArrayList<>();
        for (String key : hashMapFromManualInputValues.keySet()) {
            dataFromHashMap.add(key + "=" + hashMapFromManualInputValues.get(key));
        }
        return dataFromHashMap;
    }


    @BeforeClass
    public static void beforeClass() {
        correctDataInputValue = new ArrayList<>();
        correctDataOutputValue = new ArrayList<>();
        manySpacesInputValue = new ArrayList<>();
        manySpacesOutputValue = new ArrayList<>();
        treeNodeWithCorrectData = new TreeNode();
        treeNodeWithOneNode = new TreeNode();
        emptyTreeNode = new TreeNode();
        treeNodeWithCorrectData.insert(1);
        treeNodeWithCorrectData.insert(-1);
        treeNodeWithCorrectData.insert(5);
        treeNodeWithCorrectData.insert(8);
        treeNodeWithCorrectData.insert(3);
        treeNodeWithCorrectData.insert(134);
        treeNodeWithOneNode.insert(1);
        correctDataInputValue.add("New My Lines In this tet");
        correctDataInputValue.add("Pop m4444 works or not");
        correctDataInputValue.add("next ProvS");
        correctDataOutputValue.add("New My In tet");
        correctDataOutputValue.add("Pop m4444 or not");
        correctDataOutputValue.add("next");//TODO " " after words
        manySpacesInputValue.add("       ");
        manySpacesInputValue.add("   world    and  words  ");
        manySpacesOutputValue.add("      ");
        manySpacesOutputValue.add("   world    and  ");
        arrayListFromManualInputValues = FileUtils.readDataFromFileToArrayList(PATH_TO_MANUAL_INPUT_VALUES);
    }

    @Before
    public void setUp() {
        collectionTask = new CollectionTask();
    }

    @Test
    public void countNodesInEmptyTree() {
        assertEquals(0, emptyTreeNode.countNodes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void countNodesInTreeWithDuplicatedValue() {
        treeNodeWithOneNode.insert(1);
    }

    @Test
    public void countNodesInTreeWithOneNode() {
        assertEquals(1, treeNodeWithOneNode.countNodes());
    }


    @Test
    public void countNodesInTreeWithCorrectDataValue() {
        assertEquals(6, collectionTask.countTheNumberOfNodes(treeNodeWithCorrectData));
    }

    @Test
    public void deleteWordsEndingWithSFromArrayListWithCorrectDataValue() {
        assertEquals(correctDataOutputValue, collectionTask.deleteWordsEndingWithS(correctDataInputValue));
    }

    @Test
    public void inputArrayListWithManySpaces() {
        assertEquals(manySpacesOutputValue, collectionTask.deleteWordsEndingWithS(manySpacesInputValue));
    }

    @Test(expected = NullPointerException.class)
    public void deleteWordsEndingInSWithFromUninitializedArrayList() {
        collectionTask.deleteWordsEndingWithS(null);
    }

    @Test
    public void calculateTheCountOfDuplicationsValuesInHashMapWithDataFromFile() throws NoSuchAlgorithmException {
        hashMapWithDataFromFile = (HashMap<String, Integer>) collectionTask.calculateTheCountOfDuplicationsValuesInHashMap(arrayListFromManualInputValues);
        assertEquals(FileUtils.readDataFromFileToArrayList(PATH_TO_MANUAL_OUTPUT_VALUES), convertHashMapToArrayList(hashMapWithDataFromFile));
    }
}