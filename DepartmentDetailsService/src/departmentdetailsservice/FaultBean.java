package departmentdetailsservice;

import java.io.Serializable;

/*
 * This bean contains the web service fault detail
 */
public class FaultBean implements Serializable {

    private String message;

    public FaultBean() { }

    public String getMessage() {
          return message;
    }

    public void setMessage(String message) {
          this.message = message;
    }
}
