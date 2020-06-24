import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import sun.java2d.ScreenUpdateManager;
import sun.reflect.generics.tree.Tree;

import java.util.*;


class TreeNode
{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val)
    {
        this.val = val;

    }

}

class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}


public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(1);
        Collections.sort(list, (i1, i2) -> {
            return i1.compareTo(i2);
        });
        System.out.println(list);
    }

    public String PrintMinNumber(int[] numbers)
    {
        String ans = "";
        ArrayList<Integer> list = new ArrayList<>();
        int len = numbers.length;
        System.out.println(len);
        for (int i = 0; i < len; i++)
            list.add(numbers[i]);

        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        for (int i : list)
            ans += i;

        return ans;
    }
}


//public class Solution
//{
//    public int GetUglyNumber_Solution(int index)
//    {
//        int ans[] = new int[index + 1];
//        ans[0] = 1;
//        int cnt2 = 0, cnt3 = 0, cnt5 = 0;
//        int tmp;
//        for (int i = 1; i < index; i++)
//        {
//            tmp = Math.min(ans[cnt2] * 2, Math.min(ans[cnt3] * 3, ans[cnt5] * 5));
//            if (tmp == ans[cnt2] * 2)
//                cnt2++;
//            if (tmp == ans[cnt3] * 3)
//                cnt3++;
//            if (tmp == ans[cnt5] * 5)
//                cnt5++;
//            ans[i] = tmp;
//        }
//        return ans[index - 1];
//    }
//}
//
////public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().FirstNotRepeatingChar("google"));
//    }
//
//    public int FirstNotRepeatingChar(String str)
//    {
//        int cnt[] = new int[200];
//        for (int i = 0; i < str.length(); i++)
//            cnt[str.charAt(i)]++;
//
//        for (int i = 0; i < str.length(); i++)
//            if (cnt[str.charAt(i)] == 1)
//                return i;
//        return -1;
//    }
//}

/**
 * int cnt[] = new int[200];
 * for (int i = 0; i < str.length(); ++i)
 * {
 * if (cnt[str.charAt(i)] == 0)
 * cnt[str.charAt(i)] = i;
 * else if (cnt[str.charAt(i)] > 0)
 * cnt[str.charAt(i)] = -1;
 * System.out.print(cnt[str.charAt(i)]+" ");
 * }
 * System.out.println();
 * int ans = -1, min = Integer.MAX_VALUE;
 * for (int i = 'A'; i <= 'z'; ++i)
 * {
 * if (cnt[i] > 0 && min >= cnt[i])
 * {
 * ans = cnt[i];
 * min = cnt[i];
 * System.out.print(ans);
 * System.out.println((char) i);
 * }
 * }
 * return ans;
 */


//public class Solution
//{
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
//    {
//        ListNode node1 = pHead1;
//        ListNode node2 = pHead2;
//        while (node1 != node2)
//        {
//            if (node1 != null)
//                node1 = node1.next;
//            if (node2 != null)
//                node2 = node2.next;
//
//            if (node1 != node2)
//            {
//                if (node1 == null)
//                    node1 = pHead1;
//                if (node2 == null)
//                    node2 = pHead2;
//            }
//        }
//        return node1;
//    }
//}
//

//public class Solution
//{
//    public int TreeDepth(TreeNode root)
//    {
//        if (root == null)
//            return 0;
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//        return Math.max(left, right) + 1;
//    }
//}

////num1,num2分别为长度为1的数组。传出参数
////将num1[0],num2[0]设置为返回结果
//public class Solution
//{
//    public void FindNumsAppearOnce(int[] array, int num1[], int num2[])
//    {
//        int len = array.length;
//        if (len < 2)
//            return;
//
//        int res = 0;
//        for (int i = 0; i < len; i++)
//            res ^= array[i];
//        int index = getFirst(res);
//        for (int i = 0; i < len; i++)
//        {
//            if (((array[i] >> index) & 1) == 1)
//                num1[0] ^= array[i];
//            else num2[0] ^= array[i];
//        }
//    }
//
//    public int getFirst(int res)
//    {
//        int ans = 0;
//        while ((res & 1) == 0 && ans < 32)
//        {
//            res >>= 1;
//            ans++;
//        }
//        return ans;
//    }
//}

//public class Solution
//{
//    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum)
//    {
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        for (int i = 1; i <= sum / 2; i++)
//        {
//            for (int j = i + 1; j <= sum / 2 + 1; j++)
//                if ((i + j) * (j - i + 1) / 2 == sum)
//                {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    for (int k = i; k <= j; k++)
//                        list.add(k);
//                    ans.add(list);
//                }
//        }
//        return ans;
//    }
//    public static void main(String[] args)
//    {
//        System.out.println(Math.ceil(1.1));
//    }
//}

