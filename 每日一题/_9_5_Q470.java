package 每日一题;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

 /**
  * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

  */
class Solution extends SolBase {
    public int rand10() {
        int randNum = rand7();
        //标志位表示选择1-5还是6-10
        boolean halfChoose = false;
        while(true){
            if(randNum == 4){
                randNum = rand7();
            } else if(randNum < 4){
                halfChoose = true;
                break;
            }else{
                break;
            }
        }

        randNum = rand7();
        while(randNum > 5){
            randNum = rand7();
        }
        //halfChoose表示选择1-5这一半
        if(halfChoose){
            return randNum;
        }else{
            return randNum + 5;
        }
    }
}

public class _9_5_Q470 {
    
}
