package sort;

public class bagProblem {

	/*全局注释：
	 * v数组代表的是物品的价值
	 * w数组代表的是物品的重量
	 * c代表背包的容量
	 * m数组代表的是
	 */
	public static void main(String[] args) {
		int []w= {0,2,3,4,7};
		int []v= {0,1,3,5,9};
		int c=10;
		int [][]m;
		m=knapsack(v,w,c);
		traceback(m,w,c);
		
	}
	public static int[][] knapsack(int[]v,int []w,int c) {
		int n=v.length-1;
		int [][]m=new int[c+1][c+1];
		int jMax=Math.min(w[n]-1, c);
		for(int j=0;j<=jMax;j++)
			m[n][j]=0;
		for(int j=w[n];j<=c;j++)
			m[n][j]=v[n];
		
		for(int i=n-1;i>1;i--) {
			jMax=Math.min(w[i]-1, c);;
			for(int j=0;j<=jMax;j++)
				m[i][j]=m[i+1][j];
			for(int j=w[i];j<=c;j++)
				m[i][j]=Math.max(m[i+1][j], m[i+1][j-w[i]]+v[i]);
		}
		m[1][c]=m[2][c];
		if(c>=w[1])
			m[1][c]=Math.max(m[1][c], m[2][c-w[1]]+v[1]);
		
		/*for(int i=0;i<w.length;i++) {
			for(int j=0;j<=c;j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
		}*/
		return m;
	}
	public static void traceback(int [][]m,int []w,int c)
	{
		int n=w.length;
		int []x=new int[n];
		for(int i=1;i<n;i++) 
			if(m[i][c]==m[i+1][c])x[i]=0;
			else {
				x[i]=1;
				c-=w[i];
			}
		
		for(int i=0;i<w.length;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}
