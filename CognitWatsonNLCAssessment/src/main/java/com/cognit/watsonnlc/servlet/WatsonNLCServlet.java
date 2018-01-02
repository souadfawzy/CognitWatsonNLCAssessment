package com.cognit.watsonnlc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognit.watsonnlc.constants.NLCServiceConstants;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

/**
 * Servlet implementation class WatsonNLCServlet
 */
public class WatsonNLCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WatsonNLCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processQuestion(request, response);
	}

	/**
	 * Find suitable classifier for asked question from 
	 * trained data by call NLC service classify method
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String textToClassify = request.getParameter("question");

		if (!textToClassify.isEmpty() && textToClassify != null) {
			NaturalLanguageClassifier service = new NaturalLanguageClassifier();
			/*
			 * Instantiates a new natural language service by username and
			 * password service credentials
			 */
			service.setUsernameAndPassword(NLCServiceConstants.USER_NAME, NLCServiceConstants.PASSWORD);
			/* Returns classification Details for question */
			Classification classification = service.classify(NLCServiceConstants.CLASSIFIER_ID, textToClassify)
					.execute();
			if (classification != null && classification.getTopClass() != null
					&& !classification.getTopClass().isEmpty())
				request.setAttribute("result", classification.getTopClass());

		}
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
