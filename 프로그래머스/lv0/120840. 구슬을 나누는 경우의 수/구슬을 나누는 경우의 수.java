class Solution {

    public int BALLS, SHARE;
    public int count = 0;

    public int solution(int balls, int share) {
        BALLS = balls;
        SHARE = share;
        next(0, 0);
        return count;
    }

    public void next(int start, int depth) {
        for (int i = start; i < BALLS; i++) search(i + 1, depth + 1);
    }

    public void search(int start, int depth) {
        if (depth == SHARE) count++;
        else next(start, depth);
    }
}