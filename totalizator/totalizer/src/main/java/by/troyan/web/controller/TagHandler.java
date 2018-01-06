package by.troyan.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagHandler. Just to demonstrate works with own tag. Print some info
 */


public class TagHandler extends TagSupport {
    private final static Logger LOG = LogManager.getLogger(TagSupport.class);
    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("&copy; Anton Troyan \"Win with us\" 2018");
        } catch (IOException exc) {
            LOG.error(exc);
            throw new JspException("Error: " + exc.getMessage());
        }
        return SKIP_BODY;
    }
}

