"""
广度优先算法
breadth first search
简单实现
"""

from collections import deque

def person_is_seller(name):
    #判断这个人是否是销售商
      return name[-1] == 'm'


def search(name):
    #创建队列
    search_queue = deque()
    search_queue += graph[name]
    # This array is how you keep track of which people you've searched before.
    searched = [] #记录已经找过的人，因为有些人的邻居是重复的
    while search_queue:
        #只要队列不为空
        person = search_queue.popleft() #取出队首元素，查看其是否是要找的人
        if not person in searched:
            #如果这个人没有找过
            if person_is_seller(person):
                #如果这个人是我们要找的人，就返回True
                print(person + " is a mango seller!")
                return True
            else:
                #否则就把这个人的邻居加入队列，并把这个人的名字加入已经找过人的列表中
                search_queue += graph[person]
                # Marks this person as searched
                searched.append(person)
    return False

if __name__ == "__main__":
    #1.创建图中的元素
    graph = {}
    graph["you"] = ["alice", "bob", "claire"]
    graph["bob"] = ["anuj", "peggy"]
    graph["alice"] = ["peggy"]
    graph["claire"] = ["thom", "jonny"]
    graph["anuj"] = []
    graph["peggy"] = []
    graph["thom"] = []
    graph["jonny"] = []
    
    #2. 广度优先搜索
    search("you")
