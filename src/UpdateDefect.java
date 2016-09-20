package teamc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by John on 9/10/2016.
 */
@WebServlet(name = "UpdateDefect", urlPatterns = ("/UpdateDefect"))
public class UpdateDefect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve data from submitted form through createDefects.html and create a new Defect object using retrieved data
        String application = request.getParameter("application");
        String assignee = request.getParameter("assignee");
        String stringDefectName = request.getParameter("defectName");
        Integer defectName = Integer.valueOf(stringDefectName);
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");
        String summary = request.getParameter("summary");

        Defect tempDefect = new Defect(application, assignee, defectName, description, priority, status, summary);

        Defect defect  = DataBaseHelper.updateDefect(tempDefect);

        //Call static method sendEmail from Email Class passing in defect as the parameter
        Email.sendEmail(defect);

        //After sending the email, create dispatcher object to forward request and response to CreateDefect.jsp
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/UpdateDefect.jsp");
        request.setAttribute("confirmation", "Defect-" + defect.getDefectName() + ": " + defect.getSummary() + " has been successfully updated.");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
