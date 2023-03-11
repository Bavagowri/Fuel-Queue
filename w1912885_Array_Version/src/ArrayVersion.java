import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class ArrayVersion {
    public static void main (String[] args) {
        String [] queue1 = new String [6];
        //To assign all elements as empty in an array
        Arrays.fill(queue1, "Empty");
        String [] queue2 = new String [6];                //Creating 3 arrays to manage the queue
        //To assign all elements as empty in an array
        Arrays.fill(queue2, "Empty");
        String [] queue3 = new String [6];
        //To assign all elements as empty in an array
        Arrays.fill(queue3, "Empty");

        int fuelStock=6600;             //fuel stock value
        int empty=0;                    //To count the empty slots in a queue

        System.out.print(displayMessage());   //Calling the method to display the messages inside it

        while (true) {                                                           //To run till user input EXT

            Scanner input = new Scanner(System.in);
            System.out.println("\n");
            System.out.print("Select a button to perform operation: "); //To select a menu option
            String selectedPrompt = input.nextLine();

            if ( selectedPrompt.equals("EXT")) {    //To exit the program if EXT is entered
                System.out.print("End of the process! Thankyou bye!");
                break;
            }

            switch (selectedPrompt) {        //To perform the respective task when a button is selected
                case "VFQ":
                    System.out.println("\n queue1");
                    allFuelQueue(queue1);
                    System.out.println("\n queue2");
                    allFuelQueue(queue2);        //to view all fuel que in once the menu selected
                    System.out.println("\n queue3");
                    allFuelQueue(queue3);

                    break;
                case "VEQ":
                    System.out.println("queue1");
                    empty = emptyQueues(queue1, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue1 is = " + empty);  //to display the empty slot count
                    empty=0;             //To intialize empty value to 0
                    System.out.println("queue2");
                    empty = emptyQueues(queue2, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue2 is = " + empty);  //to display the empty slot count
                    empty=0;                    //To intialize empty value to 0
                    System.out.println("queue3");
                    empty = emptyQueues(queue3, empty); //To assign the return vale
                    System.out.println("Empty slots in the queue3 is = " + empty);  //to display the empty slot count
                    break;

                case "ACQ":
                    try {                                                    //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3): ");
                        int queueNo = input.nextInt();
                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                fuelStock = addCustomerToQueue(queue1, fuelStock);
                                break;
                            case 2:
                                System.out.println("queue2");
                                fuelStock = addCustomerToQueue(queue2, fuelStock);
                                break;
                            case 3:
                                System.out.println("queue3");
                                fuelStock = addCustomerToQueue(queue3, fuelStock);
                                break;
                            default:
                                System.out.println("Queue number is invalid start again! Select a menu option again");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Queue number is invalid it must be a integer");
                    }
                    break;

                case "RCQ":
                    try {                                                  //To validate the queue no
                        System.out.print("Select a Queue no (1,2,3): ");
                        int queueNo = input.nextInt();

                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                fuelStock = removeCustomerInQueue(queue1, fuelStock);

                                break;
                            case 2:
                                System.out.println("queue2");
                                fuelStock = removeCustomerInQueue(queue2, fuelStock);
                                break;
                            case 3:
                                System.out.println("queue3");
                                fuelStock = removeCustomerInQueue(queue3, fuelStock);
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
                        System.out.print("Select a Queue no (1,2,3): ");
                        int queueNo = input.nextInt();
                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                removeCustomerServed(queue1);
                                break;
                            case 2:
                                System.out.println("queue2");
                                removeCustomerServed(queue2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                removeCustomerServed(queue3);
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
                        System.out.print("Select a Queue no (1,2,3): ");
                        int queueNo = input.nextInt();

                        switch (queueNo) {
                            case 1:
                                System.out.println("queue1");
                                alphabeticalSorting(queue1);

                                break;
                            case 2:
                                System.out.println("queue2");
                                alphabeticalSorting(queue2);
                                break;
                            case 3:
                                System.out.println("queue3");
                                alphabeticalSorting(queue3);
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
                        storeProgram(queue1,queue2,queue3,fuelStock);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "LPD":
                    try {
                        storeProgram(queue1,queue2,queue3,fuelStock);
                        loadProgram();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "STK":
                    System.out.println("Fuel Stock available is " + viewFuelStock(fuelStock));
                    break;

                case "AFS":
                    addFuelStock(fuelStock);
                    //System.out.println("Fuel available in stock after adding new stock = "+newStock );
                    break;

                default:
                    System.out.println("Selected menu option is not valid!! Try again.");

            }
        }
    }
    public static int lengthOfArray(String[] fuelQueue){
        int lengthOfQueue=0;
        for (String lent : fuelQueue){
            if (!(lent.equals("Empty"))){     //To count the no of elements in fuel queue when only element is !="empty"
                lengthOfQueue += 1;
            }
        }
        return lengthOfQueue;
    }

    public static int addCustomerToQueue(String [] fuelQueue, int supply) {
        int temp = lengthOfArray(fuelQueue); //to check whether queue is full
        if (temp == fuelQueue.length) {
            System.out.println("The queue is full! Try another queue!");
        }
        int i = 0;
            while (i < fuelQueue.length) {
                if (fuelQueue[i] == null || fuelQueue[i].equals("Empty")) {
                    if (supply == 500) {
                        System.out.println("WARNING! The stock has reached to 500l");
                        break;
                    }
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the name of the customer to add to the queue: ");
                    String name = input.nextLine();
                    while (name.equals("")) {                            //To make sure user entering a name without skipping
                        System.out.print("You cannot skip without entering the name!\n");
                        System.out.print("Enter the name of the customer to add to the queue: ");
                        name = input.nextLine();
                        fuelQueue[i] = name;
                    }
                    if (!(name.equals(""))) {                      //if name is entered the name it will be added to the queue
                        fuelQueue[i] = name;
                    }
                    supply -= 10;

                    System.out.println("Customer " + fuelQueue[i] + " added to the selected queue!");
                    break;
                }
                i += 1;
            }
        return supply;
    }

    public static void allFuelQueue(String [] fuelQueue)
    {
        for (int i=0; i<fuelQueue.length; i++)
        {

            System.out.println("number "+(i+1)+" in the queue is "+fuelQueue[i]);

        }
    }
    public static int emptyQueues(String [] fuelQueue,int count)
    {
        int i=0;

        while ( i<fuelQueue.length)
        {
            if (fuelQueue[i].equals("Empty"))
            {
                System.out.println("number "+(i+1)+" in the queue is "+fuelQueue[i]);
                count+=1;
            }
            else
            {
                System.out.println("number "+(i+1)+" in the queue is assigned to a customer");

            }
            i+=1;

        }
        return count;


    }

    public static void addFuelStock(int stock)
    {
        if (stock==500)
        {
            int used =6600 - stock;
            stock = used + stock;
            System.out.println("Fuel Stock available is "+used);
            System.out.println("Fuel Stock available after restocking is "+stock);

        }
        else if (stock<6600){
            System.out.println("Cannot restock till the available fuel reaches 500 liter");
        }
    }

    public static int viewFuelStock(int stockIn)
    {
        return stockIn;
    }

    public static int removeCustomerInQueue(String [] fuelQueue, int supply)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the customer number in the queue: ");
        int removeindex=input.nextInt();
        while (!((removeindex-1<fuelQueue.length)&&(removeindex-1>=0))){                            //To make sure user entering a name without skipping
            System.out.print("The customer number in the queue is not valid!\n");
            System.out.print("Enter the customer number in the queue: ");
            removeindex=input.nextInt();
        }
        for ( int i=0; i<fuelQueue.length; i++)
        {
            if (i==(removeindex-1))
            {
                if (!(fuelQueue[i].equals("Empty"))){
                    System.out.print("Customer named "+ fuelQueue[i]+" is removed from the queue");
                    fuelQueue[i] = "Empty";
                    for (int k = 0; k < fuelQueue.length; k++)   //To take one string and compare it with others in the array
                    {
                        for (int j = k + 1; j < fuelQueue.length; j++) {
                            if ((fuelQueue[k].equals("Empty")) && (fuelQueue[j] != "Empty")) {
                                fuelQueue[k] = fuelQueue[j];   //to make sure all empty slots are after the entered value
                                fuelQueue[j] = "Empty";
                            }
                        }
                    }
                    supply+=10;
                    System.out.println("Remaining fuel queue incremented by 10 after user removed for some reason ="+supply);
                }
                else if ((fuelQueue[i].equals("Empty")))
                    System.out.println("The number "+removeindex+" in the queue is Empty");
            }
        }
        return supply;
    }
    public static void removeCustomerServed(String [] fuelQueue) {
        for (int i = 0; i < fuelQueue.length; i++) {
            if (!(fuelQueue[i].equals("Empty"))) {
                System.out.print("Customer named " + fuelQueue[i] + " is served and removed from the queue");
                fuelQueue[i] = "Empty";

                break;
            } else if ((fuelQueue[i].equals("Empty"))) {
                System.out.print("The Queue is empty!");
                break;
            }
        }
        for (int i = 0; i < fuelQueue.length; i++)   //To take one string and compare it with others in the array
        {
            for (int j = i + 1; j < fuelQueue.length; j++) {
                if ((fuelQueue[i].equals("Empty")) && (fuelQueue[j] != "Empty")) { //swaps only the empty field is before an entered value
                    fuelQueue[i] = fuelQueue[j];         //to make sure all empty slots are after the entered value
                    fuelQueue[j] = "Empty";
                }
            }
        }
    }

    public static void alphabeticalSorting(String [] fuelQueue){
        String temp;
        String [] copyFuelQueue = new String [fuelQueue.length];
        for (int i=0; i<fuelQueue.length; i++)   //coping the original array
        {
            copyFuelQueue[i]=fuelQueue[i]; //changing copyFuelQueue[] to verify that copyFuelQueue [] is different from fuelQueue[]
        }
        for(int i=0; i<copyFuelQueue.length; i++)   //To take one string and compare it with others in the array
        {
            for (int j=i+1; j<copyFuelQueue.length; j++)
            {
                //to compare one name with another
                int compareTo = copyFuelQueue[i].compareTo(copyFuelQueue[j]);
                if (!((copyFuelQueue[i]=="Empty")||(copyFuelQueue[j]=="Empty"))){ //To ensure empty is always coming at last while sorting
                    if ((compareTo >0 )&&(compareTo !=0))
                    {
                        temp=copyFuelQueue[i];               //To swap the small value first in the array
                        copyFuelQueue[i]=copyFuelQueue[j];
                        copyFuelQueue[j]=temp;
                    }
                }
            }
        }
        //print out the array
        System.out.println("The name in Alphabetical order: ");
        for (String s : copyFuelQueue) {       //To print the copy of fuel queue after sorting
            int i=1;   //To print the no of customer
            System.out.println("Customer number "+i+s);
            i++;
        }
    }
    public static void storeProgram(String [] fuelQueue1,String [] fuelQueue2,String [] fuelQueue3,int stock) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\gowry\\Desktop\\IIT_SEM_2\\SD 2 CW\\w1912885_Array_Version\\ouput1.txt"));
        writer.write("Queue 1 :");
        int i=1;
        for (String s : fuelQueue1) {
            writer.append("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;
        writer.write("\n \nQueue 2 :");
        for (String s : fuelQueue2) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;
        writer.write("\n \nQueue 3 :");
        for (String s : fuelQueue3) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        writer.write("\n\nThe fuel stock available is :"+stock);
        writer.close();

    }
    public static void loadProgram() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gowry\\Desktop\\IIT_SEM_2\\SD 2 CW\\w1912885_Array_Version\\ouput1.txt"));
        System.out.println("Output loaded from the file created!");
        String line;
        while ((line=reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    static String displayMessage() {
        return"""
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



