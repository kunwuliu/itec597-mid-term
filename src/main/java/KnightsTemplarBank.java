import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightsTemplarBank {

    /**
     * 返回圣殿骑士团银行职员可有的兑换方法总数以及
     * 最少使用多少枚不同面值钱币即可完成兑换
     *
     * @param amount  钱币数额
     * @param options 可以使用的面值，最小值未必是1，无特定排列顺序
     */
    public int[] resolve(int amount, int[] options) {
        int[] result ={-1, -1};
        int[] f = new int[amount + 1];
        int[] n = new int[amount + 1];
        f[0] = 0;
        n[0] = 1;
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            int count = 0;
            for (int j = 0; j < options.length; j++) {
                if (i - options[j] >= 0) {
                    cost = min(f[i-options[j]] + 1, cost);
                    count += n[i-options[j]];
                }
            }
            f[i] = cost;
            n[i] = count;
            System.out.println("f[" + i + "]=" + cost );
            System.out.println(count);
        }
        result[1] = f[amount];
        return result;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        //long a=System.currentTimeMillis();

        KnightsTemplarBank bank = new KnightsTemplarBank();
        //int amount = 10000;
        int amount = 5;
        int[] options = {1, 2, 5, 10, 25};
        System.out.println(Arrays.toString(bank.resolve(amount, options)));

        //System.out.println((System.currentTimeMillis()-a)/1000f+ "秒");
    }

}
