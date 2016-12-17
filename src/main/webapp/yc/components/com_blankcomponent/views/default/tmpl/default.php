<?php

// no direct access
defined('_JEXEC') or die;
$db = JFactory::getDbo();
//行业资讯--精选
$sql = "select id,title,alias,catid, created,images from yc_content where catid in(85) and state = 1 and featured=1  order by created DESC limit 0,4";
$db->setQuery($sql);
$items = $db->loadObjectList();
$hyzx = array();
foreach($items as $key=> $item){
	$itemId=475;
	$obj = new stdClass();
	if(!empty($item->images)){
		$images = json_decode($item->images);
		$obj->img = htmlspecialchars($images->image_intro);
	}
	$obj->title = $item->title;
	//$obj->introtext = JString::substr($item->introtext,3,46);
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$hyzx[] = $obj;
	
	
}
//联盟动态
$sql = "select id,title,alias,catid, created from yc_content where catid in(84) and state = 1  order by created DESC limit 0,8";
$db->setQuery($sql);
$items = $db->loadObjectList();
$xwdt = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 474;
// 	if($item->catid == 85){
// 		$itemId = 475;
// 	}
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$xwdt[] = $obj;
}
//成员单位
$sql = "select id,title,alias,catid, created from yc_content where catid in(86,87) and state = 1  order by created DESC limit 0,5";
$db->setQuery($sql);
$items = $db->loadObjectList();
$cydw = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 476;//学校成员
	if($item->catid == 87){
		$itemId = 477;//企业成员
	}
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$cydw[] = $obj;
}
//政策法规
$sql = "select id,title,alias,catid, created from yc_content where catid in(92,93) and state = 1  order by created DESC limit 0,7";
$db->setQuery($sql);
$items = $db->loadObjectList();
$zcfg = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 482;//国家政策
	if($item->catid == 93){
		$itemId = 483;//联盟制度
	}
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$zcfg[] = $obj;
}
//人才需求
$sql = "select id,title,alias,catid, created from yc_content where catid in(89) and state = 1  order by created DESC limit 0,7";
$db->setQuery($sql);
$items = $db->loadObjectList();
$rcxq = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 479;//人才需求
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$rcxq[] = $obj;
}
//图片新闻 
$sql = "select id,title,alias,catid, introtext,created,images from yc_content where catid in(98) and state = 1   order by created DESC limit 0,9";

