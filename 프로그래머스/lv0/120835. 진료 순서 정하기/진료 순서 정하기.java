import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] emergency) {
        List<Person> people = IntStream.range(0, emergency.length)
                .mapToObj(i -> new Person(i, emergency[i]))
                .sorted((o1, o2) -> o2.e - o1.e)
                .collect(Collectors.toList());
        IntStream.range(0, emergency.length).forEach(s -> people.get(s).s = s + 1);
        return people.stream()
                .sorted(Comparator.comparingInt(o -> o.i))
                .mapToInt(person -> person.s)
                .toArray();
    }
}

class Person {

    int i, e, s;

    public Person(int i, int e) {
        this.i = i;
        this.e = e;
    }
}