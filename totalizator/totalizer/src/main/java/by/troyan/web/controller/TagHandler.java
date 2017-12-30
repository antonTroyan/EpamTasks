package by.troyan.web.controller;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagHandler. Just to demonstrate works with own tag. Print some info
 */


public class TagHandler extends TagSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("&copy; Anton Troyan \"Win with us\" 2018");
        } catch (IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }
}

