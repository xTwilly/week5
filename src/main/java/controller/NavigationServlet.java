package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.fruit;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String path = "/viewAllItemsServlet";
		String act = request.getParameter("doThisToItem");
		fruitHelper dao = new fruitHelper();
		
		if(act.equals("delete")) {
			try {
				Integer tempid = Integer.parseInt(request.getParameter("id"));
				fruit itemToDelete = dao.searchForItemById(tempid);
				dao.deleteItem(itemToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
		}
		else if(act.equals("edit")) {
			try {
				Integer tempid =Integer.parseInt(request.getParameter("id"));
				fruit itemToEdit = dao.searchForItemById(tempid);
				request.setAttribute("itemToEdit", itemToEdit);
				path="/edit-item.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if(act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
