package zzm.java.leetcode.practise1800;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个由正整数组成的数组 nums 。
 *
 * 数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数
 *
 * nums = [6,10,3]
 * 输出：5
 */
public class Practise1819 {

    public static void main(String [] args){
        Practise1819 practise1819 = new Practise1819();
        int []nums = {42619,154452,114094,128588,167625,36742,194311,16547,8135,146323,183302,139976,125640,149694,157212,141177,34723,62594,11675,141041,79054,108539,179251,149973,121438,67412,149345,91410,144732,87323,135319,95800,148593,8890,47214,111995,58361,130177,165617,97358,172424,66343,190279,194690,198182,63742,17320,161731,68056,76723,134655,8863,76961,125347,126285,185239,42893,24250,176444,153891,139047,143497,52194,13135,149871,152403,137071,88963,74965,17318,145566,158158,59202,155200,171942,44450,38094,178480,188483,113568,165448,160552,82300,165999,185954,52355,158805,121898,174837,48520,231,53009,13282,4597,20048,101405,94775,114577,49201,42269,1289,111645,8294,64460,16261,102994,29511,96889,98120,144864,157513,35036,99825,137196,167440,24639,195214,83456,128446,165700,1008,122601,61592,105825,147243,20968,113514,157631,154620,98565,4996,90233,134914,76866,60759,104433,130141,105962,96790,13063,16178,106867,158875,112288,153966,41209,181090,38030,86667,49978,36970,128926,108351,82194,197657,1562,95817,97684,95039,191270,20998,197099,100608,34544,187455,169132,9501,37094,12951,192122,80932,69339,87280,10633,20756,33462,35992,62897,83232,55261,197751,41275,116371,52195,107094,97640,34519,81571,155608,48070,120623,6469,150501,46722,192315,164352,31939,8293,195803,36932,108592,172949,76513,134471,197800,55719,14927,18572,158008,137473,134642,141578,186046,111184,191998,70392,181512,123218,146531,115607,122046,169538,151938,162360,21374,148111,89934,27873,78654,60096,11667,62277,30402,53893,46956,172007,197245,103001,197482,106217,165941,33763,148037,60585,147362,168333,54175,127883,180900,154049,168330,40195,179789,194286,164709,198538,30573,100443,116636,94098,176002,5501,157817,126200,167113,127915,15364,65336,159917,74429,45464,132781,159627,122914,17884,196388,83346,22679,68429,182685,136336,79165,176662,33991,142771,167326,15560,82683,20762,38623,131075,183507,34150,45261,174340,6417,161496,140261,177,16071,18121,197926,141495,94646,125115,12589,179859,137566,169840,176296,139939,20309,120483,119130,148594,176384,4629,72244,93296,117606,21067,91006,16876,45842,46428,198439,150351,1143,151267,103460,50764,149221,175566,58703,40516,127545,32174,91199,137257,176405,128647,156414,26997,188663,163259,141640,178299,46352,131101,80961,25509,78634,23159,162742,30544,149802,84479,140887,115700,150960,193882,152296,75606,115280,75650,198420,132723,115136,139640,121018,154515,39184,79675,152666,70665,20318,174907,75008,8888,148941,103876,187866,34087,128352,152810,171469,191437,188015,84792,174702,68781,31858,151481,75870,114232,58136,63956,102383,141696,153126,19117,105436,176736,33132,66531,11053,178774,66469,61640,88840,21127,67753,99989,27355,34460,63370,127441,84949,121189,106645,21300,133660,152639,122801,9426,113897,52093,103301,148296,149639,178356,68282,161655,161855,198439,33556,34940,99004,14490,4696,168529,14061,115546,1024,90691,135004,116767,85615,48668,183106,174483,54803,190254,115539,163200,56165,173393,52461,102038,87026,185726,116096,73131,71922,42353,78702,175631,22900,162917,159331,143429,18435,138704,162088,125716,149636,155558,142691,63884,25063,130981,31469,117947,132552,142860,43765,29573,182781,169166,85123,136782,187341,98923,152515,58775,136556,25121,118157,59930,29346,22892,124828,66001,151048,134805,79277,5207,87483,158456,178606,100752,63979,113053,40036,131486,148345,117637,17804,124723,67245,107347,193549,141681,151263,145713,17807,184637,32050,100728,31057,70101,99148,8426,24127,142681,90228,19584,102769,176908,123174,125647,195654,175747,168962,168125,41194,104894,11124,68532,104441,177033,102724,101027,118627,4082,187051,177388,63630,140900,34272,19205,130783,105937,54926,28122,180698,188000,121081,51487,105971,166430,106489,113947,6739,73594,5741,11427,127502,194092,109691,34283,156115,46165,194956,49558,132221,98638,74414,20765,143600,11078,108321,186314,38316,122418,41678,77882,10411,170416,78829,153397,76728,8221,161100,137221,85837,77054,8352,127816,22754,42847,194060,165942,177637,197224,156108,100480,184170,165204,129251,69184,117747,5890,110092,9165,77328,12880,90970,52291,89729,47419,64174,36251,23864,10666,24722,40512,80549,82828,129233,155304,150369,157053,124263,5625,100930,151429,142608,99441,61481,192868,137730,37312,144200,27412,109361,145004,101124,58655,146016,2213,156284,149810,147414,82908,107500,101825,146286,164975,174585,57272,34784,114591,46306,28673,148833,29527,189162,78084,46028,92218,123865,130439,138119,42073,154155,70073,167742,183612,62887,69212,18485,187868,133491,85305,64173,171799,159920,145799,57550,68877,42329,166961,34365,14890,121322,93484,33811,162052,65151,79818,192978,10868,111244,117099,129175,195688,13912,45501,146868,99153,174897,178428,130649,171424,189571,81936,80442,72931,41507,93770,175038,139064,195467,191076};
        System.out.println(practise1819.countDifferentSubsequenceGCDs(nums));
    }


