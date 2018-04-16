package protocols;

public class ShortestPath {

	public void printDistAndPrev(int dist[], int prev[]) {
		for (int i = 0; i < prev.length; i++) {
			System.out.print(dist[i] + "("+ prev[i] +") ");
		}
		System.out.println("");
	}
	
	public int[][] moveGraph(int graph[][], int source){
		
		for (int i = 0; i < graph.length; i++) {
			int x = graph[i][source];
			
			for (int j = source; j > 0; j--) {
				graph[i][j] = graph[i][j-1];
			}
			
			graph[i][0] = x;
		}
		
		for (int i = 0; i < graph.length; i++) {
			int x = graph[source][i];
			
			for (int j = source; j > 0; j--) {
				graph[j][i] = graph[j-1][i];
			}
			
			graph[0][i] = x;
		}
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				// System.out.print(graph[i][j] + " ");
			}
			// System.out.println("");
		}
		
		return graph;
	}
	
	public int[] moveResult(int arr[], int source) {
		
		int temp = arr[0];
		
		for (int i = 0; i < source; i++) {
			arr[i] = arr[i+1];
		}
		
		arr[source] = temp;
		
		return arr;
	}
	
	public int[] dijkstra(int graph[][], int source) {
		int originalSource = source;
		graph = moveGraph(graph, source);
		source = 0;
		
		int dist[] = new int[graph.length];
		int prev[] = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		
		dist[source] = 0;
		prev[source] = source;
		
		int Q[] = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			
			Q[i] = graph[0][i];
			
			// System.out.print(Q[i] + " ");
		}
		// System.out.println("");
		
		int nodesTraversed = 0;
		while (nodesTraversed < graph.length) {			
			int min = Integer.MAX_VALUE;
			int nextVertexIndex = 0;
			
			for (int i = 0; i < Q.length; i++) {
				if (Q[i] < min) {
					min = Q[i];
					nextVertexIndex = i;
				}
				// System.out.print(Q[i] + " ");
			}
			// System.out.println("");
			
			Q[nextVertexIndex] = Integer.MAX_VALUE;
			nodesTraversed++;
			// System.out.println("next vertex index: " + nextVertexIndex);
			
			for (int i = 0; i < graph.length; i++) {
				if (i == nextVertexIndex) continue;
				
				int alt = (dist[nextVertexIndex] + graph[nextVertexIndex][i] > Integer.MAX_VALUE) ? 
									Integer.MAX_VALUE : dist[nextVertexIndex] + graph[nextVertexIndex][i];				
				
//				System.out.println("IMV: " + Integer.MAX_VALUE);
//				System.out.println("SUM: " + (dist[nextVertexIndex] + graph[nextVertexIndex][i]));
//				System.out.println("");
				
				if (alt < dist[i] && alt > 0) {
//					System.out.println("dist: " + dist[nextVertexIndex]);
//					System.out.println("graph: " + graph[nextVertexIndex][i]);
//					System.out.println("");
					
					dist[i] = alt;
					prev[i] = nextVertexIndex;
					Q[i] = alt;
				}
			}
			
			// printDistAndPrev(dist, prev);
			// System.out.println("==================================");
		}
		
		prev = moveResult(prev, originalSource);
		dist = moveResult(dist, originalSource);
		
		return prev;
	}
	
	public ShortestPath() {
//		int graph[][] = {
//				{0,2,3},
//				{2,0,Integer.MAX_VALUE},
//				{3,Integer.MAX_VALUE,0},
//		};
		
//		int graph[][] = {
//				{0,2,3,Integer.MAX_VALUE,5},
//				{2,0,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
//				{3,Integer.MAX_VALUE,0,Integer.MAX_VALUE, Integer.MAX_VALUE},
//				{Integer.MAX_VALUE,4,Integer.MAX_VALUE,0,Integer.MAX_VALUE},
//				{5,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0},
//		};
		
		int graph[][] = {
				{0,7,3,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
				{7,0,3,Integer.MAX_VALUE,4,Integer.MAX_VALUE},
				{3,3,0,4,8,Integer.MAX_VALUE},
				{5,Integer.MAX_VALUE,4,0,7,9},
				{Integer.MAX_VALUE,4,8,7,0,2},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,9,2,0}
		};
		
		int[] path = dijkstra(graph, 0);
		
		for (int i = 0; i < path.length; i++) {
			System.out.print(path[i ] + " ");
		}
	}
	
}
