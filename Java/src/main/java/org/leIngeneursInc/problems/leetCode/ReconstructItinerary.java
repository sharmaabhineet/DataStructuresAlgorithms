/**
 * 
 */
package org.leIngeneursInc.problems.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Abhineet
 *
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		String[][] edges = new String[][] { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
				int index = 0;
				List<String> lst = new ReconstructItinerary().findItinerary(edges);
		for (String str : lst) {
			System.out.print(str);
			if(index != lst.size() - 1){
				System.out.print(" --> ");
			}
			index++;
		}
		System.out.println("");
	}

	private Map<String, PriorityQueue<String>> edgeMap = new HashMap<String, PriorityQueue<String>>();
	private boolean[][] visitedEdges = null;
	private int edgeCount = 0;
	private Map<String, Integer> mapIndices = new HashMap<String, Integer>();
	private int visitedCount = 0;

	public List<String> findItinerary(String[][] tickets) {
		edgeCount = tickets.length;
		// long startTime = System.currentTimeMillis();
		int verIndex = 0;
		for (int index = 0; index < tickets.length; index++) {
			if (!edgeMap.containsKey(tickets[index][0])) {
				edgeMap.put(tickets[index][0], new PriorityQueue<String>(tickets.length, DEFAULT_COMP));
			}
			edgeMap.get(tickets[index][0]).add(tickets[index][1]);
			if (!mapIndices.containsKey(tickets[index][0])) {
				mapIndices.put(tickets[index][0], verIndex++);
			}

			if (!mapIndices.containsKey(tickets[index][1])) {
				mapIndices.put(tickets[index][1], verIndex++);
			}
		}

		visitedEdges = new boolean[verIndex][verIndex];
		// System.out.println("TIME : " +(System.currentTimeMillis() -
		// startTime));

		// System.out.println(edgeMap);

		final String SRC = "JFK";

		List<String> outList = new ArrayList<String>();
		getValidItineraries(SRC, outList);
		return outList;
	}

	private void getValidItineraries(String src, List<String> outList) {
		outList.add(src);
		if (visitedCount == edgeCount) {
			// implies we have visited all the edges. Base Case
			return;
		} else {
			// do nothign here. go on. got some work to do, eh!!!
		}

		int srcIndex = mapIndices.get(src);

		if (edgeMap.containsKey(src)) {
			for (String dest : edgeMap.get(src)) {
				int destIndex = mapIndices.get(dest);
				if (!visitedEdges[srcIndex][destIndex]) {
					visitedCount++;
					visitedEdges[srcIndex][destIndex] = true;
					// System.out.println("Visiting : " +edge);
					getValidItineraries(dest, outList);
					if (visitedCount == edgeCount) {
						return;
					} else {
						// System.out.println("Setting " +src + " --> " +dest +
						// "TO FALSE ");

						visitedEdges[srcIndex][destIndex] = false;
						visitedCount--;
					}
				}
			}
		} else {
			// nothing much you can do here. Retreat.
		}
		// it returns from here anyhow.
		outList.remove(outList.size() - 1);
		// System.out.println("--- HERE ----");
	}

	private static Comparator<String> DEFAULT_COMP = new Comparator<String>() {
		public int compare(String str1, String str2) {
			return str1.compareTo(str2);
		}
	};

}
