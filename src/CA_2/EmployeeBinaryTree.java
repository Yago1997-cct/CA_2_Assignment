/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author yagog
 */
public class EmployeeBinaryTree {
    private TreeNode ebt;
    private int count = 0;
    
    public void insertLevelOrder(ApplicantRecord ilo) {
        if (ilo == null) 
            return;
        
        TreeNode node = new TreeNode(ilo.getFullName(), ilo.getManagerType(), ilo.getDepartmentType());
        count++;
        
        if(ebt == null) {
            ebt = node;
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ebt);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null) {
                cur.left = node;
                return;
            } else if (cur.right == null) {
                cur.right = node;
                return;
            } else {
                q.add(cur.left);
                q.add(cur.right);
            }
        }
    }
    public List<String> levelOrderTraversal() {
        List<String> out = new LinkedList<>();
        if (ebt == null)
            return out;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ebt);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            out.add(cur.toString());
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        } return out;
    }
    
    public int nodeCount() {
        return count;
    }
    
    public int maximun() {
        return maximun(ebt);
    }
    
    private int maximun(TreeNode m) {
        if (m == null)
            return 0;
        int lm = maximun(m.left);
        int rm = maximun(m.right);
        return 1 + Math.max(lm, rm);
    
    }
}


