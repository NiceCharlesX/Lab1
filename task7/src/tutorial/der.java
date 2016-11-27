package tutorial;

import java.util.*;

public class der {
	String order;
	exp aexp;
	public der(String order,exp aexp){
		this.order = order;
		this.aexp = new exp();
		this.aexp = aexp;
	}
	
	public exp makeder(){
		String temp = order.substring(5, order.length());
		for(mono tmp:aexp.list){
			boolean flag = false;
			for(var tmp2:tmp.list){
				if(tmp2.name.equals(temp)){
					flag = true;
					if (tmp2.times != 1){
						tmp2.coe = tmp2.coe*tmp2.times;
						tmp2.times--;
					}
					else{
						tmp2.name ="1";
						tmp2.times--;
					}
				}
			}
			if (!flag){
				var tmp3 = new var("0");
				tmp3.savevar();
				tmp.list.add(tmp3);
			}
		}
		return aexp;
	}
	
}
