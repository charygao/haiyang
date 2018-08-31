package site.haiyang.hmall.model;

import java.util.Date;

public class GGKFee {
    private Integer id;

    private Long userId;

    private Integer totalPoints;

    private Date deadMonth;

    private Date extendtime1;

    private Date extendtime2;

    private Date extendtime3;

    private Integer extendint1;

    private Integer extendint2;

    private Integer extendint3;

    private Integer extendint4;

    private Integer extendint5;

    private String extendstr1;

    private String extendstr2;

    private String extendstr3;

    private String extendstr4;

    private String extendstr5;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private Boolean invalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Date getDeadMonth() {
        return deadMonth;
    }

    public void setDeadMonth(Date deadMonth) {
        this.deadMonth = deadMonth;
    }

    public Date getExtendtime1() {
        return extendtime1;
    }

    public void setExtendtime1(Date extendtime1) {
        this.extendtime1 = extendtime1;
    }

    public Date getExtendtime2() {
        return extendtime2;
    }

    public void setExtendtime2(Date extendtime2) {
        this.extendtime2 = extendtime2;
    }

    public Date getExtendtime3() {
        return extendtime3;
    }

    public void setExtendtime3(Date extendtime3) {
        this.extendtime3 = extendtime3;
    }

    public Integer getExtendint1() {
        return extendint1;
    }

    public void setExtendint1(Integer extendint1) {
        this.extendint1 = extendint1;
    }

    public Integer getExtendint2() {
        return extendint2;
    }

    public void setExtendint2(Integer extendint2) {
        this.extendint2 = extendint2;
    }

    public Integer getExtendint3() {
        return extendint3;
    }

    public void setExtendint3(Integer extendint3) {
        this.extendint3 = extendint3;
    }

    public Integer getExtendint4() {
        return extendint4;
    }

    public void setExtendint4(Integer extendint4) {
        this.extendint4 = extendint4;
    }

    public Integer getExtendint5() {
        return extendint5;
    }

    public void setExtendint5(Integer extendint5) {
        this.extendint5 = extendint5;
    }

    public String getExtendstr1() {
        return extendstr1;
    }

    public void setExtendstr1(String extendstr1) {
        this.extendstr1 = extendstr1 == null ? null : extendstr1.trim();
    }

    public String getExtendstr2() {
        return extendstr2;
    }

    public void setExtendstr2(String extendstr2) {
        this.extendstr2 = extendstr2 == null ? null : extendstr2.trim();
    }

    public String getExtendstr3() {
        return extendstr3;
    }

    public void setExtendstr3(String extendstr3) {
        this.extendstr3 = extendstr3 == null ? null : extendstr3.trim();
    }

    public String getExtendstr4() {
        return extendstr4;
    }

    public void setExtendstr4(String extendstr4) {
        this.extendstr4 = extendstr4 == null ? null : extendstr4.trim();
    }

    public String getExtendstr5() {
        return extendstr5;
    }

    public void setExtendstr5(String extendstr5) {
        this.extendstr5 = extendstr5 == null ? null : extendstr5.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }
}