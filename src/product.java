import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class product {
    public static void age() {

        Scanner input = new Scanner(System.in);
        System.out.println("Now you can check your product is suitable for your age ");
        System.out.println("Please enter your age");
        int age = input.nextInt();

        if (age > 30) {
            System.out.println("Your most suitable products are product code 1 to 10  ");
        } else {
            System.out.println("you are suitable for all products");
        }
        System.out.println();
    }
    public static void cost() {
        System.out.println("Enter your cost to choose suitable product ");
        Scanner input = new Scanner(System.in);
        double cost = input.nextDouble();
        if (cost > 1000) {
            if (cost >= 2100) {
                System.out.println("You can buy product code 1");
            } else if (cost >= 2050) {
                System.out.println("You can buy product code 2");
            } else if (cost >= 1930) {
                System.out.println("You can buy product code 3");
            } else if (cost >= 1890) {
                System.out.println("You can buy product code 4");
            } else if (cost >= 1650) {
                System.out.println("You can buy product code 5");
            } else if (cost >= 1550) {
                System.out.println("You can buy product code 6");
            } else if (cost >= 1400) {
                System.out.println("You can buy product code 7");
            } else if (cost >= 1300) {
                System.out.println("You can buy product code 8");
            } else if (cost >= 1200) {
                System.out.println("You can buy product code 9");
            } else {
                System.out.println("You can buy product code 10");
            }
        } else {
            if (cost >= 1000) {
                System.out.println("You can buy product code 11 ");
            } else if (cost >= 850) {
                System.out.println("You can buy product code 12 ");
            } else if (cost >= 500) {
                System.out.println("You can buy product code 13 ");
            } else if (cost >= 250) {
                System.out.println("You can buy product code 14 ");
            } else {
                System.out.println("You can buy product code 15 ");
            }
        }

        System.out.println();
    }
    public static void productcode() {
        System.out.println("Enter your product code");
        Scanner input = new Scanner(System.in);
        int product = input.nextInt();

        switch (product) {
            case 1:
                System.out.println("your product is Ceylon tea.Rs 2100");
                break;
            case 2:
                System.out.println("your product is Fat burn tea.Rs 2050");
                break;
            case 3:
                System.out.println("your product is Green tea.Rs 1930");
                break;
            case 4:
                System.out.println("your product is Homemade Tea.Rs 1890");
                break;
            case 5:
                System.out.println("your product is Shape up tea.Rs 1650");
                break;
            case 6:
                System.out.println("your product is Bowatte Ayurveda tea.Rs 1550");
                break;
            case 7:
                System.out.println("your product is Cino advance tea.Rs 1400");
                break;
            case 8:
                System.out.println("your product is Slim weight loss tea.Rs 1300");
                break;
            case 9:
                System.out.println("your product is Hibiscus tea.Rs 1200");
                break;
            case 10:
                System.out.println("your product is Honey lemon ginger tea.Rs 1100");
                break;
            case 11:
                System.out.println("your product is coffee tea.Rs 1050");
                break;
            case 12:
                System.out.println("your product is  lemon  tea.Rs 900");
                break;
            case 13:
                System.out.println("your product is yummy tea.Rs 600");
                break;
            case 14:
                System.out.println("your product is Tummy tea.Rs 300");
                break;

            default:
                System.out.println("your product is sweet tea.Rs 200");
                int str3 = input.nextInt();
        }

        System.out.println();
    }
    public static void productbenifits() {
        System.out.println("Now you check your selected tea product benifits");
        System.out.println("Please enter you select product code");
        Scanner input = new Scanner(System.in);
        int code = input.nextInt();

        if (code == 1) {
            System.out.println("Ceylon tea is also linked to health benefits like improved heart health and blood sugar control, as well as weight loss.");
        } else if (code == 2) {
            System.out.println("Fat burn tea could help enhance weight loss by improving fat burning and speeding up metabolism");
        } else if (code == 3) {
            System.out.println("Green tea has been shown to improve blood flow and lower cholesterol");
        } else if (code == 4) {
            System.out.println("Home made Tea Can Help Reduce Pain and Soreness.");
        } else if (code == 5) {
            System.out.println("Shape up Tea helps in the reduction of body fat, when augmented by proper exercise and a balanced diet.");
        } else if (code == 6) {
            System.out.println("Bowatte Ayurveda tea is a ayurveda medicine.It gives healty life");
        } else if (code == 7) {
            System.out.println("Cino advance tea control Obesity,To reduce the absorption of fat taken with food, To control cholesterol levels");
        } else if (code == 8) {
            System.out.println("Slim weight loss tea help the body release toxins. help burn more calories.");
        } else if (code == 9) {
            System.out.println("Hibiscus tea Protects with antioxidants. The hibiscus plant is rich in antioxidants");
        } else if (code == 10) {
            System.out.println("Honey lemon ginger tea gives Heart Health Advantages and it helps to skin protect.");
        } else if (code == 11) {
            System.out.println("coffee tea helps to reduce your sleeping.");
        } else if (code == 12) {
            System.out.println("lemon tea  helps to skin protect.");
        } else if (code == 13) {
            System.out.println("yummy tea is the most taste tea.");
        } else if (code == 14) {
            System.out.println("Tummy tea helps to reduce your fat.");
        } else if (code == 15) {
            System.out.println("Sweet tea gives Heart Health Advantages .");
        } else {
            System.out.println("Please check your product code again.Thank you");
        }
        System.out.println();
    }
    public static  void Totalcost() {
        System.out.println("How many number of packets do you need? ");
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        if (count <= 10000) {

            System.out.println("your total cost calculate now");
            System.out.println("Please enter your product code");
            double code  = input.nextDouble();
            if (code == 1) {
                double Totalcost = 2100 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 2) {
                double Totalcost = 2050 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 3) {
                double Totalcost = 1930 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 4) {
                double Totalcost = 1890 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 5) {
                double Totalcost = 1650 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 6) {
                double Totalcost = 1550 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 7) {
                double Totalcost = 1400 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 8) {
                double Totalcost = 1300 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 9) {
                double Totalcost = 1200 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 10) {
                double Totalcost = 1100 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 11) {
                double Totalcost = 1050 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 12) {
                double Totalcost = 900 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 13) {
                double Totalcost = 600 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 14) {
                double Totalcost = 300 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else if (code == 15) {
                double Totalcost = 200 * count;
                System.out.println("Total cost : " + Totalcost);
                System.out.println("you can get your order now");
            } else {
                System.out.println("Please check your code again");
            }


        } else {
            System.out.println("we generally issue 10000 packet for each product code but if you need more than 10000 packets please try another product code.");
        }

        System.out.println();

        System.out.println("Thank you come again");
    }


}

