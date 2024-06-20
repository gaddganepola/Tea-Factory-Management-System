
public class TestEmployee {

    public static void main(String[] args) {
        Manager  factoryManager = new Manager(123,"Asanka Perera",5);
        factoryManager.setEmpSalary(35000);
        Labor factoryLabor1 = new FactoryLabor(258,"Champika Ranasinghe",20);
        FactoryLabor factoryLabor2 = new FactoryLabor(186,"Sunil Jayalath",8);
        factoryManager.recruitLabor(factoryLabor1);
        factoryManager.recruitLabor(factoryLabor2);


        factoryManager.startWork();
        factoryManager.setWorkingHours(7.5);
        factoryManager.finishWork();
        factoryManager.calculateSalaries();


        System.out.println();                   //To get a single line space between the details of  Factory Labor and Estate Labors

        Manager estateManager = new Manager(1201,"Saman Rathnayaka",10);
        estateManager.setEmpSalary(45000);
        Labor estateLabor1 = new EstateLabor(675,"Nimal Edirisinghe",3);
        EstateLabor estateLabor2 = new EstateLabor(791,"Sujeewa Perera",7);

        estateManager.recruitLabor(estateLabor1);
        estateManager.recruitLabor(estateLabor2);

        estateManager.startWork();
        System.out.println("============\n\n");
        estateManager.setWorkingHours(8.9);
        estateManager.finishWork();
        System.out.println("============\n\n");
        estateManager.resignEmployee(estateLabor2);
        System.out.println("============\n\n");

        estateManager.calculateSalaries();


        factoryLabor2.promotion();
    }
}
