import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Control extends JPanel implements MouseListener { //les action alistener, l'input utilisateur
    public Etat etat; //contient les données du jeu
    public Affichage affichage; //affichage à mettre à jour

    public Control(Etat etat, Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
        affichage.addMouseListener(this);
    }

    /**mouseClicked
     * Actions à réaliser lors d'un clic souris
     * @param e un clic souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //Action on-click
    	this.etat.jump();
        if(!etat.testPerdu()) {
            Etat.score++;
        }
        affichage.repaint(); //on peut définir la zone à update pour de meilleurs perf, peut être le faire un peu plus tard
    	
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
