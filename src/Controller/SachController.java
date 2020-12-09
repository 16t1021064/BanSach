package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoaiBean;
import Bean.SachBean;
import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoaiBo l = new LoaiBo();
			ArrayList<LoaiBean> dsloai = l.getloai();
			request.setAttribute("lstloai", dsloai);
			request.setCharacterEncoding("utf-8");
			String maloai = request.getParameter("ml");
			String ten=request.getParameter("txttk");
			SachBo s = new SachBo();
			if (maloai != null) {
				ArrayList<SachBean> dsma = s.timSachTheoLoai(maloai);
				request.setAttribute("lstma", dsma);
			} else if (ten!=null) {
				ArrayList<SachBean> dstk =s.timSachTheoTen(ten);
				request.setAttribute("lsttk", dstk);
			} else {
				ArrayList<SachBean> dssach = s.getsach();
				request.setAttribute("lstsach", dssach);
			}
			RequestDispatcher rd = request.getRequestDispatcher("htsach.jsp");
			rd.forward(request, response);
		} catch (Exception tt) {
			response.getWriter().println("<html><body>"+tt.getMessage()+"<html><body>");
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
