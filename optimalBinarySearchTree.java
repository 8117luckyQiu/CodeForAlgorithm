package sort;

public class optimalBinarySearchTree {
	 /*
     * 参数P：表示1~n个节点的查找概率。其中P[0] = 0，无意义
     * 函数功能：返回在最优BST中查找的平均比较次数主表w[][]，以及最优BST中子树的根表m
     */
	public static void main(String[] args) {
		optimalBinarySearchTree test = new optimalBinarySearchTree();
		float[] a = {(float) 0.15,(float)0.1,(float)0.05,(float)0.05};
		int n=a.length;
		float b[]={0,(float) 0.5,(float)0.1,(float)0.05};
        float s[][]=new float[n+2][n+1];
        float w[][]=new float[n+2][n+1];  //保存最有BST的成功查找的平均比较次数
        float m[][]=new float[n+2][n+1];  //保 存最优BST中子树的根表R
        test.optimalbinarySearchTree(a,b,m,s,w);
	}
	public static void optimalbinarySearchTree(float[]a,float[]b,float[][]m,float [][]s,float[][]w) {
		int n=a.length-1;
		for(int i=0;i<=n;i++) {
			w[i+1][i]=a[i];
			m[i+1][i]=0;
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
			}
		 System.out.println("在最优BST中查找的平均比较次数依次为：");
	        for(int i = 1;i < w.length;i++) {
	            for(int j = 0;j < w[0].length;j++)
	                System.out.printf("%.2f\t",w[i][j]);
	            System.out.println();
	        }
	        
	        System.out.println("在最优BST中子树的根表R为：");
	        for(int i = 1;i < s.length;i++) {
	            for(int j = 0;j < s[0].length;j++)
	                System.out.printf("%.0f\t",s[i][j]);
	            System.out.println();
	        }
	}
}
