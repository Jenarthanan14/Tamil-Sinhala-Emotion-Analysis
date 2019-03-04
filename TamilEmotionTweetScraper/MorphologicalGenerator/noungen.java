/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MorphologicalGenerator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SUGADEV
 */
public class noungen {
    int set=0;
    int type;
    final int LENGTH=9;
    String word;
    String result;
    Uyir uyir=new Uyir();
    Mei mei=new Mei();
     String suffix[][]={{"யை","யால்","க்கு","யில்","யின்","யினது","கள்","களால்","யின்கண்"},
{"லை","லால்","க்கு","லில்","லின்","லினது","கள்","களால்","லின்கண்"},
{"கை","கால்","க்கு","கில்","கின்","கினது","கள்","களால்","கின்கண்"},
{"த்தை","த்தால்","த்துக்கு","த்தில்","த்தின்","த்தினது","கள்","களால்","த்தின்கண்"},
{"பை","பால்","க்கு","பில்","பின்","பினது","கள்","களால்","பின்கண்"},
     {"ட்டை","ட்டால்","ட்டுக்கு","ட்டில்","ட்டின்","ட்டினது","கள்","களால்","ட்டின்கண்"},
{"ற்றை","ற்றால்","ற்றுக்கு","ற்றில்","ற்றின்","ற்றினது","றுகள்","றுகளால்","ற்றின்கண்"},
     {"ளை","ளால்","க்கு","ளில்","ளின்","ளினது","கள்","களால்","ளின்கண்"},
     {"தை","தால்","துக்கு","தில்","தின்","தினது","கள்","களால்","தின்கண்"},
     {"ணை","ணால்","ணுக்கு","ணில்","ணின்","ணினது","கள்","களால்","ணின்கண்"},
     {"ரை","ரால்","ருக்கு","ரில்","ரின்","ரினது","ர்கள்","ர்களால்","ரின்கண்"},
     {"வை","வால்","வுக்கு","வில்","வின்","வினது","வுகள்","வுகளால்","வின்கண்"},
     {"னை","னால்","னுக்கு","னில்","னின்","னினது","ன்கள்","ன்களால்","னின்கண்"},
     {"சை","சால்","சுக்கு","சில்","சின்","சினது","சுகள்","சுகளால்","சின்கண்"},
{"றை","றால்","றுக்கு","றில்","றின்","றினது","றுகள்","றுகளால்","றின்கண்"}};
    private ArrayList<String> characters;
    private String last;
    private String join;
    private String join1,join2,join3,join4,join5,join6,join7,join8,join9;
    private int spl;
    Nedil ned=new Nedil();
    
