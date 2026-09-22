class Solution {
    public boolean isSameAfterReversals(int num) {

        int original = num;
        int reversed1 = 0;
        int reversed2 = 0;

        while (num > 0) {
            int last_digit = num % 10;
            reversed1 = reversed1 * 10 + last_digit;
            num = num / 10;
        }

        while (reversed1 > 0) {
            int last_digit = reversed1 % 10;
            reversed2 = reversed2 * 10 + last_digit;
            reversed1 = reversed1 / 10;
        }

        return reversed2 == original;
    }
}