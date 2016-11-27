package tutorial;
import java.util.*;
public class IO {
	public static void main(String[] args) {
		String str;
		String sim;
		expcontrol acontrol1;
		simcontrol acontrol2;
		dercontrol acontrol3;
		Scanner input = new Scanner(System.in);
		str = input.nextLine();
		acontrol1 = new expcontrol(str);
		if (!acontrol1.callcheck()){
			System.out.println("Error!");
		}
		else {
			
			System.out.println(str);
			acontrol1.callsave();
		
			sim = input.nextLine();
			
			if (sim.substring(0,5).equals("!d/d ")){
				acontrol3 = new dercontrol(sim,acontrol1.aexp);
				if (acontrol3.ordercheck()){
					acontrol3.callder();
					acontrol3.callsimplification();
					acontrol3.callprint();
				}
				else {
					System.out.println("Error!");
				}
			}
			else if(sim.substring(0, 10).equals("!simplify ")){
				acontrol2 = new simcontrol(sim,acontrol1.aexp);
				if (acontrol2.callcheck()){
					acontrol2.assign();
					acontrol2.callsimplification();
					acontrol2.callprint();
				}
				else {
					System.out.println("Error!");
				}
			}
			else{
				System.out.println("Error!");
			}
			
		}

	}

}
