import Foundation

public class FrogRiverOne {
    public func solution(_ X : Int, _ A : inout [Int]) -> Int {
        // write your code in Swift 4.2.1 (Linux)
        var leafSet = Set<Int>()
        
        
        for (index, value) in A.enumerated() {
            leafSet.insert(value)
            if leafSet.count == X {
                return index
            }
        }
        return -1
    }
}
