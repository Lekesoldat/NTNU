package encapsulation;

import java.util.Map;
import java.util.Stack;

public class RPNCalc {
  private Stack<Double> operandStack = new Stack<Double>();
  private Map<Character, Operator<Double>> operators = Map.of(
      '+', (a, b) -> a+b,
      '-', (a, b) -> b-a,
      '*', (a, b) -> a*b,
      '/', (a, b) -> b/a  
    );
  
  @Override
  public String toString() {
    return operandStack.toString();
  }
  
  public int getSize() {
    return operandStack.size();
  }
  
  public void push(Double operand) {
     operandStack.push(operand);
   }
  
  public double pop() {
    return operandStack.isEmpty() ? Double.NaN : operandStack.pop();
  }
  
  public double peek(int pos) {
    return (pos < 0 || pos > operandStack.size() ? Double.NaN : operandStack.get(operandStack.size() - 1 - pos));
  }
  
  public void performOperation(char operator) {
    double op1 = operandStack.pop(), op2 = operandStack.pop();
    
    // Swap
    if (operator == '~') {
      operandStack.push(op1);
      operandStack.push(op2);
      
    // Regular operands
    } else {
      operandStack.push(operators.get(operator).invoke(op1,  op2));
  } 
}
