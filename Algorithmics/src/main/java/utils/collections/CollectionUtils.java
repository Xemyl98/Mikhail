package utils.collections;

import utils.files.FileUtils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class CollectionUtils {

    private CollectionUtils() {
    }

    private static final String RANDOM_VALUES = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\collections\\RandomValues.txt";

    public static List<String> getListWithoutSEndingWords(List<String> list) {
        list = divideArrayListIntoWords(list);
        list = getArrayListWithoutWordsEndingWithS(list);
        return list;
    }

    public static Map<String, Integer> getHashMapWithDuplicateCountValue(List<String> arrayListWithCountDuplicatesValue) throws NoSuchAlgorithmException {
        if (arrayListWithCountDuplicatesValue.isEmpty()) {
            writeRandomValuesIntoFile(100, 10);
            arrayListWithCountDuplicatesValue = FileUtils.readDataFromFileToArrayList(RANDOM_VALUES);
            return getCountOfDuplicatesAfterRandomGeneration(arrayListWithCountDuplicatesValue);
        } else
            return getCountOfDuplicatesAfterRandomGeneration(arrayListWithCountDuplicatesValue);
    }

    public static void writeRandomValuesIntoFile(int count, int range) throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();
        for (int i = 0; i < count; i++)
            FileUtils.writeInFileString(RANDOM_VALUES, String.valueOf(rand.nextInt(range)));
    }

    public static void listIsUninitialized(List<String> inputList) {
        if (inputList.isEmpty())
            throw new NullPointerException();
    }


    private static HashMap<String, Integer> getCountOfDuplicatesAfterRandomGeneration(List<String> arrayListWithAllValues) {
        HashMap<String, Integer> hashMapWithCountOfDuplicatesValues = new HashMap<>();
        for (int i = 0; i < arrayListWithAllValues.size(); i++) {
            if (hashMapWithCountOfDuplicatesValues.containsKey(arrayListWithAllValues.get(i)))
                hashMapWithCountOfDuplicatesValues.put(arrayListWithAllValues.get(i), hashMapWithCountOfDuplicatesValues.get(arrayListWithAllValues.get(i)) + 1);
            else
                hashMapWithCountOfDuplicatesValues.put(arrayListWithAllValues.get(i), 1);
        }
        return hashMapWithCountOfDuplicatesValues;
    }


    private static List<String> divideArrayListIntoWords(List<String> list) {
        char[] words;
        int begin = 0;
        ArrayList<String> listWords = new ArrayList<>();
        for (String line : list) {
            words = line.toCharArray();
            for (int i = 0; i < words.length; i++) {
                if (words[i] == ' ') {
                    if (begin - i == 0)
                        listWords.add(String.valueOf(Arrays.copyOfRange(words, begin, i + 1)));
                    else
                        listWords.add(String.valueOf(Arrays.copyOfRange(words, begin, i)));
                    begin = i + 1;
                } else if (i == words.length - 1)
                    listWords.add(String.valueOf(Arrays.copyOfRange(words, begin, i + 1)));
            }
            begin = 0;
            listWords.add("\0");
        }
        return listWords;
    }

    private static List<String> getArrayListWithoutWordsEndingWithS(List<String> arrayListWithSingleWords) {
        char[] wordFromArrayList;
        StringBuilder sentences = new StringBuilder();
        ArrayList<String> collectedFromSingleWordsToSentencesArrayList = new ArrayList<>();
        for (String arrayListLine : arrayListWithSingleWords) {
            if (arrayListLine.contains("\0")) {
                collectedFromSingleWordsToSentencesArrayList.add(sentences.substring(0, sentences.length() - 1));
                sentences = new StringBuilder();
            } else {
                wordFromArrayList = arrayListLine.toCharArray();
                if (wordFromArrayList[wordFromArrayList.length - 1] == 's' || wordFromArrayList[wordFromArrayList.length - 1] == 'S')
                    continue;
                if (wordFromArrayList.length == 1)
                    sentences.append(arrayListLine);
                else
                    sentences.append(arrayListLine).append(" ");
            }
        }
        return collectedFromSingleWordsToSentencesArrayList;
    }

}





