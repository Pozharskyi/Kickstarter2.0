package com.ivanpozharskyi.kickstarter2.usertags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ScriptIncluder extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();

		try {

			JspFragment f = getJspBody();
			if (f != null) {
				f.invoke(out);
			}
			out.println("<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->");
			out.println("<script src=\"./styles/js/jquery-2.1.4.min.js\"></script>");
			out.println("<!-- Include all compiled plugins (below), or include individual files as needed -->");
			out.println("<script src=\"/EpamWebApp/styles/js/bootstrap.min.js\"></script>");

		} catch (java.io.IOException ex) {
			throw new JspException("Error in ScriptIncluder tag", ex);
		}
	}
}
