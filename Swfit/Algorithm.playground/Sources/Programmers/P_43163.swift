import Foundation

public class P_43163 {
    var initialValue: Int = 51
    var min: Int = 51
    
    public init() {
        
    }
    
    /**
     let begin = "hit"
     let target = "cog"
     var words = ["hot", "dot", "dog", "lot", "log", "cog"]
     */
    
    public func solution(_ begin:String, _ target:String, _ words:[String]) -> Int {
        dfs(begin, target, words, 0)
        let answer = min == initialValue ? 0 : min;
        return answer
    }

    func dfs(_ begin: String, _ target: String, _ words: [String], _ depth: Int) {
        var words = words

        if (begin == target) {
            min = depth < min ? depth : min;
            return;
        }
        
        for i in (0..<words.count) {
            let word = words[i]
            var diffCount = 0
            
            let wordCharacters = Array(word)
            let beginCharacters = Array(begin)
            
       
            for j in (0..<wordCharacters.count) {
                if (wordCharacters[j] != beginCharacters[j]) {
                    diffCount += 1
                }
            }
            if (diffCount == 1) {
                words[i] = "";
                dfs(word, target, words, depth+1);
            }
        }
    }

}
