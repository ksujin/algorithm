import Foundation

public class InsertionSort {
    
    //삽입 정렬. 카드같은거. 두번째 인덱스부터 앞에꺼 쭉 훑어가면서 자기보다 작고, 큰데 사이에 꽂아줌. 앞에 애들은 정렬되어있는 상태
    func insertionSort(_ A: inout [Int]) -> [Int] {
        for i in (1..<A.count) {
            let key = A[i]
            var compared = i-1
            while compared > 0 && A[compared] > key {
                A[compared+1] = A[compared]
                compared -= 1
            }
            A[compared+1] = key
        }
        return A
    }
}
