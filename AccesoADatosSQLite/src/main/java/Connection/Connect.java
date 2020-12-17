/**
 * @author Fernández
 */

package Connection;

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
    public Statement st;
    public ResultSet rs;

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
        String query = "CREATE TABLE IF NOT EXISTS Ligas (Num_ID TEXT PRIMARY KEY, ID TEXT, Nombre TEXT, Num_Equipos TEXT, Num_Ligas TEXT, Federacion TEXT);";
        Connection con = null;
        try{
            con = this.connect();
            Statement st = con.createStatement();
            st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBaseLeague(int Num_ID) {
        String sql = "DELETE FROM Ligas WHERE Num_ID = ?";
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
    
    public void insertDataLeague(int Num_ID, String ID,String Nombre,String Num_Equipos,String Num_Ligas,String Federacion){
        String insert = "INSERT INTO Ligas (Num_ID, ID, Nombre, Num_Equipos, Num_Ligas, Federacion) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        
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
        String sql = "UPDATE Ligas SET ID = ?,"
                + "Nombre = ? , "
                + "Num_Equipos = ? ,"
                + "Num_Ligas = ? ,"
                + "Federacion = ? "
                + "WHERE ID = ?";
        
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, ID);
            pstmt.setString(2, Nombre);
            pstmt.setString(3, Num_Equipos);
            pstmt.setString(4, Num_Ligas);
            pstmt.setString(5, Federacion);
            pstmt.setString(6, ID);
            
            // update 
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    public ArrayList mostrarTablaLeague(ArrayList <Liga> leagueArrayList){
        String full = "SELECT * FROM Ligas";
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
        
        insertDataLeague(1, "LALIGA", "La Liga", "20", "9", "Española");
        insertDataLeague(2, "LIGUE1", "Ligue 1", "20", "9", "Francesa");
        insertDataLeague(3, "SERIEA", "Serie A", "20", "9", "Italiana");
        insertDataLeague(4, "BUNDESLIGA", "Bundesliga", "20", "6", "Alemana");
        insertDataLeague(5, "PREMIER", "Premier League", "20", "4", "Inglesa");

    }
    /*=========================================================================*/
    /*=================             PLAYER              =======================*/
    public void createDataBasePlayer(){
        String query = "CREATE TABLE IF NOT EXISTS Jugadores (Num_ID TEXT PRIMARY KEY , DNI TEXT , Nombre_Jugador TEXT, Club TEXT , Posicion TEXT , Dorsal TEXT);";
        Connection con = null;
        try{
            con = this.connect();
            Statement st = con.createStatement();
            st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBasePlayer(int Num_ID) {
        String sql = "DELETE FROM Jugadores WHERE Num_ID = ?";
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
    
    public void insertDataPlayer(int Num_ID, String DNI,String Nombre_Jugador,String Club,String Posicion,String Dorsal){
        String insert = "INSERT INTO Jugadores (Num_ID, DNI, Nombre_Jugador, Club, Posicion, Dorsal) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        
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
                System.out.println("Insertado Jugador " + Nombre_Jugador);
                con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void updateDataPlayer(String DNI,String Nombre_Jugador,String Club,String Posicion,String Dorsal) {
        String sql = "UPDATE Jugadores SET DNI = ?,"
                + "Nombre_Jugador = ? , "
                + "Club = ? ,"
                + "Posicion = ? ,"
                + "Dorsal = ? "
                + "WHERE DNI = ?";
        
        Connection con = null;
        try {
            con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, DNI);
            pstmt.setString(2, Nombre_Jugador);
            pstmt.setString(3, Club);
            pstmt.setString(4, Posicion);
            pstmt.setString(5, Dorsal);
            pstmt.setString(6, DNI);
            
            // update 
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*=========================================================================*/
    public ArrayList mostrarTablaPlayer(ArrayList <Jugador> playerArrayList){
        String full = "SELECT * FROM Jugadores";
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
        
        insertDataPlayer(1, "77777777C","Cristiano Ronaldo","Juventus Turin","Delantero","7");
        insertDataPlayer(2, "22222222I","Isco","Real Madrid CF","Mediapunta","22");
        insertDataPlayer(3, "15151515F","Federico Valverde","Real Madrid CF","Mediocentro","15");
        insertDataPlayer(4, "11111111R","Rui Silva","Granada CF","Portero","1");

    }
    /*=========================================================================*/
    /*=================             TEAMS              =======================*/
    public void createDataBaseTeam(){
        String query = "CREATE TABLE IF NOT EXISTS Equipos (Num_ID INTEGER PRIMARY KEY, ID_Equipo TEXT NOT NULL, Nombre_Equipo TEXT NOT NULL, Liga TEXT NOT NULL, Num_Jugadores TEXT NOT NULL, Presupuesto TEXT NOT NULL);";
        Connection con = null;
        try{
            con = this.connect();
            st = con.createStatement();
            st.executeQuery(query);
            
            System.out.println("Conexión terminada...");
            con.close();
        } catch (SQLException e) {
            System.err.println("Error de conexión " + e);
        }
    }
    public void deleteRowDataBaseTeam(int Num_ID) {
        String sql = "DELETE FROM Equipos WHERE Num_ID = ?";
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
    
    public void insertDataTeam(int Num_ID, String ID_Equipo,String Nombre_Equipo,String Liga,String Num_Jugadores,String Presupuesto){
        String insert = "INSERT INTO Equipos (Num_ID, ID_Equipo, Nombre_Equipo, Liga, Num_Jugadores, Presupuesto) VALUES (?,?,?,?,?,?);";
        Connection con = null;
        
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
        String sql = "UPDATE Equipos SET ID_Equipo = ?,"
                + "Nombre_Equipo = ? ,"
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
        String full = "SELECT * FROM Equipos";
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
        
        insertDataTeam(1, "GR","Granada CF","LALIGA","33", "25.000.000");
        insertDataTeam(2, "RM","Real Madrid CF","LALIGA","33","125.000.000");
        insertDataTeam(3, "JU","Juventus Turin","SERIEA","33","75.000.000");
        insertDataTeam(4, "MU","Murcia CF","LALIGA","33","6.000.000");
        insertDataTeam(5, "BAY","Bayern de Múnich","BUNDESLIGA","33","86.000.000");

    }
    /*=========================================================================*/
}