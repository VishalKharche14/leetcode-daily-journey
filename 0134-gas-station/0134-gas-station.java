class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel_in_tank = 0 ;
        int total_fuel_required = 0 ;
        int starting_station = 0 ;
            
        for(int i = 0 ; i < gas.length ; i++){
            int curr_fuel_required = gas[i] - cost[i] ;
            fuel_in_tank += curr_fuel_required ;
            if(fuel_in_tank < 0){
                fuel_in_tank = 0 ;
                starting_station = i + 1 ;
            }
            total_fuel_required += curr_fuel_required ;
        }
        
        return total_fuel_required < 0 ? -1 : starting_station ;
    }
}