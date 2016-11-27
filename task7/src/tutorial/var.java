package tutorial;
import java.util.*;

public class var {
	String str;
	String name;
	int coe;
	int times;

	public var(String str){
		this.str = str;
	}
	public boolean checkvar(){
		int i;
		int length = str.length();
		for(i=0;i<length;i++){
			if(!(('a'<=str.charAt(i) && str.charAt(i) <='z') || ('0' <= str.charAt(i) && str.charAt(i)<= '9') || (str.charAt(i) == '^'))){
				return false;
			}
		}
		
		String[] array = str.split("\\^");
		if (array.length == 1){
			length = array[0].length();
			for (i=0;i<length;i++){
				if ('a'>=str.charAt(i) || str.charAt(i) >='z') return false;
			}
		}
		else if (array.length == 2){
			length = array[0].length();
			for (i=0;i<length;i++){
				if ('a'>=str.charAt(i) || str.charAt(i) >='z') return false;
			}
			length = array[1].length();
			for (i=0;i<length;i++){
				if ('0'>=str.charAt(i) || str.charAt(i) >='9') return false;
			}
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public void savevar(){
		String[] array = str.split("\\^");
		
		if (array.length == 1){
			name = array[0];
			times = 1;
			coe = 1;
		}
		else{
			coe = 1;
			name = array[0];
			times = Integer.parseInt(array[1]);
		}
	}
}
