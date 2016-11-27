package tutorial;

public class print {
	exp aexp;
	public print(exp aproofexp){
		this.aexp = aproofexp;
	}
	public String makeprint(){
		String temp = "";
		int index = 0;
		for(mono tmp:aexp.list){
			int flag = 1;
			for (var tmp2:tmp.list){
				boolean flag2 = false;
				if(flag != 1) {System.out.print("*");temp+="*";}
				if(tmp2.coe != 1){
					System.out.print(tmp2.coe);
					temp+=String.valueOf(tmp2.coe);
					flag2 = true;
				}
				if(flag2) {System.out.print("*");temp+="*";}
				System.out.print(tmp2.name);
				temp+=tmp2.name;
				if (tmp2.times >1){
					System.out.print("^"+tmp2.times);
					temp+="^";
					temp+=String.valueOf(tmp2.times);
				}
				flag ++;
			}
			if(index<aexp.index){
			System.out.print(aexp.add_sub[index]);
			temp+=String.valueOf(aexp.add_sub[index]);
			index++;
			}
		}
		return temp;
	}
}
