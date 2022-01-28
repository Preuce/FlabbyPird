
import java.awt.*;
import java.util.ArrayList;

public class Parcours  extends Thread {
    public static ArrayList<Point> points = new ArrayList<>(); //liste des points du parcours
    public int lastpoint = 0; //l'abscisse du point le plus avancé du parcours

    public final float PENTEMAX = Etat.AVANCE/(float)Etat.GRAVITE;  //Pente descendante
    public final float PENTEMIN = Etat.AVANCE/(float)(-5*10*Etat.SAUT); //pente ascendante, valeurs arbitraires
    public final double xmax = Etat.HEIGHT*PENTEMAX;   //borne supérieure pour l'écart en x entre 2 points

    /**
     * Parcours
     * Constructeur de Parcours
     */
    public Parcours(){
        do{
            //on commence par générer une valeur en y contenue dans l'écran
        	int ry = (int) (50 + Math.random()*(Etat.HEIGHT - 50)); //on limite légèrement où le point peut apparaître
            double minx;

            if(ry > Etat.HAUTEUR) { //cas d'une descente
                minx = (ry - Etat.HAUTEUR)*PENTEMAX;
            }else{ //cas d'une montée
                minx = (ry - Etat.HAUTEUR)*PENTEMIN;
            }
            lastpoint += (int) (minx + Math.random()*(xmax/2 - minx)); //normalement on aurait pas à diviser par deux, mais ça donne du peps au parcours

            points.add(new Point(lastpoint, ry)); 
        }while(lastpoint < Etat.WIDTH); //tant qu'on ne sort pas de l'écran
    }

    /**
     * majParcours
     * Met à jour le parcours en ne gardant que les points pertinents pour l'affichage, et en en générant des nouveaux si nécessaires
     */
    public void majParcours() {
    	ArrayList<Point> res = new ArrayList<>();
    	for(Point p : points) {
    		p.x -= Etat.AVANCE; //mise à jour des abscisses
    		if(p.x >= -Etat.WIDTH*PENTEMAX) { //ajout uniquement si le point est pertinent
    			res.add(p);
    		}
    	}
    	this.lastpoint -= Etat.AVANCE; //mise à jour du point le plus avancé
    	
    	if(points.get(points.size()-1).x < Etat.WIDTH) { //éventuellement, génération de nouveau point, même code que pour le constructeur
            //on commence par générer une valeur en y contenue dans l'écran
            int ry = (int) (50 + Math.random()*(Etat.HEIGHT - 50));
            double minx;

            if(ry > Etat.HAUTEUR) { //cas d'une descente
                minx = (ry - Etat.HAUTEUR)*PENTEMAX;
            }else{ //cas d'une montée
                minx = (ry - Etat.HAUTEUR)*PENTEMIN;
            }
            lastpoint += (int) (minx + Math.random()*(xmax/2 - minx));

            res.add(new Point(lastpoint, ry));
    	}
    	points = res;
    }
}
