public class Voler extends Thread{
    public Etat etat;
    public Affichage affichage;

    public Voler(Etat etat, Affichage affichage){
        this.etat = etat;
        this.affichage = affichage;
    }

    @Override
    public void run(){
        while(true){
        	if(this.etat.getHauteur() < this.etat.SIZE - etat.TAILLEIMAGE) {
        		etat.moveDown();
        	}
        	affichage.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
