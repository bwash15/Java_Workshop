package section_seven;

import java.util.Arrays;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;

    private String dateOfBirth;
    private String nationality;
    private String[] passport;
    private int seatNumber;

    // Overriding Default Constructor

    public Person(String _firstName, String _middleName, String _lastName, String _nationality, String _DOB,
            int _seatNumber) {
        this.firstName = _firstName;
        this.middleName = _middleName;
        this.lastName = _lastName;
        this.dateOfBirth = _DOB;
        this.nationality = _nationality;
        this.seatNumber = _seatNumber;
        this.passport = new String[3];
    }

    // Copy Constructor

    public Person(Person _source) {
        if (!_source.equals(null)) {
            this.firstName = _source.firstName;
            this.lastName = _source.lastName;
            this.middleName = _source.middleName;
            this.dateOfBirth = _source.dateOfBirth;
            this.nationality = _source.nationality;
            this.seatNumber = _source.seatNumber;
            this.passport = new String[3];
        }
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String _middleName) {
        this.middleName = _middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String _dob) {
        this.dateOfBirth = _dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String _nationality) {
        this.nationality = _nationality;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int _seatNumber) {
        this.seatNumber = _seatNumber;
    }

    public String[] getPassport() {
        // Returning a copy of the array.
        return Arrays.copyOf(passport, passport.length);
    }

    public void setPassport() {
        passport = new String[] { firstName + " " + lastName, nationality, dateOfBirth };
    }

    // Methods

    public String toString() {
        return "First Name: " + this.firstName + ".\n"
                + "MiddleName: " + this.middleName + ".\n"
                + "Last Name: " + this.lastName + ".\n"
                + "Nationality: " + this.nationality + ".\n"
                + "Date Of Birth: " + this.dateOfBirth + "\n"
                + "Passport: " + Arrays.toString(passport) + ".\n";

    }

    /**
     * FuncName: applyPassport()
     * This function returns true 50% of the time.
     * 
     * @return (boolean) A boolean value.
     */
    public boolean applyPassport() {
        int number = (int) (Math.random() * 2);
        if (number == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * FuncName: chooseSeat()
     * This function chooses a random seat number for the passenger
     */
    public void chooseSeat() {
        int randoSeat = (int) Math.random() * 11 + 1;
        this.seatNumber = randoSeat;
    }

}
