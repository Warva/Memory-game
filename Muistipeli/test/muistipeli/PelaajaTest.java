/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author henna
 */
public class PelaajaTest {
    
    String nimi = "Nella";
    String salasana = "oli";
    String tiedosto = "testipelaaja";
    boolean onnistuiko;
    Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int i = Tiedosto.kirjoitaTiedostoon(tiedosto, nimi, salasana);
        pelaaja = new Pelaaja();
    }
    
    @After
    public void tearDown() {
       boolean poisto = Tiedosto.poistaTiedosto(tiedosto);
    }
    
    @Test
    public void onnistunutRekisteroityminen(){
        onnistuiko = pelaaja.Rekisteroityminen(tiedosto, "Henna", "joo");
        assertTrue(onnistuiko);
    }
    
    @Test
    public void epaonnistunutRekisteroityminen(){
        onnistuiko = pelaaja.Rekisteroityminen(tiedosto, nimi, salasana);
        assertFalse(onnistuiko);
    }
    
    @Test
    public void onnistunutSisaankirjautuminen(){
        onnistuiko = pelaaja.SisaanKirjautuminen(tiedosto, nimi, salasana);
        assertTrue(onnistuiko);
    }
    
    @Test
    public void epaonnistunutSisaankirjautuminen1(){
        onnistuiko = pelaaja.SisaanKirjautuminen(tiedosto, "olli", "etunimi");
        assertFalse(onnistuiko);
    }
    
    @Test
    public void epaonnistunutSisaankirjautuminen2(){
        onnistuiko = pelaaja.SisaanKirjautuminen(tiedosto, nimi, "etunimi");
        assertFalse(onnistuiko);
    }
    
    @Test
    public void epaonnistunutSisaankirjautuminen3(){
        onnistuiko = pelaaja.SisaanKirjautuminen(tiedosto, "hetu", salasana);
        assertFalse(onnistuiko);
    }
}
