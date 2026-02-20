// Bus Ticket Change

/*You are given an array arr[] representing passengers in a queue. Each bus ticket costs 5 coins,
 and arr[i] denotes the note a passenger uses to pay (which can be 5, 10, or 20). You must serve the
 passengers in the given order and always provide the correct change so that each passenger effectively
 pays exactly 5 coins. Your task is to determine whether it is possible to serve all passengers 
 in the queue without ever running out of change.

Input: arr[] = [5, 5, 5, 10, 20]
Output: true

Input: arr[] = [5, 5, 10, 10, 20]
Output: false

Core idea

Each ticket costs 5.
Passengers pay with 5, 10, or 20.
You must:

take the note

give change immediately

never go negative on change

So you only need to track how many 5-coins and 10-coins you currently have.
 A 20-note change must always prefer giving 10 + 5 instead of 5 + 5 + 5 (greedy choice).

✅ Change rules

If passenger pays 5 → no change; increase count of 5s

If passenger pays 10 → must give back 5

If passenger pays 20 → must give:

first preference: 10 + 5

otherwise: 5 + 5 + 5

otherwise: impossible

If at any step change cannot be given → return false.


Time: O(n)
Space: O(1)

Strategy: Greedy (always keep smaller notes available)*/

public boolean canServeAll(int[] arr) {
    int five = 0, ten = 0;

    for (int bill : arr) {
        if (bill == 5) {
            five++;
        } else if (bill == 10) {
            if (five == 0) return false;
            five--;
            ten++;
        } else { // bill == 20
            if (ten > 0 && five > 0) { // give 10 + 5
                ten--;
                five--;
            } else if (five >= 3) { // give 5 + 5 + 5
                five -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
}
