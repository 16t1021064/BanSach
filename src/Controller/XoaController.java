package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.GioHangBo;

/**
 * Servlet implementation class XoaController
 */
@WebServlet("/XoaController")
public class XoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String ms = request.getParameter("ms");
			HttpSession session = request.getSession();
				GioHangBo gh;
				gh = (GioHangBo)session.getAttribute("gh");
				gh.xoa(ms);
				session.setAttribute("gh", gh);
			RequestDispatcher rd=request.getRequestDispatcher("GioHangController");
			rd.forward(request, response);
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch( Exception tt){
			response.getWriter().print("<html><body>"+tt.getMessage()+"<html><body>");
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
