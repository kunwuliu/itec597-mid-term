

public class MissionTrip {

    /**
     * 计算从起点到终点所有的可能走法总数
     *
     * @param paths 旅途，当某处值为1时不允许走过，为0时可以正常走过
     */
    private int count; //所有可能的走法总数
    private int[][] paths; //地图
    private int[][] status; //标记当前结点是否已经被访问

    public MissionTrip() {
        count = 0;
    }


    public int resolve(int[][] paths) {
        this.paths = paths;
        int n = paths.length;
        int m = paths[0].length;
        status = new int[n][m];
        calculate(0, 0);
        return count;
    }

    private void calculate(int i, int j) {
        status[i][j] = 1; //访问该结点
        if (i >= 1 && status[i - 1][j] != 1 && paths[i - 1][j] == 0) {
            calculate(i - 1, j);
        }
        if (i < paths.length - 1 && status[i + 1][j] != 1 && paths[i + 1][j] == 0) {
            calculate(i + 1, j);
        }
        if (j >= 1 && status[i][j - 1] != 1 && paths[i][j - 1] == 0) {
            calculate(i, j - 1);
        }
        if (j < paths[0].length - 1 && status[i][j + 1] != 1 && paths[i][j + 1] == 0) {
            calculate(i, j + 1);
        }
        status[i][j] = 0;
        if (i == paths.length - 1 && j == paths[0].length - 1) count++;
    }

    public static void main(String[] args) {
        long a=System.currentTimeMillis();

        MissionTrip missionTrip = new MissionTrip();
        int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(missionTrip.resolve(map));
        System.out.println((System.currentTimeMillis()-a)/1000f+ "秒");
    }


}
