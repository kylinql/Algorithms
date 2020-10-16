package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 图的数据结构
 * @author Kylin
 *
 */
public class Graph {
	private final int V; //图的顶点数
	private int E; //图的边数
	private List<List> adj; //保存边的列表
	
	public Graph(int v, int E, List<List> adj){
		this.V = v;
		this.E = E;
		this.adj = adj;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public List getAdj() {
		return adj;
	}

	public void setAdj(List adj) {
		this.adj = adj;
	}

	public int getV() {
		return V;
	}
	
	public void addEdge(int v, int w){
		List<Integer> edge = new ArrayList<Integer>();
		edge.add(v);
		edge.add(w);
		this.adj.add(edge);
	}
	
	public void showAdj(){
		for (List edge : adj) {
			System.out.println("[" + edge.get(0) + ", " + edge.get(1)+"]");		
		}
	}
	
	public List getAllAdj(int v){
		List<Integer> adjs = new ArrayList<Integer>();
		for (int i = 0; i < E; i++) {
			List edge = adj.get(i);
			if(edge.contains(v)){
				int vindex = edge.indexOf(v);
				if(vindex == 0){
					adjs.add((Integer) edge.get(1));
				}
				else{
					adjs.add((Integer) edge.get(0));
				}
			}
		}
		
		return adjs;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入顶点数");
		int V = sc.nextInt(); //顶点数
		System.out.println("请输入边数");
		int E = sc.nextInt();
		System.out.println("请输入相应边的顶点，用逗号分割");
		List<List> list = new ArrayList<List>();
		for (int i = 0; i < E; i++) {
			List<Integer> edge = new ArrayList<Integer>();
			String e = sc.next();
			String[] es = e.split(",");
			int e1 = Integer.parseInt(es[0]);
			int e2 = Integer.parseInt(es[1]);
			edge.add(e1);
			edge.add(e2);
			list.add(edge);
		}
		
		Graph graph = new Graph(V, E, list);
		graph.showAdj();
		
		List points = graph.getAllAdj(1);
		System.out.println("--------临接点----------");
		System.out.println(points.toString());
	}
	
}
