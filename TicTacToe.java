package projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	 static ArrayList<Integer> playerPosition=new ArrayList<Integer>();
	 static ArrayList<Integer> cpuPosition=new ArrayList<Integer>();
   public  static void printBoard(char arr1[][]) {
	   for(int i=0;i<5;i++) {
	    	 for(int j=0;j<5;j++) {
	    		   System.out.print(arr1[i][j]);
	    	     }
	    	   System.out.println();
   }
   }
   
      public static void  placepiece(char[][] arr1,int pos,String user) {
    	  char symbol=' ';
    	  if(user.equals("player")) {
    		  symbol='X';
    	  }
    	  else if(user.equals("cpu")) {
    		  symbol='O';
    	  }
    	  switch(pos) {
		   case 1: arr1[0][0]=symbol ;
		   break;
		   case 2: arr1[0][2]=symbol ;
		   break;
		   case 3: arr1[0][4]=symbol ;
		   break;
		   case 4: arr1[2][0]=symbol ;
		   break;
		   case 5: arr1[2][2]=symbol ;
		   break;
		   case 6: arr1[2][4]=symbol ;
		   break;
		   case 7: arr1[4][0]=symbol ;
		   break;
		   case 8: arr1[4][2]=symbol ;
		   break;
		   case 9: arr1[4][4]=symbol ;
		   break;
		   default:
			   break;
		   }
      }
      public static void playerPosUpdate(int pos) {
    	    playerPosition.add(pos);
      }
      public static void cpuPosUpdate(int pos) {
  	    cpuPosition.add(pos);
    }
      public static String decider() {
    	  List<Integer> upperRow= Arrays.asList(1,2,3);
    	  List<Integer> midRow=Arrays.asList(4,5,6);
    	  List<Integer> lowerRow=Arrays.asList(7,8,9);
    	  List<Integer> leftCol=Arrays.asList(1,4,7);
    	  List<Integer> midCol=Arrays.asList(2,5,8);
    	  List<Integer> rightCol=Arrays.asList(3,6,9);
    	  List<Integer> cross1=Arrays.asList(1,5,9);
    	  List<Integer> cross2=Arrays.asList(3,5,7);
    	   
    	  ArrayList<List> winning=new ArrayList<>();
    	  winning.add(upperRow);
    	  winning.add(midRow);
    	  winning.add(lowerRow);
    	  winning.add(leftCol);
    	  winning.add(midCol);
    	  winning.add(rightCol);
    	  winning.add(cross1);
    	  winning.add(cross2);
        for(List l:winning) {
        	if(playerPosition.containsAll(l)) {
        		return("Congratulations you won");
      
        	}
        	else if(cpuPosition.containsAll(l)) {
        		return("Sorry! you lost");
        	}
        	else if(playerPosition.size()+cpuPosition.size()==9){
        		return "draw" ;
        	}
        }
        return "" ;
      }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		  char arr1[][]= {{' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '}} ;
	       int playerPos=0;
	       int cpuPos=0;
		   printBoard(arr1); 
		 for(int i=0;i<5;i++) {
//		   player area
			System.out.println("Put your input here:");
	       while(true) {
	    	   playerPos=sc.nextInt(10);
	       if(!playerPosition.contains(playerPos)&&!cpuPosition.contains(playerPos))
	       {
	    	   break;
	       }
	       else {
	    	 System.out.println("that place is already occupied");  
	       }
	       }
	       
		     placepiece(arr1 ,playerPos ,"player" );
		     printBoard(arr1);
		     playerPosUpdate(playerPos);
		    if(playerPosition.size()>2) {
		     System.out.println(decider());
		       if(decider().equals("Congratulations you won")) {
		    	   break ;
		       }
		    }
		     if(playerPosition.size()==5) {
		    	   break;
		       }
		   
//		   cpu area  
		   while(true) {
		      cpuPos=r.nextInt(9)+1;
		      if(!playerPosition.contains(cpuPos)&&!cpuPosition.contains(cpuPos)) {
		    	   break;
		         }
		      }
		  
		       System.out.println("Computer Input:" + cpuPos);
	           placepiece(arr1, cpuPos, "cpu");
	          printBoard(arr1);
	          cpuPosUpdate(cpuPos);
	          
	          if(cpuPosition.size()>2) {
	 		     System.out.println(decider());
	 		       if(decider().equals("Sorry! you lost")) {
	 		    	   break ;
	 		       }
	 		       
	 		    }
	}
}
}