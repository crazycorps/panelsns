<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta content="调查派@diaochapai.com" name="author" />
<meta content="本页版权 www. diaochapai.com调查派所有。All Rights Reserved"
	name="copyright" />
<link rel="icon" href="/logo.ico" type="image/x-icon" />
<link href="/css/layouts/default.css" rel="stylesheet" type="text/css" />
<link href="/css/login.css" rel="stylesheet" type="text/css" />
<title>调查派 – 简单，好用的在线调查问卷系统</title>
<script type="text/javascript" src="/js/jq/jquery.js"></script>

</head>
<body>
	<div class="toptxt">
		<div class="txt">
			<a href="/login">登录</a><span class="v-split">|</span> <a
				href="/register">注册</a><span class="v-split">|</span> <a
				href="http://feedback.diaochapai.com/" target="_blank">意见</a><span
				class="v-split">|</span> <a href="http://support.diaochapai.com/"
				target="_blank">帮助</a>
		</div>
	</div>
	<div class="header">
		<div class="wid950">
			<div class="logo">
				<a href="/"><img src="/images/index/logo.gif" border="0" /></a>
			</div>
			<div class="navgation">
				<ul>
					<li><a href="/">首页</a></li>
					<li><a href="/intro">产品功能</a></li>
					<li><a href="/cases">典型应用</a></li>
					<li><a href="/price">服务与价格</a></li>
					<li><a href="/surveys">公开的调查表</a></li>
				</ul>
			</div>
		</div>

	</div>

	<div class="wid950 registerbox">
		<div class="registlink">
			还没有调查派帐号？<a href="/register">立即注册</a>
		</div>
		<div class="content">
			<h2>欢迎登录调查派</h2>
			<form id="login_form" name="login_form" action="/u/" method="post">
				<div class="form-error"></div>
				<table width="560" align="center" cellpadding="10" cellspacing="0">
					<tr>
						<td align="right">Email</td>
						<td class="form-item extra-tips"><input type="email"
							id="email" name="email" value="" class="inputxt" /></td>
					</tr>
					<tr>
						<td align="right">密码</td>
						<td class="form-item extra-tips"><input type="password"
							id="passwd" name="passwd" value="" class="inputxt" /></td>
					</tr>
					<tr>
						<td class="fir"></td>
						<td align="left"><table width="100%" border="0">
								<tr>
									<td width="109"><button type="submit" id="submit"
											class="view_report_btn">登 录</button></td>
									<td width="341" align="left" valign="bottom"><a
										href="/forgot/mail">忘记密码？</a></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
			<p>&nbsp;</p>
			<div class="link_login">
				<table border="0">
					<tr>
						<td width="150" align="center">使用合作网站账号登录：</td>
						<td width="90"><a class="sin" href="/login/sina"></a></td>
						<td width="90"><a class="qqwb" href="/login/txweibo"></a></td>
						<td width="90"><a class="qqmysl" href="/login/qqzone"></a></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="wid950 links">
			<ul>
				<li>
					<h4>产品与功能</h4> <a href="/intro">产品功能</a><br /> <a href="/pro">专业版介绍</a>
					<br /> <a href="/price">服务与价格</a> <br /> <a href="/surveys">公开的调查表</a><br />
					<a href="/register">注册</a>
				</li>
				<li>
					<h4>典型应用</h4> <a href="/cases">行业应用</a><br /> <a href="/stories">典型应用</a><br />
					<a href="/customers">我们的用户</a>
				</li>
				<li>
					<h4>支持与帮助</h4> <a href="http://support.diaochapai.com/faq.html"
					target="_blank">常见问题</a><br /> <a
					href="http://support.diaochapai.com" target="_blank">帮助中心</a><br />
					<a href="http://feedback.diaochapai.com" target="_blank">意见反馈</a><br />
					<a href="/privacy">隐私条款</a>
				</li>

				<li style="margin-right: 0px;">
					<h4>团队</h4> <a href="/about">关于我们</a><br /> <a
					href="http://blog.diaochapai.com" target="_blank">调查派博客</a><br />
					<a href="/jobs">工作机会</a><br /> <a href="/about">联系我们</a>
				</li>
				<li class="icon">
					<h4>联系我们</h4> <a href="mailto:support@diaochapai.com">support@diaochapai.com</a><br />
					电话：(+86)023 89887599<br />QQ：1146014774<br />
					<p class="followus">
						<a href="http://weibo.com/diaochapai" class="sin" target="_blank"></a>
						<a href="http://t.qq.com/Surveypie" class="qq" target="_blank"></a>
						<a href="http://www.douban.com/people/diaochapai/" class="db"
							target="_blank"></a><a
							href="http://blog.diaochapai.com/?feed=rss2" class="rss"
							target="_blank"></a>
					</p>
				</li>
			</ul>
		</div>
		<div class="wid950 copyright">
			Copyright © 2007~2012 重庆甚为派科技有限公司版权所有<a href="/statement">免责声明</a><br />
			沪ICP备10212628号-24
		</div>
	</div>
</body>
</html>

