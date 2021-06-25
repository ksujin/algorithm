import Foundation

public func solution(_ N : Int) -> Int {
    // write your code in Swift 4.2.1 (Linux)
    var isFirstAppeared = false
    var hasPossibility = false
    var answer = 0
    var N = N
    var max = 0
    while N > 1 {
        let remainder = N % 2 //나머지 구하기
        if isFirstAppeared && remainder == 0 {
            hasPossibility = true
            max += 1
        } else if remainder == 1 {
            isFirstAppeared = true
            if hasPossibility {
                answer = max > answer ? max : answer
                max = 0
                hasPossibility = false
            }
        }
        N = N / 2
    }

    if hasPossibility {
        answer = max > answer ? max : answer
    }

    return answer
}

