package competition;

public class Human implements Move {
    private String name;
    private int maxJump;
    private int maxRun;
    private boolean droppedOut;

    public Human(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean run(Tread tread) {
        return maxRun > tread.getSize();
    }

    @Override
    public boolean jump(Wall wall) {
        return maxJump > wall.getSize();
    }

    @Override
    public boolean overcome(Obstruction obstruction) {
        return maxJump + maxRun > obstruction.getSize();
    }

    @Override
    public boolean isDroppedOut() {
        return droppedOut;
    }

    @Override
    public void setDroppedOut(boolean value) {
        this.droppedOut = value;
    }

    public String toString() {
        return name;
    }
}