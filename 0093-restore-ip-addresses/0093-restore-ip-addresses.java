import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(String s, int index, int count,
                   List<String> parts, List<String> result) {

        if (count == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            if (Integer.parseInt(part) > 255) {
                break;
            }

            parts.add(part);

            backtrack(s, index + len, count + 1, parts, result);

            parts.remove(parts.size() - 1);
        }
    }
}