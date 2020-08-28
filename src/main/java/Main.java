import java.util.*;


public class Main
{

    public static void main(String[] args)
    {

        //        System.out.println(7^1);

        //        System.out.println(7^1^1);
        //        int arr[]={1,5,6,3,2};int x=4;
        //
        //        int pos=0;
        //        for(int i=0;i<arr.length;i++)
        //        {
        //            if(arr[i]<x)
        //            {
        //                swap(arr,i, pos);
        //                pos++;
        //            }
        //        }
        //
        //        for(int i:arr)
        //            System.out.print(i+" ");
        int arr[] = new Main().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (int i : arr)
        {
            System.out.print(i + " ");
        }

    }

    public int[] spiralOrder(int[][] matrix)
    {
        int nl = matrix.length, ml = matrix[0].length;
        int cnt = 0, n = 0, m = 0, sum = nl * ml;
        int ans[] = new int[nl * ml];
        if (sum == 0) return ans;
        while (true)
        {
            for (int i = m; i < ml; i++)
                ans[cnt++] = matrix[n][i];
            n++;
            if (cnt == sum) return ans;
            for (int i = n; i < nl; i++)
                ans[cnt++] = matrix[i][ml - 1];
            ml--;
            if (cnt == sum) return ans;
            for (int i = ml - 1; i >= m; i--)
                ans[cnt++] = matrix[nl - 1][i];
            nl--;
            if (cnt == sum) return ans;
            for (int i = nl - 1; i >= n; i--)
                ans[cnt++] = matrix[i][m];
            m++;
            if (cnt == sum) return ans;
        }
    }

    //    public static void swap(int arr[],int a,int b)
    //    {
    //        int tmp=arr[a];
    //        arr[a]=arr[b];
    //        arr[b]=tmp;
    //    }

    //    public static void main(String[] args)
    //    {
    //        Scanner scanner = new Scanner(System.in);
    //        int a = scanner.nextInt();
    //        int ans = 0;
    //        int cnt[] = new int[11];
    //        while (a > 0)
    //        {
    //            int tmp = a % 10;
    //            a /= 10;
    //            if (cnt[tmp] > 0)
    //                continue;
    //            cnt[tmp]++;
    //            ans+=tmp;
    //            ans*=10;
    //        }
    //        System.out.println(ans/10);
    //    }
}
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        a = a.substring(1, a.length() - 1);
//        b = b.substring(1, b.length() - 1);
//        int ans = Integer.parseInt(a) + Integer.parseInt(b);
//        System.out.println("\"" + ans + "\"");
//    }
//}


//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sum[] = new int[n + 2];
//        int dp[][] = new int[n + 2][n + 1];
//        int a[] = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//        {
//            a[i] = scanner.nextInt();
//            sum[i] = sum[i - 1] + a[i];
//        }
//
//        for (int i = 2; i <= n; i++)
//        {
//            for (int s = 1; s <= n - i + 1; s++)
//            {
//                int e = s + i - 1;
//                dp[s][e] = Integer.MAX_VALUE;
//                for (int k = s; k < e; k++)
//                {
//
//                    int tmp = sum[e] - sum[s - 1];
//                    dp[s][e] = Integer.min(dp[s][e], dp[s][k] + dp[k + 1][e] + tmp);
//                }
//            }
//        }
//        System.out.println(dp[1][n]);
//
//    }
//}

//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        int len = string.length();
//        int dp[][] = new int[len + 1][len + 1];
//        int ans = 0;
//        for (int i = len - 1; i >= 0; i--)
//        {
//            for (int j = i; j < len; j++)
//            {
//                boolean b = string.charAt(i) == string.charAt(j);
//                if (i == j)
//                    dp[i][j] = 1;
//
//                else if (j - i == 1)
//                {
//                    if (b)
//                        dp[i][j] = 1;
//                    else dp[i][j] = 0;
//                } else
//                {
//                    if (dp[i + 1][j - 1] == 1 && b)
//                        dp[i][j] = 1;
//                    else dp[i][j] = 0;
//                }
//
//                if (dp[i][j] == 1)
//                    ans++;
//            }
//        }
//
//        System.out.println(ans);
//    }
//}

//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        a = a.substring(1, a.length() - 1);
//        b = b.substring(1, b.length() - 1);
//        int ans = Integer.parseInt(a) + Integer.parseInt(b);
//        System.out.println("\"" + ans + "\"");
//    }
//}


