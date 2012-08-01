<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta name="keywords" content="在线调查，在线问卷，调查表，制作调查，满意度调查，市场调查，调查派" />
<meta name="description" content="调查派是完全免费的在线调查系统，帮助您简单快速的制作出专业的在线调查问卷，并提供详尽的实时结果报表。适用于学生、公司企业、网站、个人等各类用户。" />
<meta content="调查派@diaochapai.com" name="author" />
<meta content="本页版权 www. diaochapai.com调查派所有。All Rights Reserved"  name="copyright" />
<link type="text/css" rel="stylesheet" href="/css/u/users.css"/>
<link type="text/css" rel="stylesheet" href="/css/u/survey.css"/>
<link type="text/css" rel="stylesheet" href="/css/components.css"/>
<link rel="icon" href="/logo.ico" type="image/x-icon" />
<title>调查派 – 简单，好用的在线调查系统</title>
<script type="text/javascript" src="/js/jq/jquery.js"></script>

</head>

<body>
<div id="header">
    <div class="header">
    <div class="logo"><a href="/"><img alt=""  src="/images/logo_diaochapai.gif"/></a></div>
    <ul class="menu">
        <li><a href="/my/survey/generator">新建调查</a></li>
        <li><a href="/my/survey">我的调查</a></li>
        <li><a href="/my/profile">welcomejiong@163.com<span class="free"></span> <span class="ico"></span></a>
            <div class="more">
                <a href="/my/profile" class="icon_1">我的账户</a>
                                <a href="/my/wallet" class="icon_3">消费记录</a>
                <a href="/my/gallery" class="icon_4">我的图库</a>
            </div>
        </li>
                <li><a href="/upgrade" class="upgrade_li_a_style">升级专业版</a></li>
                <li><a href="/logout">退出</a></li>
        <li><a href="http://support.diaochapai.com/" target="_blank">帮助</a></li>
    </ul>
    </div>
</div>
<div class="top">
    <div class="title">我的调查表</div>
</div>

<script type="text/javascript">
Do('components-css');
</script>
<div id="upgrade_vip">
    <div class="intro">
        你正在使用大众版调查派。专业版让调查表没有广告，自助下载数据、结果统计报表和进行筛选和交叉数据分析。 <a href="javascript:void(0);" class=" modify_profile" style="text-decoration:underline; color:#39C;">完善个人信息</a>，马上获得3天专业版体验。<button type="button" class="show">打开提示</button>
    </div>
    <div class="detail"style="display:none;">
        <table width="100%" border="0" cellspacing="0" cellpadding="10">
            <tr>
                <td valign="top">
                    <h3>welcomejiong@163.com</h3>
                    您正在使用大众版调查派
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
                    <td align="center"><a href="/upgrade" class="redbutton">马上升级专业版</a>
                        <br />
<br />
                        <a href="javascript:void(0);" class="upgrade_btn modify_profile">完善个人信息</a>，马上获得3天专业版体验</td>
                    <td valign="bottom"><button type="button" class="close">×关闭提示</button></td>
            </tr>
        </table>
    </div>
