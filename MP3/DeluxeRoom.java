package MP3;

public class DeluxeRoom extends BaseRoom {
    public DeluxeRoom(String name, Hotel hotel) {
        super(name, hotel);
    }

    @Override
    protected double getPriceMultiplier() {
        return 1.2;
    }
}