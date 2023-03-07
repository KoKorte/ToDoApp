import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Mikä on valintasi?: ");
            System.out.println("1. Tehtävän luonti");
            System.out.println("2. Tehtävien tarkistaminen");
            System.out.println("3. Tehtävän poistaminen");
            System.out.println("4. Sulje sovellus");

            int valinta = scanner.nextInt();
            scanner.nextLine();

            if (valinta == 1) {
System.out.println("Listaa tehtävä: ");
            String otsikko = scanner.nextLine();
            luoLuettelo(otsikko);
        } else if (valinta == 2) {
            System.out.println("Syötä luettelon otsikko: ");
            String otsikko = scanner.nextLine();
            naytaLuettelo(otsikko);
        } else if (valinta == 3) {
            System.out.println("Syötä luettelon otsikko: ");
            String otsikko = scanner.nextLine();
            poistaLuettelo(otsikko);
        } else if (valinta == 4) {
            break;
        } else {
            System.out.println("Virheellinen valinta, yritä uudelleen.");
        }
    }

    scanner.close();
}

public static void luoLuettelo(String otsikko) {
    try {
        File tiedosto = new File(otsikko + ".txt");

        if (tiedosto.createNewFile()) {
            System.out.println("Luotu uusi todo-lista: " + otsikko);
        } else {
            System.out.println("Tehtävä " + otsikko + " on jo olemassa.");
        }
    } catch (IOException e) {
        System.out.println("Virhe luodessa tiedostoa: " + e.getMessage());
    }
}

public static void naytaLuettelo(String otsikko) {
    try {
        File tiedosto = new File(otsikko + ".txt");

        if (tiedosto.exists()) {
            BufferedReader lukija = new BufferedReader(new FileReader(tiedosto));
            String rivi = null;
            System.out.println("Todo-lista " + otsikko + ":");

            while ((rivi = lukija.readLine()) != null) {
                System.out.println(rivi);
            }

            lukija.close();
        } else {
            System.out.println("Tehtävää " + otsikko + " ei löytynyt.");
        }
    } catch (IOException e) {
        System.out.println("Virhe listaa lukiessa: " + e.getMessage());
    }
}

public static void poistaLuettelo(String otsikko) {
    File tiedosto = new File(otsikko + ".txt");

    if (tiedosto.exists()) {
        if (tiedosto.delete()) {
            System.out.println("Todo-lista " + otsikko + " poistettu.");
        } else {
            System.out.println("Virhe poistettaessa listaa.");
        }
    } else {
        System.out.println("Tehtävää " + otsikko + " ei löytynyt.");
    }
}
}
