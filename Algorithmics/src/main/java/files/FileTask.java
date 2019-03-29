package files;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Logger;

public class FileTask {
    public static final String LOGFILTERED = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\filteredLog.txt";
    Logger logger = Logger.getLogger(FileTask.class.getName());
    private Map<String, Integer> ip = new TreeMap<>();
    private Map<String, Integer> time = new TreeMap<>();
    private Map<String, Integer> day = new TreeMap<>();
    private Map<String, Integer> maxTime = new TreeMap<>();

    public void collectionFilling(String line) {
        String subIp = deletePartOfLine(line, 1);
        String subTime = deletePartOfLine(line, 2).substring(0, 2);
        String subDay = deletePartOfLine(line, 3);
        if (maxTime.containsKey(subTime))
            maxTime.put(subTime, maxTime.get(subTime) + 1);
        else
            maxTime.put(subTime, 1);
        if (ip.containsKey(subIp)) {
            ip.put(subIp, ip.get(subIp) + 1);
            if (day.containsKey(subIp + " " + subDay))
                day.put(subIp + " " + subDay, day.get(subIp + " " + subDay) + 1);
            else
                day.put(subIp + " " + subDay, 1);
            if (time.containsKey(subIp + " " + subTime))
                time.put(subIp + " " + subTime, time.get(subIp + " " + subTime) + 1);
            else
                time.put(subIp + " " + subTime, 1);
        } else {
            ip.put(subIp, 1);
            day.put(subIp + " " + subDay, 1);
            time.put(subIp + " " + subTime, 1);
        }
    }

    private String[] loverDuplicatePartOfLine(Map<String, Integer> collection) {
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

    public void fileRead(String path) {
        File logfile = new File(path);
        try {
            if (!logfile.exists()) {
                logfile.createNewFile();
            }
            BufferedReader in = new BufferedReader(new FileReader(logfile.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null)
                    collectionFilling(s);
            } finally {
                in.close();
            }
        } catch (IOException e) {
            logger.info(e.toString());
        }
    }

    private void maxVisitFromOneIp(Map<String, Integer> collection) {
        String[] deleteDataInCollection = loverDuplicatePartOfLine(collection);
        for (int i = 0; i < deleteDataInCollection.length; i++)
            if (deleteDataInCollection[i] != null)
                collection.remove(deleteDataInCollection[i]);
            else
                break;

    }

    private String[] croppedCollection(Map<String, Integer> collection) {
        String[] collectionWithoutSecondPart = new String[collection.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            collectionWithoutSecondPart[i] = deletePartOfLine(entry.getKey(), 2) + " (" + entry.getValue() + ") ";
            i++;
        }
        return collectionWithoutSecondPart;
    }

    public void removeIpFromDayAndTime() {
        if(day.isEmpty()||time.isEmpty())
            throw new NullPointerException();
        maxVisitFromOneIp(day);
        maxVisitFromOneIp(time);
    }

    public void filteredLog() {
        String[] mostPopularDayWithoutIp = croppedCollection(day);
        String[] mostPopularTimeWithoutIp = croppedCollection(time);
        try (FileWriter writer = new FileWriter(LOGFILTERED)) {
            int i = 0;
            for (Map.Entry<String, Integer> entry : ip.entrySet()) {
                writer.write(entry.getKey() + " visited site " + entry.getValue() + " time " + mostPopularDayWithoutIp[i] + " " + mostPopularTimeWithoutIp[i] + "\n");
                i++;
            }
            writer.write("popular time is " + (Collections.max(maxTime.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey()));
            writer.flush();
        } catch (IOException ex) {
            logger.info(ex.toString());
        }
    }

    public String deletePartOfLine(String line, int stringPart) {
        StringTokenizer wordsOfLine = new StringTokenizer(line, " ");
        int i = 0;
        while (i < stringPart) {
            line = wordsOfLine.nextToken();
            i++;
        }
        return line;
    }
}


