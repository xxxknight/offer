package chap5;

/**
 * 数组中出现次数超过一半的数字
 * 
 * 题目描述
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 */

public class Solution29 {
	public int MoreThanHalfNum_Solution(int [] array) {
        if(null == array || array.length <= 0){
            return 0;
        }
        int times = 0;
        int candicate = 0;
        for(int num : array){
            if(times == 0){
                candicate = num;
                times = 1;
            }else if(num != candicate){
                times--;
            }else{
                times++;
            }
        }
        
        return checkMoreThanHalf(array, candicate) == true ? candicate : 0;
        
    }
    
    private boolean checkMoreThanHalf(int[] array, int number){
        int times = 0;
        for(int num : array){
            if(number == num){
                times++;
            }
        }
        
        if(times * 2 <= array.length){
            return false;
        }
        return true;
    }

}
