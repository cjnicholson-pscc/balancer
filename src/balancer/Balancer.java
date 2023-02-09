/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author nicho
 */
public class Balancer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        // open file and
        // read character by character
        File file = new File(args[0]);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        char opener = (char) 0;

        MyStack stack = new MyStack();

        int c = 0;

        while ((c = bufferedReader.read()) != -1) {

            char character = (char) c;
            // if opener push to stack
            if (isOpener(character)) {
                stack.push(character);
                System.out.println("Pushing " + character);
            }

            // if opener pop from stack and attempt to match
            // if not a match not balance stop here
            if (isCloser(character)) {
                if (!stack.isEmpty()) {
                    opener =  (char) stack.pop();

                    System.out.println("Popping " + character);

                    char closer = getCloser(opener);
                    System.out.println(closer);
                    if(character == closer) {
                        continue;
                    } else {
                        System.out.println("Not the correct opener for closer");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Not match - Empty stack on closer");
                    System.out.println(opener);
                    System.exit(0);
                }
                // if empty stack not balanced stop here
                // until eof
            }
        }
        // if stack is not empty then not balanced
        if (stack.isEmpty()) {
            System.out.println("Balanced!");
        } else {
            System.out.println("Not balanced - stack not empty on EOF");
            System.out.println(stack);
        }
    }

    public static boolean isOpener(char c) {

        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isCloser(char c) {

        return c == ')' || c == ']' || c == '}';
    }

    public static char getCloser(int c) {

        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return (char) -1;
    }

}
