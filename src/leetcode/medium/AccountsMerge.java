package leetcode.medium;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        AccountsMerge obj = new AccountsMerge();
        obj.display(obj.accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        )));

        System.out.println();

        obj.display(obj.accountsMerge(Arrays.asList(
                Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        )));

        System.out.println();

        obj.display(obj.accountsMerge(Arrays.asList(
                Arrays.asList("David","David0@m.co","David1@m.co"),
                Arrays.asList("David","David3@m.co","David4@m.co"),
                Arrays.asList("David","David4@m.co","David5@m.co"),
                Arrays.asList("David","David2@m.co","David3@m.co"),
                Arrays.asList("David","David1@m.co","David2@m.co")
        )));
    }

    public void display(List<List<String>> ans) {
        for (List<String> list : ans) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    static class Account {
        String name;
        TreeSet<String> emails = new TreeSet<>();

        public Account(String name) {
            this.name = name;
        }

        public void addEmail(String email) {
            emails.add(email);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Account> reverseMap = new HashMap<>();
        List<Account> accountList = new ArrayList<>();
        for (List<String> list : accounts) {
            Account account = new Account(list.get(0));
            boolean newAccount = true;
            Set<String> emails = new LinkedHashSet<>(list.subList(1, list.size()));
            for (String email : emails) {
                account.addEmail(email);
                newAccount = !reverseMap.containsKey(email);
                if (newAccount) {
                    reverseMap.put(email, account);
                } else {
                    Account parent = reverseMap.get(email);
                    for (int j = 1; j < list.size(); j++) {
                        reverseMap.put(email, parent);
                        parent.addEmail(list.get(j));
                    }
                    break;
                }
            }
            if (newAccount) {
                accountList.add(account);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Account a : accountList) {
            List<String> l = new ArrayList<>();
            l.add(a.name);
            l.addAll(a.emails);
            result.add(l);
        }
        return result;
    }
}
