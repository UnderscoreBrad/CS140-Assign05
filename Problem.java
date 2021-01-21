package assignment05;
//package exam01;

import java.util.*;

public class Problem {
	
	public static String findDigits (String userId) {
		// if userId is null, return null, if userId is "", return userId
		if(userId == null){
			return null;
		}else if(userId .equals("")){
			return userId;
		}
		// Find the index i where the first digit appears in the userId
		// If c is a char, then Character.isDigit(c) is true if c is a digit, otherwise false
		int index = -1;
		char[] c = userId.toCharArray();
		for(int i = 0; i < c.length; i++){
			if(Character.isDigit(c[i])){
				index=i;
				break;
			}
		}
		if(index==-1){
			return "0";
		}else return userId.substring(index);
		// You can use either of 2 ways to go through the String:
		// 1. use char[] cs = userId.toCharArray(); which turns userId into its array of chars
		// or 2. loop through userId looking at each userId.charAt(i), which is the char
		// at index i. The length of userId is userId.length(), which is the same as cs.length

		// If you do not find any digits in userId, return "0"
		// otherwise return userId.substring(i)
		// For example findDigits("lander") is "0" but findDigits("smith71") is "71"
	}

	public static List<Integer> intParts (List<String> userIds) {
		if(userIds==null){
			return null;
		}else if(userIds.isEmpty()) {
			return List.of();
		}
		List<Integer> rtn = new ArrayList<>();
		for(int i = 0; i < userIds.size(); i++){
			String uid = findDigits(userIds.get(i));
			if(uid != null && !uid.equals(userIds.get(i))) {
				int idnum = Integer.parseInt(uid);
				rtn.add(idnum);
			}
		}
		return rtn;
		// return an ArrayList of the numeric parts of the userIds, for example
		// var test = List.of("xxx12", "a123", "bbb1", null, "ccc", "", "fasdfa7", "adfa23");
		// System.out.println(intParts(test)); prints
		// [12, 123, 1, 0, 7, 23]

		// If userIds is null, return null, if (userIds.isEmpty()) return List.of()
		
		// The previous question has the code to find substring of digits in the userId	
		// If a String uId in the list userIds is null or is empty SKIP OVER it
		// Otherwise add Integer.parseInt(findDigits(uId)) to the output list.
		
		// change to the correct value if strings is not empty
	}
	
	public static BankAccount[] largestAndSmallest(List<BankAccount> list) {
		if(list == null || list.isEmpty()) throw new IllegalArgumentException("Bad list");
		// The "size" of the BankAccount object will be the value of getBalanceInCents(). This is a 
		// long in order to have an exact balance with no inaccuracies that are possible with double. 
		
		// Find the minimum and maximum values of getBalanceInCents() for all the BankAccount
		// objects in list, if you find any objects that are null, throw new IllegalArgumentException
		// with the message "Bad list"
		long minBal = Long.MAX_VALUE;
		long maxBal = Long.MIN_VALUE;
		List<Integer> minIndexes = new ArrayList<>();
		List<Integer> maxIndexes = new ArrayList<>();
		List<BankAccount> minMax = new ArrayList<>();		//this hacky solution implementation brought to you by:
		for(int i = 0; i < list.size(); i++){				//Tester that requires a singular output order.
			if(list.get(i)==null) {
				throw new IllegalArgumentException("bad input");
			}
				if (list.get(i).getBalanceInCents() == maxBal) {
					maxIndexes.add(i);
				} else if (list.get(i).getBalanceInCents() > maxBal) {
					maxIndexes.clear();
					maxIndexes.add(i);
					maxBal = list.get(i).getBalanceInCents();
				}
				if (list.get(i).getBalanceInCents() == minBal) {
					minIndexes.add(i);
				} else if (list.get(i).getBalanceInCents() < minBal) {
					minIndexes.clear();
					minIndexes.add(i);
					minBal = list.get(i).getBalanceInCents();
				}
			}
		minIndexes.addAll(maxIndexes);
		Collections.sort(minIndexes);					//THIS was pain. Pure pain.
		for(int i = 0; i < minIndexes.size(); i++){
			minMax.add(list.get(minIndexes.get(i)));
		}
		// Return an array of all the BankAccounts in list that have getBalanceInCents() either equal to
		// the minimum value equal to the maximum value.
		
		// It is acceptable to make an ArrayList of all the bankAccounts that have getBalanceInCents() 
		// equal to either the minimum or the maximum areas and then copy those over 
		// to the return array that will have length equal to the size() of the ArrayList.
		BankAccount[] rtn  =  new BankAccount[minMax.size()];
		rtn = minMax.toArray(rtn);
		return rtn; // change to the correct array if list is not empty
	}
}
