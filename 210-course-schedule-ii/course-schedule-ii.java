class Solution {
public int[] findOrder(int numCourses, int[][] prerequisites) {

    // Create adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
    }

    // Build graph: b -> a
    for (int[] pre : prerequisites) {
        adj.get(pre[1]).add(pre[0]);
    }

    // Compute indegree
    int[] indegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
        for (int neighbour : adj.get(i)) {
            indegree[neighbour]++;
        }
    }

    // Add nodes with indegree 0
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            queue.add(i);
        }
    }

    int[] result = new int[numCourses];
    int index = 0;

    // BFS processing
    while (!queue.isEmpty()) {
        int curr = queue.poll();
        result[index++] = curr;

        for (int neighbour : adj.get(curr)) {
            indegree[neighbour]--;
            if (indegree[neighbour] == 0) {
                queue.add(neighbour);
            }
        }
    }

    // If not all courses processed → cycle exists
    if (index != numCourses) {
        return new int[0];
    }

    return result;
}
}