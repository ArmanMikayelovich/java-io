package com.energizeglobal.internship;

import java.io.IOException;

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

    String PROP = "PROP";//ok
    String COPY = "COPY";//ok
    String TREE = "TREE";//ok
    String MOVE = "MOVE";//ok
    String RENAME = "RENAME";//ok
    String READ = "READ";//ok
    String WRITE = "WRITE";//ok

    String seeProperties(String filename);

    String seeTree(String directoryName, int tabCount);

    void copyFile(String fileName, String destinationFileName) throws IOException;

    void moveFile(String fileName, String destinationName) throws IOException;

    void renameFile(String fileName, String newName) throws IOException;

    String readDataFromFile(String filename) throws IOException;

    void writeDataToFile(String fileName, String data) throws IOException;

}
