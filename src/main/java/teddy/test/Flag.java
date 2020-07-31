package teddy.test;

public interface Flag {

    public boolean isOn(int flag);
    public void reset();
    public void set(int flag);
    public void clear(int flag);
}
