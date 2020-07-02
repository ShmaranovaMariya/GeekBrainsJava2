package competition;
public class Tread implements Obstruction{

    private int length;

    public Tread(int length) {
        this.length = length;
    }

    @Override
    public int getSize() {
        return length;
    }
}
