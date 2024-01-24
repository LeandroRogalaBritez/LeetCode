/**
 *     You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 */
public class StringVowelCounter {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book")); // true
        System.out.println(halvesAreAlike("textbook")); // false
    }

    private static boolean halvesAreAlike(String s) {
        int lenght = s.length();

        if (!isEvenLength(lenght)) {
            return false;
        }
        if (lenght < 2 || lenght > 1000) {
            return false;
        }

        String a = s.substring(0, lenght / 2);
        String b = s.substring(lenght / 2);

        int vowelA = countVowel(a);
        int vowelB = countVowel(b);

        return vowelA == vowelB;
    }

    private static boolean isEvenLength(int length) {
        return length % 2 == 0;
    }

    private static int countVowel(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
