Practice:
main.model:
-creating Box, HeavyBox;
    *HeavyBox extends Box implements Comparable<HeavyBox>
    *    @Override
         public int compareTo(HeavyBox o) {
             int k = Integer.compare(weight, o.weight);
             if(k != 0)return k;
             return Double.compare(getVolume(), o.getVolume());
         }

test.model:
-creating TestCollections;
1)(tests 1-7)
-creating ArrayList<HeavyBox>;
-testing ArrayList in accordance of test task;
    *using available methods for this type of collection;
    *lambda, streams;
2)(tests 8-13)
-BufferedReader for read Text.txt;
-save into ArrayList, and testing in accordance of the task;

test.exercises:
-creating Exercises;
-BufferedReader for read SonnetI.txt;
-testing result of reading;