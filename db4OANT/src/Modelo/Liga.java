/**
 * @author Fernández
 */

package Modelo;

import java.util.ArrayList;


public class Liga {
    
    public static int cont_ID = 6;

    private int Num_ID = 0;
    private String ID_Liga = "";
    private String Nombre_Liga = "";
    private String Num_Equipos = "";
    private String Num_Ligas = "";
    private String Federacion = "";

    public Liga() {
    }

    public Liga(String ID,String Nombre, String Numero_Equipos, String Numero_ligas, String Federacion){
        this.Num_ID = cont_ID + 1;
        this.ID_Liga = ID;
        this.Nombre_Liga = Nombre;
        this.Num_Equipos = Numero_Equipos;
        this.Num_Ligas = Numero_ligas;
        this.Federacion = Federacion;
    }

    public void setNum_ID(Integer Num_ID) {
        this.Num_ID = Num_ID;
    }
    
    public void setID_Liga(String ID_Liga) {
        this.ID_Liga = ID_Liga;
    }

    public void setNombre_Liga(String Nombre_Liga) {
        this.Nombre_Liga = Nombre_Liga;
    }

    public void setNum_Equipos(String Num_Equipos) {
        this.Num_Equipos = Num_Equipos;
    }

    public void setNum_Ligas(String Num_Ligas) {
        this.Num_Ligas = Num_Ligas;
    }

    public void setFederacion(String Federacion) {
        this.Federacion = Federacion;
    }

    public Integer getNum_ID() {
        return Num_ID;
    }

    public String getID_Liga() {
        return ID_Liga;
    }

    public String getNombre_Liga() {
        return Nombre_Liga;
    }

    public String getNum_Equipos() {
        return Num_Equipos;
    }

    public String getNum_Ligas() {
        return Num_Ligas;
    }

    public String getFederacion() {
        return Federacion;
    }
    
    public ArrayList DataBaseLeague(){
        
        ArrayList<Liga> vectorLeague = new ArrayList<>();
            Liga league1 = new Liga("LALIGA","LaLiga Santander","20","9", "Española");
            vectorLeague.add(league1);
            Liga league2 = new Liga("LIGUE1","Ligue 1","20","9","Francesa");
            vectorLeague.add(league2);
            Liga league3 = new Liga("SERIEA","Serie A","20","9","Italiana");
            vectorLeague.add(league3);
            Liga league4 = new Liga("BUNDESLIGA","Bundesliga","20","6","Alemana");
            vectorLeague.add(league4);
            Liga league5 = new Liga("PREMIER","Premier League","20","4","Inglesa");
            vectorLeague.add(league5);
            
        return vectorLeague;
    }
}
