package fileupload_dowload.filedownload;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		OutputStream out = resp.getOutputStream();
		
		System.out.println("扣除1个积分");
		
		//解决W3C浏览器下载时中文显示问题
		String filename = req.getParameter("filename");
		
		String name = new String(filename.getBytes("utf-8"), "ISO-8859-1");
		
		//设置下载响应头--这个很重要
		 resp.setHeader("Content-Disposition", "attachment;filename="+ name);
		String dir = getServletContext().getRealPath("/download");
		Files.copy(Paths.get(dir, filename), out);
	}
}
