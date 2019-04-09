package tasks.collections;

import model.tree.TreeNode;
import utility.collections.CollectionsUtilities;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class CollectionTask {
    List<String> deleteWordsEndingWithS(List<String> inputList,CollectionsUtilities collectionsUtilities) {
        collectionsUtilities.checkForUninitializedListInput(inputList);
        return collectionsUtilities.getListWithoutSEndingWords(inputList);
    }

     Map<String, Integer> calculateTheCountOfDuplicationsValuesInHashMap(List<String> inputArrayList,CollectionsUtilities collectionsUtilities) throws NoSuchAlgorithmException {
        return collectionsUtilities.getHashMapWithDuplicateCountValue(inputArrayList);
    }

    int countTheNumberOfNodes(TreeNode treeNode) {
        return treeNode.countNodes();
    }
}
