package banquemisr.challenge05.system.models.requests;

public class PaginationRequestModel<R> {
    private Integer pageId;
    private Integer pageSize;
    private String orderBy;
    private String sortBy = "ASC";
    private R filterData;

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public R getFilterData() {
        return filterData;
    }

    public void setFilterData(R filterData) {
        this.filterData = filterData;
    }
}
