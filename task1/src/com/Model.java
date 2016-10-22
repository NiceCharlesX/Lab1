package com;

import java.util.ArrayList;

/**
 * Created by Xiangxi on 2016/10/21.
 */
class Model {
    public void setName(String givenName) {
        this.name = givenName;
    }

    public void setSim(String givenSim) {
        this.sim = givenSim;
    }

    private String name ;
    private String sim;

    public boolean isFlag() {
        return flag;
    }

    private boolean flag = true;
    private static final int FIELDSIZE = 10;
    private int[][] num = new int[FIELDSIZE][FIELDSIZE];
    private int sum = 0;
    private ArrayList<ArrayList<String>> mylist = new ArrayList<>();
    public void print(){
        System.out.println(name);
    }
    public  void expression(){
        int i = 0;
        int j = 0;
        String s;

        boolean t= true;
        ArrayList<String> list = new ArrayList<>();
        while (i<name.length()){
            s = "";
            if ((name.charAt(i) == '+'||name.charAt(i) == '-')&& !t){
                mylist.add(list);
                list = new ArrayList<>();
                list.add(""+name.charAt(i));
                j++;
                t= true;
                i++;
            }
            else if(name.charAt(i)==' '){
                i++;
            }
            else if(name.charAt(i)=='*'&& !t){
                t= true;
                i++;
            }
            else if(name.charAt(i)>= 'a' && name.charAt(i)<= 'z'&& t){
                while(i<name.length()&&name.charAt(i)>= 'a' && name.charAt(i)<= 'z'){
                    s = s.concat(name.substring(i, i + 1));
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
            else if(name.charAt(i)=='^'&& !t){
                i++;
                while(i<name.length()&&name.charAt(i)>= '0' && name.charAt(i)<= '9'){
                    s = s.concat(name.substring(i, i+1));
                    i++;
                }
                num[j][list.size()-1]+=Integer.parseInt(s)-1;
            }
            else if(name.charAt(i)>= '0' && name.charAt(i)<= '9'&& t){
                while(i<name.length()&&name.charAt(i)>= '0' && name.charAt(i)<= '9'){
                    s = s.concat(name.substring(i, i+1));
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
        ArrayList<String> slist = new ArrayList<>();
        String s;
        int[]  itemp = new int[FIELDSIZE];
        int i=0,n=0;
        boolean tf;
        boolean loopFlag = true;
        while(i <sim.length()){
            i++;
            if (sim.charAt(i)==' '){
                tf=true;
                s="";
                i++;
                while(i<sim.length()&&sim.charAt(i)!='='){
                    s = s.concat(sim.substring(i, i+1));
                    i++;
                }
                for(ArrayList<String> list: mylist){
                    tf = tf && !list.contains(s);
                }
                if(tf){
                    System.out.println("Error!!!");
                    loopFlag = false;
                }
                slist.add(s);

                s="";
                i++;
                while(i<sim.length()&&sim.charAt(i)>= '0' && sim.charAt(i)<= '9'){
                    s = s.concat(sim.substring(i, i+1));
                    i++;
                }
                itemp[n]= Integer.parseInt(s);
                n++;
            }
        }
        s= formString(slist, itemp);
        if (loopFlag){
            System.out.print(s);
            if(sum>0&&s.length()!=0){
                System.out.print("+");
            }
            System.out.print(sum);
        }

    }

    private String formString(ArrayList<String> slist, int[]  itemp) {
        sum = 0;
        String s="";
        int n;
        for(ArrayList<String> list: mylist){
            n=1;
            for(String point:list){
                if((point.charAt(0)=='+'||point.charAt(0)=='-') && (s.length()!=0||point.charAt(0)=='-'))
                {
                    s=s+point;
                }
                else if(point.charAt(0)>='0'&&point.charAt(0)<= '9'){
                    n= n*Integer.parseInt(point);
                }
                else{
                    if(slist.contains(point)){
                        for(int i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++)
                        {
                            n=n*itemp[slist.indexOf(point)];
                        }
                    }
                    else{
                        for(int i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++){
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
        return s;
    }

    public void derivative(){
        int i=2,n,sum;
        String st="",s;
        boolean io=false;

        while(i< sim.length()){
            if(sim.charAt(i-2)=='/' &&sim.charAt(i-1)=='d'){
                io =true;
            }
            if(io){
                st = st.concat(sim.substring(i, i+1));
            }
            i++;
        }

        sum=0;
        s="";
        for(ArrayList<String> list: mylist){
            n=1;
            if(list.contains(st)){
                for(String point:list){
                    if((point.charAt(0)=='+'||point.charAt(0)=='-')&&(s.length()!=0))
                    {
                        s=s+point;
                    }
                    else if(point.charAt(0)>='0'&&point.charAt(0)<= '9'){
                        n= n*Integer.parseInt(point);
                    }
                    else{
                        if(point.equals(st)){
                            n=n*num[mylist.indexOf(list)][list.indexOf(point)];
                            for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)]-1;i++){
                                s = s.concat(point).concat("*");
                            }
                        }
                        else{
                            for(i=0;i<num[mylist.indexOf(list)][list.indexOf(point)];i++){
                                s = s.concat(point).concat("*");
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
        else if(sum!=0){
            System.out.print(" "+sum);
        }
    }

    public void  trueorfalse(){
        int i,j;
        String temp;
        for(i=0;i<mylist.size();i++)
            for (j = 0; j < mylist.get(i).size(); j++) {
                temp = mylist.get(i).get(j);
                if (!temp.equals("+") && !temp.equals("-")) {
                    if (!temp.matches("^[a-z]+$") && !temp.matches("^[-+]?(([0-9]+)([.]([0-9]+))?)$")) {
                        flag = false;
                    }
                }
            }
    }
}
