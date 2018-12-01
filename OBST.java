package sort;

public class OBST {
	
	public static void main(String[] args) {
		OBST test = new OBST();
		float[] a = {(float) 2,(float)3,(float)1,(float)1,(float)1};
		int n=a.length;
		float b[]={0,(float) 3,(float)3,(float)1,(float)1};
        float s[][]=new float[n+2][n+1];
        float w[][]=new float[n+2][n+1];  //保存最优二叉搜索树的成功查找的平均比较次数
        float m[][]=new float[n+2][n+1];  
        float R[][]=new float[n+2][n+1]; //保存最优最优二叉搜索树的根节点
        test.optimalbinarySearchTree(a,b,m,s,w,R);
	}
	public static void optimalbinarySearchTree(float[]a,float[]b,float[][]m,float [][]s,float[][]w,float[][]R) {
		int n=a.length-1;
		for(int i=0;i<=n;i++) {
			w[i+1][i]=a[i];
			m[i+1][i]=0;
			R[i][i]=i;//单节点最优树的跟是它自己本身
		}
		for(int r=0;r<n;r++)
			for(int i=1;i<=n-r;i++) {
				int j=r+i;
				w[i][j]=w[i][j-1]+a[j]+b[j];
				m[i][j]=m[i+1][j];
				s[i][j]=i;
				for(int k=i+1;k<=j;k++) {
					float t=m[i][k-1]+m[k+1][j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
					m[i][j]+=w[i][j];
				}
				R[i][j]=s[i][j];  //保存最优的根结点
			}
		System.out.println("在最优二叉搜索树中查找的平均比较次数依次为：");
        for(int i = 1;i < w.length-1;i++) {
            for(int j = 0;j < w[0].length-1;j++)
                System.out.printf("%.0f\t",w[i][j]);
            System.out.println();
        }
        /*
         * 数组R从R(1,1)开始,R(1,1)=1指单节点最优树的根是它自己本身,R(1,2)=1指b1和b2的最优树的根是b1;
         */
        System.out.println("在最优二叉搜索树中子树的根表R为：");
        for(int i = 1;i < R.length-1;i++) {
            for(int j = 1;j < R[0].length-1;j++)
                System.out.printf("%.0f\t",R[i][j]);
            System.out.println();
        }
	}
}
