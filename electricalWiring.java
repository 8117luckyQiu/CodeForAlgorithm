package sort;

public class electricalWiring {

	public static void main(String[] args) {
		int[] c= {0,8,7,4,2,5,1,9,3,10,6};//因为接线柱是从1开始，所以第0项添一个0
		int[][]size=new int[c.length][c.length];
		int []net=new int[c.length-1];
		mnset(c,size);
		System.out.println("最多有"+traceback(c,size,net)+"条导线安排在第一层");
	}
	public static void mnset(int[]c,int [][]size) {
		int n = c.length-1;
		for(int j=0;j<c[1];j++)
			size[1][j]=0;//将连接下接线柱之前的所有接线柱设为0
		for(int j=c[1];j<=n;j++)
			size[1][j]=1;//将连接下接线柱之后的所有接线柱设为1
		for(int i=2;i<n;i++) {
			for(int j=0;j<c[i];j++)
				size[i][j]=size[i-1][j];
			for(int j=c[i];j<=n;j++)
				size[i][j]=Math.max(size[i-1][j], size[i-1][c[i]-1]+1);
		}
		size[n][n]=Math.max(size[n-1][n], size[n-1][c[n]-1]+1);		
	}
	public static int traceback(int []c,int [][]size,int []net) {//net数组储存上接线柱最优解的下标
		int n=c.length-1;
		int j =n;
		int m=0;
		for(int i=n;i>1;i--)
			if(size[i][j]!=size[i-1][j])
			{
				net[m++]=i;
				j=c[i]-1;
			}
		if(j>=c[1])
			net[m++]=1;
		System.out.println("最大不相交连线分别为:");
		for(int t=m-1;t>=0;t--) {
			System.out.println(net[t]+" "+c[net[t]]);//net数组为上接线柱的最优解下标，可通过c[net[]]来得到下接线柱的下标
		}
		return m;
	}

}
