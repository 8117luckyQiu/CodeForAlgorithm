package sort;

public class MergeSort2 {
	private static boolean less(Comparable v,Comparable w) 
	{return v.compareTo(w)<0;}
	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	private static Comparable[] aux;
	public static void main(String[] args) {
		String[] sorts = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
		aux=new Comparable[sorts.length];
		sort(sorts,0,sorts.length-1);
		for(int k=0;k<sorts.length;k++)
			System.out.print(sorts[k]+" ");

	}
	private static void sort(Comparable[] sorts,int left,int right) {
		
		if(right<=left) return;
		int mid=left+(right-left)/2;
		sort(sorts,left,mid);
		sort(sorts,mid+1,right);
		copy(sorts,left,mid,right);
		
		
	}
	private static void copy(Comparable[] sorts, int left, int mid, int right) {
		int i=left,j=mid+1;
		for(int k=left;k<=right;k++)
			aux[k]=sorts[k];
		for(int k=left;k<=right;k++) 
		{
			if(i>mid) sorts[k]=aux[j++];
			else if(j>right) sorts[k]=aux[i++];
			else if(less(aux[j],aux[i])) sorts[k]=aux[j++];
			else sorts[k]=aux[i++];
		}
		
	}

}
