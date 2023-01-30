class Solution {
    public int solution(int price) {
        return price >= 500_000 ? 
                price * 80 / 100 : 
                price >= 300_000 ? 
                        price * 90 / 100 : 
                        price >= 100_000 ? 
                                price * 95 / 100 : 
                                price;
    }
}