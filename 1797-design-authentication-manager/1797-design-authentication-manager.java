class AuthenticationManager {
    
    int time=0;
    HashMap<String,Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        
        time=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
       
            map.put(tokenId,currentTime+time); 
       
    }
    
    public void renew(String tokenId, int currentTime) {
      if(!map.containsKey(tokenId) || map.get(tokenId)<=currentTime) {
          return;
      }
          map.put(tokenId,currentTime+time); 
    }
    
    public int countUnexpiredTokens(int currentTime) {
        List<String> tokens = new ArrayList(map.keySet());
        
        for(String token:tokens){
            if(map.get(token)<=currentTime){
                map.remove(token);
            }
        }
        return map.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */