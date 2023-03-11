import java.io.*;
import java.util.Scanner;

public class FuelQueue {

    public static int lengthOfArray(String[] fuelQueue) {
        int lengthOfQueue = 0;
        for (String lent : fuelQueue) {
            if (!(lent.equals("Empty"))) {     //To count the no of elements in fuel queue when only element is !="empty"
                lengthOfQueue += 1;
            }
        }
        return lengthOfQueue;
    }

    public static int miniLengthArray(String[] fuelQueue1, String[] fuelQueue2, String[] fuelQueue3, String[] fuelQueue4, String[] fuelQueue5) {
        int len[] = new int[5];
        int i = 0;
        int queueno = 0;
        len[i] = lengthOfArray(fuelQueue1);
        i++;
        len[i] = lengthOfArray(fuelQueue2);
        i++;
        len[i] = lengthOfArray(fuelQueue3);
        i++;
        len[i] = lengthOfArray(fuelQueue4);
        i++;
        len[i] = lengthOfArray(fuelQueue5);

        int smallLen = len[4];           //To assume that smallest element is in 0th index
        for (int k = 4; k >= 0; k--) {
            if (len[k] < smallLen) {
                smallLen = len[k];
                queueno = k + 1;
            } else if ((smallLen == len[k]) && (len[k] <= 6)) {
                smallLen = len[k];
                queueno = k + 1;
            }
        }
        return queueno;
    }

    public static int addCustomerToQueue(String[] fuelQueue, int supply, int[] noliters) {
        String name = null;
        String lName = null;
        int requiredAmount = 0;
        passengers p1 = new passengers();
        name = p1.getFirstName();
        lName = p1.getSecondName();
        String vNum = p1.getVechicleNo();
        requiredAmount = p1.getPetrolRequired();
        while (requiredAmount <= 0) {
            requiredAmount = p1.getPetrolRequired();
        }
        int i = 0;
        while (i < fuelQueue.length) {
            if (fuelQueue[i] == null || fuelQueue[i].equals("Empty")) {
                if (supply == 500) {
                    System.out.println("WARNING! The stock has reached to 500l");
                    System.out.println("Customer " + fuelQueue[i] + " is NOT added to the queue!");
                    break;
                } else if (!(name.equals(""))) {                      //if name is entered the name it will be added to the queue
                    fuelQueue[i] = name + " " + lName;
                    supply -= requiredAmount;
                    noliters[i] = requiredAmount;
                }

                System.out.println("Customer " + fuelQueue[i] + " is added to the queue!");
                break;
            }
            i += 1;
        }
        CircularQueue waiting = new CircularQueue();
        if (fuelQueue.length <= i) {
            waiting.insertToWaiting(name);
            System.out.println("Customer is added to the Waiting queue!");
            waiting.insertNoOfLiter(requiredAmount);
        }
        return supply;

    }


    public static void viewWaitingQueue() {
        CircularQueue waiting = new CircularQueue();
        waiting.showWaitQueue();
        waiting.showPetrolQueue();
    }

    public static void allFuelQueue(String[] fuelQueue) {
        for (int i = 0; i < fuelQueue.length; i++)    //to view all Fuel queues
        {
            System.out.println("number " + (i + 1) + " in the queue is " + fuelQueue[i]);
        }
    }

    public static int emptyQueues(String[] fuelQueue, int count) {
        int i = 0;                                                 //To view all empty queues and count the empty slot value

        while (i < fuelQueue.length) {
            if (fuelQueue[i].equals("Empty")) {
                System.out.println("number " + (i + 1) + " in the queue is " + fuelQueue[i]);
                count += 1;
            } else {
                System.out.println("number " + (i + 1) + " in the queue is assigned to a customer");

            }
            i += 1;

        }
        return count;


    }

    public static void addFuelStock(int stock) {
        if (stock == 500)                 //to add new fuel stock if only it reaches minimum value
        {
            int used = 6600 - stock;
            stock = used + stock;
            System.out.println("Fuel Stock available is " + used);
            System.out.println("Fuel Stock available after restocking is " + stock);

        } else if (stock < 6600) {           //to not add fuel stock if its greater than 500l
            System.out.println("Cannot restock till the available fuel reaches 500 liter");
        }
    }

    public static int viewFuelStock(int stockIn) {
        return stockIn;
    }   //to print the remaining stock of fuel

