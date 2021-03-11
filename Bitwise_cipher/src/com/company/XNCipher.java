package com.company;
import java.io.*;

/*
Author: Nino Arisona
Made on: 4.3.2021
Description: Basic Cipher using bitwise to switch chars in UTF-32
*/
public class XNCipher {

    public void file(String absolute_path,int shift) throws IOException {
        File file = new File(absolute_path);                            //get file
        BufferedReader br = new BufferedReader(new FileReader(file));   //make BufferedReader
        StringBuilder content = new StringBuilder();                    //make StringBuilder
        String line;                                                    //declare String for
        while((line = br.readLine()) != null){                          //read all lines in text
            char [] char_arr = line.toCharArray();                      //line to char array
            for( char value : char_arr){
                value = (char) ~((int) value);                          //NOT bitwise
                value = (char) ((int) value ^ shift);                   //XOR bitwise using inputted Shift
                content.append(value);                                  //append new vale
            }
            content.append("\n");                                       //add line break after line
        }
        FileWriter writer = new FileWriter(file);                       //write file
        writer.write(content.toString());
        writer.close();
    }
}
