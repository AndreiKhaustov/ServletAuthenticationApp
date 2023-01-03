package by.andrei.servletapp.controllers;

import by.andrei.servletapp.dao.PersonDAO;

import jsp.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServletController extends HttpServlet {

    private PersonDAO personDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rp = req.getRequestDispatcher("/login.jsp");
        rp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person();
        personDAO = new PersonDAO();
        HttpSession session = req.getSession();

        person.setUsername(req.getParameter("username"));
        person.setPassword((req.getParameter("password")));

            if(personDAO.userLogin(person))
            {

               RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
                rd.forward(req, resp);
            }
            else {

                resp.sendRedirect("login.jsp");
                session.setAttribute("ErrorMessage","Login Failed");
            }

    }
}
