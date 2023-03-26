package AdvanceDSA.BackTracking.QuestionOnPermutationCombination.Premutation;

public class PrintAllPermutationOfString {
    public static void main(String[] args) {
		String s = "abc";
        printPermutations(s,"");
    }

    private static void printPermutations(String s, String ans) {

        //base case
        if(0 == s.length()){
            
            System.out.println(ans);
            return;
        }

        //Recusion part
        //Choices
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            String newString = s.substring(0,i) + s.substring(i+1);
            printPermutations(newString,ans+ch);
        }
    }
}
