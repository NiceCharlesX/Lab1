package tutorial;

import java.util.*;
public class sim {
	String order;
	exp aexp;
	Map<String,String> var_val;
	public sim(String order,exp aexp){
		this.order = order;
		this.aexp = new exp();
		this.aexp = aexp;
	}
	
	public exp makesim(){
		var_val = new HashMap<String,String>();
		String temp  = order.substring(10, order.length());
		String[] array = temp.split(" ");
		int length = array.length;
		int i,j;
		for (i=0;i<length;i++){
			String[] array_temp = array[i].split("=");
			var_val.put(array_temp[0], array_temp[1]);
		}
		for(mono tmp:aexp.list){
			for (var tmp2:tmp.list){
				if(var_val.get(tmp2.name) != null){
					tmp2.name = var_val.get(tmp2.name);
				}
			}
		}
		return aexp;
	}
}
