package com.company;
import java.io.*;

public class XNCipher {

    static void encode(String path,int shift) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String content = "";
        String line;
        while((line = br.readLine()) != null){
            char [] char_arr = line.toCharArray();
            for( char value : char_arr){
                value = (char) ~((int) value);
                value = (char) ((int) value ^ shift);
                content += value;
            }
            content += "\n";
        }
        System.out.print(content);
    }
}
