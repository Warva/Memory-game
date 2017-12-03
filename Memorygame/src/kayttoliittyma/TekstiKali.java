/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.util.Scanner;
import muistipeli.Pelaaja;
import muistipeli.Pelilogiikka;
import muistipeli.Ruudukko;
import muistipeli.Tiedosto;

/**
 * Muistipelin tekstikäyttöliittymä. 
 * Luokka vastaa pääasiassa siitä, mitä pelaajalle pelistä näkyy.
 *
 * @author Henna
 */
public class TekstiKali {
    
    private static Scanner lukija = new Scanner(System.in);
    private Ruudukko peli;
    private Pelaaja pelaaja;
    private Matriisi tahdet;
    private int rivi1, sarake1;
    private int rivi2, sarake2;
    private String tiedosto = "Pelaajat";
    private String tiedosto2 = "Tulokset";
    private int teko;
    
    /**
     * Luokan konstruktori.
     * Konstruktori luo luokan ilmentymän.
     */
    
    public TekstiKali(){
        this.pelaaja = new Pelaaja();
        pelinKaynnistys();
    }   
    
    /**
     * Metodi toivottaa tervetulleeksi peliin ja
     * hallinnoi miten tunnukset kysytään.
     */

    private void pelinKaynnistys(){
        System.out.println("Tervetuloa muistipeliin.");
        
        teko = tunnusKysely();
        boolean onnistuiko = sisaan(teko);

        while(onnistuiko == false){
            System.out.println("Ei onnistunut. Yritä uudestaan.");
            teko = tunnusKysely();
            onnistuiko = sisaan(teko);
        }
        valintoja();
    }
    
    /**
     * Metodi kysyy mitä pelaaja haluaa tehdä.
     */
    
    private void valintoja(){
        do {
            System.out.println("Mitä haluat tehdä?");
            System.out.println("1 = uusi peli, 2 = pelitulosten katselu, 3 = lopetus");
            
            try {
                teko = Integer.parseInt(lukija.nextLine());
            }
            catch (NumberFormatException e){
                teko = 0;
            }
        } while (teko < 1 || teko > 3);
        
        if (teko == 1){
            pelivalinta();
        } else if (teko == 2){
            hallOfFame();
        } else {
            System.exit(0);
        }
    }
    
    /**
     * Metodi kysyy haluaako pelaaja rekisteröityä vai kirjautua sisään.
     * Metodi palauttaa arvonaan tiedon, kumpi tehdään.
     * 
     * @return 1 = kirjaudutaan sisään, 2 = rekisteröidytään
     */

    private int tunnusKysely(){

        do{
            System.out.println("Kirjadu sisään tai rekisteröidy.");
            System.out.println("1 = sisään, 2 = rekisteröidy");
            
            try {
                teko = Integer.parseInt(lukija.nextLine());
            }
            catch (NumberFormatException e){
                teko = 0;
            }
        }while (teko < 1 || teko > 2);
        return teko;
    }
    
    /**
     * Metodi kirjaa pelaajan sisään tai rekisteröi tunnuksen ja salasanan.
     * Metodi palauttaa arvonaan tiedon onnistuiko haluttu toimenpide
     * 
     * @param kumpi tieto siitä kumpi toimenpide tehdään
     * @return true = onnistui, muuten false
     */
    
    private boolean sisaan(int kumpi){
        boolean onnistuiko;
        String tunnus, salasana;
        
        System.out.println("Anna tunnus.");
        tunnus = lukija.nextLine();
        System.out.println("Anna salasana.");
        salasana = lukija.nextLine(); 
        
        if(kumpi == 1){
           onnistuiko = this.pelaaja.SisaanKirjautuminen(this.tiedosto, tunnus, salasana);
        }else {
           onnistuiko = this.pelaaja.Rekisteroityminen(this.tiedosto, tunnus, salasana);
        }
        
        return onnistuiko;
    }
    
    /**
     * Metodi kysyy millaisen pelin pelaaja haluaa. 
     * Vaihtoehtona on myös koko ohjelman sulkeminen.
     */
    
    private void pelivalinta(){
        
        do {
            System.out.println("Millaisen pelin haluat?");
            System.out.println("1 = helppo, 2 = normaali, 3 = vaikea");
            System.out.println("4 = lopettaa pelin");
            
            try {
                teko = Integer.parseInt(lukija.nextLine());
            }catch (NumberFormatException e){
                teko = 0;
            }
        }while (teko < 1 || teko > 4);

        if(teko == 1){
            peliAlkaa(teko,4,4);
        } else if(teko == 2){
            peliAlkaa(teko,6,6);
        } else if(teko == 3) {
            peliAlkaa(teko,8,8);
        } else {
            System.exit(0);
        }
        
    }
    
    /**
     * Metodi aloittaa varsinaisen pelin.
     * Metodi luo peliruudukon ja matriisin. Peliruudukossa on vastaukset ja
     * matriisi taas toimii laattojen "selkäpuolena".
     * 
     * @param pelivalinta millainen peli
     * @param rivi rivien määrä
     * @param sarake sarakkeiden määrä
     */
    
    private void peliAlkaa(int pelivalinta, int rivi, int sarake){
        
        this.peli = new Ruudukko(rivi, sarake);
        this.tahdet = new Matriisi(rivi, sarake);
        
        valinta(pelivalinta);
        System.out.println("Peli alkaa.");
        System.out.println("Voit milloin tahansa kesken arvausten lopettaa pelin antamalla minkä tahansa kirjaimen.");
        pelikierros();
    }
    
