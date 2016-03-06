package chap4;

import java.util.*;

import chap2.TreeNode;

/**
 * 从上往下打印二叉树
 * 
 * 题目描述
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author Administrator
 * 
 */

public class Solution23 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            
            
            while(size > 0){
                TreeNode tmp = queue.poll();
                res.add(tmp.val);
            	if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;    
            }
        }
        return res;
	}
}
