package finalproj.dto;

import java.util.List;

public class StudentVO {
	private int snum, cnum, scert, rolnum;
	private String sname, sbirth, smail, saddr, sphone, smajor, sgender, sid, spwd, keyword;
	private SboardVO sboard_detail;
	private List<SboardVO> sboard;

	public SboardVO getSboard_detail() {
		return sboard_detail;
	}

	public void setSboard_detail(SboardVO sboard_detail) {
		this.sboard_detail = sboard_detail;
	}

	public List<SboardVO> getSboard() {
		return sboard;
	}

	public void setSboard(List<SboardVO> sboard) {
		this.sboard = sboard;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public int getScert() {
		return scert;
	}

	public void setScert(int scert) {
		this.scert = scert;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getRolnum() {
		return rolnum;
	}

	public void setRolnum(int rolnum) {
		this.rolnum = rolnum;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbirth() {
		return sbirth;
	}

	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

}
