package tasks.collections;

import model.tree.TreeNode;
import utility.collections.CollectionsUtilities;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionTask {
    ArrayList<String> deleteWordsEndingInS(ArrayList<String> inputList) {
        CollectionsUtilities collectionsUtilities = new CollectionsUtilities();
        collectionsUtilities.checkForAUninitializedListInput(inputList);
        return collectionsUtilities.getListWithoutSEndingWords(inputList);
    }

    public HashMap<String, Integer> calculateTheCountOfRepetitionsValuesIntoHashMap(ArrayList<String> inputArrayList) {
        CollectionsUtilities collectionsUtilities = new CollectionsUtilities();
        return collectionsUtilities.getHashMapWithCountDuplicatesValue(inputArrayList);
    }

    int countTheNumberOfNodes(TreeNode treeNode) {
        return treeNode.countNodes();

    }
}
