$('#checkbox-value').text($('#halfDayVacation').val());

$("#halfDayVacation").on('change', function() {
    if ($(this).is(':checked')) {
        $(this).attr('value', 'true');
    } else {
        $(this).attr('value', 'false');
    }

    $('#checkbox-value').text($('#halfDayVacation').val());
});