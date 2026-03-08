package MP3;

public class LuxuryRoom extends BaseRoom {
    public LuxuryRoom(String name, Hotel hotel) {
        super(name, hotel);
    }

    @Override
    protected double getPriceMultiplier() {
        return 1.35;
    }
}