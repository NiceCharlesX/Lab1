package tutorial;
import java.util.*;

public class simcontrol {
	String order;
	exp aexp;
	print aprint;
	checkorder acheckorder;
	public simcontrol(String str,exp aproofexp){
		this.order = str;
		this.aexp = new exp();
		this.aexp = aproofexp;
	}
	public boolean callcheck(){
		acheckorder = new checkorder(order,aexp);
		return acheckorder.checksim();
	}
	
	public void assign(){
		sim asim = new sim(order,aexp);
		aexp = asim.makesim();
	}
	
	public void callsimplification(){
		simplification asimplification = new simplification(aexp);
		aexp = asimplification.makesim();
	}
	public void callprint(){
		aprint = new print(aexp);
		aprint.makeprint();
	}
}
