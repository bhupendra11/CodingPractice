# Recursion and Backtracking

## Standford Programming abstractions Lectures by Julie Zelinski

* [Lecture 8](https://www.youtube.com/watch?v=gl3emqCuueQ&list=PLFE6E58F856038C69&index=8)
* [Lecture 9](https://www.youtube.com/watch?v=gl3emqCuueQ&list=PLFE6E58F856038C69&index=9)
* [Lecture 10](https://www.youtube.com/watch?v=gl3emqCuueQ&list=PLFE6E58F856038C69&index=10)
* [Lecture 11](https://www.youtube.com/watch?v=gl3emqCuueQ&list=PLFE6E58F856038C69&index=11)


### Exhaustive recursion
* Permutations/subsets are about choice
* Both have deep/wide tree of recursive calls
* Depth represents total number of decisions made
* Width of branching represents number of available options per
decision

### Exhaustive recursion is, well, exhaustive
Explores every possible option at every decision point
* Typically very expensive
* N! permutations, 2N subsets
* (Recursion isn't the problem, there just is a huge space to explore)
### Consider partial exploration of exhaustive space
* Similar exhaustive structure, but stop at first "satisfactory" outcome

## Recursive backtracking
#### Cast problem in terms of decision points
* Identify what decisions need to be made
* Identify what options are available for each decision
* A recursive call makes one decision, and recurs on remaining decisions
  
#### Backtracking approach
* Design recursion function to return success/failure
* At each call, choose one option and go with it Recursively proceed and see what happens
* If it works out, great, otherwise unmake choice and try again
* If no option worked, return fail result which triggers backtracking (ie un-making earlier decisions)
  
#### Heuristics may help efficiency
* Eliminate dead ends early by pruning
* Pursue most likely choice(s) first


### Backtracking pseudocode

```cpp
bool Solve (configuration conf)
{
    if (no more choices)// BASE CASE
        return (conf is goal state);
    for (all available choices) {
        try one choice c;
        // solve from here, if works out, you're done
        if (Solve(conf with choice c made)) return true;
            unmake choice c;
    }
    return false; // tried all choices, no soln found
}
```


## Permute -> anagram finder
Permute
```cpp
void RecPermute (string sofar, string rest)
    if (rest == ""){ 
        cout << sofar << end;
    } else {
        for (int i = 0; i < rest. length; i++)  {
            RecPermute(sofar-rest[i]. rest.substr(0, i)+rest.substr(i+1));
    }
}
```

IsAnagram
```cpp
bool IsAnagram(string soFar, string rest, Lexicon &1ex)
{
if (rest == ""){
    return lex.containsWord(sofar):
} else {
    for (int i = 0; i < rest. length; i++) (
        if (IsAnagram(sofarerest[i], rest.substr (0, i)+rest.substr (i+1), lex))
            return true;
    }
    return false:
}
```

## N queens code
```cpp
bool Solve (Grid<bool> &board, int col)
{
    if (col as beard.nunColsO) return true; // base case 
    for (int rowToTry-0; rowToTry<board.numRowsO: rowToTry++) {
        if (IsSafe(board, rowToTry, col)) (
            PlaceQueen (board, rowToTry, col);
            if (Solve(board, col + 1)) return true:
            RemoveQueen (board, rowToTry, col):
        }
    }
    return false:
}

```
