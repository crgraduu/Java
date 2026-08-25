package ro.ase.acs.main;
import ro.ase.acs.classes.Car;

public class Main {
    public static void main(String[] args) {
    Car c1=new Car("Tesla", 40000);
    System.out.println(c1.getProducer());

    Car c2= (Car) c1.clone();
    c1.setPrice(30000);
    System.out.println(c2.getPrice());
    int[] vector = new int[] {100,200,150};
    c1.setDistances(vector);
    vector[0]=5000;
    int[] distances = c1.getDistances();
    for(int x:distances){
        System.out.println(x);
    }
    }
}
