package lt.bit.mainTask;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


class Zmogus {
    private String vardas;
    private int amzius;
    private Gender gender;
    private List<Daiktas> daiktai;


    //public List<Daiktas> getDaiktai() {
//        return daiktai;
//    }

    public String getVardas() {
        return vardas;
    }

    private static int count;

    public static int getCount() {
        return count;
    }

    private static AtomicInteger nextId = new AtomicInteger();
    private int id;


    Zmogus() {
        count++;
        id = nextId.incrementAndGet();
    }

    Zmogus(String vardas, int amzius, Gender gender) {
        this();
        this.vardas = vardas;
        this.amzius = amzius;
        this.gender = gender;


    }

    public void aging() {
        amzius++;
    }

    public int getAmzius() {
        return amzius;
    }

//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender){
//        this.gender = gender;
//    }

    public int getId() {
        return id;
    }

    public static AtomicInteger getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return "Zmogus{" +
                "vardas='" + vardas + '\'' +
                ", amzius=" + amzius +
                ", gender=" + gender +
                //", daiktai=" + daiktai +
                ", id=" + id +
                '}';
    }
}
