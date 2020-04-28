import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> seen = new ArrayList<>();
        int greatestLengthWithoutRepeat = 0;

        for ( int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (!seen.contains(c)) {
                seen.add(c);

                if (seen.size() > greatestLengthWithoutRepeat) {
                    greatestLengthWithoutRepeat = seen.size();
                }
            }
            else {
                seen.add(c);

                while (true) {
                    if (seen.get(0) == c) {
                        seen.remove(0);
                        break;
                    }

                    seen.remove(0);
                }
            }
        }

        return greatestLengthWithoutRepeat;
    }
}
