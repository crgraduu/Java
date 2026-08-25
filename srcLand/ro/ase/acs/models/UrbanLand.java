package ro.ase.acs.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UrbanLand extends Land implements Cloneable {
    private LandType landType;
    UrbanLand(String address, boolean hasOwner, int yearOfLastTransaction,LandType landType) {
        super(address, hasOwner, yearOfLastTransaction);
        this.landType = landType;
    }

    public String getAddress() {
        return address;
    }
    public boolean doeshaveOwner() {
        return hasOwner;
    }
    public int getYear() {
        return yearOfLastTransaction;
    }
    public LandType getLandType() {
        return landType;
    }
    public void setAddress(String address) {this.address=address;}
    public void setHasOwner(boolean hasOwner) {this.hasOwner=hasOwner;}
    public void setYear(int yearOfLastTransaction) {this.yearOfLastTransaction=yearOfLastTransaction;}
    public void setLandType(LandType landType) {this.landType=landType;}

    @Override
    public int getSurface() {
        if(address.startsWith("Bucuresti")) return 500;
        if(address.startsWith("Corbeanca")) return 1000;
        return 250;
    }
    @Override
    public float getPrice() {
        if(landType==LandType.ARABLE) return getSurface()*20;
        if(landType==LandType.CONSTRUCTION) return getSurface()*100;
        return 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        UrbanLand clone = (UrbanLand) super.clone();
        return clone;
    }
    @Override
    public String toString() {
        return address+" "+hasOwner+" "+yearOfLastTransaction+" "+landType;
    }
    public static Set<Land> Lands= new HashSet<>();
    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(!(o instanceof UrbanLand)||o==null) return false;
        UrbanLand other = (UrbanLand) o;
        return Objects.equals(this.address, other.address);
    }
    @Override
    public int hashCode() { //X
        return Objects.hash(address);
    }
    public static void addLand(Land L) {
        Lands.add(L);
    }
    public static Collection<Land> getLands() { //X
        return new HashSet<Land>(Lands);
    }
    public static Collection<Land> getLandsByYear (int year) {
        return Lands.stream().filter(L->L instanceof UrbanLand).map(L->L=(UrbanLand) L)
                .filter(L->L.yearOfLastTransaction==year).sorted((L1,L2)->L1.address.compareTo(L2.address))
                .map(L->(Land) L)
                .toList();
    }





}
