package tasks.files;

import utils.files.FileUtils;

class FileTask {
    public void getFileWithFilteredIpStatistics(String ipStatistics, String filteredIpStatistics) {
        FileUtils.fileIsEmpty(ipStatistics);
        FileUtils.readFromFileWithStatistics(ipStatistics);
        FileUtils.removeIpPartFromCollection();
        FileUtils.getFilteredIpStatistics(filteredIpStatistics);
    }
}

