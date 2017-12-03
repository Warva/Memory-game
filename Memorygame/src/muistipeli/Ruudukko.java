/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 * Luokka luo Ruudukko-olion. 
 * Olio toimii muistipelin pelikenttänä.
 *
 * @author Henna
 */
public class Ruudukko {
    
    private int[][] ruudukko;
    private Laatat lista;
    private int kaannot = 0; 
    private String pelityyppi;
    
    /**
     * Konstruktori luo halutun kokoisen ruudukon ja täyttää sen.
     * 
     * @param rivit rivien määrä
     * @param sarakkeet sarakkeiden määrä
     */
    
    public Ruudukko (int rivit, int sarakkeet){
        
        boolean arvot = Pelilogiikka.arvotOikein(rivit, sarakkeet);
        if(arvot == true){
            this.ruudukko = new int[rivit][sarakkeet];
        }
        
        boolean parillinenmaara = Pelilogiikka.parillinenMaaraLaattoja(rivit, sarakkeet);
        if(parillinenmaara == true){
            this.ruudukko = uusiPeli(this.ruudukko);
        }
    }
    
    /**
     * Metodi täyttää ruudukon listan arvoilla.
     * 
     * @param ruudukko peliruudukko
     * @return täytetty ruudukko
     */
    
    private int[][] uusiPeli(int[][] ruudukko){
        this.lista = new Laatat(this.getPituus(), this.getSyvyys());
   
        int luku = 0;
        
        for (int rivi=0; rivi<ruudukko.length; ++rivi){
            for (int sarake=0; sarake<ruudukko[rivi].length; ++sarake){
                ruudukko[rivi][sarake] = this.lista.getLuku(luku);
                ++luku;
            }
        }
        return ruudukko;
    }
    
    /**
     * Metodi lisää käännön määrää.
     */
    
    public void setKaanna(){
        kaannot = ++kaannot;
    }
    
    /**
     * Metodi palauttaa arvonaan kääntöjen määrän.
     * 
     * @return kääntöjen määrä
     */
    
    public int getKaannot(){
        return this.kaannot;
    }
    
    /**
     * Metodi palauttaa arvonaan sijainnin sisälllön.
     * 
     * @param rivi sijainti rivillä
     * @param sarake sijainti sarakkeella
     * @return sisältö
     */

    public int getSisalto(int rivi, int sarake){
        return this.ruudukko[rivi][sarake];
    }
    
    /**
     * Metodi palauttaa arvonaan rivien määrän.
     * 
     * @return rivien määrä
     */
    
    public int getPituus(){
        return this.ruudukko.length;
    }
    
    /**
     * Metodi palauttaa arvonaan sarakkaiden määrän.
     * 
     * @return sarakkaiden määrä
     */
    
    public int getSyvyys(){
        return this.ruudukko[1].length;
    }
    
    /**
     * Metodi asetaa pelityypin.
     * 
     * @param tyyppi 
     */
    
    public void setPelityyppi(String tyyppi){
        this.pelityyppi = tyyppi;
    }
    
    /**
     * Metodi palauttaa pelityypin.
     * 
     * @return pelityyppi
     */
    
    public String getPelityyppi(){
        return this.pelityyppi;
    }
    
    /**
     * Metodi tulostaa ruudukon.
     */
    
    public void tulostus(){
        for (int rivi=0; rivi<this.ruudukko.length; ++rivi){
            for (int sarake=0; sarake<this.ruudukko[rivi].length; ++sarake){
                System.out.print(this.ruudukko[rivi][sarake]+" ");
            }
            System.out.println();
        }
    }  
}
