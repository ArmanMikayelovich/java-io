package com.energizeglobal.internship;
/**
 * PROP - see properties of the file
 * TREE - see all files and inner directories of folder
 * COPY  - Copy file to directory
 * MOVE - Move file to directory
 * RENAME - rename file
 * READ - read data from file and show in console
 * WRITE - write data to file
 */
public interface FileService {
    String PROP = "PROP";
    String COPY = "COPY";
    String TREE = "TREE";
    String MOVE = "MOVE";
    String RENAME = "RENAME";
    String READ = "READ";
    String WRITE = "WRITE";

    String seeProperties(String filename);

    String seeTree(String directoryName, int tabCount);

    void copyFile(String fileName, String destinationFileName);

    void moveFile(String fileName, String destinationName);

    void renameFile(String fileName, String newName);

    String readDataFromFile(String filename);

    void writeDataToFile(String fileName, String data);

}
