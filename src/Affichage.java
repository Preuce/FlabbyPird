import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Affichage extends JPanel{
	//public Parcours parcours;

	public Affichage(/*Parcours parcours*/) {
		setPreferredSize(new Dimension(Etat.SIZE, Etat.SIZE));
		//this.parcours = parcours;

	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		//alternativement on peut mettre drawOval ou fillOval
		BufferedImage im = null; //buffer
		try {                
	          im = ImageIO.read(new File("src/BetterFloppa.png")); //image de floppappy
	       } catch (IOException ex) {
	    	   System.out.println("Fichier manquant"); //absence de l'image
	       }
		//System.out.println(Etat.HAUTEUR);
		super.paintComponent(g); //nécessaire pour update l'affichage
	    g.drawImage(im, Etat.ABSCISSE, Etat.HAUTEUR, Etat.TAILLEIMAGE, Etat.TAILLEIMAGE, this); //dessin de l'image
	    g.drawString(String.valueOf(Etat.score), 10, 10);
		ArrayList<Point> l = Parcours.points;
		
		for(int i = 0; i < l.size()-1; i++){
			g.setColor(Color.BLACK);
			g.drawLine(l.get(i).x, l.get(i).y, l.get(i+1).x, l.get(i+1).y);
			g.setColor(Color.RED);
			g.drawLine(l.get(i).x, l.get(i).y-Etat.TOLERANCE, l.get(i+1).x, l.get(i+1).y-Etat.TOLERANCE);
			g.drawLine(l.get(i).x, l.get(i).y+Etat.TOLERANCE, l.get(i+1).x, l.get(i+1).y+Etat.TOLERANCE);
		}
	}
}
