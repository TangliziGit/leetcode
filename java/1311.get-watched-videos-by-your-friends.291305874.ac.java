class Solution {
    

    private int[][] next;
    private List<List<String>> elem;

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        this.next = friends;
        this.elem = watchedVideos;
        Map<String, Integer> map = new HashMap<>();
        int[] dis = new int[next.length];

        dij(id, dis);
        for (int i = 0; i<next.length; i++)
            if (dis[i] == level) merge(map, i);

        return map.entrySet().stream()
                .sorted(this::compare)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void merge(Map<String, Integer> map, int id) {
        for (String s: elem.get(id)) {
            map.computeIfAbsent(s, x -> 0);
            map.computeIfPresent(s, (k, v) -> v+1);
        }
    }

    private int compare(Map.Entry<String, Integer> x, Map.Entry<String, Integer> y) {
        Integer xv = x.getValue(), yv = y.getValue();
        if (xv.equals(yv)) return x.getKey().compareTo(y.getKey());
        return xv.compareTo(yv);
    }

    private void dij(int start, int[] dis) {
        PriorityQueue<Pair> que = new PriorityQueue<>();

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        que.add(new Pair(start, 0));

        while (!que.isEmpty()) {
            Pair from = que.poll();

            if (from.second != dis[from.first]) continue;
            // System.out.println(from.first + ", " + from.second);
            for (int to: next[from.first]) {
                if (dis[to] < dis[from.first] + 1) continue;
                dis[to] = dis[from.first] + 1;

                que.add(new Pair(to, dis[to]));
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        public int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(second, o.second);
        }
    }

}


