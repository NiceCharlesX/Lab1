package tutorial;

public class dercontrol {
	String order;
	exp  aexp;
	checkorder acheckorder;

	print aprint;
	public dercontrol(String str,exp aproofexp){
		this.order = str;
		this.aexp = new exp();
		this.aexp = aproofexp;
	}
	
	public boolean ordercheck(){
		acheckorder = new checkorder(order,aexp);
		return acheckorder.checkder();
	}
	
	public void callder(){
		der ader = new der(order,aexp);
		aexp = ader.makeder();
	}
	
	public void callsimplification(){
		simplification asimplification = new simplification(aexp);
		aexp = asimplification.makesim();
	}
	
	public String callprint(){
		String temp;
		aprint = new print(aexp);
		temp = aprint.makeprint();
		return temp;
	}
}
