package main.java.exam;

import java.util.Stack;

public class Exam {

    public static void main(String[] args) {
        System.out.println(maxDictionaryOrder("aabcbccacbbcbaaba"));
        System.out.println(magicString("cmccmcmcmcmmccmmccccmccmcmccmmcmcccmmmmmmmm"));
    }

    /**
     * 字符串最大字典序子串
     *
     * @param s
     * @return
     */
    public static String maxDictionaryOrder(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        int len = chars.length;
        //找到字典序最大的元素，再从此元素截断后往后找最大的
        for (int i = 0; i < len; i++) {
            int begin = 0;
            int index = 0;
            char target = 0;
            for (int j = i; j < len; j++) {
                char temp = chars[j];
                Integer num = Integer.valueOf(temp);
                if (num > begin) {
                    target = temp;
                    index = j;
                    begin = num;
                }
                if (j == len - 1) {
                    result += target;
                    i = index;
                }
            }
        }
        return result;
    }

    /**
     * cm字符串插入组合
     *
     * @param s
     * @return
     */
    public static boolean magicString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        //c入栈，m出栈，最后看栈是否为空
        Stack stack = new Stack();
        for (int i = 0; i < len; i++) {
            char temp = chars[i];
            if (temp == 'c') {
                stack.push('c');
            }
            if (temp == 'm') {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
