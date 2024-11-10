package MedianOfTwoSortedArray;

public class MedianOfTwoSortedArray {
    public double findMedian(int []nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int [] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int low=0;
        int high=nums1.length;

        while (low<=high){
            int parti_X=(high+low)/2;
            int parti_Y=(nums1.length+ nums2.length+1)/2-parti_X;
            int maxleftX=parti_X==0?Integer.MIN_VALUE:nums1[parti_X-1];
            int minleftX=parti_X== nums1.length?Integer.MAX_VALUE:nums1[parti_X];
            int maxleftY=parti_Y==0?Integer.MIN_VALUE: nums2[parti_Y-1];
            int minleft_Y=parti_Y== nums2.length?Integer.MAX_VALUE:nums2[parti_Y];


            if(minleftX<=maxleftY&&maxleftX>=minleft_Y){
                if((nums1.length+nums2.length)%2==0){
                    return ((double) Math.max(maxleftX,minleft_Y)+Math.min(minleftX,maxleftY))/2;
                }
                else {
                    return (double) Math.max(maxleftX,maxleftY);
                }

            } else if (minleftX>maxleftY) {
                high=parti_X-1;
            }
            else {
                low=parti_X+1;
            }

        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
        int[] param_1 = {1, 3};
        int[] param_2 = {2};
        double ret = solution.findMedian(param_1, param_2);
        System.out.println(ret);
    }
}
