import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private final Set<Integer> set = new HashSet<>();

    public int solution(String[] userId, String[] bannedId) {
        List<List<Integer>> matchedUsers = matchBannedId(userId, bannedId);
        boolean[] matched = new boolean[userId.length];
        match(matchedUsers, matched, 0);
        return set.size();
    }

    private List<List<Integer>> matchBannedId(String[] userId, String[] bannedId) {
        return new ArrayList<>() {{
            for (String bannedUser : bannedId) {
                bannedUser = bannedUser.replace('*', '.');
                List<Integer> users = new ArrayList<>();
                for (int uid = 0; uid < userId.length; uid++)
                    if (userId[uid].matches(bannedUser)) users.add(uid);
                if (!users.isEmpty()) add(users);
            }
        }};
    }

    private void match(List<List<Integer>> matchedUsers, boolean[] matched, int bid) {
        if (bid >= matchedUsers.size()) {
            int bits = 0;
            for (boolean flag : matched) {
                bits = bits << 1;
                if (flag) bits |= 1;
            }
            set.add(bits);
        } else for (int uid : matchedUsers.get(bid)) {
            if (!matched[uid]) {
                matched[uid] = true;
                match(matchedUsers, matched, bid + 1);
                matched[uid] = false;
            }
        }
    }
}