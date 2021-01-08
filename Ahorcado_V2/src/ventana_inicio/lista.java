//González Vera Bruno 3IV8
//Repositorio de GitHub:
//https://github.com/ElBruno2442/3IV8_Gonzalez_Vera_Bruno

package ventana_inicio;

//Se importan las librerias correspondientes
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BRUNO
 */

/*
En esta clase se crea el ArrayList, ademas de que se
  crea el JTable que contendra al ArrayList 
*/
public class lista extends javax.swing.JFrame {
    
    //Creacion de el ArrayList
     ArrayList<Datos>datos = new ArrayList<Datos>();
     
    public lista() {
        initComponents();
        setSize(385,230);//Cambiar tamaño de la ventana
        this.setLocationRelativeTo(null);//Posiciona la ventana al centro 
        
        Image icon=new ImageIcon(getClass().getResource("/imagenes/hol.png")).getImage();
        setIconImage(icon);//Se cambia el icono de la ventana
        
        CargaAutomatica();       
    }
    
    
    //Metodo que agrega datos al ArrayList
    public void CargaAutomatica(){
        
        juego_normal jn = new juego_normal();
        Datos dt = new Datos(jn.getNombre(), jn.getEdad(), jn.getPuntaje());
        
        
        datos.add(dt);
        mostrar();
    }
    
    //Metodo que los muestra
    public void mostrar(){
        String matriz[][] = new String[datos.size()][3];
        
        for(int i = 0; i<datos.size(); i++){
            
            matriz[i][0] = datos.get(i).getNombre();
            matriz[i][1] = datos.get(i).getEdad();
            matriz[i][2] = datos.get(i).getScore();   
        }
        
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
 
            new String [] {
                "Nombre", "Edad", "Score" 
            }
        ));
        
    }
        
        

    //inicializacion de los demas componentes(Boton de salir)                      
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Dialog", 1, 12)); 
        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                salirActionPerformed(evt);
                }
        });
        getContentPane().add(salir);
        salir.setBounds(280, 200, 70, 25);

        pack();
    }  
    
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {                                      

        this.setVisible(false);
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lista().setVisible(true);
            }
        });
    }

                  
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton salir;
                  
}
