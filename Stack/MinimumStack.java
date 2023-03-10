package Stack;
import java.util.*;
/*
 * 
 *      Minimum Stack
            Design a stack that supports push, pop and retrieving the minimum element 
            in constant time.

            You are required to complete the three methods push() which take one 
            argument an integer 'x' to be pushed into the stack, pop() which returns 
            a integer poped out from the stack and getMin() which returns the minimum 
            element from the stack. (-1 will be returned if for pop() and getMin() 
            the stack is empty.)

            Input Format:
                You just need to complete the three function provided to you.

            Output Format:
                You need to return one integer in case of pop() 
                and getMin() function representing the top element of the 
                stack and minimum element in the stack respectively.

            Example 1:
                Input:
                    push(2)
                    push(3)
                    pop()
                    getMin()
                    push(1)
                    getMin()

                Output:
                    3 2 1
            Explanation:

            The first two operation pushes 2 and 3 into the stack. 
            The minimum element currently is 2 and top element is 3.
            Next operation pops the top element in the stack which is 3 and return it.
            Next operation returns the minimum element in the stack which is 2.
            Now we push 1 into the stack.
            Next operation returns the minimum element in the stack which is 1.

            Example 2:
                Input:

                    push(5)
                    push(8)
                    push(4)
                    push(6)
                    getMin()
                    pop()
                    pop()
                    getMin()
                
                Output:
                    4 6 4 5

            Explanation:

            In first four operation we push 5 8 4 6 into the stack.
            In next operation we will get minimum element of the stack which is 4.
            In next two operation we will pop the top element of the stack. 
            We will get two integers which are 6 and 4.
            In last operation we will get minimum of the stack which is 5.

            Constraints:
                1 <= T <= 10
                1 <= Number of queries <= 100
                1 <= values of the stack <= 100
 * 
*/
class MinimumStack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			Solution g = new Solution();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
        sc.close();
		
	}
}

class Solution
{
	int minEle;
	Stack<Integer> s;
    
	Solution()
	{
		s = new Stack<Integer>();
		minEle = -1;
	}

	/*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    Stack<Integer> st = new Stack<>();
	    s.stream().forEach(x -> st.push(x));
	    Collections.sort(st);
	    if(st.isEmpty()){
	        return -1;
	    }
	    
	    return st.get(0);
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	    if(s.isEmpty()){
	        return -1;
	    }else{
	        return s.pop();
	    }
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    // Your code here	
	    s.push(x);
    }	
}
