package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test {

    public void test() {
        List<String> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        /*boolean palindrome = isPalindrome(121);
        int abcabcbb = lengthOfLongestSubstring(" ");
        boolean valid = isValid(")");*/
        /*TreeNode ll = new TreeNode(11);
        TreeNode left = new TreeNode(4, ll, null);
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(6);
        TreeNode right = new TreeNode(8, rl, rr);
        TreeNode root = new TreeNode(5, left, right);
        pathSum(root, 19);*/
        teest();
        System.out.println("----------------------over----------------------");
    }

    public static void teest() {
        Integer t = null;
        int m = t;
        System.out.println(t);
    }

    /**
     * 是否回文
     */
    public static boolean isPalindrome(int x) {
        //转数组
        /*char[] test = String.valueOf(x).toCharArray();
        int len = test.length;
        for (int i = 0; i < (len >> 1); i++) {
            if (test[i] == test[len - i - 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;*/

        //比较后一半回文与前一半
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        //原始数循环除以10，新数将其余数作为其新位上的数，直至原始数不再大于新数，说明已截取完后面的一半
        while (x > rev) {
            rev = x % 10 + rev * 10;
            x = x / 10;
        }
        if (rev != x && rev / 10 != x) {
            return false;
        }
        return true;


    }

    /**
     * 最长回文数
     */
    public static int lengthOfLongestSubstring(String s) {
        //记录每个字符最后一次出现的位置索引
        int[] last = new int[128];
        //起始位置
        int start = 0;
        //最大长度
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            //转为ascode码
            int index = s.charAt(i);
            //若此前未出现过，则保留起始位置，否则起始位置从最后一次出现位置向后挪一位
            start = Math.max(start, last[index]);
            //记录最大长度，若出现更大的长度（当前位置-起始位置），则更新
            len = Math.max(len, i - start + 1);
            //记录该字符最后一次出现位置
            last[index] = i + 1;
        }
        return len;
    }

    /**
     * 有效括号
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    /**
     * 二叉树和
     */
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, target, new ArrayList<>(), result);
        return result;
    }

    public static void find(TreeNode node, int target, List<Integer> list, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        target -= node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(list));
        } else {
            find(node.left, target, list, result);
            find(node.right, target, list, result);
        }
        list.remove(list.size() - 1);
    }

    /**
     * N字形变换
     */
    public static String convert(String s, int numRows) {
        //魔法值，即意义不明的常量值，阿里规约规定要避免使用魔法值，可预先定义一个public static final常量用常量名解释值的含义
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

}




