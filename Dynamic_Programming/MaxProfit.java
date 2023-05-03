import java.util.Scanner;

public class MaxProfit{

    static int solution(int []wt, int []pt, int size, int w)
    {

        // matrix 
        int dp[][] = new int[size+1][w+1];

        for(int i=0; i<size+1; i++){
            for(int j=0; j<w+1; j++){

                if(i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<size+1; i++){
            for(int j=1; j<w+1; j++){

                if(j >= wt[i-1])
                {
                    dp[i][j] = Math.max( (pt[i-1]+ dp[i-1][j-wt[i-1]]), dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }

        return dp[size][w];

    }
    public static void main(String args[]){


        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");

        int size = input.nextInt();
        int wt[] = new int[size];
        int pt[] = new int[size];

        System.out.println("Enter the Elements in the weight : ");

        for(int i=0; i<size; i++){
            wt[i] = input.nextInt();
        }
        System.out.println("Enter the Elements in the profit : ");

        for(int i=0; i<size; i++){
            pt[i] = input.nextInt();
        }
        System.out.println("Maximum weight : ");
        int max = input.nextInt();

        System.out.println("sum is possible : "+ solution(wt, pt, size, max ));
    }
}