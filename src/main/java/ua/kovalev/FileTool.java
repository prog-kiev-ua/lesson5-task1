package ua.kovalev;

import java.io.*;
import java.util.Arrays;

public class FileTool {
    public static void copyFiles(File folderSrc, File folderDest, String ext) throws IOException, NoSuchFolderException {

        // если один или оба передаваемые каталога являются файлами
        if (folderSrc.isFile() || folderDest.isFile()) throw new NoSuchFolderException("Ресурс не является каталогом");

        for (File fileSrc : folderSrc.listFiles()) {

            // если не каталог
            if (!fileSrc.isFile()) continue;

            // если нет точки в названии
            int indPoint = fileSrc.getName().lastIndexOf(".");
            if (indPoint == -1) {
                continue;
            }

            String extfile = fileSrc.getName().substring(indPoint + 1);

            // если расширение не соответствует фильтру
            if (!extfile.equals(ext)) continue;

            File fileDest = new File(folderDest, fileSrc.getName());

            copyFile(fileSrc, fileDest);
        }
    }

    public static void copyFile(File fileSrc, File fileDest) throws IOException {
        try (InputStream is = new FileInputStream(fileSrc);
             OutputStream os = new FileOutputStream(fileDest)) {
            is.transferTo(os);
        }
    }

    public static boolean compare(File file1, File file2) throws IOException {
        int size = 10000;
        try (InputStream is1 = new FileInputStream(file1); InputStream is2 = new FileInputStream(file2)) {
            while (true) {
                byte[] arr1 = new byte[size];
                byte[] arr2 = new byte[size];

                int readed1 = is1.read(arr1);
                int readed2 = is2.read(arr2);

                // если конец файла у обоих файлов
                if (readed1 == -1 && readed2 == -1) {
                    return true;
                }

                // если количество считанных байтов не одинаково
                if (readed1 != readed2) {
                    return false;
                }

                // если массивы считанных байтов не одинаковые
                if (!Arrays.equals(arr1, arr2)) {
                    return false;
                }
            }
        }
    }
}
