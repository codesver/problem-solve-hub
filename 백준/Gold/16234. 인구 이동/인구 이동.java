import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Country {
        int row, col;
        int population;
        boolean unionized;

        public Country(int row, int col, int population) {
            this.row = row;
            this.col = col;
            this.population = population;
        }
    }

    final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int N, L, R;
    Country[][] countries;

    public void solve() throws IOException {
        init();
        result.append(migration());
    }

    private int migration() {
        int day = 0;
        while (searchCountries()) day++;
        return day;
    }

    private boolean searchCountries() {
        List<List<Country>> unions = new ArrayList<>();
        for (int r = 1; r <= N; r++)
            for (int c = 1; c <= N; c++)
                if (!countries[r][c].unionized)
                    unions.add(new ArrayList<>(searchUnionsOf(countries[r][c])));
        unions.forEach(union -> union.forEach(country -> country.unionized = false));
        return unions.size() != N * N;
    }

    private List<Country> searchUnionsOf(Country baseCountry) {
        baseCountry.unionized = true;
        int totalPopulation = baseCountry.population;

        List<Country> unions = new ArrayList<>(Collections.singleton(baseCountry));
        Queue<Country> neighbors = new LinkedList<>(Collections.singleton(baseCountry));
        while (!neighbors.isEmpty()) {
            Country country = neighbors.poll();
            for (int[] move : moves) {
                Country neighbor = countries[country.row + move[0]][country.col + move[1]];
                if (neighbor == null) continue;
                int sub = Math.abs(country.population - neighbor.population);
                if (!neighbor.unionized && L <= sub && sub <= R) {
                    totalPopulation += neighbor.population;
                    neighbor.unionized = true;
                    neighbors.offer(neighbor);
                    unions.add(neighbor);
                }
            }
        }

        for (Country country : unions) country.population = totalPopulation / unions.size();
        return unions;
    }

    private void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());
        countries = new Country[N + 2][N + 2];
        for (int r = 1; r <= N; r++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= N; c++) countries[r][c] = new Country(r, c, Integer.parseInt(tokenizer.nextToken()));
        }
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