package ua.kovalev;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileToolTest {

    @Test
    void copyFiles() {

    }

    @Test
    void testCopyFile() {
        File fileSrc = new File("file1.txt.txt");
        File fileDest = new File("file2.txt");
        String text = "Hello World";

        try (OutputStream os = new FileOutputStream(fileSrc)) {
            fileSrc.createNewFile();
            os.write(text.getBytes());
            FileTool.copyFile(fileSrc, fileDest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream is = new FileInputStream(fileDest)){
            String str = new String(is.readAllBytes());
            assertTrue(str.equals(text));
            fileSrc.delete();
            fileDest.delete();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}