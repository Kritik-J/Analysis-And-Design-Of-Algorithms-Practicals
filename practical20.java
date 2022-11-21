public class practical20 {
    public static void main(String[] args) {
        String text = "To be is not to be and to not to be is to be";
        String pattern = "not";

        RabinKarp(text, pattern);
    }

    static void RabinKarp(String text, String pattern){
        int patternHash = createHash(pattern);
        int patternLength = pattern.length();
        boolean flag = false;

        for(int i=0; i<text.length() - patternLength + 1;i++){
            int textHash = createHash(text.substring(i,i+patternLength));

            if(textHash == patternHash){
                for(int j=0; j<patternLength;j++){
                    if(!(text.charAt(i+j) == pattern.charAt(j))){
                        break;
                    }
                }
                flag = true;
                System.out.println("Pattern match at index " + i);
            }
        }

        if(!flag){
            System.out.println("Pattern not found");
        }
    }

    static int createHash(String input){
        int n = input.length();
        int hash = 0;

        for(int i=0; i<n; i++){
            int result = (int) (input.charAt(i) * Math.pow(26,n-1-i))%Integer.MAX_VALUE;
            hash += result;
        }
        return hash;
    }
}
