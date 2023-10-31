package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackList {

    static class BaseItem {
    }

    static class SingleItem extends BaseItem {
        public int item;

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    static class SomeItem extends BaseItem {
        public List<Integer> items = new ArrayList<>();

        @Override
        public String toString() {
            String result = "";
            for (int index = 0; index < items.size(); ++ index) {
                if (index != (items.size() - 1)) {
                    result = result + String.valueOf(items.get(index)) + ",";
                } else {
                    result = result + String.valueOf(items.get(index));
                }
            }
            return result;
        }
    }

    static class ManyItem extends BaseItem {
        public List<BaseItem> items = new ArrayList<>();
        @Override
        public String toString() {
            String result = "";
            for (int index = 0; index < items.size(); ++ index) {
                if (index != (items.size() - 1)) {
                    result = result + items.get(index).toString() + ",";
                } else {
                    result = result + items.get(index).toString();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        List<Stack<BaseItem>> stacks = new ArrayList<>();

        Stack<BaseItem> stack1 = new Stack<>();
        SingleItem singleItem = new SingleItem();
        singleItem.item = 1;
        stack1.push(singleItem);

        Stack<BaseItem> stack2 = new Stack<>();
        SomeItem someItem = new SomeItem();
        someItem.items = new ArrayList<>();
        someItem.items.add(2);
        someItem.items.add(3);
        stack2.push(someItem);

        Stack<BaseItem> stack3 = new Stack<>();
        ManyItem manyItem = new ManyItem();
        SingleItem singleItem3 = new SingleItem();
        singleItem3.item = 4;
        SomeItem someItem3 = new SomeItem();
        someItem3.items = new ArrayList<>();
        someItem3.items.add(5);
        someItem3.items.add(6);
        manyItem.items = new ArrayList<>();
        manyItem.items.add(singleItem3);
        manyItem.items.add(someItem3);
        stack3.push(manyItem);

        Stack<BaseItem> stack4 = new Stack<>();
        SingleItem singleItem4 = new SingleItem();
        singleItem4.item = 7;
        stack4.push(singleItem4);

        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);

        //Expected output:
        // 1,2,4,7
        // 1,2,5,7
        // 1,2,6,7
        // 1,3,4,7
        // 1,3,5,7
        // 1,3,6,7

        printCombinations(stacks);
    }

    static class TreeNode {
        public String data;
        public List<String> sum = new ArrayList<>();
        public List<TreeNode> children;
        public TreeNode(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }
    }

    private static void printCombinations(final List<Stack<BaseItem>> stackList) {
        if (stackList == null || stackList.isEmpty()) {
            return;
        }

        // First Create Tree
        TreeNode rootNode = createTree(stackList);

        // Than Do PreOrder Traversal with special logic to print combinations
        doPreOrderTraversal(rootNode);
    }

    private static TreeNode createTree(List<Stack<BaseItem>> stackList) {

        TreeNode root = new TreeNode(null);

        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);

        for (int index = 0; index < stackList.size(); ++index) {
            temp = addStackItemsToLeafNodeOfTree(temp, stackList.get(index));
        }

        return root;
    }

    private static List<TreeNode> addStackItemsToLeafNodeOfTree(List<TreeNode> leafs, Stack<BaseItem> baseItems) {
        if (leafs == null || leafs.isEmpty() || baseItems == null || baseItems.isEmpty()) {
            return null;
        }

        List<TreeNode> newLeafNodes = new ArrayList<>();
        for (BaseItem baseItem : baseItems) {
            TreeNode leaf = new TreeNode(baseItem.toString());
            newLeafNodes.add(leaf);
        }

        for (TreeNode oldLeafs : leafs) {
            for (TreeNode newLeafs : newLeafNodes) {
               String sum = (oldLeafs.sum != null) ? oldLeafs.sum + newLeafs.toString() : newLeafs.toString();
               newLeafs.sum.add(sum);
            }
            oldLeafs.children = newLeafNodes;
        }

        return newLeafNodes;
    }

    private static void doPreOrderTraversal(TreeNode rootNode) {
        if (rootNode.children == null) {
            if (rootNode.sum != null && !rootNode.sum.isEmpty()) {
                for (String sum : rootNode.sum) {
                    System.out.println(sum);
                }
            }
        } else {
            for (TreeNode treeNode : rootNode.children) {
                doPreOrderTraversal(treeNode);
            }
        }
    }
}