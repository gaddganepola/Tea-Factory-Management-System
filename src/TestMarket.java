public class TestMarket {
    public static void main(String[] args) {

            //declaration and initialization local market object
            localMarket LMP001 = new localMarket("P001","NO 3",5000,540,380,200,2.50);

            LMP001.setReturnQuantity(205);
            LMP001.setQuality("NO 4");
            LMP001.setProductPrice(600);
            System.out.println("Product cost : " +LMP001.getProductCost());
            System.out.println("Quantity : " +LMP001.getQuantity());
            System.out.println("Product cost : " +LMP001.getProductCost());
            System.out.println("Value : " +LMP001.calValue());
            System.out.println("Product cost value : " +LMP001.calProductCost());
            System.out.println("Value of return products : " +LMP001.calReturnValue());
            System.out.println("Profit : " +LMP001.profit());
            System.out.println("Sales of product : " +LMP001.sales());
            System.out.println("Demand of the product : " +LMP001.findDemand());

            System.out.println(LMP001.toString());
            localMarket LMP002 = new localMarket();
            LMP002.getInputs();
            System.out.println(LMP002.toString());

            //create a foreign market object
            foreignMarket FMP009 = new foreignMarket("P009","NO 1",2000,1790,1000,57,1000,30);
            System.out.println(FMP009.toString());
        }


}
