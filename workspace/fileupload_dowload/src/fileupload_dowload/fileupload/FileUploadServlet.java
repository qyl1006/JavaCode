package fileupload_dowload.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		//检查基于Servlet的文件上传对象-->1是否post提交方式 2enctype="multipart/form-data"表单的编码
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart){
			//创建一个磁盘的文件工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//设置缓存大少
			factory.setSizeThreshold(1024 * 102411);
			
			//创建基于Servlet的文件上传对象
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			try {
				//解析请求生成FileItem对象
				List<FileItem> items = upload.parseRequest(req);
				
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = iter.next();

				    if (item.isFormField()) { //表单字段
				    	String name = item.getString("utf-8");
				    	System.out.println(name);
				    } else {  //二进制提交的数据
				    	String filename = item.getName();
				    	String mime = item.getContentType(); //获取文件的MIME类型
				    	System.out.println(filename + " = " + mime);
				    	
				    	//获取指定目录的真实路径
				    	String str = getServletContext().getRealPath("/upload");
				    	System.out.println(str);
				    	//上传的文件保存到项目中
				    	//使用UUID代替文件的名称,防止覆盖
				    	String ext = FilenameUtils.getExtension(filename);
				    	filename = UUID.randomUUID().toString() + "." + ext;
				    	try {
							item.write(new File(str, filename));
						} catch (Exception e) {
							e.printStackTrace();
						}
				    }
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
}
