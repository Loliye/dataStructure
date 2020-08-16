import java.util.Arrays;
import java.util.Scanner;


public class Solution
{
    public static void main(String sgf[])
    {


        StringBuffer a = new StringBuffer("A");

        StringBuffer b = new StringBuffer("B");

        a.append(b);
        b = a;

        //        operate(a, b);
        //        System.out.println(a + " " + b);


        Integer c = 1000, d = 1000;
        add(c, d);
        System.out.println(c + " " + d);
    }

    int anInt;
    public void add(){
        this.anInt=1;
    }

    static void add(Integer a, Integer b)
    {
        a += b;
        b = a;
    }

    static void operate(StringBuffer x, StringBuffer y)
    {
        x.append(y);
        y = x;
    }

    public  Solution()
    {}

}

//public class Solution
//{
//
//    public static int[] arr = new int[20];
//    public static int ans[] = new int[10];
//
//    public static boolean dfs(int cnt, int head)
//    {
//        if (cnt == 14)
//            return true;
//        if (head == 0)
//        {
//            for (int i = 1; i <= 9; i++)
//                if (arr[i] >= 2)
//                {
//                    arr[i] -= 2;
//                    dfs(cnt + 2, 1);
//                    arr[i] += 2;
//                }
//
//            return false;
//        }
//
//        for (int i = 1; i <= 9; i++)
//        {
//            if (arr[i] >= 3)
//            {
//                arr[i] -= 3;
//                dfs(cnt + 3, head);
//                arr[i] += 3;
//            }
//
//            if (arr[i] > 0 && i + 3 < 9 && arr[i + 1] > 0 && arr[i + 2] > 0)
//            {
//                arr[i] -= 1;
//                arr[i + 1] -= 1;
//                arr[i + 2] -= 1;
//                dfs(cnt + 3, head);
//                arr[i] += 1;
//                arr[i + 1] += 1;
//                arr[i + 2] += 1;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < 13; i++)
//            arr[i] = scanner.nextInt();
//        for (int i = 9; i <= 9; i++)
//        {
//            arr[i]++;
//            if (dfs(0, 0))
//                ans[i]++;
//            arr[i]--;
//        }
//        for (int i : ans)
//            System.out.println(i);
//    }
//}


//public class Solution
//{
//    public static StringBuilder builder;
//
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++)
//        {
//            String string = scanner.next();
//            builder = new StringBuilder(string);
//            for (int j = 0; j < builder.length(); j++)
//                while (judge(j)) ;
//            System.out.println(builder.toString());
//        }
//
//    }
//
//    /**
//     * haha
//     *
//     * @param index haha
//     * @return haha
//     */
//    public static boolean judge(int index)
//    {
//        if (builder.toString().length() >= index + 3 && (builder.charAt(index) == builder.charAt(index + 1)))
//        {
//            if (builder.charAt(index) == builder.charAt(index + 2))
//            {
//                builder.deleteCharAt(index + 1);
//                return true;
//            } else if (builder.length() >= index + 4 && builder.charAt(index + 2) == builder.charAt(index + 3))
//            {
//                builder.deleteCharAt(index + 2);
//                return true;
//            }
//        }
//        return false;
//    }
//}

//public class Solution
//{
//    public static void print(String s)
//    {
//        System.out.println(s);
//    }
//
//    /**
//     * @param n int整型 只剩下一只蛋糕的时候是在第n天发生的．
//     * @return int整型
//     */
//    public int cakeNumber(int n)
//    {
//        // write code here
//        int ans=1;
//        while(n-->1)
//        {
//            ans=3*(ans+1)/2;
//        }
//        return ans;
//    }
//
//    public static void main(String[] args)
//    {
//        List<String> list=new ArrayList<>();
//        list.add("name1");
//        list.add("name2");
//        list.add("name3");
//        list.add("name4");
//
//        list.forEach(Solution::print);
//    }
//}


