
//Add Bonuses and Total via method



class YahtzeePlayer{

   private String[] upperScore = new String[6];
   private String[] lowerScore = new String[7];
   private int uSum = 0;
   private int lSum = 0;

   public YahtzeePlayer(){
      
      for(int i = 0; i < upperScore.length; i++){
         upperScore[i] = "";
      }
      for(int i = 0; i < lowerScore.length; i++){
         lowerScore[i] = "";
      }
   }
   
//    Upper Array
//    0 = One's
//    1 = Two's
//    2 = Three's
//    3 = Four's
//    4 = Five's
//    5 = Six's
//    
//    Lower Array
//    0 = 3 of Kind
//    1 = 4 of Kind
//    2 = Full House
//    3 = Small Straight
//    4 = Large Straight
//    5 = Yahtzee
//    6 = Chance
   
   
   public int getTopScore(int d1, int d2, int d3, int d4, int d5, int index){
      
      int sum = 0;
      int[] dice = {d1, d2, d3, d4, d5};
      
      for(int i = 0; i < 5; i++){
         if(dice[i] == index + 1){
            sum += index + 1;
         }
      }
      return sum;
      
   }
   
   public int getKindScore(int d1, int d2, int d3, int d4, int d5, int num){
      
      int index = 0, sum = 0;
      
      if(num == 3) index = 0;
      else if(num == 4) index = 1;
      else if(num == 5) index = 5;
      
      int[] diceArray = {0,0,0,0,0,0};
      int[] dice = {d1, d2, d3, d4, d5};
      
      for(int i = 0; i < 5; i++){
         diceArray[dice[i]-1]++;
      }
      
      if(index == 0 || index == 1){
         
         for(int i = 0; i < 5; i++){
            if(diceArray[i] >= num){
               sum = (i+1)*num;
               break;
            }
         }
         return sum;
      }
      
      else if(index == 5){
         for(int i = 0; i < 5; i++){
            if(diceArray[i] >= num){
               return 50;
            }
         }
      }
      return 0;
   }
   
   public int getFullHouseScore(int d1, int d2, int d3, int d4, int d5){
      
      int indexOf3 = -1;
      int[] diceArray = {0,0,0,0,0,0};
      int[] dice = {d1, d2, d3, d4, d5};
      
      for(int i = 0; i < 5; i++){
         diceArray[dice[i]-1]++;
      }
      
      for(int i = 0; i < 5; i++){
         if(diceArray[i] == 3){
            for(int j = 0; j < 5; j++){
               if(diceArray[j] == 2){
                  return 25;
               }
            }
            break;
         }
      }
      return 0;
   }
   
   public int getStraightScore(int d1, int d2, int d3, int d4, int d5, int num){
      
      int count = 0;
      int[] diceArray = {0,0,0,0,0,0};
      int[] dice = {d1, d2, d3, d4, d5};
      
      for(int i = 0; i < 5; i++){
         diceArray[dice[i]-1]++;
      }
      
      for(int i = 0; i < 5; i++){
         if(diceArray[i] >= 1) count++;
         if(diceArray[i] < 1) count = 0;
         if(count == num){
            if(num == 4) return 30;
            else if(num == 5) return 40;
         }
      }
      return 0;
   }
   
   public int getChanceScore(int d1, int d2, int d3, int d4, int d5){
      int sum = d1 + d2 + d3 + d4 + d5;
      return sum;
   }
   
   public String[] getUpperScore(){
      return upperScore;
   }
   
   public String[] getLowerScore(){
      return lowerScore;
   }
   
   public void setUpperScore(int score, int index){
      upperScore[index] = Integer.toString(score);
   }
   
   public void setKindScore(int score, int index){
      lowerScore[index] = Integer.toString(score);
   }
   
   public void setFullHouseScore(int score){
      lowerScore[2] = Integer.toString(score);
   }
   
   public void setStraightScore(int score, int index){
      lowerScore[index] = Integer.toString(score);
   }
   
   public void setChanceScore(int score){
      lowerScore[6] = Integer.toString(score);
   }
   
   public int getUpperSum(){
      uSum = 0;
      for(int i=0; i<upperScore.length; i++){
         if(upperScore[i] == ""){
            upperScore[i] = "0";
         }
         uSum += Integer.parseInt(upperScore[i]);
      }
      return uSum;
   }
   
   public int getLowerSum(){
      lSum = 0;
      for(int i=0; i<lowerScore.length; i++){
         if(lowerScore[i] == ""){
            lowerScore[i] = "0";
         }
         lSum += Integer.parseInt(lowerScore[i]);
         System.out.println(lowerScore[i]);
      }
      return lSum;
   }
   
   public int getUpperBonus(int sum){
      if(sum > 62) return 35;
      else return 0;
   }
   
   public int getTotal(int uSum, int lSum, int bonus){
         int total = uSum + lSum + bonus;
         return total;
    }
   
}