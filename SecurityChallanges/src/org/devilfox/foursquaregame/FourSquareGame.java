package org.devilfox.foursquaregame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSquareGame {

	private static boolean isInteresting(String word,String pair) {
		int index = word.indexOf(pair);
		
		if(index!=-1 && word.length()>index+2 && word.substring(index+2).indexOf(pair)!=-1) {
			return true;
		}
		return false;
	}
	
	public static void analyze(String original) {
		// Clean the text
		final String clean = original.toLowerCase().replaceAll("[^a-zA-z]","");
		
		// Get the uniq charpairs
		final Set<String> pairs = new HashSet<String>();
		for(int i=0,n=clean.length()/2;i<n;i+=2) {
			pairs.add(clean.substring(i,i+2));
		}
		
		// Get words to check
		final Set<String> words = new HashSet<String>(Arrays.asList(original.toLowerCase().replaceAll("[^a-zA-z ]","").split(" ")));
		final List<String> interesting = new ArrayList<String>();
		
        for(String word : words) {
        	// remove the first char if it is not a first part of a pair
			String w = clean.indexOf(word)%2==0?word:word.substring(1);
        	for(String pair : pairs) {
				// Is there any pair in current word more than once?
				if (isInteresting(w,pair)) {
					interesting.add(word + "("+pair+") ");
				}
			}
		}
		
		// Print 
		System.out.println("Original: " + original);
		System.out.println("Clean: " + clean);
		System.out.print("Pairs: ");
		for(String pair : pairs) System.out.print(pair + " ");
		System.out.println();
		System.out.print("Words to check: ");
		for(String word : interesting) System.out.print(word + " ");
	}
	
	
	public static void main(String[] args) {
		final String original = "Uqzwhppahp pzywp tg outcdv pawaqqzk zaqzaaa. Luweaav ptn oivxazzovupwg aaq slv pqzxwq az rtn snpxgwpxspv. Ptn oboyqppwz xp upan xqzensr saxqzi ee nrxywkyqvy vk sli pwyqtlpgeqrlp. Cl pq yq weywywp, ttnz rtn negeywywp zqpqrosvlaa qrwgy upxwvl oe vgienv lz rtn etcwvlaa ywixqyywp ttn „Giwnyzi” vliivvy cslc. Slo yawgeznosq ls xzq imvcgiizv ptnnepsne slv yvuv vp ievlunqne yq yweonouzywvuo.B";
		analyze(original);
	}

}
