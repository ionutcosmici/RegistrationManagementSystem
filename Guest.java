package Homework.P1_RegistrationManagementSystem;

public class Guest {

    private String lastName;
    private String firstName;
    private String fullName;
    public String email;
    public String phoneNumber;
    public static int comparisonCase = 0;

    public Guest() {
    }

    public Guest(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Guest: " +
                "lastName: '" + lastName + '\'' +
                ", firstName: '" + firstName + '\'' +
                ", email: '" + email + '\'' +
                ", phoneNumber: '" + phoneNumber + '\'';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Guest other = (Guest) obj;
        if (comparisonCase == 1 || comparisonCase == 0) {
            if (this.getFullName() == null || other.getFullName() == null) {
                return false;
            } else if (this.getFullName().equals(other.getFullName())) {
                return true;
            }
        }
        if (comparisonCase == 2 || comparisonCase == 0) {
            if (email == null || other.email == null) {
                return false;
            } else if (email.equals(other.email)) {
                return true;
            }
        }
        if (comparisonCase == 3 || comparisonCase == 0) {
            if (phoneNumber == null || other.phoneNumber == null) {
                return false;
            } else if (phoneNumber.equals(other.phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
