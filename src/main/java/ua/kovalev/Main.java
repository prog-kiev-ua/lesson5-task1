package ua.kovalev;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileTool.copyFiles(new File("file1.txt"), new File("Folder2"), "txt");
        } catch (NoSuchFolderException | IOException e) {
            System.out.println(e);
        }
    }
}
