package kewe.cipher;

import java.util.Arrays;
/**
 * This class implements a substitution cipher
 * @author wedens
 *
 */
public class Substitution implements Cipher
{
   private static final int ALPHABET_SIZE = 26;
   private char[]           alphabet      = null;

   /**
    * Constructor
    */
   public Substitution()
   {
      alphabet = new char[Substitution.ALPHABET_SIZE];
   }
   
   /**
    * This function encrypts a char[] by using a given alphabet for substitution
    * @param message message to encode
    * @param key substituted alphabet
    * @return encrypted string
    * @throws CipherException
    */
   public char[] encrypt(char[] message, String key) throws CipherException
   {
      char[] emessage = new char[message.length];
      
      if (verifyKey(key))
      {
         this.alphabet = Arrays.copyOf(key.toCharArray(), key.length());
         
         for(int i=0; i < message.length; ++i)
         {
            if (message[i] == ' ')
            {
               emessage[i] = ' ';
            }
            else if (message[i] > 'a' && message[i] < 'z')
            {
               emessage[i] = this.alphabet[(message[i] - 'a')];
            }
            else if (message[i] > 'A' && message[i] < 'Z')
            {
               emessage[i] = this.alphabet[(message[i] - 'A')];
            }
            else
            {
               throw new CipherException("Bad Character");
            }
         }
      }
      else
      {
         throw new CipherException("Bad Key Value");
      }
      return emessage;
   }

   /**
    * This function decrypts a char[] by using a given alphabet for substitution
    * @param message message to decode
    * @param key substituted alphabet
    * @return decrypted string
    * @throws CipherException
    */
   public char[] decrypt(char[] message, String key) throws CipherException
   {
      char[] emessage = new char[message.length];
      
      if (verifyKey(key))
      {
      }
      else
      {
         throw new CipherException("Bad Key Value");
      }
      return emessage;
   }
   
   /**
    * This function verifies that the key given only contains a full alphabet 
    * @param key alphabet used to decode
    * @return true if input contains exactly one of each letter, false otherwise
    */
   private boolean verifyKey(String key)
   {
      boolean status = true;
      
      if (key.length() != ALPHABET_SIZE)
      {
         status = false;
      }
      else
      {
         key = key.toUpperCase();
         char[] keyArray = key.toCharArray();
         Arrays.sort(keyArray);
         
         for(int i=0; i<keyArray.length; ++i)
         {
            if ((keyArray[i] - 'A') != i)
            {
               status = false;
               break;
            }
         }
      }
      return status;
   }
}
