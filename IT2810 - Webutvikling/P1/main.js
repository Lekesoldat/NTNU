// Handle documentation display
$("#documentationButton").click(() => {
  $("#documentationContent").slideToggle("fast", () => {
    if ($("#documentationContent").is(":hidden")) {
      $("#documentationButton").text("DISPLAY DOCUMENTATION");
    } else {
      $("#documentationButton").text("HIDE DOCUMENTATION");
    }
  });
});
