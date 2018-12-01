package sort;

public class MergeSort {
	private static boolean less(Comparable w,Comparable v)
	{return w.compareTo(v)<0;}
	private static void exch(Comparable[] a,int i,int j)
	{Comparable t = a[i];a[i] = a[j];a[j] = t;}
	private static Comparable[] aux;
	private static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int left, int right) {
		if(right <= left) return;
		int middle = (left + right) / 2;
		sort(a,left,middle);
		sort(a,middle + 1,right);
		merge(a,left,middle,right);
	}
	private static void merge(Comparable[] a, int left, int middle, int right) {
		int i = left,j = middle + 1;
		for(int k = left;k<=right;k++)aux[k] = a[k];
		for(int k = left;k<=right;k++) {
			if(i > middle) a[k] = aux[j++];
			else if(j > right) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
	}
	public static void main(String[] args) {
		String[] sorts = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
		sort(sorts);
		for(int k=0;k<sorts.length;k++)
			System.out.print(sorts[k]+" ");
	}

}
