//González Vera Bruno 3IV8
//Repositorio de GitHub:
//https://github.com/ElBruno2442/3IV8_Gonzalez_Vera_Bruno
package ventana_inicio;

/**
 *
 * @author BRUNO
 */

//Se importan las librerias correspondientes 
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/*
En esta clase ocurre absolutamnte todo el juego 
*/
public class juego_normal extends javax.swing.JFrame{
    
    //Las variables que se utilizan 
    private ImageIcon imgs[];
    private JButton btns[];
    private String msgs[];
    private String msg;
    private int ran;
    private int err;
    private int err2;     
    private String res[];
    private String nombre;
    private String edad; 
    private String puntaje; 
    private int score =0;
    
    //Dentro de este metodo ocurre el juego
    public juego_normal(){
        initComponents();
        setSize(650,707);//Cambiar tamaño de la ventana
        this.setLocationRelativeTo(null);//Posiciona la ventana en el centro 
        
        Image icon=new ImageIcon(getClass().getResource("/imagenes/hol.png")).getImage();
        setIconImage(icon);//Cambia el icono de la ventana
        
        //Se inicializan los arreglos para las imagenes de errores y los botones 
        imgs = new ImageIcon[12];
        btns = new JButton[28];
              
        //Imagen del señor que se esta matando 
        imgs[0] = new ImageIcon(getClass().getResource("/imagenes/im1.jpg"));
        imgs[1] = new ImageIcon(getClass().getResource("/imagenes/im2.jpg"));
        imgs[2] = new ImageIcon(getClass().getResource("/imagenes/im3.jpg"));
        imgs[3] = new ImageIcon(getClass().getResource("/imagenes/im4.jpg"));
        imgs[4] = new ImageIcon(getClass().getResource("/imagenes/im5.jpg"));
        imgs[5] = new ImageIcon(getClass().getResource("/imagenes/im6.jpg"));

        //Imagen gradual de errores 
        imgs[6] = new ImageIcon(getClass().getResource("/imagenes/fallo0.png"));
        imgs[7] = new ImageIcon(getClass().getResource("/imagenes/fallo1.png"));
        imgs[8] = new ImageIcon(getClass().getResource("/imagenes/fallo2.png"));
        imgs[9] = new ImageIcon(getClass().getResource("/imagenes/fallo3.png"));
        imgs[10] = new ImageIcon(getClass().getResource("/imagenes/fallo4.png"));
        imgs[11] = new ImageIcon(getClass().getResource("/imagenes/fallo5.png"));
        
        //Botones para las letras
        btns[1]=button_1;
        btns[2]=button_2;
        btns[3]=button_3;
        btns[4]=button_4;
        btns[5]=button_5;
        btns[6]=button_6;
        btns[7]=button_7;
        btns[8]=button_8;
        btns[9]=button_9;
        btns[10]=button_10;
        btns[11]=button_11;
        btns[12]=button_12;
        btns[13]=button_13;
        btns[14]=button_14;
        btns[15]=button_16;
        btns[16]=button_17;
        btns[17]=button_18;
        btns[18]=button_19;
        btns[19]=button_20;
        btns[20]=button_21;
        btns[21]=button_22;
        btns[22]=button_23;
        btns[23]=button_24;
        btns[24]=button_25;
        btns[25]=button_26;
        btns[26]=button_27;
        btns[27]=button_15;
                
        //Se asigna un evento a cada letra para comprobar que exista en la palabra oculta
        for (int i = 1; i < 28; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }
        
        iniciar();
    }

    //;etodo para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        
        //Se selecciona la palbara oculta
        msg = JOptionPane.showInputDialog("Ingresa la palabra a adivinar:\n"
                                          +"No puede verla el jugador").toUpperCase();
        msgs = new String[1];
        msgs[0] = msg;
        

        //El dibujo comienza en la posicion 0 de imgs
        err = 0;
        
        //Los errores comienzan desde la posicion 6 de imgs
        err2=6;
        
        Dibujo.setIcon(imgs[0]);
        txtPalabra.setText("");
        errores.setIcon(imgs[6]);
                      
        //Para activar las letras del tablero
        for (int i = 1; i < 28; i++) {
            btns[i].setEnabled(true);
        }
        
        
        //Separa el mensaje por palaras en caso de haber mas de una
        String pal[] = msgs[0].split(" ");
        res = new String[msgs[0].length() + 1];
        int j = 0;
        
