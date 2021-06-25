import Foundation

public func solution(_ A : inout [Int]) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    let totalSum = A.reduce(0, +)
    var ans = Int.max
    var leftSum = 0
    for p in (1...A.count-1) {
        leftSum += A[p-1]
        let rightSum = totalSum - leftSum
        let myAbs = abs(leftSum - rightSum)
        ans = ans < myAbs ? ans : myAbs
    }
    return ans
}


