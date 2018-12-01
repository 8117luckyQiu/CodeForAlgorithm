package sort;

import java.util.*;
public class huffmanTree {
	private static class Huffman implements Comparable{
		BinTree tree;
		float weight;//权值
		private Huffman(BinTree tt,float ww) {
			tree = tt;
			weight = ww;
		}
		@Override
		public int compareTo(Object x) {
			float xw = ((Huffman)x).weight;
			if (weight < xw) return -1;
			if (weight == xw) return 0;
			return 1;
		}
		
	}
	public static class BinTree{
		String key;
		String data;
		BinTree left;
		BinTree right;
		public BinTree() {
			
		}
		public BinTree(BinTree l, BinTree r ,String d ) {
			this.data = d;
			this.left = l;
			this.right = r;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}

	}
	public static Huffman createHuffmanTree(List<Huffman>h) {
		while(h.size()>1) {
			Collections.sort(h);
			Huffman h1 = h.get(0);
			Huffman h2 = h.get(1);
			float w = h1.weight + h2.weight;
			BinTree b1 = h1.tree;
			BinTree b2 = h2.tree;
			BinTree b = new BinTree(b1,b2,"");
			Huffman node = new Huffman(b,w);
			h.remove(0);
			h.remove(0);
			h.add(node);
			
		}
		return h.get(0);
	}
	public static void process(BinTree node,String str){  
        //叶子结点  
        if(node.left==null){  
            node.setKey(str); 
            System.out.println(node.data+": "+node.key);
            return;  
        }  
        //对左子树分配代码"0"  
        process(node.left,str+"0");  
        //对右子树分配代码"1"  
        process(node.right,str+"1");  
    }
	public static void main(String[] args) {
		List<Huffman> h=new ArrayList<Huffman>();
		BinTree b1=new BinTree(null,null,"A");
		Huffman h1=new Huffman(b1,45);
		h.add(h1);
		BinTree b2=new BinTree(null,null,"B");
		Huffman h2=new Huffman(b2,13);
		h.add(h2);
		BinTree b3=new BinTree(null,null,"C");
		Huffman h3=new Huffman(b3,12);
		h.add(h3);
		BinTree b4=new BinTree(null,null,"D");
		Huffman h4=new Huffman(b4,16);
		h.add(h4);
		BinTree b5=new BinTree(null,null,"E");
		Huffman h5=new Huffman(b5,9);
		h.add(h5);
		BinTree b6=new BinTree(null,null,"F");
		Huffman h6=new Huffman(b6,5);
		h.add(h6);
		Huffman root=createHuffmanTree(h);
		process(root.tree,"");
	}
}
