 <!-- jQuery  -->
        <script src="resource/vertical/assets/js/jquery.min.js"></script>
        <script src="resource/vertical/assets/js/popper.min.js"></script>
        <script src="resource/vertical/assets/js/bootstrap.min.js"></script>
        <script src="resource/vertical/assets/js/metisMenu.min.js"></script>
        <script src="resource/vertical/assets/js/waves.js"></script>
        <script src="resource/vertical/assets/js/jquery.slimscroll.js"></script>

        <!-- Flot chart -->
        <script src="resource/plugins/flot-chart/jquery.flot.min.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.time.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.tooltip.min.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.resize.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.pie.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.crosshair.js"></script>
        <script src="resource/plugins/flot-chart/curvedLines.js"></script>
        <script src="resource/plugins/flot-chart/jquery.flot.axislabels.js"></script>

        <!-- KNOB JS -->
        <!--[if IE]>
        <script type="text/javascript" src="resource/plugins/jquery-knob/excanvas.js"></script>
        <![endif]-->
        <script src="resource/plugins/jquery-knob/jquery.knob.js"></script>

        <!-- Dashboard Init -->
        <script src="resource/vertical/assets/pages/jquery.dashboard.init.js"></script>

        <!-- App js -->
        <script src="resource/vertical/assets/js/jquery.core.js"></script>
        <script src="resource/vertical/assets/js/jquery.app.js"></script>
        
        
        
        
        
        <script src="resource/plugins/switchery/switchery.min.js"></script>
        <script src="resource/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
        <script src="resource/plugins/select2/js/select2.min.js" type="text/javascript"></script>
        <script src="resource/plugins/bootstrap-select/js/bootstrap-select.js" type="text/javascript"></script>
        <script src="resource/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
        <script src="resource/plugins/bootstrap-maxlength/bootstrap-maxlength.js" type="text/javascript"></script>

        <script type="text/javascript" src="resource/plugins/autocomplete/jquery.mockjax.js"></script>
        <script type="text/javascript" src="resource/plugins/autocomplete/jquery.autocomplete.min.js"></script>
        <script type="text/javascript" src="resource/plugins/autocomplete/countries.js"></script>
        <script type="text/javascript" src="resource/vertical/assets/pages/jquery.autocomplete.init.js"></script>

        <!-- Init Js file -->
        <script type="text/javascript" src="resource/vertical/assets/pages/jquery.form-advanced.init.js"></script>
		
		
		<!-- Sweet Alert Js  -->
        <script src="resource/plugins/sweet-alert/sweetalert2.min.js"></script>
        <script src="resource/horizontal/assets/pages/jquery.sweet-alert.init.js"></script>
	
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script type="text/javascript" src="resource/admin_script.js"></script>
        
        
         <!-- Required datatable js -->
        <script src="resource/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="resource/plugins/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="resource/plugins/datatables/dataTables.buttons.min.js"></script>
        <script src="resource/plugins/datatables/buttons.bootstrap4.min.js"></script>
        <script src="resource/plugins/datatables/jszip.min.js"></script>
        <script src="resource/plugins/datatables/pdfmake.min.js"></script>
        <script src="resource/plugins/datatables/vfs_fonts.js"></script>
        <script src="resource/plugins/datatables/buttons.html5.min.js"></script>
        <script src="resource/plugins/datatables/buttons.print.min.js"></script>

        <!-- Key Tables -->
        <script src="resource/plugins/datatables/dataTables.keyTable.min.js"></script>

        <!-- Responsive examples -->
        <script src="resource/plugins/datatables/dataTables.responsive.min.js"></script>
        <script src="resource/plugins/datatables/responsive.bootstrap4.min.js"></script>

        <!-- Selection table -->
        <script src="resource/plugins/datatables/dataTables.select.min.js"></script>

        
        
        
        
        <script type="text/javascript">
            $(document).ready(function() {

                // Default Datatable
                $('#datatable').DataTable();

                //Buttons examples
                var table = $('#datatable-buttons').DataTable({
                    lengthChange: false,
                    buttons: ['copy', 'excel', 'pdf']
                });

                // Key Tables

                $('#key-table').DataTable({
                    keys: true
                });

                // Responsive Datatable
                $('#responsive-datatable').DataTable();

                // Multi Selection Datatable
                $('#selection-datatable').DataTable({
                    select: {
                        style: 'multi'
                    }
                });

                table.buttons().container()
                        .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
            } );

        </script>
        
        