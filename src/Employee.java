

/* This is the Employee class
Purpose : To manage information related to the employees of the factory
Date : 25/04/2022
Author : Weerasinghe S.A.
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;

abstract class Employee {			//abstract Parent Class Employee

    // define data members
    private final int empId;
    private String empName;
    private double empSalary;
    private int yearsOfWorking;

    private double workingHours;


    public Employee(int empId,String empName,int yearsOfWorking){
        this.empId=empId;
        this.empName=empName;
        this.yearsOfWorking=yearsOfWorking;
    }


    abstract void startWork();			//Declare abstract methods
    abstract void finishWork();

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public int getYearsOfWorking() {
        return yearsOfWorking;
    }

    public void setEmpSalary(double empSalary) {
        System.out.println(empName+" got Rs."+empSalary+" Salary.");
        this.empSalary = empSalary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}


/*
This is Manager Class
Purpose :  For handling Labor information at the manager level.
*/



class Manager extends Employee {

    List<Labor> labors = new ArrayList<>();

    public Manager(int empId, String empName, int yearsOfWorking) {
        super(empId, empName, yearsOfWorking);
    }


    public void recruitLabor(Labor labor){
        labors.add(labor);
    }

    public void resignEmployee(FactoryLabor factoryLabor){
        System.out.println("Factory Labor "+factoryLabor.getEmpName()+" got resigned");
        labors.remove(factoryLabor);
    }

    public void resignEmployee(EstateLabor estateLabor){
        System.out.println("Estate Labor "+estateLabor.getEmpName()+" got resigned");
        labors.remove(estateLabor);
    }


    @Override
    public void startWork() {
        System.out.println("Manager "+getEmpName()+" ("+ getEmpId()+ ") "+" started the work for the day at :"+new Date().toString());
        for (Labor labor:labors){
            labor.startWork();
        }
    }

    @Override
    public void finishWork() {
        System.out.println(getEmpName()+" finished the work for the day after :"+getWorkingHours()+" hours as a manager.");
        for (Labor labor:labors){
            labor.finishWork();
        }
    }

    public void setWorkingHours(double workingHours){
        super.setWorkingHours(workingHours);
        for (Labor labor:labors){
            labor.setWorkingHours(workingHours);
        }
    }

    public void calculateSalaries(){
        for (Labor labor:labors){
            labor.calculateSalary();
        }
    }
}











/*
The Labor Class
Purpose : To handle common tasks common to both factory labors and the estate labor
*/

abstract class Labor extends Employee{

    protected final double salaryPerDay = 1000;

    protected final double GeneralWorkingHoursPerDay = 8;

    public final double OT_payRatePerHour = 0.1;              // 10% increase for each additional hour of working

    public Labor(int empId, String empName, int yearsOfWorking) {
        super(empId, empName, yearsOfWorking);
    }


    public void calculateSalary(){
        if( getWorkingHours() <=8 ){
            System.out.println(getEmpName()+" is not eligible for additional payment");
            setEmpSalary(salaryPerDay);
        }else{
            setEmpSalary(salaryPerDay + ((getWorkingHours()-GeneralWorkingHoursPerDay)*salaryPerDay*OT_payRatePerHour));
        }
    }

}












/*
FactoryLabor class
Purpose : To handle specific tasks related to the labors work at the factory
*/


class FactoryLabor extends Labor {

    public FactoryLabor(int empId, String empName, int yearsOfWorking) {
        super(empId, empName, yearsOfWorking);
    }

    @Override
    public void startWork() {
        System.out.println("The Factory Labor "+getEmpName()+ "("+ getEmpId()+") started the work for the day at :"+new Date().toString());
    }

    @Override
    public void finishWork() {
        System.out.println("The Factory Labor "+getEmpName()+"("+ getEmpId()+") finished the work for the day after "+getWorkingHours());
    }


    public void promotion(){
        if(getYearsOfWorking()<5){
            System.out.println(getEmpName()+ " is not eligible for a promotion.");
        }else if(getWorkingHours() <= 10){
            System.out.println(getEmpName()+" is promoted for the Labor Supervisor Level3");
        }else if(getWorkingHours() <=20){
            System.out.println(getEmpName()+ "is promoted for the Labor Supervisor Level2");
        }else if(getWorkingHours() > 20){
            System.out.println(getEmpName()+ "is promoted for the Labor Supervisor Level1");
        }
    }
}






/*
Estate Labor Class
Purpose : To handle specific tasks related to the Labors work on the tea estate.
*/



class EstateLabor extends Labor {

    public final double OT_payRatePerHour = 0.2;              // 20% increase for each additional hour of working
    private static final String sectionOfWorking = "The Tea Estate";

    public EstateLabor(int empId, String empName, int yearsOfWorking) {
        super(empId, empName, yearsOfWorking);
    }

    @Override
    public void calculateSalary(){
        if( getWorkingHours() <=8 ){
            System.out.println(getEmpName()+ " is not eligible for additional payment");
            setEmpSalary(salaryPerDay);
        }else{
            setEmpSalary( salaryPerDay + ((getWorkingHours()-GeneralWorkingHoursPerDay)*salaryPerDay*OT_payRatePerHour));
        }
    }

    @Override
    public void startWork() {
        System.out.println(getEmpName()+" started the work for the day at :"+new Date().toString()+" as a "+sectionOfWorking+" labor.");
    }

    @Override
    public void finishWork() {
        System.out.println(getEmpName()+" finished the work for the day after "+getWorkingHours()+" hours as a "+sectionOfWorking+" labor.");
    }
}
