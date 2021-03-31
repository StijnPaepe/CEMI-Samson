package domain;

import java.util.Scanner;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
        this.isGeraden = false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char c){
        if (c == letter || letter == Character.toUpperCase(c) || letter == Character.toLowerCase(c)){
            if(isGeraden){
                return false;
            }
            isGeraden = true;
            return true;
        }
        return false;
    }


    public char toChar(){
        if(isGeraden){
            return letter;
        }
        return '_';
    }

    public boolean isGeraden() {
        return isGeraden;
    }
}
