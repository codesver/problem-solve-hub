class Solution {
    public int solution(String my_string) {
        String[] elements = my_string.split(" ");
        int answer = Integer.parseInt(elements[0]);
        for (int i = 1; i < elements.length; i += 2)
            answer += Integer.parseInt(elements[i + 1]) * (elements[i].equals("+") ? 1 : -1);
        return answer;
    }
}