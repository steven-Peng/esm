package net.esm.common.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面响应entity
 *
 */
public class Result extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	
	public Result() {
		put("code", 0);
	}
	
	public static Result error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static Result error(String msg) {
		return error(500, msg);
	}
	
	public static Result error(int code, String msg) {
		Result result = new Result();
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}

	public static Result ok(String msg) {
		Result result = new Result();
		result.put("msg", msg);
		return result;
	}
	
	public static Result ok(Map<String, Object> map) {
		Result result = new Result();
		result.putAll(map);
		return result;
	}
	
	public static Result ok() {
		return new Result();
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}