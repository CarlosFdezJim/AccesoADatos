/**
 * @author Fernández
 */

package Controlador;

import static Controlador.CrearLigaXml.CrearElemento;
import static Controlador.Liga_Controlador.leagueArrayList;
import Modelo.Equipo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class Equipos_Controlador implements ActionListener{
 
    Vista MiVista;
    DefaultTableModel modeloTeam;
    public static ArrayList<Equipo> teamArrayList = new ArrayList<Equipo>();

    public Equipos_Controlador(Vista MiVista) {
        this.MiVista = MiVista;
        this.MiVista.jButtonInsertar_Equipos.addActionListener(this);
        this.MiVista.jButtonEliminar_Equipos.addActionListener(this);
        this.MiVista.jButtonModificar_Equipos.addActionListener(this);
        
        this.MiVista.txtID_Equipos.addActionListener(this);
        this.MiVista.txtNombre_Equipos.addActionListener(this);
        this.MiVista.txtLiga_Equipos.addActionListener(this);
        this.MiVista.txtNumJugadores_Equipos.addActionListener(this);
        this.MiVista.txtPresupuesto_Equipos.addActionListener(this);
        
        this.MiVista.jButtonAceptar_Equipos.addActionListener(this);
        this.MiVista.jButtonCancelar_Equipos.addActionListener(this);
        
    }
    
    public void insertarDatos() throws IOException{
         int fila = 0;
        
        for(int i = 0; i< teamArrayList.size();i++){
            if(this.MiVista.txtID_Equipos.getText().equals(this.teamArrayList.get(i).getIDequipo())){
                fila = i;
            }
        }       
        if(this.MiVista.txtID_Equipos.getText().equals(this.teamArrayList.get(fila).getIDequipo())){
            JOptionPane.showMessageDialog(MiVista, "El ID ya está introducido, NO se han actualizado los datos");
        }else{
            Equipo eq1 = new Equipo();
            eq1.setIDequipo(this.MiVista.txtID_Equipos.getText());
            eq1.setNombre_eq(this.MiVista.txtNombre_Equipos.getText());
            eq1.setLiga(this.MiVista.txtLiga_Equipos.getText());
            eq1.setNumJugadores(this.MiVista.txtNumJugadores_Equipos.getText());
            eq1.setPresupuesto(this.MiVista.txtPresupuesto_Equipos.getText());
            teamArrayList.add(eq1);
        
        
            String[] datos = new String[5];
            datos[0] = this.MiVista.txtID_Equipos.getText();
            datos[1] = this.MiVista.txtNombre_Equipos.getText();
            datos[2] = this.MiVista.txtLiga_Equipos.getText();
            datos[3] = this.MiVista.txtNumJugadores_Equipos.getText();
            datos[4] = this.MiVista.txtPresupuesto_Equipos.getText();

            modeloTeam.addRow(datos);
            mostrarEnTabla(teamArrayList);
            EscribirFichero();
        }
        
    }
    
    public void actualizarDatos() throws IOException{
        int fila = MiVista.jTableEquipos.getSelectedRow();
        
        Equipo eq1 = new Equipo();
        eq1.setIDequipo(this.MiVista.txtID_Equipos.getText());
        eq1.setNombre_eq(this.MiVista.txtNombre_Equipos.getText());
        eq1.setLiga(this.MiVista.txtLiga_Equipos.getText());
        eq1.setNumJugadores(this.MiVista.txtNumJugadores_Equipos.getText());
        eq1.setPresupuesto(this.MiVista.txtPresupuesto_Equipos.getText());
        teamArrayList.set(fila, eq1);
        
        String ID = this.MiVista.txtID_Equipos.getText();
        String Nombre = this.MiVista.txtNombre_Equipos.getText();
        String Empleados = this.MiVista.txtLiga_Equipos.getText();
        String NumJugadores = this.MiVista.txtNumJugadores_Equipos.getText();
        String Presupuesto = this.MiVista.txtPresupuesto_Equipos.getText();
        
        modeloTeam.setValueAt(ID, MiVista.jTableEquipos.getSelectedRow(), 0);
        modeloTeam.setValueAt(Nombre, MiVista.jTableEquipos.getSelectedRow(), 1);
        modeloTeam.setValueAt(Empleados, MiVista.jTableEquipos.getSelectedRow(), 2);
        modeloTeam.setValueAt(NumJugadores, MiVista.jTableEquipos.getSelectedRow(), 3);
        modeloTeam.setValueAt(Presupuesto, MiVista.jTableEquipos.getSelectedRow(), 4);
        
        EscribirFichero();
        
        JOptionPane.showMessageDialog(MiVista, "Update Successfully...");
    }
    
    public void deleteData() throws IOException{
        int fila = MiVista.jTableEquipos.getSelectedRow();
        boolean encontrado = false;

        for(int i = 0; i < Jugador_Controlador.playerArrayList.size(); i++){
            if(this.teamArrayList.get(fila).getNombre_eq().equals(Jugador_Controlador.playerArrayList.get(i).getClub())){
                encontrado = true;
            }
        }
        if(encontrado == false){
            modeloTeam.removeRow(fila);//elimino de la tabla
            teamArrayList.remove(fila);//elimino del arraylist
            EscribirFichero();
        }else{
            JOptionPane.showMessageDialog(MiVista, "No se puede eliminar esta Equipo porque tiene jugadores relacionados.");
        }
       
    }
    /*=========================================================================*/
    public void deleteTextView_Equipos(){
        this.MiVista.txtID_Equipos.setText("");
        this.MiVista.txtNombre_Equipos.setText("");
        this.MiVista.txtLiga_Equipos.setText("");
        this.MiVista.txtNumJugadores_Equipos.setText("");
        this.MiVista.txtPresupuesto_Equipos.setText("");
    }
    /*=========================================================================*/
    public void enableTextView_Equipos(){
        this.MiVista.txtID_Equipos.setEnabled(true);
        this.MiVista.txtNombre_Equipos.setEnabled(true);
        this.MiVista.txtLiga_Equipos.setEnabled(true);
        this.MiVista.txtNumJugadores_Equipos.setEnabled(true);
        this.MiVista.txtPresupuesto_Equipos.setEnabled(true);
    }
    
    public void disableTextView_Equipos(){
        this.MiVista.txtID_Equipos.setEnabled(false);
        this.MiVista.txtNombre_Equipos.setEnabled(false);
        this.MiVista.txtLiga_Equipos.setEnabled(false);
        this.MiVista.txtNumJugadores_Equipos.setEnabled(false);
        this.MiVista.txtPresupuesto_Equipos.setEnabled(false);
    }
    /*=========================================================================*/
 
    public void enableControlPanel_Equipos(){
        this.MiVista.jButtonInsertar_Equipos.setEnabled(true);
        this.MiVista.jButtonEliminar_Equipos.setEnabled(true);
        this.MiVista.jButtonModificar_Equipos.setEnabled(true);
    }
    public void disableControlPanel_Equipos(){
       this.MiVista.jButtonInsertar_Equipos.setEnabled(false);
       this.MiVista.jButtonEliminar_Equipos.setEnabled(false);
       this. MiVista.jButtonModificar_Equipos.setEnabled(false);
    }
    /*=========================================================================*/
    public void enablecontrolTextView_Equipos(){
        this.MiVista.jButtonAceptar_Equipos.setEnabled(true);
        this.MiVista.jButtonCancelar_Equipos.setEnabled(true);        
    }
    
    public void disablecontrolTextView_Equipos(){
        this.MiVista.jButtonAceptar_Equipos.setEnabled(false);
        this.MiVista.jButtonCancelar_Equipos.setEnabled(false);        
    }
    /*=========================================================================*/
    public void visibleControlTextView_Equipos(boolean visible){
        if(visible == true){
            this.MiVista.jButtonAceptar_Equipos.setVisible(true);
            this.MiVista.jButtonCancelar_Equipos.setVisible(true);
        }else{
            this.MiVista.jButtonAceptar_Equipos.setVisible(false);
            this.MiVista.jButtonCancelar_Equipos.setVisible(false);
        }
    }
    /*=========================================================================*/
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == this.MiVista.jButtonAceptar_Equipos){
            try {
                insertarDatos();
                EscribirFichero();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(evento.getSource() == this.MiVista.jButtonCancelar_Equipos){
            deleteTextView_Equipos();
        }
        
        if(evento.getSource() == this.MiVista.jButtonInsertar_Equipos){
            mostrarEnTabla(teamArrayList);
            visibleControlTextView_Equipos(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonEliminar_Equipos){
            try {
                deleteData();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteTextView_Equipos();
            visibleControlTextView_Equipos(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Equipos){
            try {
                actualizarDatos();
                EscribirFichero();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            visibleControlTextView_Equipos(true);
        }
            
        try {
            EscribirFichero();
        } catch (IOException ex) {
            Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
            mostrarEnTabla(teamArrayList);
            visibleControlTextView_Equipos(true);
            actualizarComboBoxJugador();
            deleteTextView_Equipos();
    }

    /*=========================================================================*/
    public void loadDatabaseTeam() throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException{
        
        modeloTeam = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        
        this.MiVista.jTableEquipos.setModel(modeloTeam);
        
        ArrayList<String> nombreColumnaTeam = new ArrayList<String>();
            nombreColumnaTeam.add("ID");
            nombreColumnaTeam.add("Nombre");
            nombreColumnaTeam.add("Liga");
            nombreColumnaTeam.add("Nº Jugadores");
            nombreColumnaTeam.add("Presupuesto");

        for(String columna: nombreColumnaTeam){
            modeloTeam.addColumn(columna);
        }
        
        visibleControlTextView_Equipos(false);
        cargarDataBaseOLeerFichero(false);
        actualizarComboBoxJugador();
       
    }
    
        public void cargarDataBaseOLeerFichero(boolean crear) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException{
        
        if(crear == true){
            Equipo ObtenerEquipo = new Equipo();
            teamArrayList = ObtenerEquipo.DataBaseTeam();
            this.mostrarEnTabla(teamArrayList);
            EscribirFichero();
            actualizarComboBoxJugador();
        }else{
            
            mostrarEnTabla(teamArrayList);
            actualizarComboBoxJugador();
            LeerFichero();
            
         }
    }
 /*=========================================================================*/   
    public void EscribirFichero() throws FileNotFoundException, IOException {

     System.out.println("Escribiendo en el fichero Equipos...");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Equipos", null);
        document.setXmlVersion("1.0"); 

        /********************   RECOREMOS FICHERO    **************************/     
            
        for(int i =0; i < teamArrayList.size(); i++){
            Element raiz = document.createElement("Equipo"); //nodo empleado
            document.getDocumentElement().appendChild(raiz); 
                //Añadir DNI                       
                CrearElemento("ID_Equipo",teamArrayList.get(i).getIDequipo(), raiz, document);
                //Añadir Nombre
                CrearElemento("Nombre_Equipo",teamArrayList.get(i).getNombre_eq(), raiz, document); 
                //Añadir Club
                CrearElemento("Liga",teamArrayList.get(i).getLiga(), raiz, document); 
                //Añadir Posición
                CrearElemento("Num_Jugadores",teamArrayList.get(i).getNumJugadores(), raiz,document); 
                //Añadir Dorsal
                CrearElemento("Presupuesto",teamArrayList.get(i).getPresupuesto(), raiz,document);
        }//fin del for que recorre el fichero

        /********************   CREAMOS DOM     **************************/
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Equipos.xml"));        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

       }catch(Exception e){ System.err.println("Error: "+e); } 
    }
    
    public void LeerFichero() throws FileNotFoundException, IOException, ClassNotFoundException, SAXException, ParserConfigurationException {
    	
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader  procesadorXML = parser.getXMLReader();
        GestionarFichEquipoXML gestor= new GestionarFichEquipoXML();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("Equipos.xml"); 
        procesadorXML.parse(fileXML);

        mostrarEnTabla(teamArrayList);
    }
        /*=========================================================================*/
        public void mostrarEnTabla(ArrayList<Equipo> teamArrayList){
            
            modeloTeam.setRowCount(0);
            Object[] vectorObject = new Object[5];

            for(int i = 0; i < teamArrayList.size();i++){
                vectorObject[0] = teamArrayList.get(i).getIDequipo();
                vectorObject[1] = teamArrayList.get(i).getNombre_eq();
                vectorObject[2] = teamArrayList.get(i).getLiga();
                vectorObject[3] = teamArrayList.get(i).getNumJugadores();
                vectorObject[4] = teamArrayList.get(i).getPresupuesto();

                modeloTeam.addRow(vectorObject);
            }
        }
        
        public void actualizarComboBoxJugador(){
            
            this.MiVista.jComboBoxJugador.removeAllItems();
                for(int i = 0; i < teamArrayList.size();i++){
                    this.MiVista.jComboBoxJugador.addItem(teamArrayList.get(i).getNombre_eq());

                }
                this.MiVista.txtClub_Jugadores.setEnabled(false);
        }
        
        
}