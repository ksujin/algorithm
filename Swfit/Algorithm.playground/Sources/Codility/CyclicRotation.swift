import Foundation

public func solution(_ A : inout [Int], _ K : Int) -> [Int] {
    var newArray: [Int] = Array(repeating: 0, count: A.count)
    for (index, value) in A.enumerated() {
        let newIndex = (index + K) % A.count
        newArray[newIndex] = value
    }
    return newArray
}
