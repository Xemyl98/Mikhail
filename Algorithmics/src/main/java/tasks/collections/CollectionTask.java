package tasks.collections;

import model.tree.TreeNode;
import utils.collections.CollectionUtils;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class CollectionTask {
    public List<String> deleteWordsEndingWithS(List<String> inputList) {
        CollectionUtils.listIsUninitialized(inputList);
        return CollectionUtils.getListWithoutSEndingWords(inputList);
    }

    public Map<String, Integer> calculateTheCountOfDuplicationsValuesInHashMap(List<String> inputArrayList) throws NoSuchAlgorithmException {
        return CollectionUtils.getHashMapWithDuplicateCountValue(inputArrayList);
    }

    public int countTheNumberOfNodes(TreeNode treeNode) {
        return treeNode.countNodes();
    }
}