</div>
<div id="profile_edit" title="编辑个人信息" style="display:none">
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
                <td>
                    <select name="industry">
                        <option value="">请选择...</option>
                                                <option value="计算机软件" >计算机软件</option>
                                                <option value="计算机硬件" >计算机硬件</option>
                                                <option value="计算机服务(系统、数据服务、维修)" >计算机服务(系统、数据服务、维修)</option>
                                                <option value="通信/电信/网络设备" >通信/电信/网络设备</option>
                                                <option value="通信/电信运营、增值服务" >通信/电信运营、增值服务</option>
                                                <option value="互联网/电子商务" >互联网/电子商务</option>
                                                <option value="网络游戏" >网络游戏</option>
                                                <option value="电子技术/半导体/集成电路" >电子技术/半导体/集成电路</option>
                                                <option value="仪器仪表/工业自动化" >仪器仪表/工业自动化</option>
                                                <option value="会计/审计" >会计/审计</option>
                                                <option value="金融/投资/证券" >金融/投资/证券</option>
                                                <option value="银行" >银行</option>
                                                <option value="保险" >保险</option>
                                                <option value="贸易/进出口" >贸易/进出口</option>
                                                <option value="批发/零售" >批发/零售</option>
                                                <option value="快速消费品(食品、饮料、化妆品)" >快速消费品(食品、饮料、化妆品)</option>
                                                <option value="服装/纺织/皮革" >服装/纺织/皮革</option>
                                                <option value="家具/家电/工艺品/玩具/珠宝" >家具/家电/工艺品/玩具/珠宝</option>
                                                <option value="奢侈品/收藏品" >奢侈品/收藏品</option>
                                                <option value="办公用品及设备" >办公用品及设备</option>
                                                <option value="机械/设备/重工" >机械/设备/重工</option>
                                                <option value="汽车及零配件" >汽车及零配件</option>
                                                <option value="制药/生物工程" >制药/生物工程</option>
                                                <option value="医疗/护理/卫生" >医疗/护理/卫生</option>
                                                <option value="医疗设备/器械" >医疗设备/器械</option>
                                                <option value="广告" >广告</option>
                                                <option value="公关/市场推广/会展" >公关/市场推广/会展</option>
                                                <option value="影视/媒体/艺术/文化传播" >影视/媒体/艺术/文化传播</option>
                                                <option value="文字媒体/出版" >文字媒体/出版</option>
                                                <option value="印刷/包装/造纸" >印刷/包装/造纸</option>
                                                <option value="房地产开发" >房地产开发</option>
                                                <option value="建筑/建材/工程" >建筑/建材/工程</option>
                                                <option value="家居/室内设计/装潢" >家居/室内设计/装潢</option>
                                                <option value="物业管理/商业中心" >物业管理/商业中心</option>
                                                <option value="中介服务" >中介服务</option>
                                                <option value="专业服务(咨询、人力资源、财会)" >专业服务(咨询、人力资源、财会)</option>
                                                <option value="外包服务" >外包服务</option>
                                                <option value="检测，认证" >检测，认证</option>
                                                <option value="法律" >法律</option>
                                                <option value="教育/培训/院校" >教育/培训/院校</option>
                                                <option value="学术/科研" >学术/科研</option>
                                                <option value="餐饮业" >餐饮业</option>
                                                <option value="酒店/旅游" >酒店/旅游</option>
                                                <option value="娱乐/休闲/体育" >娱乐/休闲/体育</option>
                                                <option value="美容/保健" >美容/保健</option>
                                                <option value="生活服务" >生活服务</option>
                                                <option value="交通/运输/物流" >交通/运输/物流</option>
                                                <option value="航天/航空" >航天/航空</option>
                                                <option value="石油/化工/矿产/地质" >石油/化工/矿产/地质</option>
                                                <option value="采掘业/冶炼" >采掘业/冶炼</option>
                                                <option value="电力/水利" >电力/水利</option>
                                                <option value="新能源" >新能源</option>
                                                <option value="原材料和加工" >原材料和加工</option>
                                                <option value="政府/公共事业" >政府/公共事业</option>
                                                <option value="非盈利机构" >非盈利机构</option>
                                                <option value="环保" >环保</option>
                                                <option value="农/林/牧/渔" >农/林/牧/渔</option>
                                                <option value="多元化业务集团公司" >多元化业务集团公司</option>
                                                <option value="其他行业" >其他行业</option>
                                            </select> <span class="red">*</span>
                </td>
            </tr>
            <tr>
                <td align="right">工作单位：</td>
                <td><input type="text" name="company" id="company" value="" size="30" /> <span class="red">*</span></td>
            </tr>
            <tr>
                <td align="right">职业：</td>
                <td>
                    <select name="occupation">
                        <option value="">请选择...</option>
                                                <option value="党政机关/社团/事业单位工作人员" >党政机关/社团/事业单位工作人员</option>
                                                <option value="医生" >医生</option>
                                                <option value="教师" >教师</option>
                                                <option value="律师" >律师</option>
                                                <option value="其它专业技术人员" >其它专业技术人员</option>
                                                <option value="企业管理人员" >企业管理人员</option>
                                                <option value="企业一般职员" >企业一般职员</option>
                                                <option value="个体户" >个体户</option>
                                                <option value="自由职业者" >自由职业者</option>
                                                <option value="公务员" >公务员</option>
                                                <option value="军人/警察" >军人/警察</option>
                                                <option value="在校学生" >在校学生</option>
                                                <option value="务农" >务农</option>
                                                <option value="待业" >待业</option>
                                            </select> <span class="red">*</span>
                </td>
            </tr>
            <tr>
                <td align="right">联系邮箱：</td>
                <td><input type="text" name="email" id="email" value="welcomejiong@163.com" size="30" /> <span class="red">*</span></td>
            </tr>
        </table>
    </form>
