This problem is backtracking problem but here i need to print all possible dictionary words.
approach 1:
    1)Backtracking + HashSet as dictionary word
        Memory consuming and more possible word create checks.
approach 2:
    2) Backtracking + Trie data structure as optimal way of the solution.
        Less memory and no check required as Trie node it self contains property as current character is end of the word or not
        and we can use that directly.

So i have used trie data structure as optimal way of the solution.

Following is the sample output:

*********** MENU ***************
1. Load dictionary
2. Print All Possible Words
0. Exit
*********************************
Enter your input:
1
Enter file name:
C:\\Rahul\\input.txt
Create Dictionary took time:  9637400 ns
*********** MENU ***************
1. Load dictionary
2. Print All Possible Words
0. Exit
*********************************
Enter your input:
2
Enter numbers between 2 to 9 :
56835282
love java
love lava
Generate Possible dictionary word took time:  1918200 ns
*********** MENU ***************
1. Load dictionary
2. Print All Possible Words
0. Exit
*********************************
Enter your input:
2
Enter numbers between 2 to 9 :
568352825683528256835282
love java love java love java
love java love java love lava
love java love lava love java
love java love lava love lava
love lava love java love java
love lava love java love lava
love lava love lava love java
love lava love lava love lava
Generate Possible dictionary word took time:  436600 ns
*********** MENU ***************
1. Load dictionary
2. Print All Possible Words
0. Exit
*********************************
Enter your input:
0

Process finished with exit code 0


Note:
One word in dictionary contains '-'. "cross-bun"
I have removed it from file as no special character allowed in dictionary words.

Other thing works fine. I can create special character Trie as well for future enhancement.
