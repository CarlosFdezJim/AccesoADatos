/**
 * @author Fernández
 */

package Controlador;

import Modelo.Liga;
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
        }
        
        if(evento.getSource() == this.MiVista.jButtonCancelar_Ligas){
            deleteTextView_Liga();
            visibleControlTextView_Liga(false);
        }
        
        if(evento.getSource() == this.MiVista.jButtonInsertar_Ligas){
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
            visibleControlTextView_Liga(true);
        }
        
        if(evento.getSource() == this.MiVista.jButtonModificar_Ligas){
            try {
                actualizarDatos();
            } catch (IOException ex) {
                Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            visibleControlTextView_Liga(true);
        }
        
         deleteTextView_Liga();
         visibleControlTextView_Liga(true);
         mostrarEnTabla(leagueArrayList);
         actualizarComboBoxEquipos();
         
        try {
            EscribirFichero();
            
        } catch (IOException ex) {
            Logger.getLogger(Liga_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /*=========================================================================*/
    public void LoadDatabaseLeague() throws IOException, FileNotFoundException, ClassNotFoundException{

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
            
            visibleControlTextView_Liga(false);
            cargarDataBaseOLeerFichero(true);
            actualizarComboBoxEquipos();
            
    }
    
    public void cargarDataBaseOLeerFichero(boolean crear) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        if(crear == true){
            Liga ObtenerLigas = new Liga();
            leagueArrayList = ObtenerLigas.DataBaseLeague();
           
            this.mostrarEnTabla(leagueArrayList);
            EscribirFichero();
            actualizarComboBoxEquipos();
        }else{
            this.mostrarEnTabla(leagueArrayList);
            actualizarComboBoxEquipos();
            LeerFichero();
         }
    }
    
    /*=========================================================================*/   
    public void EscribirFichero() throws FileNotFoundException, IOException {

          File fichero = new File("FichLigas.dat");//declara el fichero
          FileOutputStream fileout = new FileOutputStream(fichero,false);  //crea el flujo de salida
           //conecta el flujo de bytes al flujo de datos
          ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  

            for(int i = 0; i < leagueArrayList.size();i++){
                dataOS.writeObject(leagueArrayList.get(i));
                System.out.println( i+1 + " LIGAS GRABADAS");
            }   
            dataOS.close();  //cerrar stream de salida    
    }
    
        public void LeerFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
    	
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(new File("FichLigas.dat")));

        int i = 1;
        try {
                while (true) { // lectura del fichero
                        
                        Liga liguilla =  (Liga) dataIS.readObject(); // leer una Liga
                        System.out.print(i + "=>");
                        i++;
                        System.out.printf("ID: %s, Nombre: %s %n",
                                        liguilla.getID_Liga(),liguilla.getNombre_Liga());
                        
                        this.leagueArrayList.add(liguilla);
                }
        } catch (EOFException eo) {
                System.out.println("FIN DE LECTURA.");
        } catch (StreamCorruptedException x) {
        }
        System.out.println("***********************");  
        dataIS.close(); // cerrar stream de entrada
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
