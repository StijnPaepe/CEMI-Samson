
package db.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("C:\\Users\\Thomas\\Documents\\Projectweek2VanProject 1/hangman.txt");

        Scanner scnr = new Scanner(text);

        int lineNumber = 1;
        while(scnr.hasNextLine()) {
            String line = scnr.nextLine();
            System.out.println(" " + line);
            lineNumber++;
        }
    }
}
