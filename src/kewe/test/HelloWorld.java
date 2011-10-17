package kewe.test;

import java.util.Random;

import kewe.cipher.*;

public class HelloWorld
{
   public static void main(String[] args)
   {
      String key     = "QWERTYUIOPASDFGHJKLZXCVBNM";
      String message = "hello there";
      
      Integer[] test = new Integer[5];
      int[] ind      = new int[5];
      java.util.Random gen = new Random();
      
      for(int i=0; i<ind.length; ++i)
      {
         ind[i] = i;
         test[i] = (Math.abs(gen.nextInt()) % 100) + 1;
      }
      
      kewe.util.Algorithm.SortInd(test, ind);
      
      Substitution s = new Substitution();
      
      try
      {
         char[] emessage = s.encrypt(message.toCharArray(), key);
         System.out.println(emessage);
         
         char[] original = s.decrypt(emessage, key);
         System.out.println(original);
         
      }
      catch(CipherException e)
      {
         e.printStackTrace();
      }
   }
}