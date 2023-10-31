package leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static void main(String[] args) {
        NestedInteger nestedInteger = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> list = new ArrayList<>();
                list.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                list.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                return list;
            }
        };
        List<NestedInteger> list = new ArrayList<>();
        list.add(nestedInteger);
        list.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });
        list.add(nestedInteger);
        NestedIterator nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

    }

    public static class NestedIterator implements Iterator<Integer> {

        private List<Integer> vals;

        private Iterator<Integer> cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            vals = new ArrayList<>();
            dfs(nestedList);
            cur = vals.iterator();
        }

        @Override
        public Integer next() {
            return cur.next();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    vals.add(e.getInteger());
                } else {
                    dfs(e.getList());
                }
            }
        }
    }
}
