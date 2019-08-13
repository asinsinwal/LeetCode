public class Codec {
    
    String alpha_num = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap<>();
    
    Random random = new Random();
    String key = getRandomKey();
    
    private String getRandomKey(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++){
            sb.append(alpha_num.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key)){
            key = getRandomKey();
        }
        map.put(key, longUrl);
        System.out.println("http://tinyurl.com/" + key);
        return ("http://tinyurl.com/" + key);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/",""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));