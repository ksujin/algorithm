import Foundation

public class SelectionSort {
    //선택 정렬. 인덱스랑 그 뒤에 값들 쭉 돌면서 제일 작은거 찾아서 거기 인덱스에 꽂아줌. 앞에서 부터 정렬됨
    func selectionSort(_ A: inout [Int]) -> [Int] {
        for i in (0..<A.count) {
            let key = A[i]
            var min = key
            var minIndex = i
            for j in (i+1..<A.count) {
                if A[j] < min {
                    min = A[j]
                    minIndex = j
                }
            }
            let temp = A[i]
            A[i] = A[minIndex]
            A[minIndex] = temp
        }
        return A
    }
}
