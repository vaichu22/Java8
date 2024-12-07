import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map_Nd_FlatMap {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "World");

        //[[Ljava.lang.String;@12edcd21, [Ljava.lang.String;@34c45dca]
        List<String[]> l1 = list.stream().map(word -> word.split("")).toList();

        //[H, e, l, l, o, W, o, r, l, d]
        List<String> l2 = list.stream().flatMap(word -> Arrays.stream(word.split(""))).collect(Collectors.toList());

        System.out.println(l1);
        System.out.println(l2);

        //one-to-one transformation- use map()
        System.out.println(mapEx(Arrays.asList(1,2,3,4,5)));

        //To flatten multiple smaller lists into a single list
        List<List<String>> l = Arrays.asList(Arrays.asList("1","2"),
                Arrays.asList("3","4"), Arrays.asList("5","6"));

        System.out.println(flatMapEx(l));

    }

    private static List<Integer> mapEx(List<Integer> list) {
        List<Integer> l1 = list.stream().map(elem->elem*2).collect(Collectors.toList());
        return l1;
    }

    private static List<String> flatMapEx(List<List<String>> list) {
        List<String> ans = list.stream().flatMap(l-> l.stream()).collect(Collectors.toList());
        return ans;
    }
}