/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.io.*; 
import java.awt.*;  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author Zizo
 */

class Theif extends JPanel {
     int numOfHouse;
    JLabel EnterNoOFHouses;
    JTextField money;
    JButton Enter;
    int count;
    JLabel EnterMoneyForHouse;
    JTextField MoneyForHouse;
    JButton Submit;
    ArrayList<Integer> MoneyInHouses;
    
    JLabel MoneyInArray;
    JLabel m;
  Integer[] arr;

 JLabel getTotalMoney;
  
   public  Theif(){
       MoneyInHouses=new ArrayList();
       count=2;
        setLayout(null);
        money = new JTextField("");
        money.setBounds(170, 42, 200,20);
        add(money);
        EnterNoOFHouses=new JLabel("Enter Number of Houses: ");
        EnterNoOFHouses.setBounds(20, 40, 180,20);
        add(EnterNoOFHouses);
        Enter = new JButton("submit");
        Enter.setBounds(400, 42, 75,20);
        add(Enter);
        Enter.addActionListener(new newAction());
        
        MoneyForHouse = new JTextField("");
        MoneyForHouse.setBounds(170, 80, 200,20);
        EnterMoneyForHouse=new JLabel("Enter Money for Houses 1 : ");
        EnterMoneyForHouse.setBounds(20, 80, 180,20);
        Submit = new JButton("submit");
        Submit.setBounds(400, 80, 80,20);
        Submit.addActionListener(new entermoney());
        
        MoneyInArray =new JLabel("");
        MoneyInArray.setBounds(190, 152, 180,20);

        m = new JLabel("Money in The Houses Now : ");
        m.setBounds(20, 150, 180,20);
        
 
       getTotalMoney = new JLabel("");
       getTotalMoney.setBounds(20, 250, 200,20);

        
    }
    class newAction implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
         numOfHouse=Integer.parseInt(money.getText());
         money.setText(money.getText());
         add(MoneyForHouse);
         add(EnterMoneyForHouse);
         add(Submit);
         add(m);
         add(MoneyInArray);
           add(getTotalMoney);
           
         repaint();
        }
    }
    
 
    
     class entermoney implements ActionListener{
      public void actionPerformed(ActionEvent arg0) {
          if(count<numOfHouse+2){
         MoneyInHouses.add(Integer.parseInt(MoneyForHouse.getText()));
       MoneyInArray.setText(MoneyInArray.getText()+Integer.parseInt(MoneyForHouse.getText())+",");
      EnterMoneyForHouse.setText("Enter Money for House  " + count + ": ");
      count++;
      MoneyForHouse.setText("");
      
      }
          if(count>=numOfHouse+2){
              
      
      int moneyArr[]=new int[MoneyInHouses.size()];
      
      for(int j=0;j<MoneyInHouses.size();j++){
          moneyArr[j]=MoneyInHouses.get(j);
      }
      getTotalMoney.setText("Total Money Can be Stolen :  "+steal(moneyArr));
          }
        }  }
     
    
    
    
    
    public int steal(int[] Houses){
        if(Houses.length==0){
            return 0;
        }else if (Houses.length==1){
        return Houses[0];
        }
        int[] maxStolenMoney=new int[Houses.length+1];
        maxStolenMoney[0]=0;
        maxStolenMoney[1]=Houses[0];
        for(int i=1;i<Houses.length;i++){
            maxStolenMoney[i+1]=Math.max(maxStolenMoney[i],maxStolenMoney[i-1]+Houses[i]);
            if(maxStolenMoney[i]>(maxStolenMoney[i-1]+Houses[i])){
                
            maxStolenMoney[i+1]=maxStolenMoney[i];

            }else{
            maxStolenMoney[i+1]=(maxStolenMoney[i-1]+Houses[i]);   

            

            }
            }
        
     return maxStolenMoney[Houses.length];
      
    }
 
}

public class JavaApplication3 {

    public static void main(String[] args) {
                Theif theif = new Theif();

        JFrame jf=new JFrame();
            
        jf.setSize(600, 600);
        jf.add(theif);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        int[] a = {10, 30, 20, 40};
        
    }
    
}
