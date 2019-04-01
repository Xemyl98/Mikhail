package tasks.files.utility;

import utility.FileUtilities;

import java.util.*;

public class FilesUtility {
    private static Map<String, Integer> ip = new TreeMap<>();
    private static Map<String, Integer> time = new TreeMap<>();
    private static Map<String, Integer> day = new TreeMap<>();
    private static Map<String, Integer> maxTime = new TreeMap<>();

    public static void readFromFile(String path) {
        ArrayList<String> dataFromFile;
        dataFromFile = FileUtilities.readFromFile(path);
        for (int i = 0; i < dataFromFile.size(); i++)
            collectionFilling(dataFromFile.get(i));

    }

    public static void removeIpPartFromCollection() {
        if (day.isEmpty() || time.isEmpty())
            throw new NullPointerException();
        maxVisitFromOneIp(day);
        maxVisitFromOneIp(time);
    }

    public static void filteredLog(String path) {
        ArrayList<String> outputData = new ArrayList<>();
        String[] mostPopularDayWithoutIp = collectionWithoutIp(day);
        String[] mostPopularTimeWithoutIp = collectionWithoutIp(time);
        int i = 0;
        for (Map.Entry<String, Integer> entry : ip.entrySet()) {
            outputData.add(entry.getKey() + " visited site " + entry.getValue() + " time " + mostPopularDayWithoutIp[i] + " " + mostPopularTimeWithoutIp[i]);
            i++;
        }
        outputData.add("popular time is " + (Collections.max(maxTime.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey()));
        FileUtilities.writeInFile(path, outputData);
    }

    public static void testOnEmptyFile(String path)
    {
        if(FileUtilities.readFromFile(path).isEmpty())
            throw new NullPointerException();
    }

    private static void collectionFilling(String line) {
        maxTimeCollectionFilling(getSubTime(line));
        if (ipCollectionContainsKey(getSubIp(line))) {
            ipCollectionFilling(getSubIp(line));
            dayCollectionFilling(getSubIp(line), getSubDay(line));
            timeCollectionFilling(getSubIp(line), getSubTime(line));
        } else
            insertUniqueValuesIntoCollection(getSubIp(line), getSubDay(line), getSubTime(line));

    }

    private static String[] collectionWithoutIp(Map<String, Integer> collection) {
        String[] croppedCollection = new String[collection.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            croppedCollection[i] = deletePartOfLine(entry.getKey(), 2) + " (" + entry.getValue() + ") ";
            i++;
        }
        return croppedCollection;
    }

    private static String getSubIp(String line) {
        return deletePartOfLine(line, 1);
    }

    private static String getSubTime(String line) {
        return deletePartOfLine(line, 2).substring(0, 2);
    }

    private static String getSubDay(String line) {
        return deletePartOfLine(line, 3);
    }

    private static void insertUniqueValuesIntoCollection(String subIp, String subDay, String subTime) {
        ip.put(subIp, 1);
        day.put(subIp + " " + subDay, 1);
        time.put(subIp + " " + subTime, 1);
    }

    private static boolean ipCollectionContainsKey(String key) {
        if (ip.containsKey(key))
            return true;
        else
            return false;
    }

    private static void maxTimeCollectionFilling(String subTime) {
        if (maxTime.containsKey(subTime))
            maxTime.put(subTime, maxTime.get(subTime) + 1);
        else
            maxTime.put(subTime, 1);
    }

    private static void ipCollectionFilling(String subIp) {
        ip.put(subIp, ip.get(subIp) + 1);
    }

    private static void dayCollectionFilling(String subIp, String subDay) {
        if (day.containsKey(subIp + " " + subDay))
            day.put(subIp + " " + subDay, day.get(subIp + " " + subDay) + 1);
        else
            day.put(subIp + " " + subDay, 1);
    }

    private static void timeCollectionFilling(String subIp, String subTime) {
        if (time.containsKey(subIp + " " + subTime))
            time.put(subIp + " " + subTime, time.get(subIp + " " + subTime) + 1);
        else
            time.put(subIp + " " + subTime, 1);
    }

    private static void maxVisitFromOneIp(Map<String, Integer> collection) {
        String[] deleteDataInCollection = getDuplicateLinesWithLoverValues(collection);
        for (int i = 0; i < deleteDataInCollection.length; i++)
            if (deleteDataInCollection[i] != null)
                collection.remove(deleteDataInCollection[i]);
            else
                continue;

    }

    private static String[] getDuplicateLinesWithLoverValues(Map<String, Integer> collection) {
        String previousIp = null;
        String previousPartAfterIp = null;
        String[] duplicatePart = new String[collection.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            if (previousIp == null) {
                previousIp = deletePartOfLine(entry.getKey(), 1);
                previousPartAfterIp = deletePartOfLine(entry.getKey(), 2);
            } else {
                if (previousIp.equals(deletePartOfLine(entry.getKey(), 1))) {
                    if (collection.get(entry.getKey()) <= collection.get(previousIp + " " + previousPartAfterIp)) {
                        duplicatePart[i] = entry.getKey();
                        i++;
                    } else {
                        duplicatePart[i] = previousIp + " " + previousPartAfterIp;
                        i++;
                    }
                } else {
                    previousIp = deletePartOfLine(entry.getKey(), 1);
                    previousPartAfterIp = deletePartOfLine(entry.getKey() + " ", 2);
                }
            }
        }
        return duplicatePart;
    }

    private static String deletePartOfLine(String line, int stringPart) {
        StringTokenizer wordsOfLine = new StringTokenizer(line, " ");
        int i = 0;
        while (i < stringPart) {
            line = wordsOfLine.nextToken();
            i++;
        }
        return line;
    }

}
