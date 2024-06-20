/*
Purpose : To get information about behave of each product in the market within a particular time period
Outcomes :
           * sales of the product and percentage
           * delivery cost
           * demand of the product in the market
           * total product cost
           * total value of the product issued to the market
           * profit or loss of the product and the percentage
           * final report
After following the final report company can decide
           * which product they have to over-produced with respect to the demand of the market
           * which products that should stop production
           * which actions they have to take to increase the profit of the product
           * how to reduce the delivery costs
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class marketOfProduct {

    Scanner input = new Scanner(System.in);

    //define data members
    String productId;
    private String quality;
    private int quantity;
    private double productPrice;
    private double productCost;
    //double financialValue;
    int returnQuantity;
    //double returnValue;

    //default constructor
    marketOfProduct(){
        productId = null;
        quality = null;
        quantity = 0;
        productPrice = 0;
        returnQuantity = 0;
        productCost = 0;
    }

    //constructor overloading
    marketOfProduct(String productId,String quality,int quantity,double productPrice,double productCost,int returnQuantity){
        this.productId = productId;
        this.quality = quality;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.returnQuantity = returnQuantity;
        this.productCost = productCost;
    }

    //get input from user
    void getInputs(){
        String m = null;

        do {
            System.out.print("Enter product ID : ");
            this.productId = input.nextLine();
        }while(productId == "");

        do {
            System.out.print("Enter quality : ");
            this.quality = input.nextLine();
        }while (quality == "");

        //exception handling for quantity
        do {
            input = new Scanner(System.in);
            m = null;
            try {
                System.out.print("Enter quantity : ");
                this.quantity = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter an integer value for quantity");
                m = "e";
            }
        }while (!(m == null));

        //exception handling for price
        do {
            input = new Scanner(System.in);
            m = null;

            try {
                System.out.print("Enter Product price : ");
                this.productPrice = input.nextDouble();
                String e = null;
            }catch (InputMismatchException e){
                System.out.println("Enter double or integer value for price");
                m = "e";
            }
        }while (!(m == null));

        //exception handling for product cost
        do {
            input = new Scanner(System.in);
            m = null;

            try {
                System.out.print("Enter Product cost : ");
                this.productCost = input.nextDouble();
                String e = null;
            }catch (InputMismatchException e){
                System.out.println("Enter double or integer value for price");
                m = "e";
            }
        }while (!(m == null));

        //exception handling for return quantity
        do {
            input = new Scanner(System.in);
            m = null;

            try {
                System.out.print("Enter return quantity : ");
                this.returnQuantity = input.nextInt();
            }catch (Exception e){
                System.out.println("Please enter an integer value for return quantity");
                m = "e";
            }
        }while(!(m == null));
    }

    //set return quantity of product
    public void setReturnQuantity(int returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    //set product id
    public void setProductId(String productId) {
        this.productId = productId;
    }

    //set product quality
    public void setQuality(String quality) {
        this.quality = quality;
    }

    //set product quality
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //set product price
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    //get quantity
    public int getQuantity() {
        return quantity;
    }
    //get product cost
    public double getProductCost() {
        return productCost;
    }

    //calculate the value of product issued to the market
    double calValue(){
        return productPrice * quantity;
    }

    //calculate total cost
    double calProductCost(){
        return getProductCost() * getQuantity();
    }

    //calculate the return value of product
    double calReturnValue(){
        return returnQuantity * productCost;
    }

    //calculate the profit of each product
    abstract double profit();

    //get the count of the sold products
    int sales(){
        return quantity - returnQuantity;
    }

    //calculate the value of sold products
    double calSoldProductValue(){
        return productPrice * sales();
    }

    //calculate the sales percentage of the product in market
    double salesPercentage(){
        return (sales() / (float)quantity) * 100;
    }

    //find the priority of product in the market
    String findDemand(){
        if (salesPercentage() > 85){
            return "First demand product in market";
        }
        else if (salesPercentage() > 75){
            return "Second demand product in market";
        }
        else if (salesPercentage() > 65){
            return "Third demand product in market";
        }
        else
            return "Less demand product";
    }

    //rules and regulations
    abstract void rulesAndRegulations();

    //to string override
    public String toString(){
        System.out.println();
        System.out.println("Market report of " +"\"" +productId +"\"");
        return  "\nProduct ID             : " +productId +
                "\nQuality                : " +quality +
                "\nProduct cost           : " +getProductCost() +" LKR" +
                "\nProduct market price   : " +productPrice +" LKR" +
                "\nQuantity               : " +quantity +
                "\nReturn quantity        : " +returnQuantity +
                "\nsales                  : " +sales() +
                "\nTotal value of product : " +calValue() +" LKR" +
                "\nTotal product cost     : " +calProductCost() +" LKR" +
                "\nSales percentage       : " +salesPercentage() +" %" +
                "\nDemand                 : " +findDemand();
    }

}
class localMarket extends marketOfProduct{

    //define data members
    double deliveryCostPerUnite;

    //default constructor
    localMarket(){
        deliveryCostPerUnite = 0;
    }

    //constructor
    localMarket(String productId,String quality,int quantity,double productPrice,double productCost,int returnQuantity,double deliveryCostPerUnite){
        super(productId,quality,quantity,productPrice,productCost,returnQuantity);
        this.deliveryCostPerUnite = deliveryCostPerUnite;
    }



    //input data from user
    void getInputs(){
        super.getInputs();
        String m = null;

        //exception handling
        do {
            input = new Scanner(System.in);
            m = null;

            try {
                System.out.print("Enter delivery cost per unite : ");
                this.deliveryCostPerUnite = input.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Enter a double or integer value");
                m = "e";
            }
        }while (!(m == null));

    }

    //set delivery cost per unite
    void setDeliveryCostPerUnite(double deliveryCostPerUnite) {
        this.deliveryCostPerUnite = deliveryCostPerUnite;
    }

    //calculate delivery cost
    double calDeliveryCost(){
        return deliveryCostPerUnite * getQuantity();
    }

    //calculate the profit
    double profit(){
        return super.calSoldProductValue() - (calDeliveryCost() + calProductCost());
    }

    //print profit or loss
    String print(){
        if (profit() >= 0){
            return  "\nProfit                 : " +profit();
        }
        else
            return "\nLoss                   : " +profit();
    }

    //get profit or loss percentage
    String profitPercentage(){

        if (profit() >= 0){
            return "\nProfit percentage      : " +(profit()/(calProductCost() + calDeliveryCost())) * 100 +" %";
        }
        else
            return "\nloss percentage        : " +(profit()/(calProductCost() + calDeliveryCost())) * 100 +" %";
    }

    //details about agreements
    void rulesAndRegulations(){

    }

    //toString method
    public String toString(){
        return super.toString() +"\nDelivery cost          : " +calDeliveryCost() +" LKR" +print() +" LKR" +profitPercentage();
    }
}

class foreignMarket extends marketOfProduct{

    //define data members
    double productWeight;
    double cargoCostPerUnit;

    //default constructor
    foreignMarket(){
        productWeight = 0;
        cargoCostPerUnit = 0;
    }

    //constructor
    foreignMarket(String productId,String quality,int quantity,double productPrice,double productCost,int returnQuantity,double productWeight,double cargoCostPerUnit){
        super(productId,quality,quantity,productPrice,productCost,returnQuantity);
        this.productWeight = productWeight;
        this.cargoCostPerUnit = cargoCostPerUnit;
    }

    //get user inputs
    void getInputs(){
        super.getInputs();
        String m = null;

        do {
            input = new Scanner(System.in);
            try {
                System.out.print("Enter product weight (g) : ");
                this.productWeight = input.nextDouble();
            }catch (Exception e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while (!(m == null));

        do {
            input = new Scanner(System.in);
            try {
                System.out.print("Enter cargo cost per kg : ");
                this.cargoCostPerUnit = input.nextDouble();
            }catch (Exception e){
                System.out.println("Please enter double or integer value");
                m = "e";
            }
        }while (!(m == null));

    }


    //set the weight of a product
    void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    //set cargo cost per unit
    void setCargoCostPerUnit(double cargoCostPerUnit) {
        this.cargoCostPerUnit = cargoCostPerUnit;
    }

    //calculate the total weight of import products
    double importProductWeight(){
        return super.getQuantity() * productWeight;
    }

    //calculate the total weight of return products
    double returnProductWeight(){
        return super.returnQuantity * productWeight;
    }

    //calculate the import cost
    double importCost(){
        return (importProductWeight() / (double)1000) * cargoCostPerUnit;
    }

    //calculate the return cost
    double returnCost(){
        return (returnProductWeight() / (double)1000) * cargoCostPerUnit;
    }

    //calculate the profit
    double profit(){
        return calSoldProductValue() - (importCost() + returnCost() + calProductCost());
    }
    //get  profit or loss
    String print(){
        if (profit() >= 0){
            return "\nProfit                 : " +profit();
        }
        else
            return "\nLoss                   : " +profit();
    }

    //get the profit or loss percentage
    String profitPercentage(){

        if (profit() >= 0){
            return "\nProfit percentage      : " +(profit()/(calProductCost() + importCost() + returnCost())) * 100 +" %";
        }
        else
            return "\nloss percentage        : " +(profit()/(calProductCost() + importCost() + returnCost())) * 100 +" %";
    }
    //convert LKR to $
    double converter(double amount){
        return amount / (double)380;
    }
    //details about agreement
    void rulesAndRegulations(){
    }

    //toString method
    public String toString(){
        return super.toString() +"\nCargo cost             : " +(importCost() + returnCost()) +" LKR" +print() +" LKR" +"\nProfit or loss         : " +converter(this.profit()) +" $"
                +profitPercentage();

    }
}
