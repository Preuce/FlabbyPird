
import java.awt.*;
import java.util.ArrayList;

public class Parcours  extends Thread {
    public ArrayList<Point> points = new ArrayList<>();
    public Etat etat;
    public int lastpoint = 0;
    public final int AVANCE = 5;
    public final int PENTEMAX;  //doit dépendre d'AVANCE et de GRAVITE
    
    public Parcours(Etat etat){
        this.etat = etat;
        this.PENTEMAX = AVANCE/etat.GRAVITE;
        
        int ly;

        do{
        	int ry = (int) (Math.random()*(etat.SIZE));
        	lastpoint += (int) (50 + Math.random()*(200 - 50));
            //gérer la pente max (plus tard)
            points.add(new Point(lastpoint, ry)); 
        }while(lastpoint < (etat.SIZE));
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
    		p.x -= AVANCE;
    		if(p.x >= -200 /*l'ecart max avec les voisins, il faudra surement le modififer*/) {
    			res.add(p);
    		}
    	}
    	this.lastpoint -= AVANCE;
    	
    	if(points.get(points.size()-1).x < etat.SIZE) {
    		lastpoint += (int) (50 + Math.random()*(200 - 50));
            //gérer la pente max (plus tard)
            res.add(new Point(lastpoint, (int) (Math.random() * (etat.SIZE))));
    	}
    	this.points = res;
    }
}
