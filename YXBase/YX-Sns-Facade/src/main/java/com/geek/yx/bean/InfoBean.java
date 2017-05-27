package com.geek.yx.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.geek.yx.model.MongoBean;
import com.geek.yx.model.User;

/**
 * 〈一句话功能简述〉<br>
 * 微博基本信息
 * 
 * @author peter
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Document(collection = "BaseInfo")
public class InfoBean extends MongoBean implements Serializable, Cloneable {

	private static final long serialVersionUID = -2494047220248913239L;

	@Id
	private String id;

	// 用户ID（需要建立mongo索引）
	private String userId;

	// 删除标记
	private String deleteFlag;

	// 最新消息ID
	private String newId;

	// 是否展示在门店中
	private String isShowInShop;

	// 微博类型
	private String infoKind;

	// 赞数量(FAVOR_COUNT)
	private Long favorCount;

	// 转发数量(TRANS_COUNT)
	private Long transCount = 0L;

	// 信息被收藏数量(BOOK_COUNT)
	private Long bookCount = 0L;

	// 评价数量(EVAL_COUNT)
	private Long evalCount = 0L;

	// 人们标识
	private String hotFlag;

	private String newFlag;

	// 发布时的经纬度(CREATE_GPS)
	private List<Double> createGps;

	// 发布时设备信息
	private String createDevice;

	// 发布时间(CREATE_TIME)
	private Date createTime;

	// 信息标题Title
	private String infoTitle;

	// 信息正文本(INFO_TEXT)
	private String infoText;

	// 门店ID
	private String storeId;

	// 门店名称
	private String storeName;

	// 门店距离
	private String storeDistance;

	// 商品列表
	private List<Map<String, Object>> productList;

	// 图片列表
	private List<Map<String, Object>> imgList;

	// 城市ID
	private String cityId;

	// 公共帐号发布微博的Url
	private String publicInfoUrl;

	// 公共帐号图片Url
	private String publicInfoImgUrl;

	// 公共帐号标题
	private String publicInfoTitle;

	// 公共帐号文本内容
	private String publicInfoContent;

	// 当前用户是否赞过 ；不作为字段存储
	@Transient
	private Boolean favorFlag;
	// 当前用户是否收藏过;不作为字段存储
	@Transient
	private Boolean bookFlag;

	// 置顶标识 ，1置顶，0不置顶
	@Transient
	private String topFlag;
	// 当前用户是否收藏过;不作为字段存储
	@Transient
	private InfoBean forwardMicroblog;

	// 用户信息
	@Transient
	private User user;

	// 活动图片地址
	private String activityImg;
	// 活动内容描述
	private String activityContent;
	// 活动URL地址
	private String activityUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getIsShowInShop() {
		return isShowInShop;
	}

	public void setIsShowInShop(String isShowInShop) {
		this.isShowInShop = isShowInShop;
	}

	public String getInfoKind() {
		return infoKind;
	}

	public void setInfoKind(String infoKind) {
		this.infoKind = infoKind;
	}

	public Long getFavorCount() {
		return favorCount;
	}

	public void setFavorCount(Long favorCount) {
		this.favorCount = favorCount;
	}

	public Long getTransCount() {
		return transCount;
	}

	public void setTransCount(Long transCount) {
		this.transCount = transCount;
	}

	public Long getBookCount() {
		return bookCount;
	}

	public void setBookCount(Long bookCount) {
		this.bookCount = bookCount;
	}

	public Long getEvalCount() {
		return evalCount;
	}

	public void setEvalCount(Long evalCount) {
		this.evalCount = evalCount;
	}

	public String getHotFlag() {
		return hotFlag;
	}

	public void setHotFlag(String hotFlag) {
		this.hotFlag = hotFlag;
	}

	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	public List<Double> getCreateGps() {
		return createGps;
	}

	public void setCreateGps(List<Double> createGps) {
		this.createGps = createGps;
	}

	public String getCreateDevice() {
		return createDevice;
	}

	public void setCreateDevice(String createDevice) {
		this.createDevice = createDevice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoText() {
		return infoText;
	}

	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreDistance() {
		return storeDistance;
	}

	public void setStoreDistance(String storeDistance) {
		this.storeDistance = storeDistance;
	}

	public List<Map<String, Object>> getProductList() {
		return productList;
	}

	public void setProductList(List<Map<String, Object>> productList) {
		this.productList = productList;
	}

	public List<Map<String, Object>> getImgList() {
		return imgList;
	}

	public void setImgList(List<Map<String, Object>> imgList) {
		this.imgList = imgList;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPublicInfoUrl() {
		return publicInfoUrl;
	}

	public void setPublicInfoUrl(String publicInfoUrl) {
		this.publicInfoUrl = publicInfoUrl;
	}

	public String getPublicInfoImgUrl() {
		return publicInfoImgUrl;
	}

	public void setPublicInfoImgUrl(String publicInfoImgUrl) {
		this.publicInfoImgUrl = publicInfoImgUrl;
	}

	public String getPublicInfoTitle() {
		return publicInfoTitle;
	}

	public void setPublicInfoTitle(String publicInfoTitle) {
		this.publicInfoTitle = publicInfoTitle;
	}

	public String getPublicInfoContent() {
		return publicInfoContent;
	}

	public void setPublicInfoContent(String publicInfoContent) {
		this.publicInfoContent = publicInfoContent;
	}

	public Boolean getFavorFlag() {
		return favorFlag;
	}

	public void setFavorFlag(Boolean favorFlag) {
		this.favorFlag = favorFlag;
	}

	public Boolean getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(Boolean bookFlag) {
		this.bookFlag = bookFlag;
	}

	public String getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}

	public InfoBean getForwardMicroblog() {
		return forwardMicroblog;
	}

	public void setForwardMicroblog(InfoBean forwardMicroblog) {
		this.forwardMicroblog = forwardMicroblog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getActivityImg() {
		return activityImg;
	}

	public void setActivityImg(String activityImg) {
		this.activityImg = activityImg;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

}
