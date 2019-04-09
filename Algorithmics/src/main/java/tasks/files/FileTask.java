package tasks.files;

import utility.files.FilesUtilities;

class FileTask {
    void getFileWithFilteredIpStatistics(String ipStatistics, String filteredIpStatistics,FilesUtilities filesUtilities) {
        filesUtilities.checkForAEmptyFile(ipStatistics);
        filesUtilities.readFromFileWithStatistics(ipStatistics);
        filesUtilities.removeIpPartFromCollection();
        filesUtilities.getFilteredIpStatistics(filteredIpStatistics);
    }
}

