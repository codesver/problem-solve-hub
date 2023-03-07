import java.util.Stack;

public class Solution {

    private final int[] DISCOUNT_VALUES = new int[]{10, 20, 30, 40};
    private final Stack<Integer> discounts = new Stack<>();

    private int[][] users;
    private int[] emoticons;
    private int maxSubs = 0, maxProfit = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        search();
        return new int[]{maxSubs, maxProfit};
    }

    private void search() {
        if (emoticons.length == discounts.size()) {
            int subs = 0, profit = 0;
            for (int[] user : users) {
                int payment = 0;
                for (int i = 0; i < emoticons.length; i++)
                    if (discounts.get(i) >= user[0])
                        payment += emoticons[i] * (100 - discounts.get(i)) / 100;
                if (payment >= user[1]) subs++;
                else profit += payment;
            }
            if (subs > maxSubs) {
                maxSubs = subs;
                maxProfit = profit;
            } else if (subs == maxSubs && profit > maxProfit) maxProfit = profit;
        } else for (int d = 0; d < 4; d++) {
            discounts.push(DISCOUNT_VALUES[d]);
            search();
            discounts.pop();
        }
    }
}