package teamc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get Database of all defects.
		ArrayList<Defect> searchedDefect = new ArrayList<Defect>();

		// request.getParameter

		String defectName = request.getParameter("commonKey");

		searchedDefect = DataBaseHelper.searchDefect("defectName", defectName);

		// setting up Dispatcher
		RequestDispatcher dispatcher = getServletConfig().getServletContext()
				.getRequestDispatcher("/jsp/showDetails.jsp");

		// set values to request

		request.setAttribute("application", searchedDefect.get(0)
				.getapplication());
		request.setAttribute("assignee", searchedDefect.get(0).getAssignee());
		request.setAttribute("defectName", searchedDefect.get(0)
				.getDefectName());
		request.setAttribute("summary", searchedDefect.get(0).getSummary());
		request.setAttribute("priority", searchedDefect.get(0).getPriority());
		request.setAttribute("status", searchedDefect.get(0).getStatus());
		request.setAttribute("description", searchedDefect.get(0).getDescription());

		// forward to JSP
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}
}