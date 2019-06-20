import java.io.*;	
import java.util.*;

	public class med
	{
		private PriorityQueue<Integer> minHeap;
		private PriorityQueue<Integer> maxHeap;
		private int listSize;

	public static void main(String[] args) throws Exception
	{
		int sum = 0;
		med m = new med();
		File f1 = new File("med.txt");
		Scanner sc = new Scanner(f1);
		while(sc.hasNextInt())
		{
			m.add(sc.nextInt());
			sum=sum+m.median();
		}
		System.out.print(sum % 1000);
	}
		public med()
		{
			minHeap = new PriorityQueue<Integer>(5000);
			maxHeap	= new PriorityQueue<Integer>(5000,Collections.reverseOrder());
			listSize=0;
		}
		//

		public void add(int n)
		{
			if (listSize == 0)
			{
				maxHeap.add(n);
			}
			else if (n % 2 == 0) // if the input element size is even
			{
				if(n > minHeap.peek())
				{
					maxHeap.add(minHeap.poll());
					minHeap.add(n);
				}
				else
				{
					maxHeap.add(n);
				}
			}
			else // if input element size is odd
			{
				if(n<maxHeap.peek())
				{
					minHeap.add(maxHeap.poll());
					maxHeap.add(n);
				}
				else
				{
					minHeap.add(n);
				}
			}
			listSize++;
		}
		public int median()
		{
			return maxHeap.peek();
		}

	
	
}
	