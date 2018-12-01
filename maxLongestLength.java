package sort;
public class maxLongestLength {

	public static void main(String[] args) {
		int[]arr = {-2,11,-4,13,-7,2,-6};
		System.out.println("The maxSum is "+ maxSum(arr));

	}
	public static int maxSum(int[] arr) {
		int sum=0;int b=0;
		for(int i=1;i<arr.length;i++) {
			if(b>0) b+=arr[i];
			else b=arr[i];
			if(b>sum)sum=b;
		}
		return sum;
	}

}