    /**
     * 可以简化为判断k,是否是该序列中的一个最大公约数
     * 找出所有的k的倍数的值，n1k ,n2k,n3k, n4k,n5k
     * 如果有n1k,n3k的最大公约数为k，那么该序列的最大公约数也为k
     * 这样就可以先求n1和n2的最大公约数x,x在于n3的最大公约数即为1
     * @param nums
     * @return
     */
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        int result = 0;
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i<nums.length;i++){
            max = Math.max(max, nums[i]);
            hashSet.add(nums[i]);
        }
        for(int i = 1 ;i <= max;i++){
            if(isRight2(max,i,hashSet)){
                System.out.print(i+"  ");
                result++;
            }
        }
        System.out.println("");
        return result;
    }

    public boolean isRight2(int max, int temp,Set<Integer> hashSet){
        int gcd = 0;
        for(int i =  temp;i<=max;i = i+temp){
            if(!hashSet.contains(i)){
                continue;
            }
            if(gcd == 0) {
                gcd = i;
            }else{
                gcd = gcd(gcd,i);
            }
        }
        return gcd == temp;
    }

    public boolean isRight(int temp ,int [] nums,Set<Integer> hashSet){
        int gcd = 0;
        if(hashSet.contains(temp)){
            return true;
        }
        for(int i = 0; i < nums.length;i++){
            if(nums[i]%temp == 0){
                if(gcd == 0) {
                    gcd = nums[i];
                }else{
                    gcd = gcd(gcd,nums[i]);
                }

                if(gcd == temp){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 最大公约数算法
     * 采用辗转相除法
     * 例如求a,b两数最大公约数，那么有a = kb+c;
     * 令a,b最大公约数为x,这b%x = 0, a%x = (kb+c)%x = 0
     * 则c%x = 0,
     * 求a,b的最大公约数，就是求a,c的最大公约数
     * 换成算法，如下：
     * 迭代算法：a,b 转换成b,c ====> b, a%b
     * 终点： a % b  = 0
     * @param a 大
     * @param b 小
     * @return
     */
    int gcd(int a,int b){
        if(a % b == 0){
            return b;
        }
        //此时a % b移到比 b 小，所以要这样放
        return gcd (b ,a % b);
    }

}
