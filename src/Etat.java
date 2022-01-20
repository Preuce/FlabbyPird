public class Etat { //les variables/données utiles
    public Affichage affichage;
    

    public final int SAUT = 60; //taille saut
    public final int GRAVITE = 3; //constante de chute
    public static int HAUTEUR = 200; //ordonnée flabby

    public final int TAILLEIMAGE = 100;
    public final int SIZE = 1000; //taille de l'écran

    public Etat(){
    	
    }

    /**jump
     * met à jour la hauteur de flabby
     */
    public void jump(){
    	if(this.HAUTEUR > -SAUT) {
    		HAUTEUR -= SAUT;
    	}
    }

    public void moveDown(){
        if (HAUTEUR <= SIZE - GRAVITE){
            HAUTEUR += GRAVITE;
        }
        
    }
    
    public int getHauteur() {
    	return this.HAUTEUR;
    }
}
