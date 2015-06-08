package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Calculator {

	public static final int roll(int n, int size) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += (int) (Math.floor(Math.random()*size)) + 1;
		}
		return sum;
	}
	
	public static final double calculate(String expression) throws Exception {
		expression = "0.0 + " + expression;
		ArrayList<String>	inFix	= tokenize(expression);
		ArrayList<String>	postFix	= infixToPostfix(inFix);
		double				result	= evaluatePostfix(postFix);
		
		return result;
	}
	
	public static final ArrayList<String> tokenize(String expr) throws Exception {
		char				c;
		Character			C;
		int					i;
		String				token = "";
		ArrayList<String>	tokenList = new ArrayList<String>();
		int					nOpen, nClose;
		
		nOpen = 0;
		nClose = 0;
		
		for(i=0; i<expr.length(); i++) {
			c = expr.charAt(i);
			C = new Character(c);
			
			switch(c) {
				case '0':
					token += c;
					break;
				case '1':
					token += c;
					break;
				case '2':
					token += c;
					break;
				case '3':
					token += c;
					break;
				case '4':
					token += c;
					break;
				case '5':
					token += c;
					break;
				case '6':
					token += c;
					break;
				case '7':
					token += c;
					break;
				case '8':
					token += c;
					break;
				case '9':
					token += c;
					break;
				case '-':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case '+':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case 'x':
				case 'X':
				case '*':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case '/':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case '.':
					if (!token.contains(C.toString())) {
						token += c;
					} else {
						throw new Exception("Only 1 decimal allowed");
					}
					break;
				case '(':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case ')':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case '^':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case '%':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				case 'd':
				case 'D':
					if (token.length() > 0) {
						tokenList.add(token);
					}
					tokenList.add(C.toString());
					token = "";
					break;
				default:
					break;
			}
		}
		
		if (nOpen > nClose) {
			throw new Exception("Missing )");
		} else if (nOpen < nClose) {
			throw new Exception("Missing (");
		}

		if (token.length()>0) {
			tokenList.add(token);
		}
		return tokenList;
	}
	
	public static final ArrayList<String> infixToPostfix(ArrayList<String> inFix) throws Exception {
		ArrayList<String>	postFix = new ArrayList<String>();
		Stack<String>		opStack = new Stack<String>();
		Iterator<String>	itr = inFix.iterator();
		String				token;
		TokenType			tokenType;
		
		while(itr.hasNext()) {
			token = itr.next();
			tokenType = getTokenType(token);
			
			if (isOperand(tokenType)) {
				pushToken(postFix, token);
			} else {
				while(!isEmpty(opStack)) {
					String 		topOp = peek(opStack);
					TokenType	topType = getTokenType(topOp);
					
					if (!hasPrescedence(topType, tokenType)) {
						break;
					}
					popOp(opStack);
					pushToken(postFix, topOp);
				}
			
				if (tokenType != TokenType.close) {
					pushOp(opStack, token);
				} else {
					popOp(opStack);
				}
			}
		}
		
		while(!isEmpty(opStack)) {
			token = popOp(opStack);
			pushToken(postFix,token);
		}
		
		return postFix;
	}
	
	public static final String peek(Stack<String> S)	{
		return S.peek();
	}
	
	public static final boolean isEmpty(Stack<String> S)	{
		return S.isEmpty();
	}
	
	public static final void pushOp(Stack<String> S, String T) {
		S.push(T);
	}
	
	public static String popOp(Stack<String> S) {
		if (!S.isEmpty()) {
			String T = S.pop(); 
			return T;
		} else {
			return null;
		}
	}
	
	public static final void pushToken(ArrayList<String> S, String T) {
		S.add(T);
	}
	
	public static final double evaluatePostfix(ArrayList<String> postFix) throws Exception {
		if (postFix==null) throw new Exception("No PostFix expression (null)");
		
		Stack<Double>		S = new Stack<Double>();
		Iterator<String>	itr = postFix.iterator();
		
		while(itr.hasNext()) {
			String		token = itr.next();
			TokenType	type = getTokenType(token);
			Double		A1, A2;
			
			switch(type) {
				case number:
					S.push(new Double(token));
					break;
				case addition:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(A1.doubleValue() + A2.doubleValue()));
					break;
				case subtract:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(A1.doubleValue() - A2.doubleValue()));
					break;
				case multiply:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(A1.doubleValue() * A2.doubleValue()));
					break;
				case divide:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(A1.doubleValue() / A2.doubleValue()));
					break;
				case modulus:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(A1.doubleValue() % A2.doubleValue()));
					break;
				case exponent:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(Math.pow(A1.doubleValue() , A2.doubleValue())));
					break;
				case roll:
					A2 = S.pop();
					A1 = S.pop();
					S.push(new Double(roll(A1.intValue() , A2.intValue())));
					break;
				case close:
				case open:
				default:
					break;

			}
		}
		
		if (S.size()==1) {
			return S.pop().doubleValue();
		} else {
			throw new Exception("Malformed postfix");
		}
	}

	public	enum TokenType {
		number,
		multiply,
		divide,
		addition,
		open,
		close,
		subtract,
		modulus,
		exponent,
		roll
	};
	
	public static final TokenType getTokenType(String S) {
		if (S.equals("+"))	return TokenType.addition;
		if (S.equals("-"))	return TokenType.subtract;
		if (S.equals("*"))	return TokenType.multiply;
		if (S.equals("x"))	return TokenType.multiply;
		if (S.equals("X"))	return TokenType.multiply;
		if (S.equals("/"))	return TokenType.divide;
		if (S.equals("("))	return TokenType.open;
		if (S.equals(")"))	return TokenType.close;
		if (S.equals("%"))	return TokenType.modulus;
		if (S.equals("^"))	return TokenType.exponent;
		if (S.equals("d"))	return TokenType.roll;
		if (S.equals("D"))	return TokenType.roll;
		return TokenType.number;
	}
	
	public static final boolean isOperand(TokenType T) {
		return (	T == TokenType.number	);
	}
		
	
	public static final void printTokens(ArrayList<String> A) {
		System.out.print("TOKENS    = ");
		if (A!=null) {
			Iterator<String>	itr = A.iterator();
			while(itr.hasNext()) {
				String	token = itr.next();
				System.out.print(" [" + token + "]");
			}
			System.out.println("");
		} else {
			System.out.println("null");
		}
	}
	
	public static final void printOperators(Stack<String> A) {
		System.out.print("OPERATORS = ");
		if (A!=null) {
			Iterator<String>	itr = A.iterator();
			while(itr.hasNext()) {
				String	token = itr.next();
				System.out.print(" <" + token + ">");
			}
			System.out.println("");
		} else {
			System.out.println("null");
		}
	}	
	
	public static final void printTokensAndOperators(Stack<String> opStack, ArrayList<String> tokens) {
		printOperators(opStack);
		printTokens(tokens);
	}
	
	public static final boolean isOperand(String S) {
		if (S.equals("+"))	return false;
		if (S.equals("-"))	return false;
		if (S.equals("*"))	return false;
		if (S.equals("/"))	return false;
		if (S.equals("%"))	return false;
		if (S.equals("^"))	return false;
		if (S.equals("("))	return false;
		if (S.equals(")"))	return false;
		return true;
	}
	
	public static final boolean hasPrescedence(TokenType op1, TokenType op2) {
		if	((op1 == TokenType.addition) || (op1 == TokenType.subtract))
		{
			if ((op2 == TokenType.addition) || (op2 == TokenType.subtract) || (op2 == TokenType.close))
			{
				return true;
			} 
			else
			{
				return false;
			}
		} 
		else if ((op1 == TokenType.multiply) || (op1 == TokenType.divide) || (op2 == TokenType.modulus) || (op2 == TokenType.roll))
		{
			if ((op2 == TokenType.exponent) || (op2 == TokenType.open))
			{
				return false;
			} 
			else
			{
				return true;
			}
		} 
		else if (op1 == TokenType.exponent)
		{
			if ((op2 == TokenType.exponent) || (op2 == TokenType.open))
			{
				return false;
			} 
			else
			{
				return true;
			}
		} 
		else if (op1 == TokenType.open)
		{
			return false;
		}
		return false;	// unreachable
	}	
}
