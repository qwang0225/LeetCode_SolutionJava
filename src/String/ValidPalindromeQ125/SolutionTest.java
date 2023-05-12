package String.ValidPalindromeQ125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testIsPalindrome() {
        Solution sol = new Solution();
        assertFalse(sol.isPalindrome(null));
        assertTrue(sol.isPalindrome(""));
        assertTrue(sol.isPalindrome("a"));
        assertTrue(sol.isPalindrome("s,,,s,,ss"));
        assertTrue(sol.isPalindrome("si  s"));
        assertTrue(sol.isPalindrome("isiso  pspsppsps  posisi"));
        assertFalse(sol.isPalindrome("sd"));

        Solution1 sol1 = new Solution1();
        assertFalse(sol1.isPalindrome(null));
        assertTrue(sol1.isPalindrome(""));
        assertTrue(sol1.isPalindrome("a"));
        assertTrue(sol1.isPalindrome("s,,,s,,ss"));
        assertTrue(sol1.isPalindrome("si  s"));
        assertTrue(sol1.isPalindrome("isiso  pspsppsps  posisi"));
        assertFalse(sol1.isPalindrome("sd"));
    }
}