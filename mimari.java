package mimarii;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

import java.util.Random;

public class mimari {    
JFrame f;    

int size, hammingCodeSize, errorPosition;  
int arr[];  
int hammingCode[];

mimari(){    
f=new JFrame("Hamming Code Simulatoru");      

JRadioButton r1=new JRadioButton("4");    
JRadioButton r2=new JRadioButton("8");  
JRadioButton r3=new JRadioButton("16");    


r3.setSelected(true);  /* Baslangicta 16 bit butonu aktif  */

JButton basla = new JButton("Basla");
basla.setBounds(40,60,70,30);
f.add(basla);

r1.setBounds(10,30,50,30);    
r2.setBounds(60,30,50,30);    
r3.setBounds(110,30,50,30);    

ButtonGroup bg=new ButtonGroup();    
bg.add(r1);bg.add(r2);bg.add(r3);  

f.add(r1);f.add(r2);f.add(r3);

JLabel l1;  
l1=new JLabel("Bit sayisini seciniz:");  
    l1.setBounds(10,10,130,20);  
    f.add(l1);  
   
    JButton b=new JButton("BELLEK'e YAZ");  
    b.setBounds(250,10,120,30);  
    f.add(b);  
   
    /* Tek tek tanimlamak yerine ARRAY olarak tanimladik  */
   
    JTextField[] t = new JTextField [Parametreler.bit];
   
    for(int i = 0;i < Parametreler.bit;i++)
    {
    JTextField textField = new JTextField();
    textField.setBounds(20, 140 + i * 20, 20, 20);
    t[i]= textField;
     
    }
   
    for(int i = 0;i < Parametreler.bit;i++)
    {
    f.add(t[i]);
    }
   
   
    JLabel l2;  
l2=new JLabel("Hamming Code:");  
    l2.setBounds(150,150,120,20);  
    f.add(l2);
   
    JTextField tCode = new JTextField();
tCode.setBounds(150, 180, 180, 30);
f.add(tCode);


/*MEMORY*/
JLabel l3;  
l3=new JLabel("BELLEK:");  
    l3.setBounds(400,80,130,20);  
    f.add(l3);
   
    JTextField[] m = new JTextField [Parametreler.bit2];
    for(int i = 0;i < Parametreler.bit2;i++)
    {
    JTextField textField2 = new JTextField();
    textField2.setBounds(410, 100+i*20, 20, 20);
    m[i]= textField2;
     
    }
   
    for(int i = 0;i < Parametreler.bit2;i++)
    {
    f.add(m[i]);
    }

   
    JButton c=new JButton("BELLEK'ten OKU");  
    c.setBounds(500,10,140,30);  
    f.add(c);  
   
    JLabel l4;  
l4=new JLabel("Okunan:");  
    l4.setBounds(550,80,80,20);  
    f.add(l4);
   
    JTextField okunan = new JTextField();
okunan.setBounds(550, 100, 180, 30);
f.add(okunan);

JButton d=new JButton("Kontrol Et");  
    d.setBounds(750,100,140,30);  
    f.add(d);  

   
    /*KONTROL SONUCU*/
JLabel l5;  
l5=new JLabel("KONTROL SONUCU:");  
    l5.setBounds(550,280,130,20);  
    f.add(l5);
   
    JTextField[] k = new JTextField [Parametreler.bit2];
    for(int i = 0;i < Parametreler.bit2;i++)
    {
    JTextField textField3 = new JTextField();
    textField3.setBounds(550+i*20, 300, 20, 20);
    k[i]= textField3;
     
    }
   
    for(int i = 0;i < Parametreler.bit2;i++)
    {
    f.add(k[i]);
    }
   
   
   
    JLabel l6;  
    l6=new JLabel("Düzeltilmiş kod:");  
       l6.setBounds(550,400,150,20);  
       f.add(l6);
       
       JTextField dKod = new JTextField();
    dKod.setBounds(550, 420, 180, 30);
    f.add(dKod);
   
    JLabel l7;  
    l7=new JLabel("Gönderilen veri:");  
       l7.setBounds(550,500,150,20);  
       f.add(l7);
       
       JTextField veri = new JTextField();
    veri.setBounds(550, 520, 180, 30);
    f.add(veri);
   
   
   

    // Basla butonuna basinca.
    basla.addActionListener(new ActionListener() {
       

        public void actionPerformed(ActionEvent e)
        {
            /* 4, 8 veya 16 degerini al */
        int bit1=0,bit2 = 0;

           
            if (r1.isSelected()) {

                bit1 = 4;
                bit2=7;
            }

            else if (r2.isSelected()) {

                bit1 = 8;
                bit2=12;
            }
            else if (r3.isSelected()){

                bit1 = 16;
                bit2=21;
            }
            Parametreler.bit=bit1;
            Parametreler.bit2=bit2;
           
            size= Parametreler.bit;
            arr = new int[size];
           
            for(int j = 0 ; j < size ; j++) {
            arr[j] = Integer.valueOf(t[j].getText());   //
            }  
           
            hammingCode = getHammingCode(arr);    //hamming fonksiyonu cagrilir
            hammingCodeSize = hammingCode.length;
           
        for(int i = 0;i < hammingCodeSize;i++)
        {
        /* Data olarak girilen veriyi test amaciyla al
        * ve Hamming Code: yazan yere ekle
        * DAHA SONRA GER�EK HAMMING CODE buraya yazd�r�lacak */
        String data=Integer.toString(hammingCode[i]);
       
        tCode.setText(tCode.getText() + data);  // hamming code kutucugu
        }
                   
           
           
           
           
           
        }
    });
   
   

    b.addActionListener(new ActionListener() {
       

        public void actionPerformed(ActionEvent e)
        {
        for(int i = 0;i < Parametreler.bit2;i++)
        {
        String bcode=Integer.toString(hammingCode[i]); //bellek
       
        m[i].setText(bcode);
        }            
        }
        });


    c.addActionListener(new ActionListener() {
       

        public void actionPerformed(ActionEvent e)
        {
   
        for(int i = 0;i < Parametreler.bit2;i++)
        {
       
        String bcode=Integer.toString(hammingCode[i]); //okunan
       
        okunan.setText(okunan.getText() + bcode);
        }            
        }
        });

   
    d.addActionListener(new ActionListener() {
       

        public void actionPerformed(ActionEvent e)
        {
        arr = new int[Parametreler.bit2];
        String oku=okunan.getText();
        int size=Parametreler.bit2;
        int Loc;
       
        for(int i = 0;i < size;i++)
        {
       
        String bcode=Character.toString(oku.charAt(i));
       
        k[i].setText(bcode);                         //kontrol
        arr[i]=Integer.valueOf(bcode);  
        }
       
        Loc=receiveData(arr, Parametreler.bit2-Parametreler.bit);
            // Change text font color
        k[Loc-1].setBackground(Color.blue);
        k[Loc-1].setText(k[Loc-1].getText());
       
        for(int i = 0;i < size;i++)
        {
       
        String bcode=Integer.toString(hammingCode[i]);  //duzeltilmis
   
        dKod.setText(dKod.getText() + bcode);
        }
       
        for(int i = 0;i < Parametreler.bit;i++)
        {
       
        String bcode=t[i].getText();
   
        veri.setText(veri.getText() + bcode);     //kullanici verisi
        }
       
        }
        });











f.setSize(1000,1000);    
f.setLayout(null);    
f.setVisible(true);  


}

public class Parametreler {
    public static int bit = 16; /*Ba�lang��ta 16 bit varsay�yoruz */
    public static int bit2 = 21; /*Ba�lang��ta 0 bit varsay�yoruz */
   
}
static int[] getHammingCode(int data[]) {  
 int returnData[];  
 int size, parityBits;    
 int i = 0, j = 0, k = 0;  
 size = Parametreler.bit;
 parityBits=Parametreler.bit2 - Parametreler.bit;
 
 returnData = new int[size + parityBits];  

 for(i = 1; i <= returnData.length; i++) {    
     if(Math.pow(2, j) == i) {  
       
         returnData[(i - 1)] = 2;  
         j++;  
     }  
     else {  
         returnData[(k + j)] = data[k++];  
     }  
 }  
 for(i = 0; i < parityBits; i++) {  
   
     returnData[((int) Math.pow(2, i)) - 1] = getParityBit(returnData, i);  
 }  
   
 return returnData;  
}  

static int getParityBit(int returnData[], int pow) {  
 int parityBit = 0;  
 int size = returnData.length;  
   
 for(int i = 0; i < size; i++) {  
       
   
     if(returnData[i] != 2) {  
           
         int k = (i + 1);  
           
         String str = Integer.toBinaryString(k);  
       
         int temp = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;  
         if(temp == 1) {  
             if(returnData[i] == 1) {  
                 parityBit = (parityBit + 1) % 2;  
             }  
         }  
     }  
 }  
 return parityBit;  
}  


static int receiveData(int data[], int parityBits) {  
   
 int pow;  
    int size = data.length;      
 
    int parityArray[] = new int[parityBits];  
    String errorLoc = new String();  
    for(pow = 0; pow < parityBits; pow++) {  
        for(int i = 0; i < size; i++) {  
            int j = i + 1;  
            String str = Integer.toBinaryString(j);  
            int bit = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;  
            if(bit == 1) {  
                if(data[i] == 1) {  
                    parityArray[pow] = (parityArray[pow] + 1) % 2;  
                }  
            }  
        }  
        errorLoc = parityArray[pow] + errorLoc;  
    }  
 
    int finalLoc = Integer.parseInt(errorLoc, 2);  

    if(finalLoc != 0) {  
   

        System.out.println("Hata lokasyonu " + finalLoc + ".");  
        data[finalLoc - 1] = (data[finalLoc - 1] + 1) % 2;  
        System.out.println("Hata duzeltildikten sonra kod:");  
        for(int i = 0; i < size; i++) {  
            System.out.print(data[size - i - 1]);  
        }  
        System.out.println();  
    }  
    else {  
        System.out.println("Hata bulunmadı.");  
    }  

    System.out.println("Kullanicidan gelen veri:");  
    pow = parityBits - 1;  
    for(int k = size; k > 0; k--) {  
        if(Math.pow(2, pow) != k) {  
            System.out.print(data[k - 1]);  
        }  
        else {  
 
            pow--;  
        }  
    }  
    return finalLoc;           //final lokasyon doner
}  


public static void main(String[] args) {    
    new mimari();  
   
   
}    
}  
