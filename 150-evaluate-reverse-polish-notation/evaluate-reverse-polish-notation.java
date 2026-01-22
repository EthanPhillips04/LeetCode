class Solution {
    public int evalRPN(String[] tokens) {

        int[] stack = new int[tokens.length];
        int top = 0;

        for (String s : tokens) {
            char ch = s.charAt(0);

            if (ch == '+') {

                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a + b;
            } else if (ch == '-' && s.length() == 1) {

                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a - b;
            } else if (ch == '*') {

                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a * b;
            } else if (ch == '/') {

                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a / b;
            } else {

                stack[top++] = Integer.parseInt(s);
            }
        }

        return stack[0];
    }
}