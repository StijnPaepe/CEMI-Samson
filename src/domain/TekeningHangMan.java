package domain;

import ui.TekeningApp;

public class TekeningHangMan extends Tekening {
    public TekeningHangMan() {
        super("HangMan");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        vormen.add(galgBodem);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
        vormen.add(galgStaaf);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
        vormen.add(hangbar);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
        vormen.add(koord);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
        hoofd.setZichtbaar(false);
        vormen.add(hoofd);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
        oogLinks.setZichtbaar(false);
        vormen.add(oogLinks);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//...
        oogRechts.setZichtbaar(false);
        vormen.add(oogRechts);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        neus.setZichtbaar(false);
        vormen.add(neus);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        mond.setZichtbaar(false);
        vormen.add(mond);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        lijf.setZichtbaar(false);
        vormen.add(lijf);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        beenLinks.setZichtbaar(false);
        vormen.add(beenLinks);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        beenRechts.setZichtbaar(false);
        vormen.add(beenRechts);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        voetLinks.setZichtbaar(false);
        vormen.add(voetLinks);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        voetRechts.setZichtbaar(false);
        vormen.add(voetRechts);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        armLinks.setZichtbaar(false);
        vormen.add(armLinks);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        armRechts.setZichtbaar(false);
        vormen.add(armRechts);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        handLinks.setZichtbaar(false);
        vormen.add(handLinks);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        handRechts.setZichtbaar(false);
        vormen.add(handRechts);
    }

    public int getAantalOnzichtbaar(){
        int teller = 0;
        for (Vorm vorm : vormen) {
            if (!vorm.isZichtbaar()) {
                teller++;
            }
        }
        return teller;
    }

    public void zetVolgendeZichtbaar(){
        for (Vorm vorm : vormen) {
            if (!vorm.isZichtbaar()) {
                vorm.setZichtbaar(true);
                break;
            }
        }
    }

    public void voegToe(Vorm vorm) {}

    public void verwijder(Vorm vorm) {}

}
