<?php if(!defined('__CONTROLLER__')) return; ?>
<?php getTemplate("header", $viewParams); ?>
<body id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">
    <?php getTemplate("sidebar", $viewParams); ?>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
        <?php getTemplate("topbar", $viewParams); ?>
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Content Row -->
          <div class="row">
            <div class="col-12 row">
                <div class="col-5">
                <?php if(isset($_GET['search'])) $search = $_GET['search']; else $search = ""; ?>
                    <input id="search-text" class="form-control" style="width: 100%" value="<?php echo $search ?>">
                </div>
                <div class="col-3">
                    <button id="search-btn" class="btn btn-primary" onclick="search()">Tìm kiếm</button>
                </div>
            </div>
            <div class="col-12" style="margin-top: 20px;">
                <table class="table striped">
                    <thead>
                        <tr>
                            <th width="5%">Mã TB</th>
                            <th width="15%">Tên TB</th>
                            <th width="10%">Tình trạng</th>
                            <th width="10%">Nhà sản xuất</th>
                            <th width="10%">Nhà cung cấp</th>
                            <th width="20%">Chức năng</th>
                            <th width="10%">Giá tiền</th>
                            <th style="text-align: center;" width="10%">Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                    <?php
                    foreach($viewParams['equipment_list'] as $eq){ ?>    
                        <tr>
                            <td><?php echo $eq['id'] ?></td>
                            <td>
                                <a href="#" data-toggle="modal" data-target="#historyModal" onclick="loadHistory('<?php echo $eq['id'] ?>')"><?php echo $eq['name'] ?></a>
                            </td>
                            <td><?php echo $eq['status'] ?></td>
                            <td><?php echo $eq['producer'] ?></td>
                            <td><?php echo $eq['provider'] ?></td>
                            <td><?php echo $eq['function'] ?></td>
                            <td align="left"><?php echo $eq['price']." VND" ?></td>
                            <td align="center"><?php echo $eq['number'] ?></td>
                        </tr>
                    <?php
                    }   ?>
                    </tbody>
                </table>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Main Content -->
      <?php getModal("history") ?>
<?php getTemplate("footer", $viewParams) ?>