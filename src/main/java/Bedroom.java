import java.util.ArrayList;

public class Bedroom extends Room {
    private int number;
    private BedroomType type;
    private double pricePerNight;
    private int numberOfNights;

    public Bedroom(int number, BedroomType type, double pricePerNight) {
        super(type.getCapacity());
        this.type = type;
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type.getType();
    }

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    public void checkInGuestsForNumberOfNights(ArrayList<Guest> guests, int numberOfNights) {
        if (numberOfNights > 0) {
            super.checkInGuests(guests);
            this.numberOfNights = numberOfNights;
        }

    }
}
