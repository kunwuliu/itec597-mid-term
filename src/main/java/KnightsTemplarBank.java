import java.util.Arrays;

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
        if (amount > 0) {
            for (int i = 0; i < options.length; i++) {
                for (int j = options[i]; j <= amount; j++) {
                    if (j - options[i] >= 0) {
                        n[j] += n[j - options[i]];
                    }
                }
            }
//            System.out.println(n[amount]);
            result[0] = n[amount];
            for (int i = 1; i <= amount; i++) {
                int cost = amount;
                for (int j = 0; j < options.length; j++) {
                    if (i - options[j] >= 0) {
                        cost = min(f[i-options[j]] + 1, cost);
                    }
                }
                f[i] = cost;
//                System.out.println("f[" + i + "]=" + cost );
            }
            result[1] = f[amount];

        }
        //无法完成组合
        if (result[0] == 0) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
//        long a=System.currentTimeMillis();

        KnightsTemplarBank bank = new KnightsTemplarBank();
        //int amount = 10000;
        int amount = 6249;
        int[] options = {186, 419, 83, 408};
        System.out.println(Arrays.toString(bank.resolve(amount, options)));

//        System.out.println((System.currentTimeMillis()-a)/1000f+ "秒");
    }

}
