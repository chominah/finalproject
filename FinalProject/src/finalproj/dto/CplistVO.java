package finalproj.dto;

import java.util.List;

public class CplistVO {
	private String keyword;
	private String cpnum;
	private String cpname;
	private String cploc;
	private String cplink;
	
	private List< CplistVO> cplist;
	
	
	
	/**
	 * @return the cplist
	 */
	public List<CplistVO> getCplist() {
		return cplist;
	}
	/**
	 * @param cplist the cplist to set
	 */
	public void setCplist(List<CplistVO> cplist) {
		this.cplist = cplist;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	/**
	 * @return the cplink
	 */
	public String getCplink() {
		return cplink;
	}
	/**
	 * @param cplink the cplink to set
	 */
	public void setCplink(String cplink) {
		this.cplink = cplink;
	}
	
	
	
}
