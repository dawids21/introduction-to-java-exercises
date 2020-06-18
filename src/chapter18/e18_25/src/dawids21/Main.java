package dawids21;

public class Main {

    public static void main(String[] args) {
        displayPermutation("abc");
    }

    public static void displayPermutation(String str) {
        displayPermutation("", str);
    }

    private static void displayPermutation(String permutation, String str) {
        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            displayPermutation(permutation + ch, str.replaceFirst(String.valueOf(ch), ""));
        }
    }
}