        //Seran los guiones que van debajo de las letras como una separacion
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                txtPalabra.setText(txtPalabra.getText() + "_ ");
                res[j++] = "_";
            }
            txtPalabra.setText(txtPalabra.getText() + "\n");
            res[j++] = " ";
        }
    }
    
    //Al presionar una letra, se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        Icon cp=new ImageIcon(getClass().getResource("/imagenes/copa.png"));//Icono de la copa del ganador 
        Icon cara=new ImageIcon(getClass().getResource("/imagenes/cara.png"));//Icono de la cara triste de perdedor
        JButton bt = (JButton) e.getSource();
        char c[];
        
        //Busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 28; i++) {
            if (bt == btns[i]) {
                
                //La tecla es inicializada
                c = Character.toChars(64 + i);
                
                //Busca si la letra esta en la palabra
                boolean existe = false;
                for (int j = 0; j < msgs[0].length(); j++) {
                    if (c[0] == msgs[0].charAt(j)) {
                        res[j] = c[0] + "";
                        existe = true;
                    }
                }
                
                //Si la letra esta en la palabra, se mostrara en el TextPanel
                //En caso de existir, se sumaran 2 puntos
                if (existe) {
                    score = score+2;
                    txtPalabra.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            txtPalabra.setText(txtPalabra.getText() + "\n");
                        } else {
                            txtPalabra.setText(txtPalabra.getText() + re + " ");
                        }
                    }
                    
                    //Hace una comprobacion de las letras restantes y faltantes
                    //En caso de que ya no haya letras sera ganador
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    
                    //Al haber ganado se reinica el juego y la puntuacion se suma                    
                    if (gano) { 
                        JOptionPane.showMessageDialog(this, "FELICITACIONES GANASTE!!\n YA PUEDES RECLAMAR TU PREMIO", "Ahorcado",JOptionPane.INFORMATION_MESSAGE, cp);
                        ptos.setText(Integer.toString(score));
                        iniciar();
                        return;
                    }
                    
                    //Si la letra no estaba, se incrementa el error y cambian las imagenes
                } 
                else {
                    Dibujo.setIcon(imgs[++err]);
                    errores.setIcon(imgs[++err2]);
                    
                    //Si se llega a todos los errore se pierde 
                    if (err == 5) {
                        JOptionPane.showMessageDialog(this, "HAS PERDIDO\n Intenta con otra palabra la respuesta es: \n" + msgs[0], "Ahorcado",JOptionPane.INFORMATION_MESSAGE, cara);
                        iniciar();
                        return;
                    }
                }
                
                //Se desactivan las lineas despues de ser usadas 
                bt.setEnabled(false);
                break;
            }
        }

    }
                            
    //Aqui es donde se crea la interfaz grafica 
    private void initComponents() {

        //Se crean todos los componentes y se cambian sus caracteristicas
    
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Iniciar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        help = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtPalabra = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        errores = new javax.swing.JLabel();
        puntos = new javax.swing.JLabel();
        ptos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Dibujo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        button_2 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_10 = new javax.swing.JButton();
        button_11 = new javax.swing.JButton();
        button_12 = new javax.swing.JButton();
        button_13 = new javax.swing.JButton();
        button_14 = new javax.swing.JButton();
        button_16 = new javax.swing.JButton();
        button_17 = new javax.swing.JButton();
        button_18 = new javax.swing.JButton();
        button_19 = new javax.swing.JButton();
        button_20 = new javax.swing.JButton();
        button_21 = new javax.swing.JButton();
        button_22 = new javax.swing.JButton();
        button_23 = new javax.swing.JButton();
        button_24 = new javax.swing.JButton();
        button_25 = new javax.swing.JButton();
        button_26 = new javax.swing.JButton();
        button_27 = new javax.swing.JButton();
        button_15 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "MENÚ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), 
                new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        Iniciar.setBackground(new java.awt.Color(255, 255, 255));
        Iniciar.setFont(new java.awt.Font("Dialog", 1, 18)); 
        Iniciar.setForeground(new java.awt.Color(0, 0, 0));
        Iniciar.setText("GENERAR PALABRA NUEVA");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        btnResolver.setBackground(new java.awt.Color(255, 255, 255));
        btnResolver.setFont(new java.awt.Font("Dialog", 1, 18)); 
        btnResolver.setForeground(new java.awt.Color(0, 0, 0));
        btnResolver.setText("RESOLVER");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 18)); 
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        help.setBackground(new java.awt.Color(255, 255, 255));
        help.setFont(new java.awt.Font("Dialog", 1, 18)); 
        help.setForeground(new java.awt.Color(0, 0, 0));
        help.setText("INSTRUCCIONES DEL JUEGO");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        
        puntos.setBackground(new java.awt.Color(255, 255, 255));
        puntos.setFont(new java.awt.Font("Dialog", 1, 18));
        puntos.setForeground(new java.awt.Color(0, 0, 0));
        puntos.setText("Score:");
        puntos.setBounds(400, 610, 120, 50);
        getContentPane().add(puntos);
        
        ptos.setBackground(new java.awt.Color(255, 255, 255));
        ptos.setFont(new java.awt.Font("Dialog", 1, 18));
        ptos.setForeground(new java.awt.Color(0, 0, 0));
        ptos.setBounds(475, 610, 50, 50);
        getContentPane().add(ptos);
               
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Iniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolver)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "PALABRA OCULTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), 
                new java.awt.Color(0, 0, 0)));

        txtPalabra.setEditable(false);
        txtPalabra.setBackground(new java.awt.Color(255, 255, 255));
        txtPalabra.setFont(new java.awt.Font("Dialog", 0, 24));
        txtPalabra.setForeground(new java.awt.Color(0, 0, 0));
        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPalabraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPalabra)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "ERRORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), 
                new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(errores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(errores, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "AHORCADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), 
                new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Dibujo, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(Dibujo, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "TECLADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), 
                new java.awt.Color(0, 0, 0)));

        button_2.setBackground(new java.awt.Color(255, 255, 255));
        button_2.setFont(new java.awt.Font("Dialog", 1, 18));
        button_2.setForeground(new java.awt.Color(0, 0, 0));
        button_2.setText("B");
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });

        button_1.setBackground(new java.awt.Color(255, 255, 255));
        button_1.setFont(new java.awt.Font("Dialog", 1, 18));
        button_1.setForeground(new java.awt.Color(0, 0, 0));
        button_1.setText("A");
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });

        button_3.setBackground(new java.awt.Color(255, 255, 255));
        button_3.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_3.setForeground(new java.awt.Color(0, 0, 0));
        button_3.setText("C");
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });

        button_4.setBackground(new java.awt.Color(255, 255, 255));
        button_4.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_4.setForeground(new java.awt.Color(0, 0, 0));
        button_4.setText("D");
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });

        button_5.setBackground(new java.awt.Color(255, 255, 255));
        button_5.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_5.setForeground(new java.awt.Color(0, 0, 0));
        button_5.setText("E");
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });

        button_6.setBackground(new java.awt.Color(255, 255, 255));
        button_6.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_6.setForeground(new java.awt.Color(0, 0, 0));
        button_6.setText("F");
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });

        button_7.setBackground(new java.awt.Color(255, 255, 255));
        button_7.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_7.setForeground(new java.awt.Color(0, 0, 0));
        button_7.setText("G");
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });

        button_8.setBackground(new java.awt.Color(255, 255, 255));
        button_8.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_8.setForeground(new java.awt.Color(0, 0, 0));
        button_8.setText("H");
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });

        button_9.setBackground(new java.awt.Color(255, 255, 255));
        button_9.setFont(new java.awt.Font("Dialog", 1, 18));
        button_9.setForeground(new java.awt.Color(0, 0, 0));
        button_9.setText("I");
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });

        button_10.setBackground(new java.awt.Color(255, 255, 255));
        button_10.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_10.setForeground(new java.awt.Color(0, 0, 0));
        button_10.setText("J");
        button_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_10ActionPerformed(evt);
            }
        });

        button_11.setBackground(new java.awt.Color(255, 255, 255));
        button_11.setFont(new java.awt.Font("Dialog", 1, 18));
        button_11.setForeground(new java.awt.Color(0, 0, 0));
        button_11.setText("K");
        button_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_11ActionPerformed(evt);
            }
        });

        button_12.setBackground(new java.awt.Color(255, 255, 255));
        button_12.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_12.setForeground(new java.awt.Color(0, 0, 0));
        button_12.setText("L");
        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });

        button_13.setBackground(new java.awt.Color(255, 255, 255));
        button_13.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_13.setForeground(new java.awt.Color(0, 0, 0));
        button_13.setText("M");
        button_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_13ActionPerformed(evt);
            }
        });

        button_14.setBackground(new java.awt.Color(255, 255, 255));
        button_14.setFont(new java.awt.Font("Dialog", 1, 18));
        button_14.setForeground(new java.awt.Color(0, 0, 0));
        button_14.setText("N");
        button_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_14ActionPerformed(evt);
            }
        });

        button_16.setBackground(new java.awt.Color(255, 255, 255));
        button_16.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_16.setForeground(new java.awt.Color(0, 0, 0));
        button_16.setText("O");

        button_17.setBackground(new java.awt.Color(255, 255, 255));
        button_17.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_17.setForeground(new java.awt.Color(0, 0, 0));
        button_17.setText("P");
        button_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_17ActionPerformed(evt);
            }
        });

        button_18.setBackground(new java.awt.Color(255, 255, 255));
        button_18.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_18.setForeground(new java.awt.Color(0, 0, 0));
        button_18.setText("Q");
        button_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_18ActionPerformed(evt);
            }
        });

        button_19.setBackground(new java.awt.Color(255, 255, 255));
        button_19.setFont(new java.awt.Font("Dialog", 1, 18));
        button_19.setForeground(new java.awt.Color(0, 0, 0));
        button_19.setText("R");
        button_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_19ActionPerformed(evt);
            }
        });

        button_20.setBackground(new java.awt.Color(255, 255, 255));
        button_20.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_20.setForeground(new java.awt.Color(0, 0, 0));
        button_20.setText("S");
        button_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_20ActionPerformed(evt);
            }
        });

        button_21.setBackground(new java.awt.Color(255, 255, 255));
        button_21.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_21.setForeground(new java.awt.Color(0, 0, 0));
        button_21.setText("T");
        button_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_21ActionPerformed(evt);
            }
        });

        button_22.setBackground(new java.awt.Color(255, 255, 255));
        button_22.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_22.setForeground(new java.awt.Color(0, 0, 0));
        button_22.setText("U");
        button_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_22ActionPerformed(evt);
            }
        });

        button_23.setBackground(new java.awt.Color(255, 255, 255));
        button_23.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_23.setForeground(new java.awt.Color(0, 0, 0));
        button_23.setText("V");
        button_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_23ActionPerformed(evt);
            }
        });

        button_24.setBackground(new java.awt.Color(255, 255, 255));
        button_24.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_24.setForeground(new java.awt.Color(0, 0, 0));
        button_24.setText("W");
        button_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_24ActionPerformed(evt);
            }
        });

        button_25.setBackground(new java.awt.Color(255, 255, 255));
        button_25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_25.setForeground(new java.awt.Color(0, 0, 0));
        button_25.setText("X");
        button_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_25ActionPerformed(evt);
            }
        });

        button_26.setBackground(new java.awt.Color(255, 255, 255));
        button_26.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_26.setForeground(new java.awt.Color(0, 0, 0));
        button_26.setText("Y");
        button_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_26ActionPerformed(evt);
            }
        });

        button_27.setBackground(new java.awt.Color(255, 255, 255));
        button_27.setFont(new java.awt.Font("Dialog", 1, 18)); 
        button_27.setForeground(new java.awt.Color(0, 0, 0));
        button_27.setText("Z");
        button_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_27ActionPerformed(evt);
            }
        });

        button_15.setBackground(new java.awt.Color(255, 255, 255));
        button_15.setFont(new java.awt.Font("Dialog", 1, 18));
        button_15.setForeground(new java.awt.Color(0, 0, 0));
        button_15.setText("Ñ");
        button_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_21, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(button_27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_22, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(button_2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(button_24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(button_8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(button_14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(button_18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_1)
                    .addComponent(button_2)
                    .addComponent(button_5)
                    .addComponent(button_4)
                    .addComponent(button_3)
                    .addComponent(button_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_7)
                    .addComponent(button_8)
                    .addComponent(button_11)
                    .addComponent(button_10)
                    .addComponent(button_9)
                    .addComponent(button_12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_13)
                    .addComponent(button_14)
                    .addComponent(button_15)
                    .addComponent(button_16)
                    .addComponent(button_17)
                    .addComponent(button_18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_20)
                    .addComponent(button_19)
                    .addComponent(button_21)
                    .addComponent(button_22)
                    .addComponent(button_23)
                    .addComponent(button_24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_26)
                    .addComponent(button_27)
                    .addComponent(button_25))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 680);

        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setText("Juego");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); 

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setText("Nuevo Juego");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 14));
        jMenuItem2.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem2.setText("Cambiar apariencia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 14)); 
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setText("Acerca de ");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }                    

    
    //En caso de presionar el boton salir desde el juego, se pediran el nombre y edad para ser registrados 
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
      Datos dt = new Datos();
      if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer regresar al menu principal?",
                "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
        {
            
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre para registrarlo");
        setNombre(nombre);
            System.out.println(nombre);
            System.out.println(dt.getNombre());
        edad = JOptionPane.showInputDialog("Ingresa tu edad para registrarla");
        setEdad(edad);
        puntaje = String.valueOf(score);
        setPuntaje(puntaje);
        
        //Se activa el menu principal y se deasactiva este    
        ini i=new ini();
        i.setVisible(true);
        this.setVisible(false);
        }
        else{
                setDefaultCloseOperation(0);
        }
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
   
    private void button_25ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
        
    }                                         

    //En caso de querer general una palabra nueva o reiniciar el juego
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer una palabra nueva?",
                "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
        {iniciar();
        }
        else{
                setDefaultCloseOperation(0);
        }
        
    }                                       

    //No se puede hacer trampa
    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        JOptionPane.showMessageDialog(rootPane, "No hagas trampa!!", "Ahorcado", JOptionPane.INFORMATION_MESSAGE);
    }                                           

    //Reglas del juego
    private void helpActionPerformed(java.awt.event.ActionEvent evt) {                                     
     Icon intru=new ImageIcon(getClass().getResource("/imagenes/intru.png"));
        JOptionPane.showMessageDialog(null,"Jugadores: 2 (1 adivinador y 1 moderador)\n" +
"Objetivo: Descubrir la palabra o frase incógnita.\n" +
"\n" +
"Preparación:\n" +
"- Al inicio el moderador pensará en una palabra o frase y escribira la palabra cuando se le solicite.\n "
 +"Turno:\n" +
"- En su turno el jugador puede: Presionar una letra. \n" +
"- Presionar una letra: Se revisa si la letra presionada  se encuentra en la palabra secreta.\n" +
"-- Si la letra está, se sumaran 2 puntos y se anota la letra en la línea que ocupa su lugar en la palabra secreta.\n" +
"-- Si la letra no está, entonces se sumara un error y se aumentara una parte del muñeco ahorcado. \n" +
"- Muñeco: El muñeco se dibuja en 5 partes (cabeza, tronco y extremidades), por lo que el adivinador tiene 5 posibilidades de fallar.\n" +
"- Adivinar la Palabra: El jugador puede intentar adivinar la palabra o frase secreta.\n" +
"Fin de la partida:\n" +
"- GANA el adivinador si descubre la palabra o frase secreta. \n" +
"- PIERDE el avidinador si se dibuja el muñeco completo en la horca.\n", "Ahorcado - Instrucciones" +
"NOTA: Se suman 2 puntos por cada letra DISTINTA acertada, pero se suma el total solo si se adivina la palabra"
                , JOptionPane.INFORMATION_MESSAGE, intru);
    }                                    

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        
        
    }                                        

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
    }                                        

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
    }                                        

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
    }                                        

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    private void button_10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      
    }                                         

    private void button_12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_14ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_ÃActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void button_18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_19ActionPerformed(java.awt.event.ActionEvent evt) {                                          

    }                                         

    private void button_20ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_22ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void button_23ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_24ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void button_26ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void button_27ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      
    }                                         

    private void button_15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void txtPalabraActionPerformed(java.awt.event.ActionEvent evt) {                                           
    
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       iniciar();
    }                                          

    //Cambiar apariencia 
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
         Color c=JColorChooser.showDialog(rootPane, "Selecciona un color ", this.getBackground());
        jPanel1.setBackground(c);
        jPanel7.setBackground(c);
        jPanel2.setBackground(c);
    }                                          

    //Salir
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    //Acerca de 
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {                                    
        JOptionPane.showMessageDialog(null, "Ahoracdo V2.0", "Ahorcado", JOptionPane.INFORMATION_MESSAGE);
    }                                   
   private void button_00ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
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
            java.util.logging.Logger.getLogger(juego_normal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(juego_normal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(juego_normal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(juego_normal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new juego_normal().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JLabel Dibujo;
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_10;
    private javax.swing.JButton button_11;
    private javax.swing.JButton button_12;
    private javax.swing.JButton button_13;
    private javax.swing.JButton button_14;
    private javax.swing.JButton button_15;
    private javax.swing.JButton button_16;
    private javax.swing.JButton button_17;
    private javax.swing.JButton button_18;
    private javax.swing.JButton button_19;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_20;
    private javax.swing.JButton button_21;
    private javax.swing.JButton button_22;
    private javax.swing.JButton button_23;
    private javax.swing.JButton button_24;
    private javax.swing.JButton button_25;
    private javax.swing.JButton button_26;
    private javax.swing.JButton button_27;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JLabel errores;
    private javax.swing.JLabel puntos;
    private javax.swing.JLabel ptos;  
    private javax.swing.JButton help;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField txtPalabra;                
}