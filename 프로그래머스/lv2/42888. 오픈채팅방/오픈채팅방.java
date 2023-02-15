import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public final Map<String, User> users = new HashMap<>();

    public String[] solution(String[] record) {
        return Arrays.stream(record).map(this::runCommand).filter(Objects::nonNull).collect(Collectors.toList())
                .stream().map(User::toString).toArray(String[]::new);
    }

    private User runCommand(String command) {
        String[] content = command.split(" ");
        String operation = content[0];
        if (operation.equals("Enter")) {
            User user = users.getOrDefault(content[1], new User());
            user.name = content[2];
            user.operations.offer(operation);
            users.put(content[1], user);
            return user;
        } else if (operation.equals("Leave")) {
            User user = users.get(content[1]);
            user.operations.offer(operation);
            return user;
        } else {
            users.get(content[1]).name = content[2];
            return null;
        }
    }
}

class User {

    String name;
    Queue<String> operations = new LinkedList<>();

    @Override
    public String toString() {
        return name + "님이 " + (operations.poll().equals("Enter") ? "들어왔습니다." : "나갔습니다.");
    }
}