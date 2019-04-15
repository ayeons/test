package util;

public class Forward {
	private String path;
	private boolean sendRedirect;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isSendRedirect() {
		return sendRedirect;
	}
	public void setSendRedirect(boolean sendRedirect) {
		this.sendRedirect = sendRedirect;
	}
	@Override
	public String toString() {
		return "Forward [path=" + path + ", sendRedirect=" + sendRedirect + "]";
	}
	
	
}
