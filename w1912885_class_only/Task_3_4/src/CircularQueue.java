public class CircularQueue {
    static int maxSize=20;       // size of the array
    static String[] queueArray= new String [20];    //To store waiting customer name
    static int start=0;     //refer to the 1st element in the queueArray      //TO perform circular queue array
    static int end=-1;     //refer to the last element in the queueArray
    static int nOfItems;   //to find the no of items in the queueArray
    static int[] noOfLiterArray= new int [20];   // to store  the petrol
    static int items;         //to find the no of items in the noOfLiterArray
    static int start1=0;     //refer to the 1st element in the noOfLiterArray
    static int end1=-1;     //refer to the last element in the noOfLiterArray

    public static void insertToWaiting(String name) {                    //To insert value into circular array
        //checks if the queue is full
        if (nOfItems==maxSize){
            System.out.println("Waiting Queue is full!!!");
        }
        else if (nOfItems>maxSize){
            if (end == maxSize-1){
                end = -1;
            }
            queueArray[++end] = name;
            nOfItems++;
        }

    }
    public static void insertNoOfLiter(int need) {          //To insert value of no.of petrol required into circular array
        //checks if the queue is full
        if (items==maxSize){
            System.out.println("No of liters Queue is full!!!");

        }
        else if (nOfItems>maxSize){
            if (end1 == maxSize-1){
                end1=  -1;
            }
            noOfLiterArray[++end1] = need;
            items++;
        }

    }

    public static String remove(){
        String temp ="";                           //To remove items in waiting circular queue
        //checks whether it is empty
        while (nOfItems ==0){
            System.out.println("Waiting Queue is empty!");
            break;
        }
        if (nOfItems>0){
            temp = queueArray[start++];
            if ( start == maxSize){
                start = 0;
            }
            nOfItems--;
        }
        return temp;

    }
    public static int removeNoOfLiterInArray(){
        int temp =0;                           //To remove items in waiting circular queue
        //checks whether it is empty
        while (items ==0){
            System.out.println("no of liters Queue is empty!");
            break;
        }
        if (items>0){
            temp = noOfLiterArray[start1++];
            if ( start1 == maxSize){
                start1 = 0;
            }
            items--;
        }
        return temp;

    }

    public static void showWaitQueue(){               //To show the waiting list when menu selected
        System.out.println("\n*****Waiting List Details****\n");
        for (int temp=0; temp<queueArray.length; temp++ ){
            int i = temp+1;
            System.out.println("Waiting Queue Number : "+ i +" Customer name : "+queueArray[temp]);
        }
    }
    public static void showPetrolQueue(){               //To show the waiting list when menu selected
        System.out.println("\n*****Waiting customers required petrol Details*****\n");
        for (int temp=0; temp<noOfLiterArray.length; temp++ ){
            int i = temp+1;
            System.out.println("Waiting Queue Number :"+ i +" Petrol required : "+noOfLiterArray[temp]);
        }
    }

}
