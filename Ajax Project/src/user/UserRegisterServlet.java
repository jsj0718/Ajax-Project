package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID = request.getParameter("userID");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		response.getWriter().write(register(userID, userAge, userGender, userEmail) + "");	// 문자열 형태로 보내야 오류 발생 X
	}
	
	public int register(String userID, String userAge, String userGender, String userEmail) {
		User user = new User();
		try {
			user.setUserID(userID);
			user.setUserAge(Integer.parseInt(userAge));
			user.setUserGender(userGender);
			user.setUserEmail(userEmail);
		} catch (Exception e) {
			return 0;	// 오류 발생
		}
		return new UserDAO().register(user);	// 성공 (1 이상)
	}

}
