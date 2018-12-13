package finalproj.dto;

public class TboardVO {
	private int tbnum;
	private int tnum;
	private String tbtitle;
	private String tbdate;
	private String tbfile;
	private String tbcontent;
	private int cnum;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	/**
	 * @return the tbnum
	 */
	public int getTbnum() {
		return tbnum;
	}
	/**
	 * @param tbnum the tbnum to set
	 */
	public void setTbnum(int tbnum) {
		this.tbnum = tbnum;
	}
	/**
	 * @return the tnum
	 */
	public int getTnum() {
		return tnum;
	}
	/**
	 * @param tnum the tnum to set
	 */
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	/**
	 * @return the tbtitle
	 */
	public String getTbtitle() {
		return tbtitle;
	}
	/**
	 * @param tbtitle the tbtitle to set
	 */
	public void setTbtitle(String tbtitle) {
		this.tbtitle = tbtitle;
	}
	/**
	 * @return the tbdate
	 */
	public String getTbdate() {
		return tbdate;
	}
	/**
	 * @param tvdate the tbdate to set
	 */
	public void setTbdate(String tbdate) {
		this.tbdate = tbdate;
	}
	/**
	 * @return the tbfile
	 */
	public String getTbfile() {
		return tbfile;
	}
	/**
	 * @param tbfile the tbfile to set
	 */
	public void setTbfile(String tbfile) {
		this.tbfile = tbfile;
	}
	/**
	 * @return the tbcontent
	 */
	public String getTbcontent() {
		return tbcontent;
	}
	/**
	 * @param tbcontent the tbcontent to set
	 */
	public void setTbcontent(String tbcontent) {
		this.tbcontent = tbcontent;
	}
	
	
}
