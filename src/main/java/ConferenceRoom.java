public class ConferenceRoom extends EventRoom {
    private double pricePerDay;

    public ConferenceRoom(String name, int capacity, double pricePerDay) {
        super(name, capacity);
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }
}
