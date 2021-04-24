package Homework.P1_RegistrationManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {

    static Scanner sc = new Scanner(System.in);

    private int noSeats;
    private int noPending;
    private int orderNo;
    public ArrayList<Guest> participantsList = new ArrayList<Guest>(noSeats);
    public ArrayList<Guest> pendingList = new ArrayList<Guest>();

    public GuestsList() {
    }

    public GuestsList(int noSeats) {
        this.noSeats = noSeats;
    }

    public void checkGuest() {
        System.out.println("Alege modul de autentificare, tastand: \n"
                + "\t1. Nume si prenume \n"
                + "\t2. E-mail \n"
                + "\t3. Numar de telefon (format \"+40733386463\") \n");
        Guest.comparisonCase = sc.nextInt();
    }

    public Guest getCheckGuest() {
        Guest guest = new Guest();
        if (Guest.comparisonCase == 1) {
            System.out.println("Introduceti prenumele: ");
            String firstName = sc.next();
            System.out.println("Introduceti numele de familie:");
            String lastName = sc.next();
            guest = new Guest(firstName, lastName, "", "");
        } else if (Guest.comparisonCase == 2) {
            System.out.println("Introduceti e-mail:");
            String email = sc.next();
            guest = new Guest("", "", email, "");
        } else if (Guest.comparisonCase == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
            String phoneNumber = sc.next();
            guest = new Guest("", "", "", phoneNumber);
        }
        return guest;
    }

    public Guest getCheckGuest(Guest guest) {
        if (Guest.comparisonCase == 1) {
            System.out.println("Introduceti prenumele:");
            String firstName = sc.next();
            System.out.println("Introduceti numele de familie:");
            String lastName = sc.next();
            guest = new Guest(firstName, lastName, "", "");
        } else if (Guest.comparisonCase == 2) {
            System.out.println("Introduceti e-mail:");
            String email = sc.next();
            guest = new Guest("", "", email, "");
        } else if (Guest.comparisonCase == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
            String phoneNumber = sc.next();
            guest = new Guest("", "", "", phoneNumber);
        } else return guest;
        return guest;
    }

    public int add() {
        System.out.println("Se adauga o noua persoana…");
        System.out.println("Introduceti prenumele:");
        String firstName = sc.next();
        System.out.println("Introduceti numele de familie: ");
        String lastName = sc.next();
        System.out.println("Introduceti adresa de e-mail: ");
        String email = sc.next();
        System.out.println("Introduceti numarul de telefon (format \"+40733386463\"): ");
        String phoneNumber = sc.next();
        Guest guest = new Guest(firstName, lastName, email, phoneNumber);

        if (!check(guest)) {
            if (noSeats > 0) {
                participantsList.add(guest);
                System.out.println("[" + guest.getLastName() + " " + guest.getFirstName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n");
                noSeats--;
                return 0;
            } else {
                pendingList.add(guest);
                orderNo++;
                noPending++;
                System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
                        orderNo + "." + " Te vom notifica daca un loc devine disponibil. O zi placuta!");
                return orderNo;
            }
        } else {
            System.out.println("Esti deja inscris pe lista!");
            return -1;
        }
    }

    public void adminAdd(Guest guest) {

        if (!check(guest)) {
            if (noSeats > 0) {
                participantsList.add(guest);
                noSeats--;
            } else {
                pendingList.add(guest);
                orderNo++;
            }
        } else {
            System.out.println("Esti deja inscris pe lista!");
        }
    }

    public boolean check(Guest guest) {
        if (this.participantsList.contains(guest)) {
            return true;
        } else return false;
    }

/*    public boolean checkPending(Guest guest) {
        if (this.pendingList.contains(guest)) {
            return true;
        } else return false;
    }*/

    public boolean removeGuest(Guest guest) {

        if (check(guest)) {
            participantsList.remove(guest);
            this.noSeats++;
            System.out.println("Stergerea persoanei s-a realizat cu succes. La revedere!");
            if (pendingList != null && pendingList.size() > 0) {
                this.noSeats--;
                this.orderNo--;
                participantsList.add(pendingList.get(0));
                System.out.println("[" + pendingList.get(0).getFirstName() + " " + pendingList.get(0).getLastName() +
                        "] Felicitari! Locul tau la eveniment este confirmat, ai fost mutat din lista de asteptare, in lista de participare. Te asteptam!");
                pendingList.remove(0);
            }
            return true;
        } else if (pendingList != null && pendingList.contains(guest)) {
            pendingList.remove(guest);
            this.noPending--;
            this.orderNo--;
            System.out.println("Stergerea persoanei de pe lista de asteptare s-a realizat cu succes. La revedere!");
        } else {
            System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
            return false;
        }
        return false;
    }

    public boolean updateGuest(Guest guest) {
        System.out.println("Alege campul de actualizat, tastand:\n"
                + "\t1. Nume si prenume \n"
                + "\t2. E-mail \n"
                + "\t3. Numar de telefon (format \"+40733386463\")\n");

        Guest.comparisonCase = sc.nextInt();

        if (check(guest)) {
            int index = this.participantsList.indexOf(guest);
            if (Guest.comparisonCase == 1) {
                System.out.println("Introduceti prenumele:");
                String firstName = sc.next();
                this.participantsList.get(index).setFirstName(firstName);
                System.out.println("Introduceti numele de familie:");
                String lastName = sc.next();
                this.participantsList.get(index).setLastName(lastName);
                System.out.println("Am actualizat userul: " + guest.getFirstName() + " " + guest.getLastName() + "\n");
                return true;
            }
            if (Guest.comparisonCase == 2) {
                System.out.println("Introduceti email:");
                String email = sc.next();
                this.participantsList.get(index).setEmail(email);
                System.out.println("Am actualizat userul cu emailul: " + guest.getEmail() + "\n");
                return true;
            }
            if (Guest.comparisonCase == 3) {
                System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
                String phoneNumber = sc.next();
                this.participantsList.get(index).setPhoneNumber(phoneNumber);
                System.out.println("Am actualizat userul cu numarul de telefon: " + guest.getPhoneNumber() + "\n");
                return true;
            }
        } else if (pendingList.contains(guest)){
            int index = this.pendingList.indexOf(guest);
            if (Guest.comparisonCase == 1) {
                System.out.println("Introduceti prenumele:");
                String firstName = sc.next();
                this.pendingList.get(index).setFirstName(firstName);
                System.out.println("Introduceti numele de familie:");
                String lastName = sc.next();
                this.pendingList.get(index).setLastName(lastName);
                System.out.println("Am actualizat userul: " + guest.getFirstName() + " " + guest.getLastName() + "\n");
                return true;
            }
            if (Guest.comparisonCase == 2) {
                System.out.println("Introduceti email:");
                String email = sc.next();
                this.pendingList.get(index).setEmail(email);
                System.out.println("Am actualizat userul cu emailul: " + guest.getEmail() + "\n");
                return true;
            }
            if (Guest.comparisonCase == 3) {
                System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
                String phoneNumber = sc.next();
                this.pendingList.get(index).setPhoneNumber(phoneNumber);
                System.out.println("Am actualizat userul cu numarul de telefon: " + guest.getPhoneNumber() + "\n");
                return true;
            }
        }
        return false;
    }

    public void getParticipantsList() {
        if (this.participantsList.size() > 0) {
            System.out.println("\nLista de participare: ");
            for (int i = 0; i < this.participantsList.size(); i++) {
                System.out.println("\t - Nume: " + this.participantsList.get(i).getFullName() + ", Email: " + this.participantsList.get(i).getEmail() + ", Telefon: " + this.participantsList.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("Niciun participant inscris…");
        }

    }

    public void getPendingList() {
        if (this.pendingList.size() > 0) {
            System.out.println("\nLista de asteptare: ");
            for (int i = 0; i < this.pendingList.size(); i++) {
                System.out.println("\t - Nume: " + this.pendingList.get(i).getFullName() + ", Email: " + this.pendingList.get(i).getEmail() + ", Telefon: " + this.pendingList.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("Lista de asteptare este goala…");
        }
    }

    public int getPendingNo() {
        return this.noPending;
    }

    public int getAvailableSeats() {
        return this.noSeats;
    }

    public int getParticiantsNo() {
        return this.participantsList.size();
    }

    public int getTotalCrowdNo() {
        return participantsList.size() + pendingList.size();
    }

    public void search(String value) {
        value = value.toLowerCase();
        int counter = 0;
        System.out.println("Rezultatele cautarii sunt:");
        for (int i = 0; i < participantsList.size(); i++) {
            if (participantsList.get(i).getFullName().toLowerCase().contains(value)) {
                System.out.println("\tNume: " + participantsList.get(i).getFullName() + ", adresa de e-mail: "
                                                    + participantsList.get(i).getEmail() + ", nr. telefon: " + participantsList.get(i).getPhoneNumber());
                counter++;
            } else if (participantsList.get(i).email.toLowerCase().contains(value)) {
                System.out.println("\tNume: " + participantsList.get(i).getFullName() + ", adresa de e-mail: "
                        + participantsList.get(i).getEmail() + ", nr. telefon: " + participantsList.get(i).getPhoneNumber());
                counter++;
            } else if (participantsList.get(i).phoneNumber.contains(value)) {
                System.out.println("\tNume: " + participantsList.get(i).getFullName() + ", adresa de e-mail: "
                        + participantsList.get(i).getEmail() + ", nr. telefon: " + participantsList.get(i).getPhoneNumber());
                counter++;
            }
        }
        for (int i = 0; i < pendingList.size(); i++) {
            if (pendingList.get(i).getFullName().toLowerCase().contains(value)) {
                System.out.println("\tNume: " + pendingList.get(i).getFullName() + ", adresa de e-mail: "
                        + pendingList.get(i).getEmail() + ", nr. telefon: " + pendingList.get(i).getPhoneNumber());
                counter++;
            } else if (pendingList.get(i).email.toLowerCase().contains(value)) {
                System.out.println("\tNume: " + pendingList.get(i).getFullName() + ", adresa de e-mail: "
                        + pendingList.get(i).getEmail() + ", nr. telefon: " + pendingList.get(i).getPhoneNumber());
                counter++;
            } else if (pendingList.get(i).phoneNumber.contains(value)) {
                System.out.println("\tNume: " + pendingList.get(i).getFullName() + ", adresa de e-mail: "
                        + pendingList.get(i).getEmail() + ", nr. telefon: " + pendingList.get(i).getPhoneNumber());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("\tIn urma cautarii persoana nu a putut fi identificata. Va rugam reincercati cautarea dupa alt criteriu!");
        }
    }
}
