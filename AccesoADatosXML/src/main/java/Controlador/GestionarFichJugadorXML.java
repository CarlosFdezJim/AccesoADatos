/**
 * @author Fernández
 */

package Controlador;

import Modelo.Jugador;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GestionarFichJugadorXML extends DefaultHandler {	 
    
    private Jugador jg;
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        switch(qName){
            case "Jugadores":
                break;
            case "Jugador":
                break;
            case "DNI":
                jg.setDNI(buffer.toString());
                break;
            case "Nombre_Jugador":
                jg.setNombre_Jugador(buffer.toString());
                break;
            case "Club":
                jg.setClub(buffer.toString());
                break;
            case "Posicion":
                jg.setPosicion(buffer.toString());
                break;
            case "Dorsal":
                jg.setDorsal(buffer.toString());
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
            case "Jugadores":
                break;
            case "Jugador":
                jg = new Jugador();
                Jugador_Controlador.playerArrayList.add(jg);
                break;
            case "DNI":
            case "Nombre_Jugador":
            case "Club":
            case "Posicion":
            case "Dorsal":
                buffer.delete(0, buffer.length());
                break;
        
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Final del Documento XML Jugador");
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Comienzo del Documento XML Jugador");
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
