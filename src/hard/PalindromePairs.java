package hard;

import java.util.*;

/**
 * Created by danny on 16/6/1.
 */
public class PalindromePairs {
    public static void main(String args[]){
//        String[] words =  {"bat","tab","cat"};
//        String[] words =  {"abcd", "dcba", "lls", "s", "sssll"};
//        String[] words =  {"bat","ab"};
        String[] words =  {"aba","aba"};
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> results = palindromePairs.palindromePairs(words);
        for (List<Integer> result:results){
            System.out.println(result.get(0)+" "+result.get(1));
        }

//        System.out.println("smiles".substring(0));


    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //全部words放到map里面,words 做key 去重复
        for(int i=0;i<words.length;i++) {
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++) {
            String s = words[i];
            //{"lls","s"}
            for(int k=0;k<=s.length();k++) {
                String prefix = s.substring(0,k);
                String suffix = s.substring(k);
                //前缀是回文;map里面包含前缀的的回文；并且回文不是自己,去除相同串的情况(整个word){}
                //防止输出{1,1}
                if(isPal(prefix) && map.containsKey(reverse(suffix)) &&
                        map.get(reverse(suffix)) != i) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    //得到后缀的位置
                    tmp.add(map.get(reverse(suffix)));
                    tmp.add(i);
                    res.add(tmp);
                }
            }

            //{"bat","ab"} －> {"tab","ab"}
            s = reverse(words[i]);
            for(int k=0;k<=s.length();k++) {
                String prefix = s.substring(0,k);
                String suffix = s.substring(k);
                //是否回文,包含后缀（不需要反转）
                if(isPal(prefix) && map.containsKey(suffix) &&
                        map.get(suffix) != i) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(map.get(suffix));
                    res.add(tmp);
                }
            }

        }
        List<List<Integer>> retVal =new ArrayList<List<Integer>>();
        for(List<Integer> l:res) {
            retVal.add(l);
        }
        return retVal;
    }
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public boolean isPal(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j))return false;
        }
        return true;
    }
}
