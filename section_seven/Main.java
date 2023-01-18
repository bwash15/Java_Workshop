package section_seven;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Main {
    public static void main(String[] args) {

        // Objects
        // - Contain Fields
        // - Perform Tasks

        // Finding Objects in Requirements

        /*
         * - A car is identified by its make, model, price, year, and color
         * - Each car must drive to the nearest exit
         */

        /*
         * 1 - Object > CAR
         * CAR - has Fields of [Make][Model][Price][Year][Color]
         * CAR - can perform the task of driving [Drive]
         */

        /*
         * Once the objects are found in the Requirements,
         * - Create a CLASS for each object found
         * 
         * > CLASS is a blueprint to be used to create
         * instances of the object
         */

        Person[] people = new Person[] {
                new Person("Cleopatra", "", "", "Egypt", "69 BC", 1),
                new Person("Alexander the Great", "", "", "Macedon", "356 BC", 2),
                new Person("Julius Caesar", "", "", "Rome", "100 BC", 3),
                new Person("Hannibal", "", "", "Carthage", "247 BC", 4),
                new Person("Confucius", "", "", "China", "551 BC", 5),
                new Person("Pericles", "", "", "Greece", "429 BC", 6),
                new Person("Spartacus", "", "", "Thrace", "111 BC", 7),
                new Person("Marcus Aurelius", "", "", "Rome", "121 AD", 8),
                new Person("Leonidas", "", "", "Greece", "540 BC", 9),
                new Person("Sun Tzu", "", "", "China", "544 BC", 10),
                new Person("Hammurabi", "", "", "Babylon", "1750 BC", 11),
        };

        Airline airline = new Airline();

        for (int i = 0; i < people.length; i++) {
            airline.setPerson(people[i]);
            airline.createReservation(people[i]);
        }

        System.out.println(airline.getPerson(1));
        System.out.println(airline.getPerson(5));
        System.out.println(airline.getPerson(10));

        // String[] spareParts = new String[] { "Spare Tires", "Spare Keys" };
        Car nissan = new Car(2020, "Nissan", "Frontier", 10000, "Blue",
                new String[] { "Spare Tires", "Spare Keys" });
        Car dodge = new Car(2019, "Dodge", "Charger", 15000.00, "Black", new String[] { "Spare Tires", "Spare Keys" });

        // nissan.make = "Nissan";
        // nissan.model = "Frontier";
        // nissan.year = 2020;
        // nissan.price = 10000;
        // nissan.color = "Blue";

        // -----------------------------------------------

        // Using the Copy Constructor
        Car nissan2 = new Car(nissan);

        nissan2.setColor("Yellow");
        nissan.setColor("Orange");
        nissan2.setColor("Blue");
        nissan.setColor("Purple");
        nissan2.setColor("Fuchsia");
        nissan.setColor("Beige");

        // dodge.make = "Dodge";
        // dodge.model = "Charger";
        // dodge.year = 2019;
        // dodge.price = 15000;
        // dodge.color = "Black";

        dodge.setColor("Jet Black");
        dodge.setPrice(dodge.getPrice() / 2);
        System.out.println("This " + nissan.getMake() + " is worth $" + nissan.getPrice() +
                ". It was built in " + nissan.getYear() + ". It is " + nissan.getColor() + ".\n");
        System.out.println("This " + dodge.getMake() + " is worth $" + dodge.getPrice() +
                ". It was built in " + dodge.getYear() + ". It is " + dodge.getColor() + ".\n");

        // -----------------------------------------------
        Person morgan = new Person("Morgan", "Kendall", "Washington", "02/16/2003", "American", 1);

        // morgan.firstName = "Morgan";
        // morgan.lastName = "Washington";
        // morgan.middleName = "Kendall";
        // morgan.nationality = "American";
        // morgan.dateOfBirth = "02/16/2003";
        // morgan.seatNumber = 1;

        System.out.println(morgan.getFirstName());
        System.out.println(morgan.getLastName());
        System.out.println(morgan.getMiddleName());
        System.out.println(morgan.getNationality());
        System.out.println(morgan.getDateOfBirth());
        System.out.println(morgan.getSeatNumber());
        System.out.println(Arrays.toString(morgan.getPassport()));

        if (morgan.applyPassport()) {
            System.out.println("Congratulations!! " + morgan.getFirstName() + ", your application was approved!! \n");
            morgan.chooseSeat();
            System.out.println("\nYour chosen seat number is: " + morgan.getSeatNumber());
        } else {
            System.out.println("We are sorry, " + morgan.getFirstName() + ". We cannot process your application\n");
        }

        // ---------------------------------------------------------------------------

        // Using the copy constructor of the Person class
        Person ciera = new Person(morgan);

        ciera.setFirstName("Ciera");
        ciera.setMiddleName("Nicole");
        ciera.setDateOfBirth("04/12/2007");
        ciera.setNationality("American/English");
        ciera.setSeatNumber(2);

        System.out.print("Welcome " + ciera.getFirstName() + ". Let's start your application...\n");
        System.out.println(ciera.getFirstName());
        System.out.println(ciera.getLastName());
        System.out.println(ciera.getMiddleName());
        System.out.println(ciera.getNationality());
        System.out.println(ciera.getDateOfBirth());
        System.out.println(ciera.getSeatNumber());
        System.out.println(Arrays.toString(ciera.getPassport()));

        if (ciera.applyPassport()) {
            System.out.println("Congratulations!! " + ciera.getFirstName() + ", your application was approved!! \n");
            ciera.chooseSeat();
            System.out.println("\nYour chosen seat number is: " + ciera.getSeatNumber());
        } else {
            System.out.println("We are sorry, " + ciera.getFirstName() + ". We cannot process your application\n");
        }

        System.out.println("Name: " + ciera.getFirstName() + "\n"
                + " Nationality: " + ciera.getNationality() + "\n"
                + " Date of Birth: " + ciera.getDateOfBirth() + "\n"
                + " Seat Number: " + ciera.getSeatNumber() + "\n"
                + " Passport: " + Arrays.toString(ciera.getPassport()));

        System.out.println("Entering the Auto Dealership");

        Scanner scan = new Scanner(System.in);

        Car[] cars = new Car[] {
                new Car(2020, "Nissan", "Frontier", 5000, "red", new String[] { "tires", "keys" }),
                new Car(2019, "Dodge", "Dakota", 8500, "blue", new String[] { "tires", "keys" }),
                new Car(2017, "Nissan", "Maxima", 5000, "yellow", new String[] { "tires", "filter" }),
                new Car(2019, "Honda", "Accord", 7000, "orange", new String[] { "tires", "filter" }),
                new Car(2015, "Mercedes", "C500", 12000, "jet black",
                        new String[] { "tires", "filter", "transmission" })
        };

        Dealership dealership = new Dealership(cars);

        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
        System.out.println("Feel free to browse through our collection of cars.\n");
        System.out.println(dealership);
        System.out.println("Which car are you interested in? (0 – 4).\n");
        int index = scan.nextInt();

        // sell car here...

        scan.close();

    }
}
