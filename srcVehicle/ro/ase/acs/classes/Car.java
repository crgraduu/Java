package ro.ase.acs.classes;

import ro.ase.acs.interfaces.Taxable;

public class Car extends Vehicle implements Taxable, Comparable<Car> {
    private String color;
    private int capacity;
    public Car(){
        super();
        color = "white";
        capacity = 49;
    }
    public Car(String name, int speed, String color, int capacity) {
        super(name, speed);
        this.color = color;
        this.capacity=capacity;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public double computeTax() {
        float tax=0;
        if(capacity<2000)
            tax= (float)capacity/1000*50;
        else
            tax= (float)capacity/1000*100;
        return tax<MIN_TAX?MIN_TAX:tax;
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car copy = (Car) super.clone();
        copy.color=color;
        copy.capacity=capacity;
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("color=");
        builder.append(color);
        builder.append(", ");
        builder.append("capacity=");
        builder.append(capacity);
        builder.append(", ");
        builder.append("speed=");
        builder.append(getSpeed());
        builder.append(", ");
        builder.append("Name=");
        builder.append(getName());
        return builder.toString();
        //return "Car: color =" + color + ", capacity=" + capacity + ", Name=" + getName()+ ", Speed=" + getSpeed();
    }

    @Override
    public int compareTo(Car o) {
        if(capacity<o.capacity)
            return -1;
        else if(capacity == o.capacity)
            return 0;
        else return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car) {
            Car o=(Car)obj;
            return (getName().equals(o.getName())&& getSpeed()==o.getSpeed()&&color.equals(o.color)&&capacity==o.capacity);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return ((31*getName().hashCode()) + getSpeed())* 31 *color.hashCode() + capacity;
    }

}
