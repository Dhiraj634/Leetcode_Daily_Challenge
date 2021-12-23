package Dhiraj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<HashSet<Integer>> graph = new ArrayList<>();
		IntStream.range(0,numCourses).forEach(a -> graph.add(new HashSet<>()));
		int[] dependency = new int[numCourses];
		for(int[] course: prerequisites){
			graph.get(course[1]).add(course[0]);
			dependency[course[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<numCourses;i++){
			if(dependency[i] == 0){
				queue.add(i);
			}
		}
		int count = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		while(queue.size() > 0){
			int course = queue.poll();
			count++;
			answer.add(course);
			for(int otherCourse: graph.get(course)){
				dependency[otherCourse]--;
				if(dependency[otherCourse] == 0){
					queue.add(otherCourse);
				}
			}
		}

		return count != numCourses ? new int[]{} : answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
