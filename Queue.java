import java.util.LinkedList;
import java.util.Scanner;


public class Queue {
    private LinkedList<Customer> data;
	private int size;
	private int count;
	private int served;
	
	public Queue() {
		this.data = new LinkedList<Customer>();
		this.size = 0;
		this.count = 0;
		this.served = 0;
	}
	
	public void enqueue(Customer newCus) {
		this.data.add(newCus);
		this.size++;
	}

	public int getSize(){
		return this.size;
	}
	
	public void dequeue() {
		Customer removed = this.data.removeFirst();
		long end = System.nanoTime();
		int time = (int) ((end-removed.startgetSec())/1000000000);
		this.count += time;
		this.served ++;
		System.out.println("Time spent in queue: " + time + " seconds");
		System.out.println(removed.getName() + " has been served their " + removed.getOrder());
		this.size--;
	}
	
	public void printQueue() {
		for(Customer o: this.data) {
			o.printOrder();
		}
	}
	
	public Customer peek() {
		return this.data.getFirst();
	}

    public Customer createCustomer(boolean b) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the customer's name?");
        String name = sc.nextLine();
        System.out.println("What would you like to order?");
        String order = sc.nextLine();
		long start = System.nanoTime();
		if (b == true){{
			System.out.println("Added " +name + "(Professor) to the queue.");
		}}
		else{
			System.out.println("Added " +name + " to the queue.");
		}
        return new Customer(name, order, start);
    }

    public void removeFromQueue(String name) {
		for(Customer o: this.data) {
			if (o.getName().equals(name)){
				this.data.remove(o);
				long end = System.nanoTime();
				System.out.println("Time spent in queue: " + (end-o.startgetSec())/1000000000 + " seconds");
				this.size--;
			}
		}
    }

	public int average() {
		return (this.count);
	}

	public int served(){
		return this.served;
	}

	

}
