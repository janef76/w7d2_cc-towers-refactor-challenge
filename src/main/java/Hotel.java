import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<EventRoom> eventRooms;

    public Hotel(String name) {
        this.name = name;
        bedrooms = new ArrayList<Bedroom>();
        eventRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return new ArrayList<Bedroom>(bedrooms);
    }

    public void setBedrooms(ArrayList<Bedroom> bedrooms) {
        this.bedrooms = bedrooms;
    }

    public EventRoom getEventRoom(String name) {
        for (EventRoom room : eventRooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    public void addEventRoom(EventRoom room) {
        eventRooms.add(room);
    }

    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void checkInGuestsToRoom(ArrayList<Guest> guestList, Room room) {
        room.checkInGuests(guestList);
    }

    public ArrayList<Guest> getGuestsCheckedIntoBedroom(int number) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                return room.getGuests();
            }
        }
        return new ArrayList<Guest>();
    }

    public void checkGuestsIntoBedroom(int number, ArrayList<Guest> guestList) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkInGuests(guestList);
                return;
            }
        }
    }

    public void checkGuestsIntoBedroomForNumberOfNights(int number, ArrayList<Guest> guestList, int numberOfNights) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkInGuestsForNumberOfNights(guestList, numberOfNights);
                return;
            }
        }
    }

    public void checkGuestsOutOfBedroom(int number) {
        for (Bedroom room : bedrooms) {
            if (room.getNumber() == number) {
                room.checkOut();
                return;
            }
        }
    }

    public ArrayList<Bedroom> getAvailableBedrooms() {
        ArrayList<Bedroom> availableRooms = new ArrayList<Bedroom>();
        for (Bedroom room : bedrooms) {
            if (room.isVacant()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
