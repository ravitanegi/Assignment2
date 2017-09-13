

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

public class WebCalendar
{
  
  protected GregorianCalendar m_gc;
  
  public WebCalendar()
  {
    m_gc = new GregorianCalendar();
    m_sdf = new SimpleDateFormat();
  }
  
  
  public void setYear (int _iYear) { m_gc.set(Calendar.YEAR,_iYear); }
  
 
  public void setMonth (int _iMonth) { m_gc.set(Calendar.MONTH,_iMonth); }
  
 
  public String getMonth()
  {
    m_sdf.applyPattern("MMMM");
    return m_sdf.format(m_gc.getTime()).toString();
  }
  
  
  public GregorianCalendar getCalendar() { return m_gc; }
  
 
  public String[]
    getDays()
  {
    String days[] = new String
      [m_gc.getMaximum(Calendar.DAY_OF_WEEK) - m_gc.getMinimum(Calendar.DAY_OF_WEEK) + 1];
    m_gc.set(Calendar.DAY_OF_WEEK,1);
    
    for (int i=0; i<days.length; i++) {
      days[i] = m_sdf.format(m_gc.getTime()).toString();
      m_gc.roll(Calendar.DAY_OF_WEEK,true);
    }
    
    return days;
  }
  
  /** */
  public String
    renderOneMonth (String _sTableWidth,
            String _sCellWidth)
            //PrintWriter _out)
  {
    StringBuffer sb = new StringBuffer();
    //out = response.getWriter();
    
    sb.append("<table border='1' width='").append(_sTableWidth).append("'")
    .append(" cellspacing='0' cellpadding='0'>")
    .append("<tr><td align='center' colspan='7'>").append(getMonth())
    .append("</td></tr>")
    .append("<tr>");
    
    String days[] = getDays();
    for (int i=0; i<days.length; i++) {
      sb.append("<td width='").append(_sCellWidth).append("'")
      .append(" align='center'>").append(days[i]).append("</td>");
    }
    
    sb.append("</tr>");
    
    m_gc.set(Calendar.DAY_OF_MONTH,1);
    boolean finish = false;
    
    for (;;) {
      sb.append("<tr>");
      
      for (int i=0; i<days.length; i++) {
        Date t = m_gc.getTime();
        m_sdf.applyPattern("EEEE");
        
        if (days[i].equals(m_sdf.format(t).toString())) {
          m_sdf.applyPattern("d");
          sb.append("<td align='center'>")
          .append(m_sdf.format(t).toString()).append("</td>");
          
          if (m_gc.get(Calendar.DAY_OF_MONTH) == m_gc.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            finish = true;
            break;
          }
          
          m_gc.roll(Calendar.DAY_OF_MONTH,true);
        }
        else {
          sb.append("<td align='center'>&nbsp;</td>");
        }
      }
      
      sb.append("</tr>");
      if (finish) break;
    }
    
    sb.append("</table>");
    
    return sb.toString();
  }
  
  
}


</body>
</html>
%>