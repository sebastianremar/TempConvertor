document.getElementsByName("temp")[0].addEventListener('keyup', () => {

    // Getting values with QuerySelector
    const leftTemp = document.getElementById('leftValue').value;
    const rightTemp = Number(document.getElementById('rightValue').value);

    // Getting temperature units
    const leftUnit = document.getElementById("tempLeft");
    const leftText = leftUnit.options[leftUnit.selectedIndex].text;

    // Getting temperature units
    const rightUnit = document.getElementById("tempRight");
    const rightText = rightUnit.options[rightUnit.selectedIndex].text;

    // CASO #1 INPUT ESTA VACIO
    if (!leftTemp) {
    //  Asumamos que estamos en un estado en el que el usuario tiene en blanco el input
        document.getElementById("rightValue").value = "";
        return;
    }

    const leftTempNumber = Number(leftTemp);

    // CASO #2 El input es una letra
    if (isNaN(leftTempNumber)) {
        console.log("Input es una letra")
        document.getElementById("rightValue").value = "";
        return;
    }

   const data = {
        value : leftTemp,
        currentUnit : leftText,
        unitToChange : rightText
   }

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

