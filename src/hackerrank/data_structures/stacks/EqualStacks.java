package hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aleksandr on 06/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/equal-stacks
 */
public class EqualStacks {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n1 = in.nextInt();
        final int n2 = in.nextInt();
        final int n3 = in.nextInt();

        final int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int height1 = 0;
        final Stack<Integer> stack1 = new Stack<>();
        for(int h1_i= n1-1; h1_i >= 0; h1_i--){
            height1 += h1[h1_i];
            stack1.push(h1[h1_i]);
        }

        final int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int height2 = 0;
        final Stack<Integer> stack2 = new Stack<>();
        for(int h2_i= n2-1; h2_i >= 0; h2_i--){
            height2 += h2[h2_i];
            stack2.push(h2[h2_i]);
        }

        final int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        int height3 = 0;
        final Stack<Integer> stack3 = new Stack<>();
        for(int h3_i= n3-1; h3_i >= 0; h3_i--){
            height3 += h3[h3_i];
            stack3.push(h3[h3_i]);
        }

        while(true) {
            //System.out.println("Height1 = " + height1 + " Height2 = " + height2 + " Height3 = " + height3);
            if(height1 == height2 && height1 == height3) {
                System.out.println(height1);
                break;
            } else if(height1 >= height2 && height1 >= height3) {
                height1 -= stack1.pop();
            } else if(height2 >= height1 && height2 >= height3) {
                height2 -= stack2.pop();
            } else if(height3 >= height1 && height3 >= height2) {
                height3 -= stack3.pop();
            }
        }
    }
}
