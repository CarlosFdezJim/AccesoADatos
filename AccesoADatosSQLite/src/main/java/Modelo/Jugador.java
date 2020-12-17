/**
 * @author Fernández
 */

package Modelo;

import java.util.ArrayList;


public class Jugador{
    
    public static int cont_ID = 4;

    private Integer Num_ID = 0;
    private String DNI = "";
    private String Nombre_Jugador = "";
    private String Club = "";
    private String Posicion = "";
    private String Dorsal = "";
    
   public Jugador(){
       
   }
   
   public Jugador(String DNI, String Nombre, String Club, String Pos, String Dorsal){
       this.Num_ID = cont_ID + 1;
       this.DNI = DNI;
       this.Nombre_Jugador = Nombre;
       this.Club = Club;
       this.Posicion = Pos;
       this.Dorsal = Dorsal;
   }
   
    public void setNum_ID(Integer Num_ID) {
        this.Num_ID = Num_ID;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre_Jugador(String Nombre_Jugador) {
        this.Nombre_Jugador = Nombre_Jugador;
    }

    public void setClub(String Club) {
        this.Club = Club;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public void setDorsal(String Dorsal) {
        this.Dorsal = Dorsal;
    }
    
     public Integer getNum_ID() {
        return Num_ID;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre_Jugador() {
        return Nombre_Jugador;
    }

    public String getClub() {
        return Club;
    }

    public String getPosicion() {
        return Posicion;
    }

    public String getDorsal() {
        return Dorsal;
    }
    
    public ArrayList DataBasePlayer(){
    
        ArrayList<Jugador>vectorPlayer = new ArrayList<>();
            Jugador player1 = new Jugador("77777777C","Cristiano Ronaldo","Juventus Turin","Delantero","7");
            vectorPlayer.add(player1);
            Jugador player2 = new Jugador("22222222I","Isco","Real Madrid CF","Mediapunta","22");
            vectorPlayer.add(player2);
            Jugador player3 = new Jugador("15151515F","Federico Valverde","Real Madrid CF","Mediocentro","15");
            vectorPlayer.add(player3);
            Jugador player4 = new Jugador("11111111R","Rui Silva","Granada CF","Portero","1");
            vectorPlayer.add(player4);
            
        return vectorPlayer;
    }
}
