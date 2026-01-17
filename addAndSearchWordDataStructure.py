class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = False

class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        curr = self.root

        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()

            curr = curr.children[c]

        curr.word = True

    def search(self, word: str) -> bool:

        def dfs(j, root):
            curr = root

            for i in range(j, len(word)):
                c = word[i]

                if c == ".":
                    for child in curr.children.values():
                        if dfs(i+1, child):
                            return True
                    return False
                else:
                    if c not in curr.children:
                        return False
                    curr = curr.children[c]

            return curr.word
        
        return dfs(0, self.root)

#Example Usage
word_dict = WordDictionary()

word_dict.addWord("bad")
word_dict.addWord("dad")
word_dict.addWord("mad")

print(word_dict.search("pad"))  # False
print(word_dict.search("bad"))  # True
print(word_dict.search(".ad"))  # True  (matches bad, dad, mad)
print(word_dict.search("b.."))  # True  (matches bad)
print(word_dict.search("..d"))  # True  (matches any)
print(word_dict.search("..."))  # True  (any 3-letter word added)
print(word_dict.search("....")) # False (no 4-letter word)
        
