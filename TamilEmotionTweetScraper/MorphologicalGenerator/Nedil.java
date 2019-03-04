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
public class Nedil {
    Set<String> nedil = new HashSet<String>();
    public Nedil()
    {
        nedil.add("ஆ");
        nedil.add("ஈ");
        nedil.add("ஊ");
        nedil.add("ஏ");
        nedil.add("ஐ");
        nedil.add("ஓ");
        nedil.add("ஔ");    
        
        nedil.add("கா");
        nedil.add("கீ");
        nedil.add("கூ");
        nedil.add("கே");
        nedil.add("கை");
        nedil.add("கோ");
        nedil.add("கௌ");
        
        nedil.add("ஙா");
        nedil.add("ஙீ");
        nedil.add("ஙூ");
        nedil.add("ஙே");
        nedil.add("ஙை");
        nedil.add("ஙோ");
        nedil.add("ஙௌ");
        
        nedil.add("சா");
        nedil.add("சீ");
        nedil.add("சூ");
        nedil.add("சே");
        nedil.add("சை");
        nedil.add("சோ");
        nedil.add("சௌ");
        
        nedil.add("ஞா");
        nedil.add("ஞீ");
        nedil.add("ஞூ");
        nedil.add("ஞே");
        nedil.add("ஞை");
        nedil.add("ஞோ");
        nedil.add("ஞௌ");
        
        nedil.add("டா");
        nedil.add("டீ");
        nedil.add("டூ");
        nedil.add("டே");
        nedil.add("டை");
        nedil.add("டோ");
        nedil.add("டௌ");
        
        nedil.add("ணா");
        nedil.add("ணீ");
        nedil.add("ணூ");
        nedil.add("ணே");
        nedil.add("ணை");
        nedil.add("ணோ");
        nedil.add("ணௌ");
        
        nedil.add("தா");
        nedil.add("தீ");
        nedil.add("தூ");
        nedil.add("தே");
        nedil.add("தை");
        nedil.add("தோ");
        nedil.add("தௌ");
        
        nedil.add("நா");
        nedil.add("நீ");
        nedil.add("நூ");
        nedil.add("நே");
        nedil.add("நை");
        nedil.add("நோ");
        nedil.add("நௌ");
        
        nedil.add("பா");
        nedil.add("பீ");
        nedil.add("பூ");
        nedil.add("பே");
        nedil.add("பை");
        nedil.add("போ");
        nedil.add("பௌ");
        
        nedil.add("மா");
        nedil.add("மீ");
        nedil.add("மூ");
        nedil.add("மே");
        nedil.add("மை");
        nedil.add("மோ");
        nedil.add("மௌ");
        
        nedil.add("யா");
        nedil.add("யீ");
        nedil.add("யூ");
        nedil.add("யே");
        nedil.add("யை");
        nedil.add("யோ");
        nedil.add("யௌ");
        
        nedil.add("ரா");
        nedil.add("ரீ");
        nedil.add("ரூ");
        nedil.add("ரே");
        nedil.add("ரை");
        nedil.add("ரோ");
        nedil.add("ரௌ");
        
        nedil.add("லா");
        nedil.add("லீ");
        nedil.add("லூ");
        nedil.add("லே");
        nedil.add("லை");
        nedil.add("லோ");
        nedil.add("லௌ");
        
        nedil.add("வா");
        nedil.add("வீ");
        nedil.add("வூ");
        nedil.add("வே");
        nedil.add("வை");
        nedil.add("வோ");
        nedil.add("வௌ");
        
        nedil.add("ழா");
        nedil.add("ழீ");
        nedil.add("ழூ");
        nedil.add("ழே");
        nedil.add("ழை");
        nedil.add("ழோ");
        nedil.add("ழௌ");
        
        nedil.add("ளா");
        nedil.add("ளீ");
        nedil.add("ளூ");
        nedil.add("ளே");
        nedil.add("ளை");
        nedil.add("ளோ");
        nedil.add("ளௌ");
        
        nedil.add("றா");
        nedil.add("றீ");
        nedil.add("றூ");
        nedil.add("றே");
        nedil.add("றை");
        nedil.add("றோ");
        nedil.add("றௌ");
        
        nedil.add("னா");
        nedil.add("னீ");
        nedil.add("னூ");
        nedil.add("னே");
        nedil.add("னை");
        nedil.add("னோ");
        nedil.add("னௌ");
        
    }
   boolean  isNedil(String letter)
   {
       /*
       if(nedil.contains(letter))
       {
           System.out.println(letter+"nedil");
       }
       else
       {
            System.out.println(letter+"not nedil");
       }*/
       return nedil.contains(letter);
   }

}
