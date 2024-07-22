/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nuevo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author ar466
 */
public class Tablero extends javax.swing.JFrame implements ActionListener {
    JButton[][] Buttons = new JButton[6][6];
    JLabel[] RuletaLBL = new JLabel[3];
    Random Randy = new Random();
    JLabel JugadorTurno;
    JButton SpinBTN;
    JPanel SpinPNL;
    Tablero_1 tablero;
    boolean Movement;
    int Movimientos;
    int Turno = 1;
    int X, Y;

    String AuxMonster;
    Icon AuxImage;
    boolean girar;
    int RandomNMB;
    int Selected;
    Timer timer;
    int loop;
    
    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        tablero = new Tablero_1();
        configurarTablero();
        UpdateIcons(true);
        extraComponents();
        Movement = true;
        Movimientos = 1;
        X = 0;
        Y = 0;
        
            JFrame panel = new JFrame();

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (loop >= RandomNMB) {
                    ((Timer) e.getSource()).stop(); 
                    boolean found = false;
                    loop = -1;

                    for (int i = 0; i < 6; i++) {

                        for (int j = 0; j < 6; j++) {
        
                            if (RuletaLBL[0].getName().equals((tablero.getValorCasilla(i, j)))) {
        
                                if (tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno))) {
        
                                    Buttons[i][j].setBackground(Color.GREEN);
                                    found = true;

                                }
        
                            }
        
                        }
        
                    }

                    if (!found) MovementDone();

                }

                for (int i = 0; i < 2; i++) {
                    AuxImage = RuletaLBL[i + 1].getIcon();
                    RuletaLBL[i + 1].setIcon(RuletaLBL[i].getIcon());
                    RuletaLBL[i].setIcon(AuxImage);

                    AuxMonster = RuletaLBL[i + 1].getName();
                    RuletaLBL[i + 1].setName(RuletaLBL[i].getName());
                    RuletaLBL[i].setName(AuxMonster);
                }
                loop++;
            }


            
        });

    }

    private void extraComponents() {
        setLayout(null);
        SpinBTN = new JButton("Girar ruleta");
        SpinBTN.setBounds(580, 20, 300, 50);
        SpinBTN.setFont(jButton1.getFont());
        SpinBTN.addActionListener(this);

        SpinPNL = new JPanel();
        SpinPNL.setBounds(580,100,300,300);
        SpinPNL.setOpaque(false);

        for (int i = 0; i < 3; i++) {
            RuletaLBL[i] = new JLabel();
            RuletaLBL[i].setBorder(BorderFactory.createLineBorder(((i == 2) ? Color.red : Color.blue), 3));
            RuletaLBL[i].setIcon(scaleImage(MonsterUrl(i), 90, 90));

            SpinPNL.add(RuletaLBL[i]);
        }
        RuletaLBL[0].setName("W");
        RuletaLBL[1].setName("V");
        RuletaLBL[2].setName("N");
        RuletaLBL[0].setBounds(125, 50, 100,100);
        RuletaLBL[1].setBounds(0, 150, 100,100);
        RuletaLBL[2].setBounds(150, 150, 100,100);

        JugadorTurno = new JLabel();
        JugadorTurno.setBounds(580, 300, 300, jButton1.getHeight() + 10);
        JugadorTurno.setText("Turno de: " + Usuarios.getUsername(Turno));
        JugadorTurno.setHorizontalAlignment(JLabel.CENTER);
        JugadorTurno.setFont(jButton1.getFont());

        jButton1.setBounds(580, 425, 300, jButton1.getHeight() + 10);
        add(JugadorTurno);
        add(SpinPNL);
        add(SpinBTN);
    }

    private void setSpinIcons() {
        for (int i = 0; i < 3; i++) {
            RuletaLBL[i].setIcon(scaleImage(MonsterUrl(i), 90, 90));
        }
        RuletaLBL[0].setName("W");
        RuletaLBL[1].setName("V");
        RuletaLBL[2].setName("N");
    }

    private String MonsterUrl(int Monster) {
        String name = "";
        switch (Monster) {
            case 0:
                name = "Monstruos\\W" + ((Turno == 1) ? "W" : "B") + ".png";
                break;

            case 1:
                name = "Monstruos\\V" + ((Turno == 1) ? "W" : "B") + ".png";
                break;

            case 2:
                name = "Monstruos\\N" + ((Turno == 1) ? "W" : "B") + ".png";
                break;
        } 
        return name;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 559, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 560, Short.MAX_VALUE));

        jButton1.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jButton1)
                                .addContainerGap(195, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        endGame(" Se ha retirado, ", " ha ganado por default.");

        Usuarios.addPoints((Turno == 1)? 2 : 1);
        new MenuPrincipal().setVisible(true);
        dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void configurarTablero() {
        jPanel1.removeAll();
        GridLayout gridLayout = new GridLayout(tablero.getFilas(), tablero.getColumnas());
        gridLayout.setHgap(0);
        gridLayout.setVgap(0);
        jPanel1.setLayout(gridLayout);
        Dimension dimension = new Dimension(90, 90);
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Color color = (i + j) % 2 == 0 ? Color.red : Color.WHITE;
 
                Buttons[i][j] = new JButton();
                Buttons[i][j].setName(String.valueOf(tablero.getValorCasilla(i, j)));
                Buttons[i][j].setBackground(color);
                Buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 31));
                Buttons[i][j].setFocusPainted(false);
                Buttons[i][j].addActionListener(this);
                Buttons[i][j].setPreferredSize(dimension);
                Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                Buttons[i][j].setBorderPainted(true);
                
                jPanel1.add(Buttons[i][j]);
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private ImageIcon scaleImage(String url, int width, int height) {
        ImageIcon neocard = new ImageIcon(getClass().getResource(url));
        Image Scalecard = neocard.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(Scalecard);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SpinBTN && SpinBTN.isEnabled()) {
            Randy.setSeed(Randy.nextLong());
            RandomNMB = Randy.nextInt(50, 101);
            SpinBTN.setEnabled(false);
            timer.start();
            return ;
        }

        if (!SpinBTN.isEnabled()) {

            // Red/White - normal color
            for (int i = 0; i < tablero.getFilas(); i++) {

                for (int j = 0; j < tablero.getColumnas(); j++) {
    
                    //Green - movement
                    if (Buttons[i][j] == e.getSource() && Buttons[i][j].getBackground() == Color.GREEN) {
                        X = i;
                        Y = j;

                        MovableSpaces(i, j);
                    } else if (Buttons[i][j] == e.getSource()) {
                        Color BGColor = Buttons[i][j].getBackground();

                        //Black - Movement
                        if (BGColor == Color.BLACK) {
                            
                            if (tablero.MoveFicha(X, Y, i, j)) {
                                UpdateIcons(true);
                                SpinBTN.setEnabled(true);
                                MovementDone();
                            }

                        //Yellow - Normal Attack
                        } else if (BGColor == Color.YELLOW) {

                            if (attackAt(i, j)) {
                                UpdateIcons(true);
                                SpinBTN.setEnabled(true);
                                MovementDone();
                            }

                        //Blue - zombie invocation
                        } else if (BGColor == Color.BLUE) {

                            if (tablero.InvocarZombie(i, j, Turno)) {
                                UpdateIcons(true);
                                SpinBTN.setEnabled(true);
                                MovementDone();
                            }

                        //Gray - Zombie attack
                        } else if (BGColor == Color.GRAY) {

                            if (ZombieAttack(j, i)) {
                                UpdateIcons(true);
                                SpinBTN.setEnabled(true);
                                MovementDone();
                            }

                        }

                    }
    
                }
    
            }

            MonsterCount(false);
        }

    }

    private boolean ZombieAttack(int x, int y) {

        String MonsterAttacked = "";
        switch (tablero.getValorCasilla(x, y)) {

            case "W": MonsterAttacked = "El hombre lobo de " + tablero.getFicha(x, y).getOwner(); break;
            case "V": MonsterAttacked = "El vampiro de " + tablero.getFicha(x, y).getOwner(); break;
            case "N": MonsterAttacked = "La muerte de " + tablero.getFicha(x, y).getOwner(); break;

        }

        tablero.getFicha(x, y).ReceiveNormalDamage(1);
        JOptionPane.showMessageDialog(this, MonsterAttacked, "Ataque recibido", JOptionPane.INFORMATION_MESSAGE);
        if (tablero.getFicha(x, y).getLife() <= 0) {
            tablero.removeFicha(x, y);
        }


        return true;
    }

    private void MovableSpaces(int x, int y) {

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {
                Color color = (i + j) % 2 == 0 ? Color.red : Color.WHITE;

                if (tablero.getFicha(i, j) == null) {

                    Buttons[i][j].setBackground(color);
                    Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

                } else if (!tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno))) {

                    Buttons[i][j].setBackground(color);
                    Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

                }

            }

        }

        switch (tablero.getValorCasilla(x, y)) {

            case "W":
                NormalMovementTiles(x, y);
                specialMovementTiles(x, y, true);
            break;

            case "V":
                NormalMovementTiles(x, y);
            break;

            case "N":
                InvocationTiles();
                NormalMovementTiles(x, y);
                specialMovementTiles(x, y, false);
            break;

        }

    }

    private void InvocationTiles() {

        for (int i = 0; i < 6; i++){

            for (int j = 0; j < 6; j++) {

                if (tablero.getFicha(i, j) == null) {

                    Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.CYAN, 4));
                    Buttons[i][j].setBackground(Color.BLUE);
                    Buttons[i][j].setBorderPainted(true);

                } else if (tablero.getValorCasilla(i, j).equals("Z") && tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno))) {

                    paintZombieAttacks(i, j);

                }

            }

        }

    }

    private void paintZombieAttacks(int x, int y) {

        for (int i = x - 1; i <= x + 1; i++) {

            for (int j = y - 1; j <= y + 1; j++) {

                try {

                    if (!tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno))) {

                        Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray, 4));
                        Buttons[i][j].setBackground(Color.GRAY);
                        Buttons[i][j].setBorderPainted(true);

                    }

                } catch (Exception e){}

            }

        }

    }

    private void specialMovementTiles(int x, int y, boolean Werewolf) {
        for (int i = x - 2; i <= x + 2; i++) {

            for (int j = y - 2; j <= y + 2; j++) {

                try {

                    if (Buttons[i][j].getBackground() == Color.red || Buttons[i][j].getBackground() == Color.WHITE) {
                        paintSpecialMoveTiles(i, j, Werewolf);
                    }
    
                } catch (Exception e){} 
 
            }

        }
    }

    private void paintSpecialMoveTiles(int x, int y, boolean Werewolf) {
        if (Werewolf) {

            if (tablero.getFicha(x, y) == null) {
                Buttons[x][y].setBackground(Color.BLACK);
                Buttons[x][y].setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
            }

        } else {

            if (tablero.getFicha(x, y) != null) {

                if (!tablero.getFicha(x, y).getOwner().equals(Usuarios.getUsername(Turno))) {

                    Buttons[x][y].setBorder(BorderFactory.createLineBorder(Color.CYAN, 4));
                    Buttons[x][y].setBackground(Color.BLUE);

                }

            }

        }
    }

    private void NormalMovementTiles(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {

            for (int j = y - 1; j <= y + 1; j++) {

                paintNormalMoveTiles(i, j);

            }

        }
    }

    private void paintNormalMoveTiles(int x, int y) {
        try {
            Color bg = Buttons[x][y].getBackground();
            Border Bd = Buttons[x][y].getBorder();
    
            if (tablero.getFicha(x, y) == null) {

                Bd = BorderFactory.createLineBorder(Color.WHITE, 4);
                bg = Color.BLACK;

            } else {

                if (!tablero.getFicha(x, y).getOwner().equals(Usuarios.getUsername(Turno))){
                    Bd = BorderFactory.createLineBorder(Color.RED, 4);
                    bg = Color.YELLOW;
                }
    
            }
    
            Buttons[x][y].setBackground(bg);
            Buttons[x][y].setBorder(Bd);
        } catch (Exception e) {}
    }

    private void MovementDone() {
        Movimientos--;
        SpinBTN.setEnabled(true);
        if (Movimientos == 0) {
            Turno = (Turno == 1) ? 2 : 1;
            setSpinIcons();

            MonsterCount(true);
            JugadorTurno.setText("Turno de: " + Usuarios.getUsername(Turno));
            JOptionPane.showMessageDialog(this, JugadorTurno.getText(), "Cambio de turno", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean attackAt(int i, int j) {

        try {
            String MonsterAttacked = "";
            switch (tablero.getValorCasilla(i, j)) {

                case "W": MonsterAttacked = "El hombre lobo de " + tablero.getFicha(i, j).getOwner(); break;
                case "V": MonsterAttacked = "El vampiro de " + tablero.getFicha(i, j).getOwner(); break;
                case "N": MonsterAttacked = "La muerte de " + tablero.getFicha(i, j).getOwner(); break;
                case "Z": MonsterAttacked = "El zombie de " + tablero.getFicha(i, j).getOwner(); break;

            }


            switch (tablero.getValorCasilla(X, Y)) {

                case "W":
                    tablero.getFicha(i, j).ReceiveNormalDamage(tablero.getFicha(X, Y).getAttack());
                    JOptionPane.showMessageDialog(this, MonsterAttacked + " ha recibido " + tablero.getFicha(X, Y).getAttack() + " de daño.", "Daño recibido", JOptionPane.INFORMATION_MESSAGE);

                    if (tablero.getFicha(i, j).getLife() <= 0) {
                        tablero.removeFicha(i, j);
                    }
                    return true;
                
                case "V":
                    Object[] opciones = {"Ataque normal", "Chupar sangre"};
                    int Damage  = 1;
                    if (JOptionPane.showOptionDialog(this, "Eliga una opcion de ataque: ", "Opciones de ataque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, 0) == 0){

                        Damage = tablero.getFicha(X, Y).getAttack();

                    } else tablero.getFicha(X, Y).doVampireSpecial();;
                    tablero.getFicha(i, j).ReceiveNormalDamage(Damage);
                    JOptionPane.showMessageDialog(this, MonsterAttacked + " ha recibido " + tablero.getFicha(X, Y).getAttack() + " de daño.", "Daño recibido", JOptionPane.INFORMATION_MESSAGE);

                    if (tablero.getFicha(i, j).getLife() <= 0) {
                        JOptionPane.showMessageDialog(this, MonsterAttacked + " ha muerto", "Monstruo destruido", JOptionPane.INFORMATION_MESSAGE);
                        tablero.removeFicha(i, j);
                    }
                return true;

                case "N":
                Object[] Opciones = {"Ataque normal", "Usar lanza"};
                int damage = (tablero.getFicha(i, j).getAttack()/2);
                if (JOptionPane.showOptionDialog(this, "Eliga una opcion de ataque: ", "Opciones de ataque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Opciones, 0) == 0){

                        damage = tablero.getFicha(X, Y).getAttack();

                    } else tablero.getFicha(X, Y).doVampireSpecial();;
                    tablero.getFicha(i, j).ReceiveNormalDamage(damage);
                    JOptionPane.showMessageDialog(this, MonsterAttacked + " ha recibido " + tablero.getFicha(X, Y).getAttack() + " de daño.", "Daño recibido", JOptionPane.INFORMATION_MESSAGE);

                    if (tablero.getFicha(i, j).getLife() <= 0) {
                        JOptionPane.showMessageDialog(this, MonsterAttacked + " ha muerto", "Monstruo destruido", JOptionPane.INFORMATION_MESSAGE);
                        tablero.removeFicha(i, j);
                    }
                return true;

            }

        } catch (Exception e) {}

        return false;
    }

    private void MonsterCount(boolean EndTurn) {
        int count = 0;
        
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                if (EndTurn) {

                    if (tablero.getFicha(i, j) != null && tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno)) && !tablero.getFicha(i, j).getMonster().equals("Z")) {
                        count++;
                    }

                } else {

                    if (tablero.getFicha(i, j) != null && !tablero.getFicha(i, j).getOwner().equals(Usuarios.getUsername(Turno)) && !tablero.getFicha(i, j).getMonster().equals("Z")) {
                        count++;
                    }

                }

            }

        }

        if (count == 0) {
            endGame(" ha perdido, ", " se ha comido a todos sus monstruos.");

            Usuarios.addPoints((Turno == 1)? 2 : 1);
            dispose();
            new MenuPrincipal().setVisible(true);
        }

        if (EndTurn) {
            if (count <= 2) {
                Movimientos = 3;
            } else if (count <= 4) {
                Movimientos = 2;
            } else Movimientos = 1;
        }

    }

    private void endGame(String msg, String msg2) {
        String endMsg = EndMatchMessage(msg, msg2);
        JOptionPane.showMessageDialog(this, endMsg, "Fin de partida", JOptionPane.INFORMATION_MESSAGE);
        Usuarios.addHistorial(endMsg);
    }

    private String EndMatchMessage(String msg, String msg2) {
        String endMsg = Usuarios.getUsername(Turno).toUpperCase();
        endMsg += msg;
        endMsg += Usuarios.getUsername((Turno == 1)? 2 : 1).toUpperCase();
        endMsg += msg2;
        return endMsg;
    }

    private void UpdateIcons(boolean fullRestart) {
        FichasTablero ficha;
        String ImageUrl;
        for (int i = 0; i < tablero.getFilas(); i++) {

            for (int j = 0; j < tablero.getColumnas(); j++) {
                Color color = (i + j) % 2 == 0 ? Color.red : Color.WHITE;
                ficha = tablero.getFicha(i, j);

                if (ficha != null) {
                    ImageUrl = "Monstruos\\" + ficha.getMonster() + ((ficha.getOwner().equals(Usuarios.getUsername(1))) ? "W" : "B") + ".png";

                    Buttons[i][j].setIcon(scaleImage(ImageUrl, 90, 90));
                    Buttons[i][j].setName(ficha.getMonster());
                } else Buttons[i][j].setIcon(null);

                if (fullRestart) {
                    Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    Buttons[i][j].setBorderPainted(true);
                    Buttons[i][j].setBackground(color);
                }
            }

        }

    }

}