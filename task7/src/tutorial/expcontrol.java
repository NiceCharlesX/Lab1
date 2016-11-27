package tutorial;
import java.util.*;

public class expcontrol {
	String expression;
	exp aexp;
	public expcontrol(String str){
		this.expression = str;

		aexp = new exp(this.expression);
	}
	public boolean callcheck(){
		return aexp.checkexp();
	}
	public void callsave(){
		aexp.saveexp();
		
	}
}
