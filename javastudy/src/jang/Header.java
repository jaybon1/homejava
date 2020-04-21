package jang;

public class Header {

	private String title;
	private String resultCode;
	private String resultMsg;
	private String currentPageNo;
	private String recordCountPerPage;
	private String totalCount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(String currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public String getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(String recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}