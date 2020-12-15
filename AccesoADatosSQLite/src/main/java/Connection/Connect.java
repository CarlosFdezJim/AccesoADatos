/**
 * @author Fernández
 */

package Connection;

import Controlador.Jugador_Controlador;
import Controlador.Liga_Controlador;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Liga;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Connect {
    
    private Connect conexConnection;
    private Statement st;
    private ResultSet rs;

    public Connection connect() {
        
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:DataBase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexión con SQLite establecida con éxito.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void CloseConnection(Connection con) throws SQLException{
        System.out.println("SE HA CERRADO LA BASE DE DATOS CloseConnection.");
        con.close();
    }
    
    /*=========================================================================*/
    /*=================             LEAGUE              =======================*/
    public void createDataBaseLeague(){
        String query = "CREATE TABLE LIGAS(Num_ID INTEGER PRIMARY KEY AUTOINCREMENT, ID TEXT NOT NULL, Nombre TEXT NOT NULL, Num_Equipos TEXT NOT NULL, Num_Ligas TEXT NOT NULL, Federacion TEXT NOT NULL);";
        Connection con = null;
        try{
            con = this.connect();
            st = con.createStatement();
            rs =  st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBaseLeague(int Num_ID) {
        String sql = "DELETE FROM LIGAS WHERE Num_ID = ?";
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, Num_ID);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Eliminado correctamente fila" + Num_ID);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    
    public void insertDataLeague(String ID,String Nombre,String Num_Equipos,String Num_Ligas,String Federacion){
        String insert = "INSERT INTO LIGAS (Num_ID, ID, Nombre, Num_Equipos, Num_Ligas, Federacion) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        int Num_ID = Liga_Controlador.leagueArrayList.size() + 1;
        
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(insert);
                pstmt.setInt(1, Num_ID);
                pstmt.setString(2, ID);
                pstmt.setString(3, Nombre);
                pstmt.setString(4, Num_Equipos);
                pstmt.setString(5, Num_Ligas);
                pstmt.setString(6, Federacion);
                
                pstmt.executeUpdate();
                System.out.println("Insertada Liga " + Nombre);
                con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void updateDataLeague(String ID, String Nombre,String Num_Equipos,String Num_Ligas,String Federacion) {
        String sql = "UPDATE LIGAS SET Nombre = ? , "
                + "Num_Equipos = ? ,"
                + "Num_Ligas = ? ,"
                + "Federacion = ? "
                + "WHERE ID = ?";
        
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, Nombre);
            pstmt.setString(2, Num_Equipos);
            pstmt.setString(3, Num_Ligas);
            pstmt.setString(4, Federacion);
            pstmt.setString(5, ID);
            
            // update 
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    public ArrayList mostrarTablaLeague(ArrayList <Liga> leagueArrayList){
        String full = "SELECT * FROM LIGAS";
        Connection con = null;
        
        try {
            con = this.connect();
            Statement stmt  = con.createStatement();
            ResultSet rs = stmt.executeQuery(full);
            
            // loop through the result set
            while (rs.next()) {
                Liga lig = new Liga();
                lig.setNum_ID(rs.getInt("Num_ID"));
                lig.setID_Liga(rs.getString("ID"));
                lig.setNombre_Liga(rs.getString("Nombre"));
                lig.setNum_Equipos(rs.getString("Num_Equipos"));
                lig.setNum_Ligas(rs.getString("Num_Ligas"));
                lig.setFederacion(rs.getString("Federacion"));
                leagueArrayList.add(lig);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return leagueArrayList;
    }
    /*=========================================================================*/
    public void DataBaseLeague(){
        
        insertDataLeague("LALIGA", "La Liga", "20", "9", "Española");
        insertDataLeague("LIGUE1", "Ligue 1", "20", "9", "Francesa");
        insertDataLeague("SERIEA", "Serie A", "20", "9", "Italiana");
        insertDataLeague("BUNDESLIGA", "Bundesliga", "20", "6", "Alemana");
        insertDataLeague("PREMIER", "Premier League", "20", "4", "Inglesa");

    }
    /*=========================================================================*/
    /*=================             PLAYER              =======================*/
    public void createDataBasePlayer(){
        String query = "CREATE TABLE PLAYERS (Num_ID INTEGER PRIMARY KEY AUTOINCREMENT, DNI TEXT NOT NULL, Nombre_Jugador TEXT NOT NULL, Club TEXT NOT NULL, Posicion TEXT NOT NULL, Dorsal TEXT NOT NULL);";
        Connection con = null;
        try{
            con = this.connect();
            st = con.createStatement();
            rs =  st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBasePlayer(int Num_ID) {
        String sql = "DELETE FROM PLAYERS WHERE Num_ID = ?";
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, Num_ID);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Eliminado correctamente fila" + Num_ID);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    
    public void insertDataPlayer(String DNI,String Nombre_Jugador,String Club,String Posicion,String Dorsal){
        String insert = "INSERT INTO PLAYERS (Num_ID, DNI, Nombre_Jugador, Club, Posicion, Dorsal) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        int Num_ID = Jugador_Controlador.playerArrayList.size() + 1;
        
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(insert);
                pstmt.setInt(1, Num_ID);
                pstmt.setString(2, DNI);
                pstmt.setString(3, Nombre_Jugador);
                pstmt.setString(4, Club);
                pstmt.setString(5, Posicion);
                pstmt.setString(6, Dorsal);
                
                pstmt.executeUpdate();
                System.out.println("Insertada Liga " + Nombre_Jugador);
                con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void updateDataPlayer(String DNI,String Nombre_Jugador,String Club,String Posicion,String Dorsal) {
        String sql = "UPDATE PLAYERS SET Nombre_Jugador = ? , "
                + "Club = ? ,"
                + "Posicion = ? ,"
                + "Dorsal = ? "
                + "WHERE DNI = ?";
        
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, Nombre_Jugador);
            pstmt.setString(2, Club);
            pstmt.setString(3, Posicion);
            pstmt.setString(4, Dorsal);
            pstmt.setString(5, DNI);
            
            // update 
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    public ArrayList mostrarTablaPlayer(ArrayList <Jugador> playerArrayList){
        String full = "SELECT * FROM PLAYERS";
        Connection con = null;
        
        try {
            con = this.connect();
            Statement stmt  = con.createStatement();
            ResultSet rs = stmt.executeQuery(full);
            
            // loop through the result set
            while (rs.next()) {
                Jugador ply = new Jugador();
                ply.setNum_ID(rs.getInt("Num_ID"));
                ply.setDNI(rs.getString("DNI"));
                ply.setNombre_Jugador(rs.getString("Nombre_Jugador"));
                ply.setClub(rs.getString("Club"));
                ply.setPosicion(rs.getString("Posicion"));
                ply.setDorsal(rs.getString("Dorsal"));
                playerArrayList.add(ply);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return playerArrayList;
    }
    /*=========================================================================*/
    public void DataBasePlayer(){
        
        insertDataPlayer("77777777C","Cristiano Ronaldo","Juventus Turin","Delantero","7");
        insertDataPlayer("22222222I","Isco","Real Madrid CF","Mediapunta","22");
        insertDataPlayer("15151515F","Federico Valverde","Real Madrid CF","Mediocentro","15");
        insertDataPlayer("11111111R","Rui Silva","Granada CF","Portero","1");

    }
    /*=========================================================================*/
    /*=================             TEAMS              =======================*/
    public void createDataBaseTeam(){
        String query = "CREATE TABLE TEAMS (Num_ID INTEGER PRIMARY KEY AUTOINCREMENT, ID_Equipo TEXT NOT NULL, Nombre_Equipo TEXT NOT NULL, Liga TEXT NOT NULL, Num_Jugadores TEXT NOT NULL, Presupuesto TEXT NOT NULL);";
        Connection con = null;
        try{
            con = this.connect();
            st = con.createStatement();
            rs =  st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBaseTeam(int Num_ID) {
        String sql = "DELETE FROM TEAMS WHERE Num_ID = ?";
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, Num_ID);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Eliminado correctamente fila" + Num_ID);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    
    public void insertDataTeam(String ID_Equipo,String Nombre_Equipo,String Liga,String Num_Jugadores,String Presupuesto){
        String insert = "INSERT INTO TEAMS (Num_ID, ID_Equipo, Nombre_Equipo, Liga, Num_Jugadores, Presupuesto) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        int Num_ID = Jugador_Controlador.playerArrayList.size() + 1;
        
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(insert);
                pstmt.setInt(1, Num_ID);
                pstmt.setString(2, ID_Equipo);
                pstmt.setString(3, Nombre_Equipo);
                pstmt.setString(4, Liga);
                pstmt.setString(5, Num_Jugadores);
                pstmt.setString(6, Presupuesto);
                
                pstmt.executeUpdate();
                System.out.println("Insertado equipo " + Nombre_Equipo);
                con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void updateDataTeam(String ID_Equipo,String Nombre_Equipo,String Liga,String Num_Jugadores,String Presupuesto) {
        String sql = "UPDATE TEAMS SET Nombre_Equipo = ? , "
                + "Liga = ? ,"
                + "Num_Jugadores = ? ,"
                + "Presupuesto = ? "
                + "WHERE ID_Equipo = ?";
        
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, Nombre_Equipo);
            pstmt.setString(2, Liga);
            pstmt.setString(3, Num_Jugadores);
            pstmt.setString(4, Presupuesto);
            pstmt.setString(5, ID_Equipo);
            
            // update 
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    public ArrayList mostrarTablaTeam(ArrayList <Equipo> teamArrayList){
        String full = "SELECT * FROM TEAMS";
        Connection con = null;
        
        try {
            con = this.connect();
            Statement stmt  = con.createStatement();
            ResultSet rs = stmt.executeQuery(full);
            
            // loop through the result set
            while (rs.next()) {
                Equipo equ = new Equipo();
                equ.setNum_ID(rs.getInt("Num_ID"));
                equ.setIDequipo(rs.getString("ID_Equipo"));
                equ.setNombre_eq(rs.getString("Nombre_Equipo"));
                equ.setLiga(rs.getString("Liga"));
                equ.setNumJugadores(rs.getString("Num_Jugadores"));
                equ.setPresupuesto(rs.getString("Presupuesto"));
                teamArrayList.add(equ);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return teamArrayList;
    }
    /*=========================================================================*/
    public void DataBaseTeam(){
        
        insertDataPlayer("GR","Granada CF","LALIGA","33", "25.000.000");
        insertDataPlayer("RM","Real Madrid CF","LALIGA","33","125.000.000");
        insertDataPlayer("JU","Juventus Turin","SERIEA","33","75.000.000");
        insertDataPlayer("MU","Murcia CF","LALIGA","33","6.000.000");
        insertDataPlayer("BAY","Bayern de Múnich","BUNDESLIGA","33","86.000.000");

    }
    /*=========================================================================*/
}