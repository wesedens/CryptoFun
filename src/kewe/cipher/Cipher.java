
package kewe.cipher;

/**
 * This File provides the 
 * @author wedens
 *
 */
public interface Cipher
{
   /**
    * All ciphers must implement an encrypt function to code a message
    * @param message a char representation of the message to encode
    * @param key a possible key
    * @return char array of encoded text
    * @throws CipherException
    */
   public char[] encrypt(char[] message, String key) throws CipherException;
   
   /**
    * All ciphers must implement a decrypt function to decode a message
    * @param message char representation of the coded message
    * @param key possible decrpytion key
    * @return decrypted message
    * @throws CipherException
    */
   public char[] decrypt(char[] message, String key) throws CipherException;   
}
