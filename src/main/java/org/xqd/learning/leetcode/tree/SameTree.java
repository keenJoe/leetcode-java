package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 100. Same Tree
 *
 * @author qidongxu
 */
public class SameTree {

    /**
     * 使用一个队列实现广度优先搜索
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        // 广度优先
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while (!tmpQueue.isEmpty()) {
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }

    /**
     * 深度优先搜索
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeUsingBreadth(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Deque<TreeNode> pDeque = new ArrayDeque<>();
        Deque<TreeNode> qDeque = new ArrayDeque<>();

        pDeque.add(p);
        qDeque.add(q);

        while (!pDeque.isEmpty() && !qDeque.isEmpty()) {
            int pSize = pDeque.size();
            int qSize = qDeque.size();

            while (pSize != 0 && qSize != 0) {
                TreeNode pNode = pDeque.pollFirst();
                TreeNode qNode = qDeque.pollFirst();

                if (pNode.val != qNode.val) {
                    return false;
                }

                if (pNode.left == null && qNode.left != null) {
                    return false;
                } else if (pNode.left != null && qNode.left == null) {
                    return false;
                } else if (pNode.left != null && qNode.left != null) {
                    pDeque.add(pNode.left);
                    pDeque.add(qNode.left);
                }

                if (pNode.right == null && qNode.right != null) {
                    return false;
                } else if (pNode.right != null && qNode.right == null) {
                    return false;
                } else if (pNode.right != null && qNode.right != null) {
                    pDeque.add(pNode.right);
                    pDeque.add(qNode.right);
                }

                pSize--;
                qSize--;
            }
        }

        return true;
    }

    /**
     * 深度优先搜索
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeUsingDepth(TreeNode p, TreeNode q) {
        return false;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }


    /**
     * 先用递归的方式
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    public boolean r(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        while ((p != null && q != null) || (!stackP.isEmpty() && !stackQ.isEmpty())) {
            while (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }

                stackP.add(p);
                stackQ.add(q);

                p = p.left;
                q = q.left;
            }

            p = stackP.pop();
            q = stackQ.pop();

            p = p.right;
            q = q.right;
        }

        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //先考虑边界情况
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
