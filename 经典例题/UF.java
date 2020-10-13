package unionFound;

import java.util.Scanner;

/**
 * 定义连通图的数据结构
 * @author Kylin
 *
 */
public class UF {
	private int[] id; //分量id
	private int count; //分量数量
	
	//一开始有N个分量，随着不断的合并，分量数量会减小
	public UF(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * 返回当前连通图的分量个数
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * 返回p所在的分量标识符
	 * @param p
	 * @return
	 */
	public int find(int p){
		while(p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	/**
	 * 在p和q之间加一条连接 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q){
		int pIDRoot = find(p);
		int qIDRoot = find(q);
		
		if(pIDRoot == qIDRoot){
			return;
		}
		
		id[pIDRoot] = qIDRoot;
		count--;
	}

	/**
	 * 判断p和q是否相连
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //设置节点数量
		int notNum = sc.nextInt(); //输入线条数
		
		UF uf = new UF(N);
		
		for (int i = 0; i < notNum ; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			if(uf.connected(p, q)){
				continue;
			}
			uf.union(p, q);
		}
		System.out.println("连通图线条数：" + uf.count);
	}
}
