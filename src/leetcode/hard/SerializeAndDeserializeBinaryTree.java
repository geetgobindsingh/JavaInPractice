package leetcode.hard;

import leetcode.medium.BaseTree;

import java.util.*;

public class SerializeAndDeserializeBinaryTree extends BaseTree {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();
            Stack<TreeNode> st = new Stack<>();
            st.push(root);
            while (st.size() > 0) {
                TreeNode p = st.pop();
                if (p == null) {
                    result.append("#" );
                } else {
                    result.append(p.val);
                    st.push(p.right);
                    st.push(p.left);
                }
                if (st.size() != 0) {
                    result.append(",");
                }
            }
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0 || data == null) {
                return null;
            }
            return deserialize(new ArrayList<>(Arrays.asList(data.split(","))));
        }

        private TreeNode deserialize(ArrayList<String> list) {
            if (list.size() == 0) return null;
            String node = list.remove(0);
            if (Objects.equals(node, "#")) return null;
            return new TreeNode(Integer.parseInt(node), deserialize(list), deserialize(list));
        }
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{1, 2, 3, null, null, 4, 5};
        TreeNode root = generateTree(ar);
        preOrder(root);
        System.out.print("\n");
        inOrder(root);
        System.out.print("\n");
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        preOrder(ans);
        System.out.print("\n");
        inOrder(ans);
        System.out.print("\n");
    }

}
