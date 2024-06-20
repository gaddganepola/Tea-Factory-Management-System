import java.util.Date;
public class TestSupplier {

    public static void main(String[] args) {

        teaLeavesSupplier.setUnitPrice(80);

        //create tea supplier object
        teaLeavesSupplier TS001 = new teaLeavesSupplier("T001","Shiwarajan","0718966417",540,2);
        System.out.println(TS001.print());
        teaLeavesSupplier TS002 = new teaLeavesSupplier("T002","Aarav","0754119845",650,1);
        System.out.println(TS002.print());
        teaLeavesSupplier TS003 = new teaLeavesSupplier("T003","Gunasekara","0778955126",150,3);
        System.out.println(TS003.print());

        System.out.println(TS002.payment());
        System.out.println(TS001.quantity);


        //declare array to store ingredients supplier
        ingredientsSupplier[] IN00 = new ingredientsSupplier[20];

        IN00[0] = new ingredientsSupplier("IN000","Kamal","0758009658",100,"packets");
        IN00[1] = new ingredientsSupplier("IN001","Aamal","0768009658",80,"bag");
        IN00[2] = new ingredientsSupplier("IN002","Bimal","0778009658",110,"packets");
        IN00[3] = new ingredientsSupplier("IN003","Nimal","0718009658",105,"bag");
        IN00[4] = new ingredientsSupplier("IN004","Samal","0708009658",195,"packets");

        ingredientsSupplier.find("bag",IN00);

        IN00[1].order("IN001",100);
        IN00[3].order();



        System.out.println(IN00[1].print());
        System.out.println(IN00[4].print());
        System.out.println(IN00[3].print());

        //declare array to store fertilizer supplier objects
        fertilizerSupplier[] FE00 = new fertilizerSupplier[20];

        FE00[0] = new fertilizerSupplier("FE000","Mohomad","0741365795",450,"UT752");
        FE00[1] = new fertilizerSupplier("FE001","Namal","0771368457",500,"UT834");
        FE00[2] = new fertilizerSupplier("FE002","Sujith","0701487256",800,"UT562");
        FE00[3] = new fertilizerSupplier("FE003","Kumara","0707499816",420,"UT752");
        FE00[4] = new fertilizerSupplier("FE004","Akila","0758006947",450,"UT752");
        FE00[5] = new fertilizerSupplier("FE005","Bandara","0712599847",490,"UT834");

        //fertilizerSupplier.find("UT834",FE00);

        FE00[5].order("FE005",500);

        FE00[0].order();
        System.out.println(FE00[5].print());
        System.out.println(FE00[4].print());
        System.out.println(FE00[1].print());
        System.out.println(FE00[0].print());



    }
}
