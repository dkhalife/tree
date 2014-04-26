import java.util.EmptyStackException;
import java.util.Stack;

public class ExpressionTree extends Tree {
	public ExpressionTree(String exp){
		super(null);
		
		String[] tokens = exp.split(" ");
		
		Stack<Node> s = new Stack<>();
		for(String t : tokens){
			if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
				try{
					Node b = s.pop();
					Node a = s.pop();
					
					Node r = new Node(t);
					
					r.setLeft(a);
					r.setRight(b);
					
					s.push(r);
				}catch(EmptyStackException e){
					e.printStackTrace();
				}
			}
			else{
				try{
					Integer n = Integer.parseInt(t);
					s.push(new Node(n));
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
			}
		}
		
		setRoot(s.pop());
	}
	
	public static void main(String[] args){
		ExpressionTree test = new ExpressionTree("1 2 3 4 + * -");
		
		inOrder(test);
	}
}
