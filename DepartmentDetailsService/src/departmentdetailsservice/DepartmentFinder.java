package departmentdetailsservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;


/*
 * The Department Finder class returns the details of a specified department
 * @author Bob Webster
 * @version 1.0, April 2012
 */


@WebService
public class DepartmentFinder {

  HashMap<String, DepartmentDetails> departments;

  public DepartmentFinder() {
    super();
    initialize();
  }

  /*
  * Initializes test data for departments 1,2 and 3
  */
  private void initialize() {
    departments = new HashMap<String, DepartmentDetails>();
    departments.put("1", new DepartmentDetails("1", "Accounts Payable", "44", "Finance", "joeBeen@westco.com"));
    departments.put("2", new DepartmentDetails("2", "Inside Sales", "22", "Sales", "peterBaines@westco.com"));
    departments.put("3", new DepartmentDetails("3", "Shipping", "45", "Logistics", "alGreen@westco.com"));
    departments.put("4", new DepartmentDetails("4", "Legal", "80", "Legal", "sallyZink@westco.com"));
    }

  /*
  * Returns  the details for the selected department
  * @param   deptNumber   the department number
  * @return  a DepartmentDetails object containing the department details for the selected department or null
  */

    @WebMethod
    public DepartmentDetails getDepartmentDetails(@WebParam(name = "deptNumber")
        String deptNumber) throws DepartmentFinderFault {

    if(deptNumber == null || deptNumber.length() == 0)
    {
      FaultBean fb = new FaultBean();
      fb.setMessage("Department number cannot be null");
      throw new DepartmentFinderFault("Department number cannot null", fb);
    }
    
    // Simulate a system error using a special department number
    if(deptNumber.equals("99"))
    {
        FaultBean fb = new FaultBean();
        fb.setMessage("Department " + deptNumber + " not found");
        throw new DepartmentFinderFault("System Error retrieving Department " + deptNumber, fb );
    }
    
    DepartmentDetails result = departments.get(deptNumber);

    return result;
  }
  

    /*
    * Returns  the details for the selected department
    * @param   deptNumber   the department number
    * @return  a DepartmentDetails object containing the department details for the selected department or null
    */

    @WebMethod
    public DepartmentDetails getDepartmentByMgrEmailId(@WebParam(name = "mgrEmailId")
        String mgrEmailId) throws DepartmentFinderFault {

      DepartmentDetails department = null;
      
      if(mgrEmailId == null || mgrEmailId.length() == 0)
      {
        FaultBean fb = new FaultBean();
        fb.setMessage("Manager email cannot be null");
        throw new DepartmentFinderFault("Manager email cannot be null", fb);
      }
      
  
      Collection <DepartmentDetails> allDepts = departments.values();

      for(DepartmentDetails dept : allDepts) {
          if(dept.getDepartmentManagerEmail().equals(mgrEmailId)) {
              department = dept;
              break;
          }
      }
  
      return department;
    }
  
    /*
    * Returns  a list of known department numbers
    * @return  a string list containing known department numbers
    */

    @WebMethod
    public List<String>  getDepartments()  {
                                       
       Set<String> keys = departments.keySet();
       ArrayList<String> keyList = new ArrayList<String>();
       keyList.addAll(keys);
       return keyList;
       
    }


    /*
    * A main() method that can be used for simple unit testing.
    * The test can be run from the command line.
    * It can also be run from within JDeveloper
    * by right clicking on the DepartmentFinder.java node in the Application Navigator
    * and choosing Run.
    * The test output will appear in the JDeveloper log window
    */

    @WebMethod(exclude = true)
    public static void main(String args[]) {

      DepartmentFinder df = new DepartmentFinder();

      try {

        // Positive Test
        System.out.println("Finding known department 2");
        System.out.println(df.getDepartmentDetails("2"));
        System.out.println("Test Passed" + "\n");

        // Positive Test
        System.out.println("Get all departments");
        System.out.println(df.getDepartments());
        System.out.println("Test Passed" + "\n");
          
        // Positive Test
        System.out.println("Get department by Manager");
        DepartmentDetails dept1 = df.getDepartmentByMgrEmailId("peterBaines@westco.com");
        if(dept1 == null)
           System.out.println("Test Failed: Returned null for existing department.");
        else {
            System.out.println(dept1.toString());  
            System.out.println("Test Passed" + "\n");
        }
          
        // Negative Test
        System.out.println("Finding unknown department 8");
        DepartmentDetails dept2 = df.getDepartmentDetails("8");
        if(dept2 == null)
        {
            System.out.println("Test Passed" + "\n");
        }
          else System.out.println("Test Failed, returned department for nonexistent department number" + "\n");
          
        // Negative Test
        System.out.println("Get department using non-existent Manager");
        DepartmentDetails dept3 = df.getDepartmentByMgrEmailId("yogiBear@westco.com");
        if(dept3 != null)
             System.out.println("Test Failed: Returned dept for non existent manager.");
        else              
             System.out.println("Test Passed" + "\n");
    

      }
      catch (DepartmentFinderFault f1){
            System.out.println("Caught Exception: "  + f1.getDescription());
            System.out.println("Test Passed" + "\n");
          }


      try {
          // Negative Test
          System.out.println("Finding with null department");
          System.out.println(df.getDepartmentDetails(null));
          System.out.println("Test Failed" + "\n");
      }

      catch (DepartmentFinderFault f2){
            System.out.println("Caught Exception: " + f2.getDescription());
            System.out.println("Test Passed" + "\n");
          }


    }
}
