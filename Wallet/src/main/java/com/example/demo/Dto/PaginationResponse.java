package com.example.demo.Dto;
import java.util.List;
import com.example.demo.model.Customer;

public class PaginationResponse {
	 private List<Customer> content; // List of customer records (or any other entity)
	    public List<Customer> getContent() {
		return content;
	}
	public void setContent(List<Customer> content) {
		this.content = content;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSize() {
		return size;
	}
	public PaginationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaginationResponse(List<Customer> content, long totalElements, int totalPages, int currentPage, int size) {
		super();
		this.content = content;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
		this.size = size;
	}
	@Override
	public String toString() {
		return "PaginationResponse [content=" + content + ", totalElements=" + totalElements + ", totalPages="
				+ totalPages + ", currentPage=" + currentPage + ", size=" + size + "]";
	}
	public void setSize(int size) {
		this.size = size;
	}
		private long totalElements; // Total number of elements across all pages
	    private int totalPages; // Total number of pages
	    private int currentPage; // Current page number
	    private int size;

}
