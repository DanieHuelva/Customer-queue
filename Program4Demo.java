import java.util.Scanner;

public class Program4Demo {

	
    public static void printmenu() {				//prints the menu everytime
        System.out.println("");
        System.out.println("1. View Current Queue");
        System.out.println("2. Add student to queue");
        System.out.println("3. Add professor to queue");
        System.out.println("4. Serve next customer");
        System.out.println("5. Remove customer from queue");
        System.out.println("6. Print Queue Statistics");
        System.out.println("7. Exit");
        System.out.println("");
    }
	
	public static void main(String[] args) {

		Queue squeue = new Queue();				//two different queues since professor's has a priority queue
		Queue prof = new Queue();

		System.out.println("Welcome to the Route 406 Sandwiches Queue");
		printmenu();
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		while(choice != 7) {
			System.out.println("Your choice?");
			choice = sc.nextInt();
			//System.out.println();
			if(choice == 1) {
				System.out.println("Current Queue\n--------------");			//prints out the queue
				prof.printQueue();
				squeue.printQueue();
			}
			if(choice == 2) {												//makes a student customer and puts it in line
				Customer c = squeue.createCustomer(false);
				squeue.enqueue(c);
			}
			if(choice == 3) {											////makes a professor customer and puts it in line
				Customer c = prof.createCustomer(true);
				prof.enqueue(c);
			}
			if(choice == 4) {											//serves a customer in front of the queue 
				if (prof.getSize() != 0){								//professors go in front of the queue so they get served first
					prof.dequeue();
				}
				else{
					squeue.dequeue();									//if there are no more prof's then student's gets queued
				}
			}
			if(choice == 5) {
				System.out.println("What customer is leaving the line?");		//removes the customer thats leaving
				String name = sc.next();
					squeue.removeFromQueue(name);
					prof.removeFromQueue(name);
			}
			if(choice == 6) {
				System.out.println("Queue statistics\n------------\n");			//prints the statistic of the queue
				int ave = squeue.average();
				int aver = prof.average();
				int total = ave + aver;
				int serv1 = squeue.served();
				int serv2 = prof.served();
				int total2 = serv1 + serv2;
				double average = (double)total/total2;
				System.out.printf("Average wait time: " + average + " seconds\n");
				System.out.println("Customer served: " + total2);
			}
			if(choice == 7) {
				System.exit(0);
			}
			
			printmenu();



		}

	}
	
}
