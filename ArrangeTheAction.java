package sort;

public class ArrangeTheAction {
	private static boolean less(Comparable v,Comparable w) 
	{return v.compareTo(w)<0;}
	private static void exch(int []a,int i,int j)
	{int t=a[i];a[i]=a[j];a[j]=t;}
	private static int[] aux;
	public static int greedySelector(int []s,int[]f,boolean[]a) {
		int n = s.length -1;
		a[1]=true;
		int j = 1;
		int count = 1;
		for(int i = 2;i<=n;i++) {
			if(s[i]>=f[j]) {
				a[i] = true;
				j = i;
				count ++;
			}
			else a[i] = false;
		}
		for(int i = 1;i <=n;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		return count;
	}
	public static void mergeSort(int[]f,int lo,int high) {
		
		if(high<=lo) return;
		int middle = (lo+high) / 2;
		mergeSort(f,lo,middle);
		mergeSort(f,middle+1,high);
		copy(f,lo,middle,high);
	}
	public static void copy(int []f,int lo,int middle,int high) {
		int i = lo; int j = middle+1;
		for(int k = lo;k <=high;k++)
			aux[k] = f[k];
		for(int k = lo;k <=high;k++) {
			if(i>middle) f[k] = aux[j++];
			else if(j>high) f[k] = aux[i++];
			else if(less(aux[j],aux[i])) f[k] = aux[j++];
			else f[k] = aux[i++];
		}
	}
	public static void main(String[] args) {
		 int []s = {1,0,3,5,3,5,6,2,7,7};
		 int []f = {4,6,5,7,8,9,10,13,12,11};
		 boolean []a = new boolean[s.length];
		 aux=new int[f.length];
		 mergeSort(f,0,f.length-1);
		 int count=greedySelector(s,f,a);
		 System.out.print("一共能安排"+ count +"个节目");

	}

}
