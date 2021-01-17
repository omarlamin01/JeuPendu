import java.util.Random;
import java.util.Scanner;

public class JeuPendu {
    public String[][] List = {{"Taroudant","Casablanca","Agadir","Paris","Londres"},{"Rouge","Blue","Vert","Blanc","Noire"},{"Biologie","Geologie","Physique","Astronomie","Chimie"},{"Java","Swift","Python","JavaScript","Html"},{"Chien","Chat","Lion","Vache","Giraffe"}}; //Liste des mot utilisees dans le jau.
    public char[] Mot; //Le variable dans le on va stocker un mot choisie depuis la liste precedente.
    public char[] MotCache; //Variable auxiliaire pour generer le jeu.
    public Scanner sc = new Scanner(System.in); //Scanner pour lire une lettre entree par le joueur.
    public Random rand = new Random(System.nanoTime()); //Variable aleatoire.
    public int trv; //Nombre de lettres trouvees.
    public int e; //Nombre maximale des essaies.
    public int choix; //Variable pour stocker le choix du categorie des mot en mode sol.
    int Decision; //Variable pour stocker la decision du joueur s'il va contnuer au jeu ou non.
    int ModeJeu; //Variable pour generer le mode du jeu.

    //Declaration des couleures utilisees dans le jeu.
        public static final String ColReset = "\u001B[0m";
        public static final String ColNoire = "\u001B[30m";
        public static final String ColRouge = "\u001B[31m";
        public static final String ColVert = "\u001B[32m";
        public static final String ColJaune = "\u001B[33m";
        public static final String ColBleu = "\u001B[34m";
        public static final String ColViolet = "\u001B[35m";
        public static final String ColCyan = "\u001B[36m";
        public static final String ColBlanc = "\u001B[37m";


    /* Constucteur. */
    public JeuPendu() {}

    /* Procedure pour choisir un mot aleatoirement depuis 'List[]' et le stocker en 'Mot[]'. */
    public void initialiserMot(){
        trv = 1;
        e = 10;
        int indx = rand.nextInt(List[choix-1].length); //Entier choisie aleatoirement pour jouer le role d'index du tableau 'List[]'.
        Mot = List[choix-1][indx].toLowerCase().toCharArray(); //Initialisation du 'Mot[]'.
        MotCache = new char[Mot.length]; //Initialisation du 'MotCache[]'.
        int indx1 = rand.nextInt(MotCache.length); //Entier choisie aleatoirement pour jouer le role d'index du tableau 'Mot[]'.
        for (int i = 0; i < MotCache.length; i++){
            if (i == indx1) {
                MotCache[i] = Mot[i];
            } else {
                MotCache[i] = '_';
            }
        }
    }

    /* Procedure qui permet au premier joueur en mode du deux joueur d'entrer un mot que le deuxieme joueur va le devine. */
    public void entrerMot() {
        trv = 1;
        e = 10;
        System.out.println(ColRouge+"Le premier joueur entre un mot que le deuxieme joueur va le deviner."+ColReset);
        System.out.print(ColBleu+"Joueur 1: \nEntrer un mot: "+ColReset);
        String str = sc.next();
        Mot = str.toLowerCase().toCharArray();
        MotCache = new char[Mot.length]; //Initialisation du 'MotCache[]'.
        int indx1 = rand.nextInt(MotCache.length); //Entier choisie aleatoirement pour jouer le role d'index du tableau 'Mot[]'.
        for (int i = 0; i < MotCache.length; i++){
            if (i == indx1) {
                MotCache[i] = Mot[i];
            } else {
                MotCache[i] = '_';
            }
        }
    }

    /* Procedure permettante d'afficher le mot cache au joueur. A la premier fois il affiche une lettre aleatoirement. */
    public void afficherMot(){
        System.out.println(ColRouge+"Devinez le mot cachee."+ColReset);
        System.out.print(ColBleu+"Le mot est: "+ColReset);
        for (char c : MotCache) { System.out.print(ColCyan+c+ColReset); }
        System.out.println(ColRouge+"\nIl vous reste "+e+" essai encore."+ColReset);
        System.out.println(ColVert+"Vous avez trouve "+trv+" lettre. Il vous reste "+(MotCache.length-trv)+"."+ColReset);
    }

    /* Procedure qui affiche le pendu. */
    public void affichePendu() {
        switch(e) {
            case 10:

                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 9:

                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println ("                  ");
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 8:

                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 7:

                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 6:


                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 5:

                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"     /|      |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 4:
                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"     /|\\     |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 3:
                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"     /|\\     |     "+ColReset);
                System.out.println (ColCyan+"      -      |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 2:
                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"     /|\\     |     "+ColReset);
                System.out.println (ColCyan+"      -      |     "+ColReset);
                System.out.println (ColCyan+"     /       |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;

            case 1:
                System.out.println (ColCyan+"      |------|     "+ColReset);
                System.out.println (ColCyan+"      O      |     "+ColReset);
                System.out.println (ColCyan+"     /|\\     |     "+ColReset);
                System.out.println (ColCyan+"      -      |     "+ColReset);
                System.out.println (ColCyan+"     / \\     |     "+ColReset);
                System.out.println (ColCyan+"             |     "+ColReset);
                System.out.println (ColCyan+"  ---------------  "+ColReset);
                break;
        }
    }

