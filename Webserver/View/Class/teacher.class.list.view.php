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
                <i class="fas fa-plus"></i> Add new class
              </button>
            </div>
            <div class="col-md-9"></div>

            <div class="col-md-9">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th width="25%">Class ID</th>
                    <th width="30%">Name</th>
                    <th width="30%">Timetable</th>
                    <th width="15%"></th>
                  </tr>
                </thead>
                <tbody id="classlist_body">
                  
                </tbody>
              </table>
            </div>
            <div class="col-md-3"></div>
            <script type="text/javascript"> teacherLoadClassList(); </script>
            <?php getModal("class.add"); ?>
            <?php getModal("class.update"); ?>
          </div>
          <?php getTemplate("message", $viewParams); ?>  
        </div>
      </div>
      <!-- End of Main Content -->
<?php getTemplate("footer", $viewParams) ?>