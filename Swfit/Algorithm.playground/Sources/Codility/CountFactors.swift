import Foundation

public func solution(_ N : Int) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    var ans = 0
    //2
    for index in (1...N) {
        if index * index > N {
            break
        }
        if N % index == 0 {
            ans += 2
            if (index * index == N) {
                ans -= 1
            }
        }
    }
    return ans
}
