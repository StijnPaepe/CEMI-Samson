package ui;

import db.domain.WoordenLezer;
import domain.HintWoord;
import domain.Speler;
import domain.WoordenLijst;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;

public class WoordRadenApp {
    private Text hallo, woord, boodschap, proficiat;
    private HintWoord hintWoord;
    private Label invoerLetterLabel;
    private TextField invoerLetter;

    public WoordRadenApp(GridPane root, Speler speler) throws FileNotFoundException {
        hallo = new Text();
        hallo.setText("Rarara, welk woord zoeken we?");
        root.add(hallo, 0, 1);
        boodschap = new Text();
        root.add(boodschap, 0, 0);
        WoordenLijst lijst  = new WoordenLezer("hangman.txt").getWoordenlijst();
        String teRadenWoord = lijst.getRandomWoord();
        hintWoord = new HintWoord(teRadenWoord);
        woord = new Text();
        woord.setText(hintWoord.toString());
        root.add(woord, 0, 2);

        invoerLetterLabel = new Label("Geef een letter:");
        invoerLetter = new TextField();
        root.add(invoerLetterLabel, 0, 3);
        root.add(invoerLetter, 0, 4);
        proficiat = new Text();
        root.add(proficiat, 0, 5);
        invoerLetter.setOnAction(eventIngaveLetter -> {
            if(invoerLetter.getText().length() != 1){
                throw new UiException("Fout");
            }




            if (hintWoord.raad(invoerLetter.getText().charAt(0))){
                boodschap.setText("Super, doe zo voort!");
            }
            else{
                boodschap.setText("Helaas volgende keer beter!");
            }

            invoerLetter.clear();
            woord.setText(hintWoord.toString());


            if(hintWoord.isGeraden()){

                proficiat.setText("Goed gedaan " + speler.getNaam() + "! Je hebt het woord geraden!");
                invoerLetter.setDisable(true);
            }
        });
    }



}
