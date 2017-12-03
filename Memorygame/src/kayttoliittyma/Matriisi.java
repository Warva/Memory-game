/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 * Luokka luo taulukko-olion.
 * Luotu olio vastaa kooltaan pelikenttää.
 * Oliota käytetään "laattojen" selkämyksenä.
 * 
 * @author Henna
 */
public class Matriisi {
    
   /**
    *  Matriisi-olion ilmentymä.
    */
    
   private String[][] tahdet;
   
   /**
    * Konstruktori luo uuden tähdillä täytetyn matriisin.
    * 
    * @param rivit rivien määrä
    * @param sarakkeet sarakkeiden määrä
    */
   
   public Matriisi (int rivit, int sarakkeet){
       this.tahdet = new String[rivit][sarakkeet];
       this.tahdet = tahtimatriisi(this.tahdet);
   }
   
   /**
    * Metodi täyttää sille annetun matriisin tähdillä.
    * 
    * @param tahdet matriisi
    * @return täytetty matriisi
    */
   
   private String[][] tahtimatriisi(String[][] tahdet){
       String[][] taytetty = tahdet;
       int luku = 0;
        
       for (int rivi=0; rivi<taytetty.length; ++rivi){
            for (int sarake=0; sarake<taytetty[rivi].length; ++sarake){
                taytetty[rivi][sarake] = "*";
                ++luku;
            }
        }
        return taytetty;
    }  
   
    /**
     * Metodi vaihtaa oikealle paikalle tähden tilalle tuloksen.
     * 
     * @param rpaikka paikka rivillä
     * @param spaikka paikka sarakkeella
     * @param sisalto tulos
     */
    
    public void sijoitus(int rpaikka, int spaikka, int sisalto){
        String tulos = sisalto+"";
        this.tahdet [rpaikka][spaikka] = tulos;
    }
    
    /**
     * Metodi poistaa tähtimatriisista tuloksen.
     * Metodi vaihtaa tuloksen paikalle tähden.
     * 
     * @param rpaikka paikka rivillä
     * @param spaikka paikka sarakkeella
     */
    
    public void poisto(int rpaikka, int spaikka){
        this.tahdet [rpaikka][spaikka] = "*";
    }
    
    /**
     * Metodi etsii onko tähtimatriisissa jäljellä yhtään tähteä.
     * 
     * @return true jos löytyi, false muulloin
     */
    
    public boolean etsiTahti(){
        boolean loyty = false;
        
        for (int rivi=0; rivi<this.tahdet.length; ++rivi){
            for (int sarake=0; sarake<this.tahdet[rivi].length; ++sarake){
                if("*".equals(this.tahdet[rivi][sarake])){
                    loyty = true;
                }
            }
        }
        
        return loyty;
    }
    
    /**
     * Metodi tulostaa tähtimatriisin.
     */
    
    public void tulostus(){
        System.out.print("  ");
        
        for(int sarake=0; sarake<this.tahdet[1].length; ++sarake){
            System.out.print(sarake +" ");
        } 
        System.out.println();
        
        for (int rivi=0; rivi<this.tahdet.length; ++rivi){
            System.out.print(rivi +" ");
            for (int sarake=0; sarake<this.tahdet[rivi].length; ++sarake){
                System.out.print(this.tahdet[rivi][sarake]+" ");
            }
            System.out.println();
        }
    }
}
