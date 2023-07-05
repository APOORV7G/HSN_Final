import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

@SuppressWarnings("serial")
public class TEST1 extends JFrame implements ActionListener {
    private JTextField inputField;
    private JTextField outputField;
    private JButton submitButton;

    public TEST1() {
        // Set up the frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create the input text field
        inputField = new JTextField(20);
        add(inputField);

        // Create the output text field
        outputField = new JTextField(20);
        outputField.setEditable(false);
        add(outputField);

        // Create the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String input = inputField.getText();
            if (input.isEmpty()) {
                outputField.setText("Please enter a valid expression");
            } else {
                try {
                    int result = evaluateExpression(input);
                    inputField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                	inputField.setText("Invalid input");
                } catch (IllegalArgumentException ex) {
                	inputField.setText("Invalid expression: " + ex.getMessage());
                }
            }
        }
    }

    private int evaluateExpression(String expression) {
        expression = expression.replace(" ", ""); // Remove spaces

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                int num = Integer.parseInt(numBuilder.toString());
                numStack.push(num);
            } else if (currentChar == '+' || currentChar == '*') {
                while (!opStack.isEmpty() && hasPrecedence(currentChar, opStack.peek())) {
                    performOperation(numStack, opStack);
                }
                opStack.push(currentChar);
                i++;
            } else {
                throw new IllegalArgumentException("Invalid character: " + currentChar);
            }
        }

        while (!opStack.isEmpty()) {
            performOperation(numStack, opStack);
        }

        return numStack.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op2 == '*') || (op1 == '+' && op2 == '+');
    }

    private void performOperation(Stack<Integer> numStack, Stack<Character> opStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char operator = opStack.pop();

        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '*') {
            result = num1 * num2;
        }
        numStack.push(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TEST1();
            }
        });
    }
}
