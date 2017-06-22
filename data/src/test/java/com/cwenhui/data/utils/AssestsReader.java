package com.cwenhui.data.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import timber.log.Timber;

public class AssestsReader {

    /**
     * @param path assets目录下，相对路径
     * @Return
     * @Throws IOException
     */
    public static String readFile(String path) throws IOException {

        File file0 = new File("../app/src/androidTest/assets/", path);
        File file1 = new File("../app/src/main/assets/", path);
        File file2 = new File("../app/src/test/assets/", path);

        File file;

        if (file0.exists()) {
            file = file0;
        } else if (file1.exists()) {
            file = file1;
        } else {
            file = file2;
        }

        FileReader fileReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader(file);

            char[] chars = new char[1024];

            int hasRead;

            while ((hasRead = fileReader.read(chars)) > -1) {
                sb.append(chars, 0, hasRead);
            }

        } catch (IOException e) {
            Timber.e(e);
        } finally {
            fileReader.close();
            return sb.toString();
        }

    }

//    @test
//    public void readFile() throws IOException {
//        System.out.println(AssestsReader.readFile("success.json"));
//    }
}