package FoamXServer;


/**
* FoamXServer/MessageType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from FoamX.idl
* 02 April 2007 09:53:40 o'clock BST
*/

public class MessageType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static FoamXServer.MessageType[] __array = new FoamXServer.MessageType [__size];

  public static final int _M_DIAGNOSTIC = 0;
  public static final FoamXServer.MessageType M_DIAGNOSTIC = new FoamXServer.MessageType(_M_DIAGNOSTIC);
  public static final int _M_WARNING = 1;
  public static final FoamXServer.MessageType M_WARNING = new FoamXServer.MessageType(_M_WARNING);
  public static final int _M_ERROR = 2;
  public static final FoamXServer.MessageType M_ERROR = new FoamXServer.MessageType(_M_ERROR);

  public int value ()
  {
    return __value;
  }

  public static FoamXServer.MessageType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected MessageType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class MessageType
