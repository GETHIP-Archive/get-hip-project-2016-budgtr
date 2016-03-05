$(document).ready(function () {
    $.ajax({
        method: "GET",
        dateType: "json",
        url: "http://budgtr.nyc2.do.waldstein.io/rest/transactions?userId=4"
    }).done(function (data) {
        console.log(data);
        var response = JSON.parse(JSON.stringify(data));
        console.log(response);
        $("#transactionsTableBody").empty();
        $.each(response, function (id, transaction) {
            //noinspection JSUnresolvedVariable
            $("#transactionsTableBody").append(
                "<tr><td>" + transaction.date +
                "</td><td>" + transaction.payee +
                "</td><td>" + transaction.category +
                "</td><td>" + transaction.description +
                "</td><td>" + '$' + transaction.dollars + '.' + transaction.cents +
                "</td></tr>");
        });

        $("#createTransactionSubmitBtn").on("click", function(){
            var formData = $("#createTransactionForm").serialize(); // your form's data
            $.ajax({
                    type: "POST",
                    url: "http://budgtr.nyc2.do.waldstein.io/rest/transactions",
                    data: formData //sends the data to the new page.
                })
                .done(function( msg ) {
                    window.location.href = 'dashboard.html' // redirects the page when finished.
                });
        });


    });

    /*
     $("#dialog").dialog({
     autoOpen: false,
     modal: true,
     show: {
     effect: "blind",
     duration: 1000
     },
     hide: {
     effect: "explode",
     duration: 1000
     }
     });
     $("#transaction").click(function () {
     console.log("Transaction Click");
     $("#dialog").dialog("open");
     });
     */
});