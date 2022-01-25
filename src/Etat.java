import java.util.ArrayList;
import java.awt.*;

public class Etat { //les variables/données utiles
	
	public static final int ABSCISSE = 100;
	public static final int TOLERANCE = 400;
	
	public static int score = 0;
	
    public static final int AVANCE = 10; //constante de vitesse d'avancement

    public static final int SAUT = 60; //taille saut
    public static final int GRAVITE = 5; //constante de chute
    public static int HAUTEUR = 200; //ordonnée flabby de départ

    public static final int TAILLEIMAGE = 100; //taille de flabby
    public static final int SIZE = 1000; //taille de l'écran

    public Etat(){
    }

    /**jump
     * met à jour la hauteur de flabby pour la cas saut
     */
    public void jump(){
    	if(HAUTEUR > -SAUT) {
    		HAUTEUR -= SAUT;
    	}
    }

	/**moveDown
	 * met à jour la hauteur de flabby pour la cas chute
	 */
	public void moveDown(){
        if (HAUTEUR <= SIZE - GRAVITE){
            HAUTEUR += GRAVITE;
        }
    }
    
    public int getHauteur() {
    	return HAUTEUR;
    }

	/**
	 *abs
	 * @param a
	 * @return la valeur absolue d'un nombre
	 */
	public double abs(double a) {
    	if(a >= 0) {
    		return a;
    	}else {
    		return -a;
    	}
    }

	/**
	 *testPerdu
	 * @return true si la partie est perdue, false sinon
	 */
	public boolean testPerdu() {
    	ArrayList<Point> lp = new ArrayList<>();
    	lp = Parcours.points;
    	for(int i = 0; i < lp.size()-1; i++) { //itération sur tout les points
    		double x2 =lp.get(i+1).getX();
    		double x1 =lp.get(i).getX();
    		if(x1 < ABSCISSE && x2 > ABSCISSE) {
    			double y2 = lp.get(i+1).getY();
    			double y1 = lp.get(i).getY();
    			double orth= y1 + (ABSCISSE - x1)*(y2-y1)/(float)(x2-x1);
    			
    			return abs(orth-(HAUTEUR + TAILLEIMAGE/2.0)) >= TOLERANCE;
    		}
    	}
    	return false;
    }
}
