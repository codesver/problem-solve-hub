import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] prices) {
        int[] times = new int[prices.length];
        
        Queue<Price> queue = new PriorityQueue<>((pa, pb) -> {
            if (pa.cost == pb.cost) return pa.time - pb.time;
            else return pb.cost - pa.cost;
        });
            
        for (int p = 0; p < prices.length; p++) {
            Price price = new Price(p, prices[p]);
            while(!queue.isEmpty() && queue.peek().cost > price.cost) {
                Price prePrice = queue.poll();
                times[prePrice.time] = price.time - prePrice.time;
            }
            queue.offer(price);
        }
        
        while (!queue.isEmpty()) {
            Price price = queue.poll();
            times[price.time] = prices.length - price.time - 1;
        }
        
        return times;
    }
}

class Price {
    
    int time, cost;
    
    public Price(int time, int cost) {
        this.time = time;
        this.cost = cost;
    }
}