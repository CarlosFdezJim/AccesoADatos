

package Controlador;

import Modelo.Liga;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

public class CrearLigaXml {
    
    private ArrayList<Liga> leagueArray;
    
    public void CrearXML(){    
   /********************   LEER ARCHIVO    **************************/
   //   File fichero = new File("FichPlayer.dat");   
   //   RandomAccessFile file = new RandomAccessFile(fichero, "r");

   /*****   PERMITE CREAR ARBOL DE OBJETOS DOM A PARTIR DE XML    ******/     
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Ligas", null);
        document.setXmlVersion("1.0"); 

           /********************   RECOREMOS FICHERO    **************************/     

            

            
            Liga lg = new Liga();
            leagueArray = lg.DataBaseLeague();
            for(int i =0; i < leagueArray.size(); i++){
                Element raiz = document.createElement("Liga"); //nodo empleado
                document.getDocumentElement().appendChild(raiz); 
                    //Añadir DNI                       
                    CrearElemento("ID_Liga",leagueArray.get(i).getID_Liga(), raiz, document);
                    //Añadir Nombre
                    CrearElemento("Nombre_Liga",leagueArray.get(i).getNombre_Liga(), raiz, document); 
                    //Añadir Club
                    CrearElemento("Num_Equipos",leagueArray.get(i).getNum_Equipos(), raiz, document); 
                    //Añadir Posición
                    CrearElemento("Num_Ligas",leagueArray.get(i).getNum_Ligas(), raiz,document); 
                    //Añadir Dorsal
                    CrearElemento("Federacion",leagueArray.get(i).getFederacion(), raiz,document);
            }//fin del for que recorre el fichero

        /********************   CREAMOS DOM     **************************/
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Ligas.xml"));        
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
