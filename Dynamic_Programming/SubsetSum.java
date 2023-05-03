import java.util.Scanner;

public class SubsetSum{

    // top-down approach
    static boolean isSum(int arr[], int n, int sum)
    {
        boolean dp[][] = new boolean[n+1][sum+1];

        // Initialization
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {

                if(i == 0)
                {
                    dp[i][j] = false;
                }
                if(j == 0)
                {
                    dp[i][j] = true;
                }
              

            }
        }

        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {

            if(arr[i-1] <= j)

            {
                dp[i][j] = dp[i][j- arr[i-1]] || dp[i-1][j];
            }
            else{
                dp[i][j] = dp[i-1][j];
            }

            }
        }

        if(dp[n][sum])
        {
            return true;
        }
       return false;

    }

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");

        int size = input.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the Elements in the Array : ");

        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Ente the sum of array : ");
        int sum = input.nextInt();

        System.out.println("sum is possible : "+ isSum(arr, size, sum));

    }
}