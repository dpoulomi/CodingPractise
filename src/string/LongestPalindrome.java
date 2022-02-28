package string;

public class LongestPalindrome {
  public static void main(String[] args) {
    String palindromicString = "apqjpwedlhmvvpexxnntxheeynxmgzwxhnhfdvziuxnuusymklgcacndoyhqkoahnkyaikohwkmnuphipftmzmihvmoetskioeypwjujvvusaxynzxxdugnebsisrtgeujkqkgwjuplijhluumqcdurovyjsbowmnqndejwkihzbbdyxjunkduyqeihektaknbmkzgnnmgywylulxwyywrvieqfenjeljofkqqqisdjsbfkvqgahxwkfkcucvrbbpyhwkfztjdboavtfynrudneieelwlcezqsuhmllcsadcnoyemsfdlrijoyj";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    System.out.println(longestPalindrome.findLongestPalindrome(palindromicString));
  }

  private String findLongestPalindrome(String palindromicString) {
    if(palindromicString.length() == 1 || isPalindrome(palindromicString)){
      return palindromicString;
    }
    int palindromeLength = 0;
    String palindrome = "";

    for (int i = 0; i < palindromicString.length(); i++) {
      for (int j = i + 1; j <= palindromicString.length(); j++){
        String s = palindromicString.substring(i, j);
      if (isPalindrome(s)) {
        if (s.length() > palindromeLength) {
          palindromeLength = s.length();
          palindrome = s;
        }

      }
    }
    }
    return palindrome;
  }

  private boolean isPalindrome(String s) {
    char[] array = s.toCharArray();
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (array[i] != array[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
