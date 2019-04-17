package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import net.sf.json.JSONArray;
















@WebServlet("*.xml")
public class XML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XML() {
   
    }	
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("service");
		List<DTO> list=DAO.getInstance().getList();
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		Element el=new Element("page");
		for(DTO dto:list) {
			Element testem=new Element("testem");
			Element id=new Element("id");
			id.setText(String.valueOf(dto.getId()));
			testem.addContent(id);
			Element day=new Element("day");
			day.setText(String.valueOf(dto.getDate()));
			testem.addContent(day);
			Element content=new Element("content");
			content.setText(String.valueOf(dto.getContent()));
			testem.addContent(content);
			el.addContent(testem);
		}
	
		Document d=new Document();
		d.setContent(el);
		XMLOutputter out=new XMLOutputter();
		out.setFormat(Format.getPrettyFormat());
		out.output(d,pw);
		
		
		
		  
		  JSONArray js=JSONArray.fromObject(new ArrayList()); 
		  
	
		  System.out.println(js);
		  
		  
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		
	}

}
