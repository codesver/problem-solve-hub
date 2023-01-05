import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        boolean[] know;

        // Reading number of member and party
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int memberNo = Integer.parseInt(tokenizer.nextToken());
        int partyNo = Integer.parseInt(tokenizer.nextToken());
        know = new boolean[memberNo + 1];

        // Reading initial members who know the truth
        tokenizer = new StringTokenizer(reader.readLine());
        int knowNo = Integer.parseInt(tokenizer.nextToken());
        know = new boolean[memberNo + 1];
        while (knowNo-- > 0) know[Integer.parseInt(tokenizer.nextToken())] = true;

        // Read parties
        List<Set<Integer>> parties = new ArrayList<>();
        while (partyNo-- > 0) {
            // Create party and add to party list
            Set<Integer> party = new HashSet<>();
            boolean flag = false;       // Check if there is a participant who knows the truth
            tokenizer = new StringTokenizer(reader.readLine());
            int participantNo = Integer.parseInt(tokenizer.nextToken());
            while (participantNo-- > 0) {
                int participant = Integer.parseInt(tokenizer.nextToken());
                party.add(participant);
                if (know[participant]) flag = true;
            }
            parties.add(party);

            // Merge parties to group
            Set<Integer> group = new HashSet<>(party);
            for (Integer member : party) if (groups.containsKey(member)) group.addAll(groups.get(member));

            // Add group to groups
            for (Integer member : group) {
                groups.put(member, group);
                if (flag) know[member] = true;  // If anyone in the group knows the truth everyone will know it
            }
        }

        // Count parties that no one knows the truth
        int count = 0;
        for (Set<Integer> party : parties) {
            // Everyone in the party has same state of knowing truth
            // So can check anyone's truth knowing state
            Integer member = party.iterator().next();       // Checking first person
            Set<Integer> group = groups.get(member);        // Getting group that member belongs to
            if (!know[group.iterator().next()]) count++;    // If first member of group doesn't know the truth count
        }

        result.append(count);
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}