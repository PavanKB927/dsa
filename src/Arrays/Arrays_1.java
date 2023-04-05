package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

//June 8th 2022
public class Arrays_1 {
    public static void main(String[] args) {
        // contiguousMaxSum(new int[]{1,2,-5,4,6,-1,4,-1});
        //smallestPositiveNumber(new int[]{1,2,3,6,4,5});
        //maxArr(new int[]{55, -8, 43, 52, 8, 59, -91, -79, -18, -94});
        //plusOne(new int[]{9,9,9,9});
        //closestMinMax(new int[]{48, 774, 281, 796, 786, 411, 553, 804, 361, 85, 509, 144, 712, 982, 682, 155, 806, 521, 43, 431, 944, 280, 273, 458, 267, 63, 767, 371, 844, 848, 277, 892, 974, 559, 688, 761, 322, 593, 917, 35, 678, 426, 179, 742, 409, 861, 249, 215, 735, 293, 999, 679, 925, 272, 137, 192, 335, 256, 915, 179, 456, 193, 423, 430, 104, 463, 543, 778, 56, 461, 813, 86, 887, 992, 828, 648, 206, 430, 216, 941, 75, 215, 972, 0, 487, 461, 192, 174, 69, 460, 705, 525, 5, 480, 955, 109, 943, 499, 239, 999, 312, 52, 437, 199, 396, 265, 200, 602, 47, 416, 895, 122, 631, 867, 122, 470, 328, 667, 996, 397, 127, 53, 922, 132, 533, 230, 593, 476, 729, 184, 827, 41, 236, 264, 592, 632, 881, 792, 587, 929, 560, 482, 403, 191, 350, 526, 13, 30, 193, 9, 428, 672, 414, 702, 156, 947, 932, 101, 775, 13, 285, 954, 406, 521, 570, 999, 505, 452, 143, 444, 733, 56, 927, 488, 599, 629, 14, 613, 11, 559, 974, 439, 231, 389, 142, 739, 688, 426, 840, 816, 440, 125, 122, 846, 998, 693, 197, 504, 497, 693, 948, 582, 749, 227, 70, 348, 208, 85, 961, 220, 996, 288, 11, 228, 29, 505, 967, 69, 932, 160, 885, 724, 285, 8, 570, 284, 53, 768, 140, 550, 461, 440, 132, 210, 668, 202, 910, 228, 639, 224, 800, 636, 512, 812, 216, 893, 317, 535, 962, 601, 695, 200, 325, 981, 560, 896, 265, 613, 16, 757, 163, 829, 197, 647, 391, 217, 849, 301, 446, 489, 525, 246, 125, 389, 410, 341, 282, 728, 876, 597, 681, 924, 797, 7, 905, 709, 255, 522, 322, 623, 279, 837, 452, 476, 484, 843, 46, 685, 496, 492, 526, 374, 90, 651, 763, 501, 344, 398, 581, 573, 995, 262, 497, 144, 621, 754, 853, 228, 276, 527, 851, 907, 364, 655, 735, 200, 850, 781, 885, 347, 625, 412, 73, 716, 415, 836, 217, 112, 586, 798, 37, 933, 412, 886, 429, 34, 640, 282, 262, 268, 161, 466, 175, 877, 473, 910, 77, 324, 44, 315, 23, 669, 79, 96, 385, 846, 284, 602, 310, 223, 752, 347, 156, 165, 233, 938, 551, 873, 572, 813, 141, 734, 631, 668, 611, 105, 931, 41, 781, 975, 708, 156, 996, 139, 604, 382, 985, 240, 336, 648, 463, 441, 995, 972, 606, 229, 910, 157, 454, 482, 322, 948, 568, 306, 968, 180, 763, 899, 573, 896, 226, 633, 52, 223, 772, 656, 957, 109, 896, 645, 757, 712, 86, 105, 36, 44, 686, 946, 201, 140, 780, 876, 440, 349, 534, 409, 529, 297, 308, 454, 193, 887, 87, 597, 110, 211, 605, 67, 672, 853, 712, 430, 565, 151, 535, 601, 195, 221, 899, 749, 713, 680, 977, 154, 29, 511, 915, 910, 160, 575, 364, 353, 462, 803, 302, 572, 366, 907, 991, 38, 760, 56, 820, 326, 207, 707, 279, 402, 928, 179, 503, 994, 859, 480, 500, 888, 991, 415, 150, 151, 990, 866, 856, 805, 669, 158, 377, 387, 65, 721, 425, 826, 777, 246, 504, 336, 953, 783, 738, 234, 314, 242, 580, 173, 74, 80, 413, 66, 847, 563, 569, 189, 429, 426, 994, 450, 936, 724, 189, 2, 445, 615, 180, 574, 213, 684, 910, 518, 819, 0, 104, 134, 594, 684, 659, 669, 116, 73, 87, 315, 988, 656, 505, 770, 82, 851, 572, 19, 927, 762, 373, 724, 729, 553, 298, 942, 589, 560, 460, 408, 561, 565, 894, 507, 601, 554, 176, 718, 979, 263, 33, 319, 920, 890, 89, 354, 94, 14, 725, 21, 776, 450, 98, 857, 3, 748, 799, 944, 309, 611, 353, 222, 528, 599, 729, 130, 153, 258, 200, 132, 521, 585, 452, 793, 476, 893, 500, 922, 907, 577, 295, 35, 28, 393, 892, 383, 142, 43, 328, 803, 7, 33, 25, 535, 632, 106, 17, 786, 364, 217, 270, 238, 803, 722, 31, 631, 968, 883, 553, 875, 461, 200, 263, 489, 594, 507, 872, 88, 903, 552, 891, 910, 585, 268, 797, 218, 374, 815, 356, 91, 384, 626, 329, 539, 349, 712, 522, 669, 596, 427, 896, 57, 628, 159, 898, 222, 667, 122, 662, 570, 675, 905, 832, 260, 173, 629, 830, 899, 444, 186, 990, 181, 813, 671, 720, 514, 384, 243, 183, 980, 22, 79, 389, 650, 239, 287, 224, 258, 409, 886, 180, 84, 791, 364, 697, 316, 993, 527, 216, 790, 714, 558, 971, 527, 230, 43, 393, 614, 638, 576, 946, 661, 7, 335, 311, 598, 622, 536, 208, 383, 774, 388, 820, 566, 104, 517, 882, 98, 396, 450, 240, 462, 361, 563, 341, 591, 606, 734, 557, 597, 662, 503, 258, 670, 190, 921, 268, 164, 809, 477, 547, 936, 217, 367, 502, 322, 236, 736, 772, 985, 539, 12, 447, 900, 575, 789, 491, 533, 523, 400, 482, 186, 255, 92, 856, 445, 14, 476, 609, 175, 953, 156, 111, 523, 876, 965, 197, 464, 54, 969, 449, 593, 333, 897, 493, 260, 686, 336, 793, 561, 88, 276, 99, 343, 720, 307, 788, 86, 784, 397, 262, 89, 905, 725, 612, 133, 691, 809, 598, 97, 778, 399, 690, 463, 296, 535, 723, 334, 223, 869, 248, 311, 497, 347, 6, 217, 655, 794, 304, 439, 543, 566, 528, 800, 643, 493, 286, 334, 302, 236, 431, 433, 635, 473, 896, 284, 360, 972, 618, 583, 841, 866, 246, 338, 214, 252, 555, 221, 398, 859, 660, 293, 777, 540, 446, 421, 33, 732, 107, 688, 968, 891, 473, 603, 364, 721, 887, 725, 693, 858, 660, 534, 76, 907, 872, 642, 511, 780, 863, 262, 991, 523, 555, 121, 64, 353, 542, 449, 85, 1, 137, 405, 892, 962, 9, 609, 684, 248, 686, 377, 458, 698, 264, 535, 605, 488, 177, 469, 268, 41, 731, 260, 564, 638, 381, 980, 992, 275, 782, 77, 628, 271, 483, 521, 234, 844, 482, 918, 444, 520, 647, 903, 218, 911, 438, 824, 400, 967, 645, 20, 8, 376, 632, 925, 14, 365, 257, 358, 640, 39, 436, 269, 663, 271, 142, 897, 467, 976, 167, 911, 496, 166, 166, 714, 78, 604, 890, 830, 572, 535, 850, 932, 263, 483, 857, 630, 848, 115, 988, 489, 506, 776, 110, 521, 399, 604, 770, 866, 580, 937, 130, 428, 104, 296, 494, 534, 253, 385, 364, 177, 272, 214, 109, 888, 697, 319, 870, 546, 786, 210, 387, 644, 987, 849, 166, 738, 453, 936, 957, 385, 226, 87, 165, 330, 735, 659, 216, 340, 44, 580, 869, 669, 146, 331, 557, 844, 650, 779, 742, 788, 989, 129, 432, 976, 330, 598, 67, 135, 887, 24, 520, 113, 463, 37, 795, 550, 696, 11, 891, 93, 943, 112, 114, 89, 443, 23, 285, 93, 802, 27, 233, 791, 508, 666, 120, 190, 616, 187, 325, 503, 563, 197, 968, 26, 234, 763, 928, 931, 126, 819, 376, 69, 932, 490, 511, 727, 513, 796, 173, 315, 176, 406, 106, 36, 72, 578, 227, 689, 765, 552, 544, 328, 750, 513, 706, 984, 628, 635, 267, 755, 806, 995, 176, 90, 485, 687, 818, 998, 836, 991, 665, 364, 397, 124, 400, 822, 702, 979, 863, 820, 532, 407, 500, 634, 272, 207, 970, 901, 194, 590, 656, 0, 585, 832, 91, 71, 872, 261, 421, 708, 604, 439, 72, 1, 563, 824, 823, 617, 804, 38, 437, 688, 446, 938, 322, 70, 497, 292, 971, 691, 882, 979, 691, 820, 164, 134, 891, 36, 747, 664, 96, 351, 103, 520, 353, 18, 344, 528, 636, 500, 567, 425, 188, 365, 363, 510, 435, 860, 155, 759, 903, 389, 738, 595, 209, 902, 81, 100, 290, 829, 117, 738, 180, 572, 258, 885, 591, 955, 766, 579, 455, 685, 4, 644, 50, 720, 506, 837, 932, 661, 596, 836, 51, 335, 783, 260, 589, 864, 713, 232, 45, 182, 970, 578, 754, 581, 815, 345, 536, 581, 276, 343, 618, 281, 339, 668, 353, 846, 506, 285, 859, 454, 121, 910, 141, 904, 523, 83, 121, 588, 315, 518, 770, 637, 448, 524, 570, 264, 222, 458, 197, 850, 802, 816, 131, 141, 836, 484, 339, 694, 122, 199, 149, 243, 461, 290, 500, 984, 373, 973, 924, 40, 843, 694, 30, 292, 571, 600, 908, 145, 411, 457, 995, 213, 625, 479, 706, 462, 315, 398, 156, 437, 597, 657, 33, 410, 300, 885, 395, 25, 858, 671, 66, 701, 366, 448, 345, 289, 400, 253, 434, 811, 63, 429, 376, 688, 260, 435, 502, 576, 833, 659, 365, 782, 668, 398, 192, 968, 283, 939, 994, 493, 611, 412, 547, 329, 212, 892, 618, 612, 498, 404, 424, 561, 185, 152, 601, 446, 587, 104, 374, 772, 115, 739, 554, 783, 138, 99, 104, 773, 390, 450, 267, 353, 214, 814, 682, 426, 58, 652, 38, 556, 56, 814, 469, 242, 967, 423, 688, 906, 527, 62, 679, 642, 153, 585, 777, 291, 36, 881, 417, 427, 683, 684, 132, 897, 850, 815, 323, 908, 819, 714, 817, 876, 880, 638, 470, 199, 61, 510, 106, 588, 572, 137, 582, 77, 74, 360, 721, 463, 593, 138, 242, 629, 174, 374, 526, 24, 541, 202, 284, 361, 268, 453, 589, 148, 444, 59, 348, 505, 569, 806, 446, 493, 295, 380, 570, 721, 92, 291, 184, 38, 429, 426, 667, 955, 153, 545, 979, 694, 99, 616, 55, 367, 421, 996, 516, 865, 55, 216, 723, 624, 22, 521, 117, 669, 901, 40, 390, 994, 331, 575, 384, 113, 1, 51, 68, 154, 948, 400, 201, 48, 368, 608, 415, 789, 605, 283, 655, 660, 499, 730, 637, 873, 251, 106, 542, 152, 146, 933, 498, 478, 508, 882, 943, 861, 285, 11, 368, 234, 411, 569, 282, 779, 529, 49, 921, 134, 333, 928, 795, 832, 658, 784, 706, 909, 890, 248, 413, 37, 533, 912, 867, 41, 146, 810, 255, 784, 821, 623, 18, 585, 544, 652, 364, 425, 701, 637, 560, 34, 565, 707, 867, 223, 491, 925, 132, 381, 173, 546, 770, 707, 810, 637, 100, 308, 447, 707, 92, 621, 682, 110, 206, 226, 114, 922, 4, 816, 560, 564, 850, 125, 271, 69, 349, 114, 994, 833, 847, 520, 731, 618, 579, 893, 607, 31, 202, 55, 739, 294, 676, 421, 757, 234, 0, 871, 156, 4, 39, 716, 568, 890, 194, 191, 311, 895, 657, 306, 728, 504, 178, 460, 474, 757, 705, 82, 788, 907, 489, 527, 554, 517, 949, 663, 751, 301, 886, 259, 305, 926, 328, 873, 168, 522, 416, 479, 417, 73, 137, 497, 929, 315, 957, 756, 72, 15, 838, 213, 922, 679, 740, 828, 196, 41, 491, 299, 342, 378, 910, 999, 656, 238, 224, 824, 760, 640, 655, 529, 65, 793, 27, 347, 460, 336, 103, 885, 351, 293, 98, 626, 972, 190, 454, 520, 232, 946, 171, 926, 676, 81, 926, 332, 320, 502, 508, 432, 143, 515, 962, 560, 660, 341, 907, 121, 677, 10, 6, 29, 655, 104, 655, 627, 646, 461, 147, 230, 407, 670, 157, 435, 752, 435, 119, 72, 937, 979, 504, 432, 495, 818, 993, 507, 159, 252, 980, 189, 615, 986, 218, 270, 442, 225, 250, 89, 38, 749, 319, 446, 420, 828, 233, 172, 615, 353, 596, 905, 684, 452, 337, 531, 271, 682, 39, 782, 287, 19, 971, 254, 358, 541, 524, 152, 118, 774, 593, 157, 876, 265, 955, 296, 93, 540, 468, 61, 893, 416, 966, 930, 868, 655, 461, 491, 690, 500, 626, 977, 872, 597, 231, 230, 491, 107, 382, 961, 234, 976, 118, 110, 241, 425, 406, 686, 966, 226, 99, 211, 642, 65, 141, 862, 73, 603, 354, 763, 455, 980, 740, 327, 929, 323, 909, 772, 430, 644, 734, 16, 620, 204, 126, 213, 630, 532, 251, 948, 110, 351, 159, 752, 768, 653, 967, 841, 608, 321, 956, 63, 653, 48, 743, 934, 371, 652, 59, 154, 296, 793, 170, 268, 349, 297 });
        //EquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0});
    }

