<%@ page import="java.util.*" %>
<html>
    <body>
        <h1 align="center">Beer Recommendation JSP</h1>        
            <%
                List styles = (List) request.getAttribute("styles");
                Iterator itr = styles.iterator();
                while(itr.hasNext()){
                    out.print("<br>try: "+ itr.next());
                }
            %>
    </body>
</html>
