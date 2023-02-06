package main;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Olio-ohjelmointi viikko 3
 * Veikko Vanninen
 */
public class App {
    /**
     * @param args
     */
    public static void main( String[] args ) {
        Scanner selection = new Scanner(System.in);

        Zoo newZoo = null;

        Animal newAnimal = null;

        ArrayList<Animal> zooAnimals = new ArrayList<>();

        System.out.println("Anna eläintarhalle nimi:");
            String zooName = selection.nextLine();
            newZoo = new Zoo(zooName);


        boolean exit = false;
        while(!exit) {
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            if(selection.hasNext()) {
                int i = 0;
                String stringInput = selection.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Mikä laji?");
                        String species = selection.nextLine();
                        System.out.println("Anna eläimen nimi:");
                        String animalName = selection.nextLine();
                        System.out.println("Anna eläimen ikä:");
                        String ageString = selection.nextLine();
                        int age = Integer.parseInt(ageString);

                        newAnimal = new Animal(species, animalName, age);
                        zooAnimals.add(newAnimal);
                        break;
                    case 2:
                        System.out.println(newZoo.getName() + " pitää sisällään seuraavat eläimet:");
                        for (Animal animal : zooAnimals) {
                            animal.printSpecs();
                        }
                        break;
                    case 3:
                        System.out.println("Kuinka monta kierrosta?");
                        String lapString = selection.nextLine();
                        int lap = Integer.parseInt(lapString);

                        for (Animal animal : zooAnimals) {
                            for (int y = 0; y < lap; y++) {
                                    animal.runAnimals();
                            } 
                        }                 
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }

        }

    }
}
