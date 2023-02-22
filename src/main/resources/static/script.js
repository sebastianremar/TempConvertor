document.getElementsByName("temp")[0].addEventListener('keypress', () => {

    // Getting values with QuerySelector
    const leftTemp = document.getElementById('leftValue').value;
    const rightTemp = document.getElementById('rightValue').value;

    // Getting temperature units
    const leftUnit = document.getElementById("tempLeft");
    const leftText = leftUnit.options[leftUnit.selectedIndex].text;

    // Getting temperature units
    const rightUnit = document.getElementById("tempRight");
    const rightText = rightUnit.options[rightUnit.selectedIndex].text;

   const data = {
        value : leftTemp,
        currentUnit : leftText,
        unitToChange : rightText
   }

    console.log(data);

    $.ajax('tmp', {
        type: "POST",
        contentType : 'application/json; charset=utf-8;',
        data: JSON.stringify(data),
        success: (res) => {
            const {temp, tempUnit} = res;
            document.getElementById("rightValue").value = temp;

        },
        error: err => {
            console.log(err);
        }
   });
})

