package tutorial;
import java.util.*;

public class simplification {
	exp aexp;
	
	public simplification(exp aproofexp){
		this.aexp = new exp();
		this.aexp = aproofexp;
	}
	public exp makesim(){       //化简函数
		int length_exp,length_mono;
		length_exp  = aexp.list.size();
		int i,j,k;
		boolean flag = false;   //标志单项式中是否有0
		for(i=0;i<length_exp;i++){
			length_mono = aexp.list.get(i).list.size();
			for(j=0;j<length_mono;j++){
				if(aexp.list.get(i).list.get(j).name.equals("0")){
					flag = true;
					break;
				}
			}
			if(flag) {
				if(i==0){
					for(k=0;k<aexp.index-1;k++){
						aexp.add_sub[k] = aexp.add_sub[k+1];
					}
					aexp.index--;
					aexp.list.remove(i);
				}
				else if (i == aexp.index-1){
					aexp.index--;
					aexp.list.remove(i);
				}
				else{
					for(k=i-1;k<aexp.index-1;k++){
						aexp.add_sub[k] = aexp.add_sub[k+1];
					}
					aexp.index--;
					aexp.list.remove(i);
				}
				length_exp--;
			}
		}
		
		return aexp;
	}
	

	public boolean num(String str){
		if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
			return false;
		}
		return true; 
	}
	
	
}
