package departmentdetailsservice;

/*
 * The DepartmentDetails class represents the details of a department within an organization
 * @author Bob Webster
 * @version 1.0, April 2010
 */
  public class DepartmentDetails {
    
    String departmentNumber;
    String departmentName;
    String departmentCostCenter;
    String departmentOrg;
    String departmentManagerEmail;
    
    public DepartmentDetails() {
      super();
    }
    
    
    public DepartmentDetails(String deptNumber, String deptName, String deptCostCtr, String deptOrg, String deptMgrEmail) {
      super();
      departmentNumber = deptNumber;
      departmentName =  deptName;
      departmentCostCenter = deptCostCtr;
      departmentOrg =  deptOrg;
      departmentManagerEmail = deptMgrEmail;                                                                      
    }
    
    /*
     * Returns a printable string containing the department details
     */
    public String toString() {
       StringBuffer sb = new StringBuffer();
       sb.append(" Department Number: " + departmentNumber + ",  Name: " + departmentName + ",  Cost Center: " +  departmentCostCenter );
       sb.append(",  Org: " + departmentOrg + ",  Mgr Email: " + departmentManagerEmail);
       return sb.toString();
    }

    /*
    * Set the department number value
    * @param  departmentNumber  the department number value to be set
    */
    public void setDepartmentNumber(String departmentNumber) {
      this.departmentNumber = departmentNumber;
    }

    /*
    * Returns the department number value
    * @return  the current department number value 
    */
    public String getDepartmentNumber() {
      return departmentNumber;
    }

    /*
    * Set the department name value
    * @param  departmentName  the department name value to be set
    */
    public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
    }

   /*
   * Returns the department name value
   * @return  the current department name value 
   */
    public String getDepartmentName() {
      return departmentName;
    }

    /*
    * Set the department cost center value
    * @param  departmentCostCenter  the department cost center value to be set
    */
    public void setDepartmentCostCenter(String departmentCostCenter) {
      this.departmentCostCenter = departmentCostCenter;
    }

    /*
    * Returns the department cost center value
    * @return  the current department cost center value 
    */
    public String getDepartmentCostCenter() {
      return departmentCostCenter;
    }

    /*
    * Set the department organization center value
    * @param  departmentOrg  the department organization value to be set
    */
    public void setDepartmentOrg(String departmentOrg) {
      this.departmentOrg = departmentOrg;
    }

    /*
    * Returns the department organization value
    * @return  the current department organization value 
    */
    public String getDepartmentOrg() {
      return departmentOrg;
    }

    /*
    * Set the department manager email value
    * @param  departmentManagerEmail  the department manager email value to be set
    */
    public void setDepartmentManagerEmail(String departmentManagerEmail) {
      this.departmentManagerEmail = departmentManagerEmail;
    }

    /*
    * Returns the department manager email value
    * @return  the current department manager emai value 
    */
    public String getDepartmentManagerEmail() {
      return departmentManagerEmail;
    }
  }