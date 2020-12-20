/**
 * @author Fernández
 */

package Controlador;

import static Controlador.CrearLigaXml.CrearElemento;
import Modelo.Liga;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class Liga_Controlador implements ActionListener {
    
    Vista MiVista;
    DefaultTableModel modeloLeague;
    public static ArrayList<Liga> leagueArrayList = new ArrayList<Liga>();
    boolean insertar = false;
    boolean modificar = false;
    boolean eliminar = false;
    
 
    public Liga_Controlador(Vista MiVista) {
        this.MiVista = MiVista;
        this.MiVista.jButtonInsertar_Ligas.addActionListener(this);
        this.MiVista.jButtonEliminar_Ligas.addActionListener(this);
        this.MiVista.jButtonModificar_Ligas.addActionListener(this);
        
        this.MiVista.txtID_Ligas.addActionListener(this);
        this.MiVista.txtNombre_Ligas.addActionListener(this);
        this.MiVista.txtNumEquipos_Ligas.addActionListener(this);
        this.MiVista.txtNumLigas_Ligas.addActionListener(this);
        this.MiVista.txtFederacion_Ligas.addActionListener(this);
        
        this.MiVista.jButtonAceptar_Ligas.addActionListener(this);
        this.MiVista.jButtonCancelar_Ligas.addActionListener(this);
    }

    public void insertarDatos() throws IOException{
        int fila = 0;
        
        for(int i = 0; i< leagueArrayList.size();i++){
            if(this.MiVista.txtID_Ligas.getText().equals(this.leagueArrayList.get(i).getID_Liga())){
                fila = i;
            }
        }
        
        if(this.MiVista.txtID_Ligas.getText().equals(this.leagueArrayList.get(fila).getID_Liga())){ 
            JOptionPane.showMessageDialog(MiVista, "El ID ya está introducido, NO se han actualizado los datos");
            
        }else{
            Liga lg1 = new Liga();
            lg1.setID_Liga(this.MiVista.txtID_Ligas.getText());
            lg1.setNombre_Liga(this.MiVista.txtNombre_Ligas.getText());
            lg1.setNum_Equipos(this.MiVista.txtNumEquipos_Ligas.getText());
            lg1.setNum_Ligas(this.MiVista.txtNumLigas_Ligas.getText());
            lg1.setFederacion(this.MiVista.txtFederacion_Ligas.getText());
            leagueArrayList.add(lg1);

            String[] datos = new String[5];
            datos[0] = this.MiVista.txtID_Ligas.getText();
            datos[1] = this.MiVista.txtNombre_Ligas.getText();
            datos[2] = this.MiVista.txtNumEquipos_Ligas.getText();
            datos[3] = this.MiVista.txtNumLigas_Ligas.getText();
            datos[4] = this.MiVista.txtFederacion_Ligas.getText();

            modeloLeague.addRow(datos);
            mostrarEnTabla(leagueArrayList);
            EscribirFichero();
        }
    }
    
    public void actualizarDatos() throws IOException{
        int fila = MiVista.jTableLigas.getSelectedRow();
        
        Liga lg1 = new Liga();
        lg1.setID_Liga(this.MiVista.txtID_Ligas.getText());
        lg1.setNombre_Liga(this.MiVista.txtNombre_Ligas.getText());
        lg1.setNum_Equipos(this.MiVista.txtNumEquipos_Ligas.getText());
        lg1.setNum_Ligas(this.MiVista.txtNumLigas_Ligas.getText());
        lg1.setFederacion(this.MiVista.txtFederacion_Ligas.getText());
        leagueArrayList.set(fila, lg1);
        
        String ID = this.MiVista.txtID_Ligas.getText();
        String Nombre = this.MiVista.txtNombre_Ligas.getText();
        String NumEquipos = this.MiVista.txtNumEquipos_Ligas.getText();
        String NumLigas = this.MiVista.txtNumLigas_Ligas.getText();
        String Federacion = this.MiVista.txtFederacion_Ligas.getText();
        
        modeloLeague.setValueAt(ID, MiVista.jTableLigas.getSelectedRow(), 0);
        modeloLeague.setValueAt(Nombre, MiVista.jTableLigas.getSelectedRow(), 1);
        modeloLeague.setValueAt(NumEquipos, MiVista.jTableLigas.getSelectedRow(), 2);
        modeloLeague.setValueAt(NumLigas, MiVista.jTableLigas.getSelectedRow(), 3);
        modeloLeague.setValueAt(Federacion, MiVista.jTableLigas.getSelectedRow(), 4);
        
        EscribirFichero();
        
        JOptionPane.showMessageDialog(MiVista, "Update Successfully...");
    }
    
    public void deleteData() throws IOException{
        int fila = MiVista.jTableLigas.getSelectedRow();
        boolean encontrado = false;

        for(int i = 0; i < Equipos_Controlador.teamArrayList.size(); i++){
            if(this.leagueArrayList.get(fila).getID_Liga().equals(Equipos_Controlador.teamArrayList.get(i).getLiga())){
                encontrado = true;
            }
        }
        if(encontrado == false){
            modeloLeague.removeRow(fila);
            leagueArrayList.remove(fila);//elimino del arraylist
            EscribirFichero();
        }else{
            JOptionPane.showMessageDialog(MiVista, "No se puede eliminar esta Liga porque tiene equipos relacionados.");
        }
    }
  
    /*=========================================================================*/
    public void deleteTextView_Liga(){
        this.MiVista.txtID_Ligas.setText("");
        this.MiVista.txtNombre_Ligas.setText("");
        this.MiVista.txtNumEquipos_Ligas.setText("");
        this.MiVista.txtNumLigas_Ligas.setText("");
        this.MiVista.txtFederacion_Ligas.setText("");

    }
 /*=========================================================================*/   
    public void enableTextView_Liga(){
        this.MiVista.txtID_Ligas.setEnabled(true);
        this.MiVista.txtNombre_Ligas.setEnabled(true);
        this.MiVista.txtNumEquipos_Ligas.setEnabled(true);
        this.MiVista.txtNumLigas_Ligas.setEnabled(true);
        this.MiVista.txtFederacion_Ligas.setEnabled(true);
    }
    
    public void disableTextView_Liga(){
        this.MiVista.txtID_Ligas.setEnabled(false);
        this.MiVista.txtNombre_Ligas.setEnabled(false);
        this.MiVista.txtNumEquipos_Ligas.setEnabled(false);
        this.MiVista.txtNumLigas_Ligas.setEnabled(false);
        this.MiVista.txtFederacion_Ligas.setEnabled(false);
    }
/*=========================================================================*/     
    public void enableControlPanel_Liga(){
        this.MiVista.jButtonInsertar_Ligas.setEnabled(true);
        this.MiVista.jButtonEliminar_Ligas.setEnabled(true);
        this.MiVista.jButtonModificar_Ligas.setEnabled(true);
    }
    public void disableControlPanel_Liga(){
       this.MiVista.jButtonInsertar_Ligas.setEnabled(false);
       this.MiVista.jButtonEliminar_Ligas.setEnabled(false);
       this. MiVista.jButtonModificar_Ligas.setEnabled(false);
    }
/*=========================================================================*/    
    public void enablecontrolTextView_Liga(){
        this.MiVista.jButtonAceptar_Ligas.setEnabled(true);
        this.MiVista.jButtonCancelar_Ligas.setEnabled(true);        
    }
    
    public void disablecontrolTextView_Liga(){
        this.MiVista.jButtonAceptar_Ligas.setEnabled(false);
        this.MiVista.jButtonCancelar_Ligas.setEnabled(false);        
    }   
    /*=========================================================================*/
    public void visibleControlTextView_Liga(boolean visible){
        if(visible == true){
            this.MiVista.jButtonAceptar_Ligas.setVisible(true);
            this.MiVista.jButtonCancelar_Ligas.setVisible(true);
        }else{
            this.MiVista.jButtonAceptar_Ligas.setVisible(false);
            this.MiVista.jButtonCancelar_Ligas.setVisible(false);
        }
    }
    /*=========================================================================*/   
        @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == this.MiVista.jButtonAceptar_Ligas){
            if(insertar == true){
                try {
                    insertarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            insertar = false;
            visibleControlTextView_Liga(false);
            try {
                EscribirFichero();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(evento.getSource() == this.MiVista.jButtonCancelar_Ligas){
            deleteTextView_Liga();
            visibleControlTextView_Liga(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonInsertar_Ligas){
//            mostrarEnTabla(leagueArrayList);
            insertar = true;
            visibleControlTextView_Liga(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonEliminar_Ligas){
            try {
                deleteData();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteTextView_Liga();
            visibleControlTextView_Liga(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Ligas){
            try {
                actualizarDatos();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
           visibleControlTextView_Liga(false);
           try {
                EscribirFichero();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         deleteTextView_Liga();
         mostrarEnTabla(leagueArrayList);
         actualizarComboBoxEquipos();
         
        try {
            EscribirFichero();
            
        } catch (IOException ex) {
            Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Antes de moostrar la tabla");
        mostrarEnTabla(leagueArrayList);
            System.out.println("Antes de actualizar el combobox");
        actualizarComboBoxEquipos();
            System.out.println("Despues de acturalizar combobox y antes del teleteTextView");
        deleteTextView_Liga();
            System.out.println("Despues del deletetexvier");
    }

    /*=========================================================================*/
    public void LoadDatabaseLeague() throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException{

        modeloLeague = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        
        this.MiVista.jTableLigas.setModel(modeloLeague);
        
        ArrayList<String> nombreColumnaLeague = new ArrayList<String>();
            nombreColumnaLeague.add("ID");
            nombreColumnaLeague.add("Nombre");
            nombreColumnaLeague.add("Nº Equipos");
            nombreColumnaLeague.add("Nº Ligas");
            nombreColumnaLeague.add("Federación");
        
        for(String columna: nombreColumnaLeague){
            modeloLeague.addColumn(columna);
        }
            System.out.println("test1");
            for(int i = 0 ; i < leagueArrayList.size();i++){
                System.out.println(leagueArrayList.get(i));
            }
            visibleControlTextView_Liga(false);
            cargarDataBaseOLeerFichero(false);       
            actualizarComboBoxEquipos();

            
    }
    
    public void cargarDataBaseOLeerFichero(boolean crear) throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException{
        
        if(crear == true){
            Liga ObtenerLigas = new Liga();
            leagueArrayList = ObtenerLigas.DataBaseLeague();          
            this.mostrarEnTabla(leagueArrayList);
            EscribirFichero();
        }else{
            this.mostrarEnTabla(leagueArrayList);
            actualizarComboBoxEquipos();
            LeerFichero();
         }
    }
    
    /*=========================================================================*/   
    public void EscribirFichero() throws FileNotFoundException, IOException {

    System.out.println("Escribiendo en el fichero Liga...");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Ligas", null);
        document.setXmlVersion("1.0"); 

        /********************   RECOREMOS FICHERO    **************************/     
            

        for(int i =0; i < leagueArrayList.size(); i++){
            Element raiz = document.createElement("Liga"); //nodo empleado
            document.getDocumentElement().appendChild(raiz); 
                //Añadir ID Liga                       
                CrearElemento("ID_Liga",leagueArrayList.get(i).getID_Liga(), raiz, document);
                //Añadir Nombre Liga
                CrearElemento("Nombre_Liga",leagueArrayList.get(i).getNombre_Liga(), raiz, document); 
                //Añadir Numero Equipos
                CrearElemento("Num_Equipos",leagueArrayList.get(i).getNum_Equipos(), raiz, document); 
                //Añadir NUmeros Ligas
                CrearElemento("Num_Ligas",leagueArrayList.get(i).getNum_Ligas(), raiz,document); 
                //Añadir Federación
                CrearElemento("Federacion",leagueArrayList.get(i).getFederacion(), raiz,document);
        }//fin del for que recorre el fichero

        /********************   CREAMOS DOM     **************************/
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Ligas.xml"));        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

       }catch(Exception e){ System.err.println("Error: "+e); }

    }
    
    public void LeerFichero() throws FileNotFoundException, IOException, ClassNotFoundException, SAXException, ParserConfigurationException {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader  procesadorXML = parser.getXMLReader();
        GestionarFichLigasXML gestor= new GestionarFichLigasXML();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("Ligas.xml"); 
        procesadorXML.parse(fileXML);
        
        mostrarEnTabla(leagueArrayList);
    }

    public void mostrarEnTabla(ArrayList <Liga> leagueArrayList){

        modeloLeague.setRowCount(0);
        Object[] vectorObject = new Object[5];

        for(int i = 0; i < leagueArrayList.size();i++){
            vectorObject[0] = leagueArrayList.get(i).getID_Liga();
            vectorObject[1] = leagueArrayList.get(i).getNombre_Liga();
            vectorObject[2] = leagueArrayList.get(i).getNum_Equipos();
            vectorObject[3] = leagueArrayList.get(i).getNum_Ligas();
            vectorObject[4] = leagueArrayList.get(i).getFederacion();

            modeloLeague.addRow(vectorObject);
        }
    }
        public void actualizarComboBoxEquipos(){
            
            this.MiVista.jComboBoxEquipos.removeAllItems();
                for(int i = 0; i < leagueArrayList.size();i++){
                    this.MiVista.jComboBoxEquipos.addItem(leagueArrayList.get(i).getID_Liga());

                }
               this.MiVista.txtLiga_Equipos.setEnabled(false);
        }
}
