package pl.coderslab.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {

    public static String[] getData() {

        //in this file on server the data for email to be sent from is stored

        File file = new File("/usr/local/bin/data.txt");
        String[] data = new String[2];

        //scanner object reading file

        try (Scanner scan = new Scanner(file)) {
            //read lines from file
             data[0] = scan.nextLine();
             data[1] = scan.nextLine();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return data;
    }

}
