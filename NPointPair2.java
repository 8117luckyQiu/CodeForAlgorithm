package sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NPointPair2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int N = -1;
	        while (N != 0) {
	        	System.out.print("请输入点的个数:");
	            N = scanner.nextInt();
	            List<Point> points = new ArrayList<>();
	            for (int i = 0; i < N; i++) {
	                Point point = new Point();
	                System.out.print("请输入第"+(i+1)+"点的X坐标:");
	                point.setX(scanner.nextDouble());
	                System.out.print("请输入第"+(i+1)+"点的Y坐标:");
	                point.setY(scanner.nextDouble());
	                points.add(point);
	            }
	            if(N!=0){
	                double min = MinDistance(points);
	                System.out.println("其中两点之间最短距离为: ");
	                System.out.printf("%.2f", min);
	            }    
	        }

	}
	private static double MinDistance(List<Point> points) {
		int n=points.size();
		if(n<2)
			return Integer.MAX_VALUE;
		if(n==2) {
			double distance=MinDistance(points.get(0),points.get(1));
			return distance;
		}
		Collections.sort(points);//将点按照x的顺序排好
		// 分界线为中间两点x坐标的一半
		double m=(points.get(points.size()/2-1).getX()+points.get(points.size()/2).getX())/2;
		//以x=m为轴将点划分为两个点集
		List<Point> leftpoints = new ArrayList<>();
		List<Point> rightpoints = new ArrayList<>();
		leftpoints.addAll(points.subList(0, points.size() / 2-1));
		rightpoints.addAll(points.subList(points.size()/2,points.size()));
		double leftMin=MinDistance(leftpoints);
		double rightMin = MinDistance(rightpoints);
		//找出左右两边点集构成的最小边
		double min=Math.min(leftMin,rightMin);//左边的最小边与右边的最小边相比较
		//创建点集P1和P2，用来保存最近点
		List<Point> P1 = new ArrayList<>();
        List<Point> P2 = new ArrayList<>();
        for (Point point : points) {
            if (point.getX() >= (m - min) && point.getX() < m) {
                P1.add(point);
            }
            if (point.getX() > m && point.getX() <= m + min) {
                P2.add(point);
            }
        }
		//开始寻找跨轴的点对所连成的线
        double min2=Integer.MAX_VALUE;
        double distance;
        boolean flag1,flag2;
        if(P1!=null && P2!=null) {
        	for(Point point: P1) {
        		for(Point point2:P2) {
        			flag1=(point2.getY()>=(point.getY()-min)) && (point2.getY()<=(point.getY()));
        			flag2=(point2.getY()>=(point.getY())) && (point2.getY()<=(point.getY()+min));
        			if(flag1 || flag2) {
        				distance = MinDistance(point,point2);
                        if (distance < min2) {
                            min2 = distance;
                        }
        			}
        		}	
        	}
        	return Math.min(min,min2);
        }else {
        	return min;
        }
	}
	private static double MinDistance(Point point1, Point point2) {
		
		return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX())
	                + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
	}
	class Point implements Comparable<Point> {
	    // 点的x.y坐标
	    private double x;
	    private double y;

	    public void setX(double x) {
	        this.x = x;
	    }

	    public void setY(double y) {
	        this.y = y;
	    }

	    public double getX() {
	        return x;
	    }

	    public double getY() {
	        return y;
	    }

	    @Override
	    public String toString() {
	        return "("+x+","+y+")";
	    }
	    @Override
	    public int compareTo(Point o) {
	        if (x > o.getX())
	            return 1;
	        else if (x == o.getX()) {
	            return 0;
	        } else {
	            return -1;
	        }
	    }
	}
}
