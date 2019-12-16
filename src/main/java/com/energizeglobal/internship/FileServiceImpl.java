package com.energizeglobal.internship;

import java.io.File;
import java.util.Date;

public class FileServiceImpl implements FileService {
    @Override
    public String seeProperties(String filename) {
        File file = new File(filename);
        return new StringBuilder().append("Name: ").append(file.getName()).append(".\n")
                .append("Absolute path: ").append(file.getAbsolutePath()).append(".\n")
                .append("Size: ").append(file.length()).append("Bytes.\n")
                .append("Last modified: ")
                .append(new Date(file.lastModified())).append(".\n").toString();
    }

    @Override
    public String seeTree(String directoryName) {
        return null;
    }

    @Override
    public void copyFile(String fileName, String destinationFileName) {

    }

    @Override
    public void moveFile(String fileName, String destinationName) {

    }

    @Override
    public void renameFile(String fileName, String newName) {

    }

    @Override
    public String readDataFromFile(String filename) {
        return null;
    }

    @Override
    public void writeDataToFile(String fileName, String data) {

    }
}
