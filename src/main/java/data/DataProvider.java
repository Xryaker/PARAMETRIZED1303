package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataProvider {
    List<String> valid;
    static List<String> noValid = new ArrayList<>();

    static {
        noValid.add("1236547898");
        noValid.add("456987123");
        noValid.add("45665856145");
    }

    public static List<String> getNoValidCerts() {
        return noValid;
    }
    public static String getRundo(){
        return noValid.get(new Random().nextInt(noValid.size()));
    }
}
