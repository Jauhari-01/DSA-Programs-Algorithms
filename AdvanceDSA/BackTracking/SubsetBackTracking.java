package AdvanceDSA.BackTracking;

public class SubsetBackTracking {
    public static void main(String[] args) {
        String s = "abc";
        printSubset(s,"",0);
    }

    private static void printSubset(String s, String string, int i) {

        //base case
        if(i == s.length()){
            if(string.length() == 0)
            System.out.println("null String");
            else
            System.out.println(string);
            return;
        }

        //Recusion part
        //Chois---> yes 
        printSubset(s, string+s.charAt(i), i+1);
        //chois ---> no
        printSubset(s, string, i+1);
    }
}
