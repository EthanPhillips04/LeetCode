class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Build gene bank set for O(1) lookup
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        
        // Early exit if target doesn't exist, impossible!
        if (!geneBank.contains(endGene)) {
            return -1;
        }

        char[] mutations = {'A', 'C', 'G', 'T'};
        int mutationCount = 0;
        
        // BFS Setup
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        // Level-by-level BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                String gene = queue.poll();
                
                // Found the target!
                if (gene.equals(endGene)) {
                    return mutationCount;
                }

                // Try all possible single-char mutations
                StringBuilder currGene = new StringBuilder(gene);
                for (int index = 0; index < 8; index++) {
                    char original = currGene.charAt(index);
                    
                    for (char mutation : mutations) {
                        currGene.setCharAt(index, mutation);
                        String nextGene = currGene.toString();
                        
                        // Valid mutation found in bank?
                        if (geneBank.contains(nextGene)) {
                            queue.add(nextGene);
                            geneBank.remove(nextGene); // Mark as visited
                        }
                    }
                    currGene.setCharAt(index, original); // Restore
                }
            }
            mutationCount++; // Completed one level = one mutation
        }

        return -1; // No path found
    }
}