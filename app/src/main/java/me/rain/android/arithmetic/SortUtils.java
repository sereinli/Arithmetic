package me.rain.android.arithmetic;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by CBS on 2017/1/16.
 */

public class SortUtils {

    public static String printArrays(int[] args) {
        String result = "";
        for(int i = 0; i < args.length; i++) {
            if(!TextUtils.isEmpty(result)) {
                result += ",";
            }
            result += args[i];
        }

        return result;
    }

    /**
     * 选择排序： 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。首先在未排序序列中找到
     * 最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列
     * 的末尾。以此类推，直到所有元素均排序完毕。
     *
     算法规则： 将待排序集合(0...n)看成两部分，在起始状态中，一部分为(k..n)的待排序unsorted集合，另一部分
     为(0...k)的已排序sorted集合,在待排序集合中挑选出最小元素并且记录下标i，若该下标不等于k，那么 unsorted[i]
     与 sorted[k]交换 ，一直重复这个过程，直到unsorted集合中元素为空为止。
     * @param args
     * @return
     */
    public static int[] selectSort(int[] args) {
        if(args == null) {
            return null;
        }

        Log.d("rain","selectSort original:"+printArrays(args));
        int length = args.length;
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j< length; j++) {
                if(args[i] > args[j]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        Log.d("rain","selectSort result:"+printArrays(args));
        return args;
    }

    /**
     * 冒泡排序： 是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会
     * 经由交换慢慢“浮”到数列的顶端。
     *
     * 算法规则： 由于算法每次都将一个最大的元素往上冒，我们可以将待排序集合(0...n)看成两部分，一部分为(k..n)
     * 的待排序unsorted集合，另一部分为(0...k)的已排序sorted集合，每一次都在unsorted集合从前往后遍历，选出一个数，
     * 如果这个数比其后面的数大，则进行交换。完成一轮之后，就肯定能将这一轮unsorted集合中最大的数移动到集合的最后，
     * 并且将这个数从unsorted中删除，移入sorted中。
     * @param args
     * @return
     */
    public static int[] bubbleSort(int[] args) {
        if(args == null) {
            return null;
        }

        Log.d("rain","bubbleSort original:"+printArrays(args));
        int length = args.length;

//        for(int i = 0; i < length - 1; i++) {
//            //每循环一次，都能找到当前最大的数，放在末尾，所以没循环一次，需要遍历的n也相应减小
//            for(int j = 0; j < length - 1 - i; j++) {
//                if(args[j] > args[j + 1]) {
//                    int temp = args[j];
//                    args[j] = args[j + 1];
//                    args[j + 1] = temp;
//                }
//            }
//        }

        for(int i = 0; i < length - 1; i++) {
            //每循环一次，都能找到当前最大的数，放在末尾，所以没循环一次，需要遍历的n也相应减小
            for(int j = length - 1; j > i; j--) {
                if(args[j] > args[j - 1]) {
                    int temp = args[j];
                    args[j] = args[j - 1];
                    args[j - 1] = temp;
                }
            }
        }

        Log.d("rain","bubbleSort result:"+printArrays(args));
        return args;
    }

    /**
     * 快速排序： 又称划分交换排序（partition-exchange sort），一种排序算法，最早由东尼·霍尔提出。在平均状况下，
     * 排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快速排序通常明显
     * 比其他Ο(n log n)算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来
     *
     算法规则： 本质来说，快速排序的过程就是不断地将无序元素集递归分割，一直到所有的分区只包含一个元素为止。
     由于快速排序是一种分治算法，我们可以用分治思想将快排分为三个步骤：
     1.分：设定一个分割值，并根据它将数据分为两部分
     2.治：分别在两部分用递归的方式，继续使用快速排序法
     3.合：对分割的部分排序直到完成
     * @param args
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] args, int start, int end) {
        if(args == null) {
            return null;
        }

        if(end - start > 1) {
            int index = dividerArray(args, start, end);

            quickSort(args, start, index);
            quickSort(args, index + 1, end);
        }

        return args;
    }

    /**
     * 以start位置的值为中间点，将数组分成两个分区，前一部分小于该值，后一部分大于该值
     * @param args
     * @param start
     * @param end
     * @return
     */
    private static int dividerArray(int[] args, int start, int end) {
        if(args == null) {
            return 0;
        }
        Log.d("rain","dividerArray original:"+printArrays(args));
        int divider = args[start];

        while(start < end) {
            while (start < end && args[end] >= divider) {
                end--;
            }

            args[start] = args[end];

            while (start < end && args[start] < divider) {
                start++;
            }

            args[end] = args[start];
        }

        args[start] = divider;
        Log.d("rain","dividerArray result:"+printArrays(args));
        return start;
    }


    /**
     *归并排序： 是创建在归并操作上的一种有效的排序算法，效率为O(n log n)。1945年由约翰·冯·诺伊曼首次提出。
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。
     *
     算法规则： 像快速排序一样，由于归并排序也是分治算法，因此可使用分治思想：
     1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
     3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     4.重复步骤3直到某一指针到达序列尾
     5.将另一序列剩下的所有元素直接复制到合并序列尾
     * @param source
     * @param dest
     * @param start
     * @param end
     * @return
     */
    public static int[] mergeSort(int[] source, int[] dest, int start, int end) {
        if(start >= end) {
            return dest;
        }

        int middle = (start + end) >> 1;
        mergeSort(source, dest, start, middle);
        mergeSort(source, dest, middle + 1, end);

        merge(source, dest, start, end, middle);

        return dest;
    }

    private static void merge(int[] source, int[] dest, int start, int end, int middle) {
        //分为两个序列source[start ~ middle],source[middle+1 ~ end]
        int i = start;
        int j = middle + 1;
        int index = start;

        while (i <= middle && j <= end) {
            if(source[i] <= source[j]) {
                dest[index++] = source[i++];
            }else {
                dest[index++] = source[j++];
            }
        }

        while(i <= middle) {
            dest[index++] = source[i++];
        }

        while (j <= end) {
            dest[index++] = source[j++];
        }

        for(int k = start; k <= end; k++) {
            source[k] = dest[k];
        }

        Log.d("rain","merge source result:"+printArrays(source));
    }
}
