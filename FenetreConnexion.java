/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ZianL
 */
public class FenetreConnexion extends JFrame{
    JTextField champ;
    JPasswordField mdp;
    JButton b; 
    JPanel p;
    JLabel l,l1,l2;
    Font font,font1;
    
    public FenetreConnexion(){       
        super("Mon emploie du temps");
        
        l=new JLabel("Connexion");
        l1=new JLabel("Email :");
        l2=new JLabel("Mot de passe :");
        l.setBounds (355 , 50 ,  500 ,100);
        l1.setBounds (250 , 213 ,  500 ,100);
        l2.setBounds (250 , 300 ,  500 ,100);
        font =new Font("Arial",Font.BOLD,50);
        font1 =new Font("Arial",Font.BOLD,30);
        l.setFont(font);
        l1.setFont(font1);
        l2.setFont(font1);
        champ=new JTextField();
        champ.setColumns(10);
        champ.setBounds ( 500 , 250 ,  200 , 30 );
        mdp=new JPasswordField();
        mdp.setColumns(10);
        mdp.setBounds ( 500 , 338 ,  200 , 30 );
        b=new JButton("Connexion");
        b.setBounds ( 450 , 420 , 110 , 40 ); 
        add(l);add(l1);add(l2);
        add(champ);add(mdp);
        add(b);
        
        setLayout(null);
        setSize ( 1000 , 1000 );
        setLocationRelativeTo(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }
    
    public JTextField getChamp(){
        return champ;
    }
    
    public JPasswordField getMdp(){
        return mdp;
    }
    
    public JButton getButton(){
        return b;
    }
}
