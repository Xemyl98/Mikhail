package utility.files;

import tasks.exceptions.InvalidArgumentException;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class FilesUtilities {
    private static final Logger log = Logger.getLogger(FilesUtilities.class.getName());
    private Map<String, Integer> ip = new TreeMap<>();
    private Map<String, Integer> time = new TreeMap<>();
    private Map<String, Integer> day = new TreeMap<>();
    private Map<String, Integer> maxTime = new TreeMap<>();
    private ArrayList<String> theNamesOfTheDaysOfTheWeek = new ArrayList<>();

    public FilesUtilities() {
        fillingTheArrayListWithTheNamesOfTheDaysOfTheWeek();
    }

    public static ArrayList<String> readFromFileIntoArrayList(String path) {
        File logfile = new File(path);
        ArrayList<String> dataFromFiles = new ArrayList<>();
        boolean fileExist = true;
        try {
            if (!logfile.exists())
                fileExist = logfile.createNewFile();
            if (fileExist) {
                try (BufferedReader in = new BufferedReader(new FileReader(logfile.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null)
                        dataFromFiles.add(s);
                }
            } else
                throw new IOException();
        } catch (IOException e) {
            log.info(e.toString());
        }
        return dataFromFiles;
    }

    public static HashMap<String, Integer> readFromFileIntoHashMap(String path) {
        File logfile = new File(path);
        HashMap<String, Integer> dataFromFiles = new HashMap<>();
        boolean fileExist = true;
        try {
            if (!logfile.exists())
                fileExist = logfile.createNewFile();
            if (fileExist) {
                try (BufferedReader in = new BufferedReader(new FileReader(logfile.getAbsoluteFile()))) {
                    String s;
                    while ((s = in.readLine()) != null)
                        dataFromFiles.put(s, 1);
                }
            } else
                throw new IOException();
        } catch (IOException e) {
            log.info(e.toString());
        }
        return dataFromFiles;
    }

    public static void writeInFileArrayList(String path, ArrayList<String> inputArrayList) {
        try (FileWriter writer = new FileWriter(path)) {

            for (String datum : inputArrayList) writer.write(datum + "\n");
            writer.flush();
        } catch (IOException ex) {
            log.info(ex.toString());
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

    public void readFromLogFile(String path) {
        ArrayList<String> dataFromFile;
        dataFromFile = readFromFileIntoArrayList(path);
        for (String lineFromFile : dataFromFile) {
            checkForACorrectLineInput(lineFromFile);
            collectionFilling(lineFromFile);
        }
    }


    public void removeIpPartFromCollection() {
        if (day.isEmpty() || time.isEmpty())
            throw new NullPointerException();
        maxVisitFromOneIp(day);
        maxVisitFromOneIp(time);
    }

    public void filteredLog(String path) {
        ArrayList<String> outputData = new ArrayList<>();
        String[] mostPopularDayWithoutIp = collectionWithoutIp(day);
        String[] mostPopularTimeWithoutIp = collectionWithoutIp(time);
        int i = 0;
        for (Map.Entry<String, Integer> entry : ip.entrySet()) {
            outputData.add(entry.getKey() + " visited site " + entry.getValue() + " time " + mostPopularDayWithoutIp[i] + " " + mostPopularTimeWithoutIp[i]);
            i++;
        }
        outputData.add("popular time is " + (Collections.max(maxTime.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey()));
        writeInFileArrayList(path, outputData);
    }

    public void checkForAEmptyFile(String path) {
        if (readFromFileIntoArrayList(path).isEmpty())
            throw new NullPointerException();
    }

    private void collectionFilling(String line) {
        maxTimeCollectionFilling(getSubTime(line));
        if (ipCollectionContainsKey(getSubIp(line))) {
            ipCollectionFilling(getSubIp(line));
            dayCollectionFilling(getSubIp(line), getSubDay(line));
            timeCollectionFilling(getSubIp(line), getSubTime(line));
        } else
            insertUniqueValuesIntoCollection(getSubIp(line), getSubDay(line), getSubTime(line));
    }

    private void checkForACorrectLineInput(String lineFromFile) {
        try {
            checkForCorrectNumberOfSpaces(lineFromFile);
            checkForCorrectIp(lineFromFile);
            checkForCorrectTime(lineFromFile);
            checkForCorrectDayOfWeek(lineFromFile);
        } catch (InvalidArgumentException e) {
            log.info("Incorrect Data Input");
            throw new NullPointerException();
        }
    }

    private void fillingTheArrayListWithTheNamesOfTheDaysOfTheWeek() {
        theNamesOfTheDaysOfTheWeek.add("Monday");
        theNamesOfTheDaysOfTheWeek.add("Tuesday");
        theNamesOfTheDaysOfTheWeek.add("Wednesday");
        theNamesOfTheDaysOfTheWeek.add("Thursday");
        theNamesOfTheDaysOfTheWeek.add("Friday");
        theNamesOfTheDaysOfTheWeek.add("Saturday");
        theNamesOfTheDaysOfTheWeek.add("Sunday");
    }

    private void checkForCorrectNumberOfSpaces(String lineFromFile) throws InvalidArgumentException {
        char[] lineToCountTheNumberOfSpaces = lineFromFile.toCharArray();
        int countOfSpaces = 0;
        for (int i = 0; i < lineToCountTheNumberOfSpaces.length; i++) {
            if (lineToCountTheNumberOfSpaces[i] == ' ')
                countOfSpaces++;
        }
        if (countOfSpaces != 2)
            throw new InvalidArgumentException("Missing part of the data");
    }

    private void checkForCorrectIp(String lineFromFile) throws InvalidArgumentException {
        char[] lineToCountPointsInIp = getSubIp(lineFromFile).toCharArray();
        int countOfPoints = 0;
        for (int i = 0; i < lineToCountPointsInIp.length; i++) {
            if (lineToCountPointsInIp[i] == '.')
                countOfPoints++;
        }
        if (countOfPoints != 3)
            throw new InvalidArgumentException("Incorrect ip");
    }

    private void checkForCorrectTime(String lineFromFile) throws InvalidArgumentException {
        checkForCorrectTimeLimits(lineFromFile);
        checkForCorrectCountOfColonsInTime(lineFromFile);

    }

    private void checkForCorrectCountOfColonsInTime(String lineFromFile) throws InvalidArgumentException {
        char[] lineToCountColonInTime = deletePartOfLine(lineFromFile, 2).toCharArray();
        int countOfColons = 0;
        for (int i = 0; i < lineToCountColonInTime.length; i++) {
            if (lineToCountColonInTime[i] == ':')
                countOfColons++;
        }
        if (countOfColons != 2)
            throw new InvalidArgumentException("Invalid Counts Of Colons");
    }

    private void checkForCorrectTimeLimits(String lineFromFile) {
        try {
            int checkHours = Integer.valueOf(getSubTime(lineFromFile));
            int checkMinutes = Integer.valueOf(deletePartOfLine(lineFromFile, 2).substring(3, 5));
            int checkSeconds = Integer.valueOf(deletePartOfLine(lineFromFile, 2).substring(6, 8));
            if (checkHours > 23 || checkHours < 0)
                throw new InvalidArgumentException("Incorrect Hours");
            if (checkMinutes > 59 || checkMinutes < 0)
                throw new InvalidArgumentException("Incorrect Minutes");
            if (checkSeconds > 59 || checkSeconds < 0)
                throw new InvalidArgumentException("Incorrect Seconds");
        } catch (InvalidArgumentException e) {
           log.info("Incorrect Data Time Limits");
        }

    }

    private void checkForCorrectDayOfWeek(String lineFromFile) throws InvalidArgumentException {

        if (!theNamesOfTheDaysOfTheWeek.contains(getSubDay(lineFromFile)))
            throw new InvalidArgumentException("Invalid Day Of Week");
    }

    private String[] collectionWithoutIp(Map<String, Integer> collection) {
        String[] croppedCollection = new String[collection.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            croppedCollection[i] = deletePartOfLine(entry.getKey(), 2) + " (" + entry.getValue() + ") ";
            i++;
        }
        return croppedCollection;
    }

    private String getSubIp(String line) {
        return deletePartOfLine(line, 1);
    }

    private String getSubTime(String line) {
        return deletePartOfLine(line, 2).substring(0, 2);
    }

    private String getSubDay(String line) {
        return deletePartOfLine(line, 3);
    }

    private void insertUniqueValuesIntoCollection(String subIp, String subDay, String subTime) {
        ip.put(subIp, 1);
        day.put(subIp + " " + subDay, 1);
        time.put(subIp + " " + subTime, 1);
    }

    private boolean ipCollectionContainsKey(String key) {
        return ip.containsKey(key);
    }

    private void maxTimeCollectionFilling(String subTime) {
        if (maxTime.containsKey(subTime))
            maxTime.put(subTime, maxTime.get(subTime) + 1);
        else
            maxTime.put(subTime, 1);
    }

    private void ipCollectionFilling(String subIp) {
        ip.put(subIp, ip.get(subIp) + 1);
    }

    private void dayCollectionFilling(String subIp, String subDay) {
        if (day.containsKey(subIp + " " + subDay))
            day.put(subIp + " " + subDay, day.get(subIp + " " + subDay) + 1);
        else
            day.put(subIp + " " + subDay, 1);
    }

    private void timeCollectionFilling(String subIp, String subTime) {
        if (time.containsKey(subIp + " " + subTime))
            time.put(subIp + " " + subTime, time.get(subIp + " " + subTime) + 1);
        else
            time.put(subIp + " " + subTime, 1);
    }

    private void maxVisitFromOneIp(Map<String, Integer> collection) {
        String[] deleteDataInCollection = getDuplicateLinesWithLoverValues(collection);
        for (int i = 0; i < deleteDataInCollection.length; i++)
            if (deleteDataInCollection[i] != null)
                collection.remove(deleteDataInCollection[i]);
            else
                continue;

    }

    private String[] getDuplicateLinesWithLoverValues(Map<String, Integer> collection) {
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

    private String deletePartOfLine(String line, int stringPart) {
        StringTokenizer wordsOfLine = new StringTokenizer(line, " ");
        int i = 0;
        while (i < stringPart) {
            line = wordsOfLine.nextToken();
            i++;
        }
        return line;
    }

}
