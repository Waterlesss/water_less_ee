package Exam.day07_7_03;

/**
 * @Author: Waterless
 * @Date: 2022/07/05/17:42
 * @Description: 括号匹配问题
 *给定一个字符串A和其长度n，请返回一个bool值代表它是否为一个合法的括号串（只能由括号组成）
 * "(()())",6
 * 返回：true
 * "()a()()",7
 * 返回：false
 */
public class ParenthesisMatching {
    //解法1 使用标志位的思想。
    public boolean chkParenthesis(String A, int n) {
        // 边界条件
        if (n % 2 != 0) {
            return false;
        }
        if (A.charAt(0) == ')' || A.charAt(n - 1) == '(') {
            return false;
        }
        //标志位，遇到（ ++ 遇到 ） --，最后判断count是不是0即可
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != '(' && A.charAt(i) != ')') {
                return false;
            } else if (A.charAt(i) == '(') {
                count++;
            } else if (A.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }
    /** 用辅助栈解决
     * public boolean chkParenthesis(String A, int n) {
     *         // write code here
     *         if (n % 2 != 0) {
     *             return false;
     *         }
     *         Stack<Character> stack = new Stack<>();
     *         for (char c : A.toCharArray()) {
     *             if (c == '(') {
     *                 stack.push(c);
     *             } else if (c == ')') {
     *             //开始匹配，如果当前栈为空直接false；
     *                 if (stack.isEmpty()) {
     *                     return false;
     *                     //查看当前栈顶元素是否匹配，若匹配，将栈顶元素出栈
     *                 } else if (stack.peek() == '(') {
     *                     stack.pop();
     *                 }
     *             } else {
     *                 return false;
     *             }
     *         }
     *         return stack.isEmpty();
     *     }
     */
}
