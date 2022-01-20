import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Affichage extends JPanel{
	public Parcours parcours;
	public Etat etat; //contient les données du jeu

	public Affichage(Etat etat, Parcours parcours) {
		setPreferredSize(new Dimension(etat.SIZE, etat.SIZE));
		this.parcours = parcours;
		this.etat = etat;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO ICI
		//super.paint(g);
		//alternativement on peut mettre drawOval ou fillOval
		BufferedImage im = null; //buffer
		try {                
	          im = ImageIO.read(new File("src/BetterFloppa.png")); //image de floppappy
	       } catch (IOException ex) {
	    	   System.out.println("Fichier manquant"); //absence de l'image
	       }
		super.paintComponent(g); //nécessaire pour update l'affichage
	    g.drawImage(im, 100 /*l'abscisse*/, etat.HAUTEUR, etat.TAILLEIMAGE, etat.TAILLEIMAGE, this); //dessin de l'image
	    
		ArrayList<Point> l = parcours.points;
		
		for(int i = 0; i < l.size()-1; i++){ //pb here
			g.drawLine(l.get(i).x, l.get(i).y, l.get(i+1).x, l.get(i+1).y);
		}
	}
}