package section_seven;

import java.util.Arrays;

public class Airline {

    private Person[] people;

    public Airline() {
        people = new Person[11];
    }

    public Person getPerson(int index) {
        Person person = this.people[index];
        return new Person(person); // copy constructor creates copy of object
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

        while (people[person.getSeatNumber() - 1] != null) {
            System.out.println(
                    "\n" + "\tSorry " + person.getFirstName() + ", seat #" + (person.getSeatNumber())
                            + " is already taken");
            person.chooseSeat();

        }
        people[person.getSeatNumber() - 1] = new Person(person);
        System.out.println("Thank you " + person.getFirstName()
                + " for flying with Java Airways. Your seat number is: " + person.getSeatNumber());
    }
}
