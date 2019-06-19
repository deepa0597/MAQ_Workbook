import java.io.*;
import java.util.*;

public class prog2
{
	//cost between 2 vertices
	static int[][] cost; 
	//distance between 2 vertices
	static int[] distance;
	public static void main(String[] args) throws Exception
	{
		File f1 = new File("inputText");
		Scanner sc = new Scanner(f1);
		//200 vertices
		int n = 200;
		//initializing array with size n
		//distance is the dist from source node
		cost = new int[n][n];
		distance = new int[n];
		int i=0, j=0;
		//distance from same node will be 0 else max distance will be 1000000
		for (i=0;i<200;i++)
		{
			for(j=0;j<200;j++)
			{
				if (i == j)
				{
					cost[i][j] = 0;
				}
				else
				{
					cost[i][j] = 1000000;
				}
			}
		}

//for every vertex, split the (destination vertex and distance) from the vertex
//in the second iteration split the destination vertex and the distance
		for (i = 0; i < n; i++) {
			
			String[] s = sc.nextLine().trim().split("\t");
            // The first term is the vertex node, convert it into string and store it in variable v
            int v = Integer.parseInt(s[0]);
            // Rest of the elements in array s will contain destination vertex along with the distances
            for ( j = 1; j < s.length; j++) {
                String[] ls = s[j].split(",");
                //ls[1] is the distance and ls[0] is the destination vertex
                //v is the first vertex (1) from souce node 0
                cost[v - 1][Integer.parseInt(ls[0]) - 1] = Integer.parseInt(ls[1]);
                //System.out.println(Integer.parseInt(ls[1])); // Distance
            }
        }
        //Shortest path from the source vertex to the destination vertex
        shortest_path_dist(0,n);
        for(i=0;i<200;i++)
        {	//7,37,59,82,99,115,133,165,188,197.
        	if (i== 6){System.out.print(" "+distance[6]);}
        	else if (i==36){System.out.print(" "+distance[36]);}
        	else if (i==58){System.out.print(" "+distance[58]);}
        	else if (i==81){System.out.print(" "+distance[81]);}
        	else if (i==98){System.out.print(" "+distance[98]);}
        	else if (i==114){System.out.print(" "+distance[114]);}
        	else if (i==132){System.out.print(" "+distance[132]);}
        	else if (i==164){System.out.print(" "+distance[164]);}
        	else if (i==187){System.out.print(" "+distance[187]);}
        	else if (i==196){System.out.print(" "+distance[196]);}
        }
	}
	static void shortest_path_dist(int v, int n)
	{
		int[] s = new int[200];
		for(int i =0; i<200;i++)
		{
			s[i]=0;
			//inital distance from souce to destination
			distance[i]=cost[v][i];
		}
		s[v] = 1; //visited
		distance[v] = 0; // source vertex is at 0 distance
		for(int i=1;i<199;i++)
		{
			int u =0; int dis=0;
			for (int j =0; j<s.length;j++)
			{
				if (s[j] == 0) //if the node is unvisited
			{
				dis=distance[j];
				u=j;
				for(int k=j+1;k<s.length;k++)
				{
					if (dis>distance[k] && s[k]==0)
					{ 
						dis = distance[k];
						u=k;
					}
				}
				break;
			}

			}
			s[u] =1; //mark as visited
			for (int j=1;j<200;j++)
			{
				if (s[j] ==0)
				{
					if(distance[j] > distance[u]+cost[u][j])
					{
						distance[j] = distance[u]+cost[u][j];
					}
				}
			}

		}



	}
}
