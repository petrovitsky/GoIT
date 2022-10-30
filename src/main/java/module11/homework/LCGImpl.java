package module11.homework;

public class LCGImpl {
    private long a;
    private long c;
    private long m;



    public LCGImpl(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public long next(long seed) {
        return (a * seed + c) % m;
    }
}
