package competition;

public interface Move {

    boolean run(Tread tread);

    boolean jump(Wall wall);

    boolean overcome(Obstruction obstruction);

    boolean isDroppedOut();

    void setDroppedOut(boolean value);

}
