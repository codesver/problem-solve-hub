class Solution {
    private String censor(String phone, int length) {
        return "*".repeat(length) + phone.substring(length);
    }

    public String solution(String phone) {
        return censor(phone, phone.length() - 4);
    }
}