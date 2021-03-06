package controllers;
import twitter.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;//para evitar que el RequestDispatcher no de error

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();//iniciamos sesion
        //Recogemos los parametros que nos ha enviado el usuario
        String short_name = request.getParameter("short_name");
        String long_name = request.getParameter("long_name");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        try(DBManager db = new DBManager()){
  				int resultado = db.isDataFree(short_name, long_name,mail);

  				if (resultado == 0) {
            //creamos el usuario que vamos a guardar en la
            User new_user= new User();
            new_user.setShort_name(short_name);
            new_user.setLong_name(long_name);
            new_user.setMail(mail);
            new_user.setPassword(password);

            db.addUser(new_user);//Guardamos el nuevo usuario en la BD

            //una vez comprobado que todo esta bien, redirigimos a la pagina principal del usuario
            response.sendRedirect("iniciosesion.html");
          }
		   } catch (SQLException | NamingException e){
				e.printStackTrace();
				response.sendError(500);
			}
    }
}
