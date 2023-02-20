
public class NinjasTraining {

    /*
     * A Ninja has an ‘N’ Day training schedule. 
     * He has to perform one of these three activities 
     * (Running, Fighting Practice, or Learning New Moves) each day. 
     * There are merit points associated with performing an activity each day. 
     * The same activity can’t be performed on two consecutive days. We need to 
     * find the maximum merit points the ninja can attain in N Days.

        We are given a 2D Array POINTS of size ‘N*3’ which tells 
        us the merit point of specific activity on that particular day. 
        Our task is to calculate the maximum number of merit points that 
        the ninja can earn.

        Sample Input 1:
            2
            3
            1 2 5 
            3 1 1
            3 3 3
            3
            10 40 70
            20 50 80
            30 60 90
        Sample Output 1:
            11
            210
    */

    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        // int[][] dp = new int[n][4];
        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }

        // return memo(n-1,3,dp,points); 
        return tabulation(points,n);                                                                                      
    }

    
    // static int recurence relation for this(int day,int last,int[][] points){
    //     if(day ==0){
    //         int max = 0;
    //         for(int i=0 ; i<=2 ; i++){
    //             if(last != i){
    //                 max = Math.max(points[0][i],max);
    //             }
    //         }

    //         return max;
    //     }

    //     //for other case
    //     int max = 0 ; 
    //     for(int i=0 ; i<=2  ; i++){
    //         if(last != i){
    //             int activity = points[day][i] + solve1(day-1,i, dp, points);
    //             max = Math.max(max,activity);
    //         }
    //     }

    //     return max;
    // }
    static int memo(int day,int last,int[][] dp,int[][] points){
        
        if(day ==0){
            int max = 0;
            for(int i=0 ; i<=2 ; i++){
                if(last != i){
                    max = Math.max(points[0][i],max);
                }
            }

            return max;
        }


        if(dp[day][last] != -1){
            return dp[day][last];
        }
        //for other case
        int max = 0 ; 
        for(int i=0 ; i<=2  ; i++){
            if(last != i){
                int activity = points[day][i] + memo(day-1,i, dp, points);
                max = Math.max(max,activity);
            }
        }

        return dp[day][last] =max;
    }
    static int tabulation(int[][] points,int n){
        int[][] dp = new int[n][4];

        //for base case
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][0] = Math.max(points[0][2],points[0][1]);
        dp[0][3] = Math.max(points[0][2],(Math.max(points[0][0],points[0][1])));


        //now other case
        for(int day=1 ; day<n ; day++){

            //for last activity
            for(int last = 0 ; last < 4 ; last++){
                //now for task
                for(int task = 0 ; task <= 2 ; task++){
                    if(task != last){
                        int activity = points[day][task]+dp[day-1][task];

                        dp[day][last] = Math.max(activity,dp[day][last]);
                    }
                }
            }

            
        }

        return dp[n-1][3];
    }
}
