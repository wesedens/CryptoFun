package kewe.cipher;

/**
 * This is the base class for all cipher erros
 * @author wedens
 *
 */
public class CipherException extends Exception
{
   /**
    * 
    */
   private static final long serialVersionUID = 5024690439975232117L;
   
   /**
    * Default constructor
    */
   CipherException()
   {
      super();
   }
   
   /**
    * Constructor with error message
    * @param message error message
    */
   CipherException(String message)
   {
      super(message);
   }
}
