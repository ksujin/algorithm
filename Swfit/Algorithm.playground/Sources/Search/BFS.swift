import Foundation

public class BFS {
    
    public static func makeGraph(inputs: [(start: Int, end: Int)]) -> [Int: [Int]] {
        var graph: [Int: [Int]] = [:]
        for input in inputs {
            if graph[input.start] != nil {
                graph[input.start]?.append(input.end)
            } else {
                graph[input.start] = [input.end]
            }
            
            if graph[input.end] != nil {
                graph[input.end]?.append(input.start)
            } else {
                graph[input.end] = [input.start]
            }
            
        }
        return graph
    }
    
    public static func bfs(graph: [Int: [Int]], start: Int) -> [Int] {
        var queue: [Int] = [start]
        var visited: [Int] = []
        
        while !queue.isEmpty {
            let node = queue.remove(at: 0)
            
            if visited.contains(node) {
                continue
            } else {
                visited.append(node)
                if let neighbors = graph[node] {
                    queue += neighbors
                }
            }
        }
        return visited
    }
}
