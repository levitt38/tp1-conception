package decouverteinstruments;
      
import java.util.HashMap;
import java.util.Scanner;

public class Appli implements java.io.Serializable{
         
private HashMap<String, Instrument> lesInstruments = new HashMap<>();
private HashMap<String, Enfant> lesEnfants = new HashMap<>();
public static final String RED = "\u001B[31m";
public static final String RESET = "\u001B[0m";
public static final String GREEN = "\u001B[32m";

public HashMap<String, Instrument> getInstruments() {
	return lesInstruments;
}

public HashMap<String, Enfant> getEnfants() {
	return lesEnfants;
}

public void setInstruments(HashMap<String, Instrument> lesInstruments) {
        this.lesInstruments = lesInstruments;
    }

public void setEnfants(HashMap<String, Enfant> lesEnfants) {
        this.lesEnfants = lesEnfants;
}

/**
     * Creation d'un nouvel instrument
     * Un message de confimation est affiché à l'issue de la création.
     * Si l'instrument existe déjà, un message d'erreur est affiché
*/
public void nouveauInstrument()	{	
	System.out.println("Donnez le nom de l'instrument : | (0) pour quitter ");
        Scanner scan  = new Scanner(System.in);
        String s = scan.nextLine();
        if (s.charAt(0)=='0') { return; }
        if (! this.lesInstruments.containsKey(s)) {
            this.getInstruments().put(s, new Instrument(s));
            System.out.println(GREEN+"L'instrument : "+this.getInstruments().get(s).getNomInstrument() + " a été crée"+RESET);
        } else { System.out.println(RED+"Cet instrument existe déja !"+RESET); }
}

/**
     * Inscription d'un nouvel enfant
     * Un message de confimation est affiché à l'issue de la création.
     * Un message d'erreur est affiché pour chaque cas d'erreur (enfant déjà inscrit, instrument non existant, mauvais jour)
*/
public void nouvelEnfant(){
        System.out.println("Donnez le nom de l'enfant : | (0) pour quitter ");
        Scanner scan  = new Scanner(System.in); 
        String s = scan.nextLine();
        if (s.charAt(0)=='0') { return; }
        if (! this.lesEnfants.containsKey(s)) {
            this.getEnfants().put(s, new Enfant(s));
            System.out.println(GREEN+"L'enfant " + this.getEnfants().get(s).getNomEnfant() +" a été créee"+RESET);
        } else { System.out.println(RED+"Cet enfant est déja inscrit !"+RESET); }
}

public void Clear() {
    this.lesEnfants.clear();
    this.lesInstruments.clear();
}
	
/**
     * Inscription d'un enfant pour un autre instrument
     * Un message de confimation est affiché à l'issue de la création.
     * Un message d'erreur est affiché pour chaque cas d'erreur et chaque contrainte non vérifiée
*/

public void afficherInstruments() {
    System.out.print("\n");
    System.out.println("Liste des instruments : ");
    if ( ! this.getInstruments().isEmpty()) {
        for(Instrument ins : this.getInstruments().values()) {
            ins.Affiche();
        }
    } else { System.out.println(RED+"il n'y a pas d'instruments !"+RESET); }
}

public void afficherEnfants() {
    System.out.print("\n");
    System.out.println("Liste des enfants : ");
    if ( ! this.getEnfants().isEmpty()) {
        for(Enfant enf : this.getEnfants().values()) {
            enf.Affiche();
        }
    } else { System.out.println(RED+"il n'y a pas d'enfants !"+RESET); }
}


public void ajouterInstrumentEnfant() {
    Scanner scan = new Scanner(System.in); Enfant enf = new Enfant(""); Instrument ins = new Instrument(""); Jour jour = Jour.mercredi;
    int i = 0;
    do {
    System.out.println("Saisissez le nom de l'enfant | (0) pour quitter " );
    String enfant = scan.nextLine();
    if (enfant.charAt(0)=='0') { return; }
    try { enf = this.getEnfants().get(enfant); enf.Exception(); i++;}
    catch(NullPointerException e) {System.out.println(RED+"rentrez un enfant enregistré ou bien créez le"+RESET);}
    }while(i==0);
    
    do {
    System.out.println("Saisissez l'instrument | (0) pour quitter ");
    String instrument = scan.nextLine();
    if (instrument.charAt(0)=='0') { return; }
    try { ins = this.getInstruments().get(instrument); ins.Exception(); i++;}
    catch(NullPointerException e) {System.out.println(RED+"rentrez un instrument enregistré ou bien créez le"+RESET);}
    }while(i==1);
    
    do {
    System.out.println("Saisissez le jour | (0) pour quitter ");
    String jo = scan.nextLine();
    if (jo.charAt(0)=='0') { return; }
    try { jour = Jour.valueOf(jo); i++; }
    catch(Exception e) {System.out.println(RED+"rentrez un jour valide (mercredi,vendredi ou samedi)"+RESET);}
    }while(i==2);
    
    if(i==3) {
    JourSeance seance = new JourSeance(jour,enf,ins);
    enf.Inscrire(seance); ins.Inscrire(seance);
    }
}

public void afficherInscriptionsEnfants (){
    if ( ! this.getEnfants().isEmpty()) {
        for (Enfant enf : this.lesEnfants.values()) {
            System.out.println(enf.getNomEnfant()); System.out.print("\n");
            if ( ! enf.getJoursSeance().isEmpty()) {
                for (JourSeance seance : enf.getJoursSeance()) {
                    System.out.println("    "+seance.getJour()+"    "+seance.getInstrument());
                }
            } else { System.out.println("        pas d'inscriptions"); }
        }
    } else { System.out.println(RED+"         il n'y a pas d'enfants"+RESET); }
}
    
public void afficherInscriptionsInstruments(){
    if ( ! this.getInstruments().isEmpty()) {
        for (Instrument ins : this.lesInstruments.values()) {
            System.out.println(ins.getNomInstrument()); System.out.print("\n");
            if ( ! ins.getJoursSeance().isEmpty()) {
                for (JourSeance seance : ins.getJoursSeance()) {
                    System.out.println("    "+seance.getJour()+"    "+seance.getEnfant());
                }
            } else { System.out.println("        pas d'inscrits"); }
        }
    } else { System.out.println(RED+"         il n'y a pas d'instruments"+RESET); }
      
}

public void supEnfant() {
    int i =0; Scanner scan = new Scanner(System.in);
    do {
    System.out.println("Quel enfant voulez-vous supprimer ? | (0) pour quitter");
    String enf = scan.nextLine();
    if (enf.charAt(0) == '0') {return;}
    else if (this.getEnfants().containsKey(enf)) {
    this.getEnfants().remove(enf); i++; System.out.println(GREEN+"L'enfant "+enf+" a été supprimé"+RESET);
    } else { System.out.println(RED+"Veuillez rentrer un enfant existant !"+RESET); }
    } while (i==0);
}

public void supInstrument() {
    int i =0; Scanner scan = new Scanner(System.in);
    do {
    System.out.println("Quel instrument voulez-vous supprimer ? | (0) pour quitter");
    String ins = scan.nextLine();
    if (ins.charAt(0) == '0') {return;}
    else if (this.getInstruments().containsKey(ins)) {
    this.getInstruments().remove(ins); i++; System.out.println(GREEN+"L'instrument "+ins+" a été supprimé"+RESET);
    } else { System.out.println(RED+"Veuillez rentrer un instrument existant !"+RESET); }
    } while (i==0);
}

}





