package departmentdetailsservice;

import javax.xml.ws.WebFault;


/*
 * The Fault class represents the details of DepartmentFinder fault
 * @author Bob Webster
 * @version 1.0, April 2010
 */  
public class DepartmentFinderFault extends Exception  {

      static final long serialVersionUID = 30;

      private FaultBean faultinfo;
      private String message;

     
      
      public DepartmentFinderFault(String message, FaultBean faultinfo)
      {
        super(message);
        this.message = message;
        this.faultinfo = faultinfo;
      }
      
      public DepartmentFinderFault(String message, FaultBean faultinfo, Throwable cause)
      {   
        super(message, cause);
        this.message = message;
        this.faultinfo = faultinfo;
      }

     /*
     * Set the description name value
     * @param  description  the description  value to be set
     */
     public void setDescription(String message) {
      this.message = message;
     }

     /*
     * Returns  the fault description value, an application specific value
     * @return  an english error description 
     */
     public String getDescription() {
       return message;
     }
     
      /*
      * Set the soapInfo value
      * @param  soapInfo the soap fault message info to be set
      */
      public void setFaultInfo(FaultBean faultinfo) {
       this.faultinfo = faultinfo;
      }

      /*
      * Returns  the fault description value, an application specific value
      * @return  an english error description 
      */
      public FaultBean getFaultInfo() {
        return faultinfo;
      }
  }