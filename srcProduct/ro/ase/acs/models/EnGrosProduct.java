package ro.ase.acs.models;

public class EnGrosProduct extends Product
{
    private double discount;
    public EnGrosProduct(String name, float price, int quantity)
    {
        super(name, price, quantity);
        if(quantity < 10)
            {
                discount = 0;
            }
        if(quantity >= 10)
            {
                discount = 0.05;
            }
        if(quantity >= 20)
        {
            discount = 0.1;
        }
    }
    @Override
    public double getDiscount()
    {
        return price*discount;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        EnGrosProduct copy = (EnGrosProduct) super.clone();
        copy.discount = this.discount;
        copy.price = this.price;
        copy.quantity = this.quantity;
        copy.name = this.name;
        return super.clone();
    }
    @Override
    public String toString()
    {
        double totalPrice = price*quantity;
        double totalPriceDiscounted = totalPrice*(1-discount);
        return "> " + name + " " + price + " " + quantity + " " + (int)(discount*100) + "%" +" " + totalPrice + " " + totalPriceDiscounted;
    }
}
