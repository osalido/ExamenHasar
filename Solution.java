package examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	// Complete la siguiente funcion climbingLeaderboard.
	public static int[] climbingLeaderboard(int[] scores, int[] alice) {
		
		// variable con el resultado
        int[] result = new int[alice.length];
        
        int ranking = 0;
        int pos = alice.length - 1;
        int score = Integer.MAX_VALUE;
        
        // recorro los scores 
        for(int i = 0; i < scores.length; i ++) {
        	
        	// si el actual es menor al anterior (porque puede haber scores repetidos)
            if(scores[i] < score) {
                score = scores[i];
                ranking ++;
                // Recorro los puntajes de Alice de manera descendente
                while (pos >= 0) {
                	// Si el puntaje actual de Alice es mayor o igual al score que estoy evaluando, 
                	// entonces tengo su ubicacion en el ranking
                	if(alice[pos] >= score) {
                		result[pos] = ranking;
                		pos--;
                    } else {
                        break;
                    }
                }
            }
        }
        ranking++;
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0) {
                result[i] = ranking;
            }
        }
        return result;

	}
	
	private static int binarySearch(int arr[], int low, int high, int key) { 
	    if (high < low) 
	        return -1; 
	    int mid = (low + high) / 2; /*low + (high - low)/2;*/
	    if (key == arr[mid] || (key < arr[mid-1] && key > arr[mid + 1])) 
	        return mid; 
	    if (key < arr[mid]) 
	        return binarySearch(arr, (mid + 1), high, key); 
	    return binarySearch(arr, low, (mid - 1), key); 
	} 

}
