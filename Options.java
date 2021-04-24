package Homework.P1_RegistrationManagementSystem;

public enum Options {

    help			("\t\t\t- Afiseaza aceasta lista de comenzi"),
    add				("\t\t\t\t- Adauga o noua persoana (inscriere)"),
    check			("\t\t\t- Verifica daca o persoana este inscrisa la eveniment"),
    remove			("\t\t\t- Sterge o persoana existenta din lista"),
    update			("\t\t\t- Actualizeaza detaliile unei persoane"),
    guests			("\t\t\t- Lista de persoane care participa la eveniment"),
    waitlist		("\t\t- Persoanele din lista de asteptare"),
    available		("\t\t- Numarul de locuri libere"),
    guests_no		("\t\t- Numarul de persoane care participa la eveniment"),
    waitlist_no		("\t\t- Numarul de persoane din lista de asteptare"),
    subscribe_no	("\t- Numarul total de persoane inscrise"),
    search			("\t\t\t- Cauta toti invitatii conform sirului de caractere introdus"),
    quit			("\t\t\t- Inchide aplicatia");

    private final String details;

    Options(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }
}
