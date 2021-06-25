import Foundation
public class BinarySearch {
    public func binarySearch(_ A: [Int], key: Int) {
        var left = 0
        var right = A.count-1
        while left <= right {
            let middle = (left+right)/2
            let middleValue = A[middle]
            if middleValue == key {
                print("found!의 인스 위치는" + middle.description)
                return
            }
            if middleValue > key {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }
        print("cannot found")
    }
}