</div>
<div id="edit_profile_message" style="display:none"><p></p></div>

<script type="text/javascript">
Do('components-css');
Do('lang.account.zh_cn');
Do('jquery-ui', function() {

    // 修改个人信息
    $('#profile_edit').dialog({
        autoOpen: false,
        height: 400,
        width: 400,
        modal: true,
        resizable: false,
        buttons: [
            {
                id: 'profile_edit_submit',
                text: _('submit'),
                click: function(){
                    try {
                        var values = _validate_form_profile();
                        _send_profile_edit_request(values);
                    } catch (ex) {
                        window.alert(ex.message);
                        ex.infocus.focus();
                    }
                },
                style: "background:url('/images/button_blue_bg.gif') repeat-x; color:#fff; font-size: 14px; border-color:#089dcb;"
            }
        ]
    });

    $(document).ready(function(){
        $('a.modify_profile').click(function(){
            $("#profile_edit").dialog( "open" );
        });
    });

    function _validate_form_profile() {
        var values = {};

        var realname = $('#realname').val();
        if (realname == '') {
            throw {'message': '请填写姓名!', 'infocus': $('#realname')};
        }
        values['realname'] = realname;

        var mobile = $('#mobile').val();
        if (mobile == '') {
            throw {'message': '请填写手机号码!', 'infocus': $('#mobile')};
        } else if (!/^\+?[\-0-9]{6,}$/.test(mobile)) {
            throw {'message': '请正确填写手机号码!', 'infocus': $('#mobile')};
        }
        values['mobile'] = mobile;

        var address = $('#address').val();
        if (address == '') {
            throw {'message': '请填写联系地址!', 'infocus': $('#address')};
        }
        values['address'] = address;

        var industry = $("#form_profile select[name='industry'] option:selected").val();
        if (industry == '') {
            throw {'message': '请选择您从事的行业!', 'infocus': $('#industry')};
        }
        values['industry'] = industry;

        var company = $('#company').val();
        if (company == '') {
            throw {'message': '请填写工作单位!', 'infocus': $('#company')};
        }
        values['company'] = company;

        var occupation = $("#form_profile select[name='occupation'] option:selected").val();
        if (occupation == '') {
            throw {'message': '请选择您的职业!', 'infocus': $('#occupation')};
        }
        values['occupation'] = occupation;

        var email = $('#email').val();
        if (email == '') {
            throw {'message': '请填写联系邮箱!', 'infocus': $('#email')};
        } else if (email != '' && !/^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email)) {
            throw {'message': '请正确填写联系邮箱!', 'infocus': $('#email')};
        }
        values['email'] = email;

        return values;
    }

    function _send_profile_edit_request(value) {
        var url = $('#form_profile').attr('action');

        $.ajax({
            url: url,
            type: "POST",
            data: value,
            dataType: "json",
            beforeSend: function() {
                $('#profile_edit_submit').prop("disabled", true).find('span').text('正在提交...');
            },
            complete: function(XHR, textStatus) {
                $("#profile_edit").dialog( "close" );
                if (XHR.status != 200) {
                    window.alert(_('profile edit failed'));
                }
                $('#profile_edit_submit').prop("disabled", false).find('span').text('提交');
            },
            success: function(resp, textStatus, XHR){
                $("#profile_edit").dialog( "close" );
                var msg = _('profile edit success');
                if (resp.win_free_trial == true ) {
                    msg = msg + ',' + _('win free trial');
                }
                _show_edit_result( msg);
                $("#edit_profile_message").dialog({
                    close: function() {window.location.reload();}
                });                
            }
        });
    }

    function _show_edit_result(msg) {
        $("#edit_profile_message").find('p').text(msg);

        $("#edit_profile_message").dialog({
            resizable: false,
            modal: true,
            title: _('message title')
        });
        setTimeout(function(){$("#edit_profile_message").dialog("close")}, 3000);
    }
});
</script>

