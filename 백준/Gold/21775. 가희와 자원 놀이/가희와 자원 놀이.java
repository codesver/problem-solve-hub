import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());

        Queue<Integer> playSequence = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));

        Queue<Card> cards = new LinkedList<>();
        while (T-- > 0) cards.offer(new Card(reader.readLine().split(" ")));

        Game game = new Game(cards);

        while (!playSequence.isEmpty()) result.append(game.play(playSequence.poll())).append('\n');
    }

    public void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}

class Game {

    private final Map<Integer, Card> playersHoldingCard = new HashMap<>();
    private final Set<Integer> takenResources = new HashSet<>();
    private final Queue<Card> cards;

    public Game(Queue<Card> cards) {
        this.cards = cards;
    }

    public int play(int pno) {
        Card card = playersHoldingCard.get(pno);
        if (card != null) {
            if (!takenResources.contains(card.getRNO())) {
                playersHoldingCard.remove(pno);
                takenResources.add(card.getRNO());
            }
        } else {
            card = cards.poll();
            assert card != null;
            if (card.commandOfCard().equals("acquire"))
                if (takenResources.contains(card.getRNO())) playersHoldingCard.put(pno, card);
                else takenResources.add(card.getRNO());
            else if (card.commandOfCard().equals("release")) takenResources.remove(card.getRNO());
        }
        return card.getCNO();
    }
}

class Card {

    private final int CNO;
    private final String COMMAND;
    private final int RNO;

    public Card(String... infos) {
        CNO = Integer.parseInt(infos[0]);
        COMMAND = infos[1];
        RNO = infos.length == 3 ? Integer.parseInt(infos[2]) : 0;
    }

    public int getCNO() {
        return CNO;
    }

    public String commandOfCard() {
        return COMMAND;
    }

    public int getRNO() {
        return RNO;
    }
}