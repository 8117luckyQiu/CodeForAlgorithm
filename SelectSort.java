package sort;
public class SelectSort {
	public static boolean less(Comparable v,Comparable w) 
	{return v.compareTo(w)<0;}
	public static void exch(Comparable[] sort,int i,int j) 
	{Comparable t=sort[i];sort[i]=sort[j];sort[j]=t;}
	public static void main(String[] args) {
		Comparable[] sort = {5,3,1,9,8,2,4,7};
		select(sort);
		for(int i=0;i<sort.length;i++)
			System.out.print(sort[i]+" ");
	}
	public static void select(Comparable[] sort) {
		int N=sort.length;
		int min,t;
		for(int i=0;i<N;i++) {
			min=i;
			for(int j=i+1;j<N;j++) 
				if(less(sort[j],sort[min])) min=j;
			exch(sort,i,min);
		}
	}
}
