public class HouseRobber2 {

    //Problem related with MaximumSumOfNonAdjacentElements
    /*
     * A thief needs to rob money in a street. 
     * The houses in the street are arranged in a circular manner. 
     * Therefore the first and the last house are adjacent to each other. 
     * The security system in the street is such that if adjacent houses are robbed, 
     * the police will get notified.

        Given an array of integers “Arr” which represents money at each house, 
            we need to return the maximum amount of money that 
            the thief can rob without alerting the police.

    
     Sample Input 2:
        3
        5
        1 5 1 2 6
        3
        2 3 5
        4
        1 3 2 0
    Sample Output 2:
        11
        5
        3

    */
    public static long houseRobber(int[] valueInHouse) {
		// Write your code here.

		int n = valueInHouse.length;
		if(n == 1){
			return valueInHouse[0];
		}
		long ans = maxNotAdjecentSum(valueInHouse,0,n-2); //leaving last element
		long ans2= maxNotAdjecentSum(valueInHouse,1,n-1); // leaving first element

		return Math.max(ans,ans2);
	}	

	static long maxNotAdjecentSum(int[] arr,int start,int end){
		long pre1 = arr[start];
		long pre2 = 0L;

		for(int i = start+1 ; i<=end ; i++){
			long pic = arr[i];

			if(i > start+1){
				pic += pre2;
			}

			long notpick = 0 + pre1;

			long cur_i = Math.max(pic,notpick);
			pre2 = pre1;
			pre1 = cur_i;
		}

		return pre1;

	}
}

