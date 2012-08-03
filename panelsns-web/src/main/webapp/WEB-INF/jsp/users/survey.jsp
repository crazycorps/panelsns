<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta name="keywords" content="在线调查，在线问卷，调查表，制作调查，满意度调查，市场调查，调查派" />
<meta name="description" content="调查派是完全免费的在线调查系统，帮助您简单快速的制作出专业的在线调查问卷，并提供详尽的实时结果报表。适用于学生、公司企业、网站、个人等各类用户。" />
<meta content="调查派@diaochapai.com" name="author" />
<meta content="本页版权 www. diaochapai.com调查派所有。All Rights Reserved" name="copyright" />
<link type="text/css" rel="stylesheet" href="/css/u/users.css" />
<link type="text/css" rel="stylesheet" href="/css/u/survey.css" />
<link type="text/css" rel="stylesheet" href="/css/components.css" />
<link rel="icon" href="/logo.ico" type="image/x-icon" />
<title>调查派 – 简单，好用的在线调查系统</title>
<script type="text/javascript" src="/js/jq/jquery.js"></script>
<script type="text/javascript" src="/js/core.js"></script>
<script type="text/javascript" src="/js/u/survey.js"></script>
</head>

<body>
 <%@include file="/WEB-INF/jsp/common/header.jsp"%>
 <div class="top">
  <div class="title">我的调查表</div>
 </div>

 <div id="upgrade_vip">
  <div class="intro">
   你正在使用大众版调查派。专业版让调查表没有广告，自助下载数据、结果统计报表和进行筛选和交叉数据分析。 <a href="javascript:void(0);" class=" modify_profile"
    style="text-decoration: underline; color: #39C;">完善个人信息</a>，马上获得3天专业版体验。
   <button type="button" class="show">打开提示</button>
  </div>
  <div class="detail" style="display: none;">
   <table width="100%" border="0" cellspacing="0" cellpadding="10">
    <tr>
     <td valign="top">
      <h3>welcomejiong@163.com</h3> 您正在使用大众版调查派
     </td>
     <td>
      <h4>升级到专业版，享受更强的功能和服务</h4>
      <ul>
       <li>调查数据自助下载</li>
       <li>强大的数据分析功能，数据筛选和交叉分析</li>
       <li>可去除调查表广告</li>
       <li>调查数据备份到云服务器</li>
      </ul>
     </td>
     <td align="center"><a href="/upgrade" class="redbutton">马上升级专业版</a> <br /> <br /> <a
      href="javascript:void(0);" class="upgrade_btn modify_profile">完善个人信息</a>，马上获得3天专业版体验</td>
     <td valign="bottom"><button type="button" class="close">×关闭提示</button></td>
    </tr>
   </table>
  </div>
 </div>
 <div id="profile_edit" title="编辑个人信息" style="display: none">
  <form name="profile_form" id="form_profile" action="/my/profile">
   <table width="100%" align="center" cellpadding="5" cellspacing="0">
    <tr>
     <td align="right">姓名：</td>
     <td><input type="text" name="realname" id="realname" value="" size="30" /> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">手机：</td>
     <td><input type="text" name="mobile" id="mobile" value="" size="30" /> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">联系地址：</td>
     <td><input type="text" name="address" id="address" value="" size="30" /> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">行业：</td>
     <td><select name="industry">
       <option value="">请选择...</option>
       <option value="计算机软件">计算机软件</option>
       <option value="计算机硬件">计算机硬件</option>
       <option value="计算机服务(系统、数据服务、维修)">计算机服务(系统、数据服务、维修)</option>
       <option value="通信/电信/网络设备">通信/电信/网络设备</option>
       <option value="通信/电信运营、增值服务">通信/电信运营、增值服务</option>
       <option value="互联网/电子商务">互联网/电子商务</option>
       <option value="网络游戏">网络游戏</option>
       <option value="电子技术/半导体/集成电路">电子技术/半导体/集成电路</option>
       <option value="仪器仪表/工业自动化">仪器仪表/工业自动化</option>
       <option value="会计/审计">会计/审计</option>
       <option value="金融/投资/证券">金融/投资/证券</option>
       <option value="银行">银行</option>
       <option value="保险">保险</option>
       <option value="贸易/进出口">贸易/进出口</option>
       <option value="批发/零售">批发/零售</option>
       <option value="快速消费品(食品、饮料、化妆品)">快速消费品(食品、饮料、化妆品)</option>
       <option value="服装/纺织/皮革">服装/纺织/皮革</option>
       <option value="家具/家电/工艺品/玩具/珠宝">家具/家电/工艺品/玩具/珠宝</option>
       <option value="奢侈品/收藏品">奢侈品/收藏品</option>
       <option value="办公用品及设备">办公用品及设备</option>
       <option value="机械/设备/重工">机械/设备/重工</option>
       <option value="汽车及零配件">汽车及零配件</option>
       <option value="制药/生物工程">制药/生物工程</option>
       <option value="医疗/护理/卫生">医疗/护理/卫生</option>
       <option value="医疗设备/器械">医疗设备/器械</option>
       <option value="广告">广告</option>
       <option value="公关/市场推广/会展">公关/市场推广/会展</option>
       <option value="影视/媒体/艺术/文化传播">影视/媒体/艺术/文化传播</option>
       <option value="文字媒体/出版">文字媒体/出版</option>
       <option value="印刷/包装/造纸">印刷/包装/造纸</option>
       <option value="房地产开发">房地产开发</option>
       <option value="建筑/建材/工程">建筑/建材/工程</option>
       <option value="家居/室内设计/装潢">家居/室内设计/装潢</option>
       <option value="物业管理/商业中心">物业管理/商业中心</option>
       <option value="中介服务">中介服务</option>
       <option value="专业服务(咨询、人力资源、财会)">专业服务(咨询、人力资源、财会)</option>
       <option value="外包服务">外包服务</option>
       <option value="检测，认证">检测，认证</option>
       <option value="法律">法律</option>
       <option value="教育/培训/院校">教育/培训/院校</option>
       <option value="学术/科研">学术/科研</option>
       <option value="餐饮业">餐饮业</option>
       <option value="酒店/旅游">酒店/旅游</option>
       <option value="娱乐/休闲/体育">娱乐/休闲/体育</option>
       <option value="美容/保健">美容/保健</option>
       <option value="生活服务">生活服务</option>
       <option value="交通/运输/物流">交通/运输/物流</option>
       <option value="航天/航空">航天/航空</option>
       <option value="石油/化工/矿产/地质">石油/化工/矿产/地质</option>
       <option value="采掘业/冶炼">采掘业/冶炼</option>
       <option value="电力/水利">电力/水利</option>
       <option value="新能源">新能源</option>
       <option value="原材料和加工">原材料和加工</option>
       <option value="政府/公共事业">政府/公共事业</option>
       <option value="非盈利机构">非盈利机构</option>
       <option value="环保">环保</option>
       <option value="农/林/牧/渔">农/林/牧/渔</option>
       <option value="多元化业务集团公司">多元化业务集团公司</option>
       <option value="其他行业">其他行业</option>
      </select> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">工作单位：</td>
     <td><input type="text" name="company" id="company" value="" size="30" /> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">职业：</td>
     <td><select name="occupation">
       <option value="">请选择...</option>
       <option value="党政机关/社团/事业单位工作人员">党政机关/社团/事业单位工作人员</option>
       <option value="医生">医生</option>
       <option value="教师">教师</option>
       <option value="律师">律师</option>
       <option value="其它专业技术人员">其它专业技术人员</option>
       <option value="企业管理人员">企业管理人员</option>
       <option value="企业一般职员">企业一般职员</option>
       <option value="个体户">个体户</option>
       <option value="自由职业者">自由职业者</option>
       <option value="公务员">公务员</option>
       <option value="军人/警察">军人/警察</option>
       <option value="在校学生">在校学生</option>
       <option value="务农">务农</option>
       <option value="待业">待业</option>
      </select> <span class="red">*</span></td>
    </tr>
    <tr>
     <td align="right">联系邮箱：</td>
     <td><input type="text" name="email" id="email" value="welcomejiong@163.com" size="30" /> <span class="red">*</span></td>
    </tr>
   </table>
  </form>
 </div>
 <div id="edit_profile_message" style="display: none">
  <p></p>
 </div>

 <div class="surveysinfo">
  <div class="search">
   <form id="searchForm" action="/u/survey" method="post">
    <input type="text" id="key" name="key" value="" size="30" />
    <input type="hidden" id="toPage" name="toPage" value="1" />
    <input type="hidden" id="orderCol" name="orderCol" />
    <input type="hidden" id="orderType" name="orderType" />
    <input type="hidden" id="status" name="status" value="0" />
    <input id="searchaction" type="submit" value="搜索调查表" />
   </form>
  </div>
  <div id="alertdiv" class="wait_inf" style="display: none;"></div>
  <a href="/u/survey">全部</a>（共<span>${paginationResult.pagination.recordCount}</span>个）调查表 <a href="/u/survey/generator"
   class="creatnew_btn">新建调查表</a>

 </div>
 <div class="actions">
  <input type="checkbox" name="selectSurvey" />
  <select name="surveyAction">
   <option value="">操作</option>
   <option value="close">关闭调查</option>
   <option value="run">开启调查</option>
   <option value="delete">删除</option>
  </select>
  筛选：
  <select name="surveyStatus">
   <option value="/my/survey">全部</option>
   <option value="" disabled>选择状态</option>
   <optgroup>
    <c:forEach items="${surveyStatus}" var="stat">
     <option value="${stat.index}" ${selectedStatus==stat.index?'selected':''}>${stat.displayName}</option>
    </c:forEach>
   </optgroup>
   <option value="" disabled>选择标签</option>
   <optgroup name="surveyTag">
   </optgroup>
  </select>
  排序:
  <c:choose>
   <c:when test="${orderCol eq 'create_date'}">
    <div class="order_col create_date" orderCol="create_date" orderType="${orderType eq 'asc' ? 'desc':'asc'}">
     <c:choose>
      <c:when test="${orderType eq 'asc'}">
       <a class="sort_seling down" href="javascript:return false;">创建时间</a>
      </c:when>
      <c:otherwise>
       <a class="sort_seling up" href="javascript:return false;">创建时间</a>
      </c:otherwise>
     </c:choose>
    </div>
    <div class="order_col name" orderCol="name" orderType="desc">
     <a class="up" href="javascript:return false;">标题</a>
    </div>
   </c:when>
   <c:when test="${orderCol eq 'name'}">
    <div class="order_col create_date" orderCol="create_date" orderType="asc">
     <a class="down" href="javascript:return false;">创建时间</a>
    </div>
    <div class="order_col name" orderCol="name" orderType="${orderType eq 'asc' ? 'desc':'asc'}">
     <c:choose>
      <c:when test="${orderType eq 'asc'}">
       <a class="sort_seling down" href="javascript:return false;">标题</a>
      </c:when>
      <c:otherwise>
       <a class="sort_seling up" href="javascript:return false;">标题</a>
      </c:otherwise>
     </c:choose>
    </div>
   </c:when>
   <c:otherwise>
    <div class="order_col create_date" orderCol="create_date" orderType="asc">
     <a class="down" href="javascript:return false;">创建时间</a>
    </div>
    <div class="order_col name" orderCol="name" orderType="desc">
     <a class="up" href="javascript:return false;">标题</a>
    </div>
   </c:otherwise>
  </c:choose>

 </div>
 <div class="main_mysurvey">
  <div class="left">
   <div class="page">
    <surveyTags:pager currentpage="${paginationResult.pagination.pageNo}"
     totalpage="${paginationResult.pagination.pageCount}" />
   </div>
   <dl class="my_survey">
    <c:if test="${!empty paginationResult.results}">
     <c:forEach var="surveyDayMap" items="${paginationResult.results}">
      <c:forEach var="surveyDay" items="${surveyDayMap}">
       <dt>创建时间： ${surveyDay.key}</dt>
       <c:forEach var="surveyvo" items="${surveyDay.value}">
        <dd id="survey_${surveyvo.entity.id}" surveyId="${surveyvo.entity.id}" surveyName="${surveyvo.entity.name}">
         <div class="jt"></div>
         <div class="status">
          <input type="checkbox" name="run" value="d944a519-b4fa-40d5-aedf-15d1f31f8956" />
          <a class="running" href="javascript:void(0);" command="close" values="d944a519-b4fa-40d5-aedf-15d1f31f8956"
           title="正在运行,点击关闭调查表"></a>
         </div>
         <div class="survey_inf">
          <h1>
           <a target="_blank" title="${survey.entity.name}" href="/survey624951">${surveyvo.entity.name}</a>
          </h1>
          <div class="survey_url">
           调查表地址：http://www.panelsns.com/survey/${surveyvo.entity.id} <a href="javascript:void(0);" class="need_upgrade"
            title="生成调查表的可打印pdf文件"><span class="print">打印(PDF)问卷</span></a>
          </div>
          <div class="function_url">
           <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956" class="greybutton" title="编辑调查表内容和外观"><span
            class="edit">编辑</span></a> <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/setup" class="greybutton"
            title="设置调查表填写规则"><span class="setup">设置</span></a> <a
            href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/share" class="greybutton" title="获取调查表地址和嵌入代码并分享到微博"><span
            class="share">分享</span></a> <a href="/report/d944a519-b4fa-40d5-aedf-15d1f31f8956?init=1" class="greybutton"
            title="实时查看调查表结果统计"><span class="analytics">数据统计</span></a> <a href="javascript:void(0);"
            class="greybutton download need_upgrade" data-sn="d944a519-b4fa-40d5-aedf-15d1f31f8956"
            title="自助下载所有原始数据，并可以导入Excel或SPSS进行深入分析"><span class="download">下载数据</span></a> <span class="function">
            <a href="javascript:void(0);" class="greybutton delete" data-sn="d944a519-b4fa-40d5-aedf-15d1f31f8956"
            title="删除调查表"><span class="del">删除</span></a> <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/copy"
            class="greybutton" title="复制调查表"><span class="copy">复制</span></a>
           </span>
          </div>
         </div>
         <div class="data">
          数据<br /> <span>0</span>
         </div>
        </dd>
       </c:forEach>
      </c:forEach>
     </c:forEach>
    </c:if>
   </dl>
   <div class="page">
    <surveyTags:pager currentpage="${paginationResult.pagination.pageNo}"
     totalpage="${paginationResult.pagination.pageCount}" />
   </div>
  </div>
  <div class="right_block">
   <div class="right" style="" id="r_d944a519-b4fa-40d5-aedf-15d1f31f8956">
    <h1>
     <a target="_blank" preHref="http://www.panelsns.com/survey/" href="/survey" class="survey_info_link">xxx</a>
    </h1>
    <div class="datashow">
     <div class="more_inf">
      <div class="b_r"></div>
      <div class="data">
       <font>数据收集:</font><span>0</span><br /> <font>访问量:</font><span>0</span>
      </div>
      <div class="js_pic">
       <div style="width: 227px; height: 200px; padding: 0px; position: relative;"
        id="img_f04cc0fb-3a89-4576-8387-d5cec6d1904d" pageview="[0,0,0,0,0,0,0]" response="[0,0,0,0,0,0,0]">
        <canvas class="base" width="227" height="200"></canvas>
        <canvas class="overlay" width="227" height="200" style="position: absolute; left: 0px; top: 0px;"></canvas>
        <div style="font-size: smaller" class="tickLabels">
         <div style="color: #545454" class="xAxis x1Axis">
          <div style="position: absolute; text-align: center; left: 5px; top: 187px; width: 32px" class="tickLabel">07-27</div>
          <div style="position: absolute; text-align: center; left: 207px; top: 187px; width: 32px" class="tickLabel">08-02</div>
         </div>
         <div style="color: #545454" class="yAxis y1Axis">
          <div style="position: absolute; text-align: right; top: 174px; right: 213px; width: 14px" class="tickLabel">0</div>
          <div style="position: absolute; text-align: right; top: 119px; right: 213px; width: 14px" class="tickLabel">5</div>
          <div style="position: absolute; text-align: right; top: 64px; right: 213px; width: 14px" class="tickLabel">10</div>
          <div style="position: absolute; text-align: right; top: 9px; right: 213px; width: 14px" class="tickLabel">15</div>
         </div>
        </div>
       </div>
      </div>
     </div>
     <div style="text-align: right;">
      <a href="/report/d944a519-b4fa-40d5-aedf-15d1f31f8956" class="greybutton">查看数据统计</a>
     </div>
    </div>
    <div class="running_status">
     运行状态： <span class="running">正在运行</span>
    </div>
    <div class="time">
     <span class="start">创建时间：<font>2012-07-31</font></span><span class="over">结束时间：<font> 永久 </font></span>
    </div>
    <table class="lab">
     <tr>
      <td class="th_td">标签：</td>
      <td class="b_q" id="mytag_d944a519-b4fa-40d5-aedf-15d1f31f8956"></td>
      <td class="th_td"><a href="javascript:void(0);" command="tag" values="d944a519-b4fa-40d5-aedf-15d1f31f8956">修改</a></td>
     </tr>
    </table>
   </div>
  </div>
 </div>
 <div style="display: none;" id="tagarea" title="标签管理">
  <table width="100%" id="tagtable">
   <tr>
    <td>多个标签使用空格分隔</td>
   </tr>
   <tr>
    <td><input id="mytag" type="text" size="50" /></td>
   </tr>
   <tr>
    <td>我的标签
     <div id="systags"></div>
    </td>
   </tr>
   <tr>
    <td>常用标签 <span>用户体验</span> <span>满意度调查</span> <span>公司管理</span> <span>人力资源</span> <span>产品市场</span> <span>培训反馈</span>
     <span>读者调查</span> <span>学术研究</span> <span>用户反馈</span> <span>报名表</span></td>
   </tr>
  </table>
 </div>
 <div style="display: none;">
  <div class="upgrade_dialog" id="upgrade_dialog">
   <p class="warming">您正在使用专业版功能，请升级后使用</p>
   <table width="100%" border="0">
    <tr>
     <td width="338" rowspan="2" valign="top">
      <h4>升级到专业版，享受更强的功能和服务</h4>
      <ul>
       <li>自助下载调查数据和统计报表</li>
       <li>强大的数据分析功能，数据筛选和交叉分析</li>
       <li>去除调查表广告</li>
       <li>调查数据备份到云服务器</li>
      </ul>
     </td>
     <td width="120" height="65" align="center"><a class="button" href="/upgrade"><img alt=""
       src="/images/upload_btn_3.gif" border="0" /></a></td>
    </tr>
   </table>
  </div>
 </div>

  <%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
