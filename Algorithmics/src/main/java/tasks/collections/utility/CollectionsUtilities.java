package tasks.collections.utility;

import utility.CommonUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CollectionsUtilities {


    Tree left = null;
    Tree right = null;
    int data = 0;

    public CollectionsUtilities(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }


    public static ArrayList<String> getListWithoutSEndingWords(ArrayList<String> list) {
        list = divideArrayListByWords(list);
        list = PickingUpAnArayListWithoutWordsEndingInS(list);
        return list;
    }

    public static HashMap<Integer, Integer> getCountOfRepetitionsAfterRandomGeneration() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int randomValue=CommonUtilities.getRandomValue(100);
            if(map.containsKey(randomValue))
                map.put(randomValue,map.get(randomValue)+1);
            else
                map.put(randomValue,1);
        }
        return map;
    }

    private static ArrayList<String> divideArrayListByWords(ArrayList<String> list) {
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

    private static ArrayList<String> PickingUpAnArayListWithoutWordsEndingInS(ArrayList<String> list) {
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

    public static class Tree {
        public Tree left = null;
        public Tree right = null;
        public int data = 0;

        public Tree(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}




