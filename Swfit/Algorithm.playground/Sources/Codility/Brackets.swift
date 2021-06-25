import Foundation

public class Brackets {
    public func solution(_ S : inout String) -> Int {
        enum Brace: String, CaseIterable {
            case big
            case middle
            case small
            
            var openBrace: Character {
                switch self {
                case .big:
                    return "{"
                case .middle:
                    return "["
                case .small:
                    return "("
                }
            }
            var openBraceCounterParts: Character {
                switch self {
                case .big:
                    return "}"
                case .middle:
                    return "]"
                case .small:
                    return ")"
                }
            }
        }
        
        var braceStack: [Character] = []
        
        func canRemoveCounterPart(char: Character) -> Bool {
            let braceType = Brace.allCases.filter { $0.openBraceCounterParts == char }.first
            if let braceType = braceType {
                if braceStack.last == braceType.openBrace {
                    return true
                }
            }
            return false
        }
        
        for char in S {
            let isOpenBrace = Brace.allCases.map { (brace) in
                brace.openBrace
            }.contains(char)
            
            if isOpenBrace {
                braceStack.append(char)
            } else if canRemoveCounterPart(char: char) {
                braceStack.removeLast()
            } else {
                return 0
            }
        }
        
        
        return braceStack.count == 0 ? 1 : 0
    }
}
