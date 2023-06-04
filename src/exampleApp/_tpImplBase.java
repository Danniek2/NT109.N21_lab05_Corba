package exampleApp;


/**
* exampleApp/_tpImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from exampleApp.idl
* Sunday, June 4, 2023 7:34:52 PM ICT
*/

public abstract class _tpImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements exampleApp.tp, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _tpImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("sub", new java.lang.Integer (1));
    _methods.put ("mul", new java.lang.Integer (2));
    _methods.put ("div", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // exampleApp/tp/add
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // exampleApp/tp/sub
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.sub (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 2:  // exampleApp/tp/mul
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.mul (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 3:  // exampleApp/tp/div
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.div (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:exampleApp/tp:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _tpImplBase
