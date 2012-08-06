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
<link type="text/css" rel="stylesheet" href="/css/jq/ui/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/css/u/users.css" />
<link type="text/css" rel="stylesheet" href="/css/u/survey.css" />
<link type="text/css" rel="stylesheet" href="/css/u/naire.css" />
<link rel="icon" href="/logo.ico" type="image/x-icon" />
<title>调查派 – 简单，好用的在线调查系统</title>
<script type="text/javascript" src="/js/jq/jquery.js"></script>
<script type="text/javascript" src="/js/jq/ui/jquery-ui.js"></script>
<script type="text/javascript" src="/js/core.js"></script>
<script type="text/javascript" src="/js/u/naire.js"></script>
</head>

<body>
 <%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="editor_toolbar" id="editor_toolbar">
    <ul class="menu" id="naire_tabs">
        <li class="on" name="survey" title="轻松问卷调查">编辑内容</li>
        <li name="skin" title="让问卷变漂亮">设置外观</li>
        <li name="trigger"  title="定义问卷逻辑关联">定义逻辑</li>
    </ul>
    <div class="notice_bar"><span id="notice_bar" class="notice" style="display:none;"></span></div>
    <div class="buttons">
        <span class="preview">预览</span>
        <a href="javascript:void(0);" onclick="return false;" class="save"><span>保存</span></a>
        <a href="javascript:void(0);" onclick="return false;" class="publish">保存并分享</a>
    </div>
</div>

<div id="main">
    <div id="survey_manager">
    <div id="part_toolbar">
        <button type="button" id="add_template">模板问题</button>
        <button type="button" id="add_select_radio"><img src="/images/icon/16_mchoise.gif" width="16" height="16" />单选题</button>
        <button type="button" id="add_select_checkbox"><img src="/images/icon/16_checkbox.gif" width="16" height="16" />多选题</button>
        <button type="button" id="add_text_input"><img src="/images/icon/16_singletext.gif" width="16" height="16" />填空题</button>
        <button type="button" id="add_text_textarea"><img src="/images/icon/16_textbox.gif" width="16" height="16" />问答题</button>
        <button type="button" id="add_matrix"><img src="/images/icon/16_matrix.gif" width="16" height="16" />组合选择题</button>
        <button type="button" id="add_separator"><img src="/images/icon/16_separator.gif" width="16" height="16" />分隔符</button>
        <button type="button" id="add_html"><img src="/images/icon/16_html.gif" width="16" height="16" />自定义内容</button>
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
                <div class="tree_panel"></div>
            </td>
            <td id="survey_manager_toggler" class="expand"><img src="/images/blank.gif"/></td>
            <td valign="top" class="right_side">
                <div id="survey_sandbox">
                    <div id="page_selector">
                        <button type="button" id="add_page"><img src="/images/icon/16_add.gif" width="16" height="16" />新建页</button>
                        <button type="button" id="remove_page"><img src="/images/icon/16_del.gif" width="16" height="16" />删除当前页</button>
                        <span id="page_list"></span>
                    </div>
                    <div id="fake_survey_view">&nbsp;</div>
                </div>
            </td>
        </tr>
    </table>
</div>

<div style="display:none;" id="template-selector-box">
    <div class="select-template">选择问题类别：
        <select id="template-tags-select" name="template-tags-select">
                        <option value="个人娱乐">个人娱乐</option>
                        <option value="互联网与IT类">互联网与IT类</option>
                        <option value="公司企业">公司企业</option>
                        <option value="市场调查">市场调查</option>
                        <option value="政府机构">政府机构</option>
                        <option value="教育和培训">教育和培训</option>
                        <option value="满意度调查">满意度调查</option>
                        <option value="用户基本信息">用户基本信息</option>
                        <option value="网络店铺">网络店铺</option>
                    </select>
    </div>
    <div id="template-select-panel">
        <div class="panel loading" style="display:none;">loading</div>
        <div class="panel error" style="display:none;">载入失败，请重试</div>
    </div>
