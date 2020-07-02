package competition;
public class Wall implements Obstruction {

    private int height;

    public Wall(int height) {
        this.height = height;
    }
    @Override
    public int getSize() {
        return height;
    }
}