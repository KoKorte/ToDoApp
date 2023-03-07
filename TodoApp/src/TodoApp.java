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
            System.out.println("Valitse toiminto: ");
            System.out.println("1. Luettelon luominen");
            System.out.println("2. Luettelon tarkasteleminen");
            System.out.println("3. Luettelon poistaminen");
            System.out.println("4. Sovelluksen lopettaminen");

            int valinta = scanner.nextInt();
            scanner.nextLine();

            if (valinta == 1) {
System.out.println("Syötä luettelon otsikko: ");
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
            System.out.println("Luotu uusi todo-luettelo: " + otsikko);
        } else {
            System.out.println("Luettelo " + otsikko + " on jo olemassa.");
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
            System.out.println("Todo-luettelo " + otsikko + ":");

            while ((rivi = lukija.readLine()) != null) {
                System.out.println(rivi);
            }

            lukija.close();
        } else {
            System.out.println("Luetteloa " + otsikko + " ei löytynyt.");
        }
    } catch (IOException e) {
        System.out.println("Virhe lukiessa tiedostoa: " + e.getMessage());
    }
}

public static void poistaLuettelo(String otsikko) {
    File tiedosto = new File(otsikko + ".txt");

    if (tiedosto.exists()) {
        if (tiedosto.delete()) {
            System.out.println("Todo-luettelo " + otsikko + " poistettu.");
        } else {
            System.out.println("Virhe poistettaessa 1tiedostoa.");
        }
    } else {
        System.out.println("Luetteloa " + otsikko + " ei löytynyt.");
    }
}
}