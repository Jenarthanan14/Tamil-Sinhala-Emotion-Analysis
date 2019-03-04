/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MorphologicalGenerator;

import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author SUGADEV
 */
public class Uyir {
   Set<String> uyir = new HashSet<String>();
   public Uyir()
           {
               uyir.add("அ");
               uyir.add("ஆ");
               uyir.add("இ");
               uyir.add("ஈ");
               uyir.add("உ");
               uyir.add("ஊ");
               uyir.add("எ");
               uyir.add("ஏ");
               uyir.add("ஐ");
               uyir.add("ஒ");
               uyir.add("ஓ");
               uyir.add("ஔ");
               uyir.add("ஃ");
               
           }
   boolean isUyir(String letter)
   {
       /*
       if(uyir.contains(letter))
       {
           System.out.println(letter+"uyir");
       }
       else
       {
            System.out.println(letter+"not uyir");
       }*/
       return uyir.contains(letter);
   }
    public static void main(String arg[])
    {
        String letter="ஐ";
        
       Uyir obj=new Uyir();
    obj.isUyir(letter);
      
    }
}
