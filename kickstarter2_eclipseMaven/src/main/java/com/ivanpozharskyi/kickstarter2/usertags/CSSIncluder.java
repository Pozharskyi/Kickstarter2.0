package com.ivanpozharskyi.kickstarter2.usertags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CSSIncluder extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();

		try {

			JspFragment f = getJspBody();
			if (f != null) {
				f.invoke(out);
			}
			out.println("<!-- Bootstrap -->");
			out.println("<link href=\"/EpamWebApp/styles/css/bootstrap.min.css\" rel=\"stylesheet\">");
			out.println("<link href=\"/EpamWebApp/styles/css/sticky-footer.css\" rel=\"stylesheet\">");

		} catch (java.io.IOException ex) {
			throw new JspException("Error in CSSincluder tag", ex);
		}
	}
}
