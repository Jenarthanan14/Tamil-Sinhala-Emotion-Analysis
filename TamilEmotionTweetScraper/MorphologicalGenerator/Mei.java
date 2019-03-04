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
public class Mei {
    Set<String> mei = new HashSet<String>();
   public Mei()
           {
               mei.add("க்");
               mei.add("ங்");
               mei.add("ச்");
               mei.add("ஞ்");
               mei.add("ட்");
               mei.add("ண்");
               mei.add("த்");
               mei.add("ந்");
               mei.add("ப்");
               mei.add("ம்");
               mei.add("ய்");
               mei.add("ர்");
               mei.add("ல்");
               mei.add("வ்");
               mei.add("ழ்");
               mei.add("ள்");
               mei.add("ற்");
               mei.add("ன்");
                
           }

   boolean isMei(String letter)
   {
       /*
       if(mei.contains(letter))
       {
           System.out.println(letter+"இது மெய்");
       }
       else
       {
            System.out.println(letter+"இது மெய் அல்ல");
       }*/
       return mei.contains(letter);
   }
    public static void main(String arg[])
    {
        String letter="வ";
        
       Mei obj=new Mei();
    obj.isMei(letter);
      
    }

}
