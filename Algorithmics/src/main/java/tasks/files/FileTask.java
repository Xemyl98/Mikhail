package tasks.files;

import tasks.files.utility.FilesUtility;

public class FileTask {
    public void getFilteredLogFile(String log,String filteredLog)
    {
        FilesUtility.testOnEmptyFile(log);
        FilesUtility.readFromFile(log);
        FilesUtility.removeIpPartFromCollection();
        FilesUtility.filteredLog(filteredLog);
    }
}


