package test.vandeursen.org;

import com.google.common.base.Strings;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

public class Main {
    public static void main(String[] args) {
        System.out.println(triple("Hello World!"));
        System.out.println("My name is " + System.getProperty("jmodern.name"));
        
        // generate a list of 100 random names
        List<String> students = range(0, 100).mapToObj(i -> randomString(new Random(), 'A', 'Z', 10)).collect(toList());

        // sort names and group by the first letter
        Map<Character, List<String>> directory = students.stream().sorted().collect(groupingBy(name -> name.charAt(0)));

        // print a nicely-formatted student directory
        directory.forEach((letter, names) -> System.out.println(letter + "\n\t" + names.stream().collect(joining("\n\t"))));
     
        // does the same as above, only written shorter
        range(0, 100)
            .mapToObj(i -> randomString(new Random(), 'A', 'Z', 10))
            .sorted()
            .collect(groupingBy(name -> name.charAt(0)))
            .forEach((letter, names) -> System.out.println(letter + "\n\t" + names.stream().collect(joining("\n\t"))));
        
    }

    static String triple(String str) {
        return Strings.repeat(str, 3);
    }
    
    /**
 * ## The Random String Generator
 *
 * This method doesn't do much, except for generating a random string. It:
 *
 *  * Generates a random string at a given length, `length`
 *  * Uses only characters in the range given by `from` and `to`.
 *
 * Example:
 *
 * ```java
 * randomString(new Random(), 'a', 'z', 10);
 * ```
 *
 * @param r      the random number generator
 * @param from   the first character in the character range, inclusive
 * @param to     the last character in the character range, inclusive
 * @param length the length of the generated string
 * @return the generated string of length `length`
 */
 public static String randomString(Random r, char from, char to, int length){
    return r.ints(from, to + 1).limit(length).mapToObj(x -> Character.toString((char)x)).collect(joining());
 }
    
}