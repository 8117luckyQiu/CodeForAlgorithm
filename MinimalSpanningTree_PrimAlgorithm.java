package sort;
public class MinimalSpanningTree_PrimAlgorithm {
	public static int m=Integer.MAX_VALUE;
	static float[][] weight={
						   {0,  0,  0,  0,  0,  0,  0},
						   {0,  m, 34,  m,  m, 12,  m},
						   {0, 34,  m, 46,  m,  m, 19},
						   {0,  m, 46,  m, 17,  m, 25},
						   {0,  m,  m, 17,  m, 38, 25},  
						   {0, 12,  m,  m, 38,  m, 26},
						   {0,  m, 19, 25, 25, 26, m}};
	
	public static int verNum=weight.length;
	public static void prim(int n,float[][]c) {
		float[] lowcost = new float[n+1];
		int []closest = new int[n+1];
		boolean []s = new boolean[n+1];
		
		s[1] = true;
		for(int i = 2;i <= n;i++) {
			lowcost[i] = c[1][i];
			closest[i] = 1;
			s[i] = false;
		}
		for(int i = 1;i < n;i++) {
			float min = Float.MAX_VALUE;
			int j = 1;
			for(int k = 2;k <= n;k++)
				if((lowcost[k] < min)&&(!s[k])){
					min = lowcost[k];
					j = k;
				}
			System.out.println("v" + (closest[j]-1) + " ————> " + "v"+(j-1));
			s[j] = true;
			for(int k = 2;k <= n;k++)
				if((c[j][k] < lowcost[k]) && (!s[k])) {
					lowcost[k] = c[j][k];
					closest[k] = j;
				}
		}
	}
	public static void main(String[] args) {
		MinimalSpanningTree_PrimAlgorithm p = new MinimalSpanningTree_PrimAlgorithm();
		p.prim(verNum-1, weight);
	}

}
