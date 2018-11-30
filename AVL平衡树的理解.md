******************************************
**AVL 平衡二叉树的理解**   2018/11/22，update 2018/11/23
*******************************************
1. 概念，特点
 - 平衡二叉树是一颗自适应的搜索二叉树，自适应调节平衡因子，使得整颗树平衡。
 - 特定：每个节点的左子树和右子树之差的绝对值不超过2 （**|balance|<=1**）

2. Insert时旋转类型   
 - LL型 : 左孩子的左子树上插入节点      
          5                                                   3      
         / \                                                 / \      
        3    6     左子作父，父为右子，右孙变左孙              2   5      
       / \         --------------------------->            /   / \      
      2   4                                               1   4   6       
     /      
 -> 1     
 
 - RR型 ：右孩子的右子树上插入节点         
     2                                                        4      
    / \                                                      / \       
   1   4          右子作父，父为左子，左孙变右孙               2   5      
      / \         ------------------------------>          / \   \       
     3   5                                                1   3   6       
          \        
       ->  6       
 
 - LR型 ：左孩子的右子树上插入节点    
        5                                           5                                       3      
       / \                                         / \                                     / \    
      2   6    左子按RR型旋转，变换为LL型           3   6            按LL型旋转              2   5    
     / \       ------------------------>         / \           ----------------->        /   / \    
    1   3                                       2   4                                   1   4   6     
         \                                     /
      ->  4                                   1
 
 
 - RL型 ：右孩子的左子树上插入节点  
     2                                           2                                        4
    / \                                         / \                                      / \
   1   5     右子按LL型旋转，变换为RR型          1   4           按RR型旋转                2   5
      / \    -------------------------->          / \         ----------------->       / \   \
     4   6                                       3   5                                1   3   6
     /                                                \
-> 3                                                   6
 
 

 
 
 
 
 
3. 源码实现   
 https://github.com/wangmin-xidian/Java-Tech/tree/master/src/main/java/com/min/algorithm/avltree
 

**reference** 

1. 数据结构&&AVL树原理、插入操作详解及实现   
https://blog.csdn.net/sp_programmer/article/details/41812787

2. 平衡二叉树 之 AVL树   
https://blog.csdn.net/whucyl/article/details/17289841

3. 平衡二叉树 
  https://zhuanlan.zhihu.com/p/25239615
4. java实现平衡二叉树  
  https://blog.csdn.net/ybt_c_index/article/details/80623974

5. Java 7之集合类型 - 二叉排序树、平衡树、红黑树  
  https://blog.csdn.net/mazhimazh/article/details/19961017

6. Delete operations on AVL trees （包含源码）
http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Trees/AVL-delete.html