//public class Solution
//{
//    int mod = (int) (1e9 + 7);
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(350, 35, new int[]{3, 3, 3, 1, 1, 2, 1, 2, 2, 3, 3, 1, 3, 1, 3, 1, 2, 3, 3, 2, 1, 3, 3, 1, 1, 2, 1, 1, 2, 1, 2, 2, 3, 3, 3},
//                new int[]{302, 47, 85, 8, 13, 1, 329, 239, 31, 231, 57, 343, 87, 241, 199, 15, 57, 279, 246, 33, 163, 57, 79, 284, 315, 91, 236, 345, 101, 235, 288, 110, 200, 32, 249}));
//    }
//
//    public int solve(int n, int m, int[] x, int[] y)
//    {
//        int ans[][] = new int[5][n + 1];
//        int a[][] = new int[5][n + 1];
//        for (int i = 0; i < m; i++)
//            a[x[i]][y[i]] = 1;
//        ans[1][1] = 1;
//
//        for (int j = 1; j <= n; j++)
//        {
//            for (int i = 1; i <= 3; i++)
//                if (a[i][j] != 1)
//                    ans[i][j] += ((ans[i - 1][j - 1] + ans[i][j - 1]) % mod + ans[i + 1][j - 1]) % mod;
//        }
//        return ans[3][n];
//    }
//}


//public class Solution
//{
//
//    public static void main(String[] args)
//    {
//        System.out.println(Arrays.toString(new Solution().solve(4, 1, new int[]{1, 2, 2}, new int[]{2, 3, 4}, new int[]{3})));
//    }
//
//    ArrayList<Integer>[] node;
//    int depth[];
//    int child[];
//
//    public int[] solve(int n, int m, int[] u, int[] v, int[] x)
//    {
//        node = new ArrayList[n + 1];
//        depth = new int[n + 1];
//        child = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//            node[i] = new ArrayList<>();
//
//        for (int i = 0; i < n - 1; i++)
//        {
//            node[u[i]].add(v[i]);
//            node[v[i]].add(u[i]);
//        }
//
//        dfs(1, -1, 0);
//        int tot = 2 * (n - 1);
//        int ans[] = new int[m];
//        for (int i = 0; i < m; i++)
//            ans[i] = tot - 2 * child[x[i]] - depth[x[i]];
//
//        return ans;
//
//    }
//
//    int dfs(int u, int fa, int d)
//    {
//        depth[u] = d;
//        int cnt = 0;
//        for (int v : node[u])
//            if (v == fa)
//                continue;
//            else cnt += dfs(v, u, d + 1);
//        child[u] = cnt;
//        return cnt + 1;
//    }
//
//}


//public class Solution
//{
//    ArrayList<Integer>[] node;
//    int val[];
//    int ans, m;
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(3, 2, 3, new int[]{1, 1}, new int[]{2, 3}, new int[]{1, 3, 2}));
//    }
//
//    public boolean solve(int n, int k, int m, int[] u, int[] v, int[] x)
//    {
//        // write code here
//        node = new ArrayList[n + 1];
//        val = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//        {
//            val[i] = x[i - 1];
//            node[i] = new ArrayList<>();
//        }
//        this.m = m;
//        for (int i = 0; i < n - 1; i++)
//        {
//            node[u[i]].add(v[i]);
//            node[v[i]].add(u[i]);
//        }
//
//        dfs(1,-1);
//        return ans >= k;
//    }
//
//    int dfs(int u,int fa)
//    {
//        int val = this.val[u];
//        for (int v : node[u])
//            if (v == fa)
//                continue;
//            else val += dfs(v,u);
//
//        if (val >= m)
//        {
//            val = 0;
//            ans++;
//        }
//        return val;
//    }
//
//}


