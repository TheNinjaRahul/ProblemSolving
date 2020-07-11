package com.company.GFG.tree;

import javafx.application.Application;
import javafx.stage.Stage;

public class IsSubTree {

    public static void main(String[] args) {
    }

    public static boolean isSubtree(Node T, Node S) {
        return isSubtree2(T, S);
    }

    public static boolean isSubtree2(Node s, Node t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (isMatched(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isMatched(Node s, Node t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.data == t.data && isMatched(s.left, t.left) && isMatched(s.right, t.right)) {
            return true;
        }
        return false;
    }
}
