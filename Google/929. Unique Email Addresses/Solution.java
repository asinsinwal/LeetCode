class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0)
            return 0;
        
        Set<String> unique = new HashSet<>();
        
        // Define variable for internal 
        String[] parts;
        String actual_email;
        int index = -1;
        
        for(int i = 0; i < emails.length; i++){
            parts = emails[i].split("@");
            
            // check parts for email ids
            if(parts.length > 2)
                continue;
            
            actual_email = parts[0];
            actual_email = actual_email.replace(".","");
            index = actual_email.indexOf('+');
            if(index != -1)
                actual_email = actual_email.substring(0, index);
            
            actual_email = actual_email + "@" + parts[1];
            System.out.println(actual_email);
            unique.add(actual_email);
        }
        
        
        return unique.size();
    }
}