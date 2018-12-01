package sort;

public class MergeSort4 {
	private static boolean less(Comparable w,Comparable v) 
	{return w.compareTo(v)<0;}
	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	private static Comparable[] aux;
	public static void main(String[] args) {
		String[] sorts = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
		aux=new Comparable[sorts.length];
		sort(sorts,0,sorts.length-1);
		show(sorts);
		 
	}
	private static void sort(Comparable[] a,int left,int right) {
		if(left>=right) return;
		int mid=(left+right)/2;
		sort(a,left,mid);
		sort(a,mid+1,right);
		copy(a,left,mid,right);
	}
	private static void copy(Comparable[] a,int left,int mid,int right) {
		int i=left,j=mid+1;
		for(int k=left;k<=right;k++)
			aux[k]=a[k];
		for(int k=left;k<=right;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>right) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	private static void show(Comparable[] a) {
		for(int k=0;k<a.length;k++)
			System.out.print(a[k]+" ");
	}
}
