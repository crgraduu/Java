package ro.ase.acs.models;
import ro.ase.acs.contracts.Measurable;

public abstract class Land implements Measurable  {
    protected String address;
    protected boolean hasOwner;
    protected int yearOfLastTransaction;

    Land(String address, boolean hasOwner, int yearOfLastTransaction) {
        this.address = address;
        this.hasOwner = hasOwner;
        this.yearOfLastTransaction = yearOfLastTransaction;
    }

    @Override
    public int getSurface() {
        throw new UnsupportedOperationException("Neimplementat");
    }
    public abstract float getPrice();
}
