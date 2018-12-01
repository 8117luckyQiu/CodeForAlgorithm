package sort;
import java.util.Scanner;
public class circularSchedule {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("请输入 k 的值（2^k个运动员）");
		 int k = scanner.nextInt();
		 // 求运动员人数
		 int n = 1;
		 for (int i = 1; i <= k; i++) {
			 n = n * 2;
		 }
		 // 创建二维数组作为日程表
		 int[][] array = new int[n + 1][n + 1];
		 // 制作日程表
		 table(k, array, n);
		 // 输出日程表
		 printTable(array, n);
	}
	public static void table(int k,int[][]a,int n) {
		 // 设置日程表第一行
		for(int i = 1;i<=n;i++) a[1][i]=i;
		// 每次填充时，起始填充位置
		int m =1;
		for(int s=1;s<=k;s++) {
			n/=2;
			for(int t=1;t<=n;t++)
				// 控制行
				for(int i=m+1;i<=2*m;i++)
				//控制列
					for(int j=m+1;j<=2*m;j++)
					{
						// 右下角等于左上角的值
						a[i][j+(t-1)*m*2]=a[i-m][j+(t-1)*m*2-m];
						// 左下角等于右上角的值
						a[i][j+(t-1)*m*2-m]=a[i-m][j+(t-1)*m*2];
					}
			m*=2;
		}
	}
	 private static void printTable(int[] array[], int n) {
		 
		 for (int i = 1; i <= n; i++) {
			 for (int j = 1; j <= n; j++) {
		        System.out.print(array[i][j] + " ");
		     }
			 System.out.println();
		 }
	}
}