//public class Solution
//{
//    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum)
//    {
//        ArrayList<Integer> ans=new ArrayList<>();
//        if(array.length==0)
//            return ans;
//        int s = 0, e = array.length - 1;
//        while (true)
//        {
//            int tmp = array[s] + array[e];
//            if(tmp==sum)
//            {
//                ans.add(array[s]);
//                ans.add(array[e]);
//                return ans;
//            }
//            else if(tmp>sum)
//                e--;
//            else if(tmp<sum)
//                s++;
//
//            if(s>=e)
//                return ans;
//        }
//    }
//}

//public class Solution
//{
//    public String LeftRotateString(String str, int n)
//    {
//        StringBuilder builder = new StringBuilder(str);
//        StringBuilder builder2 = new StringBuilder(str);
//        StringBuilder res = new StringBuilder();
//
//        builder.delete(0,n);
//        builder2.delete(n,str.length());
//        res.append(builder).append(builder2);
//        return res.toString();
//    }
//}


//public class Solution
//{
//    public String ReverseSentence(String str)
//    {
//        if (str.trim().equals(""))
//        {
//            return str;
//        }
//        String[] strings = str.split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = strings.length - 1; i >= 0; i--)
//        {
//            stringBuilder.append(strings[i]);
//            if (i != 0)
//                stringBuilder.append(" ");
//        }
//        return stringBuilder.toString();
//    }
//}


//public class Solution
//{
//    public boolean isContinuous(int[] numbers)
//    {
//        int cnt0 = 0, res = 0;
//        int len = numbers.length;
//
//        if (len == 0)
//            return false;
//        Arrays.sort(numbers);
//        for (int i = 0; i < len - 1; i++)
//        {
//            if (numbers[i] == 0)
//            {
//                cnt0++;
//                continue;
//            }
//
//            if (numbers[i] == numbers[i + 1])
//                return false;
//
//            res += numbers[i + 1] - numbers[i] - 1;
//        }
//        if(cnt0>=res)
//            return true;
//        return false;
//    }
//}

//public class Solution
//{
//    public int LastRemaining_Solution(int n, int m)
//    {
//        if(n==0||m==0)
//            return -1;
//        int s = 0;
//        for (int i = 2; i <= n; i++)
//        {
//            s = (s + m) % i;
//        }
//        return s;
//    }
//}

//public class Solution
//{
//    public int Sum_Solution(int n)
//    {
//        if(n==1)
//            return 1;
//        return n+Sum_Solution(n-1);
//    }
//}


//public class Solution
//{
//    public int Add(int num1, int num2)
//    {
//        while (num2 != 0)
//        {
//            int tmp = num1 ^ num2;
//            num2 = (num1 & num2) << 1;
//            num1=tmp;
//        }
//        return num1;
//    }
//}


//public class Solution
//{
//    public int StrToInt(String str)
//    {
//        int flag = 0;
//        int sum = 0;
//        if (str.equals("") || str.length() == 0)
//            return 0;
//
//        char[] chars = str.toCharArray();
//        if (chars[0] == '-')
//            flag = 1;
//        for (int i = flag; i < chars.length; i++)
//        {
//            if(chars[i]=='+')
//                continue;
//            if (chars[i] < '0' || chars[i] > '9')
//                return 0;
//            sum = sum * 10 + chars[i] - '0';
//        }
//        return flag==0?sum:-sum;
//    }
//}


//public class Solution
//{
//    // Parameters:
//    //    numbers:     an array of integers
//    //    length:      the length of array numbers
//    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
//    // Return value:       true if the input is valid, and there are some duplications in the array number
//    //                     otherwise false
//    public boolean duplicate(int numbers[], int length, int[] duplication)
//    {
//        int cnt[]=new int[length];
//        for(int i=0;i<length;i++)
//        {
//            cnt[numbers[i]]++;
//            if(cnt[numbers[i]]==2)
//            {
//                duplication[0]=numbers[i];
//                return true;
//            }
//        }
//        return false;
//    }
//}


