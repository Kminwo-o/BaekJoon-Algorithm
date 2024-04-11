import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    static class Person implements Comparable<Person>{
        int age;
        String name;
        int join;

        public Person(int age, String name, int join) {
            this.age = age;
            this.name = name;
            this.join = join;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) {
                return this.join - o.join;
            }

            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        Collections.sort(people);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(people.get(i).age).append(" ").append(people.get(i).name).append("\n");
        }

        System.out.println(sb);
    }
}