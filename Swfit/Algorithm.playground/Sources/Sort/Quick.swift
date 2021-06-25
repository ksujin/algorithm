import Foundation

public class QuickSort {
    //퀵 소트. 피벗 필요.
    func quickSort(_ A : inout [Int]) -> [Int] {
        guard let pivot = A.first, A.count > 1 else {
            return A
        }
        var left = A.filter { $0 < pivot }
        var right = A.filter { $0 > pivot }
        
        return quickSort(&left) + [pivot] + quickSort(&right)
    }
}
