import Foundation

public func solution(_ A : inout [Int]) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    var resultSet = Set<Int>()
    A.map { (value) in
        if resultSet.contains(value) {
            resultSet.remove(value)
        } else {
            resultSet.insert(value)
        }
    }

    return resultSet.first ?? 0
}
