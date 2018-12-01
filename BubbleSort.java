package sort;

public class BubbleSort {
	public static boolean less(Comparable v,Comparable w) 
	{return v.compareTo(w)<0;}
	public static void exch(Comparable[] sort,int i,int j) 
	{Comparable t=sort[i];sort[i]=sort[j];sort[j]=t;}
	public static void main(String[] args) {
		Comparable[] arr = {5,3,1,9,8,2,4,7};
		bubbleSort(arr);
	}
	public static void bubbleSort(Comparable[] arr){
		boolean flag = true;
		while(flag == true) {
			flag = false;
			for(int i=0;i<arr.length-1;i++)
				for(int j=0;j<arr.length-i-1;j++)
					if(less(arr[i+1],arr[i])) {
						exch(arr,i+1,i);
						flag=true;
					}
			
			for(int i = 0;i < arr.length;i++)
				System.out.print(arr[i]+"	");
			System.out.println();
			
		}
	}
}
