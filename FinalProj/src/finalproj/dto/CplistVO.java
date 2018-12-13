package finalproj.dto;

import java.util.List;

public class CplistVO {
	private int keynum,cnt;
	private String cpnum;
	private String cpname;
	private String cploc, cplink, ceomail, fmemo;
	private List<CplistVO> cplist;
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List<CplistVO> getCplist() {
		return cplist;
	}

	public void setCplist(List<CplistVO> cplist) {
		this.cplist = cplist;
	}

	public String getCplink() {
		return cplink;
	}

	public void setCplink(String cplink) {
		this.cplink = cplink;
	}

	public String getCeomail() {
		return ceomail;
	}

	public void setCeomail(String ceomail) {
		this.ceomail = ceomail;
	}

	public String getFmemo() {
		return fmemo;
	}

	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}

	/**
	 * @return the keynum
	 */
	public int getKeynum() {
		return keynum;
	}

	/**
	 * @param keynum the keynum to set
	 */
	public void setKeynum(int keynum) {
		this.keynum = keynum;
	}

	/**
	 * @return the cpnum
	 */
	public String getCpnum() {
		return cpnum;
	}

	/**
	 * @param cpnum the cpnum to set
	 */
	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}

	/**
	 * @return the cpname
	 */
	public String getCpname() {
		return cpname;
	}

	/**
	 * @param cpname the cpname to set
	 */
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	/**
	 * @return the cploc
	 */
	public String getCploc() {
		return cploc;
	}

	/**
	 * @param cploc the cploc to set
	 */
	public void setCploc(String cploc) {
		this.cploc = cploc;
	}

}
