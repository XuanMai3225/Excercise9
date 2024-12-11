package oop_excercise9;

public class BedRoom extends Room {

    private int numberOfBeds;

    public BedRoom(String id, String name, double baseCost, int numberOfBeds) {
        super(id, name, baseCost);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public double calculateCost() {
        if (numberOfBeds >= 3) {
            return getBaseCost() * 1.1;
        }
        return getBaseCost();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number Of Beds: " + numberOfBeds);
    }
}
