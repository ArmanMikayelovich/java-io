package com.energizeglobal.internship;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import static com.energizeglobal.internship.FileService.*;

public class App {

    private static final FileService fileService = new FileServiceImpl();

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Need operation and minimum one argument.");
            return;
        }

        try {
            doOperation(args);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (FileAlreadyExistsException fileAlreadyExistsException) {
            System.out.println("File already exists: " + fileAlreadyExistsException.getFile());
        } catch (IOException iOException) {
            System.out.println(iOException.getCause().getMessage());
        }

    }

    private static void doOperation(String[] args) throws IOException {
        switch (args[0]) {
            case PROP: {
                checkArguments(args, 2);
                System.out.println(fileService.seeProperties(args[1]));
                break;
            }
            case COPY: {
                checkArguments(args, 3);
                fileService.copyFile(args[1], args[2]);
                break;
            }
            case TREE: {
                checkArguments(args, 2);
                System.out.println(fileService.seeTree(args[1], 0));
                break;
            }
            case MOVE: {
                checkArguments(args, 3);
                fileService.moveFile(args[1], args[2]);
                break;
            }
            case RENAME: {
                checkArguments(args, 3);
                fileService.renameFile(args[1], args[2]);
                break;
            }
            case READ: {
                checkArguments(args, 2);
                System.out.println(fileService.readDataFromFile(args[1]));
                break;
            }
            case WRITE: {
                checkArguments(args, 3);
                fileService.writeDataToFile(args[1], args[2]);
                break;
            }
            default:{
                System.out.println("Not acceptable command.");
            }
        }
    }


    private static void checkArguments(String[] array, int argCount) {
        if (array.length != argCount) {
            throw new IllegalArgumentException(String.format("The Operation needs %s arguments", argCount));
        }
    }

}
