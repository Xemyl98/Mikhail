package utils.files;

import tasks.exceptions.InvalidArgumentException;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class FileUtils {
    private FileUtils() {
    }

    private static final Logger log = Logger.getLogger(FileUtils.class.getName());
    private static Map<String, Integer> ip = new TreeMap<>();
    private static Map<String, Integer> time = new TreeMap<>();
    private static Map<String, Integer> day = new TreeMap<>();
    private static Map<String, Integer> maxTime = new TreeMap<>();
    private static List<String> NamesOfTheDaysOfTheWeek = new ArrayList<>();

    static {
        NamesOfTheDaysOfTheWeek.add("Monday");
        NamesOfTheDaysOfTheWeek.add("Tuesday");
        NamesOfTheDaysOfTheWeek.add("Wednesday");
        NamesOfTheDaysOfTheWeek.add("Thursday");
        NamesOfTheDaysOfTheWeek.add("Friday");
        NamesOfTheDaysOfTheWeek.add("Saturday");
        NamesOfTheDaysOfTheWeek.add("Sunday");
    }

    public static List<String> readDataFromFileToArrayList(String path) {
        File logfile = new File(path);
        List<String> dataFromFiles = new ArrayList<>();
        boolean fileExist = true;
        try {
            if (!logfile.exists()) {
                fileExist = logfile.createNewFile();
            }
            if (fileExist) {
                try (BufferedReader in = new BufferedReader(new FileReader(logfile.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        dataFromFiles.add(s);
                    }
                }
            } else
                throw new IOException();
        } catch (IOException e) {
            log.info(e.toString());
        }
        return dataFromFiles;
    }

    public static void writeInFileArrayList(String path, List<String> inputArrayList) {
        try (FileWriter writer = new FileWriter(path)) {

            for (String datum : inputArrayList) writer.write(datum + "\n");
            {
                writer.flush();
            }
        } catch (IOException ex) {
            log.info(ex.toString());
        }
    }

    public static void fileIsEmpty(String path) {
        if (readDataFromFileToArrayList(path).isEmpty()) {
            throw new NullPointerException("File is empty");
        }
    }

    public static void writeInFileString(String path, String inputText) {
        try (FileWriter writer = new FileWriter(path)) {

            writer.write(inputText + "\n");
            writer.flush();
        } catch (IOException ex) {
            log.info(ex.toString());
        }
    }

    public static void readFromFileWithStatistics(String path) {
        final List<String> dataFromFile = readDataFromFileToArrayList(path);
        for (String lineFromFile : dataFromFile) {
            validationOfLine(lineFromFile);
            collectionFilling(lineFromFile);
        }
    }


    public static void removeIpPartFromCollection() {
        maxVisitFromOneIp(day);
        maxVisitFromOneIp(time);
    }

    public static void getFilteredIpStatistics(String path) {
        List<String> outputData = new ArrayList<>();
        final String[] mostPopularDayWithoutIp = collectionWithoutIp(day);
        final String[] mostPopularTimeWithoutIp = collectionWithoutIp(time);
        int i = 0;
        for (Map.Entry<String, Integer> entry : ip.entrySet()) {
            outputData.add(entry.getKey() + " visited site " + entry.getValue() + " time " + mostPopularDayWithoutIp[i] + " " + mostPopularTimeWithoutIp[i]);
            i++;
        }
        outputData.add("popular time is " + (Collections.max(maxTime.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey()));
        writeInFileArrayList(path, outputData);
    }

    private static void collectionFilling(String lineFromFile) {
        maxTimeCollectionFilling(getSubTime(lineFromFile));
        if (ipCollectionContainsKey(getSubIp(lineFromFile))) {
            ipCollectionFilling(getSubIp(lineFromFile));
            dayCollectionFilling(getSubIp(lineFromFile), getSubDay(lineFromFile));
            timeCollectionFilling(getSubIp(lineFromFile), getSubTime(lineFromFile));
        } else
            insertUniqueValuesIntoCollection(getSubIp(lineFromFile), getSubDay(lineFromFile), getSubTime(lineFromFile));
    }

    private static void validationOfLine(String lineFromFile) {
        try {
            checkNumberOfSpacesInLineFromFile(lineFromFile);
            checkIpInLineFromFile(lineFromFile);
            checkTimeInLineFromFile(lineFromFile);
            checkDayOfWeekInLineFromFile(lineFromFile);
        } catch (InvalidArgumentException e) {
            throw new IllegalArgumentException("Incorrect Data Input");
        }
    }

    private static void checkNumberOfSpacesInLineFromFile(String lineFromFile) throws InvalidArgumentException {
        final char[] lineToCountTheNumberOfSpaces = lineFromFile.toCharArray();
        int countOfSpaces = 0;
        for (int i = 0; i < lineToCountTheNumberOfSpaces.length; i++) {
            if (lineToCountTheNumberOfSpaces[i] == ' ') {
                countOfSpaces++;
            }
        }
        if (countOfSpaces != 2)
            throw new InvalidArgumentException("Missing part of the data");
    }

    private static void checkIpInLineFromFile(String lineFromFile) throws InvalidArgumentException {
        final char[] lineToCountPointsInIp = getSubIp(lineFromFile).toCharArray();
        int countOfPoints = 0;
        for (int i = 0; i < lineToCountPointsInIp.length; i++) {
            if (lineToCountPointsInIp[i] == '.') {
                countOfPoints++;
            }
        }
        if (countOfPoints != 3) {
            throw new InvalidArgumentException("Incorrect ip");
        }
    }

    private static void checkTimeInLineFromFile(String lineFromFile) throws InvalidArgumentException {
        checkTimeLimits(lineFromFile);
        checkCountOfColonsInTime(lineFromFile);

    }

    private static void checkCountOfColonsInTime(String lineFromFile) throws InvalidArgumentException {
        final char[] lineToCountColonInTime = deletePartOfLine(lineFromFile, 2).toCharArray();
        int countOfColons = 0;
        for (int i = 0; i < lineToCountColonInTime.length; i++) {
            if (lineToCountColonInTime[i] == ':')
                countOfColons++;
        }
        if (countOfColons != 2)
            throw new InvalidArgumentException("Invalid Counts Of Colons");
    }

    private static void checkTimeLimits(String lineFromFile) {
        try {
            final int checkHours = Integer.parseInt(getSubTime(lineFromFile));
            final int checkMinutes = Integer.parseInt(deletePartOfLine(lineFromFile, 2).substring(3, 5));
            final int checkSeconds = Integer.parseInt(deletePartOfLine(lineFromFile, 2).substring(6, 8));
            if (checkHours > 23 || checkHours < 0) {
                throw new InvalidArgumentException("Incorrect Hours");
            }
            if (checkMinutes > 59 || checkMinutes < 0) {
                throw new InvalidArgumentException("Incorrect Minutes");
            }
            if (checkSeconds > 59 || checkSeconds < 0) {
                throw new InvalidArgumentException("Incorrect Seconds");
            }
        } catch (InvalidArgumentException e) {
            log.info("Incorrect Data Time Limits");
        }

    }

    private static void checkDayOfWeekInLineFromFile(String lineFromFile) throws InvalidArgumentException {

        if (!NamesOfTheDaysOfTheWeek.contains(getSubDay(lineFromFile))) {
            throw new InvalidArgumentException("Invalid Day Of Week");
        }
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
        return ip.containsKey(key);
    }

    private static void maxTimeCollectionFilling(String subTime) {
        if (maxTime.containsKey(subTime)) {
            maxTime.put(subTime, maxTime.get(subTime) + 1);
        } else {
            maxTime.put(subTime, 1);
        }
    }

    private static void ipCollectionFilling(String subIp) {
        ip.put(subIp, ip.get(subIp) + 1);
    }

    private static void dayCollectionFilling(String subIp, String subDay) {
        dayOrTimeCollectionFilling(subIp, subDay, day);
    }

    private static void timeCollectionFilling(String subIp, String subTime) {
        dayOrTimeCollectionFilling(subIp, subTime, time);
    }

    private static void dayOrTimeCollectionFilling(String subIp, String subTime, Map<String, Integer> collection) {
        if (collection.containsKey(subIp + " " + subTime)) {
            collection.put(subIp + " " + subTime, collection.get(subIp + " " + subTime) + 1);
        } else {
            collection.put(subIp + " " + subTime, 1);
        }
    }


    private static void maxVisitFromOneIp(Map<String, Integer> collection) {
        final String[] deleteDataInCollection = getDuplicateLinesWithLoverValues(collection);
        for (int i = 0; i < deleteDataInCollection.length; i++) {
            if (deleteDataInCollection[i] != null) {
                collection.remove(deleteDataInCollection[i]);
            }
        }

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
        final StringTokenizer wordsOfLine = new StringTokenizer(line, " ");
        int i = 0;
        while (i < stringPart) {
            line = wordsOfLine.nextToken();
            i++;
        }
        return line;
    }

}
