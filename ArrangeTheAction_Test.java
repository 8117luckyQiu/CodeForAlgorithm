package sort;

public class ArrangeTheAction_Test {

	private static boolean less(Comparable w,Comparable v)
	{return w.compareTo(v)<0;}
	private static void exch(int[] a,int i,int j)
	{int t = a[i];a[i]=a[j];a[j]=t;}
	private static int[] aux;
	public static void mergeSort(int []a,int low,int high) {
		if(high<=low) return;
		int middle = (low+high)/2;
		mergeSort(a,low,middle);
		mergeSort(a,middle+1,high);
		copy(a,low,middle,high);
	}
	public static void copy(int []a,int low,int middle,int high) {
		int i = low,j = middle+1;
		for(int k = low; k <=high; k++) aux[k] = a[k];
		for(int k = low; k <=high; k++) {
			if(i > middle) a[k] = aux[j++];
			else if(j > high) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
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
	private static int greedySelector(int[] s, int[] f, boolean[] a) {
		int n = s.length-1;
		int j = 1;
		int count = 1;
		a[1] = true;
		for(int i = 2;i <= n;i++) {
			if(s[i] >= f[j]) {
				a[i] = true;
				j = i;
				count++;
			}
			else a[i] = false;
		}
		for(int i = 1;i <= n;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		return count;
	}

}