</div>
    <div id="skin_manager" style="display:none;">
    <div id="skin_toolbar">
        <div class="skin_designer">
            <div class="category"></div>
            <div class="selector"></div>
            <div class="widget_panel"></div>
            <button type="button" id="save_my_skin">保存成我的外观</button>
        </div>
    </div>
    <table class="main" width="100%" border="0" cellspacing="0" cellpadding="0">
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
            <td id="skin_manager_toggler" class="expand"><img src="/images/blank.gif"/></td>
            <td valign="top" class="right_side"><div id="fake_skin_view">&nbsp;</div></td>
        </tr>
    </table>
</div>
<div id="skin_designer_helper" style="display:none;">
    <div class="skin_designer_widgets">
        <div id="color_picker_handle"></div>
        <div id="font_widgets_set">
            <div> 字体
                <select class="widget select" title="font-family">
                    <option selected="" value="">系统默认</option>
                    <option value="宋体">宋体</option>
                    <option value="黑体">黑体</option>
                    <option value="隶书">隶书</option>
                </select>
                大小
                <select class="widget select" title="font-size">
                    <option selected="" value="">系统默认</option>
                    <option value="9pt">9pt</option>
                    <option value="10pt">10pt</option>
                    <option value="12pt">12pt</option>
                    <option value="14pt">14pt</option>
                    <option value="16pt">16pt</option>
                    <option value="18pt">18pt</option>
                    <option value="24pt">24pt</option>
                    <option value="36pt">36pt</option>
                </select>
            </div>
            <div class="widget radio" title="text-align">
                <label title="/images/icon/icon_font_align_left.gif">
                    <input type="radio" name="text-align" value="left">
                    居左</label>
                <label title="/images/icon/icon_font_align_center.gif">
                    <input type="radio" name="text-align" value="center">
                    居中</label>
                <label title="/images/icon/icon_font_align_right.gif">
                    <input type="radio" name="text-align" value="right">
                    居右</label>
            </div>
            <div class="widget checkbox" title="font-weight">
                <label title="/images/icon/icon_font_bold.gif">
                    <input type="checkbox" name="font-weight" value="bolder" off_value="normal">
                    粗体</label>
            </div>
            <div class="widget checkbox" title="font-style">
                <label title="/images/icon/icon_font_italic.gif">
                    <input type="checkbox" name="font-style" value="italic">
                    斜体</label>
            </div>
            <div class="widget color_picker" title="color"></div>
        </div>
        <dl class="skin_designer_define">
            <dt class="category">背景设置</dt>
            <dd>
                <dl>
                    <dt class="selector" title="html body">整页背景</dt>
                    <dd>
                        <div>
                            <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                            <div class="textnotes">图片：</div>
                            <div class="widget image_selector" title="background-image">
                                <select>
                                    <option value="/images/bg/none.gif">无背景</option>
                                    <option value="/images/bg/10_bg_xmas_01.gif">圣诞背景</option>
                                    <option value="/images/bg/10_bg_xmas_02.gif">圣诞背景</option>
                                    <option value="/images/bg/bg_baowen_01.jpg">bg1</option>
                                    <option value="/images/bg/bg_baowen_02.jpg">bg2</option>
                                    <option value="/images/bg/bg_baowen_03.jpg">bg3</option>
                                    <option value="/images/bg/bg_baowen_04.jpg">bg4</option>
                                    <option value="/images/bg/bg_baowen_05.jpg">bg5</option>
                                    <option value="/images/bg/bg_baowen_06.jpg">bg6</option>
                                    <option value="/images/bg/bg_baowen_07.jpg">bg7</option>
                                    <option value="/images/bg/bg_cute_01.gif">cute01</option>
                                    <option value="/images/bg/bg_cute_02.gif">cute02</option>
                                    <option value="/images/bg/bg_cute_03.gif">cute03</option>
                                    <option value="/images/bg/bg_cute_04.gif">cute04</option>
                                    <option value="/images/bg/bg_cute_05.gif">cute05</option>
                                    <option value="/images/bg/bg_cute_07.gif">cute07</option>
                                    <option value="/images/bg/bg_cute_08.jpg">cute08</option>
                                    <option value="/images/bg/bg_cute_09.jpg">cute09</option>
                                    <option value="/images/bg/bg_cute_10.gif">cute10</option>
                                    <option value="/images/bg/bg_cute_11.jpg">cute11</option>
                                    <option value="/images/bg/bg_cute_12.jpg">cute12</option>
                                    <option value="/images/bg/bg_cute_13.jpg">cute13</option>
                                    <option value="/images/bg/bg_cute_14.jpg">cute14</option>
                                    <option value="/images/bg/bg_cute_15.jpg">cute15</option>
                                    <option value="/images/bg/bg_cute_16.jpg">cute16</option>
                                    <option value="/images/bg/bg_cute_17.jpg">cute17</option>
                                    <option value="/images/bg/bg_cute_18.jpg">cute18</option>
                                    <option value="/images/bg/bg_cute_19.gif">cute19</option>
                                    <option value="/images/bg/bg_cute_20.gif">cute20</option>
                                    <option value="/images/bg/bg_cute_21.jpg">cute21</option>
                                    <option value="/images/bg/bg_cute_23.jpg">cute23</option>
                                    <option value="/images/bg/bg_cute_24.jpg">cute24</option>
                                    <option value="/images/bg/bg_cute_25.jpg">cute25</option>
                                    <option value="/images/bg/bg_cute_26.jpg">cute26</option>
                                    <option value="/images/bg/bg_cute_27.jpg">cute27</option>
                                    <option value="/images/bg/bg_cute_28.jpg">cute28</option>
                                    <option value="/images/bg/bg_cute_29.gif">cute29</option>
                                    <option value="/images/bg/bg_cute_30.jpg">cute30</option>
                                    <option value="/images/bg/bg_cute_31.jpg">cute31</option>
                                    <option value="/images/bg/bg_cute_32.jpg">cute32</option>
                                    <option value="/images/bg/bg_cute_33.jpg">cute33</option>
                                    <option value="/images/bg/bg_cute_34.jpg">cute34</option>
                                    <option value="/images/bg/bg_cute_35.jpg">cute35</option>
                                    <option value="/images/bg/bg_cute_36.gif">cute36</option>
                                    <option value="/images/bg/bg_cute_37.gif">cute37</option>
                                    <option value="/images/bg/bg_cute_38.gif">cute38</option>
                                    <option value="/images/bg/bg_cute_39.gif">cute39</option>
                                    <option value="/images/bg/bg_cute_40.gif">cute40</option>
                                    <option value="/images/bg/bg_cute_41.gif">cute41</option>
                                    <option value="/images/bg/bg_cute_42.jpg">cute42</option>
                                    <option value="/images/bg/bg_cute_43.gif">cute43</option>
                                    <option value="/images/bg/bg_cute_44.gif">cute44</option>
                                    <option value="/images/bg/bg_cute_45.jpg">cute45</option>
                                    <option value="/images/bg/bg_cute_46.jpg">cute46</option>
                                    <option value="/images/bg/bg_cute_47.jpg">cute47</option>
                                    <option value="/images/bg/bg_cute_48.gif">cute48</option>
                                    <option value="/images/bg/bg_cute_49.gif">cute49</option>
                                    <option value="/images/bg/bg_cute_50.gif">cute50</option>
                                    <option value="/images/bg/bg_cute_51.gif">cute51</option>
                                    <option value="/images/bg/bg_cute_52.gif">cute52</option>
                                    <option value="/images/bg/bg_cute_53.jpg">cute53</option>
                                    <option value="/images/bg/bg_desgin_02.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_03.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_04.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_05.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_06.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_07.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_08.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_09.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_10.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_11.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_12.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_13.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_14.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_15.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_16.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_17.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_18.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_19.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_20.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_21.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_23.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_24.jpg">desgin</option>
                                    <option value="/images/bg/bg_desgin_25.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_26.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_27.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_28.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_29.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_30.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_31.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_32.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_33.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_34.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_35.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_36.gif">desgin</option>
                                    <option value="/images/bg/bg_desgin_37.gif">desgin</option>
                                    <option value="/images/bg/bg_sw_01.jpg">business</option>
                                    <option value="/images/bg/bg_sw_02.jpg">business</option>
                                    <option value="/images/bg/bg_sw_03.jpg">business</option>
                                    <option value="/images/bg/bg_sw_04.gif">business</option>
                                    <option value="/images/bg/bg_sw_05.jpg">business</option>
                                    <option value="/images/bg/bg_sw_06.jpg">business</option>
                                    <option value="/images/bg/bg_sw_10.jpg">business</option>
                                    <option value="/images/bg/bg_sw_11.jpg">business</option>
                                    <option value="/images/bg/bg_sw_12.jpg">business</option>
                                    <option value="/images/bg/bg_sw_13.jpg">business</option>
                                    <option value="/images/bg/bg_sw_16.gif">business</option>
                                    <option value="/images/bg/bg_sw_17.gif">business</option>
                                    <option value="/images/bg/bg_sw_18.jpg">business</option>
                                    <option value="/images/bg/bg_sw_20.gif">business</option>
                                    <option value="/images/bg/bg_sw_21.gif">business</option>
                                    <option value="/images/bg/bg_sw_22.gif">business</option>
                                    <option value="/images/bg/bg_sw_23.jpg">business</option>
                                    <option value="/images/bg/bg_sw_24.jpg">business</option>
                                    <option value="/images/bg/bg_sw_26.jpg">business</option>
                                    <option value="/images/bg/bg_sw_27.gif">business</option>
                                </select>
                            </div>
                            <div class="textnotes">自定义背景图片：</div>
                            <input class="widget text" title="background-image" type="text" value="http://" />
                            <a href="/my/gallery" target="_blank" class="album">浏览我的图库</a> </div>
                    </dd>
                    <dt class="selector" title="html .page">调查表</dt>
                    <dd>
                        <div>
                        <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                        </div>
                    </dd>
                    <dt class="selector" title="html .surveypie .survey_header">调查表头</dt>
                    <dd>
                        <div>
                        <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                        </div>
                    </dd>
                    <dt class="selector" title="html .surveypie .survey-title">整页标题</dt>
                    <dd>
                        <div>
                        <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                        </div>
                    </dd>
                    <dt class="selector" title="html .surveypie .part h4.title">题目标题</dt>
                    <dd>
                        <div>
                        <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                        </div>
                    </dd>
                    <dt class="selector" title="html .surveypie .separator .title">分隔符</dt>
                    <dd>
                        <div>
                        <div class="textnotes">颜色：</div>
                            <div class="widget color_picker" title="background-color"></div>
                        </div>
                    </dd>
                </dl>
            </dd>
            <dt class="category">字体设置</dt>
            <dd>
                <dl>
                    <dt class="selector" title="html .surveypie .survey-title">调查表标题</dt>
                    <dd>
                        <div class="font_widgets_set"></div>
                    </dd>
                    <dt class="selector" title="html .surveypie .part h4.title">题目标题</dt>
                    <dd>
                        <div class="font_widgets_set"></div>
                    </dd>
                    <dt class="selector" title="html .surveypie .options">选项文字</dt>
                    <dd>
                        <div class="font_widgets_set"></div>
                    </dd>
                    <dt class="selector" title="html .surveypie .separator .title">分隔符文字</dt>
                    <dd>
                        <div class="font_widgets_set"></div>
                    </dd>
                </dl>
            </dd>
            <dt class="category">LOGO 设置</dt>
            <dd>
                <dl>
                    <dt class="selector" title="html .surveypie .survey_header">调查表 LOGO</dt>
                    <dd>
                        <div class="widget_panel">
                            <div class="textnotes">图片：</div>
                            <div class="widget image_selector" title="background-image">
                                <select>
                                    <option value="/images/bg/none.gif">无背景</option>
                                    <option value="/images/bg/surveyheader_logo.gif">调查派默认 LOGO</option>
                                    <option value="/images/bg/logo_xmas_01.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_02.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_03.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_04.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_05.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_06.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_07.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_08.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_09.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_10.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_11.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_12.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_13.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_14.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_15.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_16.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_17.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_18.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_19.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_20.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_21.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_22.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_23.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_24.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_xmas_25.png">欢乐圣诞</option>
                                    <option value="/images/bg/logo_desgin_01.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_02.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_03.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_05.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_06.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_07.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_08.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_09.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_12.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_13.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_15.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_16.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_23.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_24.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_25.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_26.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_27.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_28.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_29.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_30.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_31.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_32.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_33.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_34.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_35.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_36.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_39.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_42.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_43.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_44.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_45.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_46.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_47.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_48.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_49.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_50.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_desgin_51.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_01.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_02.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_03.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_04.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_05.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_06.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_07.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_08.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_09.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_10.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_11.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_12.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_13.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_14.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_15.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_16.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_17.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_18.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_19.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_20.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_21.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_22.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_23.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_24.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_25.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_26.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_27.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_28.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_29.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_30.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_31.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_32.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_33.png">系统提供 LOGO</option>
                                    <option value="/images/bg/logo_full_34.png">系统提供 LOGO</option>
                                </select>
                            </div>
                            自定义：
                            <input class="widget text" title="background-image" type="text" value="http://" />
                            <a href="/my/gallery" target="_blank" class="album">浏览我的图库</a> 高度：
                            <input class="widget text" title="height" type="text" value="25" style="width:32px;" />
                        </div>
                    </dd>
                </dl>
            </dd>
        </dl>
    </div>
