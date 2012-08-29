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
<title>调查派 – 简单，好用的在线调查系统</title>

<link type="text/css" rel="stylesheet" href="/css/jq/ui/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/css/jq/ztree/zTreeStyle.css" />
<link type="text/css" rel="stylesheet" href="/css/u/users.css" />
<link type="text/css" rel="stylesheet" href="/css/u/survey.css" />
<link type="text/css" rel="stylesheet" href="/css/u/naire.css" />
<link rel="icon" href="/logo.ico" type="image/x-icon" />
<style type="text/css">
 .ui-tabs .ui-tabs-panel {
     background: none repeat scroll 0 0 transparent;
     border-width: 0;
     padding: 2px;
 }
</style>
<script type="text/javascript" src="/js/jq/jquery.js"></script>
<script type="text/javascript" src="/js/jq/ui/jquery-ui.js"></script>
<script type="text/javascript" src="/js/jq/ztree/jquery.ztree.all.js"></script>
<script type="text/javascript" src="/js/core.js"></script>
<script type="text/javascript" src="/js/u/naire.js"></script>
</head>

<body>
 <%@include file="/WEB-INF/jsp/common/header.jsp"%>
 <div id="tabs_main">
  <ul>
   <li><a href="#tabs_survey_manager">编辑内容</a></li>
   <li><a href="#tabs_skin_manager">设置外观</a></li>
   <li><a href="#tabs_trigger_manager">定义逻辑</a></li>
  </ul>
  <div id="tabs_survey_manager">
   <div id="part_toolbar">
    <button type="button" id="add_template">模板问题</button>
    <button type="button" id="add_select_radio">
     <img src="/images/icon/16_mchoise.gif" width="16" height="16" />单选题
    </button>
    <button type="button" id="add_select_checkbox">
     <img src="/images/icon/16_checkbox.gif" width="16" height="16" />多选题
    </button>
    <button type="button" id="add_text_input">
     <img src="/images/icon/16_singletext.gif" width="16" height="16" />填空题
    </button>
    <button type="button" id="add_text_textarea">
     <img src="/images/icon/16_textbox.gif" width="16" height="16" />问答题
    </button>
    <button type="button" id="add_matrix">
     <img src="/images/icon/16_matrix.gif" width="16" height="16" />组合选择题
    </button>
    <button type="button" id="add_separator">
     <img src="/images/icon/16_separator.gif" width="16" height="16" />分隔符
    </button>
    <button type="button" id="add_html">
     <img src="/images/icon/16_html.gif" width="16" height="16" />自定义内容
    </button>
   </div>
   <table class="main" width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <td valign="top" class="left_side">
      <div class="tree_buttons">
       <button type="button" disabled="disabled" id="moveup_part">上移</button>
       <button type="button" disabled="disabled" id="movedown_part">下移</button>
       <button type="button" disabled="disabled" id="copy_part">复制</button>
       <button type="button" disabled="disabled" id="paste_part">粘贴</button>
       <button type="button" disabled="disabled" id="remove_part">删除</button>
      </div>
      <div class="tree_panel">
       <ul id="tree_page" class="ztree">

       </ul>
      </div>
     </td>
     <td id="survey_manager_toggler" class="expand"><img src="/images/blank.gif" /></td>
     <td valign="top" class="right_side">
      <div id="survey_sandbox">
       <div id="page_selector">
        <button type="button" id="add_page">
         <img src="/images/icon/16_add.gif" width="16" height="16" />新建页
        </button>
        <button type="button" id="remove_page">
         <img src="/images/icon/16_del.gif" width="16" height="16" />删除当前页
        </button>
        <span id="page_list"></span>
       </div>
       <div id="edit_naire_view">&nbsp;</div>
      </div>
     </td>
    </tr>
   </table>
  </div>
  <div id="tabs_skin_manager" style="display: none; height: 420px;">
   <div id="skin_toolbar">
    <div class="skin_designer">
     <div class="category"></div>
     <div class="selector"></div>
     <div class="widget_panel"></div>
     <button type="button" id="save_my_skin">保存成我的外观</button>
    </div>
   </div>
   <table class="main" width="100%" border="0" cellspacing="0" cellpadding="0" style="height: 359px;">
    <tr>
     <td valign="top" class="left_side"><div id="skin_list">
       <div class="list_toggler">基本外观</div>
       <div class="list">
        <ul id="sys_skin_list">
        </ul>
       </div>
       <div class="list_toggler">我的外观</div>
       <div class="list">
        <ul id="my_skin_list">
        </ul>
       </div>
       <div class="list_toggler" id="tab_css_editor">CSS 调试</div>
       <div class="list" id="user_css_editor">
        <textarea style="width: 98%;" class="css_editor"></textarea>
        <button type="button" id="" class="apply">应用</button>
       </div>
      </div></td>
     <td id="skin_manager_toggler" class="expand"><img src="/images/blank.gif" /></td>
     <td valign="top" class="right_side"><div id="fake_skin_view">&nbsp;</div></td>
    </tr>
   </table>
  </div>
  <div id="tabs_trigger_manager" style="display: none; height: 420px;">
   <div id="trigger_toolbar">
    <select name="parts"></select>
    <button name="add_trigger" type="button">添加逻辑定义</button>
    <div style="display: none;">
     <fieldset class="page" id="page_trigger_panel">
      <legend class="page_title"></legend>
      <div class="triggers"></div>
     </fieldset>
    </div>
   </div>
   <div id="trigger_sandbox" style="height: 359px;"></div>

   <div style="display: none;">
    <div id="page_triggers" class="page_triggers">
     <h2 class="page_title"></h2>
     <ul class="part_triggers"></ul>
    </div>

    <ul>
     <li id="part_select_triggers" class="part_trigger">
      <div class="title">
       <span class="subject"></span>
       <button type="button" name="delete_triggers">删除逻辑</button>
      </div>
      <div class="options"></div>
     </li>
    </ul>

    <form id="select_option_trigger_editor" onsubmit="return false;">
     <span class="subject"></span> <span class="option"></span>
     <div class="action">
      <fieldset>
       <legend>关联显示</legend>
       <ul class="parts"></ul>
      </fieldset>
      <fieldset>
       <legend>其它操作</legend>
       <ul class="other">
        <li><input type="checkbox" id="363b6a80-b8f7-4e68-b784-e65dc34050e0" name="other" value="finish" /> <label
         for="363b6a80-b8f7-4e68-b784-e65dc34050e0">结束调查表</label></li>
       </ul>
      </fieldset>
     </div>
    </form>
   </div>
  </div>
 </div>

 <%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
