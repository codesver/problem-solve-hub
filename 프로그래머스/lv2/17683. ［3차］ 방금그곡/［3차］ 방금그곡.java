import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.IntStream;

class Solution {
    public String solution(String m, String[] musicInfos) {
        Optional<Music> heardMusic = IntStream.range(0, musicInfos.length)
                .mapToObj(index -> new Music(index, musicInfos[index]))
                .filter(music -> music.playedIntervalsIncludes(m))
                .max((preMusic, postMusic) -> {
                    if (preMusic.duration() == postMusic.duration()) return postMusic.index - preMusic.index;
                    else return (int) (preMusic.duration() - postMusic.duration());
                });
        return heardMusic.isPresent() ? heardMusic.get().title : "(None)";
    }
}

class Music {

    final int index;
    final String title;
    final LocalTime start, end;
    final String playedIntervals;

    public Music(int index, String info) {
        this.index = index;

        String[] infos = info.split(",");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        start = LocalTime.parse(infos[0], formatter);
        end = LocalTime.parse(infos[1], formatter);

        title = infos[2];

        int playedTime = (int) (Duration.between(start, end).getSeconds() / 60);
        String intervals = changeSharpToSingleInterval(infos[3]);
        playedIntervals = intervals.repeat(playedTime / intervals.length())
                + intervals.substring(0, playedTime % intervals.length());
    }

    public boolean playedIntervalsIncludes(String intervals) {
        String s = changeSharpToSingleInterval(intervals);
        return playedIntervals.contains(s);
    }

    public long duration() {
        return Duration.between(start, end).getSeconds();
    }

    private String changeSharpToSingleInterval(String intervals) {
        StringBuilder changer = new StringBuilder(intervals);
        for (int i = 0; i < changer.length(); i++) {
            if (changer.charAt(i) == '#') {
                changer.setCharAt(i - 1, Character.toLowerCase(changer.charAt(i - 1)));
                changer.deleteCharAt(i--);
            }
        }
        return changer.toString();
    }
}