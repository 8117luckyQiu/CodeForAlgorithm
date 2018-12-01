package sort;

public class HeapSort {
	public static void exch(int[] sort,int i,int j) 
	{int t=sort[i];sort[i]=sort[j];sort[j]=t;}
	public static void main(String[] args) {
		int[] arr = {5,3,1,9,8,2,4,7};
		show(arr);
		heapSort(arr);
		show(arr);
		
	}
	public static void heapSort(int[] arr){
		for (int i = arr.length/2-1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		for (int j = arr.length-1; j>0; j--) {
			exch(arr,0,j);
			adjustHeap(arr,0,j);
		}
	}
	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int k=i*2+1; k<length; k=i*2+1) {
			if (k+1 < length && arr[k] < arr[k+1]) {
				k = k+1;
			}
			if (temp < arr[k]) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
	public static void show(int[] arr) {
		for(int i=0;i<arr.length ;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
