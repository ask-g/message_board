package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.Message;

@WebServlet("/show")
public class showServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public showServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em =DBUtil.createEntityManager();

        Message m =em.find(Message.class, Integer.paeseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("message", m);
        RequestDisoatcher rd =request.getRewuestDispatcher("/WEB-INF/views/messages/show.jsp");
        rd.forward(request,response);


    }

}
