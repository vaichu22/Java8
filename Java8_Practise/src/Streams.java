import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,6,8,2);
        Optional<Integer> res = list.stream().filter(elem-> elem>10).findFirst();
        System.out.println(res.orElse(-1));
        System.out.println(res.isPresent()? res.get() : res.orElse(-1));
        System.out.println(res.orElseGet(()->res.orElse(-1)));


        List<String> list1 = Arrays.asList("Abc", "Assist", "Bee", "Adf");
        long output = list1.stream().filter(elem-> elem.startsWith("A")).count();
        System.out.println(output);

        List<String> list2 = Arrays.asList("ddd", "acd", "bee", "animal","cat");
        List<String> res1 = list2.stream().sorted().collect(Collectors.toList());
        System.out.println(res1);

        List<String> list4 = Arrays.asList("ddd", "acd", "bee", "animal","cat");
        List<String> res4 = list4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(res4);

        List<String> list3 = Arrays.asList("ddd", "acd", "bee", "animal","cat");
        List<String> res3 = list3.reversed();
        System.out.println(res3);

        res3.stream().forEach(System.out::println);

        System.out.println("=============");

        //GroupingBy- Group list of strings by their length
        List<String> list6 = Arrays.asList("ddd", "acd", "bee", "animal","cat");
        Map<Integer, List<String>> map = list6.stream().collect(Collectors.groupingBy(elem-> elem.length()));
        Map<Integer, List<String>> map1 = list6.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
        System.out.println(map.get(1));

        //Flattens a list of list
        List<List<Integer>> l1 = Arrays.asList(Arrays.asList(1,5,6), Arrays.asList(6,7,8,9));
        List<Integer> out = l1.stream().flatMap(List::stream).collect(Collectors.toList());  // .flatMap(list->list.stream())
        System.out.println(out);

        //remove duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> a = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(a);

        //Partition a list of integers into even and odd numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> partitioned = numbers1.stream().collect(Collectors.partitioningBy(num->num%2==0));
        System.out.println(partitioned);
        System.out.println(partitioned.get(true));
        System.out.println(partitioned.get(false));

        // Maximum Number in a List
        List<Integer> numbers2 = Arrays.asList(3, 9, 2, 15, 6);
        Optional<Integer> val = numbers2.stream().max(Comparator.naturalOrder());  //sorting in ascending order and then fetching the max value
        System.out.println(val.get());
        System.out.println(val.orElse(-1));

        //Maximum string by length
        List<String> words = Arrays.asList("cat", "elephant", "dog", "bat");
        Optional<String> maxLength = words.stream().max(Comparator.comparing(String::length)); //compare and find the max
        System.out.println(maxLength.orElse("NO words in the list"));

        //Minimum String Alphabetically
        List<String> words1 = Arrays.asList("zebra", "apple", "mango", "banana");
        Optional<String> val1 = words1.stream().min(Comparator.naturalOrder()); //sort in ascending and return min
        System.out.println(val1.orElse("No words in the list"));

        //Sum of numbers using reduce()--reducing collection into single value
        //reduce means combining/reducing all elements in a stream into a single value
        //Identity is the starting point for the operation
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5,5,6);
        int sum = numbers3.stream().reduce(0, (value1,value2)->value1+value2);
        int sum1 = numbers3.stream().reduce(0, Integer::sum);
        System.out.println(sum1);

        //forEach
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> ans5 = numbers5.stream().map(num->num*2).collect(Collectors.toList());
        System.out.println(ans5);
        //rather that this, use
        ans5.stream().forEach(num-> System.out.println(num*2));

        //peek() - Is used to see how elements change as they pass through the pipeline. Used for debugging
        List<String> words9 = Arrays.asList("zebra", "apple", "mango", "banana");
        words9.stream()
                .filter(word-> word.length()>2)
                .map(word->word.toUpperCase())
                .peek(word-> System.out.println("Mapped value:"+word))
                .forEach(System.out::println);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
                .filter(name -> name.length() > 3)         // Filter names longer than 3 characters
                .peek(name -> System.out.println("Filtered: " + name)) // Log filtered names
                .map(String::toUpperCase)                 // Convert to uppercase
                .peek(name -> System.out.println("Mapped: " + name))   // Log mapped names
                .forEach(System.out::println);

        //limit a list of number
        List<Integer> numb = Arrays.asList(1, 2, 3, 4, 5, 6,7);
        List<Integer> lim = numb.stream().limit(2).collect(Collectors.toList());
        lim.forEach(System.out::println);

        numb.stream().limit(3).forEach(System.out::println);
    }
}
