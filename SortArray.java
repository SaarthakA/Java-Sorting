package proj3;
/////////////////////////////////////////////////////////////////////
public class SortArray <T extends Comparable<T>>
{
	/** Note: Uses default constructor */
//-------------------------------------------------------------
	/** Shell for merge sort.
    @param array to be sorted.
    @return  none */
	public void mergeSort(Object[] a)
	{
		Object[] tmp = new Object[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}
//-------------------------------------------------------------
	/** recursive merge sort.
    @param array to be sorted, temporary array, left starting index, right starting index.
    @return  none */
	private void mergeSort(Object[] a, Object[] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

//-------------------------------------------------------------
	/** merging of arrays.
    @param left sub-array, right sub-array, left starting index, right starting index, and of right array index.
    @return  none */
    @SuppressWarnings("unchecked")
	private void merge(Object[]a, Object[] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(((Comparable<T>) a[left]).compareTo((T) a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
//-------------------------------------------------------------
	/** recursive quick sort.
    @param array to be sorted,starting index, ending index.
    @return  none */
    @SuppressWarnings("unchecked")
	public void qsort(Object[] arr, int a, int b) {
        if (a < b) {
            int i = a;
            int j = b;
            Object pivot = arr[(i + j) / 2];
            do 
            {
                while (((Comparable<T>) arr[i]).compareTo((T) pivot) < 0) 
                	i++;
                while (((Comparable<T>) pivot).compareTo((T) arr[j]) < 0) 
                	j--;
                if ( i <= j) 
                {
                    Object tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    }
//-------------------------------------------------------------
	/** Shell for quick sort.
    @param array to be sorted.
    @return  none */
    public void quickSort(Object[] arr) 
    {
    	qsort(arr, 0, arr.length-1);
    }
//-------------------------------------------------------------
}
/////////////////////////////////////////////////////////////////////