<script type="text/javascript">
Do('components-css');
Do(function() {
    var $root = $('#upgrade_vip'),
        $intro = $root.find('.intro'),
        $detail = $root.find('.detail');

    $root.delegate('.intro button.show', 'click', function() {
        $intro.hide(); $detail.show();
    }).delegate('.detail button.close', 'click', function() {
        $intro.show(); $detail.hide();
    });
});
</script>
<div class="surveysinfo">
<div class="search">
        <form id="searchform" action="/my/survey" method="get">
            <input type="text" value="" id="key" name="key" size="30"/>
            <input id="searchaction" type="submit" value="搜索调查表">
        </form>
    </div>
    <div id="alertdiv" class="wait_inf" style="display:none;"></div>
    <a href="/my/survey">全部</a>（共<span>1</span>个）调查表 <a href="/my/survey/generator" class="creatnew_btn">新建调查表</a> 
    
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
            <option value="/my/survey?status=run">正在运行</option>
            <option value="/my/survey?status=close">已经结束</option>
            <option value="/my/survey?status=audit">正在审核</option>
            <option value="/my/survey?status=public">已经公开</option>
            <option value="/my/survey?status=unpublic">尚未公开</option>
            </optgroup>
            <option value="" disabled>选择标签</option>
            <optgroup name="surveyTag">  </optgroup>
        </select>
    排序:
        <div class="start_time"><a class="down" href="?ordertype=create_time&order=desc">创建时间</a></div>
        <div class="titl"><a class="up" href="?ordertype=title&order=asc">标题</a></div>
</div>
<div class="main_mysurvey">
    <div class="left">
                        <div class="page"><span>共1个调查表</span><span>第1-1个</span>        </div>
        <dl class="my_survey">
                                    <dt> 创建时间：
                2012-07-31            </dt>
                        <dd id="dd_d944a519-b4fa-40d5-aedf-15d1f31f8956" values="d944a519-b4fa-40d5-aedf-15d1f31f8956">
                <div class="jt"></div>
                <div class="status">
                                        <input type="checkbox" name="run" value="d944a519-b4fa-40d5-aedf-15d1f31f8956"/>
                    <a class="running" href="javascript:void(0);" command="close" values="d944a519-b4fa-40d5-aedf-15d1f31f8956" title="正在运行,点击关闭调查表"></a>
                                    </div>
                <div class="survey_inf">
                    <h1><a target="_blank" title="xxx" href="/survey624951">xxx</a></h1>
                    <div class="survey_url">
                        调查表地址：http://www.diaochapai.com/survey624951                                                <a href="javascript:void(0);" class="need_upgrade" title="生成调查表的可打印pdf文件"><span class="print">打印(PDF)问卷</span></a>
                                            </div>
                    <div class="function_url">
                        <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956"class="greybutton" title="编辑调查表内容和外观"><span class="edit">编辑</span></a>
                        <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/setup" class="greybutton" title="设置调查表填写规则"><span class="setup">设置</span></a>
                        <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/share" class="greybutton" title="获取调查表地址和嵌入代码并分享到微博"><span class="share">分享</span></a>
                        <a href="/report/d944a519-b4fa-40d5-aedf-15d1f31f8956?init=1" class="greybutton" title="实时查看调查表结果统计"><span class="analytics">数据统计</span></a>
                        <a href="javascript:void(0);" class="greybutton download need_upgrade" data-sn="d944a519-b4fa-40d5-aedf-15d1f31f8956" title="自助下载所有原始数据，并可以导入Excel或SPSS进行深入分析"><span class="download">下载数据</span></a>
                        <span class="function">
                            <a href="javascript:void(0);" class="greybutton delete" data-sn="d944a519-b4fa-40d5-aedf-15d1f31f8956" title="删除调查表"><span class="del">删除</span></a>
                            <a href="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/copy" class="greybutton" title="复制调查表"><span class="copy">复制</span></a>
                        </span>
                    </div>
                </div>
                <div class="data">数据<br />
                    <span>0</span></div>
            </dd>
                    </dl>
            <div class="page"><span>共1个调查表</span><span>第1-1个</span>        </div>
    </div>
    <div class="right_block">
                <div class="right" style="" id="r_d944a519-b4fa-40d5-aedf-15d1f31f8956">
            <h1><a target="_blank" href="/survey624951">xxx</a></h1>
            <div class="datashow">
                <div class="more_inf">
                    <div class="b_r"></div>
                    <div class="data"><font>数据收集:</font><span>0</span><br />
                        <font>访问量:</font><span>0</span></div>
                    <div class="js_pic">
                                                <div response="[0,0,0,0,0,0,0]" pageview="[0,0,0,0,0,0,0]" id="img_d944a519-b4fa-40d5-aedf-15d1f31f8956" style="width:227px;height:200px;"></div>
                    </div>
                </div>
                <div style="text-align:right;"> <a href="/report/d944a519-b4fa-40d5-aedf-15d1f31f8956" class="greybutton">查看数据统计</a> </div>
            </div>
            <div class="running_status">运行状态：
                                <span class="running">正在运行</span>
                            </div>
            <div class="time"><span class="start">创建时间：<font>2012-07-31</font></span><span class="over">结束时间：<font>
                永久                </font></span></div>
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
    <div style="display:none;" id="tagarea" title="标签管理">
        <table width="100%" id="tagtable">
            <tr>
                <td>多个标签使用空格分隔</td>
            </tr>
            <tr>
                <td><input id="mytag" type="text" size="50"/></td>
            </tr>
            <tr>
                <td>我的标签
                    <div id="systags"></div></td>
            </tr>
            <tr>
                <td>常用标签 <span>用户体验</span> <span>满意度调查</span> <span>公司管理</span> <span>人力资源</span> <span>产品市场</span> <span>培训反馈</span> <span>读者调查</span> <span>学术研究</span> <span>用户反馈</span> <span>报名表</span></td>
            </tr>
        </table>
    </div>
