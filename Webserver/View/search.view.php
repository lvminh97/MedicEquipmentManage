<?php if(!defined('__CONTROLLER__')) return; ?>
<?php getTemplate("header", $viewParams); ?>			
<div class="full-width-container pt-90 pb-100">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div>
                <div onclick="toggleDisplay('product-search-list')" class="search-category">
                    Sản phẩm (<?php echo count($viewParams["productList"]) ?>)
                </div>
                <div id="product-search-list" style="display: none;">
                <?php
                foreach($viewParams["productList"] as $product) { ?>
                    <div class="row search-item">
                        <div class="col-md-3" style="padding-left: 50px;">
                            <?php $img = explode(";", $product["image"])[0] ?>
                            <a href="?link=chitietsanpham&product_id=<?php echo $product["product_id"] ?>">
                            <img style="width: auto; height: 150px;" src="Resource/Images/<?php echo $img ?>"></a>
                        </div>
                        <div class="col-md-6 search-item-name">
                            <a href="?link=chitietsanpham&product_id=<?php echo $product["product_id"] ?>">
                            <?php echo $product["name"] ?>
                            </a>
                        </div>
                    </div>
                <?php
                } ?>
                </div>
            </div>
            <hr>
            <div>
                <div onclick="toggleDisplay('disease-search-list')" class="search-category">
                    Thông tin bệnh (<?php echo count($viewParams["diseaseList"]) ?>)
                </div>
                <div id="disease-search-list" style="display: none;">
                <?php
                foreach($viewParams["diseaseList"] as $disease){ ?>
                    <div class="row search-item">
                        <div class="col-md-3" style="padding-left: 50px;">
                            <a href="?link=thongtinbenh&postid=<?php echo $disease["disease_id"] ?>">
                            <img style="width: 150px; height: 150px;" src="assets/images/icon/disease.jpg">
                        </div>
                        <div class="col-md-6 search-item-name">
                            <a href="?link=thongtinbenh&postid=<?php echo $disease["disease_id"] ?>">
                            <?php echo $disease["name"] ?>
                            </a>
                        </div>
                    </div>
                <?php 
                } ?>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<?php getTemplate("footer", $viewParams) ?>			