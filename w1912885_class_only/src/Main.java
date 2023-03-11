import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int queueNo = 0;
        String[] queue1 = new String[6];
        //To assign all elements as empty in an array
        Arrays.fill(queue1, "Empty");
        int[] noliter1 = new int[6];     //To add the no of liter of petrol for each customer

        String[] queue2 = new String[6];                //Creating 5 arrays to manage the queue
        //To assign all elements as empty in an array
        Arrays.fill(queue2, "Empty");
        int[] noliter2 = new int[6];           //To add the no of liter of petrol for each customer

        String[] queue3 = new String[6];
        //To assign all elements as empty in an array
        Arrays.fill(queue3, "Empty");
        int[] noliter3 = new int[6];              //To add the no of liter of petrol for each customer

        String[] queue4 = new String[6];
        //To assign all elements as empty in an array
        Arrays.fill(queue4, "Empty");
        int[] noliter4 = new int[6];                           //To add the no of liter of petrol for each customer

        String[] queue5 = new String[6];
        //To assign all elements as empty in an array
        Arrays.fill(queue5, "Empty");
        int[] noliter5 = new int[6];                               //To add the no of liter of petrol for each customer


        int fuelStock = 6600;             //fuel stock value
        int empty = 0;                    //To count the empty slots in a queue

        System.out.print(displayMessage());   //Calling the method to display the messages inside it

        while (true) {                                                           //To run till user input EXT

            Scanner input = new Scanner(System.in);
            System.out.println("\n");
            System.out.print("Select a button to perform operation: "); //To select a menu option
            String selectedPrompt = input.nextLine();

            if (selectedPrompt.equals("EXT")) {    //To exit the program if EXT is entered
                break;
            }

            switch (selectedPrompt) {        //To perform the respective task when a button is selected
                case "VFQ":
                    System.out.println("\n queue1");
                    FuelQueue.allFuelQueue(queue1);
                    System.out.println("\n queue2");
                    FuelQueue.allFuelQueue(queue2);        //to view all fuel que in once the menu selected
                    System.out.println("\n queue3");
                    FuelQueue.allFuelQueue(queue3);
                    System.out.println("\n queue4");
                    FuelQueue.allFuelQueue(queue4);
                    System.out.println("\n queue5");
                    FuelQueue.allFuelQueue(queue5);
                    break;
                case "VEQ":
                    //To view all empty queues
                    System.out.println("queue1");
                    empty = FuelQueue.emptyQueues(queue1, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue1 is = " + empty);  //to display the empty slot count
                    empty=0;             //To intialize empty value to 0
                    System.out.println("queue2");
                    empty = FuelQueue.emptyQueues(queue2, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue2 is = " + empty);  //to display the empty slot count
                    empty=0;                    //To intialize empty value to 0
                    System.out.println("queue3");
                    empty = FuelQueue.emptyQueues(queue3, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue3 is = " + empty);  //to display the empty slot count
                    empty=0;          //To intialize empty value to 0
                    System.out.println("queue4");
                    empty = FuelQueue.emptyQueues(queue4, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue4 is = " + empty);  //to display the empty slot count
                    empty=0;     //To intialize empty value to 0
                    System.out.println("queue5");
                    empty = FuelQueue.emptyQueues(queue5, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue5 is = " + empty);  //to display the empty slot count
                    break;

                case "RCQ":
                    try {                                                  //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3,4,5): ");
                        queueNo = input.nextInt();

                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                fuelStock = FuelQueue.removeCustomerInQueue(queue1, fuelStock,noliter1);

                                break;
                            case 2:
                                System.out.println("queue2");
                                fuelStock = FuelQueue.removeCustomerInQueue(queue2, fuelStock,noliter2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                fuelStock = FuelQueue.removeCustomerInQueue(queue3, fuelStock,noliter3);
                                break;
                            case 4:
                                System.out.println("queue4");
                                fuelStock = FuelQueue.removeCustomerInQueue(queue4, fuelStock,noliter4);
                                break;
                            case 5:
                                System.out.println("queue5");
                                fuelStock = FuelQueue.removeCustomerInQueue(queue5, fuelStock,noliter5);
                                break;
                            default:
                                System.out.println("Queue number is invalid start again!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Queue number is invalid it must be a integer");
                    }
                    break;

                case "PCQ":
                    try {                                                    //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3,3,4,5): ");
                        queueNo = input.nextInt();
                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                FuelQueue.removeCustomerServed(queue1);
                                break;
                            case 2:
                                System.out.println("queue2");
                                FuelQueue.removeCustomerServed(queue2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                FuelQueue.removeCustomerServed(queue3);
                                break;
                            case 4:
                                System.out.println("queue4");
                                FuelQueue.removeCustomerServed(queue4);
                                break;
                            case 5:
                                System.out.println("queue5");
                                FuelQueue.removeCustomerServed(queue5);
                                break;
                            default:
                                System.out.println("Queue number is invalid start again!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Queue number is invalid it must be a integer");
                    }
                    break;

                case "VCS":
                    try {                                                     //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3,4,5): ");
                        queueNo = input.nextInt();

                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                FuelQueue.alphabeticalSorting(queue1);

                                break;
                            case 2:
                                System.out.println("queue2");
                                FuelQueue.alphabeticalSorting(queue2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                FuelQueue.alphabeticalSorting(queue3);
                                break;
                            case 4:
                                System.out.println("queue4");
                                FuelQueue.alphabeticalSorting(queue4);
                                break;
                            case 5:
                                System.out.println("queue5");
                                FuelQueue.alphabeticalSorting(queue5);
                                break;
                            default:
                                System.out.println("Queue number is invalid start again!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Queue number is invalid it must be a integer");
                    }
                    break;

                case "SPD":
                    try {                                         // To find if any error occurs
                        FuelQueue.storeProgram(queue1, queue2, queue3,queue4,queue5, fuelStock);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "LPD":
                    try {                                  // To find if any error occurs
                        FuelQueue.loadProgram();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "STK":
                    System.out.println("Fuel Stock available is " + FuelQueue.viewFuelStock(fuelStock));
                    break;
                case "AFS":
                    FuelQueue.addFuelStock(fuelStock);
                    //System.out.println("Fuel available in stock after adding new stock = "+newStock );
                    break;

                case "IFQ":
                    try {                                                     //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3,4,5): ");
                        queueNo = input.nextInt();
                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                FuelQueue.calculateIncome(noliter1);
                                break;
                            case 2:
                                System.out.println("queue2");
                                FuelQueue.calculateIncome(noliter2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                FuelQueue.calculateIncome(noliter3);
                                break;
                            case 4:
                                System.out.println("queue4");
                                FuelQueue.calculateIncome(noliter4);
                                break;
                            case 5:
                                System.out.println("queue5");
                                FuelQueue.calculateIncome(noliter5);
                                break;
                            default:
                                System.out.println("Queue number is invalid start again!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Queue number is invalid it must be a integer");
                    }
                    break;
                case "ACQ":
                    queueNo = FuelQueue.miniLengthArray(queue1, queue2, queue3, queue4, queue5);
                    switch (queueNo) {
                        case 1:
                            int temp = FuelQueue.lengthOfArray(queue1); //to check whether queue is full
                            if (temp == queue1.length) {
                                System.out.println("The queue is full! Try another queue!"); //to output the message if all queue are full
                            }
                            else{
                                System.out.println("queue1");
                                fuelStock = FuelQueue.addCustomerToQueue(queue1, fuelStock, noliter1);
                            }
                            break;
                        case 2:
                            System.out.println("queue2");
                            fuelStock = FuelQueue.addCustomerToQueue(queue2, fuelStock, noliter2);
                            break;
                        case 3:
                            System.out.println("queue3");
                            fuelStock = FuelQueue.addCustomerToQueue(queue3, fuelStock, noliter3);
                            break;
                        case 4:
                            System.out.println("queue4");
                            fuelStock = FuelQueue.addCustomerToQueue(queue4, fuelStock, noliter4);
                            break;
                        case 5:
                            System.out.println("queue5");
                            fuelStock = FuelQueue.addCustomerToQueue(queue5, fuelStock, noliter5);
                            break;
                default:
                    System.out.println("Selected menu option is not valid!! Try again.");
                    break;

                    }
            }
        }
    }
        static String displayMessage () {
            return """
                    Console Menu
                                
                    VFQ: View all Fuel Queues.
                    VEQ: View all Empty Queues.
                    ACQ: Add customer to a Queue.
                    RCQ: Remove a customer from a Queue.
                    PCQ: Remove a served customer.
                    VCS: View Customers Sorted in alphabetical order.
                    SPD: Store Program Data into file.
                    LPD: Load Program Data from file.
                    STK: View Remaining Fuel Stock.
                    AFS: Add Fuel Stock.
                    EXT: Exit the Program.""";
        }

}
