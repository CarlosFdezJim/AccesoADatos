

package Controlador;

import Modelo.Equipo;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

public class CrearEquipoXml {
    
    private ArrayList<Equipo> teamArray;
            
    public void CrearXML(){    
   /********************   LEER ARCHIVO    **************************/
   //   File fichero = new File("FichPlayer.dat");   
   //   RandomAccessFile file = new RandomAccessFile(fichero, "r");

   /*****   PERMITE CREAR ARBOL DE OBJETOS DOM A PARTIR DE XML    ******/     
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Equipos", null);
        document.setXmlVersion("1.0"); 

           /********************   RECOREMOS FICHERO    **************************/     

            

            
            Equipo eq = new Equipo();
            teamArray = eq.DataBaseTeam();
            for(int i =0; i < teamArray.size(); i++){
                Element raiz = document.createElement("Equipo"); //Elemento Raiz
                document.getDocumentElement().appendChild(raiz); 
                    //Añadir DNI                       
                    CrearElemento("ID_Equipo",teamArray.get(i).getIDequipo(), raiz, document);
                    //Añadir Nombre
                    CrearElemento("Nombre_Equipo",teamArray.get(i).getNombre_eq(), raiz, document); 
                    //Añadir Club
                    CrearElemento("Liga",teamArray.get(i).getLiga(), raiz, document); 
                    //Añadir Posición
                    CrearElemento("Num_Jugadores",teamArray.get(i).getNumJugadores(), raiz,document); 
                    //Añadir Dorsal
                    CrearElemento("Presupuesto",teamArray.get(i).getPresupuesto(), raiz,document);
            }//fin del for que recorre el fichero

        /********************   CREAMOS DOM     **************************/
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Equipos.xml"));        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

       }catch(Exception e){ System.err.println("Error: "+e); }
    	
}
 
 //Inserción de los datos del empleado
 static void  CrearElemento(String datoEmple, String valor,Element raiz, Document document){
     
    Element elem = document.createElement(datoEmple); 
    Text text = document.createTextNode(valor); //damos valor
    raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
    elem.appendChild(text); //pegamos el valor		 	
 }
}//fin de la clase
