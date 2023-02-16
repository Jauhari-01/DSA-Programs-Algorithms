public class PrintCharWithFre{
    public static void main(String[] args) {
        String s = "shubhamjauhari";
        int[] fre = new int[26];

        for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            fre[ch - 'a']++;
        }

        String ans = fun1(s,fre);
        System.out.println(ans);
    }

    static String fun2(String s,int[] fre){
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(fre[ch-'a'] != 0){
                sb.append(ch);
                sb.append(fre[ch-'a']+" ");
                fre[ch-'a'] = 0;
            }
        }

        return sb.toString();

    }
    static String fun1(String s,int[] fre){
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(fre[ch-'a'] != 0){
                sb.append(ch);
                sb.append(fre[ch-'a']+" ");
                fre[ch-'a'] = 0;
            }
        }

        return sb.toString();

    }
}