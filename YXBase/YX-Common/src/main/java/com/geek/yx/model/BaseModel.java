package com.geek.yx.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geek.yx.common.core.util.DateUtil;
import com.geek.yx.common.core.util.DateUtil.DATE_PATTERN;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseModel implements Serializable {
	@TableId(value = "id_", type = IdType.ID_WORKER)
	private Long id;
	
	@TableField(exist = false)
	private Integer enable;
	
	@TableField("remark_")
	private String remark = "";
	
	@TableField(exist = false)
	private Long createBy;
	
	private Date createTime;

	@TableField(exist = false)
	private Long updateBy;
	
	private Date updateTime;

	@TableField(exist = false)
	private String keyword;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the enable
	 */
	public Integer getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * @return the createBy
	 */
	public Long getCreateBy() {
		return createBy;
		
	}

	/**
	 * @param createBy
	 *            the createBy to set
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime==null?"":DateUtil.format(createTime, DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateBy
	 */
	public Long getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy
	 *            the updateBy to set
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime==null?"":DateUtil.format(updateTime, DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
