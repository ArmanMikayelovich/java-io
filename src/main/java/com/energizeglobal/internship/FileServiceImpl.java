package com.energizeglobal.internship;

import java.io.File;
import java.util.Date;

public class FileServiceImpl implements FileService {
    @Override
    public String seeProperties(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return new StringBuilder().append("Type: ").append(file.isDirectory() ? "Directory\n" : " File\n")
                    .append("Name: ").append(file.getName()).append(".\n")
                    .append("Absolute path: ").append(file.getAbsolutePath()).append(".\n")
                    .append("Size: ").append(file.length()).append("Bytes.\n")
                    .append("Last modified: ")
                    .append(new Date(file.lastModified())).append(".\n").toString();
        } else {
            return "File/Directory not found";
        }
    }

    @Override
    public String seeTree(String directoryName, int tabCount) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            return "Directory not exist.";
        }

        StringBuilder treeBuilder = new StringBuilder();
        if (directory.isDirectory()) {
            treeBuilder.append(directory.getName()).append("\n");
            tabCount++;
            for (File file : directory.listFiles()) {
                if (!file.isDirectory()) {
                   appendMinuses(treeBuilder,tabCount);
                    treeBuilder.append(file.getName()).append("\n");
                } else {
                   appendMinuses(treeBuilder,tabCount);
                    treeBuilder.append(seeTree(file.getAbsolutePath(), tabCount)).append("\n");

                }
            }
        } else {
            treeBuilder.append("Not a directory");
        }
        return treeBuilder.toString();
    }

    private void appendMinuses(StringBuilder builder, int count) {
        for (int x = 0; x < count; x++) {
            builder.append("--");
        }
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