//public class Solution
//{
//    /**
//     * 又见台阶
//     *
//     * @param n int整型
//     * @param m int整型
//     * @param a int整型一维数组
//     * @return int整型
//     */
//    static int Mod = (int) (1e9 + 7);
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(9, 3, new int[]{1, 3, 5}));
//    }
//
//    public int solve(int n, int m, int[] a)
//    {
//        // write code here
//        int dp[] = new int[n + 1];
//        dp[0] = 1;
//        int cnt = 0;
//        int odd = 0, even = 1;
//        for (int i = 1; i <= n; i++)
//        {
//            if (cnt < m && i == a[cnt])
//            {
//                cnt++;
//                continue;
//            }
//
//            if ((i & 1) == 1)
//            {
//                dp[i] = (dp[i] + even) % Mod;
//                odd = (odd + dp[i]) % Mod;
//            } else
//            {
//                dp[i] = (dp[i] + odd) % Mod;
//                even = (even + dp[i]) % Mod;
//            }
//
//        }
//        return dp[n];
//    }
//}


//public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(2, 10, new int[][]{{1, 5}, {2, 4}}));
//    }
//
//    /**
//     * @param n int整型 ：牛币值种类数
//     * @param x int整型 ：牛妹拥有的钱数
//     * @param a int整型二维数组 ：第二个vector中的第一列表示币值，第二列表示牛牛拥有币值的个数
//     * @return int整型
//     */
//    public int solve(int n, int x, int[][] a)
//    {
//        // write code here
//        int dp[][] = new int[51][101];
//        int val[] = new int[101];
//        int w[] = new int[101];
//        for (int i = 1; i <= n; i++)
//        {
//            val[i] = a[i - 1][0];
//            w[i] = a[i - 1][1];
//        }
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; i++)
//            for (int j = 0; j <= x; j++)
//            {
//                if (dp[i - 1][j] != 0)
//                {
//                    for (int k = 0; k <= w[i] && j + k * val[i] <= x; k++)
//                        dp[i][j + k * val[i]] += dp[i - 1][j];
//                }
//            }
//        return dp[n][x];
//    }
//}


//public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(Arrays.toString(new Solution().continuousSet(new int[]
//                {2, 1, 0, 4, 1, 0, 3, 4, 0, 2})));
//    }
//
//    /**
//     * 检查数组的每个前缀是不是一个好的集合
//     *
//     * @param mSet int整型一维数组
//     * @return bool布尔型一维数组
//     */
//    public boolean[] continuousSet(int[] mSet)
//    {
//        // write code here
//        if (mSet.length == 0) return new boolean[mSet.length];
//        boolean ans[] = new boolean[mSet.length];
//        //        int vis[] = new int[mSet.length];
//        Map<Integer, Integer> vis = new HashMap<>();
//        vis.put(mSet[0], 1);
//        int min = mSet[0], max = mSet[0];
//        int cnt = 0;
//        ans[0] = true;
//        for (int i = 1; i < mSet.length; i++)
//        {
//            if (vis.get(mSet[i]) != null)
//                ans[i] = ans[i - 1];
//            else
//            {
//                cnt++;
//                min = Math.min(min, mSet[i]);
//                max = Math.max(max, mSet[i]);
//                if (max - min == cnt)
//                    ans[i] = true;
//                else ans[i] = false;
//            }
//            vis.put(mSet[i], 1);
//        }
//        return ans;
//    }
//}


//public class Solution
//{
//    /**
//     * k长连续子段和
//     *
//     * @param n int整型
//     * @param k int整型
//     * @param a int整型一维数组
//     * @return long长整型
//     */
//    public long solve(int n, int k, int[] a)
//    {
//        long sum[] = new long[n];
//        long dp[] = new long[n];
//        sum[0] = a[0];
//
//        for (int i = 1; i < n; i++)
//            sum[i] = sum[i - 1] + a[i];
//
//        dp[k - 1] = sum[k - 1];
//        long max = dp[k - 1];
//        for (int i = k; i < n; i++)
//        {
//            long tmp = sum[i] - sum[i - k];
//            dp[i] = Math.max(tmp, dp[i - 1] + a[i]);
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }
//}


