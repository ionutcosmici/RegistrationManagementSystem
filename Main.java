package Homework.P1_RegistrationManagementSystem;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void showOptions() {
        for (Options options : Options.values()) {
            System.out.println(options.name() + options.getDetails());
        }
    }

    public static void main(String[] args) {

        Guest guest = new Guest();

   /*       GuestsList list = new GuestsList(3);
            guest = new Guest("Ionut", "Cosmici", "ionutcosmici@gmail.com", "0741683278");
            list.adminAdd(guest);
            guest = new Guest("Andra", "Dumitrache", "andradumitrache@yahoo.com", "0741113311");
            list.adminAdd(guest);
            guest = new Guest("Codrin", "Sesovici", "codrinsesovici@hotmail.com", "0742306447");
            list.adminAdd(guest);       */

        boolean start = true;
        String chosenOption = "";

        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        int noSeats = scanner.nextInt();
        GuestsList list = new GuestsList(noSeats);

        System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");

        while (start) {
            chosenOption = scanner.next();
            if (chosenOption.equals("help")) {
                showOptions();
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("add")) {
                list.add();
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("check")) {
                list.checkGuest();
                guest = list.getCheckGuest(guest);
                if(list.check(guest)){
                    System.out.println("Persoana pe care ati verificat-o este inscrisa la eveniment.");
                } else {
                    System.out.println("Persoana pe care ati verificat-o NU este inscrisa la eveniment.");
                }
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("remove")) {
                System.out.println("Se sterge o persoana existenta din lista…");
                list.checkGuest();
                guest = list.getCheckGuest();
                list.removeGuest(guest);
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("update")) {
                list.checkGuest();
                guest = list.getCheckGuest(guest);
                list.updateGuest(guest);
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("guests")) {
                list.getParticipantsList();
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("waitlist")) {
                list.getPendingList();
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("available")) {
                System.out.println("Numarul de locuri ramase: " + list.getAvailableSeats());
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("guests_no")) {
                System.out.println("Numarul de participanti: " + list.getParticiantsNo());
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("waitlist_no")) {
                System.out.println("Dimensiunea listei de asteptare: " + list.getPendingNo());
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("subscribe_no")) {
                System.out.println("Numarul total de persoane: " + list.getTotalCrowdNo());
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("search")) {
                System.out.println("Introduceti campul dupa care doriti sa se faca cautarea (Ex: Nume, Prenume, E-mail, Nr. Telefon):");
                String value = scanner.next();
                list.search(value);
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            } else if (chosenOption.equals("quit")) {
                System.out.println("Aplicatia se inchide. La revedere!");
                start = false;
            }
        }
    }
}
