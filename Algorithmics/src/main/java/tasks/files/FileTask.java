package tasks.files;

import utility.files.FilesUtilities;

 class FileTask {
     void getFilteredLogFile(String log,String filteredLog)
    {
        FilesUtilities filesUtilities=new FilesUtilities();
        filesUtilities.checkForAEmptyFile(log);
        filesUtilities.readFromLogFile(log);
        filesUtilities.removeIpPartFromCollection();
        filesUtilities.filteredLog(filteredLog);
    }
}

