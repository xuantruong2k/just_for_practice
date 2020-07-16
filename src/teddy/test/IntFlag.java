package teddy.test;

public class IntFlag implements Flag {

    private int _value = 0;

    public void IntFlag() {
        reset();
    }

    public void reset() {
        _value = 0;
    }

    public boolean isOn(int flag) {
        return (_value & (1 << flag)) != 0;
    }

    public void set(int flag) {
        _value |= (1 << flag);
    }

    public void clear(int flag) {
        _value &= (~(1 << flag));
    }
}
