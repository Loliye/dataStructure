import java.util.*;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] s = string.split(" ");
        for (int i = s.length - 1; i >= 0; i--)
        {
            System.out.print(s[i] + " ");
        }
    }
}

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
