package com.phani.WM.controller;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;

@Controller
public class MainController {
	
	
	

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test()
	{
		return "phani";
		
	}
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main()
	{
		return "index";
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main2()
	{
		return "index.html";
		
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String pictureUpload(@RequestParam("file") MultipartFile file,@RequestParam("markedtext")String text,  Model model) throws IOException, ImageProcessingException,FontFormatException
	{
		byte[] bytes = file.getBytes();
		
		
		
		Metadata generateMetadata = ImageMetadataReader.readMetadata(file.getInputStream());
		
		
		Iterable<Directory> directories = generateMetadata.getDirectories();
	//	GpsDirectory gpsDirectory = generateMetadata.getDirectory(GpsDirectory.class);
		
		 generateMetadata.getDirectories().forEach(dir->{
			 System.out.println(dir.getName());
			 
			 if(dir.getName() =="GPS")
			 {
				dir.getTags().forEach(gpsTag->{
					System.out.println(gpsTag.toString());
					
				});
			 }
			
		 });
		 
		
		
		//System.out.println(generateMetadata.getDirectories().toString());
		
		
		
		BufferedImage read_img = ImageIO.read(file.getInputStream());
		Image drawWatermark = drawWatermark(read_img, text);
		
		ByteArrayOutputStream  by_outStr =new ByteArrayOutputStream ();
		
		ImageIO.write((RenderedImage) drawWatermark, "jpg", by_outStr);
		 byte[] imageInBytes = by_outStr.toByteArray();
		 
		 String encodeToString = Base64.getEncoder().encodeToString(imageInBytes);
		 //System.out.println(encodeToString);
		
		 model.addAttribute("image64enco", encodeToString);
		 return "result";
		
		
		
		
	}
	
	
	public Image drawWatermark(BufferedImage image , String textRec) throws FontFormatException, IOException
	{
		Graphics2D  graphics;
		
		AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
		//GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\user\\Downloads\\Sacramento\\Sacramento-Regular.ttf")));
		
		graphics = image.createGraphics();
		graphics.setComposite(alphaChannel);
		graphics.setColor(Color.BLACK);
		int x = image.getHeight();
		int y =image.getWidth();
		Font font = new Font("Sacramento", Font.ITALIC, 32);
		Font cusFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\user\\Downloads\\Sacramento\\Sacramento-Regular.ttf")).deriveFont(84f);
		graphics.setFont(cusFont);
		graphics.drawString( textRec, 400, 160);    ///width and height
		
		return image;
		
	}
	
	
	@RequestMapping(value="/downloadImage", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<byte[]> downloadImage(String encoded) throws IOException
	{
		
		System.out.println("insid ethe download fucnin ");
		
		System.out.println(encoded);
		
		BASE64Decoder decoder= new BASE64Decoder();
		
		ByteArrayInputStream  input_stream = new ByteArrayInputStream(decoder.decodeBuffer(encoded)); 
		BufferedImage img = ImageIO.read(input_stream);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", outStream);
		//return outStream.toByteArray();
		
		return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(outStream.toByteArray());

		
		
	}
	
	
	
	

}
