public enum BedroomType {
    SINGLE("Single",1),
    DOUBLE("Double", 2),
    TWIN("Twin",2);

    private String type;
    private int capacity;

    BedroomType(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
