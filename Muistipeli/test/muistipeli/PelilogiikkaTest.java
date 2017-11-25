/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import kayttoliittyma.Matriisi;
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
public class PelilogiikkaTest {
    
    Ruudukko peli;
    Matriisi tahdet;
    int rivi = 4;
    int sarake = 4;
    
    public PelilogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        peli = new Ruudukko(rivi, sarake);
        tahdet = new Matriisi(rivi, sarake);
    }
    
    @After
    public void tearDown() {
    }
    
    // Metodin koordinaatisto testit.
    
    @Test
    public void toimiiko(){
        int luku = 2;
        int kumpi = 2;
        int i = Pelilogiikka.koordinaatisto(peli, tahdet, luku, kumpi);
        assertNotNull(i);
    }
    
    // Metodin tarkistus testit.
    
    @Test
    public void riviOikeallaValilla(){
        int luku = 2;
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void riviPituus(){
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, rivi, kumpi);
        assertFalse(samat);
    }
    
    @Test
    public void riviMaksimi(){
        int luku = rivi-1;
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void riviNolla(){
        int luku = 0;
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void riviVaarallaValilla(){
        int luku = 200;
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertFalse(samat);
    }
    
    @Test
    public void riviAlleNollan(){
        int luku = -2;
        int kumpi = 1;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertFalse(samat);
    }
    
    @Test
    public void sarakeOikeallaValilla(){
        int luku = 2;
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void sarakePituus(){
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, sarake, kumpi);
        assertFalse(samat);
    }
    
    @Test
    public void sarakeNolla(){
        int luku = 0;
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void sarakeMaksimi(){
        int luku = sarake-1;
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertTrue(samat);
    }
    
    @Test
    public void sarakeVaarallaValilla(){
        int luku = 200;
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertFalse(samat);
    }
    
    @Test
    public void sarakeAlleNollan(){
        int luku = -2;
        int kumpi = 2;
        boolean samat = Pelilogiikka.tarkistus(peli, luku, kumpi);
        assertFalse(samat);
    }
    
    // Metodin vertaa testit.

    @Test
    public void samatLuvut(){
        int luku1 = 2;
        int luku2 = 2;
        boolean samat = Pelilogiikka.vertaa(luku1, luku2);
        assertTrue(samat);
    }
    
    @Test
    public void eriLuvut(){
        int luku1 = 2;
        int luku2 = 1;
        boolean samat = Pelilogiikka.vertaa(luku1, luku2);
        assertFalse(samat);  
    }
    
    // Metodin parillinenMaaraLaattoja testit.
    
    @Test
    public void parillinen1(){
        int i = 42;
        int j = 38;
        boolean parillinen = Pelilogiikka.parillinenMaaraLaattoja(i, j);
        assertTrue(parillinen);
    }
    
    @Test
    public void parillinen2(){
        int i = 2;
        int j = 2;
        boolean parillinen = Pelilogiikka.parillinenMaaraLaattoja(i, j);
        assertTrue(parillinen);
    }
    
    @Test
    public void pariton1(){
        int i = 1;
        int j = 1;
        boolean parillinen = Pelilogiikka.parillinenMaaraLaattoja(i, j);
        assertFalse(parillinen);
    }
    
    @Test
    public void pariton2(){
        int i = 25;
        int j = 17;
        boolean parillinen = Pelilogiikka.parillinenMaaraLaattoja(i, j);
        assertFalse(parillinen);
    }
    
    // Metodin arvotOikein testit.
    
    @Test
    public void arvotOikein1(){
        int i = 0;
        int j = 0;
        boolean arvot = Pelilogiikka.arvotOikein(i, j);
        assertTrue(arvot);
    }
    
    @Test
    public void arvotOikein2(){
        int i = 35;
        int j = 26;
        boolean arvot = Pelilogiikka.arvotOikein(i, j);
        assertTrue(arvot);
    }
    
    @Test
    public void arvotVaarin1(){
        int i = -1;
        int j = -4;
        boolean arvot = Pelilogiikka.arvotOikein(i, j);
        assertFalse(arvot);
    }
    
    @Test
    public void arvotVaarin2(){
        int i = -34;
        int j = -25;
        boolean arvot = Pelilogiikka.arvotOikein(i, j);
        assertFalse(arvot);
    }
}
