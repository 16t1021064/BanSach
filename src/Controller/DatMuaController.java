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
 * Servlet implementation class DatMuaController
 */
@WebServlet("/DatMuaController")
public class DatMuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatMuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ms = request.getParameter("ms");
		String ts = request.getParameter("ts");
		String giatam = request.getParameter("gia");
		HttpSession session =  request.getSession();
		if(ms !=null) {
			GioHangBo gh;
			if(session.getAttribute("gh")==null) {
				gh= new GioHangBo();
				session.setAttribute("gh", gh);
			}
			gh= (GioHangBo)session.getAttribute("gh");
			gh.Them(ms, ts, Long.parseLong(giatam), 1, "maloai");
			session.setAttribute("gh", gh);
		}
		RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
		rd.forward(request, response);
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
