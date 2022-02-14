//https://programmers.co.kr/learn/courses/30/lessons/62048
//다시 풀기

class Solution {
    public long solution(int w, int h) {
       
		long wl = Long.parseLong(String.valueOf(w));
		long hl = Long.parseLong(String.valueOf(h));
		
		return (wl*hl) - ( wl+hl-gcd(wl,hl));
        
    }
    private static long gcd( long w , long h ) {
		
		long small,big ;

		big = w >= h ? w : h ;
		small = w < h ? w : h ;

		while ( small != 0 ) {
			long nmg = big % small ;
			big = small;
			small = nmg;
		}
		return big;
	}
}