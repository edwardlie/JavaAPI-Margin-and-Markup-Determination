package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayhello()
	{
		String resource ="<?xml version='1.0'?>" 
				+ "<hello> Hello from XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayhelloJSON()
	{
		String resource = null;
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayhelloHTML(@QueryParam("name") String name, @QueryParam("revenue") double revenue, @QueryParam("COGS") double cogs){
		System.out.println("Name is " + name);
		System.out.println("Revenue is " + revenue);
		System.out.println("Cost of Goods Sold is " + cogs);
		double grossProfit, margin, markup = 0;
		grossProfit = revenue - cogs;
		
		margin = (grossProfit/revenue) * 100;
			
		System.out.println("Amount kept for every dollar made");

		markup = (grossProfit/cogs) * 100;
			
		System.out.println("How much more you sell your items for than the amount you pay for them");
			
		return "<html>" + "<title>" + "->" + name + "</title>"
				+"<body><h1>" + "Your margin is " + margin + "%" + " and your markup is " + markup + "%" + "</h1></body>" + "</html>";
		}
	//http://localhost:8080/JavaAPI/rest/hello?name=Company&revenue=200&COGS=150
}
