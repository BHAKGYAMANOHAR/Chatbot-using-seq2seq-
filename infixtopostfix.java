import java.util.Stack;
import java.util.Scanner;
import java .lang.Exception;
public class infixtopostfix
{
static int precedence(char c)
{
switch(c)
{

case '+':return 1;
case '-':return 1;
case '*':return 2;
case '/':return 2;
case '^':return 3;
}
return -1;
}
static String infixToPostFix(String expression)

{
String result="";
Stack<Character> stack=new Stack<Character>();
for(int i=0;i<expression.length();i++)

	{

	char c=expression.charAt(i);
	if(precedence(c)>0)

		{

		while(stack.isEmpty()==false &&
		precedence(stack.peek())>=precedence(c))

			{

			result += stack.pop();
			}
		stack.push(c);
		}

	else if(c==')')
		{

		char x = stack.pop();
		while(x!='(')
			{

			result += x;
			x=stack.pop();
			}
		}
	
	else if(c=='(')

		{

		stack.push(c);
		}
	else
		{

		result += c;
		}
	}

return result;
}
public static void main(String[] args) throws Exception
{
System.out.println("Enter the Infix Expression=");
Scanner s=new Scanner(System.in);
String exp=s.next();

System.out.println("Infix Expression: " + exp);
System.out.println("Postfix Expression: " + infixToPostFix(exp));
}
}