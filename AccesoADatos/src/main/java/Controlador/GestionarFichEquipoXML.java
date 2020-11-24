/**
 * @author Fernández
 */

package Controlador;

import Modelo.Equipo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GestionarFichEquipoXML extends DefaultHandler {
    
    private Equipo equi;
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        switch(qName){
            case "Equipos":
                break;
            case "Equipo":
                break;
            case "ID_Equipo":
                equi.setIDequipo(buffer.toString());
                break;
            case "Nombre_Equipo":
                equi.setNombre_eq(buffer.toString());
                break;
            case "Liga":
                equi.setLiga(buffer.toString());
                break;
            case "Num_Jugadores":
                equi.setNumJugadores(buffer.toString());
                break;
            case "Presupuesto":
                equi.setPresupuesto(buffer.toString());
                break;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        buffer.append(ch,start,length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        switch(qName){
            case "Equipos":
                break;
            case "Equipo":
                equi = new Equipo();
                Equipos_Controlador.teamArrayList.add(equi);
                break;
            case "ID_Equipo":
            case "Nombre_Equipo":
            case "Liga":
            case "Num_Jugadores":
            case "Presupuesto":
                buffer.delete(0, buffer.length());
                break;
        
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Final del Documento XML Equipo");
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Comienzo del Documento XML Equipo");
    }

//            public GestionarFichEquipoXML() {
//                super();
//            }	    
//            public void startDocument() {
//                System.out.println("Comienzo del Documento XML");
//            }	    
//            public void endDocument() {
//                
//            }	 	    
//            public void startElement(String uri, String nombre,String nombreC, Attributes atts) {
//                System.out.printf("\t Principio Elemento: %s %n",nombre);	 	        
//            } 	
//            public void endElement(String uri, String nombre, 
//                          String nombreC) {
//                System.out.printf("\tFin Elemento: %s %n", nombre);
//            }	
//            public void characters(char[] ch, int inicio, int longitud) throws SAXException {
//                   String car = new String(ch, inicio, longitud);
//                   //quitar saltos de línea	
//                   car = car.replaceAll("[\t\n]","");	   
//                   System.out.printf ("\t Caracteres: %s %n", car);		
//            }	

}//fin GestionarFichEquipoXML
