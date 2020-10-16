package graph;

import java.util.List;

/**
 * 深度优先搜索——迷宫求生
 * 	搜索迷宫中的所有通道，个人感觉有点像栈：
 * 	1. 选择一条没有标记过的通道， 然后用一个绳子记录
 *  2. 标记所有第一次路过的路口和通道、
 *  3. 当来到一个标记过的路口的时候，回退到上个路口
 *  4. 当回退到的路口已无路可走的时候，继续回退
 *  其中，绳子记录我们走过的路，而标记则保证我们不会两次经过同一个通道或者路口
 * @author Kylin
 *
 */
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	
	
	public DepthFirstSearch(Graph graph, int s) {
		this.marked = new boolean[graph.getV()];
		dfs(graph, s);
	}
	
	/**
	 * 深度优先搜索
	 * 	每次到达一个顶点时，首先将它标记为已访问，之后递归的访问它的所有没有标记过的邻居结点
	 * @param graph 图
	 * @param v 顶点
	 */
	public void dfs(Graph graph, int v){
		//1. 标记该节点为已访问
		marked[v] = true;
		count++; //路程加1
		List<Integer> adjs = graph.getAllAdj(v);
		int w;
		for (int i = 0; i < adjs.size(); i++) {
			w = adjs.get(i);
			if(!marked[w]){
				dfs(graph, w);
			}
		}	
		
	}
	
	/**
	 * 查看某个顶点是否被标记
	 * @param w
	 * @return
	 */
	public boolean isMarked(int w){
		return marked[w];
	}
	
	/**
	 * 查看走过的路径
	 * @return
	 */
	public int count(){
		return count;
	}
	



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
