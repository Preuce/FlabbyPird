public class Avancer extends Thread{
    public Parcours parcours;

    public Avancer(Parcours parcours){
        this.parcours = parcours;
    }

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
