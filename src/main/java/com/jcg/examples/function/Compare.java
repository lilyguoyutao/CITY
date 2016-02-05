package com.jcg.examples.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;





public class Compare {
	public static double getSimilarDegree(String str1, String str2)  
    {  
		 
		 Map<String, int[]> vectorSpace = new HashMap<String, int[]>();  
        int[] itemCountArray = null; 
          
        
        String strArray[] = str1.toLowerCase().split("\\W+"); 
        
        for(int i=0; i<strArray.length; ++i)  
        {   
       	 if(Filterstop.isstop(strArray[i]))
       	     {
       	 continue;
       	     }
        
            strArray[i]=Filterstem.changetoroot(strArray[i]);
            if(vectorSpace.containsKey(strArray[i]))  
                ++(vectorSpace.get(strArray[i])[0]);  
            else  
            {  
                itemCountArray = new int[2];  
                itemCountArray[0] = 1;  
                itemCountArray[1] = 0;  
                vectorSpace.put(strArray[i], itemCountArray);  
            }  
        }
        

          
        strArray = str2.toLowerCase().split("\\W+");  
        for(int i=0; i<strArray.length; ++i)  
        {  if(Filterstop.isstop(strArray[i]))
	     {   
	             continue;
	          }
        strArray[i]=Filterstem.changetoroot(strArray[i]);
            if(vectorSpace.containsKey(strArray[i]))  
                ++(vectorSpace.get(strArray[i])[1]);  
            else  
            {  
                itemCountArray = new int[2];  
                itemCountArray[0] = 0;  
                itemCountArray[1] = 1;  
                vectorSpace.put(strArray[i], itemCountArray);  
            }  
        }  
          
        //计算相似度  
        double vector1Modulo = 0.00;//向量1的模  
        double vector2Modulo = 0.00;//向量2的模  
        double vectorProduct = 0.00; //向量积  
        Iterator iter = vectorSpace.entrySet().iterator();  
          
        while(iter.hasNext())  
        {  
            Map.Entry entry = (Map.Entry)iter.next();  
            itemCountArray = (int[])entry.getValue();  
            
            vector1Modulo += itemCountArray[0]*itemCountArray[0];  
            vector2Modulo += itemCountArray[1]*itemCountArray[1];  
              
            vectorProduct += itemCountArray[0]*itemCountArray[1];  
        }  
          
        vector1Modulo = Math.sqrt(vector1Modulo);  
        vector2Modulo = Math.sqrt(vector2Modulo);  
        
        
        //返回相似度  
       return (vectorProduct/(vector1Modulo*vector2Modulo));  
    }  
	}


