package cn.kidd.algorithm;

public class ReverseNum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int data = reverse(123);
    System.out.println(data);
  }
  
  public static int reverse(int x) {
    if(x % 10 == 0){
      x = x / 10;
    }
    boolean flag = true;
    if(x < 0){
      flag = false;
    }
    String numText = (x+"").replaceAll("-", "");
    int left=0;
    int right = numText.length()-1;
    char[] data = numText.toCharArray();
    while(left < right){
      char tempChar = data[left];
      data[left] = data[right];
      data[right] = tempChar;
      left++;
      right--;
    }
    numText = "";
    for(int i=0;i<data.length;i++){
      numText = numText + data[i];
    }
    //判断越界大小
    Integer maxText = Integer.MAX_VALUE;
    Integer minText = Integer.MIN_VALUE;
    boolean breakFlag = false;
    if(numText.length() == 10){
      String MaxText = maxText+"";
      String MinText = minText+"";
      MinText = MinText.replace("-", "");
      for(int i=0;i<numText.length();i++){
        int num = Integer.parseInt(numText.charAt(i)+"");
        if(flag){
          int maxnum = Integer.parseInt(MaxText.charAt(i)+"");
          if(num > maxnum){
            breakFlag = true;
            break;
          }
        } else {
          int minnum = Integer.parseInt(MinText.charAt(i)+"");
          if(num > minnum){
            breakFlag = true;
            break;
          }
        }
      }
    }
    if(breakFlag){
      return 0;
    }
    Integer min = Integer.parseInt(numText);
    if(!flag){
      min = min * (-1);
    }
    return min;
  }
  
  /**
   * 求余乘10
   * @param x
   * @return
   */
  public int reverse2(int x) {
    int rev = 0;
    while (x != 0) {
        int pop = x % 10;
        x /= 10;
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        rev = rev * 10 + pop;
    }
    return rev;
}
  
}
