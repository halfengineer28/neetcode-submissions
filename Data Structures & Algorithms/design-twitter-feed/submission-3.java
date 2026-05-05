class Twitter {
    private int timestamp;
    private Map<Integer, Set<Integer>> users;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        this.timestamp = 0;
        this.users = new HashMap<>();
        this.tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>());
        tweets.get(userId).add(new int[] {tweetId, timestamp++});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        if (tweets.containsKey(userId)){
            for (int [] tweet : tweets.get(userId)){
                pq.add(tweet);
            }
        }

        if (users.containsKey(userId)){
            for (int followeeId : users.get(userId)){
                if(followeeId == userId){
                    continue;
                }
                if (tweets.containsKey(followeeId)){
                    for (int [] tweet : tweets.get(followeeId)){
                        pq.add(tweet);
                    }
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < 10){
            feed.add(pq.poll()[0]);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, k -> new HashSet<>());
        users.get(followerId).add(followeeId);
        
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)){
            users.get(followerId).remove(followeeId);
        }
    }
}
