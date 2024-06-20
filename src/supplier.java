/*
Purpose : Manage the suppliers who supply materials to the company.
Outcomes :
         * get all details about each supplier
         * find all suppliers according to the materials they supply
         * place an order to the supplier
         * payment to be done for the order
         * ordered  date
         * ordered quantity
         * check whether any previous orders placed to the suppliers
    Through finding the all suppliers who supply relevant materials, the company can find which supplier provides the materials at least price.
    According to the budget of the company, they can decide which supplier(s) will be given the order.
 */
import java.util.Date;
import java.util.Scanner;

public abstract class supplier {

    Scanner input = new Scanner(System.in);

    //data members
    private String supId;
    String supName;
    String supContact;

    //default constructor
    supplier(){
        this.supId = null;
        this.supName = null;
        this.supContact = null;
    }

    //constructor overloading
    supplier(String supId,String supName,String supContact){
        this.supId = supId;
        this.supName = supName;
        this.supContact = supContact;
    }

    //get supplier ID
    public String getSupId() {
        return supId;
    }

    //get supplier name
    public String getSupName() {
        return supName;
    }

    //get supplier contact
    public String getSupContact() {
        return supContact;
    }

    abstract double payment();

    abstract void order();

    //print supplier details
    public String print(){
        return "\nSupplier ID      : " +getSupId() +
                "\nSupplier name    : " +getSupName() +
                "\nSupplier contact : " +getSupContact();
    }

    //overloading toString method
    public String toString(){
        return "\nSupplier ID      : " +getSupId() +
                " Supplier name    : " +getSupName() +
                " Supplier contact : " +getSupContact();
    }
}

class teaLeavesSupplier extends supplier{

    //data  members
    private static double unitPrice;
    double quantity;
    int quality;

    //default constructor
    teaLeavesSupplier(){
        unitPrice = 0;
        quantity = 0;
        quality = 0;
    }

    //constructor overloading
    teaLeavesSupplier(String supId,String supName,String supContact,double quantity,int quality){
        super(supId,supName,supContact);
        this.quantity = quantity;
        this.quality = quality;
    }

    //modify tea leaves unit price
    static void setUnitPrice(double price){
        unitPrice = price;
    }

    //get unit price
    double getUnitPrice(){
        return unitPrice;
    }

    //get quantity
    double getQuantity(){
        return quantity;
    }

    //get quality
    int getQuality(){
        return quality;
    }

    //check quality
    double qualityPrice(){
        if (quality == 1){
            return getUnitPrice() * 110 / (double)100;
        }
        else if (quality == 2){
            return getUnitPrice() * 105 / (double)100;
        }
        else if (quality == 3){
            return getUnitPrice();
        }
        else
            return getUnitPrice() * 95 / (double)100;
    }

    //payment for each supplier
    double payment(){
        return getQuantity() * qualityPrice();
    }

    //place an order
    void order(){
        System.out.println("Not support for tea supplier");
    }

    //overriding toString method
    public String print(){
        return super.print() +
                "\nQuality          : " +"No " +getQuality()+
                "\nUnit price       : " +qualityPrice() +
                "\nQuantity         : " +getQuantity() +
                "\nPayment          : " +payment();
    }
}

class fertilizerSupplier extends supplier{
    //data members
    private double unitPrice;
    String fertilizerType;
    private double orderedQuantity;
    String orderedDate;


    //default constructor
    fertilizerSupplier(){
        this.unitPrice = 0;
        this.fertilizerType = null;
        this.orderedQuantity = 0;
        this.orderedDate = null;
    }

    //constructor overloading
    fertilizerSupplier(String supId,String supName,String supContact,double unitPrice,String fertilizerType){
        super(supId,supName,supContact);
        this.unitPrice = unitPrice;
        this.fertilizerType = fertilizerType;
        this.orderedQuantity = 0;
        this.orderedDate = null;
    }

    //get ordered quantity
    double getOrderedQuantity(){
        return orderedQuantity;
    }

    //get unite price
    double getUnitPrice(){
        return unitPrice;
    }

    //get fertilizer type
    String getFertilizerType(){
        return fertilizerType;
    }

    //get ordered date
    String getOrderedDate(){
        return orderedDate;
    }

    //oder status
    String orderStatus(){
        if (getOrderedQuantity() == 0 && orderedDate == null){
            return "\nOrder quantity   : " +"No oder placed yet";
        }
        else
            return "\nOrder quantity   : " +getOrderedQuantity() +"\nOrdered date     : " +getOrderedDate() +
                    "\nPayment for order: " +payment() + "\nAdvance payment  : " +advancePayment() +
                    "\nBalance to paid  : " +balance() +"\n\n";
    }