</div>
    <div id="trigger_manager" style="display:none;">
    <div id="trigger_toolbar">
        <select name="parts"></select><button name="add_trigger" type="button">添加逻辑定义</button>
        <div style="display:none;">
            <fieldset class="page" id="page_trigger_panel">
                <legend class="page_title"></legend>
                <div class="triggers"></div>
            </fieldset>
        </div>
    </div>
    <div id="trigger_sandbox"></div>

    <div style="display:none;">
        <div id="page_triggers" class="page_triggers">
            <h2 class="page_title"></h2>
            <ul class="part_triggers"></ul>
        </div>

        <ul>
            <li id="part_select_triggers" class="part_trigger">
                <div class="title"><span class="subject"></span><button type="button" name="delete_triggers">删除逻辑</button></div>
                <div class="options"></div>
            </li>
        </ul>

        <form id="select_option_trigger_editor" onsubmit="return false;">
            <span class="subject"></span>
            <span class="option"></span>
            <div class="action">
                <fieldset>
                    <legend>关联显示</legend>
                    <ul class="parts"></ul>
                </fieldset>
                <fieldset>
                    <legend>其它操作</legend>
                    <ul class="other">
                        <li>
                            <input type="checkbox" id="363b6a80-b8f7-4e68-b784-e65dc34050e0" name="other" value="finish"/>
                            <label for="363b6a80-b8f7-4e68-b784-e65dc34050e0">结束调查表</label>
                        </li>
                    </ul>
                </fieldset>
            </div>
        </form>
    </div>
</div>
    <iframe src="/my/survey/d944a519-b4fa-40d5-aedf-15d1f31f8956/sandbox" width="100%" height="100%" frameborder="0" scrolling="auto" name="survey_frame" id="survey_frame" marginheight="0" marginwidth="0" style="position: absolute; z-index: 100; left: 18px; top: 163px; display:none;"></iframe>
</div>

  <%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