    public noungen()
    {
        
    }
    void find_type() {
        word = "";
        last = characters.get(characters.size() - 1);
        if (last.equals("கை") || last.equals("பை") || last.equals("னி")) {
            for (int i = 0; i < characters.size(); i++) {
                word += characters.get(i);
            }

            join = "";
            type = 0;
            set = 1;
            return;
        }
        if (last.equals("சு")) {
            word = "";
            type = 13;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }
            set = 1;
            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }
        if (last.equals("கு")) {
            word = "";
            type = 2;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }
            set = 1;
            join1 = "";
            join2 = "";
            join3 = "கு";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "கு";
            join8 = "கு";
            join9 = "";
            return;
        }
        if (last.equals("ம்")) {
            set = 1;
            type = 8;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "த்";
            join2 = "த்";
            join3 = "த்";
            join4 = "த்";
            join5 = "த்";
            join6 = "த்";
            join7 = "ங்";
            join8 = "ங்";
            join9 = "த்";
            return;
        }
        if (last.equals("வு")) {
            set = 1;
            type = 11;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }
        if (last.equals("ன்")) {
            set = 1;
            type = 12;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }
        if (last.equals("ழ்")) {
            set = 1;
            type = 11;
            for (int i = 0; i < characters.size(); i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }

        if (last.equals("பு")) {
            set = 1;
            type = 4;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "பு";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "பு";
            join8 = "பு";
            join9 = "";
            return;
        }
        if (last.equals("ய்")) {
            set = 1;
            type = 0;
            spl = 1;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "ய்";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "ய்";
            join8 = "ய்";
            join9 = "";
            return;
        }
        if (last.equals("ல்")) {
            set = 1;
            type = 1;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }
            if (ned.isNedil(characters.get(characters.size() - 2))) {
                join1 = "";
                join2 = "";
                join3 = "லு";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "ல்";
                join8 = "ல்";
                join9 = "";
                return;

            }

            if (characters.size() == 2) {
                join1 = "ல்";
                join2 = "ல்";
                join3 = "ல்லு";
                join4 = "ல்";
                join5 = "ல்";
                join6 = "ல்";
                join7 = "ற்";
                join8 = "ற்";
                join9 = "ல்";
                return;
            }

            join1 = "";
            join2 = "";
            join3 = "லு";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "ல்";
            join8 = "ல்";
            join9 = "";
            return;
// return;
        }

        if (last.equals("ர்")) {
            set = 1;
            type = 10;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }
        if (last.equals("சை") || last.equals("வி")) {
            set = 1;
            type = 0;
            word = "";
            join = "";
            for (int i = 0; i < characters.size(); i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";

            return;
        }
        if (last.equals("டி") || last.equals("லை") || last.equals("டை") || last.equals("ழை") || last.equals("வை") || last.equals("சி") || last.equals("னை") || last.equals("ணை")) {
            set = 1;
            type = 0;
            word = "";
            join = "";
            for (int i = 0; i < characters.size(); i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }

        if (last.equals("டு")) {
            set = 1;
            type = 5;
            if (mei.isMei(characters.get(characters.size() - 2))) {
                for (int i = 0; i < characters.size() - 2; i++) {
                    word += characters.get(i);
                }
                join1 = "";
                join2 = "";
                join3 = "";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "ட்டு";
                join8 = "ட்டு";
                join9 = "";
            } else {
                for (int i = 0; i < characters.size() - 1; i++) {
                    word += characters.get(i);
                }
                join1 = "";
                join2 = "";
                join3 = "";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "டு";
                join8 = "டு";
                join9 = "";
            }


            return;
        }
        if (last.equals("து")) {
            set = 1;
            type = 8;
            if (characters.get(characters.size() - 2).equals("ம")) {
                for (int i = 0; i < characters.size(); i++) {
                    word += characters.get(i);
                }
                type = 11;
                join1 = "";
                join2 = "";
                join3 = "";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "";
                join8 = "";
                join9 = "";
                return;
            }
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "து";
            join8 = "து";
            join9 = "";
            return;
        }

        if (last.equals("று")) {
            set = 1;
            type = 6;
            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";

            if (characters.size() >= 2) {
                if (characters.get(characters.size() - 2).equals("ற்")) {
                    for (int i = 0; i < characters.size() - 2; i++) {
                        word += characters.get(i);
                        join7 = "ற்";
                        join8 = "ற்";
                    }

                } else {
                    if (mei.isMei(characters.get(characters.size() - 2))) {
                        type = 14;
                    }

                    for (int i = 0; i < characters.size() - 1; i++) {
                        word += characters.get(i);
                    }
                }

            } else {
                for (int i = 0; i < characters.size() - 1; i++) {
                    word += characters.get(i);
                }
            }

            return;
        }
        if (last.equals("ள்")) {
            set = 1;
            type = 7;
            for (int i = 0; i < characters.size() - 1; i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "ளு";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "ள்";
            join8 = "ள்";
            join9 = "";
            return;
        }
        if (last.equals("தி")) {
            set = 1;
            type = 0;
            for (int i = 0; i < characters.size(); i++) {
                word += characters.get(i);
            }

            join1 = "";
            join2 = "";
            join3 = "";
            join4 = "";
            join5 = "";
            join6 = "";
            join7 = "";
            join8 = "";
            join9 = "";
            return;
        }
        if (last.equals("ண்")) {
            set = 1;
            type = 9;
            if (ned.isNedil(characters.get(characters.size() - 2))) {
                for (int i = 0; i < characters.size() - 1; i++) {
                    word += characters.get(i);
                }
                join1 = "";
                join2 = "";
                join3 = "";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "ண்";
                join8 = "ண்";
                join9 = "";

            } else {
                for (int i = 0; i < characters.size(); i++) {
                    word += characters.get(i);
                }
                join1 = "";
                join2 = "";
                join3 = "";
                join4 = "";
                join5 = "";
                join6 = "";
                join7 = "";
                join8 = "";
                join9 = "";

            }


            return;
        }

    }
    
    public String gen(String in)
    {
        result="";
        set=0;
        spl=0;
        word="";
        characters=new ArrayList<String>();
        Pattern pat=Pattern.compile("\\p{L}\\p{M}*");
        Matcher matcher=pat.matcher(in);
        while(matcher.find())
        {
            characters.add(matcher.group());
        }
        find_type();
        join="";
        if(set==0)
            return (in+',');
        return returnResult();
        
    }
    
    private String returnResult()
    {
        int i;
        result+="";
        if(type==0 && spl==0)
        for(i=0;i<LENGTH;i++)
        {
            result+=word+join+suffix[type][i]+",\n";
        }
        else
        {
            result+=word+join1+suffix[type][0]+",\n";
            result+=word+join2+suffix[type][1]+",\n";
            result+=word+join3+suffix[type][2]+",\n";
            result+=word+join4+suffix[type][3]+",\n";
            result+=word+join5+suffix[type][4]+",\n";
            result+=word+join6+suffix[type][5]+",\n";
            result+=word+join7+suffix[type][6]+",\n";
            result+=word+join8+suffix[type][7]+",\n";
            result+=word+join9+suffix[type][8]+",\n";
        }
       
        return result;
    }
    
    private String returnResult(int inflex)
    {
        int i;
        result+="";
        if(type==0 && spl==0)
            
            result+=word+join+suffix[type][inflex-1]+",\n";
        else
        {
            switch(inflex)
            {
                case 1:result+=word+join1+suffix[type][0]+",\n";
                         break;
                case 2:result+=word+join2+suffix[type][1]+",\n";
                         break;
                case 3:result+=word+join3+suffix[type][2]+",\n";
                        break;
                case 4:result+=word+join4+suffix[type][3]+",\n";
                        break;
                case 5:result+=word+join5+suffix[type][4]+",\n";
                        break;
                case 6:result+=word+join6+suffix[type][5]+",\n";
                        break;
                case 7:result+=word+join7+suffix[type][6]+",\n";
                        break;
                case 8:result+=word+join8+suffix[type][7]+",\n";
                        break;
                case 9:result+=word+join9+suffix[type][8]+",\n";
                     break;
            }
            
            
        }
       
        return result;
    }
}