    //calculate the payment
    double payment(){
        return getOrderedQuantity() * getUnitPrice();
    }

    double advancePayment(){
        return (payment() * 25) / (double)100;
    }

    double balance(){
        return payment() - advancePayment();
    }

    //place an order
    void order(String supId,double orderedQuantity){
        this.orderedQuantity = orderedQuantity;
        Date d = new Date();
        orderedDate = d.toString();
        System.out.print("\nSupplier ID      : " +supId);
        System.out.print(orderStatus());
    }
    void order() {
        System.out.print("Enter supplier ID : ");
        String id = input.nextLine();
        System.out.print("Enter order quantity : ");
        orderedQuantity = input.nextDouble();
        Date d = new Date();
        orderedDate = d.toString();
        System.out.print("\nSupplier ID      : " +id);
        System.out.print(orderStatus());
    }

    public String print(){
        return super.print() +
                "\nFertilizer type  : " +getFertilizerType() +
                "\nUnite price      : " +getUnitPrice() +orderStatus();
    }

    //toString overriding
    public String toString(){
        return super.toString() +" Fertilizer type  : " +getFertilizerType() +
                " Unite price      : " +getUnitPrice();
    }

    //find suppliers
    public static void find(String fertilizerType,fertilizerSupplier[] FE00){
        int count = 0;
        try {
            for (int i = 0; i < 10; i++){
                if (FE00[i].fertilizerType.contains(fertilizerType)){
                    System.out.println(FE00[i].toString());
                    count++;
                }
            }
        }catch (NullPointerException e){
            if (count == 0){
                System.out.println("Input a valid ingredient type");
            }

        }

    }

}


class ingredientsSupplier extends supplier{
    //data members
    private double unitPrice;
    String ingredientsType;
    int orderedQuantity;
    String orderedDate;


    //default constructor
    ingredientsSupplier(){
        this.unitPrice = 0;
        this.ingredientsType = null;
        this.orderedQuantity = 0;
        this.orderedDate = null;
    }

    //constructor overloading
    ingredientsSupplier(String supId,String supName,String supContact,double unitPrice,String ingredientsType){
        super(supId,supName,supContact);
        this.unitPrice = unitPrice;
        this.ingredientsType = ingredientsType;
        this.orderedQuantity = 0;
        this.orderedDate = null;
    }

    //get unit price
    double getUnitPrice(){
        return unitPrice;
    }

    //get ordered quantity
    int getOrderedQuantity(){
        return orderedQuantity;
    }

    //get ordered date
    String getOrderedDate() {
        return orderedDate;
    }

    //get ingredients type
    String getIngredientsType(){
        return ingredientsType;
    }

    //oder status
    String orderStatus(){
        if (getOrderedQuantity() == 0 && orderedDate == null){
            return "\nOrder quantity   : " +"No oder placed yet";
        }
        else
            return  "\nOrder quantity   : " +getOrderedQuantity() +"\nOrdered date     : " +getOrderedDate() +
                    "\nPayment for order: " +payment() + "\nAdvance payment  : " +advancePayment() +
                    "\nBalance to paid  : " +balance() +"\n";
    }

    //calculate payment
    double payment(){
        return getUnitPrice() * getOrderedQuantity();
    }

    double advancePayment(){
        return (payment() * 25) / (double)100;
    }

    double balance(){
        return payment() - advancePayment();
    }

    void order(String supId,int quantity){
        orderedQuantity = quantity;
        Date d = new Date();
        orderedDate = d.toString();
        System.out.print("\nSupplier ID      : " +supId);
        System.out.println(orderStatus());

    }

    void order(){
        System.out.print("Enter supplier ID : ");
        String id = input.nextLine();
        System.out.print("Enter order quantity : ");
        orderedQuantity = input.nextInt();
        Date d = new Date();
        orderedDate = d.toString();
        System.out.print("\nSupplier ID      : " +id);
        System.out.println(orderStatus());
    }

    public String print(){
        return super.print() +
                "\nFertilizer type  : " +getIngredientsType() +
                "\nUnite price      : " +getUnitPrice() +orderStatus();
    }

    //toString overriding
    public String toString(){
        return super.toString() +" Fertilizer type  : " +getIngredientsType() +
                " Unite price      : " +getUnitPrice();
    }

    //find suppliers
    public static void find(String ingredientsType,ingredientsSupplier[] IN00){
        int count = 0;
        try {
            for (int i = 0; i < 10; i++){
                if (IN00[i].ingredientsType.contains(ingredientsType)){
                    System.out.println(IN00[i].toString());
                    count++;
                }
            }

        }catch (NullPointerException e){
            if (count == 0){
                System.out.println("Input a valid ingredient type");
            }
        }
    }
}
