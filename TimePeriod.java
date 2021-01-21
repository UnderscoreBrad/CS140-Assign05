package assignment05;
//package exam01;

import java.time.Period;

/**
 * Records a period of time in days/hours/minutes/seconds
 * @author CS140
 */

public class TimePeriod {
	private final int[] FACTORS = {1,24,60,60};
	private int[] period = new int[FACTORS.length];
	// period[0] stores days, period[1] stores hours (0-24),
	// period[2] stores minutes (0-59), period[3] stores seconds (0-59) 
	
	public void correctUnits() {
		// if the array period starts out as [12, 25, 70, 65], this
		// method changes the array to be [13, 2, 11, 5], which is the same
		// period of period but the seconds and minutes are less than 60 and
		// hours is less than 24
		// Step 1 fixes the seconds

		for(int i = FACTORS.length-1; i > 0; i--) {
			period[i-1] += period[i] / FACTORS[i]; // add every whole number of 60 seconds to the minutes (period[2])
			period[i] = period[i] % FACTORS[i]; // and keep the remaining seconds in period[3]
		}
		// then step 2 would fix the minutes and step 3 fixes the hours
		// if you see the pattern in these steps you can do them in a loop with i = 3, 2, 1.  
	}

	// PROVIDE A GETTER METHOD
	public int[] getPeriod(){
		// complete here
		return period;
	}

	public void setPeriod(int[] period){
		this.period = period;
	}

	// toString is provided
	@Override
	public String toString() {
		return period[0] + "d " + period[1] + "h " + period[2] + "m " + period[3] + "s";
	}

	public TimePeriod(int... units) {
		// if units.length is not FACTORS.length throw new IllegalArgumentException with the message "Bad input"
		if(units.length!=FACTORS.length){
			throw new IllegalArgumentException("bad input");
		}
		// in a loop set period[i] equal to units[i]
		for(int i = 0; i < units.length; i++){
			period[i] = units[i];
		}
		// call correctUnits() to fix values in the array
		correctUnits();
		// for example new TimePeriod(12, 25, 70, 65) prints as 13d 2h 11m 5s
	}
	
	public TimePeriod(int seconds) {
		// if seconds is negative throw new IllegalArgumentException with the message "Bad input"
		if(seconds<0){
			throw new IllegalArgumentException("bad input");
		}
		// set period[3] to seconds and then call correctUnits()
		period[3] = seconds;
		correctUnits();
		System.out.println(toString());
		// for example new TimePeriod(1131065) prints as 13d 2h 11m 5s
	}

	public int periodInSeconds() {
		// convert all the days, hours and minutes to seconds and
		// return the total period
		int seconds = 0;
		seconds += period[0]*FACTORS[1]*FACTORS[2]*FACTORS[3];
		seconds += period[1]*FACTORS[2]*FACTORS[3];
		seconds += period[2]*FACTORS[3];
		seconds += period[3];
		// for example TimePeriod t = new TimePeriod(12, 25, 70, 65) is stored as [13, 2, 11, 5]
		// and t.periodInSeconds() is 1131065
		return seconds;
	}

	public void add(TimePeriod t) {
		// add the TimePeriod t to this TimePeriod object. The easy way is to add the corresponding
		// array entries t.period[i] to this.period[i], for each i and then call correctUnits()
		for(int i = 0; i < FACTORS.length; i++){
			this.period[i] += t.period[i];
		}
		correctUnits();
	}
	
	public TimePeriod timeDifference (TimePeriod other) {
		// find the time period representing the difference between this TimePeriod and other.
		// The easiest is take the difference of the periodInSeconds of this and other, use
		// Math.abs to get the positive value of the difference, and use that as the 
		// argument to the second constructor above--the one that used seconds.
		int difference = periodInSeconds() - other.periodInSeconds();
		TimePeriod diff = new TimePeriod(Math.abs(difference));
		return diff;
	}
	
	public boolean longerThan(TimePeriod other) {
		// return true if this TimePeriod is larger than other, otherwise return false--compare the 
		// values of periodInSeconds() and other.periodInSeconds().
		return periodInSeconds() > other.periodInSeconds();
	}
}
