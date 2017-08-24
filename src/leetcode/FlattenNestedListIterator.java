package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Aleksandr on 23/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/flatten-nested-list-iterator
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    private Queue<Integer> queue = new LinkedList<>();
    private Iterator<Integer> iterator;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        unwind(nestedList);
        iterator = queue.iterator();
    }

    private void unwind(List<NestedInteger> list) {
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                queue.add(item.getInteger());
            } else {
                unwind(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}
