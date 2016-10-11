
package com;

import java.util.*;
public class taskone {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		one a = new one();
		a.name = str;
		a.print();
		a.expression();
		a.trueorfalse();
		if (!a.flag){
			System.out.println("Error!");
		}
		else{
			String sim = input.nextLine();
			a.sim = sim;
			if (sim.contains("!simplify")){
				a.simplify();
			}
			else if (sim.contains("!d/d")){
				a.derivative();
			}
			else {
				System.out.println("Error!");
			}
		}	
	}
}
class one{
	String name ;
	String sim;
	boolean flag = true;
	int[][] num = new int[10][10]; 
	ArrayList<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();
	public void print(){
		System.out.println(name);
	}
	public  void expression(){
		int i = 0;
		int j = 0;
		String s = "";
		
		boolean t= true;
		ArrayList<String> list = new ArrayList<String>();	
		while (i<name.length()){
			s = "";
			if ((name.charAt(i) == '+'||name.charAt(i) == '-')&& t== false){
				mylist.add(list);
				list = new ArrayList<String>();
				list.add(""+name.charAt(i));
				j++;
				t= true;
				i++;
			}
			else if(name.charAt(i)==' '){
				i++;
			}
			else if(name.charAt(i)=='*'&& t==false){
				t= true;
				i++;
			} 
			else if(name.charAt(i)>= 'a' && name.charAt(i)<= 'z'&& t==true){
				while(i<name.length()&&name.charAt(i)>= 'a' && name.charAt(i)<= 'z'){
					s=s+name.charAt(i);
					i++;
				}
				if (list.contains(s)){
					num[j][list.indexOf(s)]++;
				}
				else{
					list.add(s);
					num[j][list.indexOf(s)]=1;
				}
				t=false;
			}
			else if(name.charAt(i)=='^'&&t==false){
				i++;
				while(i<name.length()&&name.charAt(i)>= '0' && name.charAt(i)<= '9'){
					s=s+name.charAt(i);
					i++;
				}
				num[j][list.size()-1]+=Integer.parseInt(s)-1;
			}
			else if(name.charAt(i)>= '0' && name.charAt(i)<= '9'&& t==true){
				while(i<name.length()&&name.charAt(i)>= '0' && name.charAt(i)<= '9'){
					s=s+name.charAt(i);
					i++;
				}
				list.add(s);
				t=false;
			}
			else{
				flag = false;
				break;
			}
		}
		mylist.add(list);	
	}
	
	public void simplify(){
		ArrayList<String> slist = new ArrayList<String>();
		String s;
		int[]  itemp = new int[10];
		int i=0,n=0,sum;
		boolean tf;
		boolean flag = true;
		while(i <sim.length()){
			if (sim.charAt(i)==' '){
				tf=true;
				s="";
				i++;
				while(i<sim.length()&&sim.charAt(i)!='='){
					s+=sim.charAt(i);
					i++;
				}
				for(ArrayList<String> list: mylist){
					if(list.contains(s))
					{
						tf= false;
					}
				}
				if(tf){
					System.out.println("Error!!!");
					flag = false;
				}
				slist.add(s);
				
				s="";
				i++;
				while(i<sim.length()&&sim.charAt(i)>= '0' && sim.charAt(i)<= '9'){
					s=s+sim.charAt(i);
					i++;
				}
				itemp[n]= Integer.parseInt(s);
				n++;
			}
			else{
				i++;
			}
		}
		sum=0;
		s="";
		for(ArrayList<String> list: mylist){
			n=1;
			for(String point:list){
				if(point.charAt(0)=='+'||point.charAt(0)=='-')
				{
					if(s.length()!=0||point.charAt(0)=='-'){
						s=s+point;
					}
				}
				else if(point.charAt(0)>='0'&&point.charAt(0)<= '9'){
					n= n*Integer.parseInt(point);
				}
				else{
					if(slist.contains(point)){
						for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++)
						{
							n=n*itemp[slist.indexOf(point)];
						}
					}
					else{
						for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++){
							s=s+point+"*";
						}
					}
				}
			}
			if(s.length()==0||s.charAt(s.length()-1)=='+'){
				sum=sum+n;
				if(s.length()!=0)
				{
					s = s.substring(0,s.length()-1);
				}
			}
			else if(s.charAt(s.length()-1)=='-'){
				sum=sum-n;
				s = s.substring(0,s.length()-1);
			}
			else
			{
				s=s+n;
			}
		}
		if (flag){
			System.out.print(s);
			if(sum>0&&s.length()!=0){
				System.out.print("+"+sum);
			}
			else if(sum==0 && s.length()!=0){
			}
			else{
				System.out.print(sum);
			}	
		}
				
	}

	public void derivative(){
		int i=2,n,sum;
		String st="",s="";
		boolean io=false;
		
		while(i< sim.length()){
			if(sim.charAt(i-2)=='/' &&sim.charAt(i-1)=='d'){
				io =true;
			}
			if(io){
				st=st+sim.charAt(i);
			}
			i++;
		}
		
		sum=0;
		s="";
		for(ArrayList<String> list: mylist){
			n=1;
			if(list.contains(st)){
		        for(String point:list){
				    if(point.charAt(0)=='+'||point.charAt(0)=='-')
				    {
					    if(s.length()!=0){
						     s=s+point;
					    }
				    }
					else if(point.charAt(0)>='0'&&point.charAt(0)<= '9'){
						n= n*Integer.parseInt(point);
					}
					else{
						if(point.equals(st)){
							n=n*num[mylist.indexOf(list)][list.indexOf(point)];
							for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)]-1;i++){
								s=s+point+"*";
							}
						}
						else{
							for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++){
								s=s+point+"*";
							}
						}
					}
				}
		        if(s.length()==0||s.charAt(s.length()-1)=='+'){
					sum=sum+n;
					if(s.length()!=0)
					{
						s = s.substring(0,s.length()-1);
					}
				}
				else if(s.charAt(s.length()-1)=='-'){
					sum=sum-n;
					s = s.substring(0,s.length()-1);
				}
				else
				{
					s=s+n;
				}
			}
		}
		System.out.print(s);
		if(sum>0&&s.length()!=0){
			System.out.print("+"+sum);
		}
		else if(sum==0){
		}
		else{
			System.out.print(" "+sum);
		}		
	}
	
	public void  trueorfalse(){
		int i,j;
		String temp;
		for(i=0;i<mylist.size();i++){
			for(j=0;j<mylist.get(i).size();j++){
				temp = mylist.get(i).get(j);
				if (temp.equals("+") || temp.equals("-") ){
					continue;
				}
				else {
					if (!temp.matches("^[a-z]+$") && !temp.matches("^[-+]?(([0-9]+)([.]([0-9]+))?)$")){
						flag = false;
					}
				}	
			}
		}
	}		
}


