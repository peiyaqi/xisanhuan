package lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class TestLamdba {



    public void test(){
        Comparator<Integer> comparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(Integer::compareTo);

    }
}
