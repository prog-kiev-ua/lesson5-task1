package ua.kovalev;

import java.io.*;

public class FileTool {
    public static void copyFiles(File folderSrc, File folderDest, String ext) throws IOException, NoSuchFolderException{

        // если один или оба передаваемые каталога являются файлами
        if(folderSrc.isFile() || folderDest.isFile()) throw new NoSuchFolderException("Ресурс не является каталогом");

        for (File fileSrc : folderSrc.listFiles()){

            // если не каталог
            if(!fileSrc.isFile()) continue;

            // если нет точки в названии
            int indPoint = fileSrc.getName().lastIndexOf(".");
            if(indPoint == -1){
                continue;
            }

            String extfile = fileSrc.getName().substring(indPoint+1);

            // если расширение не соответствует фильтру
            if(!extfile.equals(ext)) continue;

            File fileDest = new File(folderDest, fileSrc.getName());

            copyFile(fileSrc, fileDest);
        }
    }

    public static void copyFile(File fileSrc, File fileDest) throws IOException {
        try(InputStream is = new FileInputStream(fileSrc);
            OutputStream os = new FileOutputStream(fileDest)){
            is.transferTo(os);
        }
    }
}
