
import java.awt.*;
import java.util.ArrayList;

public class Parcours  extends Thread {
    public static ArrayList<Point> points = new ArrayList<>();
    public int lastpoint = 0;

    public final float PENTEMAX = Etat.AVANCE/(float)Etat.GRAVITE;  //Pente descendante
    public final float PENTEMIN = Etat.AVANCE/(float)(-5*10*Etat.SAUT); //pente ascendante, valeurs arbitraires
    public final double xmax = Etat.SIZE*PENTEMAX;   //borne supérieure pour l'écart en x entre 2 points

    public Parcours(){
        do{
            //on commence par générer une valeur en y contenue dans l'écran
        	int ry = (int) (100 + Math.random()*(Etat.SIZE/2 - 100));
            double minx;

            if(ry > Etat.HAUTEUR) { //cas d'une descente
                minx = (ry - Etat.HAUTEUR)*PENTEMAX;
            }else{ //cas d'une montée
                minx = (ry - Etat.HAUTEUR)*PENTEMIN;
            }
            lastpoint += (int) (minx + Math.random()*(xmax - minx)); //TODO

            //gérer la pente max (plus tard)
            points.add(new Point(lastpoint, ry)); 
        }while(lastpoint < Etat.SIZE);
    }

    /*
     * Renvoie un tableau des points encore dans l'image
     */
    public ArrayList<Point> getPoints(){
        return points;
    }

    public int getScore(){
        return this.lastpoint;
    }

    public void setScore(int n){
        this.lastpoint = n;
    }
    
    public void majParcours() {
    	ArrayList<Point> res = new ArrayList<Point>();
    	for(Point p : points) {
    		p.x -= Etat.AVANCE;
    		if(p.x >= -Etat.SIZE*PENTEMAX) {
    			res.add(p);
    		}
    	}
    	this.lastpoint -= Etat.AVANCE;
    	
    	if(points.get(points.size()-1).x < Etat.SIZE) {
            //on commence par générer une valeur en y contenue dans l'écran
            int ry = (int) (Math.random()*Etat.SIZE);
            double minx;

            if(ry > Etat.HAUTEUR) { //cas d'une descente
                minx = (ry - Etat.HAUTEUR)*PENTEMAX;
            }else{ //cas d'une montée
                minx = (ry - Etat.HAUTEUR)*PENTEMIN;
            }
            lastpoint += (int) (minx + Math.random()*(xmax - minx)); //TODO

            res.add(new Point(lastpoint, ry));
    	}
    	this.points = res;
    }
}
