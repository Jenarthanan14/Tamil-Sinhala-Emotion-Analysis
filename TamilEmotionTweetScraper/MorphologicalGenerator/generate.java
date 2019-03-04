/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MorphologicalGenerator;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class generate {
   String eeru;
   Uyir uyir;
   int pres;
   int pas;
   int set;
   int fut;
   final int PAST_LENGTH=16;
   final int PRESENT_LENGTH=19;
   final int FUTURE_LENGTH=12;
   ArrayList<String> characters;
   Nedil ned;
   noungen noungen;
   String prev,last,pastjoin,presentjoin,futurejoin,result,word,s_pres,s_fut;
   
   String past[][]={{"த்தான்","த்தாள்","த்தார்","த்தார்கள்","த்தது","த்தன","த்த","த்தாய்","த்தீர்","த்தீர்கள்","த்தேன்","த்தோம்","த்தவன்","த்தவள்","த்தவர்","த்தவர்கள்"},
                    {"ந்தான்","ந்தாள்","ந்தார்","ந்தார்கள்","ந்தது","ந்தன","ந்த","ந்தாய்","ந்தீர்","ந்தீர்கள்","ந்தேன்","ந்தோம்","ந்தவன்","ந்தவள்","ந்தவர்","ந்தவர்கள்"},
                    {"றான்","றாள்","றார்","றார்கள்","றது","றன","ற","றாய்","றீர்","றீர்கள்","றேன்","றோம்","றவன்","றவள்","றவர்","றவர்கள்"},
                    {"டான்","டாள்","டார்","டார்கள்","டது","டன","ட","டாய்","டீர்","டீர்கள்","டேன்","டோம்","டவன்","டவள்","டவர்","டவர்கள்"},
                    {"னான்","னாள்","னார்","னார்கள்","யது","ன","ய","னாய்","னீர்","னீர்கள்","னேன்","னோம்","யவன்","யவள்","யவர்","யவர்கள்"},
     {"னான்","னாள்","னார்","னார்கள்","னது","ன","ன","னாய்","னீர்","னீர்கள்","னேன்","னோம்","னவன்","னவள்","னவர்","னவர்கள்"},
   {"தான்","தாள்","தார்","தார்கள்","தது","தன","த","தாய்","தீர்","தீர்கள்","தேன்","தோம்","தவன்","தவள்","தவர்","தவர்கள்"}};
   
   String present[][]={{"கிறான்","கிறாள்","கிறார்","கிறார்கள்","கின்றது","கின்றன","கின்றாய்","கின்றீர்","கின்றீர்கள்","கின்றேன்","கின்றோம்","கின்றவன்","கின்றவள்",
"கின்றவர்","கின்றவர்கள்","கின்றது","பவர்","பவள்","பவன்"}};
   
   String future[][]={{"பான்","பாள்","பார்","பார்கள்","பது","பன","பாய்","பீர்","பீர்கள்","பேன்","போம்","ம்"},
       {"வான்","வாள்","வார்","வார்கள்","வது","வன","வாய்","வீர்","வீர்கள்","வேன்","வோம்","ம்"}};
   //String iv[]={"கை","சை","ஙை","ஞை","டை","ணை","தை","நை","பை","மை","யை","ரை","லை","வை","ழை","ளை","றை","னை"};
   String iv="கை சை ஙை ஞை டை ணை தை நை பை மை யை ரை லை வை ழை ளை றை னை";
   Mei mei;
    public generate()
    {
    uyir=new Uyir();
    ned=new Nedil();  
    set=1;
    mei=new Mei();
    noungen = new noungen();
    }
    void lastய்()
    {
        pas=6;
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=1;
               s_pres="";
               s_fut="யு";
               futurejoin="";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
    }
   void lastடி()
   {
       if(characters.size()>=3)
           if(mei.isMei(prev))
               prev=characters.get(characters.size()-3);
       if(ned.isNedil(prev) || prev.equals("க")|| prev.equals("த")|| prev.equals("ஒ")|| prev.equals("வெ"))
           {
               pas=4;
               pastjoin="டி";
               pres=0;
               presentjoin="டு";
               fut=1;
               s_pres="டு";
               s_fut="டு";
               futurejoin="டு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   void lastடு()
   {
       
       if(characters.size()>=3)
       {
           if(mei.isMei(prev))
               prev=characters.get(characters.size()-3);
       
       }
       
           if(ned.isNedil(prev) || prev.equals("க")|| prev.equals("ஒ")|| prev.equals("த"))
       {
           pas=4;
           pres=0;
           fut=1;
           pastjoin="டி";
           presentjoin="டு";
           futurejoin="டு";
           s_pres="டு";
           s_fut="டு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
       }
       else
       {
           pas=3;
           pres=0;
           fut=1;
           pastjoin="ட்";
           presentjoin="டு";
           futurejoin="டு";
           s_pres="டு";
           s_fut="டு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       }
           if(prev.equals("போ"))
           {pastjoin="ட்";
           pas=3;
               
           }
if(prev.equals("வெ"))
           {pastjoin="டி";
           pas=4;
               
           }
           if(prev.equals("கொ"))
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
           {
               word+=characters.get(i);
           }
           }
   }
   void lastSingle()
   {
       word=characters.get(0);
       //word=word-"\u0BBE";
     if(word.equals("வா"))
     {
         word="வ";
     }
     
     if(word.equals("தா"))
     {
         word="த";
     }
     
       if(ned.isNedil(word) && !word.equals("வ")&& !word.equals("த")&& !word.equals("டோ"))
       {//word.replace(oldChar, newChar)
             //word.replace("\u0BBE"," ");
           pas=5;
           pres=0;
           fut=1;
           pastjoin="";
           presentjoin="";
           s_pres="";
           futurejoin="";
           s_fut="கு";
           
       }
       else
       {
           pas=1;
           pres=0;
           fut=1;
           pastjoin="";
           presentjoin="ரு";
           futurejoin="ரு";
           s_pres="ரு";
           s_fut="ரு";
          
           
       }
       
   }
   void lastள்()
   {
      if(ned.isNedil(prev) && !prev.equals("மா"))
       {
           pas=3;
           pres=0;
           fut=0;
           pastjoin="ட்";
           presentjoin="ட்";
           futurejoin="ட்";
           s_pres="ட்";
           s_fut="ட்கு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
       }
       else
       {
           pas=3;
           pres=0;
           fut=1;
           pastjoin="ண்";
           presentjoin="ள்";
           futurejoin="ள்";
           s_pres="ள்";
           if(prev.equals("மா"))
           s_fut="ளு";
           else
           s_fut="ள்ளு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       } 
   }
   void lastண்()
   {
       if(ned.isNedil(prev))
           {
               pas=3;
               pastjoin="ண்";
               pres=0;
               presentjoin="ண்";
               fut=0;
               s_pres="ண்";
               s_fut="ணு";
               futurejoin="ண்";
               word="";
               if(prev.endsWith("\u0BBE"))
               {
                   presentjoin="\u0BBE"+presentjoin;
                   futurejoin="\u0BBE"+futurejoin;
                   s_pres="\u0BBE"+s_pres;
                   s_fut="\u0BBE"+s_fut;
               }
               
               for(int i=0;i<characters.size()-2;i++)
               {
                   word+=characters.get(i);
               }
               if(prev.equals("கா"))
                   prev="க";
               
               //prev.replace("\u0BBE", "");
               word+=prev;
               
           }
           else
           {
               pas=3;
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=0;
               s_pres="";
               s_fut="";
               futurejoin="";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   void lastல்()
   {
       if(ned.isNedil(prev))
       {
           pas=4;
           pres=0;
           fut=1;
           pastjoin="டி";
           presentjoin="டு";
           futurejoin="டு";
           s_pres="டு";
           s_fut="டு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
       }
       else
       {
           pas=2;
           pres=0;
           fut=1;
           pastjoin="ன்";
            presentjoin="ல்";
           futurejoin="ல்";
           s_pres="ல்";
           s_fut="ல்லு";
           if(prev.equals("சொ"))
           {
               pas=5;
              
         }
           if(prev.equals("நி"))
           {
                presentjoin="ற்";
           futurejoin="ற்";
           s_pres="ற்";
           fut=0;
           s_fut="ற்கு";
           }
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       }
   }
   void lastன்()
   {
       if(ned.isNedil(prev))
           {
               pas=2;
               pastjoin="ன்";
               pres=0;
               presentjoin="ன்";
               fut=0;
               s_pres="ன்";
               s_fut="னு";
               futurejoin="ன்";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
              pas=4;
               pastjoin="ன்னி";
               pres=0;
               presentjoin="ன்னு";
               fut=1;
               s_pres="ன்னு";
               s_fut="ன்னு";
               futurejoin="ன்னு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
           }
         
   }
   void lastகு()
   {
       if(true)
           {
               pas=4;
               pastjoin="கி";
               pres=0;
               presentjoin="கு";
               fut=1;
               s_pres="கு";
               s_fut="கு";
               futurejoin="கு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
    void lastiv()
   {
       if(characters.size()==1)
       {
           prev=last;
       }
       if(true)
           {
               pas=0;
               pastjoin=last;
               pres=0;
               presentjoin=last+"க்";
               fut=0;
               s_pres=last+"ப்";
               s_fut=last+"க்கு";
               futurejoin=last+"ப்";;
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
     void lastறு()
   {
       int cas=0;
       if(characters.size()>=3)
       {
           if(!(uyir.isUyir(characters.get(characters.size()-3))) || characters.get(characters.size()-3).equals("ஆ") )
           {
               cas=1;
           }
       }
       if(characters.size()==2)
       {
           cas=1;
       }
       if(cas==1)
       {
           pas=4;
           pres=0;
           fut=1;
           pastjoin="றி";
           presentjoin="று";
           futurejoin="று";
           s_pres="று";
           s_fut="று";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       }
       else
       {
       //    returnResult();
       
           pas=2;
           pres=0;
           fut=0;
           pastjoin="";
           presentjoin="";
           futurejoin="";
           s_pres="";
           s_fut="கு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       }
   }
     void lastடற()
   {
       if(true)
       {
           pas=1;
           pres=0;
           fut=0;
           prev=last;
           pastjoin="";
           presentjoin="க்";
           futurejoin="ப்";
           s_pres="ப்";
           s_fut="க்கு";
           for(int i=0;i<characters.size();i++)
           {
               word+=characters.get(i);
           }
       }
       else
       {
           pas=3;
           pres=0;
           fut=1;
           pastjoin="ட்";
           presentjoin="டு";
           futurejoin="டு";
           s_pres="டு";
           s_fut="டு";
           for(int i=0;i<characters.size()-1;i++)
           {
               word+=characters.get(i);
           }
           
       }
     
   }
   void lastவு()
   {
       if(true)
           {
               pas=4;
               pastjoin="வி";
               pres=0;
               presentjoin="வு";
               fut=1;
               s_pres="வு";
               s_fut="வு";
               futurejoin="வு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
  void lastசு()
   {
       if(true)
           {
               pas=4;
               pastjoin="சி";
               pres=0;
               presentjoin="சு";
               fut=1;
               s_pres="சு";
               s_fut="சு";
               futurejoin="சு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
  void lastது()
   {
       int type=0;
       if(characters.size()>=3)
       {
           if(uyir.isUyir(characters.get(characters.size()-3)))
           {
               type=1;
           }
       }
       if(type==1)
           {
               pas=4;
               pastjoin="தி";
               pres=0;
               presentjoin="து";
               fut=1;
               s_pres="து";
               s_fut="து";
               futurejoin="து";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               if(prev.equals("த்")){
                   pas=0;
               }
               else
               {
                   pas=1;
               }
               
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=1;
               s_pres="";
               s_fut="யு";
               futurejoin="";
               word="";
               for(int i=0;i<characters.size()-2;i++)
               {
                   word+=characters.get(i);
               }
               if(characters.size()==3)
               {
                   if(characters.get(characters.size()-3).equals("வ"))
                   {
                       presentjoin="ரு";
                       futurejoin="ரு";
                       s_pres="ரு";
                       s_fut="ரு";
                       word="வ";
                   }
                   if(characters.get(characters.size()-3).equals("த"))
                   {
                       presentjoin="ரு";
                       futurejoin="ரு";
                       s_pres="ரு";
                       s_fut="ரு";
                       word="த";
                   }
               }
               
           }
         
   }
  void lastழ்()
   {
       if(true)
           {
               pas=1;
               pastjoin="ழ்";
               pres=0;
               presentjoin="ழ்";
               fut=1;
               s_pres="ழ்";
               s_fut="ழு";
               futurejoin="ழ்";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
   void lastறி()
   {
       if(uyir.isUyir(prev))
           {
               pas=1;
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=1;
               s_pres="";
               s_fut="யு";
               futurejoin="";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   void lastதி()
   {
       if(true)
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
   void lastபிமிணி()
   {
       if(characters.size()>=3)
           if(mei.isMei(prev))
               prev=characters.get(characters.size()-3);
       
       if(ned.isNedil(prev))
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=1;
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=1;
               s_pres="";
               s_fut="யு";
               futurejoin="";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
   void lastர்()
   {
       if(ned.isNedil(prev))
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=1;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
   
   
   void lastபு()
   {
       if(true)
           {
               pas=4;
               pastjoin="பி";
               pres=0;
               presentjoin="பு";
               fut=1;
               s_pres="பு";
               s_fut="ப்பு";
               futurejoin="பு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
  void lastழி()
   {
       if(true)
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
  void lastணு()
   {
       if(true)
           {
               pas=4;
               pastjoin="ணி";
               pres=0;
               presentjoin="ணு";
               fut=1;
               s_pres="ணு";
               s_fut="ணு";
               futurejoin="ணு";
               word="";
               for(int i=0;i<characters.size()-1;i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
  
   void lastரி()
   {
       if(true)
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
               
           }
           else
           {
               pas=0;
               pastjoin="";
               pres=0;
               presentjoin="க்";
               fut=0;
               s_pres="ப்";
               s_fut="க்கு";
               futurejoin="ப்";
               word="";
               for(int i=0;i<characters.size();i++)
               {
                   word+=characters.get(i);
               }
               
           }
         
   }
  
  void find_type()
   {
       
       pastjoin="";
       presentjoin="";
       futurejoin="";
       word="";
       last=characters.get(characters.size()-1);
       if(characters.size()!=1)
       {
          prev=characters.get(characters.size()-2);   
       }
       
       if(characters.size()==1 && !iv.contains(last))
       {
           last=characters.get(characters.size()-1);
           lastSingle();
           return;
       }
       if(last.equals("ற")||last.equals("ட")||last.equals("ர"))
         {
            lastடற();
            return;
         }
         if(last.equals("பு"))
         {
             lastபு();
             return;
         }
         
         if(last.equals("ழி"))
         {
             lastழி();
             return;
         }
         if(last.equals("ணு"))
         {
             lastணு();
             return;
         }
         if(last.equals("பி"))
         {
             lastபிமிணி();
             return;
         }
         if(last.equals("மி"))
         {
             lastபிமிணி();
             return;
         }
         if(last.equals("ரி"))
         {
             lastரி();
             return;
         }
         if(last.equals("ணி"))
         {
             lastபிமிணி();
             return;
         }
       if(last.equals("டி"))
       {
           lastடி();
           return;
       }
       if(last.equals("டு"))
       {
           lastடு();
           return;
       }
       
       
       if(last.equals("ள்"))
       {
           lastள்();
           return;
       }
       if(last.equals("ண்"))
       {
           lastண்();
           return;
       }
       if(last.equals("ல்"))
       {
           lastல்();
           return;
       }
        if(last.equals("ன்"))
       {
           lastன்();
           return;
       }
         if(last.equals("கு"))
       {
           lastகு();
           return;
       }
         if(iv.contains(last))
         {
             lastiv();
             return;
         }
         if(last.equals("று"))
         {
             lastறு();
             return;
         }
         if(last.equals("வு"))
         {
             lastவு();
             return;
         }
         if(last.equals("சு"))
         {
             lastசு();
             return;
         }
         if(last.equals("து"))
         {
             lastது();
             return;
         }
         if(last.equals("ழ்"))
         {
             lastழ்();
             return;
         }
          if(last.equals("றி"))
       {
           lastறி();
           return;
       }
          if(last.equals("தி"))
       {
           lastதி();
           return;
       }
          if(last.equals("ர்"))
       {
           lastர்();
           return;
       }
            if(last.equals("ய்"))
        {
             lastய்();
             return;
        }

        set=0;

      
   }
    public String gen(String root)
    {result="";
        characters = new ArrayList<String>();
        Pattern pat = Pattern.compile("\\p{L}\\p{M}*");
        Matcher matcher = pat.matcher(root);
        while (matcher.find()) {
            characters.add(matcher.group());
        }
        find_type();

        if(set==0) {
            String nounOut=noungen.gen(root);
            return(nounOut);
        }
        return returnResult();
        
    }
    
    private String returnResult()
    {
        int i;
        //result+="PAST:\n\n";
        for(i=0;i<PAST_LENGTH;i++)
        {
            result+=word+pastjoin+past[pas][i]+",\n";
        }
        //result+="\n\nPRESENT:\n\n";
        for(i=0;i<PRESENT_LENGTH-3;i++)
        {
            result+=word+presentjoin+present[pres][i]+",\n";
        }
        result+=word+s_pres+present[pres][i++]+",\n";
        result+=word+s_pres+present[pres][i++]+",\n";
        result+=word+s_pres+present[pres][i++]+",\n";
        //result+="\n\nFUTURE:\n\n";
        for(i=0;i<FUTURE_LENGTH-1;i++)
        {
            result+=word+futurejoin+future[fut][i]+",\n";
        }
        result+=word+s_fut+future[fut][i]+",";
        return result;
    }

    public static void main(String args[]) {
        generate verbgeneragte = new generate();
        Scanner user_input = new Scanner( System.in );
        System.out.println("Enter file name with location : ");
        String inputFile = user_input.nextLine();
        System.out.println("Enter result file name with store location  : ");
        String resultFile = user_input.nextLine();
        String str;
        try {
            //"D:\\Twiter screbing project\\Genarator\\src\\genarator\\Anger.txt";
            File fileDirread = new File(inputFile);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDirread), "UTF8"));
            //"D:\\Twiter screbing project\\Genarator\\src\\genarator\\File1.txt";
            File fileDir = new File(resultFile);



            while ((str = in.readLine()) != null) {
                String[] word=str.split(",");
                for (String temp: word ){
                    String output = verbgeneragte.gen(temp);
                    Writer out = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(fileDir,true), "UTF8"));

                    out.append(output);
                    out.flush();
                    out.close();

                }

            }

            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
