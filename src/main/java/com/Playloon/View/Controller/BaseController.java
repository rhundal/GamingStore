package com.Playloon.View.Controller;

import com.Playloon.Entities.User;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Exceptions.InfrastructureException;
import com.Playloon.Exceptions.ValidationException;
import org.apache.log4j.Logger;
import com.Playloon.View.util.Message;
import com.Playloon.View.util.MessageType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class BaseController extends HttpServlet{

    final static Logger logger = Logger.getLogger(BaseController.class);

    protected Message processException(Exception e) {

        if (e instanceof ValidationException) {
            return Message.buildWarningMessage(e.getMessage());
        } else if (e instanceof EntityNotFoundException) {
            logger.error(e.getMessage(), e);
            return Message.buildWarningMessage(e.getMessage());
        } else if (e instanceof InfrastructureException) {
            String errorId = UUID.randomUUID().toString();
            logger.error(errorId+" - "+e.getMessage(), e);
            return Message.buildDangerMessage(errorId+": Infrastructure error, please try again later");
        } else {
            String errorId = UUID.randomUUID().toString();
            logger.error(errorId+" - "+e.getMessage(), e);
            return Message.buildDangerMessage(errorId+": Unexpected error, please try again later");
        }
    }


    protected void verifyLoggedUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User)request
                .getSession()
                .getAttribute("loggedUser");

        if (user == null){
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/user/loginForm.jsp");

            dispatcher.forward(request, response);
        }
    }

}
