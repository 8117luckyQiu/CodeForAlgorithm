package sort;

public class LoadingProblemForBacktrack {
	static int n;			//集装箱数
	static int []w;			//集装箱重量数组
	static int c;			//第一艘轮船的载重量
	static int cw;			//当前载重量
	static int bestw;		//当前最优载重量
	static int r;			//剩余集装箱重量
	static int []x;			//当前解
	static int[]bestx;		//当前最优解
	public static int maxLoading(int []ww,int cc,int[]xx) {
		n = ww.length-1;
		w = ww;
		c = cc;
		cw = 0;
		bestw = 0;
		x = new int[n+1];
		bestx = xx;
		
		//初始化
		for(int i = 1;i<=n;i++)
			r += w[i];
	}
	public static void main(String[] args) {
		
	}

}
