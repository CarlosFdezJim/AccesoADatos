
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Equipos_Controlador;
import Controlador.Jugador_Controlador;
import Controlador.Liga_Controlador;
import Modelo.*;
import Vista.Vista;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Fernández
 */
public class Testing {
    Vista MiVista;
    Liga_Controlador liga;
    Equipos_Controlador equipo;
    Jugador_Controlador jugador;
    
    public Testing() {   
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test

    public void crearUnaLiga(){
        Liga lg = new Liga("Test","Test","Test","Test","Test");
        liga.leagueArrayList.add(lg);
    }
    public void crearUnEquipo() {
        Equipo eq = new Equipo("Test","Test","Test","Test","Test");
        equipo.teamArrayList.add(eq);
        
    }
    public void crearUnJugador(){
        Jugador jg = new Jugador("Test","Test","Test","Test","Test");
        jugador.playerArrayList.add(jg);
    }
    public void LeerDeUnFicheros() throws ClassNotFoundException, IOException, SAXException, FileNotFoundException, ParserConfigurationException{
        liga.LeerFichero();
        equipo.LeerFichero();
        jugador.LeerFichero();
    }
    public void EscribirUnFichero() throws IOException, SAXException{
        liga.EscribirFichero();
        equipo.EscribirFichero();
        jugador.EscribirFichero();
    }
    
}
