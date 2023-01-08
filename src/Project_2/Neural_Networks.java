/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_2;

import java.text.DecimalFormat;

/**
 *
 * @author raedk
 */
public class Neural_Networks {
    
    //perceptron 
    double w1;
    double w2;
    double threshold;
    /////////////////////
    //Multilayer
    double w11;
    double w12;
    double w21;
    double w22;
    double w3;
    double w4;
    double threshold3;
    double threshold4;
    double threshold5;
    double Ya3,Ya4,Ya5;
    double XY3,XY4,XY5;
    double AW11,AW12,AW21,AW22,AW3,AW4 ;
     double Athreshold3,Athreshold4,Athreshold5;
     double GE5,GE4,GE3;
    /////////////////////initialization
    public void Perceptron_initialization(){
         DecimalFormat d=new DecimalFormat("#.##");
     w1=Double.parseDouble(d.format((Math.random() *(0.5 - 0.5 +1) + -0.5)));
     w2=Double.parseDouble(d.format((Math.random() *(0.5 - 0.5 +1) + -0.5)));
     threshold=Double.parseDouble(d.format(Math.random() *(0.5 - 0.5 +1) + -0.5));
    }
    public void Multilayer_initialization(){
     DecimalFormat d=new DecimalFormat("#.####");
     w11=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     w12=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     w21=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     w22=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     w3=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     w4=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     threshold3=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     threshold4=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
     threshold5=Double.parseDouble(d.format((Math.random() *(1.2 + 1.2 ) + -1.2)));
    }
    
    public  double Perceptron(int x1,int x2,int Yd,double LER){
      DecimalFormat d=new DecimalFormat("#.##");
    System.out.println("w1: "+w1+" "+"w2: "+w2+" "+"threshold: "+threshold+" ");
    double LR=LER;
    double X=(x1*w1)+(x2*w2)+threshold;
    double Ya;
    Ya=step_function(X);
    double error=Yd-Ya;
    double AW1,AW2,Athreshold;
    AW1=LR*x1*error;
    AW2=LR*x2*error;
    Athreshold=LR*1*error;
    w1=Double.parseDouble(d.format(w1+AW1));
    w2=Double.parseDouble(d.format(w2+AW2));
    threshold=Double.parseDouble(d.format(threshold+Athreshold));
    System.out.println("Ya:"+(int)Ya+" "+"Error:"+(int)error+" "+"w1: "+w1+" "+"w2: "+w2);
    return error;
    }

     public double multilayer(int x1,int x2,int Yd,double LER){
          DecimalFormat d=new DecimalFormat("#.####");
          System.out.println("w11: "+w11+" "+"w12: "+w12+" "
    +"w21: "+w21+" "+"w22: "+w22+" "+"w3: "+w3+" "+"w4: "+w4);
      System.out.println("threshold3:"+threshold3+" "+"threshold4:"+threshold4+" "+"threshold5:"+threshold5);
     double LR=LER;
     //Hidden Layer
    XY3=Double.parseDouble(d.format(x1*w11+x2*w21-threshold3));
    XY4=Double.parseDouble(d.format(x1*w12+x2*w22-threshold4));
    Ya3=Double.parseDouble(d.format(Sigmoid_function(XY3)));
    Ya4=Double.parseDouble(d.format(Sigmoid_function(XY4)));
    //Output layer
    XY5=Double.parseDouble(d.format(Ya3*w3+Ya4*w4-threshold5));
    Ya5=Double.parseDouble(d.format(Sigmoid_function(XY5)));
    double error=Double.parseDouble(d.format((Yd-Ya5)));
    GE5=Double.parseDouble(d.format(Gradient_error_Sigmoid_function(Ya5,error)));
    AW3=Double.parseDouble(d.format(LR*Ya3*GE5));
    AW4=Double.parseDouble(d.format(LR*Ya4*GE5));
    Athreshold5=Double.parseDouble(d.format(LR*-1*GE5));
    GE3=Double.parseDouble(d.format(Gradient_error_Sigmoid_function(Ya3, (GE5*w3))));
    GE4=Double.parseDouble(d.format(Gradient_error_Sigmoid_function(Ya4, (GE5*w4))));
    AW11=Double.parseDouble(d.format(LR*x1*GE3));
    AW21=Double.parseDouble(d.format(LR*x2*GE3));
    Athreshold3=Double.parseDouble(d.format(LR*-1*GE3));
    AW12=Double.parseDouble(d.format(LR*x1*GE4));
    AW22=Double.parseDouble(d.format(LR*x2*GE4));
    Athreshold4=Double.parseDouble(d.format(LR*-1*GE4));
    w11=Double.parseDouble(d.format(w11+AW11));
    w12=Double.parseDouble(d.format(w12+AW12));
    w21=Double.parseDouble(d.format(w21+AW21));
    w22=Double.parseDouble(d.format(w22+AW22));
    w3=Double.parseDouble(d.format(w3+AW3));
    w4=Double.parseDouble(d.format(w4+AW4));
    threshold3=Double.parseDouble(d.format(threshold3+Athreshold3));
    threshold4=Double.parseDouble(d.format(threshold4+Athreshold4));
    threshold5=Double.parseDouble(d.format(threshold5+Athreshold5));
    System.out.println("Ya:"+Ya5+" "+"Error:"+error+" ");
    
     return error;
     }
      public double Sigmoid_function(double X) {
           DecimalFormat d=new DecimalFormat("#.####");
        return Double.parseDouble(d.format(1/(1+(Math.exp(-X)))));
    }
       public double Gradient_error_Sigmoid_function(double ya,double error) {
            DecimalFormat d=new DecimalFormat("#.####");
        return Double.parseDouble(d.format((ya*(1-ya))*error));
    }
       
    public double step_function(double X) {
        double r=0;
        if (X>=0)
            r=1;
        if (X<0)
            r=0;
        return r;
    }
}
