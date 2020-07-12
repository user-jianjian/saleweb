package com.asiainfo.walk.webdemo.mvc.entity;import org.walkframework.data.entity.BaseEntity;import org.walkframework.data.entity.OperColumn;import org.walkframework.data.annotation.Table;import org.walkframework.data.annotation.Column;import java.util.Date;  /*** @Type TdMStaff* @Desc  * @author 75517* @date 2020-07-12 19:08:47* * 1、本类由工具类DbToEntity自动生成* 2、数据表新增字段时建议使用DbToEntity工具类重新生成* 3、不建议直接修改本类，如果想对本类扩展，建议创建子类，在子类里进行扩展，子类的set/get方法无需按照父类的写法，用开发工具直接生成就好*/	@Table(name="TD_M_STAFF")public class TdMStaff extends BaseEntity {	private static final long serialVersionUID = 1L;	/**		 * 员工ID		 */		@Column(name = STAFF_ID)	private String staffId;	/**		 * 部门ID		 */		@Column(name = DEPART_ID)	private String departId;	/**		 * 员工名称		 */		@Column(name = STAFF_NAME)	private String staffName;	/**		 * 工作岗位 10：管理员；20：订单人员；00：其它；详情看TD_S_STATIC.JOB_CODE		 */		@Column(name = JOB_CODE)	private String jobCode;	/**		 * 性别 1：男，0：女		 */		@Column(name = SEX)	private String sex;	/**		 * 		 */		@Column(name = BIRTHDAY)	private Date birthday;	/**		 * 工作邮箱		 */		@Column(name = EMAIL)	private String email;	/**		 * 身份证号码		 */		@Column(name = USER_PID)	private String userPid;	/**		 * 手机号码		 */		@Column(name = SERIAL_NUMBER)	private String serialNumber;	/**		 * 离职标识。0：在职，1：离职		 */		@Column(name = DIMISSION_TAG)	private String dimissionTag;	/**		 * 		 */		@Column(name = START_DATE)	private Date startDate;	/**		 * 		 */		@Column(name = END_DATE)	private Date endDate;	/**		 * 备注		 */		@Column(name = REMARK)	private String remark;	/**		 * 备用字段1		 */		@Column(name = RSVALUE1)	private String rsvalue1;	/**		 * 备用字段2		 */		@Column(name = RSVALUE2)	private String rsvalue2;	/**		 * 省份编码		 */		@Column(name = PROVINCE_CODE)	private String provinceCode;	/**		 * 首页选择。登录后可选择首页。根据TD_S_STATIC表中配置的TYPE_ID取首页列表		 */		@Column(name = HOME_CHOICE)	private String homeChoice;	/**		 * 超级工号标识。1：是；0：否		 */		@Column(name = SUPER_FLAG)	private String superFlag;	/**		 * 		 */		@Column(name = CREATE_TIME)	private Date createTime;	/**		 * 创建人		 */		@Column(name = CREATE_STAFF_ID)	private String createStaffId;	/**		 * 		 */		@Column(name = UPDATE_TIME)	private Date updateTime;	/**		 * 更新人		 */		@Column(name = UPDATE_STAFF_ID)	private String updateStaffId;	/**		 * 工号来源系统。TD_S_STATIC.STAFF_SYS		 */		@Column(name = STAFF_SYS)	private String staffSys;	/**		 * 密码认证方式。TD_S_STATIC.AUTH_TYPE		 */		@Column(name = AUTH_TYPE)	private String authType;	public String getStaffId() {		return staffId;	}	public OperColumn setStaffId(String staffId) {		this.staffId = staffId;		return addOperColumn(STAFF_ID, "staffId", staffId, String.class);	}	public String getDepartId() {		return departId;	}	public OperColumn setDepartId(String departId) {		this.departId = departId;		return addOperColumn(DEPART_ID, "departId", departId, String.class);	}	public String getStaffName() {		return staffName;	}	public OperColumn setStaffName(String staffName) {		this.staffName = staffName;		return addOperColumn(STAFF_NAME, "staffName", staffName, String.class);	}	public String getJobCode() {		return jobCode;	}	public OperColumn setJobCode(String jobCode) {		this.jobCode = jobCode;		return addOperColumn(JOB_CODE, "jobCode", jobCode, String.class);	}	public String getSex() {		return sex;	}	public OperColumn setSex(String sex) {		this.sex = sex;		return addOperColumn(SEX, "sex", sex, String.class);	}	public Date getBirthday() {		return birthday;	}	public OperColumn setBirthday(Date birthday) {		this.birthday = birthday;		return addOperColumn(BIRTHDAY, "birthday", birthday, Date.class);	}	public String getEmail() {		return email;	}	public OperColumn setEmail(String email) {		this.email = email;		return addOperColumn(EMAIL, "email", email, String.class);	}	public String getUserPid() {		return userPid;	}	public OperColumn setUserPid(String userPid) {		this.userPid = userPid;		return addOperColumn(USER_PID, "userPid", userPid, String.class);	}	public String getSerialNumber() {		return serialNumber;	}	public OperColumn setSerialNumber(String serialNumber) {		this.serialNumber = serialNumber;		return addOperColumn(SERIAL_NUMBER, "serialNumber", serialNumber, String.class);	}	public String getDimissionTag() {		return dimissionTag;	}	public OperColumn setDimissionTag(String dimissionTag) {		this.dimissionTag = dimissionTag;		return addOperColumn(DIMISSION_TAG, "dimissionTag", dimissionTag, String.class);	}	public Date getStartDate() {		return startDate;	}	public OperColumn setStartDate(Date startDate) {		this.startDate = startDate;		return addOperColumn(START_DATE, "startDate", startDate, Date.class);	}	public Date getEndDate() {		return endDate;	}	public OperColumn setEndDate(Date endDate) {		this.endDate = endDate;		return addOperColumn(END_DATE, "endDate", endDate, Date.class);	}	public String getRemark() {		return remark;	}	public OperColumn setRemark(String remark) {		this.remark = remark;		return addOperColumn(REMARK, "remark", remark, String.class);	}	public String getRsvalue1() {		return rsvalue1;	}	public OperColumn setRsvalue1(String rsvalue1) {		this.rsvalue1 = rsvalue1;		return addOperColumn(RSVALUE1, "rsvalue1", rsvalue1, String.class);	}	public String getRsvalue2() {		return rsvalue2;	}	public OperColumn setRsvalue2(String rsvalue2) {		this.rsvalue2 = rsvalue2;		return addOperColumn(RSVALUE2, "rsvalue2", rsvalue2, String.class);	}	public String getProvinceCode() {		return provinceCode;	}	public OperColumn setProvinceCode(String provinceCode) {		this.provinceCode = provinceCode;		return addOperColumn(PROVINCE_CODE, "provinceCode", provinceCode, String.class);	}	public String getHomeChoice() {		return homeChoice;	}	public OperColumn setHomeChoice(String homeChoice) {		this.homeChoice = homeChoice;		return addOperColumn(HOME_CHOICE, "homeChoice", homeChoice, String.class);	}	public String getSuperFlag() {		return superFlag;	}	public OperColumn setSuperFlag(String superFlag) {		this.superFlag = superFlag;		return addOperColumn(SUPER_FLAG, "superFlag", superFlag, String.class);	}	public Date getCreateTime() {		return createTime;	}	public OperColumn setCreateTime(Date createTime) {		this.createTime = createTime;		return addOperColumn(CREATE_TIME, "createTime", createTime, Date.class);	}	public String getCreateStaffId() {		return createStaffId;	}	public OperColumn setCreateStaffId(String createStaffId) {		this.createStaffId = createStaffId;		return addOperColumn(CREATE_STAFF_ID, "createStaffId", createStaffId, String.class);	}	public Date getUpdateTime() {		return updateTime;	}	public OperColumn setUpdateTime(Date updateTime) {		this.updateTime = updateTime;		return addOperColumn(UPDATE_TIME, "updateTime", updateTime, Date.class);	}	public String getUpdateStaffId() {		return updateStaffId;	}	public OperColumn setUpdateStaffId(String updateStaffId) {		this.updateStaffId = updateStaffId;		return addOperColumn(UPDATE_STAFF_ID, "updateStaffId", updateStaffId, String.class);	}	public String getStaffSys() {		return staffSys;	}	public OperColumn setStaffSys(String staffSys) {		this.staffSys = staffSys;		return addOperColumn(STAFF_SYS, "staffSys", staffSys, String.class);	}	public String getAuthType() {		return authType;	}	public OperColumn setAuthType(String authType) {		this.authType = authType;		return addOperColumn(AUTH_TYPE, "authType", authType, String.class);	}	//Database field	public static final String STAFF_ID = "STAFF_ID";	public static final String DEPART_ID = "DEPART_ID";	public static final String STAFF_NAME = "STAFF_NAME";	public static final String JOB_CODE = "JOB_CODE";	public static final String SEX = "SEX";	public static final String BIRTHDAY = "BIRTHDAY";	public static final String EMAIL = "EMAIL";	public static final String USER_PID = "USER_PID";	public static final String SERIAL_NUMBER = "SERIAL_NUMBER";	public static final String DIMISSION_TAG = "DIMISSION_TAG";	public static final String START_DATE = "START_DATE";	public static final String END_DATE = "END_DATE";	public static final String REMARK = "REMARK";	public static final String RSVALUE1 = "RSVALUE1";	public static final String RSVALUE2 = "RSVALUE2";	public static final String PROVINCE_CODE = "PROVINCE_CODE";	public static final String HOME_CHOICE = "HOME_CHOICE";	public static final String SUPER_FLAG = "SUPER_FLAG";	public static final String CREATE_TIME = "CREATE_TIME";	public static final String CREATE_STAFF_ID = "CREATE_STAFF_ID";	public static final String UPDATE_TIME = "UPDATE_TIME";	public static final String UPDATE_STAFF_ID = "UPDATE_STAFF_ID";	public static final String STAFF_SYS = "STAFF_SYS";	public static final String AUTH_TYPE = "AUTH_TYPE";	}