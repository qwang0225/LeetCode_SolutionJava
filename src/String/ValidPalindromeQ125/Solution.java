package String.ValidPalindromeQ125;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
class Solution {
    public boolean isPalindrome(String s) {
        // if string is null, return false
        if (s==null){
            return false;
        }
        // if string has length less than or equal 1, return true
        if (s.length() <= 1){
            return true;
        }
        // convert the string to lowercase and remove all non-alphanumeric characters
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        // use recursion to check if the string is palindrome
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }
}
