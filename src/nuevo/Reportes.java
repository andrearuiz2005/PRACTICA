package nuevo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Reportes extends JFrame implements ActionListener{
    private JTextPane InformationPane;

    public Reportes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel MainPNL = new JPanel();
        MainPNL.setPreferredSize(new Dimension(900,600));
        MainPNL.setBackground(Color.BLACK);
        MainPNL.setLayout(null);

        JLabel AuxImage = new JLabel();
        AuxImage.setBounds(500, 0, 400, 600);
//        AuxImage.setIcon(new ImageIcon(getClass().getResource("Monstruos\\Carmesi.png")));
        
        JButton ExitBTN = new JButton();
        ExitBTN.setBounds(50,25,400,30);
        ExitBTN.setBackground(new java.awt.Color(212, 45, 10));
        ExitBTN.setFont(new java.awt.Font("Cambria", 3, 14));
        ExitBTN.setForeground(new java.awt.Color(255, 255, 255));
        ExitBTN.setText("Regresar");
        ExitBTN.addActionListener(this);
        MainPNL.add(ExitBTN);

        InformationPane = new JTextPane();
        InformationPane.setFont(new java.awt.Font("Cambria", 3, 18));
        InformationPane.setBounds(50, 75, 400, 500);
        InformationPane.setText(setInformation());
        InformationPane.setEditable(false);
        JScrollPane scrollPanelRanking = new JScrollPane(InformationPane);
        scrollPanelRanking.setBounds(InformationPane.getBounds()); 
        MainPNL.add(scrollPanelRanking);

        MainPNL.add(AuxImage);
        add(MainPNL);
        pack();
    }

    private String setInformation(){

        return "\tRanking\n" + Usuarios.Ranking() + "\n" + Usuarios.getHistorial();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new MenuPrincipal().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        new Reportes().setVisible(true);
    }

}
