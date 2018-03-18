//package com.esprit.tests;
//
//import com.esprit.entities.Etudiant;
//import com.esprit.services.EtudiantService;
//import java.sql.*;
//import tp_db.Bgcolor;
//
//public class EtudiantServiceTest {
//
//    public static void main(String args[]) {
//       
//        Etudiant e = new Etudiant("Nom", "Prenom");
//        EtudiantService es = new EtudiantService();
//        es.createEtudiant(new Etudiant("Nom", "Prenom"));
//        es.createEtudiant(new Etudiant("Nom2", "Prenom2"));
//        es.createEtudiant(new Etudiant("Nom3", "Prenom3"));
//        es.createEtudiant(new Etudiant("Nom4", "Prenom4"));
//        
//        
//        
//        System.out.println("Avant delete ****************************");
//        es.getAll().forEach(System.out::println);
//        es.delete(9);
//        System.out.println("Avant update****************************");
//        es.getAll().forEach(System.out::println);
//        es.update(new Etudiant(8, "updated nom", "updated prenom"));
//        System.out.println("Apres delete****************************");
//        es.getAll().forEach(System.out::println);
//    }
//}
