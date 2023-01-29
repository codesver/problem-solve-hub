import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {

    String morse = ",.-:a,-...:b,-.-.:c,-..:d,.:e,..-.:f,--.:g,....:h,..:i,.---:j,-.-:k,.-..:l,--:m,-.:n,---:o,.--.:p,--.-:q,.-.:r,...:s,-:t,..-:u,...-:v,.--:w,-..-:x,-.--:y,--..:z";

    public String solution(String letter) {
        return Arrays.stream(letter.split(" ")).map(code -> {
            String c = "," + code + ":";
            return String.valueOf(morse.charAt(morse.indexOf(c) + c.length()));
        }).collect(Collectors.joining());
    }
}