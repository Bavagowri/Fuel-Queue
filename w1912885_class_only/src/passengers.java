import java.util.InputMismatchException;
import java.util.Scanner;

public class passengers {

        public String FirstName;
        public String SecondName;
        public String VechicleNo;
        public int NoOfLitersRequired;

        public String getFirstName(){
            Scanner input = new Scanner (System.in);
            System.out.print("Enter the name of the customer to add to the queue: ");
            FirstName=input.nextLine();
            while (FirstName.equals("")){                            //To make sure user entering a name without skipping
                System.out.print("You cannot skip without entering the name!\n");
                System.out.print("Enter the name of the customer to add to the queue: ");
                FirstName=input.nextLine();
            }
            return FirstName;
        }
    public String getSecondName(){
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the last name of the customer : ");
        SecondName=input.nextLine();
        while (SecondName.equals("")){                            //To make sure user entering a name without skipping
            System.out.print("You cannot skip without entering the last name!\n");
            System.out.print("Enter the last name of the customer : ");
            SecondName=input.nextLine();
        }
        return SecondName;
    }
    public String getVechicleNo(){
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the vechicle number of the customer : ");
        VechicleNo=input.nextLine();
        return VechicleNo;
    }
    public int getPetrolRequired(){
        try{
            Scanner sc1 = new Scanner (System.in);              //to validate the input if its integer
            System.out.print("Enter the no of liters of petrol required : ");
            NoOfLitersRequired=sc1.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Please enter numeric value!");
        }
        return NoOfLitersRequired;
    }

    }

