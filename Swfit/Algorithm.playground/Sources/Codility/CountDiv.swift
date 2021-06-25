import Foundation

public func solution(_ A : Int, _ B : Int, _ K : Int) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    let b = B / K
    let a = A / K
    var ans = b-a
    if A % K == 0 {
        ans += 1
    }
    return ans
}