//public class Solution
//{
//    int cnt[] = new int[333];
//    int index = 1;
//
//    //Insert one char from stringstream
//    public void Insert(char ch)
//    {
//        if (cnt[ch] == 0)
//            cnt[ch] = index++;
//        else cnt[ch] = -1;
//    }
//
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {
//        int min=Integer.MAX_VALUE;
//        char res='#';
//        for(int i=1;i<=255;i++)
//        {
//            if(cnt[i]>0&&min>cnt[i])
//            {
//                min=cnt[i];
//                res= (char) i;
//            }
//        }
//        return res;
//    }
//}

//class ListNode
//{
//    int val;
//    ListNode next = null;
//
//    ListNode(int val)
//    {
//        this.val = val;
//    }
//}
//
//public class Solution
//{
//
//    public ListNode EntryNodeOfLoop(ListNode pHead)
//    {
//        ListNode p1 = pHead;
//        ListNode p2 = pHead;
//
//        while (p1 != null && p1.next != null)
//        {
//            p1 = p1.next;
//            p2 = p2.next.next;
//            if (p1 == p2)
//            {
//                p1 = pHead;
//                while (p1 != p2)
//                {
//                    p1 = p1.next;
//                    p2 = p2.next;
//                }
//                if(p1==p2)
//                    return p1;
//            }
//        }
//        return null;
//    }
//}


//public class Solution
//{
//    public ListNode deleteDuplication(ListNode pHead)
//    {
//        if (pHead == null || pHead.next == null)
//            return pHead;
//
//        //第一个为空
//        ListNode head = new ListNode(0);
//        head.next = pHead;
//        ListNode pre = head;
//        ListNode last = head.next;
//        while (last != null)
//        {
//            if (last.next != null && last.val == last.next.val)
//            {
//                while (last.next != null && last.val == last.next.val)
//                    last = last.next;
//                pre.next = last.next;
//                last = last.next;
//            } else
//            {
//                pre = pre.next;
//                last = last.next;
//            }
//        }
//        return head.next;
//    }
//}


//class TreeLinkNode
//{
//    int val;
//    TreeLinkNode left = null;
//    TreeLinkNode right = null;
//    TreeLinkNode next = null;
//
//    TreeLinkNode(int val)
//    {
//        this.val = val;
//    }
//}
//
//public class Solution
//{
//    public TreeLinkNode GetNext(TreeLinkNode pNode)
//    {
//        if(pNode==null)
//            return pNode;
//
//        if(pNode.right!=null)
//        {
//            pNode=pNode.right;
//            while(pNode.left!=null)
//                pNode=pNode.left;
//            return pNode;
//        }
//
//        while(pNode.next!=null)
//        {
//            if(pNode.next.left==pNode)
//                return pNode.next;
//            pNode=pNode.next;
//        }
//        return null;
//    }
//}


//class TreeNode
//{
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val)
//    {
//        this.val = val;
//
//    }
//}


//
//public class Solution
//{
//    boolean isSymmetrical(TreeNode pRoot)
//    {
//        TreeNode tmp = copy(pRoot);
//        return check(pRoot,tmp);
//    }
//
//    boolean check(TreeNode node, TreeNode tmp)
//    {
//        if (node == null && tmp == null)
//            return true;
//        else if (node == null || tmp == null)
//            return false;
//
//        if (node.val == tmp.val)
//        {
//            return check(node.left, tmp.right) && check(node.right, tmp.left);
//        }
//        return false;
//    }
//
//    TreeNode copy(TreeNode root)
//    {
//        if (root == null)
//            return null;
//
//        TreeNode node = new TreeNode(root.val);
//        node.left = copy(root.left);
//        node.right = copy(root.right);
//        return node;
//    }
//}


//
//public class Solution
//{
//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
//    {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(pRoot);
//        int rows=1;
//        while (!queue.isEmpty())
//        {
//            ArrayList<Integer> list = new ArrayList<>();
//            int size=queue.size();
//            for(int i=0;i<size;i++)
//            {
//                TreeNode node = queue.poll();
//                if(rows%2==0)
//                    list.add(0,node.val);
//                else list.add(node.val);
//
//                if(node.left!=null)
//                    queue.offer(node.left);
//                if(node.right!=null)
//                    queue.offer(node.right);
//            }
//            res.add(list);
//            rows++;
//        }
//        return res;
//    }
//}


//
//public class Solution
//{
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
//    {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        dfs(res, 0, pRoot);
//        return res;
//    }
//
//    void dfs(ArrayList<ArrayList<Integer>> list, int depth, TreeNode root)
//    {
//        if (root == null)
//            return;
//        if (depth >= list.size())
//            list.add(new ArrayList<>());
//        if (depth % 2 == 0)
//            list.get(depth).add(root.val);
//        else list.get(depth).add(0, root.val);
//        dfs(list, depth + 1, root.left);
//        dfs(list, depth + 1, root.right);
//    }
//}


