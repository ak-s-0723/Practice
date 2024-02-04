import java.util.ArrayList;
import java.util.List;

import static org.springframework.aot.hint.TypeReference.listOf;


public class main2 {
    public static void main(String args[]) {
        List<Integer> l1 = List.of(1,2);
        List<String> l2 = List.of("ddddddd");
        List<Double> l3 = List.of(560.0,890000.0);
        System.out.println(l1.getClass().getName());
        System.out.println(l2.getClass().getName());
        System.out.println(l3.getClass().getName());
    }
}
