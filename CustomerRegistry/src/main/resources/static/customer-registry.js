$(document).ready(function() {

    $("#attempt-form").submit(function( event ) {

        event.preventDefault();

        // Get some values from elements on the page
        var firstName = $('.first_name').text();
        var username = $('.username').text();
        var password = $('.password').text();

        // Compose the data in the format that the API is expecting
        var data = {
            username:username,
            firstName:firstName,
            password:password
        };

        // Send the data using post
        $.ajax({
            url: '/api/customer/creation/create',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(result){
               alert("Customer Created!");
            }
        });

    });
});
