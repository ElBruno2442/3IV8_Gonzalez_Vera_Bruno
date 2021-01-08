//González Vera Bruno 3IV8
//Repositorio de GitHub:
//https://github.com/ElBruno2442/3IV8_Gonzalez_Vera_Bruno

package ventana_inicio;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Bruno
 */

//En esta clase se encuentra el menu principal 
public class ini extends javax.swing.JFrame {


    public ini() {
        initComponents();
        setSize(600,500);
        this.setLocationRelativeTo(null);
        Image icon=new ImageIcon(getClass().getResource("/imagenes/hol.png")).getImage();
        setIconImage(icon);
    }
                        
    private void initComponents() {

        cre = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        puntuacion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        //Boton informativo 
        cre.setBackground(new java.awt.Color(255, 255, 255));
        cre.setFont(new java.awt.Font("Dialog", 1, 24)); 
        cre.setText("ACERCA DE");
        cre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creActionPerformed(evt);
            }
        });
        getContentPane().add(cre);
        cre.setBounds(55, 220, 200, 70);

        //Boton para jugar 
        jugar.setBackground(new java.awt.Color(255, 255, 255));
        jugar.setFont(new java.awt.Font("Dialog", 1, 24)); 
        jugar.setText("JUGAR");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        getContentPane().add(jugar);
        jugar.setBounds(55, 140, 200, 70);

        //Boton para salir 
        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 24));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });       
        getContentPane().add(jButton2);
        jButton2.setBounds(55, 380, 200, 70);

        //Bototn para ver la puntuacion
        puntuacion.setBackground(new java.awt.Color(255, 255, 255));
        puntuacion.setFont(new java.awt.Font("Dialog", 1, 24)); 
        puntuacion.setText("PUNTUACIÓN");
        puntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntuacionActionPerformed(evt);
            }
        }); 
        getContentPane().add(puntuacion);
        puntuacion.setBounds(55, 300, 200, 70);
        
        //Etiquetas de texto
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); 
        jLabel2.setText("AHORCADO...");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 30, 260, 47);
        
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); 
        jLabel3.setText("EL JUEGO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(93, 65, 260, 47);     

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventana_inicio/ahorcado.jpg"))); // NOI18N
        jLabel1.setText("AHORCADO");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 500);

        pack();
    }                        

    //Creditos
    private void creActionPerformed(java.awt.event.ActionEvent evt) {                                    
        JOptionPane.showMessageDialog(null,"Juego diseñado por:\n\n González Vera Bruno. "
                + "\n\n" + " CECyT 9 Juan De Dios Batiz"
                + "\n Tercer semestre 3IV8"
                + "\n El sistema de puntos lo pense inspirandome en los juegos que vienen por defecto"
                + "\n en algunas computadoras(Pin Ball), los puntos se suman por cada palabra acertada"
                + "\n y la tabla de puntuaciones muestra las partidas jugadas recientemente"
                + "\n\n\n      Ahorcado V 2"
                , "Ahorcado",JOptionPane.INFORMATION_MESSAGE );
    }                                   

    //Salir
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     if (JOptionPane.showConfirmDialog(rootPane, "¿Salir de la aplicación?",
                "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
        {System.exit(0);
        }
        else{
                setDefaultCloseOperation(0);
        }
            
    }                                        

    //Jugar
    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {                                      
        juego_normal jn=new juego_normal();
        jn.setVisible(true);
        this.setVisible(false);
        
    }
    
    //Tabla de puntuacion
    private void puntuacionActionPerformed(java.awt.event.ActionEvent evt) {                                      
        lista lt=new lista();
        lt.setVisible(true);
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
            java.util.logging.Logger.getLogger(ini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ini().setVisible(true);
            }
        });
    }

                      
    private javax.swing.JButton cre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton puntuacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jugar;
                    
}

