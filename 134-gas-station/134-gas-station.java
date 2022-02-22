class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int circuitLength=gas.length;
        
        int total_tank_capacity=0;
        int current_tank_capacity =0;
        int start_station=0;
      
     for(int index=0;index<circuitLength;index++)
        {
           total_tank_capacity+=gas[index]-cost[index];
           current_tank_capacity+=gas[index]-cost[index];
           
            if(current_tank_capacity<0)
            {
              start_station =  index+1; 
                current_tank_capacity =0;
            }
        }
        return total_tank_capacity>=0 ? start_station:-1;
    }
}//T-O(N),S-O(1)