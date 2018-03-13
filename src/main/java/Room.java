import java.util.ArrayList;

public abstract class Room {
    private ArrayList<Guest> guests;
    private int capacity;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int numberOfGuests() {
        return this.guests.size();
    }
    public boolean isVacant() {
        return numberOfGuests() == 0;
    }

    public boolean isFull() {
        return this.guests.size() == this.capacity;
    }

    public void checkIn(Guest guest) {
        if (!isFull()) {
            this.guests.add(guest);
        }
    }

    public void checkOut() {
        this.guests.clear();
    }

    public ArrayList<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    public void checkInGuests(ArrayList<Guest> guestsToCheckIn) {
        if ((guestsToCheckIn.size() > this.capacity) || !isVacant()) {
            return;
        }
        for (Guest guest : guestsToCheckIn) {
            checkIn(guest);
        }
    }
}
