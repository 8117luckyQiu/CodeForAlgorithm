package sort;
import java.util.Random;
public class QuickSort {
	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	public static void main(String[] args) {
		Comparable[] a= {8,4,3,7,1,5,6,2};
		quickSort(a,0,a.length-1);
		show(a);
	}
	private static void quickSort(Comparable[] a,int p,int r) {
		if(p<r) {
			int q=randomizedPartition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
		}
	}
	private static int randomizedPartition(Comparable[] a,int p,int r)
	{
		Random random =new Random();
		int i=random.nextInt(r-p) + p;
		exch(a,r,i);
		return partition(a,p,r);
	}
	private static int partition(Comparable[] a,int p, int r) {
		int i=p,j=r+1;
		Comparable x=a[p];
		while(true) {
			while(a[++i].compareTo(x)<0&&i<r);
			while(a[--j].compareTo(x)>0);
			if(i>=j)break;
			exch(a,i,j);
		}
		a[p]=a[j];
		a[j]=x;
		return j;
	}
	private static void show(Comparable []a) {
		for(int t=0;t<a.length;t++)
			System.out.print(a[t]+" ");
	}
}
