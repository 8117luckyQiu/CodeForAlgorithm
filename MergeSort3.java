package sort;

public class MergeSort3 {
	public static void main(String[] args) {
		int a[] = {5,3,1,9,8,2,4,7};
		sort(a,0,a.length-1);
		System.out.println("最后一次");
		show(a);
		
	}
	private static void sort(int[] a, int left, int right) {
 		if(right<= left) return;
		int mid=(right+left)/2;
		sort(a,left,mid);
		sort(a,mid+1,right);
		copy(a,left,mid,right);
		show(a);
		
	}
	private static void copy(int[] a, int left, int mid, int right) {
		int i=left,j=mid+1;
		int[] aux=new int[a.length];
		for(int k=left;k<=right;k++)
			aux[k]=a[k];
		for(int k=left;k<=right;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>right) a[k]=aux[i++];
			else if (aux[j]<aux[i]) a[k]=aux[j++];
			else  a[k]=aux[i++];
		}
	}
	private static void show(int []a) {
		for(int t=0;t<a.length;t++)
			System.out.print(a[t]+" ");
		System.out.println();
	}

}
