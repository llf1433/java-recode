package io;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.java");
        file.createNewFile();
        //file.mkdir();


    }
}
