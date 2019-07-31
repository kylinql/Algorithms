"""
迪杰斯特拉算法的简单实现
"""
# the graph
graph = {}
graph["start"] = {}
graph["start"]["a"] = 6
graph["start"]["b"] = 2

#节点A到终点的边的权重为1
graph["a"] = {}
graph["a"]["fin"] = 1

#节点B到A的边的权重是3，到终点的边的权重是5
graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["fin"] = 5

#终点没有任何邻居
graph["fin"] = {}

#节点开销表
infinity = float("inf")
costs = {}
costs["a"] = 6
costs["b"] = 2
costs["fin"] = infinity

#父节点表
parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None

#记录处理过的节点
processed = []

def find_lowest_cost_node(costs):
    #找到代价最小的节点
    lowest_cost = float("inf")
    lowest_cost_node = None
    
    # Go through each node.
    for node in costs:
        cost = costs[node]
        # If it's the lowest cost so far and hasn't been processed yet...
        if cost < lowest_cost and node not in processed:
            #如果当前节点权重最低且还未处理过
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

#找到未处理的点中代价最小的点
node = find_lowest_cost_node(costs)
while node is not None:
    #只要未处理的点不为空，就一直循环
    cost = costs[node] #获取当前到节点边的权值
    #找到这个节点的所有邻居
    neighbors = graph[node]
    for n in neighbors.keys():
        #遍历所有邻居节点
        new_cost = cost + neighbors[n]#计算新权值
        # If it's cheaper to get to this neighbor by going through this node...
        if costs[n] > new_cost:
            #如果新权值,小于在cost表中的相应值，就更新
            costs[n] = new_cost
            #将当前节点记为该节点的父节点
            parents[n] = node
    #将这个节点标记为处理过
    processed.append(node)
    #寻找下一个最小代价节点
    node = find_lowest_cost_node(costs)

if __name__ == "__main__":
    print("cost tabel:", costs)
    print("parent table:", parents)