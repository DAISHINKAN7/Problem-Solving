public class kokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile: piles){
            right = Math.max(right, pile);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            int hoursNeeded = 0;
            for(int pile:piles){
                hoursNeeded += Math.ceil((double)pile / mid);
            }
            if(hoursNeeded > h){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        kokoEatingBananas keb = new kokoEatingBananas();
        int[] piles1 = {3,6,7,11};
        int h1 = 8;
        int[] piles2 = {30,11,23,4,20};
        int h2 = 5;
        int[] piles3 = {30,11,23,4,20};
        int h3 = 6;
        System.out.println(keb.minEatingSpeed(piles1, h1)); // Output: 4
        System.out.println(keb.minEatingSpeed(piles2, h2)); // Output:  30
        System.out.println(keb.minEatingSpeed(piles3, h3)); // Output:  23
    }
}
