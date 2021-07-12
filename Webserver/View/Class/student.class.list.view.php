<?php if(!defined('__CONTROLLER__')) return; ?>
<?php getTemplate("header", $viewParams); ?>
<body id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">
    <?php getTemplate($viewParams['sidebar'], $viewParams); ?>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
        <?php getTemplate("topbar", $viewParams); ?>
        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Content Row -->
          <div class="row">
            <div class="col-md-3">
              <button class="btn btn-success btn-block" style="margin-bottom: 20px;" data-toggle="modal" data-target="#addClassModal">
                <i class="fas fa-plus"></i> Join a class
              </button>
            </div>
            <div class="col-md-9"></div>
            <div class="col-md-9">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th width="10%">No.</th>
                    <th width="30%">Name</th>
                    <th width="20%">Class ID</th>
                    <th width="40%">Timetable</th>
                  </tr>
                </thead>
                <tbody id="classlist_body">
                  
                </tbody>
              </table>
              <?php getModal("class.join")?>
            </div>
            <script>loadClassList();</script>
          </div>
          <?php getTemplate("message", $viewParams); ?>  
        </div>
      </div>
      <!-- End of Main Content -->
<?php getTemplate("footer", $viewParams) ?>