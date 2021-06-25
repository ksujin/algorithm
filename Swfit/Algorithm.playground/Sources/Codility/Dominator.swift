import Foundation

public class Dominator {
    public func solution(_ A : inout [Int]) -> Int {
        // write your code in Swift 4.2.1 (Linux)
        var myDic: [Int: Int] = [:]
        
        for (index, value) in A.enumerated() {
            if myDic[value] == nil {
                myDic[value] = 1
            } else {
                myDic[value]! += 1
            }
            
            print(value.description + "의 개수는" + myDic[value]!.description)
            
            if myDic[value]! > A.count/2 {
                return index
            }
        }
        
        return -1
    }
}
