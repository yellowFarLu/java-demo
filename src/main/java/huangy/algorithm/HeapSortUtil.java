package huangy.algorithm;


/**
 * 堆排序算法的实现
 * @author huangy on 2019-12-14
 */
public class HeapSortUtil {

    // 大根堆进行调整
    private static void adjustHeap(int i, int j, int[] inNums) {

        int temp = inNums[i];

        for (int k=i*2+1; k<j; k=k*2+1) {

            //如果右边值大于左边值，指向右边
            if (k+1<j && inNums[k]<inNums[k+1]) {
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点,并以新的子节点作为父节点（不用进行交换）
            if (inNums[k] > temp) {
                inNums[i]=inNums[k];
                i=k;
            }
            else
                break;
        }

        // 插入元素找到适当的位置，进行插入
        inNums[i] = temp;
    }

    /**
     * 堆排序主要算法
     * 首先建立堆，然后末尾出堆n-1次，即排好序了
     * 之所以是n-1次，因为最后一个元素不用出堆
     * @param inNums 需要排序的数组
     */
    public static void HeapSort(int[] inNums) {

        int nums = inNums.length;

        //1.构建大顶堆
        for (int i=nums/2-1; i>=0; i--) {
            adjustHeap(i, nums, inNums);
        }

        //2.交换堆顶元素与末尾元素，然后调整堆结构
        for (int j=nums-1; j>0; j--) {

            // 堆顶元素和末尾元素进行交换
            int temp=inNums[0];
            inNums[0]=inNums[j];
            inNums[j]=temp;

            // 重新对堆进行调整
            adjustHeap(0, j, inNums);
        }
    }

    public static void main(String[] args) {

        int[] data = {6,5,8,4,7,9,1,3,2};

        HeapSort(data);

        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
