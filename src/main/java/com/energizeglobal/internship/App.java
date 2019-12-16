package com.energizeglobal.internship;
import static com.energizeglobal.internship.FileService.*;
public class App {

    private static final FileService fileService = new FileServiceImpl();

    public static void main(String[] args) {
        switch (args[0]) {
            case PROP: {
                System.out.println(fileService.seeProperties(args[1]));
            }
            case COPY:{
                break;
            }
            case TREE :{
                System.out.println(fileService.seeTree(args[1],0));
            }
            case MOVE:{
                break;
            }
            case RENAME:{
                break;
            }
            case READ:{
                break;
            }
            case WRITE:{
                break;
            }


        }
    }
}
