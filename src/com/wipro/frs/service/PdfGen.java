package com.wipro.frs.service;



	import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
//import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;

	public class PdfGen extends AbstractITextPdfView{


	   

	        
	   

		@Override
		protected void buildPdfDocument(Map<String, Object> model,
				Document document, PdfWriter writer,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			

	              OutputStream file = new FileOutputStream(new File("D:\\Ticket.pdf"));
		          //Document documen = new Document();
		          //PdfWriter.getInstance(document, file);

				//Inserting Image in PDF
				    // Image image = Image.getInstance ("src/pdf/java4s.png");
				     //image.scaleAbsolute(120f, 60f);//image width,height	
	              Map<ReservationBean, List<PassengerBean>> m1=(Map<ReservationBean, java.util.List<PassengerBean>>) model.get("ticket");
	              ReservationBean rb = new ReservationBean();
		          Paragraph para1=new Paragraph("Go HORIZON Air Travel Ltd.");
		          para1.setAlignment(Element.ALIGN_CENTER);
		          DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		          for(ReservationBean k:m1.keySet()){
		        	  rb=k;
		          }
		          
		          List<PassengerBean> listpassenger=m1.get(rb);
		          Iterator it=listpassenger.iterator();
		          
		          
				//Inserting Table in PDF
				     PdfPTable table=new PdfPTable(4);

		                     PdfPCell cell = new PdfPCell (new Paragraph ("Journey Details"));

					      cell.setColspan (4);
					      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					      cell.setPadding (5.0f);
					      cell.setBackgroundColor (new BaseColor (140, 221, 8));					               

					      table.addCell(cell);						               

					      table.addCell("Reservation ID");
					      table.addCell(rb.getReservationID());
					      table.addCell("Scheduke ID");
	                      table.addCell(rb.getScheduleID());
					      table.addCell("Reservation Type");
					      table.addCell(rb.getReservationType());
					      table.addCell("Journey Date");
					      table.addCell(dateFormat.format(rb.getJourneyDate()));
					      table.addCell("Booking Date");
					      table.addCell(dateFormat.format(rb.getBookingDate()));
					      table.addCell("No. of Seats");
					      table.addCell(Double.toString(rb.getNoOfSeats()));
					      table.addCell("");
					      table.addCell("");
					      table.addCell("Total fare");
					      table.addCell("Rs."+Double.toString(rb.getTotalFare()));
					      
					      
					      table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
					      table.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS								          

					      
					      
					    //Inserting Table in PDF
						     PdfPTable passsengertable=new PdfPTable(5);

				                     PdfPCell cell1 = new PdfPCell (new Paragraph ("Passengers List"));

							      cell1.setColspan (5);
							      cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
							      cell1.setPadding (5.0f);
							      cell1.setBackgroundColor (new BaseColor (140, 221, 8));					               

							      passsengertable.addCell(cell1);						               

							      passsengertable.addCell("SNO");
							      passsengertable.addCell("NAME");
							      passsengertable.addCell("GENDER");
							      passsengertable.addCell("AGE");
							      passsengertable.addCell("SEAT NO");
							      int sno=0;
							      while(it.hasNext()){
							    	  PassengerBean pbean=(PassengerBean) it.next();
							    	  passsengertable.addCell(Integer.toString(sno+1));
							    	  passsengertable.addCell(pbean.getName());
								      passsengertable.addCell(pbean.getGender());
								      passsengertable.addCell(Integer.toString(pbean.getAge()));
								      passsengertable.addCell(Integer.toString(pbean.getSeatNo()));
								      sno++;
							      }
							     
							      
							      
							      passsengertable.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
							      passsengertable.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS								          

					      
					      
				 //Inserting List in PDF
					      //List list=new List(true,30);
				          //list.add(new ListItem("Java4s"));
					      //list.add(new ListItem("Php4s"));
					      //list.add(new ListItem("Some Thing..."));		

				 //Text formating in PDF
		                Chunk chunk=new Chunk("Welecome To Java4s Programming Blog...");
						chunk.setUnderline(+1f,-2f);//1st co-ordinate is for line width,2nd is space between
						Chunk chunk1=new Chunk("Php4s.com");
						chunk1.setUnderline(+4f,-8f);
						chunk1.setBackground(new BaseColor (17, 46, 193));      

				 //Now Insert Every Thing Into PDF Document
			         document.open();//PDF document opened........			       

						//document.add(image);

						document.add(Chunk.NEWLINE);   //Something like in HTML :-)
document.add(para1);
                //document.add(new Paragraph("Go Horizone Airways\n hiiiii"));
		                //document.add(new Paragraph("Document Generated On - "+new Date().toString()));	

						document.add(table);
						document.add(passsengertable);

						//document.add(chunk);
						//document.add(chunk1);

						document.add(Chunk.NEWLINE);   //Something like in HTML :-)							    

	       				//document.newPage();            //Opened new page
						//document.add(list);            //In the new page we are going to add list

			         document.close();

				             file.close();

	            System.out.println("Pdf created successfully..");

	        
			
		}}
	