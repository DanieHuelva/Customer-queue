public class Customer {
    String name;
    String order;
    long start;
    public Customer(String name, String order, long start){
        this.name = name;
        this.order = order;
        this.start = start;
    }


    public void printOrder() {
        System.out.println(this.name + " (" +this.order + ")");
    }

    public long startgetSec(){
        return start;
    }

    public String getOrder(){
        return this.order;
    }

    public String getName(){
        return this.name;
    }

    
    
}
