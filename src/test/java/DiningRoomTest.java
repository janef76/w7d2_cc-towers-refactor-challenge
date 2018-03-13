import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom room;

    @Before
    public void before() {
        room = new DiningRoom("CC Canteen", 50);
    }

    @Test
    public void hasName() {
        assertEquals("CC Canteen", room.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(50, room.getCapacity());
    }
}
