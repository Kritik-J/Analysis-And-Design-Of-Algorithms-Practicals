class Cell{
    char direction;
    int count;

    Cell(char direction, int count){
        this.direction=direction;
        this.count = count;
    }
}

public class practical16 {

    public static void getString(Cell[][] matrix, String s1, int i, int j){
        if(i==0 || j==0){
            return;
        } else if(matrix[i][j].direction == 'd'){
            getString(matrix, s1, i-1,j-1);
            System.out.print(s1.charAt(i-1));
        } else if(matrix[i][j].direction == 'u'){
            getString(matrix, s1, i-1,j);
        } else{
            getString(matrix, s1, i, j-1);
        }
    }

    public static void LCS(String s1, String s2){

        Cell[][] matrix = new Cell[s1.length()+1][s2.length()+1];

        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i==0 || j==0){
                    matrix[i][j] = new Cell('o', 0);
                } else if(Character.toLowerCase(s1.charAt(i-1)) == Character.toLowerCase(s2.charAt(j-1))){
                    matrix[i][j] = new Cell('d', matrix[i-1][j-1].count+1);
                } else{
                    int max = matrix[i-1][j].count;
                    if(max > matrix[i][j-1].count){
                    matrix[i][j] = new Cell('u', max);
                    } else{
                        max = matrix[i][j-1].count;
                        matrix[i][j] = new Cell('l', max);
                    }
                }
            }
        }

        getString(matrix, s1, s1.length(), s2.length());
    }


    public static void main(String[] args) {
        String str1 = "providence";
        String str2 = "president";
        LCS(str1, str2);
    }
}