    //Find the contiguous max sum of an array
    //Kadane's Algorithm
    private static void contiguousMaxSum(int[] A) {
        int maxSum = Integer.MIN_VALUE, tempSum =0;
        for(int i = 1; i<A.length;i++){
            tempSum += A[i];
            maxSum = Integer.max(maxSum,tempSum);
            if(tempSum < 0){
                tempSum = 0;
            }
        }
        System.out.println("max sum : "+maxSum);
    }

    /* Given an array of size n, find the smallest positive number which is not present in the array
    * ex : 7,2,-3,6,1,4
    * BF => sing n^2 or use sort and loop to get min
        *  Arrays.sort(A);int min = 1;for(int i = 0; i<A.length;i++){if(min == A[i] ){min++;}}
        * System.out.println("missing min :"+min);
    * Second approach: using hashset
    * main approach :
        * change all zero and negative numbers to n+1 in the array
        * for each index element change the corresponding index(element) to negative
        * iterate and find the positive numbers in array,index is the answer else return n+1
    * */
    private static void smallestPositiveNumber(int[] A) {
        System.out.println("before conversion :"+Arrays.toString(A));
        for(int i=0;i<A.length;i++){
            if(A[i] <= 0){
                A[i] = A.length+1;
            }
        }
        System.out.println("after conversion :"+Arrays.toString(A));
        for(int i=0; i<A.length; i++){
            int temp = A[i] > 0?A[i]:-(A[i]);
            if((temp-1) < A.length){
                A[temp-1] = A[temp-1] > 0?-A[temp-1]:A[temp-1];
            }
        }
        System.out.println("reverse conversion :"+Arrays.toString(A));
        for(int i=0; i<A.length; i++){
            if(A[i] > 0){
                System.out.println("missing :"+(i+1));
                return;
            }
        }
        System.out.println("missing : "+(A.length+1));

    }

