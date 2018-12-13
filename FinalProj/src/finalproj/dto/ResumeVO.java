package finalproj.dto;

public class ResumeVO {
	private int rnum,snum,rcnum;
	private String rfile,rdate;
	
	public int getRcnum() {
		return rcnum;
	}
	public void setRcnum(int rcnum) {
		this.rcnum = rcnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getRfile() {
		return rfile;
	}
	public void setRfile(String rfile) {
		this.rfile = rfile;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
}