//public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(2, 1, new int[]{-757147, -507978500}));
//    }
//
//    /**
//     * k长连续子段和
//     *
//     * @param n int整型
//     * @param k int整型
//     * @param a int整型一维数组
//     * @return long长整型
//     */
//    public long solve(int n, int k, int[] a)
//    {
//        // write code here
//        int sum[] = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//            sum[i] = sum[i - 1] + a[i - 1];
//        int ans = sum[k];
//        for (int i = k; i <= n; i++)
//            for (int j = 0; j <= i; j++)
//            {
//                if (i - j + 1 >= k && i != j)
//                    ans = Math.max(ans, sum[i] - sum[j]);
//            }
//
//        return ans;
//    }
//}

//public class Solution
//{
//    /**
//     * @param s string字符串
//     * @return int整型
//     */
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve("UR11645E64O45CACC1GR1560C303X1A24CDCBYLX1616D491I"));
//    }
//
//    public int solve(String s)
//    {
//        // write code here
//
//        int ans = Integer.MIN_VALUE;
//        int tmp = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++)
//        {
//            int tmp1 = chars[i] - '0';
//            int tmp2 = chars[i] - 'A';
//            if (tmp1 >= 0 && tmp1 <= 9)
//                tmp = tmp * 16 + tmp1;
//            else if (tmp2 <= 5 && tmp2 >= 0)
//                tmp = tmp * 16 + tmp2 + 10;
//            else
//            {
//                ans = Math.max(ans, tmp);
//                tmp = 0;
//            }
//        }
//        return ans;
//    }
//}


//public class Solution
//{
//    final int Mod = (int) (1e9 + 7);
//
//    /**
//     * 好多牛牛
//     *
//     * @param s string字符串
//     * @return int整型
//     */
//    public int solve(String s)
//    {
//        // write code here
//        int dp[] = new int[6];
//        String ans = "niuniu";
//        int len = s.length();
//        for (int i = 0; i < len; i++)
//        {
//            for (int j = 0; j < 6; j++)
//            {
//                if (ans.charAt(j) == s.charAt(i))
//                {
//                    if (j == 0)
//                        dp[j]++;
//                    else dp[j] += dp[j - 1];
//                    dp[j] %= Mod;
//                }
//            }
//        }
//
//        return dp[5];
//    }
//}


