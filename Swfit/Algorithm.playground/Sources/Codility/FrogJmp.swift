import Foundation

public class FrogJmp {
    public func solution(_ X : Int, _ Y : Int, _ D : Int) -> Int {
        var needToJumpDistance = Y - X
        var answer = needToJumpDistance / D
        if needToJumpDistance % D > 0 {
            answer += 1
        }
        return answer
    }
}
