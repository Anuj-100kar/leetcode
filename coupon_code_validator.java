class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>order=Arrays.asList(
            "electronics","grocery","pharmacy","restaurant"
        );

        Map<String,List<String>>map=new HashMap<>();
        for(String c:order){
            map.put(c,new ArrayList<>());
        }

        for(int i=0;i<code.length;i++){
            if(!isActive[i])continue;

            if(!map.containsKey(businessLine[i]))continue;

            String str=code[i];
            if(str==null || str.length()==0)continue;

            boolean isvalid=true;
            for(int j=0;j<str.length();j++){
                char ch=str.charAt(j);

                if(!((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9') || ch=='_')){
                    isvalid=false;
                    break;
                }
            }
            if(isvalid){
                map.get(businessLine[i]).add(str);
            }
        }
        List<String>ans=new ArrayList<>();
        for(String b:order){
            List<String>list=map.get(b);
            Collections.sort(list);
            ans.addAll(list);
        }
        return ans;
    }
}
