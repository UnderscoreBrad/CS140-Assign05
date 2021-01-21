package assignment05;

public class Partitioner {

    /**
     * Partitions an array of integers into its remainder classes based off the given modulo,
     * then returns the percentages for each remainder class in an array of doubles.
     * @param arr array of integers that need to be partitioned
     * @param mod modulus used to partition arr into remainders 0 through mod - 1
     * @throws IllegalArgumentException "Bad input" if arr is null or empty, or mod is non-positive
     * @return an array of doubles which hold the percentages for each remainder partition
     */

    public static double[] moduloPartition(int[] arr, int mod){
        if(arr==null || arr.length==0||mod<=0){
            throw new IllegalArgumentException("bad input");
        }
        int[] partitionCounter = new int[mod];
        for(int i : arr){
            partitionCounter[i%mod]+=1;
        }
        double[] percentages = new double[mod];
        for(int i = 0; i < mod; i++){
            percentages[i] = ( ((double)partitionCounter[i]*100)/(double)arr.length );
        }
        return percentages;
    }
}
