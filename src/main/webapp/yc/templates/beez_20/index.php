<?php
/**
 * @package                Joomla.Site
 * @subpackage	Templates.beez_20
 * @copyright        Copyright (C) 2005 - 2014 Open Source Matters, Inc. All rights reserved.
 * @license                GNU General Public License version 2 or later; see LICENSE.txt
 */

// No direct access.
defined('_JEXEC') or die;

jimport('joomla.filesystem.file');

// check modules
$showRightColumn	= ($this->countModules('position-3') or $this->countModules('position-6') or $this->countModules('position-8'));
$showbottom			= ($this->countModules('position-9') or $this->countModules('position-10') or $this->countModules('position-11'));
$showleft			= ($this->countModules('position-4') or $this->countModules('position-7') or $this->countModules('position-5'));

if ($showRightColumn==0 and $showleft==0) {
	$showno = 0;
}

JHtml::_('behavior.framework', true);

// get params
$color				= $this->params->get('templatecolor');
$logo				= $this->params->get('logo');
$navposition		= $this->params->get('navposition');
$app				= JFactory::getApplication();
$doc				= JFactory::getDocument();
$templateparams		= $app->getTemplate(true)->params;

$doc->addStyleSheet($this->baseurl.'/templates/'.$this->template.'/css/style.css');

$doc->addScript($this->baseurl.'/templates/'.$this->template.'/js/jquery-1.12.4.min.js', 'text/javascript');
$doc->addScript($this->baseurl.'/templates/'.$this->template.'/js/script.js', 'text/javascript');

$pageclass = "";
$app = JFactory::getApplication();
$menu = $app->getMenu();
if ($menu->getActive() == $menu->getDefault()) {
    //$pageclass = "home";
}

$db = JFactory::getDbo();
//通知消息
$sql = "select id,title,alias,catid, created from yc_content where catid in(97) and state = 1  order by created DESC limit 0,5";
$db->setQuery($sql);
$items = $db->loadObjectList();
$tzxx = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 494;
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$tzxx[] = $obj;
}


?>

<!DOCTYPE html>
<html lang="<?php echo $this->language; ?>" dir="<?php echo $this->direction; ?>" >
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<jdoc:include type="head" />
</head>

<body class="<?php echo $pageclass; ?>">

<div id="header">
    <div class="nav">
        <div class="wp">
            <jdoc:include type="modules" name="position-1" />
        </div>
    </div>
    <div class="subnav">
        <div class="wp">
            <jdoc:include type="modules" name="position-0" />
            <span class="today">今天是 2016/06/16 星期四</span>
            <div class="notice"><span class="lb">通知：</span><div class="notices-wrap">
                <ul class="notices">
                    <!-- <li><a href="#">全国职业教育集团化办学工作专家组工作会议安排！</a></li>
                    <li><a href="#">全国职业教育集团化办学工作专家组工作会议安排！</a></li>
                    <li><a href="#">全国职业教育集团化办学工作专家组工作会议安排！</a></li>
                    <li><a href="#">全国职业教育集团化办学工作专家组工作会议安排！</a></li> -->
                    <?php 
						foreach ($tzxx as $item ){
					?>
					<li><a href="<?php echo $item->url;?>"><?php echo $item->title;?></a></li>
					<?php			
					 	}
					 ?>
                </ul>
            </div></div>
        </div>
    </div>
</div><!-- end header -->

<div id="<?php echo $showRightColumn ? 'contentarea2' : 'contentarea'; ?>" class="wp">
    <?php if ($navposition=='center' and $showleft) : ?>
    <div class="left <?php if ($showRightColumn==NULL){ echo 'leftbigger';} ?>" id="nav" >
        <jdoc:include type="modules" name="position-7"  style="beezDivision" headerLevel="3" />
        <jdoc:include type="modules" name="position-4" style="beezHide" headerLevel="3" state="0 " />
        <jdoc:include type="modules" name="position-5" style="beezTabs" headerLevel="2"  id="3" />
    </div><!-- end navi -->
   <?php endif; ?>

    <?php if ($navposition=='left' and $showleft) : ?>
        <div class="left1 <?php if ($showRightColumn==NULL){ echo 'leftbigger';} ?>" id="nav">
            <jdoc:include type="modules" name="position-7" style="beezDivision" headerLevel="3" />
            <jdoc:include type="modules" name="position-4" style="beezHide" headerLevel="3" state="0 " />
            <jdoc:include type="modules" name="position-5" style="beezTabs" headerLevel="2"  id="3" />
        </div><!-- end navi -->
    <?php endif; ?>

    <div id="<?php echo isset($showno) ? 'wrapper' : 'wrapper2'; ?>">
        <?php if ($menu->getActive() !== $menu->getDefault()) : ?>
            <div id="breadcrumbs"><jdoc:include type="modules" name="position-2" /></div>
        <?php endif; ?>
        <div id="main">
            <?php if ($this->countModules('position-12')): ?>
                <div id="top"><jdoc:include type="modules" name="position-12" /></div>
            <?php endif; ?>

            <jdoc:include type="message" />
            <jdoc:include type="component" />
        </div><!-- end main -->
    </div><!-- end wrapper -->

    <?php if ($showRightColumn) : ?>
    <h2 class="unseen">
        <?php echo JText::_('TPL_BEEZ2_ADDITIONAL_INFORMATION'); ?>
    </h2>
    <div id="close">
        <a href="#" onclick="auf('right')"><span id="bild"><?php echo JText::_('TPL_BEEZ2_TEXTRIGHTCLOSE'); ?></span></a>
    </div>
    <div id="right">
        <a id="additional"></a>
        <jdoc:include type="modules" name="position-6" style="beezDivision" headerLevel="3"/>
        <jdoc:include type="modules" name="position-8" style="beezDivision" headerLevel="3"  />
        <jdoc:include type="modules" name="position-3" style="beezDivision" headerLevel="3"  />
    </div><!-- end right -->
    <?php endif; ?>


</div><!-- end contentarea -->

<div id="footer" class="wp">
    <div class="links"><a href="#">关于我们</a> | <a href="#">联系方式</a> | <a href="#">后台登录</a></div>
    <div class="copyright">浙ICP备11026016-3 版权所有：盐城市电子信息职业教育联盟</div>
</div>

<jdoc:include type="modules" name="debug" />

</body>
</html>