//public class Solution
//{
//
//    ArrayList<Integer>[] v;
//
//    boolean vis[];
//
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().solve(new int[]{7, 11}, new Point[]{
//                new Point(3, 2),
//                new Point(5, 1),
//                new Point(1, 6),
//                new Point(6, 4),
//                new Point(7, 2),
//                new Point(7, 4),
//                new Point(4, 2),
//                new Point(1, 3),
//                new Point(6, 3),
//                new Point(3, 7),
//                new Point(5, 6)
//        }));
//    }
//
//
//    /**
//     * 能回到1号点返回 Yes，否则返回 No
//     *
//     * @param param int整型一维数组 param[0] 为 n，param[1] 为 m
//     * @param edge  Point类一维数组 Point.x , Point.y 分别为一条边的两个点
//     * @return string字符串
//     */
//    public String solve(int[] param, Point[] edge)
//    {
//        int n = param[0];
//        int m = param[1];
//        v = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++)
//            v[i] = new ArrayList<>();
//        vis = new boolean[n + 1];
//
//        for (Point p : edge)
//        {
//            v[p.x].add(p.y);
//            v[p.y].add(p.x);
//        }
//
//        if (dfs(1, 1))
//            return "Yes";
//        else return "No";
//
//    }
//
//    boolean dfs(int u, int fa)
//    {
//        for (int i : v[u])
//        {
//            if (i == fa)
//                continue;
//            if (i == 1)
//                return true;
//            if (vis[i])
//                continue;
//            vis[i] = true;
//            if (dfs(i, u))
//                return true;
//        }
//        return false;
//    }
//
//}


class Point
{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}


//public class Solution
//{
//    /**
//     * @param n int整型
//     * @param a int整型一维数组
//     * @return int整型
//     */
//    public int work(int n, int[] a)
//    {
//        // write code here
//        int ans = n;
//        int tmp;
//        for (int i = 1; i < n; i++)
//        {
//            tmp = a[i] - a[i - 1];
//            if (tmp != 1 && !check(tmp))
//            {
//                if (tmp % 2 == 0 || check(tmp - 2))
//                    ans += 1;
//                else ans += 2;
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().work(7,new int[]{0,3,10,15,16,24,28}));
//    }
//
//    public boolean check(int n)
//    {
//        if (n == 1)
//            return false;
//        for (int i = 2; i * i <= n; i++)
//            if (n % i == 0)
//                return false;
//        return true;
//    }
//}


//public class Solution
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int nums[] = new int[n];
//        for (int i = 0; i < n; i++)
//            nums[i] = scanner.nextInt();
//        int max = nums[0], sum = 0;
//        for (int i = 0; i < n; i++)
//        {
//            sum += nums[i];
//            if (sum > max)
//                max = sum;
//            if (sum < 0)
//                sum = 0;
//        }
//        System.out.println(max);
//    }
//}


//public class Solution
//{
//    public boolean Find(int target, int[][] array)
//    {
//        int x = array[0].length;
//        int y = array.length;
//
//        int i = 0, j = x - 1;
//        while (j >= 0 && i < y)
//        {
//            int val = array[i][j];
//            if (val > target)
//                j--;
//            else if (val < target)
//                i++;
//            else return true;
//
//        }
//        return false;
//    }
//}


//public class Solution
//{
//    public String replaceSpace(StringBuffer str)
//    {
//        StringBuffer buffer = new StringBuffer();
//        if (str == null)
//            return null;
//
//        for (int i = 0; i < str.length(); i++)
//        {
//            if (str.charAt(i) == ' ')
//            {
//                buffer.append('%');
//                buffer.append('2');
//                buffer.append('0');
//            } else buffer.append(str.charAt(i));
//        }
//
//        return buffer.toString();
//    }
//}


//public class Solution
//{
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode)
//    {
//        ArrayList<Integer> list = new ArrayList<>();
//        while (listNode != null)
//        {
//            list.add(0, listNode.val);
//            listNode = listNode.next;
//        }
//        return list;
//    }
//}


//public class Solution
//{
//    public static void main(String[] args)
//    {
//        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        int[] ints = Arrays.copyOfRange(arr, 1, arr.length);
//        System.out.println(Arrays.toString(ints));
//    }
//    //    public TreeNode reConstructBinaryTree(int[] pre, int[] in)
//    //    {
//    //        if (pre.length == 0)
//    //            return null;
//    //
//    //        int val = pre[0];
//    //        TreeNode node = new TreeNode(val);
//    //        if (pre.length == 1)
//    //            return node;
//    //
//    //        int flag = 0;
//    //        for (int i = 0; i < in.length; i++)
//    //        {
//    //            if (val == in[i])
//    //            {
//    //                flag = i;
//    //                break;
//    //            }
//    //        }
//    //        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, flag + 1),
//    //                Arrays.copyOfRange(in, 0, flag));
//    //        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, flag + 1, pre.length),
//    //                Arrays.copyOfRange(in, flag + 1, in.length));
//    //        return node;
//    //    }
//}

//public class Solution
//{
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node)
//    {
//        stack1.push(node);
//    }
//
//    public int pop()
//    {
//        while (!stack1.isEmpty())
//            stack2.push(stack1.pop());
//
//        int ans = stack2.pop();
//        while (!stack2.isEmpty())
//            stack1.push(stack2.pop());
//        return ans;
//    }
//}

//public class Solution
//{
//    public int minNumberInRotateArray(int[] array)
//    {
//        if (array.length == 0)
//            return 0;
//
//        for (int i = 0; i < array.length - 1; i++)
//        {
//            if (array[i] > array[i + 1])
//                return array[i + 1];
//            if (i == array.length - 2)
//                return array[0];
//        }
//        return 0;
//    }
//}


