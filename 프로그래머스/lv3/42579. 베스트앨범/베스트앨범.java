import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(i, plays[i]);
            Genre genre = map.getOrDefault(genres[i], new Genre(genres[i]));
            genre.addMusic(music);
            map.put(genres[i], genre);
        }

        return map.values().stream()
                .sorted(Comparator.reverseOrder())
                .flatMapToInt(genre -> {
                    Queue<Music> musics = genre.musics;
                    if (musics.size() >= 2) return IntStream.of(musics.poll().idx, musics.poll().idx);
                    else return IntStream.of(musics.poll().idx);
                }).toArray();
    }
}

class Genre implements Comparable<Genre> {

    String genre;
    Queue<Music> musics = new PriorityQueue<>(Comparator.reverseOrder());
    int total = 0;

    public Genre(String genre) {
        this.genre = genre;
    }

    public void addMusic(Music music) {
        musics.add(music);
        total += music.play;
    }

    @Override
    public int compareTo(Genre o) {
        return total - o.total;
    }
}

class Music implements Comparable<Music> {

    int idx, play;

    public Music(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public int compareTo(Music o) {
        return play - o.play;
    }
}