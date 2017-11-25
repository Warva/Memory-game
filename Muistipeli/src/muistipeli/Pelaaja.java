/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 *
 * @author Henna
 */
public class Pelaaja {
    
    private String nimi;
    
    /**
     * Luokan konstruktori.
     */
    
    public Pelaaja(){
    }
    
    /**
     * Metodi luo uuden pelaajan ja tallentaan sen tiedot tiedostoon.
     * Mikäli siis sama pelaajanimi ei ole jo ennestään käytössä.
     * 
     * @param nimi pelaajan tunnus
     * @param salasana pelaajan salasana
     * @return false jos pelaajanimi on jo käytössä, muuten true
     */
    
    public boolean Rekisteroityminen(String tiedosto, String nimi, String salasana){
        boolean onnistuiko = false;
        
        int apuri = Tiedosto.etsiTiedostosta(tiedosto, nimi);
        if (apuri == 2){
            Tiedosto.kirjoitaTiedostoon(tiedosto, nimi, salasana);
            onnistuiko = true;
            setNimi(nimi);
        }
        return onnistuiko;
    }
    
    /**
     * Metodi tarkistaa ovat annettu nimi ja salasana oikein.
     * 
     * @param tiedosto
     * @param nimi
     * @param salasana
     * @return true jos olivat oikein, muuten false
     */
    
    public boolean SisaanKirjautuminen(String tiedosto, String nimi, String salasana){
        boolean loytyiko = false;
        
        int apuri = Tiedosto.tarkistaNimiJaSalasana(tiedosto, nimi, salasana);
        if (apuri == 1){
            loytyiko = true;
            setNimi(nimi);
        }
        return loytyiko;
    } 
    
    /**
     * Metodi asettaa pelaajan nimen.
     * 
     * @param nimi 
     */
    
    private void setNimi(String nimi){
        this.nimi = nimi;
    }
    
    /**
     * Metodi palauttaa pelaajan nimen.
     * 
     * @return nimi
     */
    
    public String getNimi(){
        return this.nimi;
    }
}
