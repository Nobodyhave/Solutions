package leetcode;

/**
 * Created by Aleksandr on 14/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/bulls-and-cows
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if(secret == null || secret.isEmpty() || guess == null || guess.isEmpty() || guess.length() != secret.length()) {
            return "";
        }

        boolean[] isBull = new boolean[guess.length()];
        int[] stateBulls = new int[10];
        int[] stateCows = new int[10];
        int[] guessCount = new int[10];

        for(int i = 0; i < guess.length(); i++) {
            guessCount[guess.charAt(i) - '0']++;
        }

        for(int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                stateBulls[guess.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']--;
                isBull[i] = true;
            }
        }

        for(int i = 0; i < secret.length(); i++) {
            for(int j = 0; j < guess.length(); j++) {
                if(secret.charAt(i) == guess.charAt(j) && !isBull[i] && !isBull[j] && guessCount[guess.charAt(j) - '0'] > 0) {
                    stateCows[guess.charAt(i) - '0']++;
                    guessCount[guess.charAt(j) - '0']--;
                    break;
                }
            }
        }

        int bulls = 0, cows = 0;
        for(int i = 0; i < 10; i++) {
            if(stateCows[i] > 0) {
                cows += stateCows[i];
            }
            if(stateBulls[i] > 0) {
                bulls += stateBulls[i];
            }
        }

        return bulls + "A" + cows + "B";
    }
}