//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        String[] s = string.split(" ");
//        for (int i = s.length - 1; i >= 0; i--)
//        {
//            System.out.print(s[i] + " ");
//        }
//    }
//}

//public class Main
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner=new Scanner(System.in);
//        String str1=scanner.nextLine();
//        String str2=scanner.nextLine();
//        List<String> list = insert(str1.split(" "),str2.split(" "));
//        for (int i = 0; i < list.size(); i++)
//        {
//            System.out.print(list.get(i)+" ");
//        }
//    }
//
//    public static List<String> insert(String[] s1,String[] s2)
//    {
//        List<String> list=new ArrayList<>();
//        int len=0;
//        int mod=0;
//        for (int i = 0; i < s1.length; i++)
//        {
//            list.add(s1[i]);
//            mod++;
//            if(mod==4&&len<s2.length)
//            {
//                mod = 0;
//                list.add(s2[len]);
//                len++;
//            }
//        }
//        while(len<s2.length)
//        {
//            list.add(s2[len++]);
//        }
//        return list;
//    }
//}

//public class Main
//{
//    public static void main(String[] args)
//    {
//        int n;
//        Scanner scanner=new Scanner(System.in);
//        n=scanner.nextInt();
//        for(int i=0;i<n;i++)
//        {
//            String a,b;
//            a=scanner.next();b=scanner.next();
//            String[] split = a.split("\\.");
//            String[] split1 = b.split("\\.");
//            System.out.println(Arrays.asList(split ));
//            System.out.println(Arrays.asList(split1));
//        }
//    }
//}

//public class Main
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < stringBuilder.length(); )
//        {
//            if (stringBuilder.charAt(i) == '(')
//            {
//                list.add(i);
//                i++;
//            } else if (stringBuilder.charAt(i) == '<' && list.size() == 0)
//            {
//                stringBuilder.delete(i - 1, i + 1);
//                i -= 1;
//            } else if (stringBuilder.charAt(i) == ')')
//            {
//                stringBuilder.delete(list.get(list.size() - 1), i + 1);
//                i = list.get(list.size() - 1);
//                list.remove(list.size() - 1);
//            }
//            else i++;
//        }
//
//        System.out.println(stringBuilder.toString());
//    }
//
//}

/*
public class Main
{

    public static void main(String[] args)
    {
        new Main().sln();
    }

    private void sln()
    {
        Scanner sc = new Scanner(System.in);
        int[] state = new int[9], helpArr = new int[9];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 13; i++)
        {
            int num = sc.nextInt();
            state[num - 1]++;
        }
        for (int i = 0; i < 9; i++)
        {
            if (state[i] < 4)
            {
                int num = i + 1;
                System.arraycopy(state, 0, helpArr, 0, 9);
                helpArr[i]++;
                if (canHu(helpArr, 14, false)) res.add(num);
            }
        }
        if (res.isEmpty()) System.out.println(0);
        else
        {
            StringBuffer sbf = new StringBuffer();
            sbf.append(res.get(0));
            for (int i = 1; i < res.size(); i++)
            {
                sbf.append(" ");
                sbf.append(res.get(i));
            }
            System.out.println(sbf.toString());
        }
    }

    private boolean canHu(int[] arr, int total, boolean hasHead)
    {
        if (total == 0) return true;
        if (!hasHead)
        {
            for (int i = 0; i < 9; i++)
            {
                if (arr[i] >= 2)
                {
                    arr[i] -= 2;
                    if (canHu(arr, total - 2, true)) return true;
                    arr[i] += 2;
                }
            }
            return false;
        } else
        {
            for (int i = 0; i < 9; i++)
            {
                if (arr[i] > 0)
                {
                    if (arr[i] >= 3)
                    {
                        arr[i] -= 3;
                        if (canHu(arr, total - 3, true)) return true;
                        arr[i] += 3;
                    }
                    if (i + 2 < 9 && arr[i + 1] > 0 && arr[i + 2] > 0)
                    {
                        arr[i]--;
                        arr[i + 1]--;
                        arr[i + 2]--;
                        if (canHu(arr, total - 3, true)) return true;
                        arr[i]++;
                        arr[i + 1]++;
                        arr[i + 2]++;
                    }
                }
            }
        }
        return false;
    }
}
*/
