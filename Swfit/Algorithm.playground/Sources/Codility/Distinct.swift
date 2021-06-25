import Foundation

public class Distinct {
    public func solution(_ A : inout [Int]) -> Int {
        // write your code in Swift 4.2.1 (Linux)
        var distinctSet = Set<Int>()
        A.forEach { (value) in
            distinctSet.insert(value)
        }
        return distinctSet.count
    }
}