    /* Procedure qui affiche le pendu finale. */
    public void affichePenduFinale(){
        if (gagner()){
            for (char c : Mot) { System.out.print(ColViolet+c+ColReset); }
            System.out.println();
            System.out.println(ColViolet+"\n############################################################\n"+ColReset);
            System.out.println (ColCyan+"      |------|     "+ColReset);
            System.out.println (ColCyan+"             |     "+ColReset);
            System.out.println (ColCyan+"    \\ O /    |     "+ColReset);
            System.out.println (ColCyan+"      |      |     "+ColReset);
            System.out.println (ColCyan+"      -      |     "+ColReset);
            System.out.println (ColCyan+"     / \\     |     "+ColReset);
            System.out.println (ColCyan+"  ---------------  "+ColReset);
            System.out.println(ColViolet+"Superb, vous avez trouve le mot cache.\n"+ColReset);
            System.out.println(ColViolet+"############################################################"+ColReset);
        }

        if (perdu()) {
            System.out.println(ColRouge + "       *           * " + ColReset);
            System.out.println(ColRouge + "         *       *   " + ColReset);
            System.out.println(ColRouge + "           *   *     " + ColReset);
            System.out.println(ColRouge + "             *       " + ColReset);
            System.out.println(ColRouge + "           *   *     " + ColReset);
            System.out.println(ColRouge + "         *       *   " + ColReset);
            System.out.println(ColRouge + "       *           * " + ColReset);
            System.out.println(ColRouge + "           PERDU     " + ColReset);
            System.out.println(ColRouge + "      ---------------" + ColReset);
            System.out.print(ColRouge+"Malheureusement, vous avez perdu. Le mot etait : "+ColReset);
            for (char c : Mot) {
                System.out.print(ColRouge+c+ColReset);
            }
            System.out.println();
        }
        System.out.println(ColJaune+"\t 1 Continuer \n\t"+ColReset+ColVert+" 2 Changer mode de jeu \n\t"+ColReset+ColRouge+" 0 Sortir"+ColReset);
        System.out.print(ColBleu+"Choisie une decision: "+ColReset);
        Decision = sc.nextInt();
        if (Decision == 2) choisieModeJeu();
    }

    /* Procedure qui permet de choisir le mode du jeu. */
    public void choisieModeJeu(){
        do {
            System.out.print(ColJaune+"\t 1 un joueur\n"+ColReset+ColVert+"\t 2 deux joueur\n"+ColReset+ColBleu+"Choisie le mode du jeu: "+ColReset);
            ModeJeu = sc.nextInt();
        } while (ModeJeu < 1 || ModeJeu > 2);
    }

    /* Procedure qui permet de choisir la categorie du mot en mode solo. */
    public void choisieCategorie() {
        do {
            System.out.println(ColJaune+"\t 1 Villes"+ColReset);
            System.out.println(ColVert+"\t 2 Couleurs"+ColReset);
            System.out.println(ColRouge+"\t 3 Sciences"+ColReset);
            System.out.println(ColCyan+"\t 4 langues de programmation"+ColReset);
            System.out.println(ColViolet+"\t 5 Animeaux"+ColReset);
            System.out.print(ColBleu+"choisie un type: "+ColReset);
            choix = sc.nextInt();
        } while (choix < 1 || choix > 5);

    }

    /* Procedure permettante de lire un charctere entree par le joueur, verifier est-ce qu'il est inclut dans 'Mot[]', et le remplacer. */
    public void remplacerChar(){
        System.out.print(ColBleu+"Entree une lettre: "+ColReset);
        String str = sc.next();
        char c = str.toLowerCase().charAt(0); //Variable pour stocker la lettre entree par le joueur.
        boolean estInclue = false; //Variable logique prenant la valeur True si la lettre entree par le joueur est inclut dans Mot[], et False sinon.
        for (int i = 0; i < MotCache.length; i++) {
            if (c == Mot[i] && c != MotCache[i]) {
                MotCache[i] = Mot[i];
                trv++;
                estInclue = true;
            }
        } //Tester 'estInclue' et incrémentation du 'trv'.
        if (estInclue && MotCache.length > trv) { System.out.println(ColViolet+"\nExcellent, bonne reponse."+ColReset); System.out.println(ColBleu+"\n__________________________________________________\n"+ColReset); }
        else if (!estInclue) { System.out.println(ColRouge+"Reponse incorrecte !!"+ColReset); e--; System.out.println(ColBleu+"\n__________________________________________________\n"+ColReset); }
        }

    /* Fonction retournant True si le joueur a trouver tous les lettres cachees, et False sinon. */
    public boolean gagner(){
        boolean g = false;
        if(trv >= MotCache.length) g = true;
        return g;
    }

    /* Fonction retournant True si le joueur a dépasser le nombre maximale des fautes sans trouve le mot cache, et False sinon. */
    public boolean perdu(){
        boolean p = false;
        if (e == 0) { p = true; }
        return p;
    }

    /* Procedure permettante de jouer en mode solo. */
    public void mode1() {
        choisieCategorie();
        initialiserMot();
        System.out.println(ColBleu + "Devinez le mot cache.");
        /* La boucle se déroule tant que le joueur n' a pas gagné ou perdu. */
        do {
            affichePendu();
            afficherMot();
            remplacerChar();
        } while (!gagner() && !perdu());
        affichePenduFinale();
    }

    /* Procedure permettante de jouer en mode du deux joueur. */
    public void mode2(){
            entrerMot();
            /* La boucle se déroule tant que le joueur n' a pas gagné ou perdu. */
            do {
                affichePendu();
                afficherMot();
                remplacerChar();
            } while (!gagner() && !perdu());
            affichePenduFinale();
        }
    }
