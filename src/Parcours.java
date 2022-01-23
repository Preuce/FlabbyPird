
import java.awt.*;
import java.util.ArrayList;

public class Parcours  extends Thread {
    public ArrayList<Point> points = new ArrayList<>();
    public int lastpoint = 0;

    public final float PENTEMAX = (float) Etat.AVANCE/Etat.GRAVITE;;  //Pente descendante
    public final float PENTEMIN = (float) Etat.AVANCE/(-5* Etat.SAUT);
    public final double xmax = Etat.SIZE*PENTEMAX;   //borne supérieure pour l'écart en x entre 2 points

    public Parcours(){
        do{
            //on commence par générer une valeur en y contenue dans l'écran
        	int ry = (int) (Math.random()*(Etat.SIZE));
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
        System.out.println(points);
    }

    /*
     * Renvoie un tableau des points encore dans l'image
     */
    public ArrayList<Point> getPoints(){
        ArrayList<Point> res = new ArrayList<>(); //résultat
        for (Point point : this.points) { //parcours des points
            int absolu = point.x - lastpoint; //test si le point est dans l'écran
            if (absolu >= 0) {
                res.add(point);
            }
        }
        return res;
    }

    public int getScore(){
        return this.lastpoint;
    }

    public void setScore(int n){
        this.lastpoint = n;
    }
    
    public void majParcours() {
    	ArrayList<Point> res = new ArrayList<Point>();
    	for(Point p : this.points) {
    		p.x -= Etat.AVANCE;
    		if(p.x >= -Etat.SIZE*PENTEMAX) {
    			res.add(p);
    		}
    	}
    	this.lastpoint -= Etat.AVANCE;
    	
    	if(points.get(points.size()-1).x < Etat.SIZE) {
            //on commence par générer une valeur en y contenue dans l'écran
            int ry = (int) (Math.random()*(Etat.SIZE));
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
