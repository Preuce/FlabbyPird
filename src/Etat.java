public class Etat { //les variables/données utiles

    public static final int AVANCE = 10; //constante de vitesse d'avancement

    public static final int SAUT = 60; //taille saut
    public static final int GRAVITE = 5; //constante de chute
    public static int HAUTEUR = 200; //ordonnée flabby de départ

    public static final int TAILLEIMAGE = 100; //taille de flabby
    public static final int SIZE = 1000; //taille de l'écran

    public Etat(){
    }

    /**jump
     * met à jour la hauteur de flabby
     */
    public void jump(){
    	if(HAUTEUR > -SAUT) {
    		HAUTEUR -= SAUT;
    	}
    }

    public void moveDown(){
        if (HAUTEUR <= SIZE - GRAVITE){
            HAUTEUR += GRAVITE;
        }
        
    }
    
    public int getHauteur() {
    	return HAUTEUR;
    }
}
