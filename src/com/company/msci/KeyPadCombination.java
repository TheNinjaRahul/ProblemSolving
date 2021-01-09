package com.company.msci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Key pad combination.
 */
public class KeyPadCombination {

    /**
     * The Keypad.
     */
    static char[][] keypad = {{}, {},
            {'a', 'b', 'c'}, //2
            {'d', 'e', 'f'}, //3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, //6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'} // 9
    };
    /**
     * The Root.
     */
    static Trie root = null;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        /*createDic("C:\\Rahul\\input.txt");
        printAllPossibleDicWords("568352825683528256835282");*/

        Scanner s = new Scanner(System.in);
        String option = "5";
        while (!option.equals("0")) {
            System.out.println("*********** MENU ***************");
            System.out.println("1. Load dictionary");
            System.out.println("2. Print All Possible Words");
            // System.out.println("3. Print Dictionary for tracing smaller inputs:");
            System.out.println("0. Exit");
            System.out.println("*********************************");
            System.out.println("Enter your input:");
            option = s.next();

            switch (option) {
                case "1":
                    System.out.println("Enter file name:");
                    String filename = s.next();
                    createDic(filename);
                    break;

                case "2":
                    System.out.println("Enter numbers between 2 to 9 :");
                    String numbers = s.next();
                    printAllPossibleDicWords(numbers);
                    break;
                /*case "3":
                    StringBuilder sb = new StringBuilder();
                    printDictionary(root, sb);
                    break;*/
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Please Enter Valid Input");
            }
        }
    }

    private static void printDictionary(Trie root, StringBuilder sb) {
        if (root == null) return;
        if (root.isWordEndHear) {
            System.out.println(sb.toString());
        }
        for (int i = 0; i < root.chars.length; i++) {
            if (root.chars[i] != null) {
                sb.append((char) ('a' + i));
                printDictionary(root.chars[i], sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private static void printAllPossibleDicWords(String numbers) {
        long startTime = System.nanoTime();
        FinalCombination finalCombination = new FinalCombination();
        char[] inputs = numbers.toCharArray();
        for (char c : keypad[inputs[0] - '0']) {
            if (root.chars[c - 'a'] != null) {
                finalCombination.sb.append(c);
                getOtherPossibleCharacters(finalCombination, root.chars[c - 'a'], inputs, 1);
                finalCombination.sb.setLength(finalCombination.sb.length() - 1);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Generate Possible dictionary word took time:  " + (endTime - startTime) + " ns");

    }

    private static void getOtherPossibleCharacters(FinalCombination finalCombination, Trie node, char[] inputs, int i) {
        if (node == null) return;

        if (i >= inputs.length) return;
        int key = inputs[i] - '0';
        for (char c : keypad[key]) {
            Trie current = node.chars[c - 'a'];
            if (current != null) {
                if (current.isWordEndHear) {
                    finalCombination.sb.append(c);
                    finalCombination.sb.append(" ");
                    finalCombination.spaces++;
                    if (finalCombination.sb.length() - finalCombination.spaces == inputs.length) {
                        System.out.println(finalCombination.sb);
                    }
                    getOtherPossibleCharacters(finalCombination, root, inputs, i + 1);
                    finalCombination.spaces--;
                    finalCombination.sb.setLength(finalCombination.sb.length() - 2);
                }
                finalCombination.sb.append(c);
                getOtherPossibleCharacters(finalCombination, current, inputs, i + 1);
                finalCombination.sb.setLength(finalCombination.sb.length() - 1);
            }
        }
    }

    /**
     * @param filename
     */
    private static void createDic(String filename) {
        long startTime = System.nanoTime();
        File file = new File(filename);
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("File path looks wrong.\nPlease enter fully qualified file path: e.g. C:\\Rahul\\input.txt");
            return;
        }
        root = new Trie();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            addIntoTrie(root, data.toCharArray(), 0);
        }
        long endTime = System.nanoTime();
        System.out.println("Create Dictionary took time:  " + (endTime - startTime) + " ns");
        myReader.close();
    }

    /**
     * @param root
     * @param str
     * @param i
     */
    private static void addIntoTrie(Trie root, char[] str, int i) {
        try {
            int index = str[i] - 'a';
            if (root.chars[index] == null) {
                root.chars[index] = new Trie();
                if (i == str.length - 1) {
                    root.chars[index].isWordEndHear = true;
                } else {
                    addIntoTrie(root.chars[index], str, i + 1);
                }
            } else {
                if (i == str.length - 1) {
                    root.chars[index].isWordEndHear = true;
                } else {
                    addIntoTrie(root.chars[index], str, i + 1);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.valueOf(str));
            e.printStackTrace();
        }

    }
}

/**
 * The type Trie.
 */
class Trie {
    /**
     * The Chars.
     */
    Trie[] chars = new Trie[26];
    /**
     * The Is word end hear.
     */
    boolean isWordEndHear = false;
}

/**
 * The type Final combination.
 */
class FinalCombination {
    /**
     * The Sb.
     */
    StringBuilder sb = new StringBuilder();
    /**
     * The Spaces.
     */
    int spaces = 0;
}