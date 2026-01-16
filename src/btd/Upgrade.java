package btd;

public interface Upgrade {
    public void apply(Tower t);

    public void revert(Tower t);

    public int getCost();

    public String getName();
}
