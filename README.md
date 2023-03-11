# Fuel-Queue
--A fuel queue management system for fuel center--
Designed a program for a Fuel center which have 2 pumps where maximum 3 customers can be hold simultaneously in a queue. Implemented the following functionalities as separate procedures. Fuel Center will have exactly 500 liters in their stock. For each customer added to the queue, stock will be updated. (Assume each customer is served with 50 liters), and a warning message should be displayed when the stock reaches a value of 50 liters. Operator should be performing the following tasks by selecting from a console menu.
'''
100 : View all Fuel Queues.
101 : View all Empty Queues.
102 : Add customer to a Queue.
103 : Remove a customer from a Queue. (From a specific location)
104 : Remove a served customer.
105 : View Customers Sorted in alphabetical order (Do not use library sort routine)
106 : Store Program Data from file.
107 : Load Program Data from file.
108 : View Remaining Fuel Stock.
EXT : Exit the Program.
'''
--Classes version.--
Created a second version of the fuel queue management system using an array of FuelQueue Objects. The Class version should be able to manage 2[Two] pumps parallelly. Create a class called FuelQueue and another class called passenger. The program shouldfunction as in Task 1. Each queue can hold up to 3 passengers with the following additional information.
'''
i. First Name.
ii. Second Name.
iii. Vehicle No (int: max length 6)
iv. No. of liters required.
'''
Note: In class version, add customer to the Fuel queue (102) option must select the queue with the minimum length. Otherwise, the program should function as in Task 1.
--Add to a waiting Queue.--
Added a waiting list to Fuel Queue class version. Waiting list can hold up to 5 customers. Used an array.
Modiied the ‘102 Add customer to a Queue’ and ‘104: Remove a served customer’ as follows:
'''
• When you press ‘102 to add a new customer, the customer should be added to the Waiting List
queue if the Fuel queues are full.
• When you press ‘104’ to remove a served customer, the next customer in the Waiting List queue
should be automatically placed in the fuel queue.
'''