    /**
     * Metodi asettaa pelityypin Ruudukko-oliolle.
     * 
     * @param valinta pelityyppi
     */
    
    private void valinta(int valinta){
        if(valinta == 1){
            peli.setPelityyppi("Helppo");
        } else if (valinta == 2){
            peli.setPelityyppi("Normaali");
        } else {
            peli.setPelityyppi("Vaikea");
        }
    }
    
    /**
     * Metodi pitää huolta pelikierroksista, laskee niitä ja testauttaa
     * onko peli jo voitettu.
     */
    
    private void pelikierros(){
        boolean samat, valmis;
        
        do {
            this.tahdet.tulostus();
            int luku1 = laatanKaanto1();
            this.tahdet.tulostus();
            int luku2 = laatanKaanto2();
            this.tahdet.tulostus();
            samat = Pelilogiikka.vertaa(luku1, luku2);
                
            if (samat == true){
               System.out.println("Löysit parin.");
            } else {
               System.out.println("Paria ei löytynyt. Yritä uudestaan.");
               this.tahdet.poisto(this.rivi1, this.sarake1);
               this.tahdet.poisto(this.rivi2, this.sarake2);
            }
            
            this.peli.setKaanna();
            valmis = this.tahdet.etsiTahti();
        } while (valmis == true);
        
        System.out.println("Onneksi olkoon. Voitit pelin.");
        pelitulokset();
        
    }
    
    /**
     * Metodi kääntää ensimmäisen laatan laattaparista ja palauttaa arvonaan
     * laatan sisällön.
     * 
     * @return sisältö
     */
    
    private int laatanKaanto1(){
        boolean jatketaanko;
        
        do {
            System.out.print("Anna rivi, jolla käännettävä laattaa on.");
            try {
                this.rivi1 = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e){
                System.exit(0);
            }
            
            jatketaanko = Pelilogiikka.tarkistus(this.peli, this.rivi1, 1);
        } while (jatketaanko == false);
        
        do {      
            System.out.print("Anna sarake, jolla käännettävä laattaa on.");
            try {
                this.sarake1 = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e){
                System.exit(0);
            }
        
            jatketaanko = Pelilogiikka.tarkistus(this.peli, this.sarake1, 2);
        } while (jatketaanko == false);
        
        int luku = Pelilogiikka.koordinaatisto(this.peli, this.tahdet, this.rivi1, this.sarake1);
        return luku;
    }
    
    /**
     * Metodi kääntää toisen laatan laattaparista ja palauttaa arvonaan
     * laatan sisällön.
     * 
     * @return sisältö 
     */
    
    private int laatanKaanto2(){
        boolean jatketaanko;
        
        do {
            System.out.print("Anna rivi, jolla käännettävä laattaa on.");
            try {
                this.rivi2 = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e){
                System.exit(0);
            }
            
            jatketaanko = Pelilogiikka.tarkistus(this.peli, this.rivi2, 1);
        } while (jatketaanko == false);
        
        do {      
            System.out.print("Anna sarake, jolla käännettävä laattaa on.");
            try {
                this.sarake2 = Integer.parseInt(lukija.nextLine());
            } catch (NumberFormatException e){
                System.exit(0);
            }
        
            jatketaanko = Pelilogiikka.tarkistus(this.peli, this.sarake2, 2);
        } while (jatketaanko == false);
        
        int luku = Pelilogiikka.koordinaatisto(this.peli, this.tahdet, this.rivi2, this.sarake2);
        return luku;
    }
    
    /**
     * Metodi tallentaa voitetun pelin tuloksen ja näyttää sen pelaajalle.
     */
    
    private void pelitulokset(){
        int kaannot = this.peli.getKaannot();
        String tunnus = this.pelaaja.getNimi();
        String pelityyppi = this.peli.getPelityyppi();
        this.tiedosto2 = this.tiedosto2+pelityyppi;
        
        Tiedosto.kirjoitaTiedostoon(this.tiedosto2, tunnus, kaannot);
        System.out.println(tunnus+", käytit "+kaannot+" arvausta.");
        valintoja();
    }
    
    /**
     * Metodi näyttää pelaajalle halutut pelitulokset.
     */
    
    private void hallOfFame(){
        String tieto;
        this.tiedosto2 = "Tulokset";
        do {
            System.out.println("Mitä tuloksia haluat katsella?");
            System.out.println("1 = helppojen, 2 = normaalien, 3 = vaikeiden");
            
            try {
                teko = Integer.parseInt(lukija.nextLine());
            }catch (NumberFormatException e){
                teko = 0;
            }
        }while (teko < 1 || teko > 3);

        if(teko == 1){
            this.tiedosto2 = this.tiedosto2+"Helppo";
            tieto = "Helppo";
        } else if(teko == 2){
            this.tiedosto2 = this.tiedosto2+"Normaali";
            tieto = "Normaali";
        } else {
            this.tiedosto2 = this.tiedosto2+"Vaikea";
            tieto = "Vaikea";
        }
        
        System.out.println("Pelitulokset "+tieto);
        Pelilogiikka.tulostaTiedostosta(this.tiedosto2);
        System.out.println();
        valintoja();
    }
}
