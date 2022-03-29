package com.coderun.jsp.board.model.dto;

import java.sql.Date;


public class CommentDTO {
	
	private int cmtNo;
	private String cmtWriter;
	private String cmtContent;
	private Date cmtDate;
	private Date cmtUpdate;
	private String cmtDelete;
	private int bdNo;
	
	public CommentDTO() {}

	public CommentDTO(int cmtNo, String cmtWriter, String cmtContent, Date cmtDate, Date cmtUpdate, String cmtDelete,
			int bdNo) {
		super();
		this.cmtNo = cmtNo;
		this.cmtWriter = cmtWriter;
		this.cmtContent = cmtContent;
		this.cmtDate = cmtDate;
		this.cmtUpdate = cmtUpdate;
		this.cmtDelete = cmtDelete;
		this.bdNo = bdNo;
	}

	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}

	public String getCmtWriter() {
		return cmtWriter;
	}

	public void setCmtWriter(String cmtWriter) {
		this.cmtWriter = cmtWriter;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public Date getCmtDate() {
		return cmtDate;
	}

	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}

	public Date getCmtUpdate() {
		return cmtUpdate;
	}

	public void setCmtUpdate(Date cmtUpdate) {
		this.cmtUpdate = cmtUpdate;
	}

	public String getCmtDelete() {
		return cmtDelete;
	}

	public void setCmtDelete(String cmtDelete) {
		this.cmtDelete = cmtDelete;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	@Override
	public String toString() {
		return "CommentDTO [cmtNo=" + cmtNo + ", cmtWriter=" + cmtWriter + ", cmtContent=" + cmtContent + ", cmtDate="
				+ cmtDate + ", cmtUpdate=" + cmtUpdate + ", cmtDelete=" + cmtDelete + ", bdNo=" + bdNo + "]";
	}

	
	
	

	

}
