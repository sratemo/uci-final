package teamc;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/OpenDefects")
public class OpenDefects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Get choice of project to list defects from OpenDefectsPage.jsp
		String choice = request.getParameter("choice");
        if(choice == null){
        	choice = "all";
        }
		System.out.println("What was the choice: " + choice);
		
       //Get open defects list with Project status.
		ArrayList<Defect> allDefects = DataBaseHelper.openProjectDefects();
        //System.out.println("Inside Servlet found allDefects: " + allDefects.get(0).getSummary());        
        
        
        //Choose only defects from open projects & that are open.
		ArrayList<Defect> openDefects = new ArrayList<Defect>();
        String noDefects = "noDefects";
		
		for(Defect openOnly : allDefects){
		
			if(choice.equals("all") && openOnly.getStatus().equals("open")){
	    		openDefects.add(openOnly);
//              System.out.println(openDefects.get(0).getStatus());
	    	}
	    	else if(choice.equals("ProjectA") && openOnly.getapplication().equals("ProjectA")  && openOnly.getStatus().equals("open")){
	    		openDefects.add(openOnly);
	    	}
	    	else if(choice.equals("ProjectB") && openOnly.getapplication().equals("ProjectB")  && openOnly.getStatus().equals("open")){
	    		openDefects.add(openOnly);
	    	}
	    	else if(choice.equals("ProjectC") && openOnly.getapplication().equals("ProjectC")  && openOnly.getStatus().equals("open")){
	    		openDefects.add(openOnly);
	    	}	    		
		}

		int size = openDefects.size();
		if (size == 0){
			request.setAttribute("passby", noDefects);
	        System.out.println(noDefects);
		}else {
		    request.setAttribute("passby", openDefects);			
	        System.out.println("Inside Servlet found ArrayList3: " + openDefects.get(0).getSummary());
		}
		

		
		//Instantiate the dispatcher
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsp/OpenDefectPage.jsp");

		dispatcher.forward(request,  response);;

		openDefects = null;
	}  

}
