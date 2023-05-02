import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.util.*;

class YahtzeeGUI extends JPanel {
   // 1, 2, 3, 4, 5, 6,
   //3ofKind, 4ofKind, FullHouse, ShortStr, LongStr, Yahtzee, Chance
   //Labels
   private JFrame window = new JFrame("Yahtzee!");
   private JTable scoreCard = new JTable(18, 2);
   
   private JTextField txtD1 = new JTextField();
   private JTextField txtD2 = new JTextField();
   private JTextField txtD3 = new JTextField();
   private JTextField txtD4 = new JTextField();
   private JTextField txtD5 = new JTextField();
   
   private JButton ones = new JButton("Play");
   private JButton twos = new JButton("Play");
   private JButton threes = new JButton("Play");
   private JButton fours = new JButton("Play");
   private JButton fives = new JButton("Play");
   private JButton sixes = new JButton("Play");
   private JButton threeK = new JButton("Play");
   private JButton fourK = new JButton("Play");
   private JButton fullHouse = new JButton("Play");
   private JButton shortStr = new JButton("Play");
   private JButton longStr = new JButton("Play");
   private JButton yahtzee = new JButton("Play");
   private JButton chance = new JButton("Play");
   private JButton reroll = new JButton("Roll");
   
   private int temp = 0;
   private int d1, d2, d3, d4, d5;
   private int rollCount = 3;
   
   private JCheckBox ch1 = new JCheckBox("");
   private JCheckBox ch2 = new JCheckBox("");
   private JCheckBox ch3 = new JCheckBox("");
   private JCheckBox ch4 = new JCheckBox("");
   private JCheckBox ch5 = new JCheckBox("");
   
