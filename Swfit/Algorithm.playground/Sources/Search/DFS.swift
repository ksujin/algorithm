import Foundation

public class DFS {
    public static func dfs(graph: [Int: [Int]], start: Int) -> [Int] {
        var stack = [start]
        var visited: [Int] = []
        while !stack.isEmpty {
            let node = stack.popLast()!
            if visited.contains(node) {
                continue
            } else {
                visited.append(node)
                if let neighbors = graph[node] {
                    stack += neighbors
                }
            }
        }
        return visited
    }
}
