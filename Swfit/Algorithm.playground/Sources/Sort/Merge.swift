import Foundation
public class MergeSort {
    //나눠서 정렬 nlogn
    public func mergeSort(_ A : inout [Int]) -> [Int] {
        if A.count <= 1 {
            return A
        }
        
        let mid = A.count / 2
        var left = (0..<mid).map{ A[$0] }
        var right = (mid..<A.count).map{ A[$0] }
        
        var mergedLeft = mergeSort(&left)
        var mergedRight = mergeSort(&right)
        return merge(left: &mergedLeft, right: &mergedRight)
    }
    
    func merge(left: inout [Int], right: inout [Int]) -> [Int] {
        var result: [Int] = []
        while !left.isEmpty && !right.isEmpty {
            let value = left.first! < right.first! ? left.removeFirst() : right.removeFirst()
            result.append(value)
        }
        
        if !left.isEmpty {
            result.append(contentsOf: left)
        }
        
        if !right.isEmpty {
            result.append(contentsOf: right)
        }
        return result
    }
}
