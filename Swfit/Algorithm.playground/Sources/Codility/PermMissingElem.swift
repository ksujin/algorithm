import Foundation

public func solution(_ A : inout [Int]) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    var newArray = Array(repeating: false, count: A.count + 2)
    A.map { (value)  in
        newArray[value] = true
    }

    for (index, isContained) in newArray.enumerated() {
        if !isContained && index != 0 {
            return index
        }
    }

    return -1
}
