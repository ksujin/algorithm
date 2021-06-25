import UIKit

let begin = "hit"
let target = "cog"
var words = ["hot", "dot", "dog", "lot", "log", "cog"]
print(P_43163().solution(begin, target, words))

let inputs = [(1,2), (1,3), (1,4), (2,4), (3,4)]
var graph = BFS.makeGraph(inputs: inputs)
for key in graph.keys {
    graph[key]?.sort(by: >)
    
}
print(graph)
DFS.dfs(graph: graph, start: 1) //[3: [4, 1], 2: [4, 1], 1: [4, 3, 2], 4: [3, 2, 1]]
for key in graph.keys {
    graph[key]?.sort(by: <)
}
print(graph)
BFS.bfs(graph: graph, start: 1) //[3: [1, 4], 2: [1, 4], 1: [2, 3, 4], 4: [1, 2, 3]]