//public class Solution
//{
//    public static int jumpFloor(int target)
//    {
//        if (target <= 0) return 0;
//        return (int) Math.pow(2, target - 1);
//    }
//}


//public class Solution
//{
//    public int NumberOf1(int n)
//    {
//        int cnt = 0;
//        while (n != 0)
//        {
//            cnt++;
//            n = n & (n - 1);
//        }
//        return cnt;
//    }
//}


//public class Solution
//{
//    public void reOrderArray(int[] array)
//    {
//        int len = array.length;
//        int cnt = 0;
//        for (int i = 0; i < len; i++)
//        {
//            if (array[i] % 2 == 1)
//            {
//                int j = i;
//                while (j > cnt)
//                {
//                    int tmp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = tmp;
//                    j--;
//                }
//                cnt++;
//            }
//        }
//    }
//}
//

//public class Solution
//{
//    public ListNode FindKthToTail(ListNode head, int k)
//    {
//        ListNode node = head;
//        int cnt = 0;
//        while (node != null)
//        {
//            cnt++;
//            node = node.next;
//        }
//        node = head;
//        for (int i = 0; i < cnt - k; i++)
//            node = node.next;
//        return node;
//
//    }
//}

//public class Solution
//{
//    public ListNode ReverseList(ListNode head)
//    {
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != null)
//        {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
//}

//public class Solution
//{
//    public ListNode Merge(ListNode list1, ListNode list2)
//    {
//        if (list1 == null)
//            return list2;
//        if (list2 == null)
//            return list1;
//
//        if (list1.val <= list2.val)
//        {
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        } else
//        {
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
//    }
//}


//public class Solution
//{
//    public boolean HasSubtree(TreeNode root1, TreeNode root2)
//    {
//        boolean flag = false;
//        if (root1 != null && root2 != null)
//        {
//            if (root1.val == root2.val)
//            {
//                flag = check(root1, root2);
//            }
//
//            if (!flag)
//                flag = check(root1.left, root2);
//            if (!flag)
//                flag = check(root1.right, root2);
//
//        }
//        return flag;
//    }
//
//    boolean check(TreeNode root, TreeNode tmp)
//    {
//        if (root == null && tmp != null)
//            return false;
//        if (tmp == null)
//            return true;
//        if (root.val != tmp.val)
//            return false;
//
//        return check(root.left, tmp.left) && check(root.right, tmp.right);
//    }
//}

//public class Solution
//{
//    public void Mirror(TreeNode root)
//    {
//        if (root == null)
//            return;
//        if (root.left == null && root.right == null)
//            return;
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        if (root.left != null)
//            Mirror(root.left);
//        if (root.right != null)
//            Mirror(root.right);
//    }
//}

//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
//    }
//
//    public ArrayList<Integer> printMatrix(int[][] matrix)
//    {
//        ArrayList<Integer> ans = new ArrayList<>();
//        if (matrix == null || matrix.length == 0)
//            return ans;
//
//        //1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
//        int ex = matrix[0].length - 1;
//        int ey = matrix.length - 1;
//        int sx = 0, sy = 0;
//        int cnt = 0;
//        while (cnt < matrix.length*matrix[0].length)
//        {
//            for (int i = sx; i <= ex; i++)
//            {
//                cnt++;
//                if(cnt== matrix.length*matrix[0].length)
//                    return ans;
//                ans.add(matrix[sy][i]);
//            }
//            sy++;
//            for (int i = sy; i <= ey; i++)
//            {
//                cnt++;
//                if(cnt== matrix.length*matrix[0].length)
//                    return ans;
//                ans.add(matrix[i][ex]);
//            }
//            ex--;
//            for (int i = ex; i >= sx; i--)
//            {
//                cnt++;
//                if(cnt== matrix.length*matrix[0].length)
//                    return ans;
//                ans.add(matrix[ey][i]);
//            }
//            ey--;
//            for (int i = ey; i >= sy; i--)
//            {
//                cnt++;
//                if(cnt== matrix.length*matrix[0].length)
//                    return ans;
//                ans.add(matrix[i][sx]);
//            }
//            sx++;
//        }
//        return ans;
//    }
//}


