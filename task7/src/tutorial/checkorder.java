package tutorial;
import java.util.*;

public class checkorder {
	String order; // 存放指令字符串
	exp aexp;
	public checkorder(String str ,exp aproofexp){
		this.order = str;
		this.aexp = new exp();
		this.aexp = aproofexp;
	}
	
	public boolean checksim() {  //检查赋值指令的合法性 
		String temp  = order.substring(10, order.length());
		if(temp.equals("")) return false;
		String[] array = temp.split(" ");
		int length = array.length;
		if (length <1) return false;
		int i,j;
		for (i=0;i<length;i++){
			String[] array_temp = array[i].split("=");
			if (array_temp.length !=2) return false;
			int var_length = array_temp[0].length();
			int int_length =  array_temp[1].length();
			for(j=0;j<var_length;j++){
				if (array_temp[0].charAt(j) < 'a' || array_temp[0].charAt(j) > 'z' ){
					return false;
				}
			}
			if(!checkvar(array_temp[0])) return false;
			for(j=0;j<int_length;j++){
				if (array_temp[1].charAt(j) < '0' || array_temp[1].charAt(j) > '9'  ){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkder(){  //检查求导指令的合法性
		String temp = order.substring(5, order.length());
		if(temp.equals("")) return false;
		int i;
		int length;
		length = temp.length();
		for(i=0;i<length;i++){
			if (temp.charAt(i) < 'a' || temp.charAt(i) > 'z' ){
				return false;
			}
		}
		if(!checkvar(temp)) return false;
		return true;
	}
	
	public boolean checkvar(String temp){ //检查表达式是否包含指令里的变量
		boolean flag = false;
		for(mono tmp:aexp.list){
			for (var tmp2:tmp.list){
				if(tmp2.name.equals(temp)) flag = true;
			}
		}	
		return flag;
	}
}
