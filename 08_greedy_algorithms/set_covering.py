"""
贪婪算法的简单实现
"""
#需要覆盖的洲
states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])

#构建一个字典，存储各个站点覆盖的洲
stations = {}
stations["kone"] = set(["id", "nv", "ut"])
stations["ktwo"] = set(["wa", "id", "mt"])
stations["kthree"] = set(["or", "nv", "ca"])
stations["kfour"] = set(["nv", "ut"])
stations["kfive"] = set(["ca", "az"])

#存储最终选择的站点
final_stations = set()


while states_needed:
    best_station = None
    states_covered = set()
    for station, states in stations.items():
        #station站点，states是相应站点覆盖的区域
        covered = states_needed & states
        if len(covered) > len(states_covered):
            best_station = station#标记当前最好的站点
            states_covered = covered#记录相应的站点覆盖区
    states_needed -= states_covered #从需要包含的区域中减去已经包含的区域
    final_stations.add(best_station)#在最终站点中添加最佳站点

print(final_stations)
