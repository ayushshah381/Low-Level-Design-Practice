public class Passenger {
    private int id;
    private String name;
    private String contact;
    private Location location;

    public Passenger(int id, String name, String contact, Location location) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
