package sort;
import java.util.Scanner;
public class BinarySearch {
	
	private static int search(int []a,int x,int n,int i , int j) {
		int left = 0,right = n-1;
		int flag = 0;
		while(left <= right) {
			int middle = (left + right) / 2;
			if(x == a[middle]){
				flag = 1;
				System.out.println("The index of the number is:"+middle);
				return middle;
			}
			if(x > a[middle]) left = middle + 1;
			else right = middle -1;
			i = left;
			j = right;
		}
		if(flag == 0)
			System.out.println("大于" + x + "的最小元素位置为" + j + ",小于" + x + "的最大元素位置为" + i );
		return -1;
	}
	public static void main(String[] args) {
		int[]a ={-15,-6,0,7,9,23,54,82,101};
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the number you want to find:");
		int x = scan.nextInt();
		search(a,x,a.length-1,0,a.length-1);
	}
}
