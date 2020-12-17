/**
 * @author Fernández
 */

package Controlador;

import Connection.Connect;
import Modelo.Equipo;
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
         Connect con = new Connect();
        
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
            
            //Insert to BD
            con.insertDataTeam(eq1.getNum_ID(),this.MiVista.txtID_Equipos.getText(), this.MiVista.txtNombre_Equipos.getText(), this.MiVista.txtLiga_Equipos.getText(), this.MiVista.txtNumJugadores_Equipos.getText(), this.MiVista.txtPresupuesto_Equipos.getText());        
            mostrarEnTabla(teamArrayList);
        }
        
    }
    
    public void actualizarDatos() throws IOException{
        int fila = MiVista.jTableEquipos.getSelectedRow();
        Connect con = new Connect();
        
        Equipo eq1 = new Equipo();
        eq1.setIDequipo(this.MiVista.txtID_Equipos.getText());
        eq1.setNombre_eq(this.MiVista.txtNombre_Equipos.getText());
        eq1.setLiga(this.MiVista.txtLiga_Equipos.getText());
        eq1.setNumJugadores(this.MiVista.txtNumJugadores_Equipos.getText());
        eq1.setPresupuesto(this.MiVista.txtPresupuesto_Equipos.getText());
        teamArrayList.set(fila, eq1);
        
        String ID = this.MiVista.txtID_Equipos.getText();
        String Nombre = this.MiVista.txtNombre_Equipos.getText();
        String Liga_Equipos = this.MiVista.txtLiga_Equipos.getText();
        String NumJugadores = this.MiVista.txtNumJugadores_Equipos.getText();
        String Presupuesto = this.MiVista.txtPresupuesto_Equipos.getText();
        
        modeloTeam.setValueAt(ID, MiVista.jTableEquipos.getSelectedRow(), 0);
        modeloTeam.setValueAt(Nombre, MiVista.jTableEquipos.getSelectedRow(), 1);
        modeloTeam.setValueAt(Liga_Equipos, MiVista.jTableEquipos.getSelectedRow(), 2);
        modeloTeam.setValueAt(NumJugadores, MiVista.jTableEquipos.getSelectedRow(), 3);
        modeloTeam.setValueAt(Presupuesto, MiVista.jTableEquipos.getSelectedRow(), 4);
        
        con.updateDataTeam(ID, Nombre, Liga_Equipos, NumJugadores, Presupuesto);
        
        JOptionPane.showMessageDialog(MiVista, "Update Successfully...");
    }
    
    public void deleteData() throws IOException{
        int fila = MiVista.jTableEquipos.getSelectedRow();
         boolean encontrado = false;
        Connect con = new Connect();

        for(int i = 0; i < Jugador_Controlador.playerArrayList.size(); i++){
            if(this.teamArrayList.get(fila).getNombre_eq().equals(Jugador_Controlador.playerArrayList.get(i).getClub())){
                encontrado = true;
            }
        }
        if(encontrado == false){
            con.deleteRowDataBaseLeague(teamArrayList.get(fila).getNum_ID());//elimino de la base de datos.
            modeloTeam.removeRow(fila);//elimino de la tabla
            teamArrayList.remove(fila);//elimino del arraylist
            
            deleteTextView_Equipos();
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
                    Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
               deleteTextView_Equipos();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteTextView_Equipos();
            visibleControlTextView_Equipos(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Equipos){
            try {
                actualizarDatos();
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            visibleControlTextView_Equipos(true);
        }
            deleteTextView_Equipos();
            actualizarComboBoxJugador();
            
    }

    /*=========================================================================*/
    public void loadDatabaseTeam() throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException{
        
        modeloTeam = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        
        
        
        ArrayList<String> nombreColumnaTeam = new ArrayList<String>();
            nombreColumnaTeam.add("ID");
            nombreColumnaTeam.add("Nombre");
            nombreColumnaTeam.add("Liga");
            nombreColumnaTeam.add("Nº Jugadores");
            nombreColumnaTeam.add("Presupuesto");

        for(String columna: nombreColumnaTeam){
            modeloTeam.addColumn(columna);
        }
        
        this.MiVista.jTableEquipos.setModel(modeloTeam);
        
        visibleControlTextView_Equipos(false);
        cargarDataBaseOLeerFichero(true);
        actualizarComboBoxJugador();
       
    }
    
    public void cargarDataBaseOLeerFichero(boolean crear) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException{
        
        Connect con = new Connect();
        
        if(crear == true){
            con.createDataBaseTeam();
            con.DataBaseTeam();
            teamArrayList = con.mostrarTablaTeam(teamArrayList);
            this.mostrarEnTabla(teamArrayList);

        }else{
            teamArrayList = con.mostrarTablaTeam(teamArrayList);
            this.mostrarEnTabla(teamArrayList);
            actualizarComboBoxJugador();
         }
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