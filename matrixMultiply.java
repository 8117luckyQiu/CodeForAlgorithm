package sort;

public class matrixMultiply {
	private static int m[][];
	private static int p[];
	private static int s[][];
	
	public matrixMultiply(){
		p=new int[]{10,5,2,8,4,9,10,7,6};
		m=new int[8][8];
		s=new int[8][8];
	}
	
	public matrixMultiply(int n,int []p){
		this.p=new int[n+1];
		this.m=new int[n][n];
		this.s=new int[8][8];
		for(int i=0;i<p.length;i++)
			this.p[i]=p[i];
	}
	public static void main(String[] args) {
		matrixMultiply matrix = new matrixMultiply();
		matrix.matrixChain(p, m, s);
		matrix.traceback(s, 0, s.length-1);
		
	}
	public static void matrixMultiply(int [][]a,int [][]b,int [][]c,int ra,int ca,int rb,int cb) {
		if(ca!=rb)//第一个列不等于第二个的行
			throw new IllegalArgumentException("矩阵不可乘");
		//若矩阵可乘，则进行相乘
		for(int i=0;i<ra;i++)
			for(int j=0;j<cb;j++) {
				int sum=a[i][0]*b[0][j];
				for(int k=1;k<ca;k++) {
					sum+=a[i][k]*b[k][j];
				}
				c[i][j]=sum;
			}
	}
	public static void matrixChain(int []p,int [][]m, int [][]s) {
		int n=m.length-1;
		for(int i=1;i<=n;i++) m[i][i]=0;
		for(int r=2;r<=n;r++) 
			for(int i=1;i<=n-r+1;i++) {
				int j=i+r-1;
				m[i][j]=m[i][i]+m[i+1][j]+p[i-1]*p[i]*p[j];
				s[i][j]=i;
				for(int k=i+1;k<j;k++) {
					int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
	}
	public static void traceback(int[][]s,int i,int j) {
		if(i==j) return;
		traceback(s,i,s[i][j]);
		traceback(s,s[i][j]+1,j);
		System.out.println("先把A"+(i+1)+"到A"+(s[i][j]+1)+"括起来，再把A"+(s[i][j]+2)+"到A"+(j+1)+"括起来，然后把A"+(i+1)+"到A"+(j+1)+"括起来");
	}

}
