package FoamXServer;

/**
* FoamXServer/FoamXTypeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from FoamX.idl
* 02 April 2007 09:53:40 o'clock BST
*/


// -------------------------------------------------------------------------
public final class FoamXTypeHolder implements org.omg.CORBA.portable.Streamable
{
  public FoamXServer.FoamXType value = null;

  public FoamXTypeHolder ()
  {
  }

  public FoamXTypeHolder (FoamXServer.FoamXType initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = FoamXServer.FoamXTypeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    FoamXServer.FoamXTypeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return FoamXServer.FoamXTypeHelper.type ();
  }

}
