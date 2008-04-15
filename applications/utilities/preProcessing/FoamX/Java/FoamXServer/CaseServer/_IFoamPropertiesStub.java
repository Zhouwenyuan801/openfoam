package FoamXServer.CaseServer;


/**
* FoamXServer/CaseServer/_IFoamPropertiesStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from FoamX.idl
* 02 April 2007 09:53:40 o'clock BST
*/


// ---------------------------------------------------------------------
public class _IFoamPropertiesStub extends org.omg.CORBA.portable.ObjectImpl implements FoamXServer.CaseServer.IFoamProperties
{


  //- Attributes.
  public String[] availableModules ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_availableModules", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return availableModules (        );
            } finally {
                _releaseReply ($in);
            }
  } // availableModules


  //- Root directories to search for cases.
  public String[] rootDirectories ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_rootDirectories", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rootDirectories (        );
            } finally {
                _releaseReply ($in);
            }
  } // rootDirectories


  //- Unexpanded form of rootDirectories.
  public String[] rawRootDirectories ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_rawRootDirectories", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rawRootDirectories (        );
            } finally {
                _releaseReply ($in);
            }
  } // rawRootDirectories

  public void addRootDirectory (String rawRootDir) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addRootDirectory", true);
                $out.write_string (rawRootDir);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addRootDirectory (rawRootDir        );
            } finally {
                _releaseReply ($in);
            }
  } // addRootDirectory

  public void deleteRootDirectory (String rawRootDir) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deleteRootDirectory", true);
                $out.write_string (rawRootDir);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                deleteRootDirectory (rawRootDir        );
            } finally {
                _releaseReply ($in);
            }
  } // deleteRootDirectory


  // Foam types.
  public String[] foamTypes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_foamTypes", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return foamTypes (        );
            } finally {
                _releaseReply ($in);
            }
  } // foamTypes

  public void getFoamType (String foamTypeName, FoamXServer.ITypeDescriptorHolder typeDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getFoamType", true);
                $out.write_string (foamTypeName);
                $in = _invoke ($out);
                typeDesc.value = FoamXServer.ITypeDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getFoamType (foamTypeName, typeDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // getFoamType


  // Geometry types.
  public String[] geometryTypes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_geometryTypes", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return geometryTypes (        );
            } finally {
                _releaseReply ($in);
            }
  } // geometryTypes

  public void getGeometryType (String geometryTypeName, FoamXServer.CaseServer.IGeometryDescriptorHolder geometryDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getGeometryType", true);
                $out.write_string (geometryTypeName);
                $in = _invoke ($out);
                geometryDesc.value = FoamXServer.CaseServer.IGeometryDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getGeometryType (geometryTypeName, geometryDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // getGeometryType


  // Patch types.
  public String[] patchTypes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_patchTypes", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return patchTypes (        );
            } finally {
                _releaseReply ($in);
            }
  } // patchTypes

  public void getPatchType (String patchTypeName, FoamXServer.CaseServer.IPatchDescriptorHolder patchDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getPatchType", true);
                $out.write_string (patchTypeName);
                $in = _invoke ($out);
                patchDesc.value = FoamXServer.CaseServer.IPatchDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getPatchType (patchTypeName, patchDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // getPatchType

  public void findPatchType (String patchTypeName, FoamXServer.CaseServer.IPatchDescriptorHolder patchDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("findPatchType", true);
                $out.write_string (patchTypeName);
                $in = _invoke ($out);
                patchDesc.value = FoamXServer.CaseServer.IPatchDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                findPatchType (patchTypeName, patchDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // findPatchType


  // Patch field types.
  public String[] patchFieldTypes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_patchFieldTypes", true);
                $in = _invoke ($out);
                String $result[] = FoamXServer.StringListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return patchFieldTypes (        );
            } finally {
                _releaseReply ($in);
            }
  } // patchFieldTypes

  public void getPatchFieldType (String patchFieldTypeName, FoamXServer.ITypeDescriptorHolder patchFieldDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getPatchFieldType", true);
                $out.write_string (patchFieldTypeName);
                $in = _invoke ($out);
                patchFieldDesc.value = FoamXServer.ITypeDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getPatchFieldType (patchFieldTypeName, patchFieldDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // getPatchFieldType

  public void findPatchFieldType (String patchFieldTypeName, FoamXServer.ITypeDescriptorHolder patchFieldDesc) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("findPatchFieldType", true);
                $out.write_string (patchFieldTypeName);
                $in = _invoke ($out);
                patchFieldDesc.value = FoamXServer.ITypeDescriptorHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                findPatchFieldType (patchFieldTypeName, patchFieldDesc        );
            } finally {
                _releaseReply ($in);
            }
  } // findPatchFieldType


  // FOAM controlDict
  public void getFoamControlDict (FoamXServer.IDictionaryEntryHolder controlDict) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getFoamControlDict", true);
                $in = _invoke ($out);
                controlDict.value = FoamXServer.IDictionaryEntryHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getFoamControlDict (controlDict        );
            } finally {
                _releaseReply ($in);
            }
  } // getFoamControlDict


  // Application classes.
  public FoamXServer.ApplicationDescriptor[] applicationes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_applicationes", true);
                $in = _invoke ($out);
                FoamXServer.ApplicationDescriptor $result[] = FoamXServer.ApplicationDescriptorListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return applicationes (        );
            } finally {
                _releaseReply ($in);
            }
  } // applicationes

  public void getApplication (String appName, FoamXServer.CaseServer.IApplicationHolder app) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getApplication", true);
                $out.write_string (appName);
                $in = _invoke ($out);
                app.value = FoamXServer.CaseServer.IApplicationHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getApplication (appName, app        );
            } finally {
                _releaseReply ($in);
            }
  } // getApplication

  public void addApplication (String appName, FoamXServer.CaseServer.IApplicationHolder app) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addApplication", true);
                $out.write_string (appName);
                $in = _invoke ($out);
                app.value = FoamXServer.CaseServer.IApplicationHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addApplication (appName, app        );
            } finally {
                _releaseReply ($in);
            }
  } // addApplication

  public void deleteApplication (String appName) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deleteApplication", true);
                $out.write_string (appName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                deleteApplication (appName        );
            } finally {
                _releaseReply ($in);
            }
  } // deleteApplication

  public void cloneApplication (String appNameSrc, String appNameDest, String appDestPath, FoamXServer.CaseServer.IApplicationHolder app) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cloneApplication", true);
                $out.write_string (appNameSrc);
                $out.write_string (appNameDest);
                $out.write_string (appDestPath);
                $in = _invoke ($out);
                app.value = FoamXServer.CaseServer.IApplicationHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                cloneApplication (appNameSrc, appNameDest, appDestPath, app        );
            } finally {
                _releaseReply ($in);
            }
  } // cloneApplication


  // Foam utilities.
  public FoamXServer.ApplicationDescriptor[] utilities ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_utilities", true);
                $in = _invoke ($out);
                FoamXServer.ApplicationDescriptor $result[] = FoamXServer.ApplicationDescriptorListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return utilities (        );
            } finally {
                _releaseReply ($in);
            }
  } // utilities

  public void getUtilityControlDict (String utilityName, String rootDir, String caseName, FoamXServer.IDictionaryEntryHolder controlDict) throws FoamXServer.FoamXError, FoamXServer.FoamXIOError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getUtilityControlDict", true);
                $out.write_string (utilityName);
                $out.write_string (rootDir);
                $out.write_string (caseName);
                $in = _invoke ($out);
                controlDict.value = FoamXServer.IDictionaryEntryHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getUtilityControlDict (utilityName, rootDir, caseName, controlDict        );
            } finally {
                _releaseReply ($in);
            }
  } // getUtilityControlDict


  //- Validation.
  public void validate () throws FoamXServer.FoamXError, FoamXServer.FoamXIOError, FoamXServer.ValidationError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("validate", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/ValidationError:1.0"))
                    throw FoamXServer.ValidationErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                validate (        );
            } finally {
                _releaseReply ($in);
            }
  } // validate


  //- Persistence.
  public void saveSystemProperties () throws FoamXServer.FoamXError, FoamXServer.FoamXIOError, FoamXServer.ValidationError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("saveSystemProperties", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/ValidationError:1.0"))
                    throw FoamXServer.ValidationErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                saveSystemProperties (        );
            } finally {
                _releaseReply ($in);
            }
  } // saveSystemProperties

  public void saveUserProperties () throws FoamXServer.FoamXError, FoamXServer.FoamXIOError, FoamXServer.ValidationError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("saveUserProperties", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:FoamXServer/FoamXError:1.0"))
                    throw FoamXServer.FoamXErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/FoamXIOError:1.0"))
                    throw FoamXServer.FoamXIOErrorHelper.read ($in);
                else if (_id.equals ("IDL:FoamXServer/ValidationError:1.0"))
                    throw FoamXServer.ValidationErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                saveUserProperties (        );
            } finally {
                _releaseReply ($in);
            }
  } // saveUserProperties

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:FoamXServer/CaseServer/IFoamProperties:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _IFoamPropertiesStub
