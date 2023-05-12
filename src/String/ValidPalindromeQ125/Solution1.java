package String.ValidPalindromeQ125;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
class Solution1 {
    public boolean isPalindrome(String s) {
        // if string is null, return false
        if (s == null) {
            return false;
        }
        // convert the string to lowercase and remove all non-alphanumeric characters
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        // if string has length less than or equal 1, return true
        if (s.length() <= 1) {
            return true;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            // if the first character is not equal to the last character, return false
            // odd length: the central position would be left alone unchecked, but does not matter
            // even length: all positions will be checked
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

