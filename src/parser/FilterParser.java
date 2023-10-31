package parser;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilterParser {

    public static List<Condition> conditionList = new ArrayList<>();
    public static List<String> operatorList = new ArrayList<>();

    public static void main(String[] args) {
        QuickFilter quickFilter = new QuickFilter();

        System.out.println("groupId : " + quickFilter.groupId);
        System.out.println("id : " + quickFilter.id);
        System.out.println("name : " + quickFilter.name);

        operatorList.add("$");

        conditionList.add(new Condition(0, "CHAT", "groupId", quickFilter.groupId.toString(), "EQUALS"));

        traverseQuickFilter(quickFilter.predicate, 0);

        System.out.println();
        for (Condition condition : conditionList) {
            System.out.println(condition.toString());
        }

        System.out.println();
        for (String operator : operatorList) {
            System.out.println(operator);
        }
    }

    private static void traverseQuickFilter(QuickFilter.Predicate predicate, int level) {
        if (predicate != null) {
            int nextLevel = level + 1;

            if (predicate.operator != null
                    && predicate.left != null && predicate.right != null
                    && predicate.left.left != null && predicate.left.right != null
                    && predicate.right.left != null && predicate.right.right != null) {
                operatorList.add(predicate.operator);
            }

            traverseQuickFilter(predicate.left, nextLevel);

            if (predicate.left != null && predicate.right != null && predicate.left.left == null && predicate.left.right == null) {
                conditionList.add(new Condition(level, predicate.left.type, predicate.left.value, predicate.right.value, predicate.operator));
            } else if (predicate.left != null && predicate.right != null && predicate.right.left == null && predicate.right.right == null) {
                conditionList.add(new Condition(level, predicate.left.type, predicate.left.value, predicate.right.value, predicate.operator));
            }

            traverseQuickFilter(predicate.right, nextLevel);
        }
    }

    static class Condition {
        public int level;
        public String type; // FORMANSWER, ANSWER, CHAT, VALUE
        public String key;
        public String value;
        public String operation;

        @Override
        public String toString() {
            return "Condition{" +
                    "level='" + level + '\'' +
                    ", type='" + type + '\'' +
                    ", key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", operation='" + operation + '\'' +
                    '}';
        }


        public Condition(int level, String type, String key, String value, String operation) {
            this.level = level;
            this.type = type;
            this.key = key;
            this.value = value;
            this.operation = operation;
        }
    }

    static class QuickFilter {
        public UUID groupId;
        public UUID id;
        public String name;
        public Predicate predicate;

        public QuickFilter() {
            groupId = UUID.fromString("efd301f7-bd66-43ed-9fa6-1caf444446f3");
            id = UUID.fromString("b17a3a50-dac9-11e9-b713-e9179cd0c824");
            name = "Get All Pinned Chats";

            predicate = getTooComplexPredicate();
        }

        private Predicate getTooComplexPredicate() {
            Predicate predicate = new Predicate();

            predicate.left = getComplexPredicate();
            predicate.right = getComplexPredicate();

            predicate.operator = "OR";
            return predicate;

        }

        private Predicate getComplexPredicate() {
            Predicate predicate = new Predicate();

            predicate.left = new Predicate();
            predicate.right = new Predicate();

            predicate.left.left = new Predicate();
            predicate.left.left.type = "CHAT";
            predicate.left.left.value = "isPanned";

            predicate.left.right = new Predicate();
            predicate.left.right.type = "VALUE";
            predicate.left.right.value = "true";

            predicate.left.operator = "EQUALS";

            predicate.right.left = new Predicate();
            predicate.right.left.type = "CHAT";
            predicate.right.left.value = "type";

            predicate.right.right = new Predicate();
            predicate.right.right.type = "VALUE";
            predicate.right.right.value = "TEXT";

            predicate.right.operator = "LESS THAN EQUAL TO";

            predicate.operator = "AND";
            return predicate;
        }

        private Predicate getPinnedPredicate() {
            Predicate predicate = new Predicate();
            predicate.left = new Predicate();
            predicate.left.type = "CHAT";
            predicate.left.value = "isPanned";

            predicate.right = new Predicate();
            predicate.right.type = "VALUE";
            predicate.right.value = "true";

            predicate.operator = "EQUALS";
            return predicate;
        }


        @Override
        public String toString() {
            return "QuickFilter{" +
                    "groupId=" + groupId +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", predicate=" + predicate +
                    '}';
        }

        static class Predicate {
            public Predicate left, right;
            public String operator;
            public String type;
            public String value;

            @Override
            public String toString() {
                return "Predicate{" +
                        "left=" + left +
                        ", right=" + right +
                        ", operator='" + operator + '\'' +
                        ", type='" + type + '\'' +
                        ", value='" + value + '\'' +
                        '}';
            }

        }
    }
}
