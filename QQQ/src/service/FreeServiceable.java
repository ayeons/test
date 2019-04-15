package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FreeServiceable {
	default public void list(HttpServletRequest req,HttpServletResponse resp) {};
}
