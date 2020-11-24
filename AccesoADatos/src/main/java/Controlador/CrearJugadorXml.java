

package Controlador;

import Modelo.Jugador;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

public class CrearJugadorXml {
    
    private ArrayList<Jugador> playerArray;
    
    public void CrearXML(){    
        
   /********************   LEER ARCHIVO    **************************/
   //   File fichero = new File("FichPlayer.dat");   
   //   RandomAccessFile file = new RandomAccessFile(fichero, "r");

   /*****   PERMITE CREAR ARBOL DE OBJETOS DOM A PARTIR DE XML    ******/     
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Jugadores", null);
        document.setXmlVersion("1.0"); 

           /********************   RECOREMOS FICHERO    **************************/     
            
            Jugador jg = new Jugador();
            playerArray = jg.DataBasePlayer();
            for(int i =0; i < playerArray.size(); i++){
                Element raiz = document.createElement("Jugador"); //nodo empleado
                document.getDocumentElement().appendChild(raiz); 
                    //Añadir DNI                       
                    CrearElemento("DNI",playerArray.get(i).getDNI(), raiz, document);
                    //Añadir Nombre
                    CrearElemento("Nombre_Jugador",playerArray.get(i).getNombre_Jugador(), raiz, document); 
                    //Añadir Club
                    CrearElemento("Club",playerArray.get(i).getClub(), raiz, document); 
                    //Añadir Posición
                    CrearElemento("Posicion",playerArray.get(i).getPosicion(), raiz,document); 
                    //Añadir Dorsal
                    CrearElemento("Dorsal",playerArray.get(i).getDorsal(), raiz,document);
            }//fin del for que recorre el fichero

        /********************   CREAMOS DOM     **************************/
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Jugadores.xml"));        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

       }catch(Exception e){ System.err.println("Error: "+e); }
    
   //    file.close();  //cerrar fichero 	
}
 
 //Inserción de los datos del empleado
 static void  CrearElemento(String datoEmple, String valor,Element raiz, Document document){
     
    Element elem = document.createElement(datoEmple); 
    Text text = document.createTextNode(valor); //damos valor
    raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
    elem.appendChild(text); //pegamos el valor		 	
 }
}//fin de la clase

