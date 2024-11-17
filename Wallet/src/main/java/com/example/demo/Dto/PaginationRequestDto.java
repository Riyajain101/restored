package com.example.demo.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequestDto {
	private int offSet;
    private int limit;
    private String sortByFieldName;
    private String sortedType;
	public int getOffSet() {
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSortByFieldName() {
		return sortByFieldName;
	}
	public void setSortByFieldName(String sortByFieldName) {
		this.sortByFieldName = sortByFieldName;
	}
	public String getSortedType() {
		return sortedType;
	}
	public void setSortedType(String sortedType) {
		this.sortedType = sortedType;
	}
	@Override
	public String toString() {
		return "PaginationRequestDto [offSet=" + offSet + ", limit=" + limit + ", sortByFieldName=" + sortByFieldName
				+ ", sortedType=" + sortedType + ", getOffSet()=" + getOffSet() + ", getLimit()=" + getLimit()
				+ ", getSortByFieldName()=" + getSortByFieldName() + ", getSortedType()=" + getSortedType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public PaginationRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaginationRequestDto(int offSet, int limit, String sortByFieldName, String sortedType) {
		super();
		this.offSet = offSet;
		this.limit = limit;
		this.sortByFieldName = sortByFieldName;
		this.sortedType = sortedType;
	}  // "asc" or "desc"
}
	
