package sort;

import java.util.Random;

public class LinearSelection {

	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	public static void main(String[] args) {
		Comparable[] a= {4,61,12,6,14,
			48,3,12,48,20,
			94,66,21,19,64,
			75,50,29,67,77,
			69,23,95,50,88,
			35,64,33,36,91,
			73,4,55,46,16,
			96,97,83,78,88,
			16,52,1,14,21,
			18,53,33,33,77,
			5,79,43,16,57,
			60,56,59,40,90,
			73,5,73,88,55,
			3,40,2,81,7,
			1,40,28,58,45};
		Comparable x=randomizedSelect(a,0,a.length-1,25);
		System.out.println("第25小的元素为"+x);

	}
	private static Comparable randomizedSelect(Comparable[]a,int p,int r,int k) {
		if(p==r) return a[p];
		int i=randomizedPartition(a,p,r);
		int j=i-p+1;
		if(k<=j) return randomizedSelect(a,p,i,k);
		else return randomizedSelect(a,i+1,r,k-j);
	}
	private static int randomizedPartition(Comparable[] a,int p,int r)
	{
		Random random =new Random(100);
		int i=random.nextInt(r-p) + p;
		exch(a,r,i);
		return partition(a,p,r);
	}
	private static int partition(Comparable[] a,int p, int r) {
		int i=p,j=r+1;
		Comparable x=a[p];
		while(true) {
			while(a[++i].compareTo(x)<0 && i<r);
			while(a[--j].compareTo(x)>0);
			if(i>=j)break;
			exch(a,i,j);
		}
		a[p]=a[j];
		a[j]=x;
		return j;
	}
}
