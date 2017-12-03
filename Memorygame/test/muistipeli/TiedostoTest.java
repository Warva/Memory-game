/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
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
public class TiedostoTest {
    
    int kaannot = 5;
    String tiedosto = "tulokset";
    String tiedosto1 = "testausta";
    String tiedosto2 = "vanha";
    int kirjoitus, i;
    boolean poisto;
    
    public TiedostoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto2, "Maija", 20);
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto, "ÄäÖöÅå", 6);
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto2, "Molli", 3);
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto1, "Molli", "Elli");
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto1, "Molli", "Olli");
        kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto1, "Molli", "Ali");
    }
    
    @After
    public void tearDown() {
        poisto = Tiedosto.poistaTiedosto(tiedosto);
        poisto = Tiedosto.poistaTiedosto(tiedosto1);
        poisto = Tiedosto.poistaTiedosto(tiedosto2);
    }
    
    // Kirjoitusta testaavat testit
    
    @Test
    public void eroaakoIsotjaJaPienetKirjaimet() {
        i = Tiedosto.etsiTiedostosta(tiedosto, "maija");
        assertEquals(2, i);  
    }
    
    @Test
    public void toimiikoAakkoset() {
        i = Tiedosto.etsiTiedostosta(tiedosto, "ÄäÖöÅå");
        assertEquals(1, i);
    }
    
    @Test
    public void onnistunutKirjoitus() {
        i = Tiedosto.kirjoitaTiedostoon(tiedosto, "Molli", 4);
        assertEquals(1, i);
    }
    
    @Test
    public void onnistunutKirjoitus2() {
        i = Tiedosto.kirjoitaTiedostoon(tiedosto1, "Molli", "Alli");
        assertEquals(1, i);
    }
    
    // Etsintää testaavat testit
    
    @Test
    public void etsitaanTiedostostaLoytyy() {
        i = Tiedosto.etsiTiedostosta(tiedosto2, "Maija");
        assertEquals(1, i);
    }
    
    @Test
    public void etsitaanTiedostostaEiLoydy() {
        i = Tiedosto.etsiTiedostosta(tiedosto, "Arttu");
        assertEquals(2, i);
    }
    
    @Test
    public void etsitaanMassastaLoytyy(){
        for(int j=0; j<30; j++){
            String nimi = "Maija"+j;
            kirjoitus = Tiedosto.kirjoitaTiedostoon(tiedosto, nimi, kaannot);
        }
        i = Tiedosto.etsiTiedostosta(tiedosto, "Maija10");
        assertEquals(1, i);
    }
    
    @Test
    public void etsitaanMassastaEiLoydy(){
        i = Tiedosto.etsiTiedostosta(tiedosto, "Kaija");
        assertEquals(2, i);
    }
    
    @Test
    public void etsitaanNimiJaSalasanaLoytyy(){
        i = Tiedosto.tarkistaNimiJaSalasana(tiedosto1, "Molli", "Olli");
        assertEquals(1, i);
    }
    
    @Test
    public void etsitaanNimiJaSalasanaEiLoydy(){
        i = Tiedosto.tarkistaNimiJaSalasana(tiedosto1, "Molli", "kolli");
        assertEquals(2, i);
    }

    // Tiedoston poistoa testaavat testit
    
    @Test
    public void tiedostonPoisto() {
        assertTrue(Tiedosto.poistaTiedosto(tiedosto1));
    }
    
    @Test
    public void tyhjanTiedostonPoisto() {
        assertFalse(Tiedosto.poistaTiedosto("Moi"));
    }
    
    // Tiedoston tulostusta testaavat testit
    
    @Test
    public void tiedostonTulostus() {
        ArrayList<String> lista = Tiedosto.tulostaKaikki(tiedosto);
        boolean apuri = lista.isEmpty();
        assertFalse(apuri);
    }
    
    @Test
    public void tyhjanTiedostonTulostus() {
        ArrayList<String> lista = Tiedosto.tulostaKaikki("molli");
        boolean apuri = lista.isEmpty();
        assertTrue(apuri);
    }
}
