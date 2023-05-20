//https://leetcode.com/problems/evaluate-division/solution/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
     
        for(int i=0;i<equations.size();i++)
        {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];
            graph.putIfAbsent(dividend,new HashMap<String,Double>());   
            graph.putIfAbsent(divisor,new HashMap<String,Double>());
            graph.get(dividend).put(divisor,quotient);
            graph.get(divisor).put(dividend,1/quotient);
        }

        double[] result = new double[queries.size()];
        
        
        for(int i=0;i<queries.size();i++)
        {
            List<String> querie = queries.get(i);
            
            String dividend = querie.get(0), divisor = querie.get(1);
            if(!graph.containsKey(dividend)|| !graph.containsKey(divisor))
            {
                result[i] = -1.0 ;
            }
            else if(dividend.equals(divisor))
            {
                result[i] = 1.0 ;
            }
            else
            {
            HashSet<String> visited = new HashSet<>();
            result[i] = dfssearch(graph,dividend,divisor,visited,1.0);
            }
        }
        return result;
    }
    
   private double dfssearch(HashMap<String,HashMap<String,Double>> graph,String currentval,String targetval,Set<String> visited,double recurval)
    {
        // mark the visit
        visited.add(currentval);
        double res = -1.0;
        
        HashMap<String,Double> neighbour = graph.get(currentval);
        
        if(neighbour.containsKey(targetval))
        {
         res = recurval*neighbour.get(targetval);     
        }
        else
        {
        for(Map.Entry<String,Double> entry : neighbour.entrySet())
        {
            String nextNode = entry.getKey();
            if(visited.contains(nextNode))
               continue; 
                res = dfssearch(graph,nextNode,targetval,visited,recurval*entry.getValue());
                    if(res!=-1.0)
                        break;
        }
        }
          // unmark the visit, for the next backtracking
        visited.remove(currentval);
        return  res;
    }
    
 
}