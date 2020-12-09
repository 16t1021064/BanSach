package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.DangNhapBo;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructorr stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un =  request.getParameter("txtun");
		String pass= request.getParameter("txtpass");
		HttpSession session= request.getSession();
		DangNhapBo dn = new DangNhapBo();
		try {
			if(dn.ktDangNhap(un, pass))
			{
				session.setAttribute("un", un);
				response.sendRedirect("SachController");
			}
			else 
				session.setAttribute("un", "");
				RequestDispatcher rd =  request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
		}
			catch (Exception tt) {
				response.getWriter().println("<html><body>"+tt.getMessage()+"<html><body>");
				// TODO: handle exception
			}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