    public static int removeCustomerInQueue(String[] fuelQueue, int supply, int[] noliters)      //removes a particular customer
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the customer number in the queue: ");
        int removeindex = input.nextInt();
        while (!((removeindex < 6) && (removeindex >= 0))) {                            //To make sure user entering a name without skipping
            System.out.print("The customer number in the queue is not valid!\n");
            System.out.print("Enter the customer number in the queue: ");
            removeindex = input.nextInt();
        }
        for (int i = 0; i < fuelQueue.length; i++) {
            if (i == (removeindex - 1)) {
                if (!(fuelQueue[i].equals("Empty"))) {
                    System.out.print("Customer named " + fuelQueue[i] + " is removed from the queue");
                    fuelQueue[i] = fuelQueue[i + 1];
                    fuelQueue[i + 1] = "Empty";
                    for (int j = i; j < fuelQueue.length; j++) {
                        for (int k = j + 1; k < fuelQueue.length; k++) {
                            if ((fuelQueue[j].equals("Empty")) && (!(fuelQueue[k].equals("Empty")))) {
                                fuelQueue[j] = fuelQueue[k];
                                fuelQueue[k] = "Empty";
                            }
                        }
                    }
                    supply += noliters[i];
                    noliters[i] = noliters[i + 1];
                    noliters[i + 1] = 0;
                    break;
                }
            } else if ((fuelQueue[i].equals("Empty"))) {
                System.out.print("The number " + removeindex + " in the queue is Empty");
                break;
            }
        }
        return supply;
    }

    public static void addCustomerFromWaitingQueue(String[] fuelQueue, int [] noOfLiterArray) {
        CircularQueue waiting = new CircularQueue();    //to access the circular queue class
        String temp = waiting.remove();
        int temp1 = waiting.removeNoOfLiterInArray();
        //if (waiting.queueArray.length > 0) {
        int i = lengthOfArray(fuelQueue);
        fuelQueue[i] = temp;
        noOfLiterArray[i] = temp1;
    }

    public static void removeCustomerServed(String [] fuelQueue,int supply, int[] noliters) {
        for (int i = 0; i < fuelQueue.length; i++) {
            if (!(fuelQueue[i].equals("Empty"))) {
                System.out.print("Customer named " + fuelQueue[i] + " is served and removed from the queue");
                fuelQueue[i] = "Empty";
                fuelQueue[i]=fuelQueue[i+1];
                fuelQueue[i+1]="Empty";

                for (int j=i; j<fuelQueue.length; j++){
                    for (int k=j+1;k<fuelQueue.length; k++){
                        if ((fuelQueue[j].equals("Empty"))&&(!(fuelQueue[k].equals("Empty")))){   //to update the fuel queue
                            fuelQueue[j]=fuelQueue[k];
                            fuelQueue[k]="Empty";
                        }
                    }
                }
                noliters[i] = noliters[i + 1];        //to update the petrol queue
                noliters[i + 1] = 0;
                for (int j=i; j<noliters.length; j++){
                    for (int k=j+1;k<noliters.length; k++){
                        if ((noliters[j]==0)&&(noliters[k]!=0)){
                            noliters[j]=noliters[k];
                            noliters[k]=0;
                        }
                    }
                }
                addCustomerFromWaitingQueue(fuelQueue,noliters);
                break;
            }
            else if ((fuelQueue[i].equals("Empty"))) {
                System.out.print("The Queue Slot is empty!");
                break;
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
    public static void storeProgram(String [] fuelQueue1,String [] fuelQueue2,String [] fuelQueue3,String [] fuelQueue4,String [] fuelQueue5,int stock) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("w1912885_class_only\\ouput1.txt"));
        writer.write("Queue 1 :");
        int i=1;                            //To get the customer's number of position in queue
        for (String s : fuelQueue1) {
            writer.append("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;                                   //To get the customer's number of position in queue
        writer.write("\n \nQueue 2 :");
        for (String s : fuelQueue2) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;                                     //To get the customer's number of position in queue
        writer.write("\n \nQueue 3 :");
        for (String s : fuelQueue3) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;                                         //To get the customer's number of position in queue
        for (String s : fuelQueue4) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        i=1;                                       //To get the customer's number of position in queue
        for (String s : fuelQueue5) {
            writer.write("\n Customer no"+i+" = "+s);
            i++;
        }
        writer.write("\n\nThe fuel stock available is :"+stock);
        writer.close();

    }
    public static void loadProgram() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("w1912885_class_only\\ouput1.txt"));
        System.out.println("Output loaded from the file created!");
        String line;
        while ((line=reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    public static void calculateIncome (int [] noliters){     //to calculate the income of each fuel queue
        int temp=0;
        for (int i=0; i<noliters.length; i++){            //gets the noofliters array of particular queue and calculates the income
            temp+= noliters[i];
        }
        int income =temp*430;
        System.out.println("income for this queue is = "+income);
    }

}
