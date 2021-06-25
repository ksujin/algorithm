import Foundation

public class BubbleSort {
    //옆에거랑 한개씩 비교하면서 바꾸는 방식. 그러면 맨 마지막거부터 정렬됨
    public func bubbleSort(_ A: inout [Int]) -> [Int] {
        for index in (0..<A.count-1) {
            for index2 in (0..<A.count-index-1) {
                if (A[index2] > A[index2+1]) {
                    A.swapAt(index2, index2+1)
                }
            }
        }
        return A
    }
}
