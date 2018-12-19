package finalproj.dto;

public class Stu_LoggerVO {
	private int logno, rnum, snum, stat;
	private String logdate;

	
	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getLogno() {
		return logno;
	}

	public void setLogno(int logno) {
		this.logno = logno;
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

	public String getLogdate() {
		return logdate;
	}

	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}

}
