/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        // My logic
    //     public int findCelebrity(int n) {
    //         int candidate = 0;
    //         boolean[] checked = new boolean[n];
            
    //         int result = 0, flag = 0;
            
    //         while(candidate < n && checked[candidate] == false){
    //             result = candidate;
    //             checked[candidate] = true;
    //             flag = 0;
                
    //             for(int i = 0; i < n; i++){
    //                 System.out.println(candidate + "\t" + i);
    //                 if(i == candidate)
    //                     continue;
    //                 if(knows(candidate, i)){
    //                     if(checked[i] == true && i < n){
    //                         flag = 1;
    //                         continue;
    //                     }else{
    //                         candidate = i;
    //                         flag = 1;
    //                         break;
    //                     }
    //                 }else if(flag == 0 && !knows(i, candidate))
    //                     result = -1;   
    //             }
    //         }
            
    //         if(flag == 1){
    //             return -1;
    //         }
            
    //         return result;
    //     }
        
        // simple logic
        public int findCelebrity(int n) {
            int candidate = 0;
            
            for(int i = 1; i < n; i++){
                if(knows(candidate, i))
                    candidate = i;
            }
            
            for(int j = 0; j < candidate; j++){
                if(knows(candidate, j))
                    return -1;
            }
            
            for(int k = 0; k < n; k++){
                if(!knows(k, candidate))
                    return -1;
            }
            
            return candidate;
        }
    }