$db->setQuery($sql);
$items = $db->loadObjectList();
$tpxw = array();
foreach($items as $key=> $item){
	$itemId = 495;
// 	if($item->catid == 85){
// 		$itemId = 475;
// 	}
	$obj = new stdClass();
	if(!empty($item->images)){
		$images = json_decode($item->images);
		$obj->img = htmlspecialchars($images->image_intro);
	}
	$obj->title = $item->title;
	//$obj->introtext = JString::substr($item->introtext,3,46);
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$tpxw[] = $obj;
}
//品牌专业
$sql = "select id,title,alias,catid, created from yc_content where catid in(96) and state = 1  order by created DESC limit 0,5";
$db->setQuery($sql);
$items = $db->loadObjectList();
$ppzy = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 492;//品牌专业
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$ppzy[] = $obj;
}
//校企合作
$sql = "select id,title,alias,catid, created from yc_content where catid in(88) and state = 1  order by created DESC limit 0,5";
$db->setQuery($sql);
$items = $db->loadObjectList();
$xqhz = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 478;//校企合作
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$xqhz[] = $obj;
}
//综合服务
$sql = "select id,title,alias,catid, created from yc_content where catid in(94) and state = 1  order by created DESC limit 0,5";
$db->setQuery($sql);
$items = $db->loadObjectList();
$zhfw = array();
foreach($items as $key=> $item){
	$obj = new stdClass();
	$obj->title = $item->title;
	$obj->date = JHtml::_('date', $item->created, JText::_('DATE_FORMAT_LC4'));
	$itemId = 490;//综合服务
	$obj->url = JRoute::_("index.php?option=com_content&view=article&id=".$item->id.":".$item->alias."&catid=".$item->catid."&Itemid=".$itemId);
	$zhfw[] = $obj;
}
?>
		<div class="home-row">
			<div class="home-col home-col-h">
				<div class="mod mod-h">
					<div class="spotlight">
						<div class="slides">
							<!-- 484x320  -->
							<!-- <div class="slide active">
								<img src="http://temp.im/484x320" class="pic">
								<div class="text"><p>全国职业教育集团化办学工作专家111组工作会议全国职业教育集团化办学工作专家组工作会议</p></div>
							</div>
							<div class="slide">
								<img src="http://temp.im/484x320/ff9500" class="pic">
								<div class="text"><p>全国职业教育集团化办学222工作专家组工作会议全国职业教育集团化办学工作专家组工作会议</p></div>
							</div>
							<div class="slide">
								<img src="http://temp.im/484x320/007aff" class="pic">
								<div class="text"><p>全国职业教育集团化办学工作专家组工作会议333全国职业教育集团化办学工作专家组工作会议</p></div>
							</div> -->
							<?php 
								$i = 0;
								foreach ($hyzx as $item ){
							?>
							<div class="slide <?php if($i==0){echo 'active';}?>">
								<img src="<?php echo $item->img;?>" class="pic">
								<div class="text"><p><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></p></div>
							</div>
							<?php	
									$i++;
							 	}
							 ?>
						</div>
						<div class="dots">
							<span class="active"></span><span></span><span></span>
						</div>
					</div>
				</div>
			</div>
			<div class="home-col home-col-h home-col-last">
				<div class="mod mod-h mod-xwdt">
					<div class="mod-hd">
						<h2 class="mod-title">联盟动态</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=84&Itemid=474");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($xwdt as $item ){
							?>
							<li><span class="date"><?php echo $item->date;?></span><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col home-col-s">
				<div class="mod mod-s mod-lmjj">
					<div class="mod-hd">
						<h2 class="mod-title">联盟简介</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=article&id=74&Itemid=469");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<p>全国职业教育集团化办学工作专家组工作会议全国职业教育集团化办学工作专家组工作会议全国职业教育集团化办学工作专家组工作会议全国职业教育集团化办学工作专家组工作会议全国职业教育集团化办学工作专家组工作会议职业…</p>
					</div>
				</div>
			</div>
			<div class="home-col home-col-m">
				<div class="home-banner home-banner-1"><img src="templates/beez_20/img/banner1.jpg" alt=""></div>
				<div class="mod mod-m mod-cydw">
					<div class="mod-hd">
						<h2 class="mod-title">成员单位</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=86&Itemid=476");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($cydw as $item ){
							?>
							<li><span class="date"><?php echo $item->date;?></span><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
			<div class="home-col home-col-s home-col-last">
				<div class="mod mod-s mod-zcfg">
					<div class="mod-hd">
						<h2 class="mod-title">政策法规</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=92&Itemid=482");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($zcfg as $item ){
							?>
							<li><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col home-col-s">
				<div class="mod mod-s mod-mssq">
					<a href="#" class="video"><img src="templates/beez_20/img/video.jpg" alt=""></a>
					<a href="#" class="title">名师视频教学</a>
				</div>
			</div>
			<div class="home-col home-col-m">
				<div class="mod mod-m mod-rcxq">
					<div class="mod-hd">
						<h2 class="mod-title">人才需求</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=89&Itemid=479");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($rcxq as $item ){
							?>
							<li><span class="date"><?php echo $item->date;?></span><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
			<div class="home-col home-col-s home-col-last">
				<div class="mod mod-s mod-btnlinks">
					<div class="mod-bd">
						<a href="#" class="lbtn">联盟大事记</a>
						<a href="#" class="lbtn">职业教育政策</a>
						<a href="#" class="lbtn">校企合作政策</a>
						<a href="#" class="lbtn">招生就业政策</a>
					</div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col home-col-l home-col-last">
				<div class="home-banner home-banner-2">
					<!-- 980x157 -->
					<div class="banner"><img src="templates/beez_20/img/banner2.jpg" alt=""></div>
					<div class="banner"><img src="http://temp.im/980x157/" alt=""></div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col home-col-l home-col-last">
				<div class="mod mod-l mod-tpxw">
					<div class="mod-hd">
						<h2 class="mod-title">图片新闻</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=98&Itemid=495");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<div class="picnews">
							<!-- 190x130 -->
							<ul>
								<!-- <li><a class="pic" href="#"><img src="http://temp.im/190x130/" /></a><a href="#" class="title">全国职1业教育集团化办学工作专家组工作会议</a></li>
								<li><a class="pic" href="#"><img src="http://temp.im/190x130/" /></a><a href="#" class="title">全国职2业教育集团化办学工作专家组工作会议</a></li>
								<li><a class="pic" href="#"><img src="http://temp.im/190x130/" /></a><a href="#" class="title">全国职3业教育集团化办学工作专家组工作会议</a></li>
								<li><a class="pic" href="#"><img src="http://temp.im/190x130/" /></a><a href="#" class="title">全国职4业教育集团化办学工作专家组工作会议</a></li>
								<li><a class="pic" href="#"><img src="http://temp.im/190x130/" /></a><a href="#" class="title">全国职5业教育集团化办学工作专家组工作会议</a></li> -->
								<?php 
									foreach ($tpxw as $item ){
								?>
								<li><a class="pic" href="<?php echo $item->url;?>"><img src="<?php echo $item->img;?>" /></a><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
								<?php			
								 	}
								 ?>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col home-col-s">
				<div class="mod mod-s mod-ppzy">
					<div class="mod-hd">
						<h2 class="mod-title">品牌专业</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=96&Itemid=492");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($ppzy as $item ){
							?>
							<li><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="home-col home-col-m">
				<div class="mod mod-m mod-xqhz">
					<div class="mod-hd">
						<h2 class="mod-title">校企合作</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=88&Itemid=478");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><span class="date">2016-10-11</span><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($xqhz as $item ){
							?>
							<li><span class="date"><?php echo $item->date;?></span><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
			<div class="home-col home-col-s home-col-last">
				<div class="mod mod-s mod-zhfw">
					<div class="mod-hd">
						<h2 class="mod-title">综合服务</h2>
						<a href="<?php echo JRoute::_("index.php?option=com_content&view=category&id=94&Itemid=490");?>" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul class="list">
							<!-- <li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li>
							<li><a href="#" class="title">全国职业教育集团化办学工作专家组工作会议</a></li> -->
							<?php 
								foreach ($zhfw as $item ){
							?>
							<li><a href="<?php echo $item->url;?>" class="title"><?php echo $item->title;?></a></li>
							<?php			
							 	}
							 ?>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="home-row">
			<div class="home-col mod-l home-col-l home-col-last">
				<div class="mod mod-yqlj">
					<div class="mod-hd">
						<h2 class="mod-title">友情链接</h2>
						<a href="#" style="display: none" class="more-link">更多</a>
					</div>
					<div class="mod-bd">
						<ul>
							<li><a href="http://www.moe.gov.cn" target="_blank"><img src="templates/beez_20/img/link_1.jpg" /></a></li>
							<li><a href="http://www.cvae.com.cn/zgzcw" target="_blank"><img src="templates/beez_20/img/link_2.jpg" /></a></li>
							<li><a href="http://www.jsve.edu.cn/" target="_blank"><img src="templates/beez_20/img/link_3.jpg" /></a></li>
							<li><a href="http://www.yce.cn/" target="_blank"><img src="templates/beez_20/img/link_4.jpg" /></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>