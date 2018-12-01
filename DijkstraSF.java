package sort;
public class DijkstraSF {
 
	public static void main(String[] args) {
		
		float m=Float.MAX_VALUE;
		float [][]a = {{ m, m, m, m, m, m },
				       { m, m, 3, m, m, 30},
				       { m, m, m,25, 8,  m},
				       { m, m, m, m, m, 10},
				       { m,20, m, 4, m, 12},
				       { m, 5, m, m, m, m }};
		float []dist = new float [a.length+1];
		int []prev = new int [a.length +1];
		int v=1;
		dijkstra(v,a,dist,prev);
		
	}
	public static void dijkstra(int v,float [][]a,float []dist,int []prev){
		int n=dist.length-1;
		if(v<1||v>n)return;
		boolean []s = new boolean[n+1];
		//初始化
		for(int i =1;i<n;i++){
			dist[i]=a[v][i];
			s[i]=false;
			if(dist[i] == Float.MIN_EXPONENT)prev[i]=0;
			else prev[i]=v;			
		  }
		dist[v]=0;
		s[v]=true;
		for(int i = 1;i<n;i++){
			float temp = Float.MAX_VALUE;
			int  u = v;
			for(int j=1;j<n;j++){
				if((!s[j])&&(dist[j]<temp)){
					u=j;
					temp=dist[j];
				}
			}
				s[u]=true;
				for(int j=1;j<n;j++)
					if((!s[j])&&(a[u][j]<Float.MAX_VALUE)){
						float newdist = dist[u]+a[u][j];
						if(newdist<dist[j]){
							dist[j]=newdist;
							prev[j]=u;
						}
					}
			}
		for(int i=2;i<=5;i++){
			System.out.println("v0 到 v"+(i-1)+" 的单源最短路径为: "+dist[i]);
		}
		}
}