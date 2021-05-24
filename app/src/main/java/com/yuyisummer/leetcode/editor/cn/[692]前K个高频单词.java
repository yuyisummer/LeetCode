//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 262 👎 0


import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        /*还是需要HashMap存值*/
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        /*
         * PriorityQueue类在Java1.5中引入。
         * PriorityQueue是基于优先堆的一个无界队列，
         * 这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器） 在队列实例化的时排序。
         * 要求使用Java Comparable和Comparator接口给对象排序，
         * 并且在排序时会按照优先级处理其中的元素。
         * */
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<Map.Entry<String, Integer>>
                        (new Comparator<Map.Entry<String, Integer>>() {
                            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
                            }
                        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        /*反转ret数组*/
        Collections.reverse(ret);
        return ret;
    }

//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> cnt = new HashMap<String, Integer>();
//
//        for (String word : words) {
//            /*塞入默认值*/
//            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
//        }
//
//        List<String> rec = new ArrayList<String>();
//        /*获得不重复字符串*/
//        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
//            rec.add(entry.getKey());
//        }
//
//        /*出现频率排序*/
//        Collections.sort(rec, new Comparator<String>() {
//            public int compare(String word1, String word2) {
//                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
//            }
//        });
//
//        return rec.subList(0, k);
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
