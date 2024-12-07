import java.util.Optional;

public class OptionalClass {

    public static void main(String[] args) {
        Optional<String> s = Optional.of("Vaishu");
        System.out.println(s.get());

//        //NPE - you Optional.ofNullable() instead
//        Optional<String> s1 = Optional.of(null);
//        System.out.println(s1.get());

        Optional<String> s2 = Optional.empty();
        System.out.println(s2.isPresent());

        Optional<String> s3 = Optional.ofNullable( null);
        System.out.println(s3.isPresent());

        Optional<String> s4 = Optional.ofNullable( null);
        String res = s4.orElse("test");
        System.out.println(s4.isPresent());
        System.out.println(res);

        Optional<String> s5= Optional.ofNullable(null);
        s5.orElseGet(()->"test");
        System.out.println(s5.isPresent());

        Optional<String> s6 = Optional.of("Alice");
        String output = s6.map(String::toUpperCase).get();
        System.out.println(output);

        //the fn passed to flatMap must return a optional
        Optional<String> s7 = Optional.of("VAISHU");
        String res1 = s7.flatMap(s8-> Optional.of(s8.toLowerCase())).get();
        System.out.println(res1);
    }

}
