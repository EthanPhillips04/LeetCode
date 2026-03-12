class Solution {
    public boolean isValidSerialization(String s) {
        String str[]=s.split(",");
        int v = 1;
        for(int i=0;i<str.length;i++){
            if(str[i].equals("#")){
                if(v==0)
                return false;
               v=v-1;
            }else{
                if(v==0)
                return false;
                v=v-1;
                v=v+2;
            }
        }
        if(v==0){
            return true;
        }
        else{
            return false;
        }
    }
}