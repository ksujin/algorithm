import Foundation

public class P_42587 {
    var priorities: [Int] = [2, 1, 3, 2]
    var location: Int = 2
    
    public init() {
        
    }
    
    func solution(_ priorities:[Int], _ location:Int) -> Int {
        var printCount = 0
        var priorities = priorities
        var location = location
        var isFinish = false
        while true {
            let participant = priorities.remove(at: 0)
            let isParticipantHighest = priorities.allSatisfy { $0 <= participant }
            
            if location == 0 {
                if isParticipantHighest {
                    printCount += 1
                    isFinish = true
                } else {
                    priorities.append(participant)
                    location = priorities.count - 1
                }
            } else {
                if isParticipantHighest {
                    printCount += 1
                } else {
                    priorities.append(participant)
                }
                location -= 1
            }
            
            if isFinish {
                break
            }
        }
        return printCount
    }
}
