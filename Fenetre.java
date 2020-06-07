/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import Modele.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ZianL
 */
public class Fenetre extends JFrame{
    JMenuBar menuBar = new JMenuBar();
    public JMenu cours = new JMenu("Cours  ");
    public JMenu info = new JMenu("Information  ");
    public JMenu salle = new JMenu("Salle  ");
    public JMenuItem etudiant = new JMenuItem("Etudiant");
    public JMenuItem enseignant = new JMenuItem("Enseignant");
    public JMenuItem scolarite = new JMenuItem("Scolarite");
    public JMenuItem admin = new JMenuItem("Administrateur");
    JPanel p=new JPanel();
    JOptionPane etu; 
    Font font,font1;
    JTabbedPane onglet;
    int i = 0;
    public static Object[][] data1={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data2={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data3={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data4={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data5={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data6={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data7={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data8={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data9={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    public static Object[][] data10={{"","Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"},
    {"8:30-10:00","","","","","","",""},{"10:15-11:45","","","","","","",""},
    {"12:00-13:30","","","","","","",""},{"13:45-15:15","","","","","","",""},
    {"15:30-17:00","","","","","","",""},{"17:15-18:45","","","","","","",""},
    {"19:00-20:00","","","","","","",""}};
    String  title[] = {"","", "", "","","","",""};
    
    public Fenetre(){
        super("Mon emploie du temps");
        setContentPane(p);
        p.setLayout(null);
        menuBar.setBounds (0 , 0 ,  2100 ,70);
        p.add(menuBar);
        font =new Font("Arial",Font.BOLD,30);
        font1 =new Font("Arial",Font.BOLD,20);
        cours.setFont(font);
        info.setFont(font);
        salle.setFont(font);
        etudiant.setFont(font);
        enseignant.setFont(font);
        scolarite.setFont(font);
        admin.setFont(font);  
        
        JTable t1 = new JTable(data1, title);
        JTable t2 = new JTable(data2, title);
        JTable t3 = new JTable(data3, title);
        JTable t4 = new JTable(data4, title);
        JTable t5 = new JTable(data5, title);
        JTable t6 = new JTable(data6, title);
        JTable t7 = new JTable(data7, title);
        JTable t8 = new JTable(data8, title);
        JTable t9 = new JTable(data9, title);
        JTable t10 = new JTable(data10, title);
        t1.setFont(font1);
        t2.setFont(font1);
        t3.setFont(font1);
        t4.setFont(font1);
        t5.setFont(font1);
        t6.setFont(font1);
        t7.setFont(font1);
        t8.setFont(font1);
        t9.setFont(font1);
        t10.setFont(font1);
        DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
        custom.setHorizontalAlignment(JLabel.CENTER);
        for (int i=0 ; i < 8 ; i++) {
            t1.getColumnModel().getColumn(i).setCellRenderer(custom);
            t2.getColumnModel().getColumn(i).setCellRenderer(custom);
            t3.getColumnModel().getColumn(i).setCellRenderer(custom);
            t4.getColumnModel().getColumn(i).setCellRenderer(custom);
            t5.getColumnModel().getColumn(i).setCellRenderer(custom);
            t6.getColumnModel().getColumn(i).setCellRenderer(custom);
            t7.getColumnModel().getColumn(i).setCellRenderer(custom);
            t8.getColumnModel().getColumn(i).setCellRenderer(custom);
            t9.getColumnModel().getColumn(i).setCellRenderer(custom);
            t10.getColumnModel().getColumn(i).setCellRenderer(custom);
        }
        for (i=0;i<8;i++){
            t1.setRowHeight(i,100);
            t2.setRowHeight(i, 100);
            t3.setRowHeight(i, 100);
            t4.setRowHeight(i, 100);
            t5.setRowHeight(i, 100);
            t6.setRowHeight(i, 100);
            t7.setRowHeight(i, 100);
            t8.setRowHeight(i, 100);
            t9.setRowHeight(i, 100);
            t10.setRowHeight(i, 100);
        }
        
        onglet = new JTabbedPane();
        onglet.setBounds(10, 80, 1890, 900);
        onglet.setFont(font1);
        onglet.add("Semaine 1",new JScrollPane(t1));
        onglet.add("Semaine 2",new JScrollPane(t2));
        onglet.add("Semaine 3",new JScrollPane(t3));
        onglet.add("Semaine 4",new JScrollPane(t4));
        onglet.add("Semaine 5",new JScrollPane(t5));
        onglet.add("Semaine 6",new JScrollPane(t6));
        onglet.add("Semaine 7",new JScrollPane(t7));
        onglet.add("Semaine 8",new JScrollPane(t8));
        onglet.add("Semaine 9",new JScrollPane(t9));
        onglet.add("Semaine 10",new JScrollPane(t10));

     