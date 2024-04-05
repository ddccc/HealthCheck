// (C) OntoOO Inc 2008 Sep
package com;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ZAjax extends HttpServlet {
    static private int cnt = 0;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	res.setContentType("text/html");
	res.setHeader("Cache-Control", "no-cache");
	res.getWriter().write("" + cnt++);
    }
}

