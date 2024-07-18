package banquemisr.challenge05.system.models.responses;

import java.util.ArrayList;
import java.util.List;

public class PaginationResponseModel<R,T> {
    private List<T> resultList = new ArrayList<>();
    private R filterDataResponse;
    private Integer pageSize;
    private Integer pageId;
    private String orderBy;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public R getFilterDataResponse() {
        return filterDataResponse;
    }

    public void setFilterDataResponse(R filterDataResponse) {
        this.filterDataResponse = filterDataResponse;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
