import javax.swing.JFrame;

public class Main {
	public static Etat etat = new Etat();
	public static Parcours parcours = new Parcours(etat);
	public static Affichage affichage = new Affichage(etat, parcours);
	public static Control control = new Control(etat, affichage);
	public static Voler voler = new Voler(etat, affichage);
	
	public static Avancer avancer = new Avancer(parcours);
	//c'est très moche tout ça...

	public static void main(String [] args) {
		etat.affichage = affichage;
		JFrame f =  new JFrame("Flabby Pird");
		f.add(affichage);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		voler.start();
		avancer.start();

	}
	
}
