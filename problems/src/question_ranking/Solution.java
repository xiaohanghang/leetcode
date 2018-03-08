package question_ranking;

/**
 * 存在的问题是：：：：：如果从上往下循环  这样的做法我是没成功   从下到上的话   由于归一化  会减少参数 从上到下  就需要所有的参数都要进行计算了
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
 /*   public int minimunTotal(ArrayList<ArrayList<Integer>> triangle){
        if(triangle == null || triangle.size()==0){
            return 0;
        }
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int sumMin = 0;
        for(int i = 0;i<triangle.size();i++){
            for(int j = 0;j<triangle.get(i).size();j++){
                triangle.get(i+1).set(j,Math.min(triangle.get(i).get(j)+triangle.get(i+1).get(j),
                        triangle.get(i).get(j)+triangle.get(i+1).get(j+1)));
            }
        }

        for(int i = 0;i<triangle.get(triangle.size()-1).size()-1;i++){
            sumMin = Math.min(sumMin,triangle.get(triangle.size()-1).get(i));
        }
        return sumMin;

    }*/
     public int minimumTotal(List<List<Integer>> triangle) {
         int[] A = new int[triangle.size()+1];
         for(int i=triangle.size()-1;i>=0;i--){
             for(int j=0;j<triangle.get(i).size();j++){
                 A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
             }
         }
         return A[0];
     }
    public int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i=len-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

}
