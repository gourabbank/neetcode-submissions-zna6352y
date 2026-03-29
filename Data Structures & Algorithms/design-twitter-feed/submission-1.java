class Twitter {
    Map<Integer,Set<Integer>> followings;
    Map<Integer, List<int[]>> tweets;
    int time;
    public Twitter() {
        this.followings=new HashMap<>();
        this.tweets=new HashMap<>();
        this.time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId))
        {
            tweets.put(userId,new ArrayList<>());
        }
        tweets.get(userId).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->b[0]-a[0]
        );
        List<Integer> sol=new ArrayList<>();
        if(tweets.containsKey(userId))
        {
            for(int[] tweet:tweets.get(userId))
            {
                pq.offer(tweet);
            }
        }
        if(followings.containsKey(userId))
        {
            for(int followee:followings.get(userId))
            {
                if(tweets.containsKey(followee))
                {
                    for(int[] tweet:tweets.get(followee))
                    {
                        pq.offer(tweet);
                    }
                }
            }
        }
        int count=0;
        while(!pq.isEmpty() && count<10)
        {
            sol.add(pq.poll()[1]);
            count++;
        }
        return sol;
    }
    
    public void follow(int followerId, int followeeId) {
    if (followerId == followeeId) return;

    if (!followings.containsKey(followerId)) {
        followings.put(followerId, new HashSet<>());
    }
    followings.get(followerId).add(followeeId);
}
    
    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) 
        {
            followings.get(followerId).remove(followeeId);
        }
    }
}
