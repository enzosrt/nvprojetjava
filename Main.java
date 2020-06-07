/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import Vue.*;
import java.util.Scanner;

/**
 *
 * @author ZianL
 */
public class Main{
    public static FenetreConnexion f;
    public static Fenetre f1;
    public static int user,droit;
    
    public static void main(String[] args){
        int a;
        
        f = new FenetreConnexion();
        Login login=new Login();
        Login mdp=new Login();
        ControleLogin cl=new ControleLogin(login,mdp,f.getChamp(),f.getMdp(),Connexion.getInstance());
        
        f.getButton().addActionListener(cl);
        
        f1=new Fenetre();
        
        /*DAO<Seance> seanceDAO = new SeanceDAO(Connexion.getInstance());
        seanceDAO.modifier();
        a=seanceDAO.nbligne();
        for(int i = 1; i < a+1; i++){
            Seance seance = seanceDAO.find(i);
            System.out.println("Seance N°" + seance.getId() + "  - " + seance.getSemaine()
            +" - "+seance.getDate()+" - "+seance.getHeuredebut()+" - "+
            seance.getHeurefin()+" - "+seance.getEtat()+" - "+seance.getIdcours()+
            " - "+seance.getIdtype());
        }
        
        DAO<TypeCours> typecoursdao = new TypeCoursDAO(Connexion.getInstance());
        typecoursdao.delete();
        a=typecoursdao.nbligne();
        for(int i = 1; i < a+1; i++){
            TypeCours typeCours = typecoursdao.find(i);
            System.out.println("Site N°" + typeCours.getId() + "  - " + typeCours.getNom());
        }
        
        DAO<Site> sitedao = new SiteDAO(Connexion.getInstance());
        sitedao.ajouter();
        a=sitedao.nbligne();
        for(int i = 1; i < a+1; i++){
            Site site = sitedao.find(i);
            System.out.println("Site N°" + site.getId() + "  - " + site.getNom());
        }
        
        DAO<Salle> salledao = new SalleDAO(Connexion.getInstance());
        salledao.delete();
        a=salledao.nbligne();
        for(int i = 1; i < a+1; i++){
            Salle salle = salledao.find(i);
            System.out.println("Promotion N°" + salle.getId() + "  - " + salle.getNom()
            +" - "+ salle.getCapa()+" - "+ salle.getSite());
        }
        
        DAO<Promotion> promotiondao = new PromotionDAO(Connexion.getInstance());
        promotiondao.ajouter();
        a=promotiondao.nbligne();
        for(int i = 1; i < a+1; i++){
            Promotion promotion = promotiondao.find(i);
            System.out.println("Promotion N°" + promotion.getId() + "  - " + promotion.getNom());
        }
        
        DAO<Groupe> groupedao = new GroupeDAO(Connexion.getInstance());
        groupedao.delete();
        a=groupedao.nbligne();
        for(int i = 1; i < a+1; i++){
            Groupe groupe = groupedao.find(i);
            System.out.println("Groupe N°" + groupe.getId() + "  - " + groupe.getNom()
            +" - "+groupe.getPromo());
        }
        
        DAO<Etudiant> etudiantdao = new EtudiantDAO(Connexion.getInstance());
        etudiantdao.modifier();
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de l'etudiant :");
        int s = sc.nextInt();
        sc.nextLine();
        Etudiant etudiant = etudiantdao.find(s);
        System.out.println("Etudiant N°" + etudiant.getId() + "  - " + etudiant.getNum()+
        " - "+etudiant.getGr());
        
        DAO<Enseignant> enseignantdao = new EnseignantDAO(Connexion.getInstance());
        //enseignantdao.ajouter();
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de l'enseignant :");
        int s = sc.nextInt();
        sc.nextLine();
        Enseignant enseignant = enseignantdao.find(s);
        
        
        DAO<Cours> coursDao = new CoursDAO(Connexion.getInstance());
        coursDao.modifier();
        a=coursDao.nbligne();
        for(int i = 1; i < a+1; i++){
            Cours cours = coursDao.find(i);
            System.out.println("Cours N°" + cours.getId() + "  - " + cours.getNom());
        }
        
        DAO<Utilisateur> utilisateurDao = new UtilisateurDAO(Connexion.getInstance());
        //utilisateurDao.modifier();
        a=utilisateurDao.nbligne();
        for(int i = 1; i < a+1; i++){
            Utilisateur utilisateur = utilisateurDao.find(i);
            System.out.println("Utilisateur N°" + utilisateur.getId() + "  - " + 
            utilisateur.getEmail()+"  - " + utilisateur.getMdp()+"  - " + utilisateur.getNom()
            +"  - " + utilisateur.getPrenom()+"  - " + utilisateur.getDroit());
        }*/
    }
}
