package ins.common.util;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

/**
 * 灏咷BK杞崲涓篣TF-8
 * @author Administrator
 *
 */
public class GBKtoUTF_8 {
	public static void main(String[]args) throws Exception{
	
		//D:\workspaces\dbyjx\component\ins\product\model
		//D:\workspaces\dbyjx\component\ins\prpall\report\model
		//D:\\workspaces\\dbyjx\\component\\ins\\common\\util
		//D:\\workspaces\\dbyjx\\component\\ins\\platform\\common
		//D:\\workspaces\\dbyjx\\component\\ins\\platform\\service\\facade
		//D:\\workspaces\\dbyjx\\component\\ins\\platform\\service\\spring
		//D:\\workspaces\\dbyjx\\component\\ins\\platform\\vo
		//D:\\workspaces\\dbyjx\\component\\ins\\product\\service\\facade
		//D:\\workspaces\\dbyjx\\component\\ins\\product\\service\\spring
		//D:\\workspaces\\dbyjx\\component\\ins\\product\\web
		//D:\\workspaces\\dbyjx\\component\\ins\\prpall\\report\\service\\facade
		//D:\\workspaces\\dbyjx\\component\\ins\\prpall\\report\\service\\spring
		//D:\\workspaces\\dbyjx\\component\\ins\\prpall\\report\\vo
		//D:\\workspaces\\dbyjx\\component\\ins\\prpall\\report\\web
		//F:\\Workspaces\\dbyjx\\webapps\\product\\pddefine\\baseinfodefine\\js
		String srcDirPath = "F:\\Workspaces\\pojo\\src\\ins\\product\\model"; 
	 
		String utf8DirPath = "F:\\Workspaces\\pojo\\src\\ins\\product\\model1"; 
		        
		
		Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true); 
		        
		for (File javaGbkFile : javaGbkFileCol) { 
	
		      String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length()); 
		      
		      FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));        
		}
		System.out.println("ok");

	}
}
