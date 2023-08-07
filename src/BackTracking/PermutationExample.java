package BackTracking;

public class PermutationExample {
    public void printPermutation(String str, String perm, int idx) {
        //if perm
        if (str.length() == 0) {
            System.out.println();
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newstr, perm + currChar, idx + 1);
        }
    }
}