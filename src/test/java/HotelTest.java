import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom singleRoom;
    Bedroom doubleRoom;
    Bedroom twinRoom;

    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;

    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before() {
        hotel = new Hotel("CodeClan Towers");
        singleRoom = new Bedroom(101, BedroomType.SINGLE, 25.00);
        doubleRoom = new Bedroom(102, BedroomType.DOUBLE, 50.00);
        twinRoom = new Bedroom(103, BedroomType.TWIN, 60.00);

        conferenceRoom = new ConferenceRoom("Charles Babbage Suite", 2, 1000.00);
        diningRoom = new DiningRoom("Canteen", 2);

        guest1 = new Guest("Ada Lovelace");
        guest2 = new Guest("Alan Turing");
        guest3 = new Guest("Clive Sinclair");
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan Towers", hotel.getName());
    }

    @Test
    public void bedRoomCountStartsAtZero() {
        assertEquals(0, hotel.bedroomCount());
    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom(singleRoom);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test
    public void canSetConferenceRoom() {
        hotel.addEventRoom(conferenceRoom);
        assertEquals("Charles Babbage Suite", hotel.getEventRoom("Charles Babbage Suite").getName());
    }

    @Test
    public void canSetDiningRoom() {
        hotel.addEventRoom(diningRoom);
        assertEquals("Canteen", hotel.getEventRoom("Canteen").getName());
    }

    @Test
    public void canCheckGuestsIntoConferenceRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        hotel.addEventRoom(conferenceRoom);
        hotel.checkInGuestsToRoom(guestList, conferenceRoom);
        assertEquals(2, hotel.getEventRoom("Charles Babbage Suite").numberOfGuests());
        assertEquals(false, hotel.getEventRoom("Charles Babbage Suite").isVacant());
    }

    @Test
    public void cannotCheckTooManyGuestsIntoConferenceRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        hotel.addEventRoom(conferenceRoom);
        hotel.checkInGuestsToRoom(guestList, conferenceRoom);
        assertEquals(0, hotel.getEventRoom("Charles Babbage Suite").numberOfGuests());
        assertEquals(true, hotel.getEventRoom("Charles Babbage Suite").isVacant());
    }

    @Test
    public void canCheckGuestsIntoDiningRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        hotel.addEventRoom(diningRoom);
        hotel.checkInGuestsToRoom(guestList, diningRoom);
        assertEquals(2, hotel.getEventRoom("Canteen").numberOfGuests());
        assertEquals(false, hotel.getEventRoom("Canteen").isVacant());
    }

    @Test
    public void cannotCheckTooManyGuestsIntoDiningRoom() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        hotel.addEventRoom(diningRoom);
        hotel.checkInGuestsToRoom(guestList, diningRoom);
        assertEquals(0, hotel.getEventRoom("Canteen").numberOfGuests());
        assertEquals(true, hotel.getEventRoom("Canteen").isVacant());
    }

    @Test
    public void canGetGuestsCheckedIntoBedroom() {
        hotel.addBedroom(singleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        singleRoom.checkInGuests(guestList);
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(1, guests.size());
        assertEquals("Ada Lovelace", guests.get(0).getName());
    }


    @Test
    public void canCheckGuestIntoBedroom() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkGuestsIntoBedroom(singleRoom.getNumber(), guestList);
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(1, guests.size());
        assertEquals("Ada Lovelace", guests.get(0).getName());
    }

    @Test
    public void canCheckGuestOutOfBedroom() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkGuestsIntoBedroom(singleRoom.getNumber(), guestList);

        hotel.checkGuestsOutOfBedroom(singleRoom.getNumber());
        ArrayList<Guest> guests = hotel.getGuestsCheckedIntoBedroom(singleRoom.getNumber());
        assertEquals(0, guests.size());
    }

    @Test
    public void canGetVacantBedroomsAllStartFree() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);

        ArrayList<Bedroom> vacantBedrooms = hotel.getAvailableBedrooms();
        assertEquals(2, vacantBedrooms.size());
    }

    @Test
    public void canGetVacantBedroomsOneOccupied() {
        hotel.addBedroom(singleRoom);
        hotel.addBedroom(doubleRoom);

        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkGuestsIntoBedroom(singleRoom.getNumber(), guestList);

        ArrayList<Bedroom> vacantBedrooms = hotel.getAvailableBedrooms();
        assertEquals(1, vacantBedrooms.size());
    }

    @Test
    public void canCheckGuestIntoBedroomForNumberOfNights() {
        hotel.addBedroom(singleRoom);
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        hotel.checkGuestsIntoBedroomForNumberOfNights(singleRoom.getNumber(), guestList, 2);
        assertEquals(2, singleRoom.getNumberOfNights());
    }
}
