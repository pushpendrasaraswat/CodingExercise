package com.nespresso.exercises.train;


public class Train {

	private final String H_FIRST="<HHHH";
	private final String H_LAST="HHHH>";
	private final String P="|OOOO|";
	private final String R="|hThT|";
	private final String C="|____|";
	
	private final String JOINER="::";
	
	StringBuffer train=null;
	public Train(String structure) {
		train = new StringBuffer();
		
		for(int i=0;i<structure.length();i++){
			if(structure.charAt(i)=='H'){
				if(i==0){
					train.append(H_FIRST);
				}else{
					train.append(JOINER);
					train.append(H_LAST);
				}
			}else if(structure.charAt(i)=='P'){
				train.append(JOINER);
				train.append(P);
			}else if(structure.charAt(i)=='R'){
				train.append(JOINER);
				train.append(R);
			}else if(structure.charAt(i)=='C'){
				train.append(JOINER);
				train.append(C);
			}
		}
	}

	public String print(){
		return train.toString();
	}

	public void detachEnd(){
		if(train.toString().contains(H_LAST)){
			train=new StringBuffer(train.toString().replaceAll(JOINER+H_LAST,""));
			
		}
	}

	public void detachHead(){
		if(train.toString().contains(H_FIRST)){
			train=new StringBuffer(train.toString().replaceAll(H_FIRST+JOINER, ""));
			
		}
	}

	public boolean fill(){
        String trainCargo=train.toString();
        int start=0;
        int last=0;
        int count=0;
        int totalCount=4;
        for(int i=0;i<trainCargo.length();i++){
        	if(trainCargo.charAt(i)=='_'){
        		if(count==0){
        			start=i;
        		}
        		count++;
        		if(count==totalCount){
        			last=i;
        		}
        		
        	}
        }
        
        for(int i=start ;i<=last;i++){
        	train.setCharAt(i, '^');
        
        }
        
        if(start == 0){
        	return false;
        }else{
        	return true;
        }
        
       
	}
	
	public static void main(String ar[]){
		 Train train = new Train("HPRPH");
	        train.detachEnd();
	        System.out.println(train.print());
	        System.out.println("<HHHH::|OOOO|::|hThT|::|OOOO|".equalsIgnoreCase(train.print()));
	        train.detachHead();
	        System.out.println(train.print());
	        System.out.println("|OOOO|::|hThT|::|OOOO|".equalsIgnoreCase(train.print()));
	}
}
