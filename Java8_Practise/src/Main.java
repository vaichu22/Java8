import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

       String s = "Hello world";

        ArrayList<String> list = new ArrayList<>();
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
    }
}