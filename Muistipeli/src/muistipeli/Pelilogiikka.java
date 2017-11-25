/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import kayttoliittyma.Matriisi;

/**
 * Luokkaan on koottu pelissä tarvittavia metodeja.
 *
 * @author Henna
 */
public class Pelilogiikka {
    
    /**
     * Metodi näyttää vastauksen.
     * Metodi hakee ruudukosta oikean sisältötiedon ja kutsuu sitten toista 
     * metodia, joka sijoittaa tähden paikalle sisällön.
     * 
     * @param peli peliruudukko
     * @param tahdet tähtimatriisi
     * @param rivi rivien määrä
     * @param sarake sarakkeiden määrä
     * @return sisältö
     */
    
    public static int koordinaatisto(Ruudukko peli, Matriisi tahdet, int rivi, int sarake){
        int sisalto = peli.getSisalto(rivi, sarake);
        tahdet.sijoitus(rivi, sarake, sisalto);
        return sisalto;
    }
    
    /**
     * Metodi tarkistaa onko saatu arvo yli nollan.
     * 
     * @param rivi rivien määrä
     * @param sarake sarakkeiden määrä
     * @return true jos olivat yli nollan, muuten false
     */
    
    public static boolean arvotOikein(int rivi, int sarake){
        boolean minNolla = false;
        
        if(rivi >= 0 && sarake >= 0){
            minNolla = true;
        }
        return minNolla;
    }
    
    /**
     * Metodi tarkistaa, että ruudukossa on parillinen määrä laattoja.
     * 
     * @param rivi rivien määrä
     * @param sarake sarakkeiden määrä
     * @return jos parillinen määrä niin true, muuten false
     */
    
    public static boolean parillinenMaaraLaattoja(int rivi, int sarake){
        boolean laattojenmaara = false;
        int laatat = rivi*sarake;
        int parillinen = laatat%2;
        
        if(parillinen == 0){
            laattojenmaara = true;
        }
        
        return laattojenmaara;
    }
    
    /**
     * Metodi vertaa kahta lukua keskenään.
     * 
     * @param luku1
     * @param luku2
     * @return true jos samat, muuten false
     */
    
    public static boolean vertaa(int luku1, int luku2){
        boolean samat = false;
        
        if(luku1 == luku2){
            samat = true;
        }
        return samat;
    }
    
    /**
     * Metodi tarkistaa, että saatu luku on halutulla välillä.
     * Haluttu väli on nollan ja sarakkeen tai rivin pituuden välillä.
     * 
     * @param peli ruuduukko
     * @param luku saatu luku
     * @param kumpi kumpaa katsotaan, rivejä vai sarakkeita
     * @return true jos luku on oikealla välillä, muuten false
     */
    
    public static boolean tarkistus(Ruudukko peli, int luku, int kumpi){
        boolean oikeinko = false;
        int maksimi;
        
        if (kumpi == 1){
            maksimi = peli.getPituus();
        } else {
            maksimi = peli.getSyvyys();
        }   
        
        if (luku >= 0 && luku < maksimi){
            oikeinko = true;
        }
        return oikeinko;
    }
    
    /**
     * Metodi hakee Arraylistan, jossa on tiedoston tiedot ja tulostaa tiedot.
     * 
     * @param nimi tiedoston nimi
     */
    
    public static void tulostaTiedostosta(String nimi){
        ArrayList<String> tiedosto;
        
        tiedosto = Tiedosto.tulostaKaikki(nimi);
        
        for (int i=0; i<tiedosto.size(); ++i){
            System.out.println(tiedosto.get(i));
        }
    }
    
}
