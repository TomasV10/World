package lt.bit.mainTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static lt.bit.mainTask.Gender.Female;
import static lt.bit.mainTask.Gender.Male;

class Pasaulis {
    private List<Zmogus> zmones = new ArrayList<>();
    private final Random random;


    Pasaulis() {
        random = new Random();
    }

    void generateListOfPeople(int count, int maxAge) {   //metodas sukuriantas tokį žmonių kiekį, kiek yra nurodoma count parametre
        for (int i = 0; i < count; i++) {
            zmones.add(generatePerson(maxAge));
        }
    }

    void listAllPeople() {      //spausdina žmonių listą
//        zmones.forEach(x -> System.out.println(x));
//        ---------------------------------------------------------------
//        for (Zmogus x : zmones) {
//            System.out.println(x);
//        }
//        --------------------------------------------------------------
        zmones.forEach(System.out::println);
    }

    void removePeopleOverAge(int age) {     //nukillina žmones kurių amžius yra nuo įvesto "age" iki "maxAge"

        List<Zmogus> atrinktiZmones = getPeopleAccordingAge(age, 101); //atrenkami žmonės ir sudedami į listą, kurie ir bus nukillinti,

//        int amziuSuma = zmones.stream()     //skaiciuoja amziu suma
//                .filter(zmogus -> zmogus.getAmzius() >= age)
//                .filter(zmogus ->zmogus.getVardas().startsWith("L"))     //atfiltruoja zmones pagal amziu ir pagal pirma vardo raide
//                .map(Zmogus::getAmzius)
//                .reduce(0, (a, b) -> a+b);

//                .sorted(Comparator.comparing(Zmogus::getAmzius).reversed())
//                .collect(Collectors.toList());
//        System.out.println(amziuSuma);

        zmones.removeAll(atrinktiZmones); //nukillinami žmonės.
    }

    void babies() {
        int count = resolveBabiesCount();               //pridedami vaikai
        generateListOfPeople(count, 1);
    }

    void aging() {
        zmones.forEach(Zmogus::aging);
    } //sendinami žmonės

    void bombing() {            //nukilina 30% viso listo žmonių
        int peopleToKillCount = getPeopleToKillCount();

        List<Zmogus> peopleToKill = getPeopleToKill(peopleToKillCount);

//        List<Zmogus> peopleToKill = zmones.stream().limit(peopleToKillCount).collect(Collectors.toList());
        zmones.removeAll(peopleToKill);
    }

    private int getPeopleToKillCount() {            //paskaičiuojamas listo trečdalis
        int totalPeopleCount = zmones.size();
        return totalPeopleCount / 3;
    }

    private List<Zmogus> getPeopleToKill(int peopleToKillCount) {  //šalinamas trečdalis žmonių iš listo.
        List<Zmogus> peopleToKill = new ArrayList<>();
        for (int i = 0; i < peopleToKillCount; i++) {
            peopleToKill.add(zmones.get(i));
        }
        return peopleToKill;
    }

    void trecdalisVirsPemMetu() {
        List<Zmogus> zmoguses = zmones.stream()              //atflitruojami žmonės iš listo kuriems yra virš 50metų
                .filter(zmogus -> zmogus.getAmzius() >= 50)
                .collect(Collectors.toList());
        int peopleToKillCount = getPeopleToKillCount();     //trečdalis viso listo žmonių
        List<Zmogus>zmogTrec = new ArrayList<>();           //sukuriamas listas, kuriame yra talpinamas tas trečdalis žmonių
        int adjustedCount = zmoguses.size() < peopleToKillCount
                ? zmoguses.size()
                : peopleToKillCount;
        for(int i = 0; i < adjustedCount; i++){
            zmogTrec.add(zmoguses.get(i));
        }
        zmones.removeAll(zmogTrec);



    }

    List<Zmogus> getZmones() {
        return zmones;
    }

    private Zmogus generatePerson(int maxAge) {
        Gender gender = generateGender();
        String name = generateNameAccordingGender(gender);
        int age = generateAge(maxAge);
        return new Zmogus(name, age, gender);
    }

    private int generateAge(int maxAge) {
        return random.nextInt(maxAge) + 1;
    }

    private String generateNameAccordingGender(Gender gender) {
        return gender == Male
                ? Fixtures.MAN_NAMES.get(random.nextInt(50))
                : Fixtures.WOMAN_NAMES.get(random.nextInt(50));
    }

    private Gender generateGender() {
        return random.nextBoolean() ? Male : Female;
    }

    private List<Zmogus> getPeopleAccordingAge(int age, int maxAge) {
        return zmones.stream()
                .filter(zmogus -> zmogus.getAmzius() >= age)
                .filter(zmogus -> zmogus.getAmzius() <= maxAge)
                .collect(Collectors.toList());
    }

    private int resolveBabiesCount() {
        int parentsCount = getPeopleAccordingAge(20, 38).size();  //nustatoma, jog vaikų gali susilaukti žmonės nuo 20 iki 38 metų.
        return (int) (parentsCount * 0.1);
    }
}



//static klases laukai
//objektus galima kurt tik pagal klases kurios nera abstrakcios.
//final klase skirta kad butu paskutine, vaiku negali turet.
// class A {
//    final int a = 10;
//    {
//        a = 10;
//    }
//
//    A(){
//        a = 12;
//    }
//} reiksmiu priskyrimas trim budai naudojant final.


// class C {
//    static int a = 10;
//    {
//        a = 11;    //kai kuriame nauja objekta new
//    }
// }

//Reiksmes kvietimas C.a

//Kuriant nauja objekta gaunama nauja reiksme 11


//final metodas - negali but overridintas

//klases ekvivalentai Integer, (klases wraperiai- apvalkalai),
//Integer i1; i1 = new Integer(100); i1 + 12 = 112;
//Jeigu reikia Integer listo naudojamas butent Integer

//AtomiIteger - veiksmai nedalomi.


