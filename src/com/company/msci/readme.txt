Problem Definition:
*********************************************************************************

*Please read all given below given instruction and consider all scenarios to get the best score*

Write a program that takes a number and produces all possible phrases consisting of words that match
this number while using all digits and inserting spaces between words as needed.
 
Use a digit to char mapping printed on the telephone keyboards and a word list as a dictionary
(e.g. http://www.mieliestronk.com/corncob_lowercase.txt). Digit to char mapping is (like on the
standard phone):
 
2 =&gt; [ ‘a’, ‘b’, ‘c’ ]
3 =&gt; [ ‘d’, ‘e’, ‘f’ ]
...
9 =&gt; [ ‘w’, ‘x’, ‘y’, ‘z’ ]
 
For example, if input is “56835282” and dictionary contains words “love” and “java” and “lava”, the
output must contain strings “love java” and “love lava”.
Please provide a full solution. Please pay close attention to the performance. The code must work fast
and be scalable. Please test on a long number (for instance 20 digits) and measure time.

************************************************************************************************



This problem is backtracking problem but here i need to print all possible dictionary words.
approach 1:
    1)Backtracking + HashSet as dictionary word
        Memory consuming as same prefix for possible dictionary words will have character which will occupy memory
        and more possible words will also create more checks as dictionary have this word or not.
approach 2:
    2) Backtracking + Trie data structure as optimal way of the solution.
        Less memory and no check required as Trie node it self contains property as current character is end of the
        dictionary word or not and we can use that property directly.

So i have used trie data structure as optimal way of the solution.


Note:
One word in dictionary contains '-'. Word="cross-bun"
I have removed it from file as no special character allowed in dictionary words.

Other thing works fine. I can create special character Trie as well for future enhancement.

I just need to maintain full ASCII length trie array instead of 26 fix size array as solution.


How to Run:
C:\Rahul\msci> javac .\KeyPadCombination.java
C:\Rahul\msci> java -classpath . KeyPadCombination
*********** MENU ***************
1. Load dictionary
2. Print All Possible Words
0. Exit
*********************************
Enter your input:
0
PS C:\Rahul\msci>

************************************************************************
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