</div>
<div style="display:none;">
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
                <td width="120" height="65" align="center"><a class="button" href="/upgrade"><img alt=""  src="/images/upload_btn_3.gif" border="0" /></a></td>
            </tr>
        </table>
    </div>
</div>

<script type="text/javascript">
Do('components-css');
Do('jquery-fancybox', function() {
    $('.need_upgrade').fancybox({
        href: '#upgrade_dialog',
        scrolling: 'no',
        autoScale: true,
        titleShow: false,
        onStart: function(a) {
            $('#upgrade_dialog p.intro').text( $(a).attr('title') );
        }
    });
});
</script>

<div id="footer">2007-<span class="wid950 copyright">2012</span> 重庆甚为派科技有限公司版权所有  www.diaochapai.com</div>
<script type="text/javascript">
Do(function() {
    function _show_more($node) {
        var timer = $node.data('timer');
        if (timer) window.clearTimeout(timer);

        timer = window.setTimeout(function() {
            var $label = $node.find('> a');
            !$label.hasClass('current') && $label.addClass('current');
            $node.find('.more').show();
        }, 200);
        $node.data('timer', timer);
    }

    function _hide_more($node) {
        var timer = $node.data('timer');
        if (timer) window.clearTimeout(timer);

        timer = window.setTimeout(function() {
            var $label = $node.find('> a');
            $label.hasClass('current') && $label.removeClass('current');
            $node.find('.more').hide();
        }, 200);
        $node.data('timer', timer);
    }

    var $search = $('#header .menu li .more');
    for (var i = 0, more; more = $search[i++];) {
        var $more = $(more),
            $node = $more.parents('li'),
            m_width = $more.width(),
            n_width = $node.width();
        if (m_width < n_width) $more.width(n_width);
    }

    $('#header .menu').delegate('li', 'mouseover mouseout', function(event) {
        var $node = $(this);
        if (event.type == 'mouseover') {
            _show_more($node);
        } else {
            _hide_more($node);
        }
    });

    $('#header .menu').delegate('li .more', 'mouseover mouseout', function(event) {
        var $node = $(this).parents('li');
        if (event.type == 'mouseover') {
            _show_more($node);
        } else {
            _hide_more($node);
        }
    });
});
</script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="/j/jquery/flot/excanvas.min.js"></script>
<![endif]--> 
<script type="text/javascript">
Do('my.survey');
var _gaq = _gaq || [];
_gaq.push(['_trackEvent', 'Survey', 'Manager']);
</script>
</body>
</html>
