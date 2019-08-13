class Solution {
    
    //Method 1: HashMap
//     public int romanToInt(String s) {
//         Map<Character, Integer> mymap = new HashMap<Character, Integer>();
//         mymap.put('I',1);
//         mymap.put('V',5);
//         mymap.put('X',10);
//         mymap.put('L',50);
//         mymap.put('C',100);
//         mymap.put('D',500);
//         mymap.put('M',1000);
        
//         int result = 0;
//         for(Character c: s.toCharArray()){
//             result += mymap.get(c);
//         }
        
//         if(s.contains("IV") || s.contains("IX"))
//             result += -2;
//         if(s.contains("XL") || s.contains("XC"))
//             result += -20;
//         if(s.contains("CD") || s.contains("CM"))
//             result += -200;
        
//         return result;
        
//     }
    
    //Method 2: HashMap
    public int romanToInt(String s) {
        //Step 1: Edge case
        if(s == null || s.length() == 0)
            return 0;
        
        //Step 2: Define variables
        char prev = ' ', c = ' ';
        int result = 0;
        
        //Step 3: Loop into string
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            //Step 4: Set result
            result += getValue(prev, c);
            prev = c;
        }
        
        //Step 5: Return result
        return result; 
    }
    
    private int getValue(char prev, char curr) {
        //Check for the value
        if(prev == 'I'){
            if(curr == 'V')
                return 3;
            else if(curr == 'X')
                return 8;
        }
        
        if(prev == 'X'){
            if(curr == 'L')
                return 30;
            else if(curr == 'C')
                return 80;
        }
        
        if(prev == 'C'){
            if(curr == 'D')
                return 300;
            else if(curr == 'M')
                return 800;
        }
        
        if(curr == 'I')
            return 1;
        if(curr == 'V')
            return 5;
        if(curr == 'X')
            return 10;
        if(curr == 'L')
            return 50;
        if(curr == 'C')
            return 100;
        if(curr == 'D')
            return 500;
        if(curr == 'M')
            return 1000;
        
        return 0;
    }
}