package tasks.collections;

import model.tree.TreeNode;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.files.FilesUtilities;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CollectionTaskTest {
    private TreeNode treeNode;
    private CollectionTask collectionTask;
    private static final String PATH_TO_MANUAL_INPUT_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\ManualInput.txt";
    private static final String PATH_TO_MANUAL_OUTPUT_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\ManualOutput.txt";
    private static ArrayList<String> correctDataInputValue;
    private static ArrayList<String> correctDataOutputValue;
    private static ArrayList<String> manySpacesInputValue;
    private static ArrayList<String> manySpacesOutputValue;
    private static ArrayList<String> arrayListFromManualInputValues;
    private static HashMap<String, Integer> hashMapFromManualInputValues;

    private static void fillingArrayList() {
        arrayListFromManualInputValues = FilesUtilities.readFromFileIntoArrayList(PATH_TO_MANUAL_INPUT_VALUES);
    }

    private void fillingTreeNodes() {
        treeNode.insert(1);
        treeNode.insert(-1);
        treeNode.insert(5);
        treeNode.insert(8);
        treeNode.insert(3);
        treeNode.insert(134);
    }
    private ArrayList<String>  convertHashMapIntoArrayList(HashMap<String,Integer> hashMapToConvert)
    {
        ArrayList<String> dataFromHashMap=new ArrayList<>();
        for(String key:hashMapFromManualInputValues.keySet())
        {
            dataFromHashMap.add(key+"="+hashMapFromManualInputValues.get(key));
        }
        return dataFromHashMap;
    }


    @BeforeClass
    public static void beforeClass() {
        correctDataInputValue = new ArrayList<>();
        correctDataOutputValue = new ArrayList<>();
        manySpacesInputValue = new ArrayList<>();
        manySpacesOutputValue = new ArrayList<>();
        correctDataInputValue.add("New My Lines In this tet");
        correctDataInputValue.add("Pop m4444 works or not");
        correctDataInputValue.add("next Provs");
        correctDataOutputValue.add("New My In tet");
        correctDataOutputValue.add("Pop m4444 or not");
        correctDataOutputValue.add("next ");
        manySpacesInputValue.add("       ");
        manySpacesInputValue.add("   world    and  words  ");
        manySpacesOutputValue.add("       ");
        manySpacesOutputValue.add("   world    and   ");
    }

    @Before
    public void setUp() {
        treeNode = new TreeNode();
        collectionTask = new CollectionTask();
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
    public void countNodesInTreeWithDuplicatedValue() {
        treeNode.insert(1);
        treeNode.insert(1);
    }

    @Test
    public void countNodesInTreeWithCorrectDataValue() {
        fillingTreeNodes();
        assertEquals(6, collectionTask.countTheNumberOfNodes(treeNode));
    }

    @Test
    public void deleteWordsEndingInSWithCorrectInputValue() {
        assertEquals(correctDataOutputValue, collectionTask.deleteWordsEndingInS(correctDataInputValue));
    }

    @Test
    public void inputArrayListWithManySpaces() {
        assertEquals(manySpacesOutputValue, collectionTask.deleteWordsEndingInS(manySpacesInputValue));
    }

    @Test(expected = NullPointerException.class)
    public void deleteWordsEndingInSWithInputValue() {
        collectionTask.deleteWordsEndingInS(null);
    }

    @Test
    public void calculateTheCountOfRepetitionsValuesIntoHashMapFromManualInput() {
        fillingArrayList();
        hashMapFromManualInputValues = collectionTask.calculateTheCountOfRepetitionsValuesIntoHashMap(arrayListFromManualInputValues);
        assertEquals(FilesUtilities.readFromFileIntoArrayList(PATH_TO_MANUAL_OUTPUT_VALUES), convertHashMapIntoArrayList(hashMapFromManualInputValues));
    }
}