   public YahtzeeGUI(){
      setLayout(null);
      
      //SETS UP SCORECARD, CELLS THAT WONT CHANGE
      scoreCard.setBounds(20, 20, 334, 630);
      scoreCard.setEnabled(false); //makes it readonly
      
      scoreCard.setRowHeight(35);

      scoreCard.setValueAt("<html><h1 style='padding-left: 30px;'>Yahtzee</h1></html>", 0, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 29px;'>Player</h1></html>", 0, 1);
      
      scoreCard.setValueAt("<html><h1 style='padding-left: 40px;'>Ones</h1></html>", 1, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 40px;'>Twos</h1></html>", 2, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 33px;'>Threes</h1></html>", 3, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 38px;'>Fours</h1></html>", 4, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 39px;'>Fives</h1></html>", 5, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 39px;'>Sixes</h1></html>", 6, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 10px;'>Upper Total:</h1></html>", 7, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 18px;'>3 of a Kind</h1></html>", 8, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 18px;'>4 of a Kind</h1></html>", 9, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 18px;'>Full House</h1></html>", 10, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 10px;'>Sm. Straight</h1></html>", 11, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 10px;'>Lrg. Straight</h1></html>", 12, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 28px;'>Yahtzee</h1></html>", 13, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 30px;'>Chance</h1></html>", 14, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 10px;'>Lower Total:</h1></html>", 15, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 4px;'>Upper Bonus:</h1></html>", 16, 0);
      scoreCard.setValueAt("<html><h1 style='padding-left: 10px;'>Total Score:</h1></html>", 17, 0);
      scoreCard.setBorder(new LineBorder(Color.black, 2));
      
      //SETS DICE TXT FIELDS
      txtD1.setBounds(20, 670, 50, 50);
      txtD2.setBounds(80, 670, 50, 50);
      txtD3.setBounds(140, 670, 50, 50);
      txtD4.setBounds(200, 670, 50, 50);
      txtD5.setBounds(260, 670, 50, 50);
      
      txtD1.setEnabled(false);
      txtD2.setEnabled(false);
      txtD3.setEnabled(false);
      txtD4.setEnabled(false);
      txtD5.setEnabled(false);
      
      txtD1.setBorder(new LineBorder(Color.black, 2));
      txtD2.setBorder(new LineBorder(Color.black, 2));
      txtD3.setBorder(new LineBorder(Color.black, 2));
      txtD4.setBorder(new LineBorder(Color.black, 2));
      txtD5.setBorder(new LineBorder(Color.black, 2));
      
      //SETS PLAY BUTTONS
      ones.setBounds(360, 55, 60, 35);
      twos.setBounds(360, 90, 60, 35);
      threes.setBounds(360, 125, 60, 35);
      fours.setBounds(360, 160, 60, 35);
      fives.setBounds(360, 195, 60, 35);
      sixes.setBounds(360, 230, 60, 35);
      threeK.setBounds(360, 300, 60, 35);
      fourK.setBounds(360, 335, 60, 35);
      fullHouse.setBounds(360, 370, 60, 35);
      shortStr.setBounds(360, 405, 60, 35);
      longStr.setBounds(360, 440, 60, 35);
      yahtzee.setBounds(360, 475, 60, 35);
      chance.setBounds(360, 510, 60, 35);
      
      ones.setBorder(new LineBorder(Color.black, 2));
      ones.setBackground(Color.white);
      ones.setFocusPainted(false);
      twos.setBorder(new LineBorder(Color.black, 2));
      twos.setBackground(Color.white);
      twos.setFocusPainted(false);
      threes.setBorder(new LineBorder(Color.black, 2));
      threes.setBackground(Color.white);
      threes.setFocusPainted(false);
      fours.setBorder(new LineBorder(Color.black, 2));
      fours.setBackground(Color.white);
      fours.setFocusPainted(false);
      fives.setBorder(new LineBorder(Color.black, 2));
      fives.setBackground(Color.white);
      fives.setFocusPainted(false);
      sixes.setBorder(new LineBorder(Color.black, 2));
      sixes.setBackground(Color.white);
      sixes.setFocusPainted(false);
      threeK.setBorder(new LineBorder(Color.black, 2));
      threeK.setBackground(Color.white);
      threeK.setFocusPainted(false);
      fourK.setBorder(new LineBorder(Color.black, 2));
      fourK.setBackground(Color.white);
      fourK.setFocusPainted(false);
      fullHouse.setBorder(new LineBorder(Color.black, 2));
      fullHouse.setBackground(Color.white);
      fullHouse.setFocusPainted(false);
      shortStr.setBorder(new LineBorder(Color.black, 2));
      shortStr.setBackground(Color.white);
      shortStr.setFocusPainted(false);
      longStr.setBorder(new LineBorder(Color.black, 2));
      longStr.setBackground(Color.white);
      longStr.setFocusPainted(false);
      yahtzee.setBorder(new LineBorder(Color.black, 2));
      yahtzee.setBackground(Color.white);
      yahtzee.setFocusPainted(false);
      chance.setBorder(new LineBorder(Color.black, 2));
      chance.setBackground(Color.white);
      chance.setFocusPainted(false);
      
      ch1.setBounds(35, 720, 20, 20);
      ch2.setBounds(95, 720, 20, 20);
      ch3.setBounds(155, 720, 20, 20);
      ch4.setBounds(215, 720, 20, 20);
      ch5.setBounds(275, 720, 20, 20);
      
      reroll.setBounds(320, 670, 100, 50);
      
      add(scoreCard);
      add(txtD1);
      add(txtD2);
      add(txtD3);
      add(txtD4);
      add(txtD5);
      
      add(ones);
      add(twos);
      add(threes);
      add(fours);
      add(fives);
      add(sixes);
      add(threeK);
      add(fourK);
      add(fullHouse);
      add(shortStr);
      add(longStr);
      add(yahtzee);
      add(chance);
      add(reroll);
      
      add(ch1);
      add(ch2);
      add(ch3);
      add(ch4);
      add(ch5);
      
      window.add(this);
      
      window.setSize(800, 1000);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      //Sets die value
      YahtzeePlayer p1 = new YahtzeePlayer();
      
      Font f1 = new Font("SansSerif", Font.BOLD, 40);

      txtD1.setFont(f1);
      txtD2.setFont(f1);
      txtD3.setFont(f1);
      txtD4.setFont(f1);
      txtD5.setFont(f1);
      //to change color of dice, may have to change them to labels!!
      
      

      roll();

         
      reroll.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            roll();         
            
//          System.out.println(d1 + "," + d2+ "," + d3 + "," +d4 + "," +d5);
//         
//    
//          System.out.println("1: "+p1.getTopScore(d1, d2, d3, d4, d5, 0));
//          System.out.println("2: "+p1.getTopScore(d1, d2, d3, d4, d5, 1));
//          System.out.println("3: "+p1.getTopScore(d1, d2, d3, d4, d5, 2));
//          System.out.println("4: "+p1.getTopScore(d1, d2, d3, d4, d5, 3));
//          System.out.println("5: "+p1.getTopScore(d1, d2, d3, d4, d5, 4));
//          System.out.println("6: "+p1.getTopScore(d1, d2, d3, d4, d5, 5));
//          
//          System.out.println("3ofK: "+p1.getKindScore(d1, d2, d3, d4, d5, 3));
//          System.out.println("4ofK: "+p1.getKindScore(d1, d2, d3, d4, d5, 4));
//          System.out.println("FH: "+p1.getFullHouseScore(d1, d2, d3, d4, d5));
//          System.out.println("SS: "+p1.getStraightScore(d1, d2, d3, d4, d5, 4));
//          System.out.println("LS: "+p1.getStraightScore(d1, d2, d3, d4, d5, 5));
//          System.out.println("YA: "+p1.getKindScore(d1, d2, d3, d4, d5, 5));
//          System.out.println("CH: "+p1.getChanceScore(d1, d2, d3, d4, d5));
         }
      });
      
      ones.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 0);
            int index=1;
            p1.setUpperScore(temp, 0);
            int sum=p1.getUpperSum();   
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            ones.setEnabled(false);
            ones.setVisible(false);
            repaint();
            resetCheck();
            rollCount = 3;
            roll();
         }
      });
      twos.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 1);
            int index=2;
            p1.setUpperScore(temp, 1);
            int sum=p1.getUpperSum();
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            twos.setEnabled(false);
            twos.setVisible(false); 
            repaint();
            resetCheck();rollCount = 3;
            roll(); 
         }
      });
      threes.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 2);
            int index=3;
            p1.setUpperScore(temp, 2);
            int sum=p1.getUpperSum();
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            threes.setEnabled(false);
            threes.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();            
         }
      });
      fours.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 3);
            int index=4;
            p1.setUpperScore(temp, 3);
            int sum=p1.getUpperSum();
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            fours.setEnabled(false);
            fours.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll(); 
         }
      });
      fives.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 4);
            int index=5;
            p1.setUpperScore(temp, 4);
            int sum=p1.getUpperSum();
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            fives.setEnabled(false);
            fives.setVisible(false);
            repaint(); 
            resetCheck();rollCount = 3;
            roll();
         }
      });
      sixes.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getTopScore(d1, d2, d3, d4, d5, 5);
            int index=6;
            p1.setUpperScore(temp, 5);
            int sum=p1.getUpperSum();
            int bonus = p1.getUpperBonus(sum);
            displayUpper(sum, bonus);
            updateTable(index, temp);
            int lsum = p1.getLowerSum();
            int total = lsum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1); 
            sixes.setEnabled(false);
            sixes.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      
      threeK.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getKindScore(d1, d2, d3, d4, d5, 3);
            int index = 8;
            p1.setKindScore(temp, 0);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            threeK.setEnabled(false);
            threeK.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      fourK.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getKindScore(d1, d2, d3, d4, d5, 4);
            int index=9;
            p1.setKindScore(temp, 1);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            fourK.setEnabled(false);
            fourK.setVisible(false); 
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      fullHouse.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getFullHouseScore(d1, d2, d3, d4, d5);
            int index=10;
            p1.setFullHouseScore(temp);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            fullHouse.setEnabled(false);
            fullHouse.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      shortStr.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getStraightScore(d1, d2, d3, d4, d5, 4);
            int index=11;
            p1.setStraightScore(temp, 3);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp); 
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            shortStr.setEnabled(false);
            shortStr.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      longStr.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getStraightScore(d1, d2, d3, d4, d5, 5);
            int index=12;
            p1.setStraightScore(temp, 4);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            longStr.setEnabled(false);
            longStr.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      yahtzee.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getKindScore(d1, d2, d3, d4, d5, 5);
            int index=13;
            p1.setKindScore(temp, 5);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            yahtzee.setEnabled(false);
            yahtzee.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      chance.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            temp = p1.getChanceScore(d1, d2, d3, d4, d5);
            int index=14;
            p1.setChanceScore(temp);
            int sum=p1.getLowerSum();
            displayLower(sum);
            updateTable(index, temp);
            int usum = p1.getUpperSum();
            int bonus = p1.getUpperBonus(usum);
            int total = usum + sum + bonus;
            scoreCard.setValueAt(total, 17, 1);
            chance.setEnabled(false);
            chance.setVisible(false);
            repaint();
            resetCheck();rollCount = 3;
            roll();
         }
      });
      
      
      
      
   }
   
   public static void main(String[]args){
      new YahtzeeGUI();
   }
   
    public static int rollDice(){
       Random rand = new Random();
       int die;
       
       die = rand.nextInt(6)+1;
       return die;
    }
    
    public void updateTable(int index, int score){
      scoreCard.setValueAt(Integer.toString(score), index, 1);
    }
    
    public void displayUpper(int sum, int bonus){
       scoreCard.setValueAt(Integer.toString(sum), 7, 1);
       scoreCard.setValueAt(Integer.toString(bonus), 16, 1);
       System.out.println("Upper: "+sum);
    }
    
    public void displayLower(int sum){
        scoreCard.setValueAt(Integer.toString(sum), 15, 1);
        System.out.println("Lower: "+sum);
    }
    
    public void roll(){
      if(rollCount > 0){
         if(!ch1.isSelected()) d1 = rollDice();
         if(!ch2.isSelected()) d2 = rollDice();
         if(!ch3.isSelected()) d3 = rollDice();
         if(!ch4.isSelected()) d4 = rollDice();
         if(!ch5.isSelected()) d5 = rollDice();
   
         txtD1.setText(Integer.toString(d1));
         // txtD1.setFont(f1);
         txtD2.setText(Integer.toString(d2));
         // txtD2.setFont(f1);
         txtD3.setText(Integer.toString(d3));
         // txtD3.setFont(f1);
         txtD4.setText(Integer.toString(d4));
         // txtD4.setFont(f1);
         txtD5.setText(Integer.toString(d5));
         // txtD5.setFont(f1);
         rollCount--;
      }
    }
    
    public void resetCheck(){
       ch1.setSelected(false);
       ch2.setSelected(false);
       ch3.setSelected(false);
       ch4.setSelected(false);
       ch5.setSelected(false);
    }
    
}