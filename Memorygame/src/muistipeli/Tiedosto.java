/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokkaan on koottu tiedostojen käsittelyyn tarvittavia metodeja.
 *
 * @author Henna
 */
public class Tiedosto {
    
    /**
     * Metodi luo uuden halutun nimisen tiedoston, jos samannimistä ei vielä 
     * ole. 
     * Metodi lukee tiedostoa, tulostaa tiedoston tiedot toiseen tiedostoon ja lisää
     * uudet tiedot haluttuun paikkaan. Tämän jälkeen metodi poistaa vanhan tiedoston
     * ja uudelleennimeää uuden tiedoston vanhan nimellä.
     * 
     * @param tiedostonnimi haluttu tiedoston nimi
     * @param pelaaja pelaajan nimi
     * @param kaannot kääntöjen määrä
     * @return 1 jos onnistui ja 3 jos tapahtui virhe
     */

    public static int kirjoitaTiedostoon(String tiedostonnimi, String pelaaja, int kaannot){

        PrintStream kirjoita = null;
        String aputiedosto = tiedostonnimi+1;
        Integer luettu;

        BufferedReader lue;
        String seuraava;
        int i = 3;
        File tiedosto = new File(tiedostonnimi);
        File tiedosto2 = new File(aputiedosto);
        
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            lue = new BufferedReader(new FileReader(tiedostonnimi));
            seuraava = lue.readLine();
            while(seuraava != null){
                luettu = Integer.decode(seuraava);
                try {
                    kirjoita = new PrintStream(new FileOutputStream(tiedosto2,true));
                }
                catch (FileNotFoundException e) {
                    i = 3;
                    return i;
                }
                if (luettu > kaannot){
                    if (i == 3){
                         try {
                                kirjoita.println(kaannot);
                                kirjoita.println(pelaaja);
                                kirjoita.println(seuraava);
                                seuraava = lue.readLine();
                                kirjoita.println(seuraava);
                                i = 1;
                         } finally{}
                    } else {
                        try {
                            kirjoita.println(seuraava);
                            seuraava = lue.readLine();
                            kirjoita.println(seuraava);
                        } finally{}
                    }
                } else {
                    try {
                        kirjoita.println(seuraava);
                        seuraava = lue.readLine();
                        kirjoita.println(seuraava);
                    } finally {}
                }
                seuraava = lue.readLine();
            }
            
            if (i == 3){
                try {
                    kirjoita = new PrintStream(new FileOutputStream(tiedosto2,true));
                }
                catch (FileNotFoundException e) {
                    i = 3;
                    return i;
                }
                
                try {
                     kirjoita.println(kaannot);
                     kirjoita.println(pelaaja);
                     i = 1;
                    } finally{}
            }
            
        }catch (IOException e) {
            i = 3;
            return i;
        }

        try {
            if (lue != null){
                lue.close();
            }
        }catch(IOException e) {
            i = 3;
        }
         finally{
            kirjoita.close();
            poistaTiedosto(tiedostonnimi);
            tiedosto2.renameTo(tiedosto);
        }
        return i;
    }
    
    /**
     * Metodi luo uuden halutun nimisen tiedoston, jos samannimistä ei vielä 
     * ole ja lisää annetut tiedot tiedostoon.
     * 
     * @param tiedostonnimi haluttu tiedoston nimi
     * @param pelaaja tiedostoon lisättävä teksti
     * @param salasana tiedostoon lisättävä teksti
     * @return 1 jos onnistui ja 3 jos tapahtui virhe
     */
    
    public static int kirjoitaTiedostoon(String tiedostonnimi, String pelaaja, String salasana){

        PrintStream kirjoita;
        int i;

        try {
            kirjoita = new PrintStream(new FileOutputStream(tiedostonnimi,true));
	}
        catch (FileNotFoundException e) {
            i = 3;
            return i;
	}

        try {
            kirjoita.println(pelaaja);
            kirjoita.println(salasana);
            i = 1;
  
        } finally{
            kirjoita.close();
        }
        return i;
    }

    /**
     * Metodi etsii annetusta tiedostosta halutun tiedon.
     * 
     * @param tiedostonnimi tiedosto, josta etsitään
     * @param etsittava etsittävä tieto
     * @return 1 jos löytyi, 2 jos ei löytynyt, 3 jos tapahtui virhe
     */
    
    public static int etsiTiedostosta(String tiedostonnimi, String etsittava){

        BufferedReader lue;
        String seuraava;
        int i = 2;
        File tiedosto = new File(tiedostonnimi);
        
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            lue = new BufferedReader(new FileReader(tiedostonnimi));
            seuraava = lue.readLine();
            while(seuraava != null) {
                if (seuraava.equals(etsittava)){
                    i = 1;
                    break;
                } 
                seuraava = lue.readLine();
            }
        }catch (IOException e) {
            i = 3;
            return i;
        }

        try {
            if (lue != null){
                lue.close();
            }
        }catch(IOException e) {
            i = 3;
        }
        return i;
    }

    /**
     * Metodi etsii annetusta tiedostosta halutut tiedot.
     * 
     * @param tiedostonnimi tiedosto, josta etsitään
     * @param nimi etsittävä nimi
     * @param salasana etsittävä salasana
     * @return 1 jos löytyi, 2 jos ei löytynyt, 3 jos tapahtui virhe
     */
    
    public static int tarkistaNimiJaSalasana(String tiedostonnimi, String nimi, String salasana){

        BufferedReader lue;
        String seuraava;
        int i = 2;
        File tiedosto = new File(tiedostonnimi);
        
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tiedosto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            lue = new BufferedReader(new FileReader(tiedostonnimi));
            seuraava = lue.readLine();
            while(seuraava != null) {
                if (seuraava.equals(nimi)){
                    seuraava = lue.readLine();
                        if (seuraava.equals(salasana)){
                            i = 1;
                            break;
                        } 
                } 
                seuraava = lue.readLine();
            }
        }catch (IOException e) {
            i = 3;
            return i;
        }

        try {
            if (lue != null){
                lue.close();
            }
        }catch(IOException e) {
            i = 3;
        }
        return i;
    }
    
    /**
     * Metodi tulostaa annetun tiedoston kaiken tiedon.
     * 
     * @param tiedostonnimi tiedoston nimi
     * @return lista, jossa on tiedoston tiedot
     */

    public static ArrayList<String> tulostaKaikki(String tiedostonnimi){

        BufferedReader lue;
        String seuraava;
        ArrayList<String> lista = new ArrayList<String>();
        File tiedosto = new File(tiedostonnimi);
        boolean olemassa = tiedosto.exists();
        
        if (olemassa == false){
            return lista;
        }
        
        try {
            lue = new BufferedReader(new FileReader(tiedostonnimi));
            seuraava = lue.readLine();
            if(seuraava == null){
                return lista;
            }
            else {
                while(seuraava != null) {
                    String rivi = seuraava;
                    lista.add(rivi);
                    seuraava = lue.readLine();
                }
            }
        }catch (IOException e) {
            return lista;
        }

        try {
            if (lue != null){
                lue.close();
            }     
        }catch(IOException e) {
            return lista;
        }
        return lista;
    }
    
    /**
     * Metodi poistaa halutun tiedoston.
     * 
     * @param tiedostonnimi poistettavan tiedoston nimi
     * @return true onnistui, false ei onnistunut
     */

    public static boolean poistaTiedosto(String tiedostonnimi){
        File tiedosto = new File(tiedostonnimi);
        return tiedosto.delete();
    }    
        
}
