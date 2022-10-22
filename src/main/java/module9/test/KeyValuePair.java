package module9.test;

public class KeyValuePair<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValuePair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class KeyValueTest {
    public static void main(String[] args) {
        KeyValuePair<String, Integer> javaSalary = new KeyValuePair<>();
        javaSalary.setKey("Java");
        javaSalary.setValue(5000);
        System.out.println(javaSalary);
        System.out.println("----- ---- ------");
        KeyValuePair<String, Integer> javaSalary1 = new KeyValuePair<String, Integer>();
        KeyValuePair<Integer, Float> yearAvgTemperature = new KeyValuePair<Integer, Float>();

        javaSalary1.setKey("Java");
        javaSalary1.setValue(5000);

        yearAvgTemperature.setKey(3200);
        yearAvgTemperature.setValue(15f);
        System.out.println(javaSalary1);
        System.out.println(yearAvgTemperature);
    }
}


