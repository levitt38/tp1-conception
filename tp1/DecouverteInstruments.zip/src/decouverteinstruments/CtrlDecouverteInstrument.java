/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decouverteinstruments;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author culeta
 */
public class CtrlDecouverteInstrument {
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	        	
	    	Appli appli = new Appli();
	    	
			int choix =0;
			do {
			System.out.println(CYAN+"\n*****************************************************************"+RESET);
			System.out.println("    *  Association de musique - Découverte d'instruments        *");
			System.out.println("*****************************************************************");
			System.out.println("      * 1- Créer un nouveau instrument                          *");
			System.out.println("      * 2- Inscrire un enfant                                   *");
			System.out.println(BLUE+"      * 3- Ajouter une demande d'instrument à un enfant inscrit *"+RESET);
			System.out.println("      * 4- Afficher les demandes des enfants                    *");
			System.out.println("      * 5- Afficher les demandes pour les instruments           *");
                        System.out.println("      * 6- Afficher les instruments                             *");
                        System.out.println("      * 7- Afficher les enfants                                 *");
                        System.out.println("      * 8- Supprimer un enfant                                  *");
                        System.out.println("      * 9- Supprimer un instrument                              *");
			
                        System.out.println("*****************************************************************");
			System.out.println("      * 0- Quitter                                              *");
			System.out.println(CYAN+"*****************************************************************"+RESET);
			System.out.print("      Votre Choix : ");
			
			try {
                            choix = sc.nextInt();
                        }
                        catch ( InputMismatchException ex ){
                           System.out.println("Choix non valide - Relancer le programme");
                          }
			switch (choix) {
				case 1: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.nouveauInstrument(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break; }
				case 2: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.nouvelEnfant(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case 3: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.ajouterInstrumentEnfant(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case 4: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherInscriptionsEnfants(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case 5: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherInscriptionsInstruments(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
                                case 6: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherInstruments(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
                                case 7: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherEnfants(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
                                case 8: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.supEnfant();
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
                                case 9: {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.supInstrument();
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				
				default:
                                        break;
				} // switch
			} while (choix != 0);	
    }
    
}