//public class Solution
//{
//
//    Stack<Integer> stack = new Stack<>();
//
//    public void push(int node)
//    {
//        stack.push(node);
//    }
//
//    public void pop()
//    {
//        stack.pop();
//    }
//
//    public int top()
//    {
//        return stack.peek();
//    }
//
//    public int min()
//    {
//        Integer[] array = (Integer[]) stack.toArray();
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < array.length; i++)
//            if (min > array[i])
//                min = array[i];
//            return min;
//    }
//}


//public class Solution
//{
//    public boolean IsPopOrder(int[] pushA, int[] popA)
//    {
//        int cnt = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < pushA.length; i++)
//        {
//            stack.push(pushA[i]);
//            while (!stack.isEmpty()&&stack.peek()==popA[cnt])
//            {
//                stack.pop();
//                cnt++;
//            }
//        }
//        return stack.isEmpty();
//    }
//}


//public class Solution
//{
//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
//    {
//        ArrayList<Integer> ans = new ArrayList<>();
//        if (root == null)
//            return ans;
//
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.add(root);
//        while (!deque.isEmpty())
//        {
//            TreeNode tmp = deque.pop();
//            ans.add(tmp.val);
//            if (tmp.left != null)
//                deque.add(tmp.left);
//            if (tmp.right != null)
//                deque.add(tmp.right);
//        }
//        return ans;
//    }
//}


//public class Solution
//{
//    public boolean VerifySquenceOfBST(int[] sequence)
//    {
//        return dfs(sequence,0,sequence.length);
//    }
//
//    boolean dfs(int arr[], int start, int end)
//    {
//        if (end <= start)
//            return true;
//        int index = start;
//        for (; index < end; index++)
//        {
//            if (arr[index] > arr[end])
//                break;
//        }
//        for (int i = index; i < end; i++)
//            if (arr[i] < arr[end])
//                return false;
//            return dfs(arr,start,index-1)&&dfs(arr,index,end-1);
//    }
//}


//public class Solution
//{
//    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//    ArrayList<Integer> res = new ArrayList<>();
//
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
//    {
//        if (root == null)
//            return ans;
//        res.add(root.val);
//        target -= root.val;
//        if (target == 0 && root.left == null && root.right == null)
//        {
//            ans.add(new ArrayList<>(res));
//        }
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        res.remove(res.size() - 1);
//        return ans;
//    }
//}

class RandomListNode
{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label)
    {
        this.label = label;
    }
}


//public class Solution
//{
//    TreeNode end = null;
//    TreeNode head = null;
//
//    public TreeNode Convert(TreeNode pRootOfTree)
//    {
//        dfs(pRootOfTree);
//        return head;
//    }
//
//    void dfs(TreeNode cur)
//    {
//        if (cur == null)
//            return;
//        dfs(cur.left);
//        if (end == null)
//        {
//            end = cur;
//            head = cur;
//        } else
//        {
//            end.right = cur;
//            cur.left = end;
//            end = cur;
//        }
//        dfs(cur.right);
//    }
//}


//public class Solution
//{
//    ArrayList<String> ans = new ArrayList<>();
//    int len;
//    int cnt[] = new int[255];
//    char[] res;
//
//    public ArrayList<String> Permutation(String str)
//    {
//        if(str.length()==0||str==null)
//            return ans;
//        len = str.length();
//        res = new char[len];
//        for (int i = 0; i < str.length(); i++)
//            cnt[str.charAt(i)]++;
//        dfs(0);
//        return ans;
//    }
//
//    public void dfs(int index)
//    {
//        if (index == len)
//        {
//            ans.add(String.valueOf(res));
//            return;
//        }
//
//        for (int i = 'A'; i <= 'z'; i++)
//        {
//            if (cnt[i] > 0)
//            {
//                cnt[i]--;
//                res[index] = (char) i;
//                dfs(index + 1);
//                cnt[i]++;
//            }
//        }
//    }
//}


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


