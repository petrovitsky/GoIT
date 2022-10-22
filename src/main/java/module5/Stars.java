package module5;

public class Stars {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {


        this.count = count;
    }

    @Override
    public String toString() {
        return "X".repeat(count/1000) +
                "Y".repeat(count/100 % 10) +
                "Z".repeat(count/10 % 10) +
                "*".repeat(count % 10);
    }

    public static void main(String[] args) {
        Stars stars = new Stars();
        stars.setCount(153);
        System.out.println(stars);
        System.out.println(stars.getCount());
    }
}
