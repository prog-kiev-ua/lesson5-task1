package ua.kovalev;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 3 && args[0].equals("-c")) {
            try {
                String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                File fileJar = new File(path);
                File folder = fileJar.getParentFile();

                File file1 = new File(folder, args[1]);
                File file2 = new File(folder, args[2]);

                if (!file1.exists() || !file2.exists()) {
                    System.out.println("Указан не верный параметр!");
                }

                boolean resultCompare = FileTool.compare(file1, file2);

                System.out.println(String.format("Файлы [%s] и [%s] %s", file1.getName(), file2.getName(), (resultCompare ? "одинаковые" : "разные")));

            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try {
                FileTool.copyFiles(new File("file1.txt"), new File("Folder2"), "txt");
            } catch (NoSuchFolderException | IOException e) {
                System.out.println(e);
            }
        }
    }
}
