/**
 * @author Fernández
 */

package Modelo;

import java.util.ArrayList;


public class Equipo{
    
    public static int cont_ID = 5;
    
    private Integer Num_ID = 0;
    private String ID_Equipo = "";
    private String Nombre_Equipo = "";
    private String Liga = "";
    private String Num_Jugadores = "";
    private String Presupuesto = "";

    public Equipo() {
    }
    
    public Equipo(String ID, String Nombre, String Ligas, String Numero, String Presupuesto) {
        
        this.Num_ID = cont_ID + 1;
        this.ID_Equipo = ID;
        this.Nombre_Equipo = Nombre;
        this.Liga = Ligas;
        this.Num_Jugadores = Numero;
        this.Presupuesto = Presupuesto;
    }

    public void setNum_ID(Integer Num_ID) {
        this.Num_ID = Num_ID;
    }
    public void setIDequipo(String ID_Equipo) {
        this.ID_Equipo = ID_Equipo;
    }

    public void setNombre_eq(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public void setLiga(String Liga) {
        this.Liga = Liga;
    }

    public void setNumJugadores(String Num_Jugadores) {
        this.Num_Jugadores = Num_Jugadores;
    }

    public void setPresupuesto(String Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public Integer getNum_ID() {
        return Num_ID;
    }
    
    public String getIDequipo() {
        return ID_Equipo;
    }

    public String getNombre_eq() {
        return Nombre_Equipo;
    }

    public String getLiga() {
        return Liga;
    }

    public String getNumJugadores() {
        return Num_Jugadores;
    }

    public String getPresupuesto() {
        return Presupuesto;
    }
    
    public ArrayList DataBaseTeam(){
    
        ArrayList<Equipo> vectorTeam = new ArrayList<>();
            Equipo team1 = new Equipo("GR","Granada CF","LALIGA","33", "25.000.000");
            vectorTeam.add(team1);
            Equipo team2 = new Equipo("RM","Real Madrid CF","LALIGA","33","125.000.000");
            vectorTeam.add(team2);
            Equipo team3 = new Equipo("JU","Juventus Turin","SERIEA","33","75.000.000");
            vectorTeam.add(team3);
            Equipo team4 = new Equipo("MU","Murcia CF","LALIGA","33","6.000.000");
            vectorTeam.add(team4);
            Equipo team5 = new Equipo("BAY","Bayern de Múnich","BUNDESLIGA","33","86.000.000");
            vectorTeam.add(team5);
            
        return vectorTeam;
    }
}
