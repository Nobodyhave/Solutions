package leetcode;

/**
 * Created by Aleksandr on 17/07/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/rectangle-area
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int maxStartX = Math.max(A, E);
        int minEndX = Math.min(C, G);
        int maxStartY = Math.max(B, F);
        int minEndY = Math.min(D, H);

        int intersection = 0;
        if(maxStartX < minEndX && maxStartY < minEndY){
            intersection = (minEndX  - maxStartX) * (minEndY - maxStartY);
        }

        return (C - A) * (D - B) + (G - E) * (H - F) - intersection;
    }
}
