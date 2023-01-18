package section_seven;

import java.util.Arrays;

public class Car {

    /*
     * - Access Level for the fields
     * > We make them private and use Getters and Setters to Access and Modify
     * the values for each field
     * 
     */
    // String make;
    // String model;
    // int price;
    // int year;
    // String color;
    private String make;
    private String model;
    private double price;
    private int year;
    private String color;
    private String[] parts;

    // Constructors - Initialize Fields of a class upon creation

    /**
     * 1. Define the Access Level
     * 2. Assign Params for each field needing to be initialized
     * 3. Use the THIS keyword to refer the actual instance you are creating
     * 
     */
    public Car(int _year, String _make, String _model, double _price, String _color, String[] _parts) {
        this.year = _year;
        this.make = _make;
        this.model = _model;
        this.color = _color;
        this.price = _price;
        this.parts = Arrays.copyOf(_parts, _parts.length); // uses copyOf() > DEEP Copy the class
    }

    // Copy Constructor
    /*
     * > When creating a new instance of an object
     * > If you create the object by making it equal to another Instance of the same
     * class
     * > then you have NOT created a new object. You have created a REFERENCE to the
     * same object
     * > This is called when you create a NEW CAR object instead of passing in each
     * field individually
     * as in the ^^ Class Constructor above ^^
     * > Copy constructor Must also update the objects fields
     * 
     * -- THE THIS KEYWORD --
     * > ** This keyword refers to the [object that is calling the constructor] **
     * 
     * > ** So you effectively have two references pointing to the same object **
     * #############################################################################
     * 
     * > *** Any time you have a MUTABLE object *** <
     * > *** Avoid setting variables equal to each other *** <
     * > *** Both variable will SHARE a reference to the same object *** <
     * 
     * #############################################################################
     * 1. Create a constructor that takes one Param
     * 2. Param is of the same Type as the object passed in
     * 
     */

    public Car(Car source) {
        if (!source.equals(null)) {
            this.make = source.make;
            this.model = source.model;
            this.price = source.price;
            this.year = source.year;
            this.color = source.color;
            this.parts = Arrays.copyOf(source.parts, source.parts.length); // DEEP Copy
        }
    }

    /*
     * Getters and Setters
     * > Allows access private fields of the class
     * > Helps to make sure fields values are not updated by mistake
     * > Public with a return type to match the field it is allowing access to
     * 
     */

    // Getters

    public String getMake() {
        return make;
    }

    public String getMlodel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String[] getParts() {
        return Arrays.copyOf(parts, parts.length);
    }

    // Setters

    public void setMake(String _make) {
        this.make = _make;
    }

    public void setModel(String _model) {
        this.model = _model;
    }

    public void setYear(int _year) {
        this.year = _year;
    }

    public void setPrice(double _price) {
        this.price = _price;
    }

    public void setColor(String _color) {
        this.color = _color;
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public void drive() {
        System.out.println("\n You bought the beautiful " + this.year + " " + this.color + " " + this.make + " "
                + this.model + " for " + this.price);
        System.out.println("Please drive your car to the nearest exit");
    }

    public String toString() {
        return "Year: " + this.year + ".\n"
                + "Make: " + this.make + ".\n"
                + "Model: " + this.model + ".\n"
                + "Price: " + this.price + ".\n"
                + "Color: " + this.color + ".\n"
                + "Parts: " + Arrays.toString(parts) + ".\n";

    }

}
