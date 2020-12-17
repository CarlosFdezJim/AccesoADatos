/**
 * @author Fernández
 */

package Controlador;

import Modelo.Equipo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class Equipos_Controlador implements ActionListener{
 
    Vista MiVista;
    DefaultTableModel modeloTeam;
    public static ArrayList<Equipo> teamArrayList = new ArrayList<Equipo>();
    boolean insertar = false;
    boolean modificar = false;
    boolean eliminar = false;

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
            //EscribirFichero();
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
        
        //EscribirFichero();
        
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
            if(insertar == true){
                try {
                    insertarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            insertar = false;
            visibleControlTextView_Equipos(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonCancelar_Equipos){
            deleteTextView_Equipos();
            visibleControlTextView_Equipos(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonInsertar_Equipos){
            insertar = true;
            visibleControlTextView_Equipos(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonEliminar_Equipos){
            try {
                deleteData();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteTextView_Equipos();
            visibleControlTextView_Equipos(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Equipos){
            try {
                actualizarDatos();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            visibleControlTextView_Equipos(false);
        }
        
            deleteTextView_Equipos();
            visibleControlTextView_Equipos(true);
            mostrarEnTabla(teamArrayList);
            actualizarComboBoxJugador();
            
            try {
            EscribirFichero();
            
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
        }else{
            mostrarEnTabla(teamArrayList);
            actualizarComboBoxJugador();
            LeerFichero();
            
         }
    }
 /*=========================================================================*/   
    public void EscribirFichero() throws FileNotFoundException, IOException {

          File fichero = new File("FichEquipos.dat");//declara el fichero
          FileOutputStream fileout = new FileOutputStream(fichero,false);  //crea el flujo de salida
           //conecta el flujo de bytes al flujo de datos
          ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  

            for(int i = 0; i < teamArrayList.size();i++){
                dataOS.writeObject(teamArrayList.get(i));
                System.out.println( i+1 + " EQUIPOS GRABADOS");
            }   
            dataOS.close();  //cerrar stream de salida    
    }
    
    public void LeerFichero() throws FileNotFoundException, IOException, ClassNotFoundException, SAXException, ParserConfigurationException {
       
            
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(new File("FichEquipos.dat")));

        int i = 1;
        try {
                while (true) { // lectura del fichero
                        
                        Equipo equipo = (Equipo) dataIS.readObject(); // leer un Equipo
                        System.out.print(i + "=>");
                        i++;
                        System.out.printf("ID: %s, Nombre: %s %n",equipo.getIDequipo(),equipo.getNombre_eq());
                        
                        this.teamArrayList.add(equipo);
                }
        } catch (EOFException eo) {
                System.out.println("FIN DE LECTURA.");
        } catch (StreamCorruptedException x) {
        }
        System.out.println("***********************");  
        dataIS.close(); // cerrar stream de entrada
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