/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luokka muodostaa lista-olion.
 * Olioon tallennetaan muistipelin laattojen sisällön tiedot.
 *
 * @author Henna
 */
public class Laatat {
    
    private List<Integer> lista;
    private int kuviolkm;
    
    /**
     * Konstruktori luo listan ja kutsuu kahta metodia.
     * 
     * @param rivit rivien määrä
     * @param sarakkeet sarakkeiden määrä
     */
    
    public Laatat(int rivit, int sarakkeet){
        
        this.lista = new ArrayList<Integer>();
        this.lista = laattojenValinta(rivit, sarakkeet);
        this.lista = sekoitus(lista);
        
    }
    
    /**
     * Metodi laskee pelilaattojen määrän ja palauttaa lista, jossa on
     * laattojen numerot.
     * 
     * @param rivit rivien määrä
     * @param sarakkeet sarakkeiden määrä
     * @return lista, jossa on laattojen numerot
     */
    
    private List<Integer> laattojenValinta(int rivit, int sarakkeet){
        kuviolkm = rivit*sarakkeet;
        kuviolkm = kuviolkm/2;

        for(int i=0; i<kuviolkm; ++i){
            lista.add(i+1);
            lista.add(i+1);
        }
        return lista;
    }
    
    /**
     * Metodi sekoittaa listan.
     * 
     * @param listat lista, jossa luvut ovat
     * @return sekoitettu lista
     */
    
    private List<Integer> sekoitus(List<Integer> listat){   
        Collections.shuffle(listat);
        return listat;
    }
    
    /**
     * Metodi palauttaa halutussa paikassa olevan luvun.
     * 
     * @param i luvun paikka
     * @return palautettava luku
     */
    
    public int getLuku(int i){
        return this.lista.get(i);
    }
            
}
