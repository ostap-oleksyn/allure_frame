package tests;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class Tst {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<String> list1 = new LinkedList<>();
        list1.add("jack");
        list1.add("jwel");
        list1.add("joe");
        list1.add("janny");

        Comparator<String> comparator = (o1, o2) -> 0;

        Collections.sort(list, comparator);

        list.forEach(System.out::println);

        assertThat(list).isSortedAccordingTo(comparator);
        fail("test");
    }


}
