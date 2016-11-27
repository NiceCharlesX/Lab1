package tutorial;
import java.util.*;
public class exp {
	String expression;
	ArrayList<mono> list  = new ArrayList<mono>();
	char[] add_sub;	
	int index;
	public exp(){
		
	}
	public exp(String str){
		String[] array = str.split(" ");
		int length = array.length;
		if(length > 1) {
			String temp = array[0];
			int i;
			for (i = 1;i<length;i++){
				temp = temp+array[i];
			}
			this.expression = temp;
		}
		else{
			this.expression = str;
		}
	}
	public boolean checkexp(){
		if(expression.charAt(0) == '+' || expression.charAt(expression.length()-1) == '+' || expression.charAt(0) == '-' || expression.charAt(expression.length()-1) == '-'){
			return false;
		}
		else{
			String temp = "";
			int length = expression.length();
			int i;
			for(i=0;i<length;i++){
				if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
					mono temp_mulexp = new mono(temp);
					if (!temp_mulexp.checkmono()){
						return false;
					}
					else{
						temp = "";
					}
				}
				else{
					temp = temp.concat(String.valueOf(expression.charAt(i)));
				}
				
			}
			mono temp_mulexp = new mono(temp);
			if (!temp_mulexp.checkmono()){
				return false;
			}
		}
		return true;
	}
	
	
	public void saveexp(){
		
		add_sub = new char[10];
		index = 0;
		String temp = "";
		int length = expression.length();
		int i;
		for (i=0;i<length;i++){
			if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
				
				add_sub[index] = expression.charAt(i);
				index++;
				mono temp_mulexp = new mono(temp);
				temp_mulexp.savemono();
				list.add(temp_mulexp);
				temp = "";
			}
			else{
				temp = temp.concat(String.valueOf(expression.charAt(i)));
			}
		}
		mono temp_mulexp = new mono(temp);
		temp_mulexp.savemono();
		list.add(temp_mulexp);
		
	}
}