    /* Question : Maximum Absolute Difference
    * You are given an array of N integers, A1, A2, .... AN.
    * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|,
    * where |x| denotes absolute value of x.
    * */
    /* Approach :
    * expression we can divide it into 4 cases
    * A[i]>A[j] && i>j => (A[i]-A[j]) + (i-j) => (A[i]-A[j])+(i-j)
    * A[i]<A[j] && i<j => (A[j]-A[i]) + (j-i) => -(A[i]+i)+(A[j]+j)
    * A[i]<A[j] && i>j => (A[i]-A[j]) + (i-j) => (A[i]+i)-(A[j]+j)
    * A[i]>A[j] && i<j => (A[i]-A[j]) + (j-i) => (A[i]-i)-(A[j]-j)
    * */
    public static void maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
            max1 = Integer.max(max1,(A[i]+i));
            max2 = Integer.max(max2, (A[i]-i));
            min1 = Integer.min(min1,(A[i]+i));
            min2 = Integer.min(min2,(A[i]-i));
        }
        int ans = Integer.max((max1 - min1),(max2-min2));
    }

    /* Question: Flip
    * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
    * In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
    * By flipping, we mean changing character 0 to 1 and vice-versa.
    * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
    * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
    *  If there are multiple solutions, return the lexicographically smallest pair of L and R.
    * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
    * */
    // Approach
    /* use kadane's algo(0 as +1 and 1 as -1)
    * */
    public static void flip(String A) {
        int[] K = new int[A.length()];
        int[] ans  = new int[2];
        boolean flag = true;
        for(int i=0; i<A.length();i++){
            if(A.charAt(i) == '0'){
                flag = false;
                K[i] = 1;
            }else{
                K[i] = -1;
            }
        }
        if(flag){
            return;
        }
        int maxSum = 0, currSum = 0,left =0,right=0;
        for(int i = 0;i<K.length;i++){
            currSum += K[i];
            if(currSum > maxSum){
                maxSum = currSum;
                right = i;
                ans[0] = left+1;
                ans[1] = right+1;
            }
            if(currSum < 0){
                currSum = 0;
                left = i+1;
            }
        }
    }

    /* Question: Beggars Outside the temple
    * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
    * When the devotees come to the temple, they donate some amount of coins to these beggars.
    * Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
    * Given the amount P donated by each devotee to the beggars ranging from L to R index,
    * where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
    * provided they don't fill their pots by any other means.
    * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
    * */
    public static void BeggarsOutSideTheTemple(int A, int[][] B) {
        int[] ans = new int[A];
        for(int i =0;i<B.length;i++){
            int left = B[i][0]-1;
            int right = B[i][1]-1;
            int amt = B[i][2];
            ans[left] += amt;
            if(right+1 < A) {
                ans[right + 1] -= amt;
            }
        }
        for(int i=1;i<A;i++){
            ans[i] = ans[i]+ans[i-1];
        }
        System.out.println("ans :"+Arrays.toString(ans));

    }

    /* Question : Add one to number
    * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
    * The digits are stored such that the most significant digit is at the head of the list.
    * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    * For example: for this problem, the following are some good questions to ask :
    * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
    * A: For the purpose of this question, YES
    * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
    * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
    * */
    public static void plusOne(int[] A) {
        int carry = 1;
        int[] rev = new int[A.length];
        int k = 0;
        System.out.println("in :"+Arrays.toString(A));
        for(int i = A.length-1;i>=0;i--){
            rev[k] = A[i];
            k++;
        }
        System.out.println("rev : "+Arrays.toString(rev));
        for(int i=0;i<rev.length;i++){
            rev[i] += carry;
            if(rev[i] > 9){
                rev[i] = 0;
                carry = 1 ;
            }else{
                carry = 0;
                break;
            }
        }
        System.out.println("rev __: "+Arrays.toString(rev) +" :: crry :"+carry);
        boolean check = true;
        int[] ans = new int[0];
        if(carry == 1){
            ans = new int[rev.length+1];
            ans[0] = carry;
            k = 1;
            for(int i=rev.length-1;i>=0;i--){
                ans[k] = rev[i];
                k++;
            }
            System.out.println("ans :::; "+Arrays.toString(ans));
            return;
        }else{
            int count = 0;
            k = 0;
            for(int i = rev.length-1;i>=0;i--){
                if(check && rev[i] == 0){
                    count++;
                }else if(check && rev[i] != 0){
                    check = false;
                    ans = new int[rev.length-count];
                    ans[k] = rev[i];
                    k++;
                }else if(!check){
                    ans[k] = rev[i];
                    k++;
                }
            }
            System.out.println("ans >> "+Arrays.toString(ans));
        }



    }

    /* Question: Closest MinMax
    * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
    * and at least one occurrence of the minimum value of the array.
    * */
    public static void closestMinMax(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE,maxPos = Integer.MAX_VALUE,closest = Integer.MAX_VALUE;
        for(int i=0; i<A.length;i++){
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        System.out.println("min :"+min+"  :: max :"+max);
        for(int i =0; i<A.length;i++){
            minPos = A[i] == min ? i:minPos;
            maxPos = A[i] == max ? i:maxPos;
            if(minPos != Integer.MAX_VALUE && maxPos != Integer.MAX_VALUE){
                int val = minPos - maxPos;
                closest = Math.min(closest,(val > 0?val:-val)) ;
                closest = closest > 0 ? closest : -closest;
                System.out.println("len :"+closest);
            }


        }
    }

    /* Question: Equilibrium index of an Array
    * You are given an array A of integers of size N.
    * Your task is to find the equilibrium index of the given array
    * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    * NOTE:
    * Array indexing starts from 0. If there is no equilibrium index then return -1.
    * If there are more than one equilibrium indexes then return the minimum index.
    * */
    public static void EquilibriumIndex(int[] A) {
        System.out.println("input arr : "+Arrays.toString(A));
        if(A.length == 0){
            return;
        }
        int minIdx = Integer.MAX_VALUE;
        int[] ps = new int[A.length];
        ps[0] = A[0];
        for(int i=1;i<A.length;i++){
            ps[i] = ps[i-1] + A[i];
        }
        System.out.println("prefix sum :: "+Arrays.toString(ps));
        int lSum,rSum;
        for(int i=0;i<A.length;i++){
            System.out.println("i :"+i);
            if(i == 0){
                lSum = 0;
                rSum = ps[A.length-1] - ps[i];
            }else if(i == A.length-1){
                lSum = ps[i-1];
                rSum = 0;
            }else{
                lSum = ps[i-1];
                rSum = ps[A.length-1]-ps[i];
            }
            System.out.println("left Sum :"+lSum);
            System.out.println("right Sum :"+rSum);
            if(lSum == rSum){
                minIdx = Math.min(minIdx,i);
                System.out.println("min idx :"+minIdx +"  :: i : "+i);
            }
        }

    }


}
