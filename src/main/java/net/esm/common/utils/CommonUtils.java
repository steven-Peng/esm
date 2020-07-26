package net.esm.common.utils;

import net.esm.common.constant.MsgConstant;
import net.esm.common.constant.SystemConstant;
import net.esm.common.entity.Result;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 通用工具类
 *
 */
public class CommonUtils {

	/**
	 * 根据模板生成文件内容
	 * @param templateClassPath 类路径模板
	 * @param bindAttrs 绑定变量表
	 * @return 生成结果内容
	 * @throws IOException
	 */
	public static String generate(String templateClassPath, Map<String, Object> bindAttrs) throws IOException {
		ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(getPath(templateClassPath));
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(classpathResourceLoader, cfg);
		Template template = groupTemplate.getTemplate(getFile(templateClassPath));
		template.fastBinding(bindAttrs);
		return template.render();
	}

	/**
	 * 生成代码到本地
	 * @param templateFilePath 模板绝对路径
	 * @param outputFilePath 输入文件绝对路径
	 * @param bindAttrs 绑定变量表
	 * @throws IOException
	 */
	public static void generate(String templateFilePath, String outputFilePath, Map<String, Object> bindAttrs) throws IOException {
		FileResourceLoader fileResourceLoader = new FileResourceLoader(getPath(templateFilePath));
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate groupTemplate = new GroupTemplate(fileResourceLoader, cfg);
		Template template = groupTemplate.getTemplate(getFile(templateFilePath));
		template.fastBinding(bindAttrs);
		File outputFile = new File(outputFilePath);
		FileWriterWithEncoding writer = new FileWriterWithEncoding(outputFile, "utf-8");
		template.renderTo(writer);
	}

	/**
	 * 根据文件绝对路径获取目录
	 * @param filePath
	 * @return
	 */
	public static String getPath(String filePath) {
		String path = "";
		if (StringUtils.isNotBlank(filePath)) {
			path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}
		return path;
	}

	/**
	 * 根据文件绝对路径获取文件
	 * @param filePath
	 * @return
	 */
	public static String getFile(String filePath) {
		String file = "";
		if (StringUtils.isNotBlank(filePath)) {
			file = filePath.substring(filePath.lastIndexOf("/") + 1);
		}
		return file;
	}

	/**
	 * 对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断整数是否大于零
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isIntThanZero(int number) {
		if (number > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 新增，修改提示
	 * @param count
	 * @return
	 */
	public static Result msg(int count) {
		if(isIntThanZero(count)){
			return Result.ok(MsgConstant.MSG_OPERATION_SUCCESS);
		}
		return Result.error(MsgConstant.MSG_OPERATION_FAILED);
	}
	
	/**
	 * 查询详情提示
	 * @param data
	 * @return
	 */
	public static Result msg(Object data) {
		if(isNullOrEmpty(data)){
			return Result.error(MsgConstant.MSG_INIT_FORM);
		}
		return Result.ok().put(SystemConstant.DATA_ROWS, data);
	}

	/**
	 * 返回信息提示
	 * @param errorMsg
	 * @return
	 */
	public static Result msg(String errorMsg) {
		if(!isNullOrEmpty(errorMsg)){
			return Result.error(errorMsg);
		}
		return Result.ok();
	}
	
	/**
	 * 返回数据
	 * @param data
	 * @return
	 */
	public static Result msgNotCheckNull(Object data) {
		return Result.ok().put(SystemConstant.DATA_ROWS, data);
	}
	
	/**
	 * 删除提示
	 * @param total
	 * @param count
	 * @return
	 */
	public static Result msg(Object[] total, int count) {
		if(total.length == count){
			return Result.ok(MsgConstant.MSG_OPERATION_SUCCESS);
		}else{
			if(isIntThanZero(count)){
				return Result.error(MsgConstant.removeFailed(total.length, count));
			}else{
				return Result.error(MsgConstant.MSG_OPERATION_FAILED);
			}
		}
	}
	
}
