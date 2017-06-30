class LintCode_4 {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        
        Queue<Long> PQ = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++){
            PQ.add(primes[i]);
            set.add(primes[i]);
        }
        
        Long min = Long.valueOf(1);
        for(int i = 1; i < n; i++){
            min = PQ.poll();
            for(int j = 0; j < 3; j++){
                if(!set.contains(min * primes[j])){
                    PQ.add(min * primes[j]);
                    set.add(min * primes[j]);
                }
            }
        }
        
        return min.intValue();
    }
}