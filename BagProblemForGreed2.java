package sort;
import java.util.*;
public class BagProblemForGreed2 {
	 /**
     * 普通背包问题，可以将物品的一部分放入背包，比如黄金喽
     *      简单贪心：将物品的单位价值降序排列
     *s     物品个数，与物品重量，价值一一对应
     *w     物品重量
     *v     物品价值
     *p     背包大小
     */
	public static double normalPackage(int s,double[]w,double[]v,int p) {
		double[][] vperw = new double[s][2];//[0]单位重量下的价值[1]编号
		for(int i = 0; i < s;i++) {
			vperw[i][0] = v[i] / w[i];
			vperw[i][1] = i;
		}
		//排序
		Arrays.sort(vperw,new Comparator<double[]>() {
			public int compare(double[]o1,double[]o2) {
				return o2[0]-o1[0]>0?1:-1;
			}
		});
		/*//测试
		for (int i = 0; i < s; i++) {
			System.out.print(vperw[i][0] + "   ");
		}
		System.out.println();	
		*/
		double tmpW = 0;//临时重量
        double result = 0;//价值
        for(int i = 0;i<s;i++) {
        	int b = (int) vperw[i][1];//当前物品的id
        	double thisW = w[b];
        	if(thisW < p-tmpW) {//如果物品能完全放入
        		result +=v[b];
        		tmpW +=w[b];
        		System.out.println("物品" + b + " 放入比例" + vperw[i][0] + " 获得收益" + v[b]);
        	}else {//如果物品不能完全放入
        		double canW = p-tmpW;
        		result +=canW *vperw[i][0]; 
        		System.out.println("物品 " + b +" 放入比例 "+ canW/thisW +" 获得收益 " + vperw[i][0] * canW);
        		break; 
        	}
        }
        return result;
	}
	public static void main(String[] args) {
		  double[] w = new double[]{18,15,10};
	      double[] v = new double[]{25,24,15};
	      double result = normalPackage(w.length, w, v, 20);
	      System.out.println("获取最大收益为：" + result);

	}

}
