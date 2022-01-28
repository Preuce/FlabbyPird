public class Voler extends Thread{
    public Etat etat;
    public Affichage affichage;

    /**
     * Voler
     * Constructeur de Voler
     * @param etat
     * @param affichage
     */
    public Voler(Etat etat, Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
    }

    /**
     * run
     * Thread contrôlant la chute du personnage, ainsi que l'incrémentation du score et la mise à jour de l'affichage (par l'appel de affichage.repaint())
     */
    @Override
    public void run(){
        while(true){
        	if(Etat.HAUTEUR < Etat.HEIGHT - Etat.TAILLEIMAGE) { //on autorise pas le personnage à quitter l'écran
        		etat.moveDown();
        	}
            if(!etat.testPerdu()) { //incrémentation (si nécessaire) du score
                Etat.score++;
            }
            Etat.timer++; //incrémentation du timer
        	affichage.repaint(); //affichage
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
