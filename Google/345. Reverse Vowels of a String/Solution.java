class Solution {
    public String reverseVowels(String s) {
        // Define 2 pointers
        int ptr1 = 0, ptr2 = s.length()-1;
        char[] char_arr = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        // temp char variable
        char temp = ' ';
        
        while(ptr1 < ptr2){
            if(ptr1 != ptr2 && vowels.contains(char_arr[ptr1]) && vowels.contains(char_arr[ptr2])){
                //swap(char_arr, ptr1, ptr2);
                temp = char_arr[ptr1];
                char_arr[ptr1] = char_arr[ptr2];
                char_arr[ptr2] = temp;
                ptr1++;
                ptr2--;
            }
            
            if(!vowels.contains(char_arr[ptr1]))
                ptr1++;
            if(!vowels.contains(char_arr[ptr2]))
                ptr2--;
        }
        
        return String.valueOf(char_arr);
    }
}