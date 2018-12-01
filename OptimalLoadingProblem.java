package sort;

public class OptimalLoadingProblem {

	private static boolean less(Comparable v,Comparable w) 
	{return v.compareTo(w)<0;}
	private static void exch(int []a,int i,int j)
	{int t=a[i];a[i]=a[j];a[j]=t;}
	private static Element[] aux;
	public static class Element implements Comparable{
		float w;
		int i;
		public Element(float ww,int ii) {
			w = ww;
			i = ii;
		}
		public int compareTo(Object x) {
			float xw = ((Element)x).w;
			if(w < xw)return -1;
			if(w == xw)return 0;
			return 1;
		}
	}
	public static float loading(float c,float[]w,int[]x) {
		int n = w.length;
		Element []d = new Element[n];
		for(int i = 0;i < n;i++)
			d[i] = new Element(w[i],i);
		aux=new Element[d.length];
		mergeSort(d,0,d.length-1);
		float opt = 0;
		for(int i = 0;i < n;i++)x[i] = 0;
		for(int i = 0;i < n && d[i].w <=c;i++) {
			x[d[i].i] = 1;
			opt += d[i].w;
			c -=d[i].w;
		}
		return opt;	
	}
	public static void mergeSort(Element[] d,int lo,int high) {
		
		if(high<=lo) return;
		int middle = (lo+high) / 2;
		mergeSort(d,lo,middle);
		mergeSort(d,middle+1,high);
		copy(d,lo,middle,high);
	}
	public static void copy(Element[] d,int lo,int middle,int high) {
		int i = lo; int j = middle+1;
		for(int k = lo;k <=high;k++)
			aux[k] = d[k];
		for(int k = lo;k <=high;k++) {
			if(i>middle) d[k] = aux[j++];
			else if(j>high) d[k] = aux[i++];
			else if(less(aux[j],aux[i])) d[k] = aux[j++];
			else d[k] = aux[i++];
		}
	}
	public static void main(String[] args) {
		float c=50;
        float[] w={7,35,25,15,10,4,3,2};
        int[] x={0,0,0,0,0,0,0,0};
        System.out.println("最多装入"+loading(c, w, x)+"个集装箱");
	}

}
