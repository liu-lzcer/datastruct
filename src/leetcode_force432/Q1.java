package leetcode_force432;

import java.util.ArrayList;
import java.util.List;

class Solution_zigzagTraversal {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>()  ;

        for(int i = 0; i < grid.length;i++) {
            int j = 0;
            for(; j < grid[0].length;j+=2) {
                list.add(grid[i][j]);
            }
            if(grid[0].length+1 == j)
                j--;
            else j-=3;
            i++;
            for (int k = j;k >= 0; k-=2) {
                list.add(grid[i][k]);
            }
        }


        return list;
    }

}