/*
Write a stack client Parentheses that reads in a text stream from standard input 
and uses a stack to determine whether its parentheses are properly balanced. 
For example, your program should print true for [()]{}{[()()]()} and false for [(]).
*/

import java.util.Stack;
import java.util.Scanner;

public class Parentheses {

    Stack<Character> stack = new Stack<>();
    Scanner in = new Scanner(System.in);

    public boolean isBeginning(char arg){
        if (arg == '<' || arg == '{' || arg == '[' || arg == '(')
            return true;
        return false;
    }

    public Character getOpposite(char arg){
        char oppositeChar = ' ';
        switch(arg){
            case '>':
                oppositeChar = '<';
                break;
            case ')':
                oppositeChar = '(';
                break;
            case '}':
                oppositeChar = '{';
                break;
            case ']':
                oppositeChar = '[';
                break;
        }
        return oppositeChar;
    }

    public String readInput() {
        System.out.println("Enter parentheses: ");
        String input = in.next();
        return input;
    }

    public boolean evaluate(String input){
        char top;
        char current;

        for (int i = 0; i < input.length(); i++){
            current = input.charAt(i);
            if (isBeginning(current))
                stack.push(current);
            else if (stack.isEmpty())
                return false;
            else{
                top = stack.pop();
                if (top != getOpposite(current))
                    return false;
            }


        }
        return true;
    }

    /*  MAIN METHOD
    public static void main (String args[]){
        String input = readInput();
        if (evaluate(input) == false)
            System.out.println("False");
        else
            System.out.println("True");
    }
    */
}
