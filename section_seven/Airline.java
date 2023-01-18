package section_seven;

import java.util.Arrays;

public class Airline {

    private Person[] people;

    public Airline() {
        people = new Person[11];
    }

    public Person getPerson(int index) {
        return people[index];
    }

    /**
     * FuncName: setter for the Airline class
     * If the seat number of the person is equal to the index of the array, then set
     * the person in that
     * seat.
     * 
     * @param person The person to be added to the plane.
     */
    public void setPerson(Person person) {

        int index = person.getSeatNumber() - 1;
        this.people[index] = new Person(person);

    }

    // Methods

    public void createReservation(Person person) {
        int index = person.getSeatNumber() - 1; // seat number used as index
        while (people[person.getSeatNumber() - 1] != null) {
            System.out.println("\n" + "\tSorry Ms/Mr, " + person.getLastName() + " that seat is already taken");
            person.chooseSeat();
        }
        people[index] = new Person(person);
        System.out.println("Thank you " + person.getFirstName() + " " + person.getLastName()
                + " for flying with Java Airways");

    }
}
