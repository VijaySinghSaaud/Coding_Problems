import java.util.Scanner;
import java.util.HashSet;

public class CountSub{

// function 
static int SubSetSum(int arr[], int n, int sum)
{
    // top-down approach
    int dp[][] = new int[n+1][sum+1];

    for(int i=0; i<n+1; i++)
    {
        for(int j =0; j<sum+1; j++)
        {
            if(i ==0 )
            {
                dp[i][j] = 0;
            }
            if(j == 0)
            {
                dp[i][j] = 1;
            }
        }
    }
    HashSet<Integer>list = new HashSet<>();
    for(int i=1; i<n+1; i++)
    {
        for(int j =1; j<sum+1; j++)
        {
            if(arr[i-1] <= j)
            {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                list.add(j);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    System.out.println(list);
    return dp[n][sum];


}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); // scanner class
        System.out.println("Enter the size : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the Elements : ");
        for(int i=0; i<size; i++)
        {
            arr[i] =  sc.nextInt();
        }
        System.out.println("Enter the Sum : ");
        int sum = sc.nextInt();

        // function call
        System.out.println("Ans is :"+ SubSetSum(arr, size ,sum));
    }
}