package sort;
//p为数组中最左边的数,r为数组中最右边的数,k为要查的第几小的数
public class LinearSelectionM {
	private static boolean less(Comparable w,Comparable v)
	{return w.compareTo(v)<0;}
	private static void exch(Comparable []a,int i,int j)
	{Comparable t=a[i];a[i]=a[j];a[j]=t;}
	public static Comparable[]a={4,61,12,6,14,
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
						  1,40,28,58,45,
						  8,85,49,6,4,
						  73,5,73,88,55,
						  73,5,73,88,55,
						  73,5,73,88,55,
						  73,5,73,88,55,};
	public static void main(String[] args) {
		Comparable x=select(0,a.length-1,25);
		System.out.println("第25小的元素为"+x);
	}
	private static Comparable select(int p,int r,int k) {
		if(r-p<75) {
			MergeSort(p,r);
			return a[p+k-1];
		}
		//将a[p+5*i]至a[p+5*i+4]的第3小元素与a[p+i]交换位置
		//找中位数的中位数
		for(int i=0;i<=(r-p-4)/5;i++)
		{
			int s=p+5*i,t=s+4;
			for(int j=0;j<3;j++) bubble(s,t-j);
			exch(a,p+i,s+2);
		}
		Comparable x=select(p,p+(r-p-4)/5,(r-p+6)/10);
		int i=partition(p,r,x),j=i-p+1;
		if(k<=j) return select(p,i,k);
		else return select(i+1,r,k-j);
	}
	private static int partition(int p, int r,Comparable x) {
		int i=p,j=r+1;
		//Comparable x=a[p];
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
	private static void bubble(int s, int m) {
		for(int i=s;i<m;i++) {
			Comparable max=a[s];
			if(less(max,a[i+1])) exch(a,i+1,s);	
		}
		
	}
	private static void MergeSort(int p, int r) {
		if(r<=p)return;
		int mid =(p+r)/2;
		MergeSort(p,mid);
		MergeSort(mid+1,r);
		copy(p,mid,r);
		
	}
	private static void copy(int p, int mid, int r) {
		int i=p,j=mid+1;
		Comparable []aux=new Comparable[a.length];
		for(int k=p;k<=r;k++) 
			aux[k]=a[k];
		for(int k=p;k<=r;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>r) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
		
	}
}