//public class Solution
//{
//    StringBuilder stringBuilder;
//    int index = -1;
//
//    String Serialize(TreeNode root)
//    {
//        stringBuilder = new StringBuilder();
//        dfs(root);
//        return stringBuilder.toString();
//    }
//
//    void dfs(TreeNode root)
//    {
//        if (root == null)
//        {
//            stringBuilder.append("#,");
//            return;
//        }
//        stringBuilder.append(root.val);
//        stringBuilder.append(',');
//        dfs(root.left);
//        dfs(root.right);
//    }
//
//    TreeNode Deserialize(String str)
//    {
//        String[] strings = str.split(",");
//        return dfs2(strings);
//    }
//
//    TreeNode dfs2(String[] strings)
//    {
//        index++;
//        if (index == strings.length)
//            return null;
//        if (!strings[index].equals("#"))
//        {
//            TreeNode node = new TreeNode(Integer.parseInt(strings[index]));
//            node.left = dfs2(strings);
//            node.right = dfs2(strings);
//            return node;
//        }
//        return null;
//    }
//
//}
//
//class TreeNode
//{
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val)
//    {
//        this.val = val;
//
//    }
//}


//public class Solution
//{
//    int k;
//
//    TreeNode KthNode(TreeNode pRoot, int k)
//    {
//        this.k = k;
//        return dfs(pRoot);
//    }
//
//    public TreeNode dfs(TreeNode root)
//    {
//        TreeNode tmp = null;
//        if (root != null)
//        {
//            tmp = dfs(root.left);
//            if (tmp != null)
//                return tmp;
//            if (--k == 0)
//                return root;
//            tmp = dfs(root.right);
//            if (tmp != null)
//                return tmp;
//        }
//        return null;
//    }
//}
//
//class TreeNode
//{
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val)
//    {
//        this.val = val;
//    }
//}

//import java.lang.annotation.Documented;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution
//{
//
//    public List<Integer> list = new ArrayList<>();
//
//    public static void main(String[] args)
//    {
//        Solution solution = new Solution();
//        solution.Insert(1);
//        solution.Insert(2);
//        solution.Insert(3);
//        solution.Insert(4);
//        solution.Insert(5);
//        solution.Insert(6);
//        System.out.println(solution.GetMedian());
//        System.out.println(solution.list);
//    }
//
//    public void Insert(Integer num)
//    {
//        if (list.size() == 0)
//        {
//            list.add(num);
//            return;
//        }
//
//        for (int i = 0; i < list.size(); i++)
//        {
//            if (num < list.get(i))
//            {
//                list.add(i, num);
//                return;
//            }
//        }
//        list.add(num);
//    }
//
//    public Double GetMedian()
//    {
//        if (list.size() == 0)
//        {
//            return null;
//        }
//
//        if (list.size() % 2 == 0)
//        {
//            int i = list.size() / 2;
//            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
//            return a / 2;
//        }
//
//        list.get(0);
//        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
//
//    }
//
//}


//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Solution
//{
//    public ArrayList<Integer> maxInWindows(int[] num, int size)
//    {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> tmp;
//        int len = num.length;
//
//        if (size == 0)
//            return (ArrayList<Integer>) list;
//        for (int i = 0; i < len - size + 1; i++)
//        {
//            tmp = new ArrayList<>();
//            for (int j = i; j < size + i; j++)
//                tmp.add(num[j]);
//            Collections.sort(tmp);
//            list.add(tmp.get(tmp.size() - 1));
//        }
//        return (ArrayList<Integer>) list;
//    }
//}


//public class Solution
//{
//    public boolean[] vis;
//    public int m, n;
//    public char[] matrix, str;
//
//    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
//    {
//        this.matrix = matrix;
//        this.str = str;
//        m = rows;
//        n = cols;
//        vis = new boolean[m * n + 10];
//        for (int i = 0; i < m; i++)
//            for (int j = 0; j < n; j++)
//            {
//                if (vis[i * n + j])
//                    break;
//                if (check(i, j, 0))
//                    return true;
//            }
//
//        return false;
//    }
//
//    public boolean check(int i, int j, int k)
//    {
//        int index = i * n + j;
//        if (i < 0 || i >= this.m || j < 0 || j >= this.n || matrix[index] != str[k]||vis[index])
//            return false;
//        if (k == str.length - 1)
//            return true;
//        vis[index] = true;
//        if (check(i + 1, j, k + 1) || check(i - 1, j, k + 1) || check(i, j - 1, k + 1) || check(i, j + 1, k + 1))
//            return true;
//        vis[index] = false;
//        return false;
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),5,8,"SGGFIECVAASABCEEJIGOEM".toCharArray()));
//    }
//
//}