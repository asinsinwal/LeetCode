class Solution {
    // Combination
    public String mostCommonWord(String paragraph, String[] banned) {
        // Clean data -> modify paragraph string
        String[] punctuations = new String[]{"!", "?", ".", ",", "\\", "'", ";"};
        
        for(int i = 0; i < punctuations.length; i++){
            paragraph = paragraph.replace(punctuations[i], " ");
        }
        
        
        paragraph = paragraph.toLowerCase();
        // System.out.println(paragraph);
        // DS for banned elements
        Set<String> bannedW = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> frequency = new HashMap<>();
        
        String result = "";
        int max_freq = 0;
        
        String[] list = paragraph.split(" ");
        // System.out.println(Arrays.toString(list));
        
        for(int i = 0; i < list.length; i++){
            if(list[i].trim().length() == 0)
                continue;
            if(!bannedW.contains(list[i])){
                frequency.put(list[i], frequency.getOrDefault(list[i], 0) + 1);
                
                if(frequency.get(list[i]) > max_freq){
                    max_freq = frequency.get(list[i]);
                    result = list[i];
                }
            }
        }
        
        return result;
    }
}