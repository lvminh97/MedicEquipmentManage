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
            <div class="container">
              <ul class="nav nav-tabs">
                <li id="studentTab" class="active" onclick="tabToggle(this)"><a data-toggle="tab" href="#student_manage" aria-expanded="true">Student</a></li>
                <li id="assignmentTab" class="" onclick="tabToggle(this)"><a data-toggle="tab" href="#assignment_manage" aria-expanded="false">Assignment</a></li>
              </ul>
              <div class="tab-content" style="margin-top: 30px;">
                <div id="student_manage" class="tab-pane fade in active show">
                  <h3><?php echo "The students of \"".$viewParams['classname']."\""; ?></h3>
                  <span style="display: none"><?php echo $viewParams['teacher']['account_id'] ?></span>
                  Teacher: <a href="#" onclick="messageFormOpen(this.previousElementSibling.innerHTML); return false;"><?php echo $viewParams['teacher']['fullname']; ?></a>
                  <div style="height: 25px;"></div>
                  <div class="row">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <td width="10%">No.</td>
                          <td>Student's name</td>
                          <td></td>
                        </tr>			
                      </thead>
                      <tbody id="student_list_body">
                      <script>studentLoadStudentList();</script>	
                      </tbody>
                    </table>
                    <?php getModal("teacher.submission.view") ?>
                  </div>
                </div>
                <div id="assignment_manage" class="tab-pane fade">
                  <div class="row">
                    <div class="col-md-9">
                    <h3><?php echo "The assignments of \"".$viewParams['classname']."\""; ?></h3>
                    <span style="display: none"><?php echo $viewParams['teacher']['account_id'] ?></span>
                    Teacher: <a href="#" onclick="messageFormOpen(this.previousElementSibling.innerHTML); return false;"><?php echo $viewParams['teacher']['fullname']; ?></a>
                    <div style="height: 25px;"></div>
                    </div>
                    <div class="col-md-3"></div>
                  </div>
                  <div class="row">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <td width="10%">No.</td>
                          <td width="30%">Title</td>
                          <td width="40%">Content</td>
                          <td width="20%">Status</td>
                        </tr>			
                      </thead>
                      <tbody id="assignment_list_body">
                      <script>studentLoadAssignmentList();</script>	
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>

          </div>
          <?php getTemplate("message", $viewParams); ?>  
        </div>
      </div>
      <!-- End of Main Content -->
<?php getTemplate("footer", $viewParams) ?>