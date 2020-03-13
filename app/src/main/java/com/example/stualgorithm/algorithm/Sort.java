package com.example.stualgorithm.algorithm;

public enum Sort {

    //冒泡排序 O(N²)
    BUBBLE {
        @Override
        public void excute(int[] array) {
            for (int i = 0; i < array.length; i++) {
                boolean flag = false;

                for (int j = array.length - 1; j > i; j--) {

                    if (array[j] < array[j - 1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        flag = true;
                    }
                }

                //当上一次冒泡没有交换时，说明已经是有序的了
                if (!flag) {
                    break;
                }

            }
        }
    },

    //选择排序 O(N²)
    SELECTION {
        @Override
        public void excute(int[] array) {
            for (int i = 0; i < array.length; i++) {

                int min = i;
                for (int j = array.length - 1; j > i; j--) {
                    if (array[j] < array[min]) {
                        min = j;
                    }
                }

                if (min != i) {
                    int temp = array[i];
                    array[i] = array[min];
                    array[min] = temp;
                }
            }
        }
    },

    //插入排序 O(N²)
    INSERTION {
        @Override
        public void excute(int[] array) {
            for (int i = 1; i < array.length; i++) {

                //基于冒泡排序，把未排序地第一个向上冒泡
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j - 1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    } else {
                        //无需排序
                        break;
                    }
                }
            }
        }
    },

    //希尔排序 不稳定~O(N²)
    SHELL {
        @Override
        public void excute(int[] array) {
            //原理：一个k增量排序的数列，将保持它的k排序性（不被后续排序打断）
            int increase = array.length;
            while (true) {
                increase = increase / 2;

                //切分成increase个数列
                for (int i = 0; i < increase; i++) {

                    //基于插入排序，此时把i想成初始值，间隔变化：1->increse
                    for (int j = i + increase; j < array.length; j += increase) {
                        for (int k = j; k > i; k -= increase) {

                            if (array[k] < array[k - increase]) {
                                int temp = array[k];
                                array[k] = array[k - increase];
                                array[k - increase] = temp;
                            } else {
                                break;
                            }
                        }
                    }
                }

                if (increase == 1) {
                    break;
                }
            }
        }
    },

    //快速排序
    QUICK {
        @Override
        public void excute(int[] array) {


        }
    },

    //归并排序 O(N logN)
    MERGE {
        @Override
        public void excute(int[] array) {
            //准备递归所需要的零时数组和变量
            int first = 0;
            int last = array.length - 1;
            int[] temp = new int[array.length];

            //开始排序
            mergeSort(array, temp, first, last);
        }

        //归并递归排序
        private void mergeSort(int[] array, int[] temp, int first, int last) {

            //开始位置等于结束位置，单个元素就不用排序了
            if (first < last) {
                int middle = (first + last) / 2;

                //左半部分排序
                mergeSort(array, temp, first, middle);
                //右半部分排序
                mergeSort(array, temp, middle + 1, last);

                //合并左右两部分
                mergeArrays(array, temp, first, last);
            }
        }

        //合并数组
        private void mergeArrays(int[] array, int[] temp, int first, int last) {
            int middle = (first + last) / 2;

            //左右两部分指针位置
            int foreIndex = first;
            int behindIndex = middle + 1;

            //temp数组的指针位置
            int tempIndex = 0;

            //左右部分取最小的值放入temp[]
            while (foreIndex <= middle && behindIndex <= last) {

                if (array[foreIndex] < array[behindIndex]) {
                    temp[tempIndex] = array[foreIndex];
                    tempIndex++;
                    foreIndex++;
                } else {
                    temp[tempIndex] = array[behindIndex];
                    tempIndex++;
                    behindIndex++;
                }
            }

            //剩余放入的元素一次放入
            while (foreIndex <= middle) {
                temp[tempIndex] = array[foreIndex];
                tempIndex++;
                foreIndex++;
            }
            while (behindIndex <= last) {
                temp[tempIndex] = array[behindIndex];
                tempIndex++;
                behindIndex++;
            }

            //把temp[]元素放入array[]
            for (int i = 0; i < tempIndex; i++) {
                array[first + i] = temp[i];
            }

        }

    },

    //堆排序
    HEAP {
        @Override
        public void excute(int[] array) {

        }
    },

    //基数排序 O(N)
    RADIX {
        @Override
        public void excute(int[] array) {

        }
    },

    //计数排序
    COUNTING {
        @Override
        public void excute(int[] array) {

        }
    },

    //桶排序
    BUCKET {
        @Override
        public void excute(int[] array) {

        }
    };

    public abstract void excute(int[] array);
}
