public abstract class EventRoom extends Room {
    private String name;

    public EventRoom(String name, int capacity) {
        super(capacity);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
