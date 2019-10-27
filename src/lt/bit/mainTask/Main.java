package lt.bit.mainTask;

public class Main {

    public static void main(String[] args) {
        Pasaulis pasaulis = new Pasaulis();
        for (int i = 0; i < 50; i++){
            pasaulis.generateListOfPeople(100, 100);
            pasaulis.aging();
            pasaulis.removePeopleOverAge(75);
            pasaulis.babies();
        }
        //pasaulis.trecdalisVirsPemMetu();
        //pasaulis.bombing();
        pasaulis.listAllPeople();
        System.out.println("Viso žmonių gyvena " + pasaulis.getZmones().size());
    }
}
