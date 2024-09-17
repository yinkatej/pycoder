

$(() => {
  
  const checkResult = ``;
  const upload = ``;
  const tasks = {
    checkResult,
    upload,
  };

  $(".one").hide();$(".two").hide()

  $("#check-result").on("click", () => {
    console.log($("#check-value").val())
    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "http://localhost:8080/admin/student",
      data: JSON.stringify({ matric: `${$("#check-value").val()}` }),
      success: (data) => {
        const { matric, surname, firstName, otherName, email, scores } = data;
        console.log(data);
        $(".table").append(`
          <tr>
            <td>${matric}</td>
            <td>${surname}</td>
            <td>${firstName}</td>
            <td>${otherName}</td>
            
            <td>${[...scores].reduce((a, b) => a + b, 0)}</td>
          </tr>
          `);
      },
      dataType: "json",
      error: (error) => {
        console.log(error)
      }
    });
    $("#check-value").val("");
  });
  $("#checker").on("click", () => {
    $(".two").hide()
    $(".one").show()
  });
  $("#upload-student").on("click", () => {
    $(".two").show()
    $(".one").hide()
  });
  $("#upload").on("click", () => {
    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "http://localhost:8080/add-student",
      data: JSON.stringify({
        matric: $("#matric").val().toUpperCase().trim(),
        surname: $("#surname").val().trim(),
        firstName: $("#fname").val().trim(),
        otherName: $("#oname").val().trim(),
        email: $("#email").val().toLowerCase().trim(),
      }),
      dataType: "json",
      success: (data) => {
        console.log(data);
        alert("Student Added Successfully");
        
      },
      error: (error) => {
        console.log(error)
      }
    });
  });
});
