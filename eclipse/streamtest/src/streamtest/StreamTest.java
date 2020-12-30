package streamtest;

import java.util.ArrayList;

public class StreamTest {
   public static void main(String[] args) {
	ArrayList<String> list =new ArrayList<>();
	list.add("Mary,98");
	list.add("May,97");
	list.add("Mark,88");
	list.add("Martin,98");
    list.add("Marvin,76");
    list.stream().map(s->s.split(",")[1]).map(Integer::parseInt)
        .filter(n->n>90).forEach(System.out::println);
 }
}
