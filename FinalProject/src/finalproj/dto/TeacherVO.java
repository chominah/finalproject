package finalproj.dto;

public class TeacherVO {
	private int tnum;
	private String tname;
	private String tbirth;
	private String tmail;
	private String taddr1;
	private String taddr2;
	private String tpost;
	private String tphone;
	private int rolnum;
	private String tgender;
	private String tid, tpwd;	
	private TboardVO tboard;
	

	public TboardVO getTboard() {
		return tboard;
	}

	public void setTboard(TboardVO tboard) {
		this.tboard = tboard;
	}

	public int getRolnum() {
		return rolnum;
	}

	public void setRolnum(int rolnum) {
		this.rolnum = rolnum;
	}

	public int getTnum() {
		return tnum;
	}

	public void setTnum(int tnum) {
		this.tnum = tnum;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTbirth() {
		return tbirth;
	}

	public void setTbirth(String tbirth) {
		this.tbirth = tbirth;
	}

	public String getTmail() {
		return tmail;
	}

	public void setTmail(String tmail) {
		this.tmail = tmail;
	}

	public String getTaddr1() {
		return taddr1;
	}

	public void setTaddr1(String taddr1) {
		this.taddr1 = taddr1;
	}

	public String getTaddr2() {
		return taddr2;
	}

	public void setTaddr2(String taddr2) {
		this.taddr2 = taddr2;
	}

	public String getTpost() {
		return tpost;
	}

	public void setTpost(String tpost) {
		this.tpost = tpost;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public String getTgender() {
		return tgender;
	}

	public void setTgender(String tgender) {
		this.tgender = tgender;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}


}