//public class Solution
//{
//    ArrayList<String> ans = new ArrayList<>();
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().Permutation("112"));
//    }
//    public ArrayList<String> Permutation(String str)
//    {
//        char[] chars = str.toCharArray();
//        if (str == null || str.length() == 0)
//            return ans;
//
//        dfs(chars, 0);
//        return ans;
//    }
//
//    public void dfs(char[] chars, int index)
//    {
//        if (index == chars.length - 1)
//        {
//            ans.add(String.valueOf(chars));
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++)
//        {
//            if(chars[i]!=chars[index])
//            {
//                swap(chars, index, i);
//                dfs(chars, index + 1);
//                swap(chars, index, i);
//            }
//        }
//    }
//
//    void swap(char[] tmp, int a, int b)
//    {
//        char t = tmp[a];
//        tmp[a] = tmp[b];
//        tmp[b] = t;
//    }
//}


//public class Solution
//{
//    ArrayList<String> ans = new ArrayList<>();
//    char[] tmp;
//    boolean[] flag;
//
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().Permutation("123"));
//    }
//
//    public ArrayList<String> Permutation(String str)
//    {
//        if (str == null || str.length() == 0)
//            return ans;
//        char[] chars = str.toCharArray();
//        flag = new boolean[chars.length];
//        tmp = new char[chars.length];
//        dfs(chars, 0);
//        return ans;
//    }
//
//    public void dfs(char[] chars, int index)
//    {
//        if (index > chars.length)
//            return;
//        if (index == chars.length)
//        {
//            ans.add(String.valueOf(tmp));
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++)
//        {
//            if (!flag[i])
//            {
//                tmp[index] = chars[i];
//                flag[i] = true;
//                dfs(chars, index + 1);
//                flag[i] = false;
//            }
//        }
//    }
//}

//public class Solution
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new Solution().FindGreatestSumOfSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
//    }
//
//    public int FindGreatestSumOfSubArray(int[] array)
//    {
//        int ans = array[0], tmp = array[0];
//        for (int i = 1; i < array.length; i++)
//        {
//            tmp = Math.max(tmp + array[i], array[i]);
//            ans = Math.max(tmp, ans);
//        }
//        return ans;
//    }
//
//}


//public class Solution
//{
//    public int NumberOf1Between1AndN_Solution(int n)
//    {
//        int ans = 0;
//        int i = 1;
//        int cur = 0, before = 0, after = 0;
//        while (n / i != 0)
//        {
//            cur = (n / i) % 10;
//            before = n / (i * 10);
//            after = n - (n / i) * i;
//
//            if (cur == 0)
//                ans += before * i;
//            else if (cur == 1)
//                ans += before * i + after + 1;
//            else ans += (before + 1) * i;
//            i*=10;
//        }
//        return ans;
//    }
//}

//public class Solution
//{
//    public static void main(String[] args)
//    {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(5);
//        list.add(4);
//        list.add(1);
//        Collections.sort(list, (i1, i2) -> {
//            return i1.compareTo(i2);
//        });
//        System.out.println(list);
//    }
//
//    public String PrintMinNumber(int[] numbers)
//    {
//        String ans = "";
//        ArrayList<Integer> list = new ArrayList<>();
//        int len = numbers.length;
//        System.out.println(len);
//        for (int i = 0; i < len; i++)
//            list.add(numbers[i]);
//
//        Collections.sort(list, (o1, o2) -> {
//            String s1 = o1 + "" + o2;
//            String s2 = o2 + "" + o1;
//            return s1.compareTo(s2);
//        });
//        for (int i : list)
//            ans += i;
//
//        return ans;
//    }
//}


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
