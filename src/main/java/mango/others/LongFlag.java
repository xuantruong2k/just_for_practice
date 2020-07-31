package mango.others;

public class LongFlag implements Flag {

    private long _value = 0;

    public void LongFlag() {
        reset();
    }

    public void reset() {
        _value = 0;
    }

    public boolean isOn(int flag) {
        return (_value & ((long)1 << flag)) != 0;
    }

    public void set(int flag) {
        _value |= ((long)1 << flag);
    }

    public void clear(int flag) {
        _value &= (~((long)1 << flag));
    }
}
