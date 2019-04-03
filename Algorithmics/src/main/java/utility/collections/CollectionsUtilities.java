package utility.collections;

import utility.files.FilesUtilities;

import java.util.*;

public class CollectionsUtilities {

    private static final String RANDOM_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\RandomValues.txt";

    public ArrayList<String> getListWithoutSEndingWords(ArrayList<String> list) {
        list = divideArrayListByWords(list);
        list = pickingUpAnArrayListWithoutWordsEndingInS(list);
        return list;
    }

    public void writeRandomValuesIntoFile(int count, int range) {
        Random random = new Random();
        for (int i = 0; i < count; i++)
            FilesUtilities.writeInFileString(RANDOM_VALUES, String.valueOf(random.nextInt(range)));
    }

    public void checkForAUninitializedListInput(List<String> inputList) {
        if (inputList.isEmpty())
            throw new NullPointerException();
    }

    public HashMap<String, Integer> getHashMapWithCountDuplicatesValue(ArrayList<String> arrayListWithCountDuplicatesValue) {
        if (arrayListWithCountDuplicatesValue.isEmpty()) {
            writeRandomValuesIntoFile(100, 10);
            arrayListWithCountDuplicatesValue=FilesUtilities.readFromFileIntoArrayList(RANDOM_VALUES);
            return getCountOfRepetitionsAfterRandomGeneration(arrayListWithCountDuplicatesValue);
        } else
            return getCountOfRepetitionsAfterRandomGeneration(arrayListWithCountDuplicatesValue);
    }

    private HashMap<String, Integer> getCountOfRepetitionsAfterRandomGeneration(ArrayList<String> arrayListWithAllValues) {
        HashMap<String,Integer> hashMapWithCountOfDuplicatesValues=new HashMap<>();
        for (int i=0;i<arrayListWithAllValues.size();i++) {
            if (hashMapWithCountOfDuplicatesValues.containsKey(arrayListWithAllValues.get(i)))
                hashMapWithCountOfDuplicatesValues.put(arrayListWithAllValues.get(i), hashMapWithCountOfDuplicatesValues.get(arrayListWithAllValues.get(i))+1);
            else
                hashMapWithCountOfDuplicatesValues.put(arrayListWithAllValues.get(i), 1);
        }
        return hashMapWithCountOfDuplicatesValues;
    }


    private ArrayList<String> divideArrayListByWords(ArrayList<String> list) {
        char[] words;
        int begin = 0;
        ArrayList<String> listWords = new ArrayList<>();
        for (String line : list) {
            words = line.toCharArray();
            for (int i = 0; i < words.length; i++) {
                if (words[i] == ' ') {
                    listWords.add(String.valueOf(Arrays.copyOfRange(words, begin, i + 1)));
                    begin = i + 1;
                } else if (i == words.length - 1)
                    listWords.add(String.valueOf(Arrays.copyOfRange(words, begin, i + 1)));
            }
            begin = 0;
            listWords.add("\0");
        }

        return listWords;
    }

    private ArrayList<String> pickingUpAnArrayListWithoutWordsEndingInS(ArrayList<String> list) {
        char[] words;
        String sentensies = "";
        ArrayList<String> collectedArrayList = new ArrayList<>();
        for (String line : list) {
            if (line.contains("\0")) {
                collectedArrayList.add(sentensies);
                sentensies = "";
            } else {
                words = line.toCharArray();
                if (words.length == 1)
                    if (words[words.length - 1] != 's' || words[words.length - 1] != 'S') {
                        sentensies += line;
                        continue;
                    } else
                        continue;
                if (words[words.length - 1] != ' ' && (words[words.length - 1] == 's' || words[words.length - 1] == 'S'))
                    continue;
                if (words[words.length - 2] == 's' || words[words.length - 2] == 'S')
                    continue;
                sentensies += line;
            }
        }
        return collectedArrayList;
    }


}





