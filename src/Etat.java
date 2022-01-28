import java.util.ArrayList;
import java.awt.*;

public class Etat { //les variables/données utiles
	
	public static final int ABSCISSE = 100; //L'abscisse du personnage
	public static final int TOLERANCE = 70; //tolérance pour la détection des points (ou la hitbox des obstacles dans une version plus aboutie)
	
	public static int score = 0; //le score
	public static int timer = 0; //pour que le score représente quelque chose
	
    public static final int AVANCE = 20; //constante de vitesse d'avancement

    public static final int SAUT = 60; //taille saut
    public static final int GRAVITE = 5; //constante de chute
    public static int HAUTEUR = 0; //ordonnée flabby de départ

    public static final int TAILLEIMAGE = 70; //taille de flabby
    public static final int HEIGHT = 300; //Hauteur de l'écran
	public static final int WIDTH = 900; //Largeur de l'écran

	/**
	 * Etat
	 * Constructeur d'Etat
	 */
    public Etat(){
    }

    /**
	 * jump
     * met à jour la hauteur de flabby pour la cas saut
     */
    public void jump(){
    	if(HAUTEUR > -SAUT) { //borne supérieur (avec une petite marge)
    		HAUTEUR -= SAUT;
    	}
    }

	/**
	 * moveDown
	 * Met à jour la hauteur de flabby pour la cas chute
	 * Est appelée par Voler.run()
	 */
	public void moveDown(){
        if (HAUTEUR <= HEIGHT - GRAVITE){ //borne de l'écran
            HAUTEUR += GRAVITE;
        }
    }

	/**
	 * abs
	 * @param a
	 * @return la valeur absolue d'un nombre
	 */
	public double abs(double a) { //elle était pas dans la bibliothèque de base d'eclipse...
    	if(a >= 0) {
    		return a;
    	}else {
    		return -a;
    	}
    }

	/**
	 *testPerdu
	 * @return true si le personnage est suffisamment éloigné du parcours, false sinon
	 * Est appelée par Voler.run()
	 */
	public boolean testPerdu() {
    	ArrayList<Point> lp = new ArrayList<>();
    	lp = Parcours.points; //copie du parcours
    	for(int i = 0; i < lp.size()-1; i++) { //itération sur tout les points
    		double x2 =lp.get(i+1).getX();
    		double x1 =lp.get(i).getX(); //récupération des valeurs importantes pour se simplifier la vie
    		if(x1 < ABSCISSE && x2 > ABSCISSE) { //on "sélectionne" le bon segment (donc le bon duo de points)
    			double y2 = lp.get(i+1).getY();
    			double y1 = lp.get(i).getY(); //récupération des valeurs
    			double orth= y1 + (ABSCISSE - x1)*(y2-y1)/(float)(x2-x1); //calcul de l'ordonnée sur la droite, du point imaginaire d'abscisse ABSCISSE
    			
    			return abs(orth-(HAUTEUR + TAILLEIMAGE/2.0)) >= TOLERANCE; //calcul de l'écart entre ce point et le personnage, vérifie si l'écart inférieur à la tolérance (le calcul est fait dans l'autre sens, mais ça revient au même)
    		}
    	}
    	return false;
    }
}
