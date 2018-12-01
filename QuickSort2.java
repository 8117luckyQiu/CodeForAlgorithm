package sort;

public class QuickSort2 {
	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	public static void main(String[] args) {
		Comparable[] a= {5,3,1,9,8,2,4,7};
		quickSort(a,0,a.length-1);
		show(a);

	}
	private static void quickSort(Comparable[] a, int p, int r) {
		if(p<r) {
			int q=partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
		}
		
	}
	private static int partition(Comparable[] a,int p,int r) {
		int i=p,j=r+1;
		Comparable t=a[p];
		while(true) {
			while(a[++i].compareTo(t)<0 && i<r);
			while(a[--j].compareTo(t)>0);
			if(i>=j) break;
			exch(a,i,j);
		}
		a[p]=a[j];
		a[j]=t;
		return j;
	}
	private static void show(Comparable []a) {
		for(int t=0;t<a.length;t++)
			System.out.print(a[t]+" ");
	}
}
