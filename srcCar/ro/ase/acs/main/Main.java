package ro.ase.acs.main;
import ro.ase.acs.classes.Car;
import ro.ase.acs.classes.Vehicle;
import ro.ase.acs.interfaces.Taxable;

import java.util.*;

public class Main
{
    static void add(Car x, Car y) {
        x.setCapacity(x.getCapacity()+y.getCapacity());
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car("Dacia", 90, "black", 1400);
        System.out.println(car);
        Taxable t = car;
        double tax = t.computeTax();
        System.out.println(tax);
        Vehicle v = new Car();
        v.move();
        Car c = new Car("Ford", 90, "white", 1000);
        Car c2 = null;
        if (car instanceof Cloneable) {
            c2 = (Car) car.clone();
            c2.setCapacity(1900);
            System.out.println(c2.getCapacity());
        }
        Integer x = 5;
        int y = x;
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(6);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        list.remove(2);
        list.add(1, 3);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println();
        list.set(0, 9);
        for (Integer i : list) {
            System.out.println(i);
        }
        Set<Car> set = new TreeSet<Car>();
        set.add(c);
        set.add(c2);
        for (Car z : set)
            System.out.println(z);
        Map<Car, String> map = new HashMap<Car, String>();
        map.put(c, "Ion I");
        map.put(c2, "Gigi G");
        Car c3 = null;
        try {
            c3 = (Car) c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        map.put(c3, "Petre P");
        for (Car z : map.keySet())
        {
            System.out.printf("%s: ", z.toString());
            System.out.println(map.get(z));
        }
        add(c,c2);
        System.out.println(c.getCapacity());
    }
}
