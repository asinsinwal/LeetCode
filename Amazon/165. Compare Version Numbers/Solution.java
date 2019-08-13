class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versioning1 = version1.split("\\.");
        String[] versioning2 = version2.split("\\.");
        
        for(int i = 0; i < Math.max(versioning1.length, versioning2.length); i++){
            int ver_1 = 0;
            int ver_2 = 0;
            
            if(i < versioning1.length)
                ver_1 = Integer.parseInt(versioning1[i]);
            
            if(i < versioning2.length)
                ver_2 = Integer.parseInt(versioning2[i]);
            
            if(ver_1 < ver_2)
                return -1;
            else if(ver_1 > ver_2)
                return 1;
            
        }
        
        return 0;
        // Method 2
//         versioning1[i] = (versioning1[i].replaceFirst("^0+(?!$)", "").length() == 0) ? "0" : versioning1[i].replaceFirst("^0+(?!$)", "");
//         versioning2[j] = (versioning2[j].replaceFirst("^0+(?!$)", "").length() == 0) ? "0" : versioning2[j].replaceFirst("^0+(?!$)", "");
    }
}