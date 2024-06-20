import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class property { //abstract class

    Scanner inputValues = new Scanner(System.in);

    //data members
    double Maintenance_Cost;
    String Property_Trustee;
    static String Company_Name = "ABC";

    //private data member
    private double value;
    private String Property_Id;
    private String Ownership;

    //default constructor
    property() {
        this.Property_Id = null;
        this.value = 0;
        this.Ownership = null;
        this.Property_Trustee = null;
    }

    //overloading constructor
    property(String Property_Id, double value, String Ownership, String Property_Trustee){
        this.Property_Id = Property_Id;
        this.value = value;
        this.Ownership = Ownership;
        this.Property_Trustee =Property_Trustee;
        //this.Maintenance_Cost = Maintenance_Cost;
    }


    //getter method for ownership
    public String getOwnership() {
        return Ownership;
    }

    //getter method
    public String getProperty_Id() {
        return Property_Id;
    }

    //get value of property
    public double getValue() {
        return value;
    }

    //get inputs from user
    void inputValues(){
        String m;

        System.out.print("Enter Ownership : ");
        this.Ownership = inputValues.nextLine();

        System.out.print("Enter Property Trustee : ");
        this.Property_Trustee = inputValues.nextLine();

        System.out.print("Enter property Id : ");
        this.Property_Id = inputValues.nextLine();

        //exception handling
        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter value : ");
                this.value = inputValues.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while ((m == "e"));
    }


    //Abstract method
    abstract double CalMaintenanceCost();


    void print(){
        System.out.println(" ");
        System.out.println("Property information");
        System.out.println("____________________");
        System.out.println(" ");
        System.out.println("Company name             = " + " " + Company_Name);
        System.out.println("property Id              = "+" "+getProperty_Id());
        System.out.println("Property Trustee         = "+" "+Property_Trustee);
        System.out.println("The owner                = "+" " +getOwnership());
        System.out.println("The value                = "+" "+"Rs."+getValue());

    }

    //toString method
    public String toString(){
        return "This is a Property";
    }
}

//land child class
class Land extends property {

    //data members
    private double Area_Of_Land;
    double Income_per_perch;
    double Maintenance_per_perch;

    //default constructor
    Land() {
        Area_Of_Land = 0;
        Income_per_perch = 0;
        Maintenance_per_perch = 0;
    }

    //overloading land constructor
    Land(double Area_Of_Land, double Income_per_perch, double Maintenance_per_perch,String Property_Id, double value, String Ownership, String Property_Trustee ) {
        super(Property_Id,value, Ownership,Property_Trustee);
        this.Area_Of_Land = Area_Of_Land;
        this.Income_per_perch = Income_per_perch;
        this.Maintenance_per_perch = Maintenance_per_perch;
    }

    //overriding method
    public void inputValues() {
        String m;

        super.inputValues();

        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter Area_Of_Land : ");
                this.Area_Of_Land = inputValues.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while ((m == "e"));

        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter Income_per_perch  : ");
                this.Income_per_perch = inputValues.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while ((m == "e"));

        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter Maintenance_per_perch  : ");
                this.Maintenance_per_perch = inputValues.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while ((m == "e"));
    }

    //set data members
    public void setArea_Of_Land(double Area_Of_Land) {
        this.Area_Of_Land = Area_Of_Land;
    }

    public void setIncome_per_perch(double Income_per_perch) {
        this.Income_per_perch = Income_per_perch;
    }

    public void setMaintenance_per_perch(double Maintenance_per_perch) {
        this.Maintenance_per_perch = Maintenance_per_perch;
    }

    //getter methods
    public double getArea_Of_Land() {
        return Area_Of_Land;
    }

    public double getIncome_per_perch() {
        return Income_per_perch;
    }

    public double getMaintenance_per_perch() {
        return Maintenance_per_perch;
    }

    //calculate income
    public double calIncome() {
        return getArea_Of_Land() * getIncome_per_perch();
    }

    //Calculate Maintenance for one land
    double CalMaintenanceCost() {
        return getArea_Of_Land() * getMaintenance_per_perch();
    }

    //calculate profit
    public double getProfit() {
        return calIncome() - CalMaintenanceCost();
    }

    //print method overriding
    void print() {
        super.print();
        System.out.println("Income                   = " + " " + "Rs." +calIncome());
        System.out.println("Maintenance cost         = " + " " + "Rs." + CalMaintenanceCost());
        System.out.println("profit                   = " + " " + "Rs." + getProfit());
    }

    //toString method
    public String toString(){
        return super.toString()+" "+"and"+" "+"This is a Land property";
    }

}


//machine child class
class Machine extends property{

    //data members
    int workHours;
    private double MaintenanceCost_per_hour;


    //default constructor
    Machine(){
        this.workHours = 0;
        this.MaintenanceCost_per_hour = 0;
    }

    //overloading method
    Machine(String Property_Id, double value, String Ownership, String Property_Trustee, int workHours,double MaintenanceCost_per_hour){
        super(Property_Id,value,Ownership,Property_Trustee);
        this.workHours = workHours;
        this.MaintenanceCost_per_hour = MaintenanceCost_per_hour;

    }

    //input values
    void inputValues(){
        String m;

        super.inputValues();

        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter workHours : ");
                this.workHours = inputValues.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter integer value");
                m = "e";
            }
        }while ((m == "e"));

        do {
            m = null;
            inputValues = new Scanner(System.in);
            try {
                System.out.print("Enter Maintenance_per_hour  : ");
                this.MaintenanceCost_per_hour = inputValues.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while ((m == "e"));
    }

    //get method
    public double getWorkHours() {
        return workHours;
    }

    public double getMaintenanceCost_per_hour() {
        return MaintenanceCost_per_hour;
    }

    //set methods
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    private void setMaintenanceCost_per_hour(double maintenanceCost_per_hour) {
        MaintenanceCost_per_hour = maintenanceCost_per_hour;
    }

    //calculate maintenance cost
    double CalMaintenanceCost(){
        return getMaintenanceCost_per_hour() * getWorkHours();
    }

    //machine efficiency
    public double getQuality() {
        return (getMaintenanceCost_per_hour() / getWorkHours()) / (double)100;
    }

    //find machine status
    String machineStatus(){
        if(getQuality() >= 0.65){
            return " This machine needs to be replaced.";
        }
        else if (getQuality() >= 0.5){
            return " This machine needs to be repaired.";
        }
        else
            return " This machine is in working condition.";
    }

    //Override method
    void print() {
        super.print();
        System.out.println("Maintenance cost         = " + " " + "Rs." + CalMaintenanceCost());
        System.out.println("Machine status           = " +machineStatus());


    }

    //toString method
    public String toString(){
        return super.toString()+" "+"and"+" "+"This is a machine property";
    }
}
