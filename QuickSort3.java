package sort;

public class QuickSort3 {
	
	private static boolean less(Comparable a,Comparable b) 
	{return a.compareTo(b)<0;}
	private static void exch(Comparable[] a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	public static void main(String[] args) {
		Comparable[] a= {5,3,1,9,8,2,4,7};
		sort(a,0,a.length-1);
		show(a);
	}
	private static void sort(Comparable[]a,int lo,int hi){
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo,j=hi+1;
		Comparable x=a[lo];
		while(true) {
			while(less(a[++i],x)) if(i==hi) break;
			while(less(x,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private static void show(Comparable[] a) {
		for(int t=0;t<a.length;t++)
			System.out.print(a[t]+" ");
		
	}
}
