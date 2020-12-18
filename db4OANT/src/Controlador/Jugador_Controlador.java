/**
 * @author Fernández
 */

package Controlador;

import Modelo.Jugador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.Vista;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class Jugador_Controlador implements ActionListener {
    
    Vista MiVista;
    DefaultTableModel modeloPlayers;
    public static ArrayList<Jugador> playerArrayList = new ArrayList<Jugador>();
    boolean insertar = false;
    boolean modificar = false;
    boolean eliminar = false;
    static String DataBase = "DataBase.yap";
 
    public Jugador_Controlador(Vista MiVista) {
        this.MiVista = MiVista;
        this.MiVista.jButtonInsertar_Jugador.addActionListener(this);
        this.MiVista.jButtonEliminar_Jugador.addActionListener(this);
        this.MiVista.jButtonModificar_Jugador.addActionListener(this);
        
        this.MiVista.txtDNI_Jugadores.addActionListener(this);
        this.MiVista.txtNombre_Jugadores.addActionListener(this);
        this.MiVista.txtClub_Jugadores.addActionListener(this);
        this.MiVista.txtPosicion_Jugadores.addActionListener(this);
        this.MiVista.txtDorsal_Jugadores.addActionListener(this);
        
        this.MiVista.jButtonAceptar_Jugador.addActionListener(this);
        this.MiVista.jButtonCancelar_Jugador.addActionListener(this);
    }

    public void insertarDatos() throws IOException{
        int fila = 0;
	ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DataBase);
        
        for(int i = 0; i< playerArrayList.size();i++){
            if(this.MiVista.txtDNI_Jugadores.getText().equals(this.playerArrayList.get(i).getDNI())){
                fila = i;
            }
        }
        
        if(this.MiVista.txtDNI_Jugadores.getText().equals(this.playerArrayList.get(fila).getDNI())){ 
            JOptionPane.showMessageDialog(MiVista, "El DNI ya está en uso \nNo se puede insertar ese jugador");
        }else{
            Jugador jg1 = new Jugador(this.MiVista.txtDNI_Jugadores.getText(),this.MiVista.txtNombre_Jugadores.getText(), this.MiVista.txtClub_Jugadores.getText(),this.MiVista.txtPosicion_Jugadores.getText(), this.MiVista.txtDorsal_Jugadores.getText());
            playerArrayList.add(jg1);

            String[] datos = new String[5];
            datos[0] = this.MiVista.txtDNI_Jugadores.getText();
            datos[1] = this.MiVista.txtNombre_Jugadores.getText();
            datos[2] = this.MiVista.txtClub_Jugadores.getText();
            datos[3] = this.MiVista.txtPosicion_Jugadores.getText();
            datos[4] = this.MiVista.txtDorsal_Jugadores.getText();

            modeloPlayers.addRow(datos);
            
        //Insert to DB
        db.store(jg1);
        mostrarEnTabla(playerArrayList);
        db.close(); // cerrar base de datos
        }
    }
    
    public void actualizarDatos() throws IOException{
        int fila = MiVista.jTableJugadores.getSelectedRow();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DataBase);
        
        ObjectSet<Jugador> result = db.queryByExample(new Jugador(playerArrayList.get(fila).getDNI(), null,null,null,null));
	
        Jugador existe = (Jugador) result.next();     
        //modificar los datos
        existe.setDNI(this.MiVista.txtDNI_Jugadores.getText());
        existe.setNombre_Jugador(this.MiVista.txtNombre_Jugadores.getText());
        existe.setClub(this.MiVista.txtClub_Jugadores.getText());
        existe.setPosicion(this.MiVista.txtPosicion_Jugadores.getText());
        existe.setDorsal(this.MiVista.txtDorsal_Jugadores.getText());
        db.store(existe);
        
        Jugador jg1 = new Jugador();
        jg1.setDNI(this.MiVista.txtDNI_Jugadores.getText());
        jg1.setNombre_Jugador(this.MiVista.txtNombre_Jugadores.getText());
        jg1.setClub(this.MiVista.txtClub_Jugadores.getText());
        jg1.setPosicion(this.MiVista.txtPosicion_Jugadores.getText());
        jg1.setDorsal(this.MiVista.txtDorsal_Jugadores.getText());
        playerArrayList.set(fila, jg1);
        
        String DNI = this.MiVista.txtDNI_Jugadores.getText();
        String Nombre_Jugadores = this.MiVista.txtNombre_Jugadores.getText();
        String Club = this.MiVista.txtClub_Jugadores.getText();
        String Posicion = this.MiVista.txtPosicion_Jugadores.getText();
        String Dorsal = this.MiVista.txtDorsal_Jugadores.getText();
        
        modeloPlayers.setValueAt(DNI, MiVista.jTableJugadores.getSelectedRow(), 0);
        modeloPlayers.setValueAt(Nombre_Jugadores, MiVista.jTableJugadores.getSelectedRow(), 1);
        modeloPlayers.setValueAt(Club, MiVista.jTableJugadores.getSelectedRow(), 2);
        modeloPlayers.setValueAt(Posicion, MiVista.jTableJugadores.getSelectedRow(), 3);
        modeloPlayers.setValueAt(Dorsal, MiVista.jTableJugadores.getSelectedRow(), 4);
        
        //con.updateDataPlayer(DNI, Nombre_Jugadores, Club, Posicion, Dorsal);
        db.close();
        JOptionPane.showMessageDialog(MiVista, "Update Successfully...");
    }
    
    public void deleteData() throws IOException{
        int fila = MiVista.jTableJugadores.getSelectedRow();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DataBase);        
        ObjectSet<Jugador> result = db.queryByExample(new Jugador(this.playerArrayList.get(fila).getDNI(), null, null, null, null));
        while (result.hasNext()) {
            Jugador j = result.next();
            db.delete(j);
            System.out.println("Borrado....");
        }
        db.close(); // cerrar base de datos
        modeloPlayers.removeRow(fila);
        playerArrayList.remove(fila);//elimino del arraylist
        deleteTextView_Jugador();
    }
    /*=========================================================================*/
    public void deleteTextView_Jugador(){
        this.MiVista.txtDNI_Jugadores.setText("");
        this.MiVista.txtNombre_Jugadores.setText("");
        this.MiVista.txtClub_Jugadores.setText("");
        this.MiVista.txtPosicion_Jugadores.setText("");
        this.MiVista.txtDorsal_Jugadores.setText("");
        
    }
    /*=========================================================================*/
    public void enableTextView_Jugador(){
        this.MiVista.txtDNI_Jugadores.setEnabled(true);
        this.MiVista.txtNombre_Jugadores.setEnabled(true);
        this.MiVista.txtClub_Jugadores.setEnabled(true);
        this.MiVista.txtPosicion_Jugadores.setEnabled(true);
        this.MiVista.txtDorsal_Jugadores.setEnabled(true);
    }
    
    public void disableTextView_Jugador(){
        this.MiVista.txtDNI_Jugadores.setEnabled(false);
        this.MiVista.txtNombre_Jugadores.setEnabled(false);
        this.MiVista.txtClub_Jugadores.setEnabled(false);
        this.MiVista.txtPosicion_Jugadores.setEnabled(false);
        this.MiVista.txtDorsal_Jugadores.setEnabled(false);
    }
    /*=========================================================================*/ 
    public void enableControlPanel_Jugador(){
        this.MiVista.jButtonInsertar_Jugador.setEnabled(true);
        this.MiVista.jButtonEliminar_Jugador.setEnabled(true);
        this.MiVista.jButtonModificar_Jugador.setEnabled(true);
    }
    public void disableControlPanel_Jugador(){
       this.MiVista.jButtonInsertar_Jugador.setEnabled(false);
       this.MiVista.jButtonEliminar_Jugador.setEnabled(false);
       this. MiVista.jButtonModificar_Jugador.setEnabled(false);
    }
    /*=========================================================================*/
    public void enablecontrolTextView_Jugador(){
        this.MiVista.jButtonAceptar_Jugador.setEnabled(true);
        this.MiVista.jButtonCancelar_Jugador.setEnabled(true);        
    }
    
    public void disablecontrolTextView_Jugador(){
        this.MiVista.jButtonAceptar_Jugador.setEnabled(false);
        this.MiVista.jButtonCancelar_Jugador.setEnabled(false);        
    }   
    /*=========================================================================*/
    public void visibleControlTextView_Jugador(boolean visible){
        if(visible == true){
            this.MiVista.jButtonAceptar_Jugador.setVisible(true);
            this.MiVista.jButtonCancelar_Jugador.setVisible(true);
        }else{
            this.MiVista.jButtonAceptar_Jugador.setVisible(false);
            this.MiVista.jButtonCancelar_Jugador.setVisible(false);
        }
    }
    /*=========================================================================*/
        @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == this.MiVista.jButtonAceptar_Jugador){
            if(insertar == true){
                try {
                    insertarDatos();
                } catch (IOException ex) {
                    Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            insertar = false;
            visibleControlTextView_Jugador(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonCancelar_Jugador){
            deleteTextView_Jugador();
            visibleControlTextView_Jugador(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonInsertar_Jugador){
            insertar = true;
            visibleControlTextView_Jugador(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonEliminar_Jugador){
            try {
                deleteData();
                deleteTextView_Jugador();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            deleteTextView_Jugador();
            visibleControlTextView_Jugador(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Jugador){
            try {
                actualizarDatos();
                System.out.println("llega2");
            } catch (IOException ex) {
                Logger.getLogger(Equipos_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            visibleControlTextView_Jugador(true);
        }
        deleteTextView_Jugador();
    }

    /*=========================================================================*/
    
    public void LoadDatabasePlayers() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException{

        modeloPlayers = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        
        this.MiVista.jTableJugadores.setModel(modeloPlayers);

        ArrayList<String> nombreColumnaPlayers = new ArrayList<String>();
            nombreColumnaPlayers.add("DNI");
            nombreColumnaPlayers.add("Nombre");
            nombreColumnaPlayers.add("Club");
            nombreColumnaPlayers.add("Posición");
            nombreColumnaPlayers.add("Dorsal");

        for(String columna: nombreColumnaPlayers){
            modeloPlayers.addColumn(columna);
        }
        visibleControlTextView_Jugador(false);
        cargarDataBaseOLeerFichero(true);

    }
    
    public void cargarDataBaseOLeerFichero(boolean crear) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException{
        
        Jugador j = new Jugador();
        
        if(crear == true){
            //playerArrayList = j.DataBasePlayer();
            insertarDatosEnBD();
            Consulta();
            this.mostrarEnTabla(playerArrayList);
        }
    }
    public void insertarDatosEnBD(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DataBase);

        for(int i = 0; i < playerArrayList.size();i++){
            db.store(this.playerArrayList.get(i));
        }
        
        db.close();
    }
    public void Consulta(){
         ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DataBase);

        Jugador jug = new Jugador(null,null,null,null,null);
        ObjectSet<Jugador> result = db.queryByExample(jug);
        
        if (result.size() == 0)
                System.out.println("No existen Jugadores..");
        else {
                System.out.printf("Número de Jugadores: %d %n", result.size());

                while (result.hasNext()) {
                        Jugador j = result.next();
                        playerArrayList.add(j);
                }
        }
        
        db.close(); // cerrar base de dato
        
    }
    /*=========================================================================*/
    public void mostrarEnTabla(ArrayList<Jugador> teamArrayList){
            
        modeloPlayers.setRowCount(0);
        Object[] vectorObject = new Object[5];

        for(int i = 0; i < playerArrayList.size();i++){
            vectorObject[0] = playerArrayList.get(i).getDNI();
            vectorObject[1] = playerArrayList.get(i).getNombre_Jugador();
            vectorObject[2] = playerArrayList.get(i).getClub();
            vectorObject[3] = playerArrayList.get(i).getPosicion();
            vectorObject[4] = playerArrayList.get(i).getDorsal();

            modeloPlayers.addRow(vectorObject);
        }
    }

}
