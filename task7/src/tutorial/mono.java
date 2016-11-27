package tutorial;
import java.util.*;

public class mono {
	String str;
	ArrayList<var> list = new ArrayList<var>();
	public mono(String str){
		this.str = str;
	}
	public boolean checkmono(){
		if(str.charAt(0) == '*' || str.charAt(str.length()-1) == '*'){
			return false;
		}
		else {
			String[] array = str.split("[*]");
			int length = array.length;
			int i;
			for (i=0;i<length;i++){
				var temp = new var(array[i]);
				if(!temp.checkvar()){
					return false;
				}
			}
		}
		return true;
	}
	
	public void savemono(){
		int i;
		
		String[] array = str.split("[*]");
		int length = array.length;
		for (i = 0;i<length;i++){
			var temp  = new var(array[i]);
			temp.savevar();
			list.add(temp);
		}
	}
}
