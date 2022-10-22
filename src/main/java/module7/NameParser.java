package module7;

public class NameParser {
    public String parse(String[] names) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                sb.append(names[i].split(" ")[0]);
                return sb.toString();
            }
            sb.append(names[i].split(" ")[0]).append(", ");
        }

        return sb.toString();
    }
}

class NameParserTest {
    public static void main(String[] args) {
        String[] names = {"John Doe", "Bill Mask", "Nigua Joshua"};

        //John, Bill, Nigua
        System.out.println(new NameParser().parse(names));
    }
}
