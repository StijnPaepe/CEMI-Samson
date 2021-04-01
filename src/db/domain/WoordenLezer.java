
package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
        private WoordenLijst lijst;
        public WoordenLezer(String  fileNaam) throws FileNotFoundException {
            this.lijst = new WoordenLijst();
        File text = new File(fileNaam);
        Scanner scnr = new Scanner(text);
            while(scnr.hasNextLine()) {
            String line = scnr.nextLine();
            this.lijst.voegToe(line);

        }
    }

    public WoordenLijst getWoordenlijst(){
            return this.lijst;
    }
}
