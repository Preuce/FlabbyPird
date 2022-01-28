public class Avancer extends Thread{
    public Parcours parcours;

    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }

    /**
     * run
     * Thread contrôlant l'avancer du parcours
     */
    @Override
    public void run(){
        while(true) {
            parcours.majParcours();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
