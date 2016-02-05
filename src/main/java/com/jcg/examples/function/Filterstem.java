package com.jcg.examples.function;

public class Filterstem {
	public static String changetoroot(String testStr){
		 Stemmer s = new Stemmer();
	     
	     char [] charList = testStr.toCharArray();
	     for (int i =0 ; i<charList.length; i++) {
	   	  s.add(charList[i]);
	     }
	     
	     s.stem();
	     
	    return s.toString();}

}
