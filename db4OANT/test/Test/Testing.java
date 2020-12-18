/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Liga;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Fernández
 */
public class Testing {
    
    public Testing() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void insertLeagueInDataBase() throws IOException {
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DataBase.yap");
        
        byte[] bytesFileBefore = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        Liga league = new Liga("LALIGA TEST","LaLiga Test","20","9", "Española");
        
        db.store(league);

        byte[] bytesFileAfter = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        assertNotEquals(bytesFileBefore, bytesFileAfter);
    
    }
    
    public void insertPlayersInDataBase() throws IOException {
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DataBase.yap");
        
        byte[] bytesFileBefore = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        Jugador players = new Jugador("PLAYER TEST","Luis Serrano","20","9", "Española");
        
        db.store(players);

        byte[] bytesFileAfter = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        assertNotEquals(bytesFileBefore, bytesFileAfter);
    
    }
    
    public void insertTeamInDataBase() throws IOException {
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DataBase.yap");
        
        byte[] bytesFileBefore = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        Equipo team = new Equipo("TEAM TEST","Luis Serrano","20","9", "Española");
        
        db.store(team);

        byte[] bytesFileAfter = Files.readAllBytes(Paths.get("DataBase.yap"));
        
        assertNotEquals(bytesFileBefore, bytesFileAfter);
    
    }
}
