package tests;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class Tst {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("joe");
        list.add("jwel");
        list.add("jack");
        list.add("janny");

        List<String> list1 = new LinkedList<>();
        list.add("joe");
        list.add("jwel");
        list.add("jack");
        list.add("janny");

        assertThat(list).hasSameElementsAs(list1);

    }


}
