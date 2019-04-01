package tasks.collections;

import tasks.collections.utility.CollectionsUtilities;

import java.util.ArrayList;

public class ArrayListTask {

    public ArrayList<String> deleteWordsEndingInS(ArrayList<String>list)
    {

       return CollectionsUtilities.getListWithoutSEndingWords(list);

    }
}
