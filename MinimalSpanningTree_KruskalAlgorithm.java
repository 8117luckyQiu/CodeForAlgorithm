package sort;
import java.util.*;
public class MinimalSpanningTree_KruskalAlgorithm {
	public static int n;
	public static class FastUnionFind {
		public int[] u;//数组用来保存顶点所属的集合，用数字表示
		public FastUnionFind(int n){
			u=new int[n+1];
			for(int i=0;i<=n;i++){
				u[i]=i;
			}
		}
		public int find(int x){
			return u[x];
		}
		public void union(int x,int y){
			int m = u[y];
			for(int i=0;i<=n;i++)
				if(u[i] == m)u[i]=u[x];
			u[y]=u[x];
		}
	}
	static class EdgeNode implements Comparable{
		float weight;
		int u,v;
		EdgeNode(int uu,int vv,float ww){
			u = uu;
			v = vv;
			weight = ww;
		}
		public int compareTo(Object x) {
			double xw = ((EdgeNode) x).weight;
			if(weight < xw) return -1;
			if(weight ==  xw) return 0;
			return 1;
		}
	}
	public static boolean kruskal(int n,LinkedList<EdgeNode> E,EdgeNode[] t){
		
		FastUnionFind U=new FastUnionFind(n);
		int k=0;
		while(k<n-1){
			EdgeNode x=E.peek();;
			int a=U.find(x.u);
			int b=U.find(x.v);
			if(a != b){
				t[k++]=x;
				U.union(a, b);
			}
			E.pop();
		}
		for(int i=0;i<k;i++){
			System.out.println("V"+(t[i].u)+" ————> V"+(t[i].v)+"; 长度为:"+t[i].weight);
		}
		return (k==n-1);
	}
	public static void main(String[] args) {
		n=6;
		EdgeNode e1=new EdgeNode(0,1,34);
		EdgeNode e2=new EdgeNode(0,4,12);
		EdgeNode e3=new EdgeNode(1,2,46);
		EdgeNode e4=new EdgeNode(1,5,19);
		EdgeNode e5=new EdgeNode(2,5,25);
		EdgeNode e6=new EdgeNode(2,3,17);
		EdgeNode e7=new EdgeNode(3,5,25);
		EdgeNode e8=new EdgeNode(3,4,38);
		EdgeNode e9=new EdgeNode(4,5,26);
		LinkedList<EdgeNode> E=new LinkedList<EdgeNode>();
		E.add(e9);
		E.add(e8);
		E.add(e7);
		E.add(e6);
		E.add(e5);
		E.add(e4);
		E.add(e3);
		E.add(e2);
		E.add(e1);
		Collections.sort(E);
		EdgeNode[] t=new EdgeNode[n];
		kruskal(n,E,t);
	}

}
