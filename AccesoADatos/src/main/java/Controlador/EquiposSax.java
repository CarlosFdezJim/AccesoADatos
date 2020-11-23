/**
 * @author Fernández
 */

package Controlador;

import Modelo.Equipo;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


public class EquiposSax {
    
    public void LeerXML() throws SAXException, ParserConfigurationException, IOException{
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        File file = new File("Equipos.xml");
        GestionContenido handler = new GestionContenido();
        parser.parse(file, handler);

        ArrayList<Equipo> teamArrayList = handler.getTeamArray();

        for(Equipo eq : teamArrayList){
            System.out.println(eq);
        }
    }
//	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException{
//	
//            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
//            SAXParser parser = parserFactory.newSAXParser();
//            File file = new File("Equipos.xml");
//            GestionContenido handler = new GestionContenido();
//            parser.parse(file, handler);
//            
//            ArrayList<Equipo> teamArrayList = handler.getTeamArray();
//            
//            for(Equipo eq : teamArrayList){
//                System.out.println(eq);
//            }
//            
//            
//            XMLReader procesadorXML = parser.getXMLReader();
//            procesadorXML = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
//            GestionContenido gestor= new GestionContenido();  
//            procesadorXML.setContentHandler(gestor);
//            InputSource fileXML = new InputSource("Equipos.xml");
//            procesadorXML.parse(fileXML);    	      
//	}
}//fin PruebaSax1


