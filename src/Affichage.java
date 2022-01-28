import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Affichage extends JPanel{
	public static BufferedImage Flabby = null;
	public static ArrayList<BufferedImage> Background = new ArrayList<>();
	public static int indice = 0;

	/**
	 * Affichage
	 * Constructeur d'Affichage
	 */
	public Affichage() {
		setPreferredSize(new Dimension(Etat.WIDTH, Etat.HEIGHT));

		try {
			Flabby = ImageIO.read(new File("src/BetterFloppa.png")); //image de floppappy
		} catch (IOException ex) {
			System.out.println("Fichier manquant"); //absence de l'image
		}

		for(int i = 0; i < 49; i ++){
			String pathname = "src/Background/00" + (i+1) + ".jpg";
			try {
				Background.add(ImageIO.read(new File(pathname))); //background
			} catch (IOException ex) {
				System.out.println("Fichier manquant : " + pathname); //absence de l'image
			}
		}
	}

	/**
	 * paint
	 * Gère la mise à jour de l'affichage
	 * @param g
	 * Est appelée par Voler.run() et Control.mouseclicked()
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g); //nécessaire pour update l'affichage
		g.drawImage(Background.get(indice), 0, 0, Etat.WIDTH, Etat.HEIGHT, this); //affichage de l'arrière-plan
		indice = (indice+1)%49; //les images forment un boucle, on revient à l'indice 0 quand la boucle est finie

	    g.drawImage(Flabby, Etat.ABSCISSE, Etat.HAUTEUR, Etat.TAILLEIMAGE, Etat.TAILLEIMAGE, this); //dessin de l'image

		g.setFont(new Font("FontyBirb", Font.BOLD, 32)); //Police pour l'affichage du score
	    g.drawString(Etat.score + " / " + Etat.timer + " (" + (100*(Etat.score+1)/(Etat.timer+1)) + "%)", Etat.WIDTH/2 - 70 /*Pas très propre, mais relativement centré*/, 32);

		ArrayList<Point> l = Parcours.points;

		for(int i = 0; i < l.size()-1; i++){ //affichage du parcours
			//g.setColor(Color.BLACK);
			g.drawLine(l.get(i).x, l.get(i).y, l.get(i+1).x, l.get(i+1).y);

			//pour afficher les lignes de tolérances, ont servies au débogage
			/*g.setColor(Color.RED);
			g.drawLine(l.get(i).x, l.get(i).y-Etat.TOLERANCE, l.get(i+1).x, l.get(i+1).y-Etat.TOLERANCE);
			g.drawLine(l.get(i).x, l.get(i).y+Etat.TOLERANCE, l.get(i+1).x, l.get(i+1).y+Etat.TOLERANCE);*/
		}
	}
}
