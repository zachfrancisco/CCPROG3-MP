package MP3;

public class StandardRoom extends BaseRoom {
    public StandardRoom(String name, Hotel hotel) {
        super(name, hotel);
    }

    @Override
    protected double getPriceMultiplier() {
        return 1.0; // Standard price is just the base price
    }
}