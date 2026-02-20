// Number of ways to paint N × 3 Grid

/*You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.

Sol:-
Grid size: n × 3
Colors: Red, Yellow, Green (3 colors)
Constraint:
	No horizontal neighbors same
	No vertical neighbors same
	
Time Complexity: O(n)
Space Complexity: O(1)


Type A – All 3 cells different
R Y G
R G Y
Y R G
Y G R
G R Y
G Y R
count : 3 × 2 × 1 = 6


Type B – Two cells same, one different
R Y R
Y R Y
G R G
R G R
Y G Y
G Y G
count: 3 × 2 = 6

Input : n=1
Total ways = typeA + typeB
            = 6 + 6
            = 12
-----------------------------------			

Input: n=2
Compute Type A for Row 2
newTypeA = (2 × typeA) + (2 × typeB)
          = (2 × 6) + (2 × 6)
          = 12 + 12
          = 24

Compute Type B for Row 2
newTypeB = (2 × typeA) + (3 × typeB)
          = (2 × 6) + (3 × 6)
          = 12 + 18
          = 30
		  
Total Ways for n = 2
Total = newTypeA + newTypeB
       = 24 + 30
       = 54

*/

class NumOfWays {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long typeA = 6; // all 3 different
        long typeB = 6; // two same

        for (int i = 2; i <= n; i++) {
            long newTypeA = (2 * typeA + 2 * typeB) % MOD;
            long newTypeB = (2 * typeA + 3 * typeB) % MOD;

            typeA = newTypeA;
            typeB = newTypeB;
        }

        return (int)((typeA + typeB) % MOD);
    }
}
