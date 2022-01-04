/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class EmployeeInterval{
    Interval interval;
    int employeeIndex;
    int intervalIndex;
    
    public EmployeeInterval(Interval interv, int empIdx,int intIdx)
    {
        interval = interv;
        employeeIndex = empIdx;
        intervalIndex = intIdx;       
    }
    
}
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    
      PriorityQueue<EmployeeInterval> minHeap = new  PriorityQueue<EmployeeInterval>((a,b)->a.interval.start-b.interval.start);
        
    for(int i=0;i<schedule.size();i++)
    {
        List<Interval> employee = schedule.get(i);
        EmployeeInterval employeeInterval = new EmployeeInterval(employee.get(0),i,0);
        minHeap.offer(employeeInterval);
    }
        
        List<Interval> freeInterval = new ArrayList<>();
        EmployeeInterval prevEmpItr = minHeap.peek();
        
        while(!minHeap.isEmpty())
        {
            EmployeeInterval currentEmpItr = minHeap.poll();
 
            
            if(prevEmpItr.interval.end>=currentEmpItr.interval.start)
            {
                prevEmpItr.interval.end = Math.max(prevEmpItr.interval.end,currentEmpItr.interval.end);
            }
            else
            {
                if(prevEmpItr != currentEmpItr)
                {
                   freeInterval.add( new Interval(prevEmpItr.interval.end,currentEmpItr.interval.start));
                   prevEmpItr = currentEmpItr;
                }
            }
            if(hasNext(currentEmpItr,schedule))
            {
              minHeap.offer(nextInterval(currentEmpItr,schedule));  
            }
        }
        return freeInterval;
    }//T-O(NlogK),S-O(K)
    
    boolean hasNext(EmployeeInterval ei,List<List<Interval>> schedule)
    {
       return schedule.get(ei.employeeIndex).size()> ei.intervalIndex +1; 
    }
    
    EmployeeInterval nextInterval(EmployeeInterval ei,List<List<Interval>> schedule)
    {
    int employeeIndex= ei.employeeIndex;
    int intervalIndex= ei.intervalIndex+1;
    Interval interval = schedule.get(employeeIndex).get(intervalIndex);
        
        return new EmployeeInterval(interval,employeeIndex,intervalIndex);

    }
    
}