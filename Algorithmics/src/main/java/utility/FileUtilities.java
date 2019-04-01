package utility;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FileUtilities {
    private static final Logger log = Logger.getLogger(FileUtilities.class.getName());
    public static ArrayList<String> readFromFile(String path) {
        File logfile = new File(path);
        ArrayList<String>dataFromFiles=new ArrayList<>();
        boolean fileExist = true;
        try {
            if (!logfile.exists())
                fileExist = logfile.createNewFile();
            if (fileExist) {
                BufferedReader in = new BufferedReader(new FileReader(logfile.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null)
                        dataFromFiles.add(s);
                } finally {
                    in.close();
                }
            } else
                throw new IOException();
        } catch (IOException e) {
            log.info(e.toString());
        }
        return dataFromFiles;
    }
    public static void writeInFile(String path, ArrayList<String> data)
    {
        try (FileWriter writer = new FileWriter(path)) {

            for (int i=0;i<data.size();i++)
                writer.write(data.get(i) + "\n");
            writer.flush();
        }
            catch (IOException ex) {
                log.info(ex.toString());
            }
    }
}
