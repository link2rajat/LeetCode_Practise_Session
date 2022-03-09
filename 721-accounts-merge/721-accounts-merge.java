//https://www.youtube.com/watch?v=J5YnIxbG3hw&ab_channel=happygirlzt ,https://leetcode.com/problems/accounts-merge/discuss/109158/Java-Solution-(Build-graph-%2B-DFS-search)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String,Set<String>> mailGraph = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        buildmailGraph(accounts,mailGraph,emailToName);
        Set<String> visitedEmailSet = new HashSet<>();
        for(String email : emailToName.keySet())
        {
            if(visitedEmailSet.add(email))
            {
                List<String> currentMailList = new ArrayList<>();
                currentMailList.add(email);
                buildEmailListformGraphDFS(currentMailList,visitedEmailSet,email,mailGraph);
                Collections.sort(currentMailList);
                currentMailList.add(0,emailToName.get(email));
                result.add(currentMailList);
            }
        }
        return result;
    }
    
    void buildmailGraph(List<List<String>> accounts,Map<String,Set<String>> mailGraph,Map<String,String> emailToName)
    {
        for(List<String> account: accounts)
        {
            String uName= account.get(0);
            for(int mailCount=1;mailCount<account.size();mailCount++)
            {
                String currentEmail = account.get(mailCount);
                emailToName.put(currentEmail,uName);
                mailGraph.putIfAbsent(currentEmail,new HashSet<String>());
                if(mailCount==1)continue;
                String previousEmail = account.get(mailCount-1);
                mailGraph.get(previousEmail).add(currentEmail);
                mailGraph.get(currentEmail).add(previousEmail);
            }
        }
        
    }
    
    void buildEmailListformGraphDFS(List<String> currentMailList,Set<String> visitedEmailSet,String email,Map<String,Set<String>> mailGraph)
    {
        if(mailGraph.get(email)==null ||mailGraph.get(email).size()==0)return;
        
        for(String neighbourMailsinGraph : mailGraph.get(email))
        {
            if(visitedEmailSet.add(neighbourMailsinGraph))
            {
                currentMailList.add(neighbourMailsinGraph);
                buildEmailListformGraphDFS(currentMailList,visitedEmailSet,neighbourMailsinGraph,mailGraph);
            }
        }
        
    }
}