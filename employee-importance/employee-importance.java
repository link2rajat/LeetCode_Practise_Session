/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap();
        for(Employee e : employees)map.put(e.id,e);
        return importancedfs(id);
      
    }
    
    
    int importancedfs(int id)
    {
        Employee e = map.get(id);
        
        int importance = e.importance;
        
        for(Integer subID: e.subordinates)
        {
            importance+=importancedfs(subID);
        }
        return importance;
    }
}//T-O(N),S-O(N)