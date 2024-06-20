/*Date : 4/13/2022.
        ***************************************************************************************************************************
        "Hopping use below short terms of varibles in this programming"
        ***************************************************************************************************************************
NOL = Number of labors working in the estate.
        NOM = Number of managers working in the estate.
        NOS = Number of superintendents working in the estate.

        NUM = Number of days each labors works.
MSOM = Monthly salary of the manager.
        MSOS = Monthly salary of the estate superintendent.
DSOL = Daly salary of the labor.
        NODLW = Number of days one labor worked for month.
        p_cost_E_D = What is the production cost of each department in the estate.
        T_income = What is the total income of production.
        OT_rate = What is the overtime rate of each labor.
last_T_income = Last year income in the production.
A = T_income - last_T_income.

***********************************************************************************************************************************
*/
import java.util.Scanner;
public class finance {

    public static void main(String[] args)
    {

        total_salary_of_manager();
        total_salary_of_all_superintendents();
        total_salary_of_all_laborers();
        total_production_cost();
        net_income_of_the_poduction();
    }

    public static void total_salary_of_manager()
    {
        Scanner input = new Scanner(System.in);
        double NOM,MSON;
        System.out.println("Enter Number of managers : ");
        NOM = input.nextDouble();
        System.out.println("Input monthly salary of one manager : ");
        MSON = input.nextDouble();
        System.out.println("Total Salary Cost of the all managers : "+ NOM*MSON);

    }

    public static void total_salary_of_all_superintendents()
    {
        Scanner input = new Scanner(System.in);
        double NOS,MSOS;

        System.out.println("Enter Number of superintendents : ");
        NOS = input.nextDouble();
        System.out.println("Input monthly salary of one superintendent : ");
        MSOS = input.nextDouble();

        System.out.println("Total Salary Cost of the all superintendents : "+ NOS*MSOS);
    }
    public static void total_salary_of_all_laborers()
    {
        Scanner input = new Scanner(System.in);
        double NODLW,DSOL,NUM,OT_rate,hour;
        for(int i=0;i<3;i++)
        {
            System.out.println("Enter How many days one labor works : ");
            NODLW = input.nextDouble();
            if(NODLW>25)
            {
                DSOL = 50000.00;
                System.out.println("Enter How many labors works : ");
                NUM = input.nextDouble();
                System.out.println("Enter over time rate : ");
                OT_rate = input.nextDouble();
                System.out.println("Enter How many extra hours works labor : ");
                hour = input.nextDouble();

                System.out.println("Full cost for labors : " + ((DSOL*NUM)+(OT_rate*hour)));

            }
            else if(NODLW>15)
            {
                DSOL = 25000.00;
                System.out.println("Enter How many labors works : ");
                NUM = input.nextDouble();
                System.out.println("Enter over time rate : ");
                OT_rate = input.nextDouble();
                System.out.println("Enter How many extra hours works labor : ");
                hour = input.nextDouble();


                System.out.println("Full cost for labors : " + ((DSOL*NUM)+(OT_rate*hour)));
            }
            else
            {
                DSOL = 15000.00;
                System.out.println("Enter How many labors works : ");
                NUM = input.nextDouble();
                System.out.println("Full cost for labors : " + DSOL*NUM);
            }
        }
    }
    public static void total_production_cost()
    {
        double  p_cost_E_D,sum= 0;
        Scanner input  = new Scanner(System.in);
        //Assume that we have 5 departments in this estate.
        for(int i=0;i<=5;i++)
        {
            System.out.println("Enter your" + (i+1) + "department cost : " );
            p_cost_E_D = input.nextDouble();

            sum += p_cost_E_D;

            //System.out.println("Full cost of all departments : " + sum);
        }
        System.out.println("Full cost of all departments : " + sum);
    }

    public static void net_income_of_the_poduction()
    {
        double T_income,last_T_income,A;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter total income in the production : ");
        T_income = input.nextDouble();

        System.out.println(" Enter the last income in the production : ");

        last_T_income = input.nextDouble();

        A = T_income - last_T_income;
        if(A>0){
            System.out.println("Production Cost is increase by " + A + ".");
        }else {
            System.out.println("Production Cost is decrease by " + A + ".");
        }
    }




}
