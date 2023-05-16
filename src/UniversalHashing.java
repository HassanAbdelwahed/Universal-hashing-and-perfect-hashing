import java.util.Arrays;
import java.util.Random;

public class UniversalHashing {
    int U;
    int M;
    int b;
    private int[][] h;
    private int[][] x;
    private int[][] h_X;
    Random rand;

    public UniversalHashing(int m) {
        U = 31;
        M = m;
        b = (int)(Math.log(M) / Math.log(2));
        this.rand = new Random();
        h = new int[b][U];
        generateMatrix();
    }
    public void generateMatrix(){
        if (b == 0)
            return;
        for (int i = 0; i < h.length; i++){
            for (int j = 0; j < h[0].length; j++){
                h[i][j] = rand.nextInt(2);
            }
        }
    }
    public void convertDecimalToBinary(int key){
        x = new int[U][1];
        String temp = Integer.toBinaryString(key);
        int j = temp.length() - 1;
        for (int i = x.length - 1; i >= 0; i--){
            x[i][0] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            j--;
            if (j < 0)
                break;
        }
    }
    public void multiply(){
        h_X = new int[h.length][1];
        for(int i = 0; i < h.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                for (int k = 0; k < x.length; k++) {
                    h_X[i][j] += h[i][k] * x[k][j];
                }
                h_X[i][j] = h_X[i][j] % 2;
            }
        }
    }

    public int convertBinaryToDecimal(){
        int x = 0;
        int po = h_X.length - 1;
        for (int i = h_X.length - 1; i >= 0; i--){
            x += (h_X[h_X.length - 1 - i][0] * Math.pow(2, i));
        }
        return x;
    }
    public int getHashValue(int key){
        if (b == 0)
            return 0;
        convertDecimalToBinary(key);
        multiply();

        return convertBinaryToDecimal();
    }

    public void updateHashMatrix(){
        generateMatrix();
    }
}
